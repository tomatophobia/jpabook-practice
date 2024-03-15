package jpabook.start.pr2

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
    var team: Team?
)