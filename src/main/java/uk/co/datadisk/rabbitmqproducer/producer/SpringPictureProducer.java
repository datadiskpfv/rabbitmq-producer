package uk.co.datadisk.rabbitmqproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringPictureProducer {

  private final RabbitTemplate rabbitTemplate;

  private ObjectMapper objectMapper = new ObjectMapper();

  public SpringPictureProducer(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendMessage(Picture p) {
    try {
      var json = objectMapper.writeValueAsString(p);
      rabbitTemplate.convertAndSend("x.spring.work", p.getType(), json);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
