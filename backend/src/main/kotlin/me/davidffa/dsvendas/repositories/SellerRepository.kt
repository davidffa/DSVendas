package me.davidffa.dsvendas.repositories

import me.davidffa.dsvendas.entities.Seller
import org.springframework.data.jpa.repository.JpaRepository

interface SellerRepository : JpaRepository<Seller, Long>