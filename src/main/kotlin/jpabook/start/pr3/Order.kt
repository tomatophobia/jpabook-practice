package jpabook.start.pr3

import javax.persistence.*

@Entity
@Table(name = "`order`")
//@IdClass(OrderId::class)
class Order(
    @ManyToOne
    @JoinColumn(name = "member_id")
    var member: Member,

    @ManyToOne
    @JoinColumn(name = "product_id")
    var product: Product,

    var amount: Int
) {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}