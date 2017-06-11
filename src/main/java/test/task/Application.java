package test.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import test.task.enums.StockAvailability;
import test.task.model.Item;
import test.task.model.Stock;
import test.task.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication()
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner setup(ItemRepository repository) {
        return (args) -> {

            Stock s1 = new Stock(123.6, StockAvailability.FEW);
            Stock s2 = new Stock(123.6, StockAvailability.FEW);
            Stock s3 = new Stock(123.6, StockAvailability.FEW);
            Stock s4 = new Stock(123.6, StockAvailability.FEW);


            List<Stock> stockDetails = new ArrayList<>();
            stockDetails.add(s1);
            stockDetails.add(s2);
            stockDetails.add(s3);
            stockDetails.add(s4);

            Item good = new Item(s1);
            /*Item g1 = new Item(stockDetails);
            Item g2 = new Item(stockDetails);
            Item g3 = new Item(stockDetails);*/
            //repository.save(g1);
           // repository.save(g2);
            //repository.save(g3);
            repository.save(good);

            logger.info("The sample data has been generated");
        };
    }
}