package com.rkovtiuk.blog_ms.statistics.entity

import javax.persistence._


@Entity
@Table(name = "statistics")
class StatisticsEvent{

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long = _

  @Column(name = "user")
  var user: Long = _

  @Column(name = "blog")
  var blog: Long = _

  @Column(name = "comment")
  var comment: Long = _

  @Column(name = "type")
  var event: String = _

}
