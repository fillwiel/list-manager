package com.wielkopolan.listmanager.util;

import com.wielkopolan.listmanager.entity.Item;
import com.wielkopolan.listmanager.exception.EmptyListException;
import com.wielkopolan.listmanager.exception.NoFormerListElementException;
import com.wielkopolan.listmanager.exception.NoSubsequentListElementException;

import java.util.Collections;
import java.util.List;

public abstract class ListManager {

    public static void moveElementUp(int elementId, List<Item> itemList) throws NoFormerListElementException,
                                                                                EmptyListException {
        if (itemList.isEmpty()) {
            throw new EmptyListException(Collections.singletonList(itemList));
        }
        if (elementId > 0 && elementId < itemList.size()) {
            Collections.swap(itemList, elementId, elementId - 1);
            updateListIndexProperties(itemList);
        } else {
            throw new NoFormerListElementException();
        }
    }

    public static void moveElementDown(int elementId, List<Item> itemList) throws NoSubsequentListElementException,
                                                                                  EmptyListException {
        if (itemList.isEmpty()) {
            throw new EmptyListException(Collections.singletonList(itemList));
        }
        if (elementId >= 0 && elementId < itemList.size() - 1 && itemList.size() > 1) {
            Collections.swap(itemList, elementId, elementId + 1);
            updateListIndexProperties(itemList);
        } else {
            throw new NoSubsequentListElementException();
        }
    }

    public static void moveElementToTop(int elementId, List<Item> itemList) throws NoFormerListElementException,
                                                                                   EmptyListException {
        if (itemList.isEmpty()) {
            throw new EmptyListException(Collections.singletonList(itemList));
        }
        if (elementId > 0 && elementId < itemList.size()) {
            itemList.add(0, itemList.remove(elementId));
            updateListIndexProperties(itemList);
        } else {
            throw new NoFormerListElementException();
        }
    }

    public static void moveElementToBottom(int elementId, List<Item> itemList) throws
                                                                                   NoSubsequentListElementException,
                                                                                   EmptyListException {
        if (itemList.isEmpty()) {
            throw new EmptyListException(Collections.singletonList(itemList));
        }
        if (elementId >= 0 && elementId < itemList.size() - 1 && itemList.size() > 1) {
            Item movedItem = itemList.get(elementId);
            itemList.remove(elementId);
            itemList.add(movedItem);
            updateListIndexProperties(itemList);
        } else {
            throw new NoSubsequentListElementException();
        }
    }

    private static void updateListIndexProperties(List<Item> itemList) {
        int i = 0;
        for (Item item : itemList) {
            item.setListIndex(i);
            i++;
        }
    }

    private ListManager() {
    }
}
