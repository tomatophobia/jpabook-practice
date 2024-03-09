package jpabook.start.pr1

import javax.persistence.*


@Entity
@Table(
    name = "member",
    uniqueConstraints = [
        UniqueConstraint( name = "NAME_AGE_UNIQUE", columnNames = ["name", "age"])
    ])
class Member() {

    constructor(username: String, age: Int) : this() {
        this.username = username
        this.age = age
    }

    constructor(id: Long, username: String, age: Int) : this() {
        this.id = id
        this.username = username
        this.age = age
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "name", nullable = false, length = 10)
    lateinit var username: String

    var age: Int? = null

    override fun toString(): String {
        return "Member(id=$id, username=$username, age=$age)"
    }
}
