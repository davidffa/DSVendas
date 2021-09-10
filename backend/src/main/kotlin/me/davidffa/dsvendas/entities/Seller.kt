package me.davidffa.dsvendas.entities

import javax.persistence.*

@Entity
@Table(name = "tb_sellers")
class Seller(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long,
  var name: String,

  @OneToMany(mappedBy = "seller")
  var sales: List<Sale> = mutableListOf()
)