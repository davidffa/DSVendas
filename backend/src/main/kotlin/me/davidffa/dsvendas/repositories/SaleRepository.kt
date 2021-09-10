package me.davidffa.dsvendas.repositories

import me.davidffa.dsvendas.entities.Sale
import org.springframework.data.jpa.repository.JpaRepository

interface SaleRepository : JpaRepository<Sale, Long>