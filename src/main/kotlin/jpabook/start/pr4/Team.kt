package jpabook.start.pr4

import org.hibernate.annotations.AttributeAccessor
import javax.persistence.*

@Entity
@Table(name = "team")
class Team(
    @get:Id
    @get:Column(name = "team_id")
    val id: String,

    val name: String,

    @get:OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    val members: MutableList<Member> = mutableListOf()
)