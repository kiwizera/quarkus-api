package org.api.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;


@Entity
public class Product extends PanacheEntity {
    public String name;
    public String email;
    public String password;

    // No need to use getters/setters with Panache
}