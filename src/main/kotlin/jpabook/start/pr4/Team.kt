package jpabook.start.pr4

import org.hibernate.annotations.AttributeAccessor
import javax.persistence.*

@Entity
@Table(name = "team")
//@Access(AccessType.FIELD)
class Team(
    @Id
    @Column(name = "team_id")
    val id: String,

    val name: String,

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    val members: MutableList<Member> = mutableListOf()
)