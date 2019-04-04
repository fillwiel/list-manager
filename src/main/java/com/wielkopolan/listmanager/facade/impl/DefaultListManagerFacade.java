package com.wielkopolan.listmanager.facade.impl;

import com.wielkopolan.listmanager.dao.ItemDAO;
import com.wielkopolan.listmanager.entity.Item;
import com.wielkopolan.listmanager.exception.EmptyListException;
import com.wielkopolan.listmanager.exception.NoFormerListElementException;
import com.wielkopolan.listmanager.exception.NoSubsequentListElementException;
import com.wielkopolan.listmanager.facade.ListManagerFacade;
import com.wielkopolan.listmanager.util.ListManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class DefaultListManagerFacade implements ListManagerFacade {

    private static final Logger LOGGER = Logger.getLogger(DefaultListManagerFacade.class.getName());

    @Autowired
    private ItemDAO itemDAO;

    @Override
    public List<Item> findAll() {
        List<Item> itemList = (List<Item>) itemDAO.findAll();
        sortListByListIndexParam(itemList);
        return itemList;
    }

    @Override
    public void moveUp(final int elementId) throws NoFormerListElementException, EmptyListException {
        LOGGER.info("Moving UP element on position " + elementId);
        ArrayList<Item> itemList = (ArrayList<Item>) findAll();
        ListManager.moveElementUp(elementId, itemList);
        updateDatabaseWithNewList(itemList);
    }

    @Override
    public void moveDown(final int elementId) throws NoSubsequentListElementException, EmptyListException {
        LOGGER.info("Moving DOWN element on position " + elementId);
        ArrayList<Item> itemList = (ArrayList<Item>) findAll();
        ListManager.moveElementDown(elementId, itemList);
        updateDatabaseWithNewList(itemList);
    }

    @Override
    public void moveToTop(final int elementId) throws NoFormerListElementException, EmptyListException {
        LOGGER.info("Moving TO TOP element on position " + elementId);
        ArrayList<Item> itemList = (ArrayList<Item>) findAll();
        ListManager.moveElementToTop(elementId, itemList);
        updateDatabaseWithNewList(itemList);
    }

    @Override
    public void moveToBottom(final int elementId) throws NoSubsequentListElementException, EmptyListException {
        LOGGER.info("Moving TO BOTTOM element on position " + elementId);
        ArrayList<Item> itemList = (ArrayList<Item>) findAll();
        ListManager.moveElementToBottom(elementId, itemList);
        updateDatabaseWithNewList(itemList);
    }

    @Override
    public void updateDatabaseWithNewList(final List<Item> itemList){
        itemDAO.saveAll(itemList);
    }

    private void sortListByListIndexParam(List<Item> itemList){
        itemList.sort((item1, item2) -> {
            if(item1.getListIndex() == item2.getListIndex()) {
                return 0;
            }
            return item1.getListIndex() > item2.getListIndex() ? 1 : -1;
        });
    }
}
