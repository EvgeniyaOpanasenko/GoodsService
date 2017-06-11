package test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.model.Stock;
import test.task.repository.StockRepository;

import java.util.List;


@Service("stockService")
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository repository;


    @Override
    public Stock getById(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Stock> getAll() {
        return (List<Stock>) repository.findAll();
    }
}
