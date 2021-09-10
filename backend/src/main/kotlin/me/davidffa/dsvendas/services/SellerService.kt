package me.davidffa.dsvendas.services

import me.davidffa.dsvendas.dto.SellerDTO
import me.davidffa.dsvendas.repositories.SellerRepository
import org.springframework.stereotype.Service

@Service
class SellerService(
  val repository: SellerRepository
) {
  fun findAll(): List<SellerDTO> {
    val result = repository.findAll()

    return result.map { SellerDTO(it) }
  }
}