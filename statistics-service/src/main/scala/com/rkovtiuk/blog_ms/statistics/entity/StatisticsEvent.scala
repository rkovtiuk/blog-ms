package com.rkovtiuk.blog_ms.statistics.entity

import javax.persistence._


@Entity
@Table(name = "statistics")
class StatisticsEvent extends Serializable{

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: java.lang.Long = _

  @Column(name = "user")
  var user: Long = _

  @Column(name = "blog")
  var blog: Long = _

  @Column(name = "comment")
  var comment: Long = _

  @Column(name = "type")
  var event: String = _

}
