package jpabook.start.pr2

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
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
    var members: MutableList<Member> = mutableListOf()
)