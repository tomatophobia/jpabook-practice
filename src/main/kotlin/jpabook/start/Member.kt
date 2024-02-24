package jpabook.start

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "member")
class Member {

    @Id
    @Column(name = "id")
    var id: String? = null

    @Column(name = "name")
    var username: String? = null

    var age: Int? = null

    override fun toString(): String {
        return "Member(id=$id, username=$username, age=$age)"
    }
}
