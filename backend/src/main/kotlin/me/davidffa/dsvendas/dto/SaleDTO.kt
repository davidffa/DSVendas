package me.davidffa.dsvendas.dto

import me.davidffa.dsvendas.entities.Sale
import java.time.LocalDate

data class SaleDTO(
  val id: Long,
  val visited: Int,
  val deals: Int,
  val amount: Double,
  val date: LocalDate,

  val seller: SellerDTO
) {
  constructor(entity: Sale)
          : this(entity.id, entity.visited, entity.deals, entity.amount, entity.date, SellerDTO(entity.seller))
}
