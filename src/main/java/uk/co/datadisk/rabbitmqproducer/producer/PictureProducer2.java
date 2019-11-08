package uk.co.datadisk.rabbitmqproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

//@Service
public class PictureProducer2 {

  private final RabbitTemplate rabbitTemplate;

  private ObjectMapper objectMapper = new ObjectMapper();

  public PictureProducer2(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendMessage(Picture p) {
    try {
      var sb = new StringBuilder();

      sb.append(p.getSource() + ".");
      sb.append(p.getSize() > 4000 ? "large." : "small.");
      sb.append(p.getType());

      System.out.println("Source: " + sb.toString());

      var routingKey = sb.toString();

      var json = objectMapper.writeValueAsString(p);
      // The routing is blank as in fanout exchange all messages are broadcast
      // on all queues
      rabbitTemplate.convertAndSend("x.picture2", routingKey, json);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
