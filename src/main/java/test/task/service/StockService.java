package test.task.service;

import test.task.model.Item;
import test.task.model.Stock;

import java.util.List;

public interface StockService {
    Stock getById(long id);
    List<Stock> getAll();
}
