/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author angelponce
 */
public class Compiler extends javax.swing.JFrame {

    /**
     * Creates new form Phase1
     */
    public Compiler() {
        //Chose layout
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Error al cargar el layout");
        }
        initComponents();
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
        leftPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        input = new javax.swing.JTextArea();
        rightPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        footerContainer = new javax.swing.JPanel();
        analize = new javax.swing.JButton();
        clean = new javax.swing.JButton();
        example = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fase 1");
        setMinimumSize(new java.awt.Dimension(320, 200));

        container.setLayout(new java.awt.GridBagLayout());

        jSplitPane1.setResizeWeight(0.5);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(800, 400));

        leftPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Código"));
        leftPanel.setLayout(new java.awt.BorderLayout());

        input.setColumns(20);
        input.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        input.setForeground(new java.awt.Color(0, 204, 0));
        input.setRows(5);
        jScrollPane1.setViewportView(input);

        leftPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(leftPanel);

        rightPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Palabras"));
        rightPanel.setLayout(new java.awt.BorderLayout());

        output.setEditable(false);
        output.setColumns(20);
        output.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        output.setForeground(new java.awt.Color(0, 101, 251));
        output.setRows(5);
        jScrollPane2.setViewportView(output);

        rightPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(rightPanel);

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
        input.setText("");
        output.setText("");
    }//GEN-LAST:event_cleanActionPerformed

    private void analizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizeActionPerformed
        output.setText("");
        String code = input.getText().trim(); //delete front an back null spaces
        String[] linesCode = code.split("\n");
        for (String line : linesCode) {
            line = line += " "; //Ask to engineer Macz
            String element = "";
            for (int i = 0; i < line.length(); i++) {
                String character = String.valueOf(line.charAt(i));
                if (character.matches("\\w")) {
                    element += character;
                } else {
                    output.append(element + "\n" + character + "\n");
                    element = "";
                }
            }
        }
        cleanOutput();
    }//GEN-LAST:event_analizeActionPerformed

    private void exampleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exampleActionPerformed
        input.setText("\n\n\n\nint x;\ndouble y;\nint m=3;\n");
        output.setText("");
    }//GEN-LAST:event_exampleActionPerformed

    private void cleanOutput() {
        String code = output.getText();
        String[] elements = code.split("\n");
        output.setText("");
        for (String element : elements) {
            if (!element.matches("\\s*|\\t*")) {
                output.append(element + "\n");
            }
        }
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Compiler().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analize;
    private javax.swing.JButton clean;
    private javax.swing.JPanel container;
    private javax.swing.JButton example;
    private javax.swing.JPanel footerContainer;
    private javax.swing.JTextArea input;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JTextArea output;
    private javax.swing.JPanel rightPanel;
    // End of variables declaration//GEN-END:variables
}