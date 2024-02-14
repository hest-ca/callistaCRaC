package se.callistaenterprise.callistacrac;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import se.callistaenterprise.callistacrac.blog.BlogEntity;
import se.callistaenterprise.callistacrac.blog.BlogRepository;

@SpringBootApplication
public class CallistacracApplication {
  public static void main(String[] args) {
    SpringApplication.run(CallistacracApplication.class, args);
  }

  @Component
  class StatefulComponent implements SmartLifecycle {

    @Override
    public void start() {
      // fetch config and start stateful component
    }

    @Override
    public void stop() {
      // graceful shutdown and remove config?
    }

    @Override
    public boolean isRunning() {
      return false;
    }
  }

  @Bean
  public CommandLineRunner run(BlogRepository blogRepository) {
    return (String[] args) -> {
      BlogEntity blog1 = new BlogEntity("en blogg", "Lorem");
      BlogEntity blog2 = new BlogEntity("två blogg", "Ipsum");
      blogRepository.save(blog1);
      blogRepository.save(blog2);
      blogRepository.findAll().forEach(System.out::println);
    };
  }
}
