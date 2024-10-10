package com.luv2code.hibernate.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class user{

    @Id
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    public int getId(int id) {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName(String name) {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
