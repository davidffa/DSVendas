package me.davidffa.dsvendas.entities

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tb_sales")
class Sale(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long,
  var visited: Int,
  var deals: Int,
  var amount: Double,
  var date: LocalDate,

  @ManyToOne
  @JoinColumn(name = "seller_id")
  var seller: Seller
)