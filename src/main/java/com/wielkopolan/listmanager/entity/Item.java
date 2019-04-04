package com.wielkopolan.listmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Item Entity used by Hibernate
 */
@Entity
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "id",
            nullable = false)
    private int id;

    @Column(name = "Name",
            length = 64,
            nullable = false)
    private String name;

    @Column(name = "ListIndex",
            nullable = false)
    private int listIndex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getListIndex() {
        return listIndex;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }
}
