package com.three_amigas.LaundryOps;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class PriorityRowRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        setHorizontalAlignment(CENTER);

        if (row == 0) {
            c.setBackground(Color.YELLOW);
        }

        return c;
    }
}
