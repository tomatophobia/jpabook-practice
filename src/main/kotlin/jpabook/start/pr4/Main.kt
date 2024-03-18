package jpabook.start.pr4

import org.hibernate.proxy.AbstractLazyInitializer
import javax.persistence.EntityManager
import javax.persistence.Persistence
import javax.persistence.PersistenceUnitUtil

fun save(em: EntityManager) {
    val team1 = Team("team1", "팀1")
    em.persist(team1)
    val team2 = Team("team2", "팀2")
    em.persist(team2)
    em.persist(Member("member1", "멤버1", team1))
    em.persist(Member("member2", "멤버2", team1))
    em.persist(Member("member3", "멤버3", team2))
}

fun logic(em: EntityManager, puu: PersistenceUnitUtil) {
    val member = em.find(Member::class.java, "member1")
    println(puu.isLoaded(member.team))
    println(member.team?.name)
    println(puu.isLoaded(member.team))
}

fun main() {
    val emf = Persistence.createEntityManagerFactory("jpabook")
    val persistenceUnitUtil = emf.persistenceUnitUtil
    var em = emf.createEntityManager()
    var tx = em.transaction

    try {
        tx.begin()

        logic(em, persistenceUnitUtil)

        tx.commit()
    } catch (e: Exception) {
        e.printStackTrace()
        tx.rollback()
    } finally {
        em.clear()
    }
    em.close()
    emf.close()
}
