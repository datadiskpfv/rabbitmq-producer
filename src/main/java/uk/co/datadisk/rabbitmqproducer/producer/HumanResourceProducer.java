package uk.co.datadisk.rabbitmqproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

//@Service
public class HumanResourceProducer {

  private final RabbitTemplate rabbitTemplate;

  private ObjectMapper objectMapper = new ObjectMapper();

  public HumanResourceProducer(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendMessage(Employee emp) {
    try {
      var json = objectMapper.writeValueAsString(emp);
      // The routing is blank as in fanout exchange all messages are broadcast
      // on all queues
      rabbitTemplate.convertAndSend("x.hr", "", json);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
