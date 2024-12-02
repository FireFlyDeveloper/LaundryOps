/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.three_amigas.LaundryOps;

import com.three_amigas.LaundryOps.Models.Customer;
import javax.swing.table.DefaultTableModel;

public class Queue {
    private final DefaultTableModel model;
    
    public Queue(DefaultTableModel model) {
        this.model = model;
    }
    
    public void addRowToQueue(Customer customer) {
        int rowCount = this.model.getRowCount();
        this.model.addRow(new Object[]{rowCount + 1, customer.name, customer.number, customer.email, customer.date});
    }

    public void addRowToPriorityQueue(Customer customer) {
        Object[] newRow = {1, customer.name, customer.number, customer.email, customer.date};
        
        for (int i = 0; i < this.model.getRowCount(); i++) {
            int currentPriority = (int) this.model.getValueAt(i, 0);
            this.model.setValueAt(currentPriority + 1, i, 0);
        }

        this.model.insertRow(0, newRow);
    }

    public void removeFirstRowFromQueue() {
        if (this.model.getRowCount() > 0) {
            this.model.removeRow(0);
            for (int i = 0; i < model.getRowCount(); i++) {
                this.model.setValueAt(i + 1, i, 0);
            }
        }
    }
}
