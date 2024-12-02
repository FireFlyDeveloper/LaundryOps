/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.three_amigas.LaundryOps.Models;

public class Customer {
    public final String name;
    public final String number;
    public final String email;
    public final String date;
    public final boolean done;
    public final boolean mailed;

    public Customer(String name, String number, String email, String date, boolean done, boolean mailed) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.date = date;
        this.done = done;
        this.mailed = mailed;
    }
}
