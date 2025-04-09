package org.api.entity;

import java.sql.Date;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;


@Entity
@Table(name = "Transaction")
public class Transaction extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long transactionId;
    public String name;
    public Long transactionTypeId;
    public Date transactionDate;
    public Double amount;
    public String category;
    public Long bankAccountId;

    // Default constructor
    public Transaction() {
    }

    // Constructor with parameters
    public Transaction(String name, Long transactionTypeId, Date transactionDate, Double amount, String category, Long bankAccountId) {
        this.name = name;
        this.transactionTypeId = transactionTypeId;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.category = category;
        this.bankAccountId = bankAccountId;
    }

    // Getters and Setters
    public Long getTransactionId() {
        return transactionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Long transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    // Method to find transactions by transactionTypeId
    public static List<Transaction> findByTransactionTypeId(Long transactionTypeId) {
        return list("transactionTypeId", transactionTypeId);
    }
}
