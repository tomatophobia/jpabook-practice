package jpabook.start.pr3

import javax.persistence.EntityManager
import javax.persistence.Persistence


fun save(em: EntityManager) {
    val team1 = Team("team1", "팀1")
    val member1 = Member("member1", "회원1", team1)
    val member2 = Member("member2", "회원2", team1)
    team1.members.addAll(listOf( member1, member2))

    em.persist(member1)
    em.persist(member2)
    em.persist(team1)
}

fun addMember(em: EntityManager) {
    val team1 = em.find(Team::class.java, "team1")
    val member3 = Member("member3", "회원3", team1)
    em.persist(member3)
    team1.members.add(member3)
}

fun changeTeam(em: EntityManager) {
    val team2 = Team("team2", "팀2")
    em.persist(team2)
    val member3 = em.find(Member::class.java, "member3")
    member3.team = team2
}

fun doubleMember(em: EntityManager) {
    val member1 = em.find(Member::class.java, "member1")
    val team1 = em.find(Team::class.java, "team1")
    val team2 = em.find(Team::class.java, "team2")
    team2.members.add(member1)
    member1.team = team1
}

fun saveMemberProduct(em: EntityManager) {
    val member1 = em.find(Member::class.java, "member1")
    val product1 = em.find(Product::class.java, "product1")

    val order1 = Order(member1, product1, 1)
    em.persist(order1)
}

fun findProducts(em:EntityManager) {
//    val member1 = em.find(Member::class.java, "member1")
//    println(member1.products.size)
}

fun main() {
    val emf = Persistence.createEntityManagerFactory("jpabook")
    var em = emf.createEntityManager()
    var tx = em.transaction

    try {
        tx.begin()

        saveMemberProduct(em)

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
