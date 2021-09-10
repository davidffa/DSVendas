package me.davidffa.dsvendas.repositories

import me.davidffa.dsvendas.dto.SaleSuccessDTO
import me.davidffa.dsvendas.dto.SaleSumDTO
import me.davidffa.dsvendas.entities.Sale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SaleRepository : JpaRepository<Sale, Long> {

  @Query("SELECT new me.davidffa.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " +
          "FROM Sale AS obj GROUP BY obj.seller")
  fun amountGroupedBySeller(): List<SaleSumDTO>

  @Query("SELECT new me.davidffa.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " +
          "FROM Sale AS obj GROUP BY obj.seller")
  fun successGroupedBySeller(): List<SaleSuccessDTO>
}