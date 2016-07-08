package org.jimmyoak.service.reactiveuserservice.api

import org.springframework.boot.SpringApplication
import org.springframework.cloud.client.SpringCloudApplication

@SpringCloudApplication
class Application

object Application {
  def main(args: Array[String]) {
    SpringApplication.run(classOf[Application], args: _*)
  }
}
