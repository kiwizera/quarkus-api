package org.api.entity;

import java.sql.Date;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;


@Entity
public class Transaction extends PanacheEntity {

    public String name;

    public Integer transactionTypeId;

    public Date transactionDate;

    public Double amount;
    
    public String category;

    public static List<Transaction> findByTransactionTypeId(Integer transactionTypeId) {
        return find("transactionTypeId", transactionTypeId).list();
    }
}
