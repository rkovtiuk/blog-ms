package com.rkovtiuk.blog_ms.statistics.entity

import javax.persistence._


@Entity
@Table(name = "statistics")
class StatisticsEvent{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var user: Long = null

  @Column(name = "blog")
  var blog: Long = null

  @Column(name = "comment")
  var comment: Long = null

  @Column(name = "type")
  var event: String = ""

}
