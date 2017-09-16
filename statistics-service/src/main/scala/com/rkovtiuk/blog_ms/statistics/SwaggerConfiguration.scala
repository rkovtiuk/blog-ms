package com.rkovtiuk.blog_ms.statistics

import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}
import springfox.documentation.builders.{PathSelectors, RequestHandlerSelectors}
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
@ComponentScan(Array("com.rkovtiuk.blog_ms.core", "com.rkovtiuk.blog_ms.statistics"))
class SwaggerConfiguration {

  @Bean
  def api(): Docket = {
    new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis(RequestHandlerSelectors.basePackage("com.rkovtiuk.blog_ms.statistics.controllers"))
      .paths(PathSelectors.any())
      .build()
  }

}
