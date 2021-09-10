package me.davidffa.dsvendas.dto

import me.davidffa.dsvendas.entities.Seller

data class SellerDTO(
  val id: Long,
  val name: String
) {
  constructor(entity: Seller) : this(entity.id, entity.name)
}