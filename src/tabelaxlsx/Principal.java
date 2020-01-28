/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelaxlsx;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author jr
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Principal() {
        initComponents();

        jTableDados.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTableDados.getTableHeader().setOpaque(false);
        jTableDados.getTableHeader().setBackground(new Color(32, 136, 203));
        jTableDados.getTableHeader().setForeground(new Color(255, 255, 255));
        jTableDados.setRowHeight(25);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDados = new javax.swing.JTable();
        jButtonProcurar = new javax.swing.JButton();
        jTextFieldCaminho = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonGerar = new javax.swing.JButton();
        jTextFieldEmpresa = new javax.swing.JFormattedTextField();
        Status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Importação de Arquivos Excel");
        setResizable(false);

        jTableDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATA", "DOCUMENTO", "HISTORICO", "VALOR", "D/C", "DEBITO", "TERCEIRO", "CREDITO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableDados);
        if (jTableDados.getColumnModel().getColumnCount() > 0) {
            jTableDados.getColumnModel().getColumn(0).setResizable(false);
            jTableDados.getColumnModel().getColumn(1).setResizable(false);
            jTableDados.getColumnModel().getColumn(2).setResizable(false);
            jTableDados.getColumnModel().getColumn(3).setResizable(false);
            jTableDados.getColumnModel().getColumn(4).setResizable(false);
            jTableDados.getColumnModel().getColumn(5).setResizable(false);
            jTableDados.getColumnModel().getColumn(6).setResizable(false);
            jTableDados.getColumnModel().getColumn(7).setResizable(false);
        }

        jButtonProcurar.setText("Procurar arquivo .XLS ou XLSX");
        jButtonProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProcurarActionPerformed(evt);
            }
        });
        jButtonProcurar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonProcurarKeyPressed(evt);
            }
        });

        jTextFieldCaminho.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextFieldCaminho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldCaminho.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Importação de extratos Excel");

        jLabel2.setText("Digite o código da empresa");

        jButtonGerar.setText("Gerar arquivo .txt");
        jButtonGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarActionPerformed(evt);
            }
        });

        try {
            jTextFieldEmpresa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldEmpresaKeyPressed(evt);
            }
        });

        Status.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextFieldCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonProcurar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jButtonGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProcurarActionPerformed
        // TODO add your handling code here:
        limparTabela(jTableDados);
        DecimalFormat decimalFormat = new DecimalFormat("00000");

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.showOpenDialog(this);
        File f = fc.getSelectedFile();
        jTextFieldCaminho.setText(f.getPath());

        FileInputStream fisPlanilha = null;
        try {

            fisPlanilha = new FileInputStream(f);

            //cria um workbook = planilha toda com todas as abas
            XSSFWorkbook workbook = new XSSFWorkbook(fisPlanilha);

            //recuperamos apenas a primeira aba ou primeira planilha
            XSSFSheet sheet = workbook.getSheetAt(0);

            //retorna todas as linhas da planilha 0 (aba 1)
            Iterator<Row> rowIterator = sheet.iterator();

            //varre todas as linhas da planilha 0
            while (rowIterator.hasNext()) {

                //recebe cada linha da planilha
                Row row = rowIterator.next();

                DefaultTableModel modelo = (DefaultTableModel) jTableDados.getModel();
                if (!row.equals("")) {
                    try {
                        modelo.addRow(new Object[]{
                            CelulaData(row.getCell(0)),
                            CelulaValorInteiroDocumento(row.getCell(1)),
                            CelulaValorInteiroDocumento(row.getCell(2)),
                            CelulaValor(row.getCell(3)),
                            CelulaValorInteiroDocumento(row.getCell(4)),
                            decimalFormat.format(new BigDecimal(row.getCell(5).getNumericCellValue()).toBigInteger()),
                            row.getCell(6),
                            decimalFormat.format(new BigDecimal(row.getCell(7).getNumericCellValue()).toBigInteger()),});
                    } catch (Exception e) {
                        e.printStackTrace();
                        Status.setText("Ocorreu um erro ao gerar o arquivo");
                    }

                }
                //pegamos todas as celulas desta linha
//                Iterator<Cell> cellIterator = row.iterator();
//
//                //varremos todas as celulas da linha atual
//                while (cellIterator.hasNext()) {
//
//                    //criamos uma celula
//                    Cell cell = cellIterator.next();
//
//                    switch (cell.getCellType()) {
//
//                        case Cell.CELL_TYPE_STRING:
//                            System.out.println("TIPO STRING: " + cell.getStringCellValue());
//                            break;
//
//                        case Cell.CELL_TYPE_NUMERIC:
//                            System.out.println("TIPO NUMERICO: " + cell.getNumericCellValue());
//                            break;
//
//                        case Cell.CELL_TYPE_FORMULA:
//                            System.out.println("TIPO FORMULA: " + cell.getCellFormula());
//                    }
//
//                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fisPlanilha.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao gerar o arquivo");
            }
        }


    }//GEN-LAST:event_jButtonProcurarActionPerformed

    private void jButtonGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarActionPerformed
        // TODO add your handling code here:
        BufferedWriter buffWrite = null;

        //String path = ("P:/ProEmp00/CTB/CTBLCTOS" + jTextFieldEmpresa.getText() + ".txt");
        String path = ("C:/ArquivosTXT/CTBLCTOS" + jTextFieldEmpresa.getText() + ".txt");
        File file = new File(path);
        if (file.exists()) {
            if (JOptionPane.showConfirmDialog(this, "O arquivo já existe, deseja excluí-lo", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                file.delete();
            }
        }
        try {

            buffWrite = new BufferedWriter(new FileWriter(path));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao gerar o arquivo");
        }
        for (int i = 0; i < jTableDados.getRowCount(); i++) {

            try {
                DecimalFormat formatoCodigo = new DecimalFormat("00000");
                DecimalFormat formatoValor = new DecimalFormat("0000000000000.00");
                SimpleDateFormat formatoData = new SimpleDateFormat("ddMMyyyy");
                StringBuilder string = new StringBuilder();

                //String linha = "";
                //Scanner in = new Scanner(System.in);
                //System.out.println("Escreva algo: ");
                //linha = in.nextLine();
                string.append("LC1");
                string.append(formatoCodigo.format(i + 1));
                string.append("   ");
                string.append(1);
                string.append(formatoData.format(MetodoUtil.stringToDate(jTableDados.getValueAt(i, 0).toString())));
                if (jTableDados.getValueAt(i, 1) != null) {
                    String numeroDocumento = String.format("%-10.10s", jTableDados.getValueAt(i, 1).toString());
                    string.append(numeroDocumento);
                } else {
                    string.append("          ");
                }
                string.append("     ");
                string.append("                              ");
                string.append("   ");
                string.append(jTableDados.getValueAt(i, 5).toString());
                if (jTableDados.getValueAt(i, 6) != null) {
                    String terceiroDebito = String.format("%-14.14s", jTableDados.getValueAt(i, 6).toString());
                    string.append(terceiroDebito);
                } else {
                    string.append("              ");
                }
                string.append("     ");
                string.append(jTableDados.getValueAt(i, 7).toString());
                string.append("              ");
                System.out.println(MetodoUtil.stringToBigDecimal(jTableDados.getValueAt(i, 3).toString()));
                string.append("     ");
                string.append(String.format("%016.2f", MetodoUtil.stringToBigDecimal(jTableDados.getValueAt(i, 3).toString())).replace(",", "."));
                string.append(jTableDados.getValueAt(i, 2));
                buffWrite.append(string);
                buffWrite.newLine();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao gerar o arquivo");
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao gerar o arquivo");
            }
        }
        try {
            JOptionPane.showMessageDialog(this, "Arquivo construido com sucesso" + path);
            buffWrite.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao carregar o arquivo");
        }


    }//GEN-LAST:event_jButtonGerarActionPerformed

    private void jTextFieldEmpresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmpresaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButtonProcurar.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldEmpresaKeyPressed

    private void jButtonProcurarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonProcurarKeyPressed
        // TODO add your handling code here:
        ActionEvent evento = null;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButtonProcurarActionPerformed(evento);
        }
    }//GEN-LAST:event_jButtonProcurarKeyPressed

    public String CelulaData(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING: {
                try {
                    return MetodoUtil.dateToString(MetodoUtil.stringToDate(cell.getStringCellValue()));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    Status.setText("Ocorreu um erro na linha " + cell.getRowIndex() + 1);
                }
            }
            default:
                try {
                    return MetodoUtil.dateToString(cell.getDateCellValue());
                } catch (Exception e) {
                    e.printStackTrace();
                    Status.setText("Ocorreu um erro na linha " + cell.getRowIndex() + 1);
                }
        }
        return null;
    }

    public Object CelulaValor(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                try {
                    if (cell.getNumericCellValue() > 0.0) {
                        return MetodoUtil.bigDecimalToString(new BigDecimal(cell.getNumericCellValue()));
                    } else {
                        return MetodoUtil.bigDecimalToString(new BigDecimal(cell.getNumericCellValue()).multiply(new BigDecimal(-1)));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Status.setText("Ocorreu um erro na linha " + cell.getRowIndex() + 1);
                }
        }
        return null;
    }

    public Object CelulaValorInteiroDocumento(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: {
                try {
                    return new BigDecimal(cell.getNumericCellValue()).toBigInteger();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Status.setText("Ocorreu um erro na linha " + cell.getRowIndex() + 1);
                }
            }
            case Cell.CELL_TYPE_BLANK:
                return "";

            default:
                try {
                    return cell.getStringCellValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    Status.setText("Ocorreu um erro na linha " + cell.getRowIndex() + 1);
                }
        }
        return null;
    }

    public static void limparTabela(JTable tabela) {

        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

    }

    public double retornarDifNull(Cell cell) {
        try {
            Double valor = cell.getNumericCellValue();
            return valor;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Status;
    private javax.swing.JButton jButtonGerar;
    private javax.swing.JButton jButtonProcurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDados;
    private javax.swing.JTextField jTextFieldCaminho;
    private javax.swing.JFormattedTextField jTextFieldEmpresa;
    // End of variables declaration//GEN-END:variables
}
