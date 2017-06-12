package test.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import test.task.model.Item;
import test.task.service.ItemService;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ItemService service;

   /* @RequestMapping(value="", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> getAll() */

    @RequestMapping(value="/items", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Item> getItems() {
        return service.getAllItems();
    }

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {

        return "Hi "+name+" !";

    }

    @RequestMapping(value = "/getprice{mpn}", method = RequestMethod.GET)
    public Item getItem(@PathVariable("mpn") String mpn) {

        return service.getItemDataByMpn(mpn);
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable("id") long id) {

        return service.getItemDataById(id);
    }

}
