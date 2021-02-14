/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;

/**
 *
 * @author angelponce
 */
public class Compiler extends javax.swing.JFrame {

    private final Txt txtElements = new Txt("Elements");
    private final ArrayList<Element> elements = new ArrayList();
    private int lineInputCounter = 1;
    private int lineOutputCounter = 1;

    /**
     * Creates new form Phase1
     */
    public Compiler() {
        initComponents();
        //Fill elements
        ArrayList<String> linesTxtElements = txtElements.getLines();
        for (String line : linesTxtElements) {
            String[] props = line.split("\\s");
            Element element = new Element(props[0], props[1]);
            elements.add(element);
        }
        addNumberUp();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        container = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        upPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lineCounterUp = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        input = new javax.swing.JTextArea();
        bottomPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lineCounterBottom = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        footerContainer = new javax.swing.JPanel();
        analize = new javax.swing.JButton();
        clean = new javax.swing.JButton();
        example = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fase 1");
        setMinimumSize(new java.awt.Dimension(500, 200));

        container.setPreferredSize(new java.awt.Dimension(1000, 700));
        container.setLayout(new java.awt.GridBagLayout());

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(0.5);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(800, 400));

        upPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Código"));
        upPanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane5.setPreferredSize(new java.awt.Dimension(30, 123));

        lineCounterUp.setEditable(false);
        lineCounterUp.setColumns(20);
        lineCounterUp.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lineCounterUp.setRows(5);
        jScrollPane5.setViewportView(lineCounterUp);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        upPanel.add(jScrollPane5, gridBagConstraints);

        input.setColumns(20);
        input.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        input.setRows(5);
        input.setTabSize(4);
        jScrollPane3.setViewportView(input);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        upPanel.add(jScrollPane3, gridBagConstraints);

        jSplitPane1.setLeftComponent(upPanel);

        bottomPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tokens"));
        bottomPanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane6.setPreferredSize(new java.awt.Dimension(30, 123));

        lineCounterBottom.setEditable(false);
        lineCounterBottom.setColumns(20);
        lineCounterBottom.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lineCounterBottom.setRows(5);
        jScrollPane6.setViewportView(lineCounterBottom);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        bottomPanel.add(jScrollPane6, gridBagConstraints);

        output.setColumns(20);
        output.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        output.setRows(5);
        output.setTabSize(4);
        jScrollPane4.setViewportView(output);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        bottomPanel.add(jScrollPane4, gridBagConstraints);

        jSplitPane1.setRightComponent(bottomPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        container.add(jSplitPane1, gridBagConstraints);

        footerContainer.setPreferredSize(new java.awt.Dimension(800, 100));

        analize.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        analize.setText("Analizar");
        analize.setPreferredSize(new java.awt.Dimension(150, 30));
        analize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizeActionPerformed(evt);
            }
        });
        footerContainer.add(analize);

        clean.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        clean.setText("Limpiar");
        clean.setPreferredSize(new java.awt.Dimension(150, 30));
        clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanActionPerformed(evt);
            }
        });
        footerContainer.add(clean);

        example.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        example.setText("Ejemplo");
        example.setPreferredSize(new java.awt.Dimension(150, 30));
        example.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exampleActionPerformed(evt);
            }
        });
        footerContainer.add(example);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        container.add(footerContainer, gridBagConstraints);

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanActionPerformed
        clean();
    }//GEN-LAST:event_cleanActionPerformed

    private void analizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizeActionPerformed
        analize();
    }//GEN-LAST:event_analizeActionPerformed

    private void exampleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exampleActionPerformed
        input.setText("\n\n\n\nint x;\ndouble y;\nint m=3;\n");
        output.setText("");
    }//GEN-LAST:event_exampleActionPerformed

    private void addNumberUp() {
        lineCounterUp.append(lineInputCounter + "\n");
        lineInputCounter++;
    }

    private void addNumberBottom() {
        lineCounterBottom.append(lineOutputCounter + "\n");
        lineOutputCounter++;
    }

    private void analize() {
        output.setText("");
        String code = input.getText().trim(); //delete front an back null spaces
        String[] linesCode = code.split("\n");
        for (String line : linesCode) {
            line = line += " "; //Ask to engineer Macz
            String element = "";
            int indexChar = 0;
            for (int i = 0; i < line.length(); i++) {
                String character = String.valueOf(line.charAt(i));
                indexChar = i;
                if (character.matches("\\w")) {
                    element += character;
                } else {
                    if (character.equals("\"")) {
                        for (int j = indexChar + 1; j < line.length(); j++) {
                            i++;
                            character = String.valueOf(line.charAt(j));
                            if (!character.equals("\"")) {
                                element += character;
                            } else {
                                String token = "<\",sy> " + "<" + element + "," + elementDescription(element) + "> " + "<\",sy> ";
                                output.append(token);
                                element = "";
                                break;
                            }
                        }
                    } else if (character.equals("\'")) {
                        for (int j = indexChar + 1; j < line.length(); j++) {
                            i++;
                            character = String.valueOf(line.charAt(j));
                            if (!character.equals("\'")) {
                                element += character;
                            } else {
                                String token = "<\',sy> " + "<" + element + "," + elementDescription(element) + "> " + "<\',sy> ";
                                output.append(token);
                                element = "";
                                break;
                            }
                        }
                    } else {
                        if (!character.matches("\\s|\\t")) {
                            if (!element.isEmpty()) {
                                String token = "<" + element + "," + elementDescription(element) + "> " + "<" + character + "," + elementDescription(character) + "> ";
                                output.append(token);
                            } else {
                                String token = "<" + character + "," + elementDescription(character) + "> ";
                                output.append(token);
                            }
                        } else {
                            if (!element.isEmpty()) {
                                String token = "<" + element + "," + elementDescription(element) + "> ";
                                output.append(token);
                            }
                        }
                        element = "";
                    }
                }
            }
            output.append("\n");
        }
        cleanOutput();
    }

    private void cleanOutput() {
        String code = output.getText();
        String[] elements = code.split("\n");
        output.setText("");
        for (String element : elements) {
            if (!element.matches("\\s*|\\t*")) {
                output.append(element.trim() + "\n");
            }
        }
    }

    private void clean() {
        input.setText("");
        output.setText("");
    }

    private String elementDescription(String line) {
        String description = "value";
        for (Element element : elements) {
            if (element.getValue().equals(line)) {
                description = element.getDescription();
                break;
            }
        }
        return description;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Compiler().setVisible(true);
        });
    }

    //<editor-fold defaultstate="collapsed" desc="Element inner class">
    class Element {

        private String value;
        private String description;

        public Element(String value, String description) {
            this.value = value;
            this.description = description;
        }

        public Element() {

        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }
    //</editor-fold>


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analize;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton clean;
    private javax.swing.JPanel container;
    private javax.swing.JButton example;
    private javax.swing.JPanel footerContainer;
    private javax.swing.JTextArea input;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea lineCounterBottom;
    private javax.swing.JTextArea lineCounterUp;
    private javax.swing.JTextArea output;
    private javax.swing.JPanel upPanel;
    // End of variables declaration//GEN-END:variables
}
