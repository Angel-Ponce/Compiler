/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        String[] tokens = split(input.getText().replace("\n", " "), "(?:<[^<]*?>|[^\\s])+");
        ArrayList<String> arrTokens = new ArrayList();
        for (String t : tokens) {
            if (!t.matches("\\s+")) {
                arrTokens.add(t);
            }
        }
        tokens = arrTokens.toArray(new String[0]);
        int counter = 1;
        int directionSize = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].matches("<.+,id>")) {
                String id = tokens[i].replace("<", "").replace(">", "").replace(",", "").replace("id", "");
                try {
                    if (tokens[i - 1].matches("<.+,dato>") || tokens[i - 1].matches("<class,pr>")) {
                        String type = tokens[i - 1].replace("<", "").replace(">", "").replace(",", "").replace("dato", "").replace("pr", "");
                        String direction = "STATIC+" + directionSize;
                        int dimention = 0;
                        if (type.equals("String")) {
                            if (tokens[i + 1].matches("<=,sy_asig>")
                                    && tokens[i + 2].matches("<\",sy_codo>")
                                    && tokens[i + 3].matches("<.*,value>")
                                    && tokens[i + 4].matches("<\",sy_codo>")) {
                                String valueString = tokens[i + 3].replace("<", "").replace(">", "").replace(",", "").replace("value", "");
                                dimention = valueString.length();
                            }
                        }
                        Object[] row = {counter, id, direction, type, dimention};
                        directionSize += sizeOf(type) + dimention;
                        counter++;
                        model.addRow(row);
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
            default:
                return 0;
        }
    }

    public static String[] split(CharSequence input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int start = 0;
        ArrayList<String> result = new ArrayList();
        while (matcher.find()) {
            result.add(input.subSequence(start, matcher.start()).toString());
            result.add(matcher.group());
            start = matcher.end();
        }
        if (start != input.length()) {
            result.add(input.subSequence(start, input.length()).toString());
        }
        return result.toArray(new String[0]);
    }
}
