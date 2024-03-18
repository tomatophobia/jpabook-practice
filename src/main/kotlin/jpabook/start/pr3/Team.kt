package jpabook.start.pr3

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "team")
class Team(
    @Id
    @Column(name = "team_id")
    var id: String,

    var name: String,

    @OneToMany(mappedBy = "team")
//    @JoinColumn(name = "team_id")
    var members: MutableList<Member> = mutableListOf()
)