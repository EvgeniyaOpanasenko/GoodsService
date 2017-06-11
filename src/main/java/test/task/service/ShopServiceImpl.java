package test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.model.Item;
import test.task.repository.ItemRepository;

import java.util.List;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ItemRepository itemRepository;
    

    @Override
    public Item getItemDataById(long id) {
        return (Item) itemRepository.findOne(id);
    }

    @Override
    public Item getItemDataByMpn(String mpn) {
        return getAllItems().stream()
                .filter(i-> i.getMpn()
                        .equals(mpn)).findFirst().get();
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
