package com.rkovtiuk.blog_ms.statistics.controllers

import com.rkovtiuk.blog_ms.statistics.domain.requests.StatisticsEventRequest
import com.rkovtiuk.blog_ms.statistics.entity.StatisticsEvent
import com.rkovtiuk.blog_ms.statistics.services.StatisticsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation._

@RestController
class StatisticsController(@Autowired val service: StatisticsService) {

  @RequestMapping(value = Array("/event/track"), method = Array(RequestMethod.POST))
  def trackEvent(@RequestBody request: StatisticsEventRequest): ResponseEntity[String] = {
    if (request==null)
      return new ResponseEntity(HttpStatus.NO_CONTENT)
    service.track(request)
    ResponseEntity.ok("Event saved")
  }

  @RequestMapping(value = Array("events/user/{id}"))
  def getUserEvent(@PathVariable(value = "id") id: Long,
                   @RequestParam(name = "type", required = false) eventType: String): ResponseEntity[Iterable[StatisticsEvent]] = {
    ResponseEntity.ok(service.getUserEvents(id, eventType))
  }

  @RequestMapping(value = Array("/events/blog/{id}"))
  def getBlogEvent(@PathVariable(value = "id") id: Long,
                   @RequestParam(name = "type", required = false) eventType: String): ResponseEntity[Iterable[StatisticsEvent]] = {
    ResponseEntity.ok(service.getBlogEvents(id, eventType))
  }

  @RequestMapping(value = Array("/events/comment/{id}"))
  def getCommentEvent(@PathVariable(value = "id") id: Long,
                      @RequestParam(name = "type", required = false) eventType: String): ResponseEntity[Iterable[StatisticsEvent]] = {
    ResponseEntity.ok(service.getCommentEvents(id, eventType))
  }

}
