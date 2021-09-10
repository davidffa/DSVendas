package me.davidffa.dsvendas.controllers

import me.davidffa.dsvendas.dto.SellerDTO
import me.davidffa.dsvendas.services.SellerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/sellers"])
class SellerController(
  private val service: SellerService
) {

  @GetMapping
  fun findAll(): ResponseEntity<List<SellerDTO>> {
    val list = service.findAll()

    return ResponseEntity.ok(list)
  }
}