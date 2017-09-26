package com.rkovtiuk.blog_ms.statistics.domain.requests

class StatisticsEventRequest {

  var userId: Option[Int] = Option.empty
  var blogId: Option[Int] = Option.empty
  var commentId: Option[Int] = Option.empty
  var eventType: String = ""

}
