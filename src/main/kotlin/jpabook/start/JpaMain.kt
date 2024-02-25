package jpabook.start

import javax.persistence.EntityManager
import javax.persistence.Persistence

fun main() {
    val emf = Persistence.createEntityManagerFactory("jpabook")
    var em = emf.createEntityManager()
    var tx = em.transaction

    val member = Member()
    member.id = "id1"
    member.username = "abc"
    member.age = 13

    try {
        tx.begin()

        em.persist(member)

        tx.commit()
    } catch (e: Exception) {
        e.printStackTrace()
        tx.rollback()
    } finally {
        em.clear()
    }
    em.close()

    member.username = "cde"
    member.id = null

    em = emf.createEntityManager()
    tx = em.transaction
    try {
        tx.begin()

        val merged = em.merge(member)
        println(member.username)
        println(merged.username)
        println(merged == member)

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

fun logic(em: EntityManager) {
    val id = "id1"
    val member = Member()
    member.id = id
    member.username = "지한"
    member.age = 3

    em.persist(member)
    member.age = 20
    em.detach(member)

//    val findMember = em.find(Member::class.java, id)
//    println(member == findMember)

//    val members = em.createQuery("select m from Member m", Member::class.java).resultList
//    println(members)

//    em.remove(member)
}
