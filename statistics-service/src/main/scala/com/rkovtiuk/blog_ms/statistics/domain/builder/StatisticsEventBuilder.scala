package com.rkovtiuk.blog_ms.statistics.domain.builder

import com.rkovtiuk.blog_ms.statistics.entity.StatisticsEvent
import org.springframework.stereotype.Component

@Component
class StatisticsEventBuilder(val entity: StatisticsEvent) {

  var userId: Int = _
  var commentId: Int = _
  var blogId: Int = _
  var eventType: String = ""

  def this() = this(new StatisticsEvent)

  def build(): StatisticsEvent = {
    entity.user = userId
    entity.comment = commentId
    entity.blog = blogId
    entity.event = eventType
    entity
  }

  def setUser(id: Option[Int]): StatisticsEventBuilder = {
    if (id.nonEmpty)
      userId = id.get
    this
  }

  def setComment(id: Option[Int]): StatisticsEventBuilder = {
    if (id.nonEmpty)
      commentId = id.get
    this
  }

  def setBlog(id: Option[Int]): StatisticsEventBuilder = {
    if (id.nonEmpty)
      blogId = id.get
    this
  }

  def setEventType(event: String): StatisticsEventBuilder = {
    eventType = event
    this
  }

}
