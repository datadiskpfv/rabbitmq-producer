package uk.co.datadisk.rabbitmqproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import uk.co.datadisk.rabbitmqproducer.producer.*;

import javax.lang.model.element.TypeParameterElement;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {

  //@Autowired
  //private HelloRabbitProducer helloRabbitProducer;

  @Autowired
  //private EmployeeJsonProducer employeeJsonProducer;
  //private HumanResourceProducer humanResourceProducer;
  //private PictureProducer pictureProducer;
  //private PictureProducer2 pictureProducer2;
  //private MyPictureProducer myPictureProducer;
  //private RetryPictureProducer retryPictureProducer;
  //private RetryEmployeeProducer retryEmployeeProducer;
  private SpringPictureProducer springPictureProducer;

  private final List<String> SOURCES = List.of("mobile", "web");
  private final List<String> TYPES = List.of("jpg", "png", "svg");

  public static void main(String[] args) {
    SpringApplication.run(RabbitmqProducerApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    //helloRabbitProducer.sendHello("Paul " + Math.random());

//    for (int i = 0; i < 5; i++) {
//      var a = new Employee("emp " + 1, "Employee " + i, LocalDate.now());
//      //employeeJsonProducer.sendMessage(a);
//      humanResourceProducer.sendMessage(a);
//    }

//    for (int i = 0; i < 10; i++) {
//      var p = new Picture();
//
//      p.setName("Picture " + i);
//      p.setSize(ThreadLocalRandom.current().nextLong(9001, 10001));
//      p.setSource(SOURCES.get(i % SOURCES.size()));
//      p.setType(TYPES.get(i % TYPES.size()));
//
//      retryPictureProducer.sendMessage(p);
//    }

//    for (int i = 0; i < 1; i++) {
//      var p = new Picture();
//
//      p.setName("Picture " + i);
//      p.setSize(ThreadLocalRandom.current().nextLong(9000, 10000));
//      p.setSource(SOURCES.get(i % SOURCES.size()));
//      p.setType(TYPES.get(i % TYPES.size()));
//
//      myPictureProducer.sendMessage(p);
//    }

//    for (int i = 0; i < 10; i++) {
//      Employee emp = new Employee("Employee" + i, null, LocalDate.now());
//      retryEmployeeProducer.sendMessage(emp);
//    }

    for (int i = 0; i < 1; i++) {
      var p = new Picture();

      p.setName("Picture " + i);
      p.setSize(ThreadLocalRandom.current().nextLong(9001, 10001));
      p.setSource(SOURCES.get(i % SOURCES.size()));
      p.setType(TYPES.get(i % TYPES.size()));

      springPictureProducer.sendMessage(p);
    }
  }
}