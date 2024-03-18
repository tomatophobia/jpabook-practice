package jpabook.start.pr3

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "product")
class Product(
    @Id
    @Column(name = "product_id")
    var id: String,

    var name: String,
)