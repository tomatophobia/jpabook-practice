package jpabook.start.pr3

import javax.persistence.*

@Entity
@Table(name = "member")
class Member(
    @Id
    @Column(name = "member_id")
    var id: String,

    var username: String,

    @ManyToOne
    @JoinColumn(name = "team_id")
    var team: Team?,

    @OneToMany(mappedBy = "member")
    var orders: MutableList<Order> = mutableListOf()
)