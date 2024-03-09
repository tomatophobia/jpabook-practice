package jpabook.start.pr1

import javax.persistence.Persistence

fun main() {
    val emf = Persistence.createEntityManagerFactory("jpabook")
    var em = emf.createEntityManager()
    var tx = em.transaction

    val member = Member("abc", 13)

    try {
        tx.begin()

        em.persist(member)
        println(member.username)

        tx.commit()
    } catch (e: Exception) {
        e.printStackTrace()
        tx.rollback()
    } finally {
        em.clear()
    }
    em.close()

//    em = emf.createEntityManager()
//    tx = em.transaction
//    try {
//        tx.begin()
//
//        val member2 = em.find(Member::class.java, "id1")
//        println(member2.username)
//
//        tx.commit()
//    } catch (e: Exception) {
//        e.printStackTrace()
//        tx.rollback()
//    } finally {
//        em.clear()
//    }
//    em.close()


    emf.close()
}

