package me.davidffa.dsvendas.services

import me.davidffa.dsvendas.dto.SaleDTO
import me.davidffa.dsvendas.repositories.SaleRepository
import me.davidffa.dsvendas.repositories.SellerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SaleService(
  val repository: SaleRepository,
  val sellerRepository: SellerRepository
) {
  @Transactional(readOnly = true)
  fun findAll(pageable: Pageable): Page<SaleDTO> {
    sellerRepository.findAll()
    val result = repository.findAll(pageable)

    return result.map { SaleDTO(it) }
  }
}