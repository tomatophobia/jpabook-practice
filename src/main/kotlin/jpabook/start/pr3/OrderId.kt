package jpabook.start.pr3

import java.io.Serializable

data class OrderId(
    var member: String,
    var product: String,
) : Serializable {
    constructor() : this("", "")
}