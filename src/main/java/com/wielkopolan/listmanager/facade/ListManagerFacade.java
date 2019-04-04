package com.wielkopolan.listmanager.facade;

import com.wielkopolan.listmanager.entity.Item;
import com.wielkopolan.listmanager.exception.EmptyListException;
import com.wielkopolan.listmanager.exception.NoFormerListElementException;
import com.wielkopolan.listmanager.exception.NoSubsequentListElementException;

import java.util.List;

/**
 * Facade making changes in database
 */
public interface ListManagerFacade {

    List<Item> findAll();

    void moveUp(int elementId) throws NoFormerListElementException, EmptyListException;

    void moveDown(int elementId) throws NoSubsequentListElementException, EmptyListException;

    void moveToTop(int elementId) throws NoFormerListElementException, EmptyListException;

    void moveToBottom(int elementId) throws NoSubsequentListElementException, EmptyListException;

    void updateDatabaseWithNewList(List<Item> newList);
}
