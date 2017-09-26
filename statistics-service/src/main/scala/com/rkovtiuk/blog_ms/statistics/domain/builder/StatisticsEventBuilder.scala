package com.rkovtiuk.blog_ms.statistics.domain.builder

import com.rkovtiuk.blog_ms.statistics.entity.StatisticsEvent
import org.springframework.stereotype.Component

@Component
class StatisticsEventBuilder(val entity: StatisticsEvent) {

  var userId: Int = null
  var commentId: Int = null
  var blogId: Int = null
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
