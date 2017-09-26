package com.rkovtiuk.blog_ms.statistics.repository

import java.lang

import com.rkovtiuk.blog_ms.statistics.entity.StatisticsEvent
import org.springframework.data.repository.CrudRepository

trait StatisticsRepository extends CrudRepository[StatisticsEvent, java.lang.Long]{
  override def save[S <: StatisticsEvent](entity: S): S
  override def save[S <: StatisticsEvent](iterable: lang.Iterable[S]): lang.Iterable[S]
  def findAllByUser(user: Long): Iterable[StatisticsEvent]
  def findAllByComment(user: Long): Iterable[StatisticsEvent]
  def findAllByBlog(user: Long): Iterable[StatisticsEvent]
  def findAllByType(user: Long): Iterable[StatisticsEvent]
}
