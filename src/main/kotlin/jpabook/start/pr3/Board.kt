package jpabook.start.pr3

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Board {
    @Id
    @GeneratedValue
    @Column(name = "board_id")
    var id: Long? = null

    lateinit var title: String

    @OneToOne(mappedBy = "board")
    var boardDetail: BoardDetail? = null
}
