package jpabook.start.pr4

import javax.persistence.*

@Entity
@Table(name = "member")
class Member(
    @Id
    @Column(name = "member_id")
    var id: String,

    var username: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var team: Team?,
)