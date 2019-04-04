package com.wielkopolan.listmanager.dao;

import com.wielkopolan.listmanager.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDAO extends CrudRepository<Item, Long> {

}
