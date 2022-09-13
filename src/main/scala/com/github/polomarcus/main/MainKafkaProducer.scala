package com.github.polomarcus.main

import com.github.polomarcus.conf.ConfService
import com.github.polomarcus.utils.{KafkaProducerService}
import com.typesafe.scalalogging.Logger

object MainKafkaProducer {
  def main(args: Array[String]) {
    val logger = Logger(this.getClass)
    logger.info("Used `sbt run` to start the app")

    for (i <- 0 to 20) {
      KafkaProducerService.produce(ConfService.TOPIC_OUT, s"key$i", s"Reminder #$i Take time to read the Intergovernmental Panel on Climate Change (IPCC) summary reports - https://www.ipcc.ch/report/ar6/wg1/")
    }

    logger.warn(s"Stopping the app ${this.getClass}")
    KafkaProducerService.close()
    System.exit(0)
  }
}

