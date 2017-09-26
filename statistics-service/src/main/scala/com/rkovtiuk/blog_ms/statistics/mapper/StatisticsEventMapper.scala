package com.rkovtiuk.blog_ms.statistics.mapper

import com.rkovtiuk.blog_ms.statistics.domain.builder.StatisticsEventBuilder
import com.rkovtiuk.blog_ms.statistics.domain.requests.StatisticsEventRequest
import com.rkovtiuk.blog_ms.statistics.entity.StatisticsEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

trait StatisticsEventMapper {
  def mapToEntity(dto: StatisticsEventRequest): StatisticsEvent
}

@Component
class StatisticsEventMapperImpl(@Autowired val builder: StatisticsEventBuilder)
                                extends StatisticsEventMapper{

  override def mapToEntity(dto: StatisticsEventRequest): StatisticsEvent =
    builder
      .setUser(dto.userId)
      .setBlog(dto.blogId)
      .setComment(dto.commentId)
      .build()
}
