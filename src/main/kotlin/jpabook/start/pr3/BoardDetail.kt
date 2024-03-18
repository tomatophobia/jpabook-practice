package jpabook.start.pr3

import javax.persistence.*

@Entity
class BoardDetail {
    @Id
    @Column(name = "board_id")
    private var boardId: Long? = null

    @MapsId
    @OneToOne
    @JoinColumn(name = "board_id")
    lateinit var board: Board

    var content: String? = null
}