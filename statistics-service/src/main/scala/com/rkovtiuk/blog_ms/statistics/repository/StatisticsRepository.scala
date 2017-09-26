package com.rkovtiuk.blog_ms.statistics.repository

import com.rkovtiuk.blog_ms.statistics.entity.StatisticsEvent
import org.springframework.data.repository.CrudRepository

trait StatisticsRepository extends CrudRepository[StatisticsEvent, Long]{
  def findAllByUser(user: Long): Iterable[StatisticsEvent]
  def findAllByComment(user: Long): Iterable[StatisticsEvent]
  def findAllByBlog(user: Long): Iterable[StatisticsEvent]
  def findAllByType(user: Long): Iterable[StatisticsEvent]
}
