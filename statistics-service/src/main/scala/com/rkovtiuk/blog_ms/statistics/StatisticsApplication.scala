package com.rkovtiuk.blog_ms.statistics

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.context.annotation.ComponentScan

@ComponentScan(Array("com.rkovtiuk.blog_ms.core", "com.rkovtiuk.blog_ms.notification"))
@EnableAutoConfiguration
@SpringBootApplication
class StatisticsApplication extends App{
}

object StartStatisticsApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[StatisticsApplication])
  }
}
