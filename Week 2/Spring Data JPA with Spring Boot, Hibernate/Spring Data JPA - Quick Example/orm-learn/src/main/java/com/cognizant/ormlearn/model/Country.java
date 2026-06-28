package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity tells Spring Data JPA that this class maps to a database table
@Entity
// @Table tells it which table to use (our "country" table in MySQL)
@Table(name = "country")
public class Country {

    // @Id marks this field as the primary key
    @Id
    // @Column maps the field to the actual column name in the table
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    // ---------- Getters ----------

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    // ---------- Setters ----------

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString() so we can print a Country object nicely in logs
    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
