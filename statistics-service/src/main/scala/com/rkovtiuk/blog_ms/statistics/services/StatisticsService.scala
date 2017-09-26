package com.rkovtiuk.blog_ms.statistics.services

import com.rkovtiuk.blog_ms.statistics.domain.requests.StatisticsEventRequest
import com.rkovtiuk.blog_ms.statistics.entity.StatisticsEvent
import com.rkovtiuk.blog_ms.statistics.mapper.StatisticsEventMapper
import com.rkovtiuk.blog_ms.statistics.repository.StatisticsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

trait StatisticsService {
  def getUserEvents(id: Long, eventType: String): Iterable[StatisticsEvent]
  def getCommentEvents(id: Long, eventType: String): Iterable[StatisticsEvent]
  def getBlogEvents(id: Long, eventType: String): Iterable[StatisticsEvent]
  def track(dto: StatisticsEventRequest)
}

@Service
class StatisticsServiceImpl(@Autowired val repo: StatisticsRepository,
                            @Autowired val mapper: StatisticsEventMapper)
                            extends StatisticsService{

  override def track(dto: StatisticsEventRequest): StatisticsEvent =
    repo.save[StatisticsEvent](mapper.mapToEntity(dto))

  override def getUserEvents(id: Long, eventType: String) = {
    repo.findAllByUser(id)
  }

  override def getCommentEvents(id: Long, eventType: String) = {
    repo.findAllByComment(id)
  }

  override def getBlogEvents(id: Long, eventType: String) = {
    repo.findAllByBlog(id)
  }
}
