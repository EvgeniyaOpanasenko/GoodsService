package test.task.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test.task.model.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
}
