package jpabook.start

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "member")
class Member() {

    constructor(id: String, username: String, age: Int) : this() {
        this.id = id
        this.username = username
        this.age = age
    }

    @Id
    var id: String? = null

    @Column(name = "name")
    var username: String? = null

    var age: Int? = null

    override fun toString(): String {
        return "Member(id=$id, username=$username, age=$age)"
    }
}
