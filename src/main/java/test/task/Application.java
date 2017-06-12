package test.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import test.task.model.Item;
import test.task.model.Stock;
import test.task.repository.ItemRepository;


@SpringBootApplication()
public class Application extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public CommandLineRunner setup(ItemRepository repository) {
        return (args) -> {
            Item item1 = new Item(new Stock(123.5));
            Item item2 = new Item(new Stock(334.5));
            Item item3 = new Item(new Stock(445.8));
            Item item4 = new Item(new Stock(445.8));
            Item item5 = new Item(new Stock(445.8));
            Item item6 = new Item(new Stock(445.8));

            repository.save(item1);
            repository.save(item2);
            repository.save(item3);
            repository.save(item4);

            logger.info("The sample data has been generated");
        };
    }
}
