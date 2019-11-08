package uk.co.datadisk.rabbitmqproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class FixedRateProducer {

  private RabbitTemplate rabbitTemplate;

  private int i = 0;

  private Logger log = LoggerFactory.getLogger(FixedRateProducer.class);

  public FixedRateProducer(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Scheduled(fixedRate = 500)
  public void sendMessage() {
    i++;
    //log.info("i is " + i);
    rabbitTemplate.convertAndSend("course.fixedrate", "Fixed rate " + i);
  }
}
