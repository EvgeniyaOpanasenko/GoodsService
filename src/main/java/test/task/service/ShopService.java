package test.task.service;

import test.task.model.Item;

import java.util.List;

public interface ShopService {
    Item getItemDataById(long id);
    Item getItemDataByMpn(String mpn);
    List<Item> getAllItems();
}
