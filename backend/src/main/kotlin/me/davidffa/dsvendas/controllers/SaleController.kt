package me.davidffa.dsvendas.controllers

import me.davidffa.dsvendas.dto.SaleDTO
import me.davidffa.dsvendas.dto.SaleSuccessDTO
import me.davidffa.dsvendas.dto.SaleSumDTO
import me.davidffa.dsvendas.services.SaleService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/sales"])
class SaleController(
  private val service: SaleService
) {

  @GetMapping
  fun findAll(pageable: Pageable): ResponseEntity<Page<SaleDTO>> {
    val list = service.findAll(pageable)

    return ResponseEntity.ok(list)
  }

  @GetMapping(value = ["/amount-by-seller"])
  fun amountGroupedBySeller(): ResponseEntity<List<SaleSumDTO>> {
    val list = service.amountGroupedBySeller()

    return ResponseEntity.ok(list)
  }

  @GetMapping(value = ["/success-by-seller"])
  fun successGroupedBySeller(): ResponseEntity<List<SaleSuccessDTO>> {
    val list = service.successGroupedBySeller()

    return ResponseEntity.ok(list)
  }
}