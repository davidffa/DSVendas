package me.davidffa.dsvendas.dto

import me.davidffa.dsvendas.entities.Seller

data class SaleSumDTO(
  val sellerName: String,
  val sum: Double
) {
  constructor(seller: Seller, sum: Double) : this(seller.name, sum)
}
