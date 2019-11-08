package uk.co.datadisk.rabbitmqproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

//@Service
public class EmployeeJsonProducer {

  private final RabbitTemplate rabbitTemplate;

  private ObjectMapper objectMapper = new ObjectMapper();

  public EmployeeJsonProducer(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendMessage(Employee emp) {
    try {
      var json = objectMapper.writeValueAsString(emp);
      rabbitTemplate.convertAndSend("course.employee", json);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }
}
