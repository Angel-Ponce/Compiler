/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angelponce
 */
public class SintacticAnalizer {

    private JTextArea input;
    private JTextArea output;
    private JDialog symbolsTableDialog;
    private JTable symbolsTable;

    public SintacticAnalizer(JTextArea input, JTextArea output, JDialog symbolsTableDialog, JTable symbolsTable) {
        this.input = input;
        this.output = output;
        this.symbolsTableDialog = symbolsTableDialog;
        this.symbolsTable = symbolsTable;
    }

    public SintacticAnalizer() {

    }

    public void analize() {
        DefaultTableModel model = (DefaultTableModel) symbolsTable.getModel();
        for (int i = symbolsTable.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        String[] tokens = input.getText().replace("\n", " ").split("\\s");
        int counter = 1;
        int directionSize = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].matches("<.+,id>")) {
                String id = tokens[i].replace("<", "").replace(">", "").replace(",", "").replace("id", "");
                try {
                    if (tokens[i - 1].matches("<.+,dato>") && !tokens[i + 1].matches("<\\(,par_a>")) {
                        String type = tokens[i - 1].replace("<", "").replace(">", "").replace(",", "").replace("dato", "");
                        String direction = "STATIC+" + directionSize;
                        Object[] row = {counter, id, direction, type, String.valueOf(0)};
                        directionSize += sizeOf(type);
                        counter++;
                        model.addRow(row);
                    } else if (tokens[i - 1].matches("<.+,modificador>")) {

                    } else if (tokens[i - 1].matches("<pr,class>")) {

                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }

        this.symbolsTableDialog.setVisible(true);
    }

    private static int sizeOf(String type) {
        switch (type) {
            case "byte":
                return 1;
            case "short":
                return 2;
            case "int":
                return 4;
            case "long":
                return 8;
            case "float":
                return 4;
            case "double":
                return 8;
            case "boolean":
                return 1;
            case "char":
                return 2;
            case "String":
                return 8;
            default:
                return 0;
        }
    }
}
