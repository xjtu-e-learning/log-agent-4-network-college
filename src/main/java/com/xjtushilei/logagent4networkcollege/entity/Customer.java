package com.xjtushilei.logagent4networkcollege.entity;

import org.springframework.data.annotation.Id;

/**
 * @author scriptshi
 * 2018/5/23
 */
public class Customer {
    @Id
    private String id;

    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id,
                firstName, lastName);
    }
}
