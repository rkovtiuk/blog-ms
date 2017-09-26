package com.rkovtiuk.blog_ms.statistics.domain.builder

import com.rkovtiuk.blog_ms.statistics.entity.StatisticsEvent
import org.springframework.stereotype.Component

@Component
class StatisticsEventBuilder(val entity: StatisticsEvent) {

  var userId: Int = 0
  var commentId: Int = 0
  var blogId: Int = 0
  var eventType: String = ""

  def this() = this(new StatisticsEvent)

  def build(): StatisticsEvent = {
    entity.user = userId
    entity.comment = commentId
    entity.blog = blogId
    entity.event = eventType
    entity
  }

  def setUser(id: Int): StatisticsEventBuilder = {
    userId = id; this
  }

  def setComment(id: Int): StatisticsEventBuilder = {
    commentId = id; this
  }

  def setBlog(id: Int): StatisticsEventBuilder = {
    blogId = id; this
  }

  def setEventType(event: String): StatisticsEventBuilder = {
    eventType = event; this
  }

}
