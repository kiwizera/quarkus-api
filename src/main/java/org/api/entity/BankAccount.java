package org.api.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;


@Entity
@Table(name = "Bank_Account")
public class BankAccount extends PanacheEntityBase {

    // Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long bankAccountId;
    public String name;
    public String accountNumber;
    public String agencyNumber;

    // Default constructor
    public BankAccount() {
    }

    // Constructor with parameters
    public BankAccount(String name, String accountNumber, String agencyNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
    }

    // Getters and Setters
    public Long getBankAccountId() {
        return bankAccountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(String agencyNumber) {
        this.agencyNumber = agencyNumber;
    }
}
