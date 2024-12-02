package com.three_amigas.LaundryOps;

import com.three_amigas.LaundryOps.Models.Customer;
import com.three_amigas.LaundryOps.Models.SQLquery;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Queue {
    private final DefaultTableModel model;
    private final CRUD crud;

    public Queue(DefaultTableModel model) {
        this.model = model;
        this.crud = new CRUD();
        loadExistingData();
    }

    // Load existing data from the database into the table model
    private void loadExistingData() {
        List<SQLquery> data = this.crud.read();
        for (SQLquery sql : data) {
            this.model.addRow(new Object[]{sql.id, sql.name, sql.number, sql.email, sql.date});
        }
    }

    public void addRowToQueue(Customer customer) {
        int newId = this.model.getRowCount() + 1;

        SQLquery sql = new SQLquery(newId, customer.name, customer.number, customer.email, customer.date, false, false);
        if (this.crud.create(sql)) {
            this.model.addRow(new Object[]{newId, customer.name, customer.number, customer.email, customer.date});
        } else {
            System.err.println("Failed to add row to the database.");
        }
    }

    public void addRowToPriorityQueue(Customer customer) {
        Object[] newRow = {1, customer.name, customer.number, customer.email, customer.date};

        // Adjust priorities in the table and the database
        for (int i = 0; i < this.model.getRowCount(); i++) {
            int currentPriority = (int) this.model.getValueAt(i, 0);
            this.model.setValueAt(currentPriority + 1, i, 0);

            // Update priority in the database
            int id = (int) this.model.getValueAt(i, 0);
            SQLquery sql = new SQLquery(id, 
                                         (String) this.model.getValueAt(i, 1), 
                                         (String) this.model.getValueAt(i, 2), 
                                         (String) this.model.getValueAt(i, 3), 
                                         (String) this.model.getValueAt(i, 4), 
                                         false, false);
            this.crud.update(sql);
        }

        // Add the new row to the table and the database
        SQLquery newSql = new SQLquery(this.model.getRowCount() + 1, customer.name, customer.number, customer.email, customer.date, false, false);
        if (this.crud.create(newSql)) {
            this.model.insertRow(0, newRow);
        } else {
            System.err.println("Failed to add row to the database.");
        }
    }

    public void removeFirstRowFromQueue() {
        if (this.crud.deleteLastInserted()) {
            this.model.removeRow(0);

            // Recalculate priorities for remaining rows
            for (int i = 0; i < this.model.getRowCount(); i++) {
                this.model.setValueAt(i + 1, i, 0);
            }
        } else {
            System.err.println("Failed to remove row from the database.");
        }
    }
}