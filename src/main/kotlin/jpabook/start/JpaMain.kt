package jpabook.start

import javax.persistence.EntityManager
import javax.persistence.Persistence

fun main() {
    val emf = Persistence.createEntityManagerFactory("jpabook")
    val em = emf.createEntityManager();
    val tx = em.transaction
    try {
        tx.begin()
        logic(em)
        tx.commit()
    } catch (e: Exception) {
        e.printStackTrace()
        tx.rollback()
    } finally {
        em.clear()
    }
    emf.close()
}

fun logic(em: EntityManager) {
    val id = "id1"
    val member = Member()
    member.id = id
    member.username = "지한"
    member.age = 3

    em.persist(member)
    member.age = 20

    val findMember = em.find(Member::class.java, id)
    println(findMember)

    val members = em.createQuery("select m from Member m", Member::class.java).resultList
    println(members)

    em.remove(member)
}
