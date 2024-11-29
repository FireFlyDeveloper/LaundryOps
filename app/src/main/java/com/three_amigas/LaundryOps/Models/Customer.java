/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.three_amigas.LaundryOps.Models;

/**
 *
 * @author Kim Eduard Saludes
 */
public class Customer {
    private final String name;
    private final String number;
    private final String email;
    private final String date;

    public Customer(String name, String number, String email, String date) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getDate() {
        return date;
    }
}
