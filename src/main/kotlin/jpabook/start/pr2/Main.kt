package jpabook.start.pr2

import javax.persistence.EntityManager
import javax.persistence.Persistence

fun save(em: EntityManager) {
    val team1 = Team("team1", "팀1")
    em.persist(team1)
    val member1 = Member("member1", "회원1", team1)
    em.persist(member1)
    val member2 = Member("member2", "회원2", team1)
    em.persist(member2)
}

fun queryLogicLoading(em: EntityManager) {
    val jpql = "select m from Member m join m.team t where t.name=:teamName"
    val resultList = em.createQuery(jpql, Member::class.java)
        .setParameter("teamName", "팀1")
        .resultList

    resultList.forEach {
        println("[query] member.username=${it.username}")
    }
}

fun updateRelation(em: EntityManager) {
    val team2 = Team("team2", "팀2")
    em.persist(team2)

    val member = em.find(Member::class.java, "member1")
    member.team = team2
}

fun deleteRelation(em: EntityManager) {
    val member = em.find(Member::class.java, "member1")
    member.team = null
}

fun biDirection(em: EntityManager) {
    val team = em.find(Team::class.java, "team1")
    val members = team.members

    members.forEach {
        println("member.username = ${it.username}")
    }
}

fun main() {
    val emf = Persistence.createEntityManagerFactory("jpabook")
    var em = emf.createEntityManager()
    var tx = em.transaction

    try {
        tx.begin()

        biDirection(em)

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
