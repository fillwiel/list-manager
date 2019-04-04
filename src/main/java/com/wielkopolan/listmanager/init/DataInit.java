package com.wielkopolan.listmanager.init;

import com.wielkopolan.listmanager.dao.ItemDAO;
import com.wielkopolan.listmanager.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInit implements ApplicationRunner {

    private ItemDAO itemDAO;

    @Autowired
    public DataInit(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = itemDAO.count();
        if (count == 0) {
            List<Item> itemList = new ArrayList<>();
            List<String> nameList = Arrays
                    .asList("A Game of Thrones", "A Clash of Kings", "A Storm of Swords",
                            "A Feast for Crows", "A Dance with Dragons", "The Winds of Winter", "A Dream of Spring");
            nameList.forEach(name -> itemList.add(new Item(name)));
            itemList.forEach(item -> {
                itemDAO.save(item);
                item.setListIndex(item.getId()-1);
                itemDAO.save(item);
            });
        }
    }
}
