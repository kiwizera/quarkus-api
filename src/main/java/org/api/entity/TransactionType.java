package org.api.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;


@Entity
@Table(name = "Transaction_Type")
public class TransactionType extends PanacheEntityBase {

    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long transactionTypeId;
    public String name;

    // Default constructor
    public TransactionType() {
    }

    // Constructor with parameters
    public TransactionType(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getTransactionTypeId() {
        return transactionTypeId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
