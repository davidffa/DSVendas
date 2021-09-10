package me.davidffa.dsvendas.dto

import me.davidffa.dsvendas.entities.Seller

data class SaleSuccessDTO(
  val sellerName: String,
  val visited: Long,
  val deals: Long
) {
  constructor(seller: Seller, visited: Long, deals: Long) : this(seller.name, visited, deals)
}
