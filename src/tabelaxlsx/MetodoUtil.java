package tabelaxlsx;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXTable;

//Retorna a data de hoje
public class MetodoUtil {

    static SimpleDateFormat formatoData = null;
    static DateFormat dateFormat = null;

    //----------------------------data------------------------------------
    public static Date dataHoje() throws ParseException {
        //retorna a data atual
        formatoData = new SimpleDateFormat("yyyy/MM/dd");
        return formatoData.parse(formatoData.format(new Date()));
    }

    public static boolean validarData(String data) {
        try {
            dateFormat = DateFormat.getDateInstance();
            dateFormat.setLenient(false);
            dateFormat.parse(data);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    public static Date stringToDate(String text) throws ParseException {
        //Retorna uma string com a data ano,mes e dia
        formatoData = new SimpleDateFormat("yyyy/MM/dd");
        formatoData.setLenient(false);
        dateFormat = DateFormat.getDateInstance();
        dateFormat.setLenient(false);
        Date data = dateFormat.parse(text);
        data = dateFormat.parse(text);
        return data;
    }

    public static String dateToString(Date date) throws ParseException {
        //Retorna uma string com a data ano,mes e dia
        formatoData = new SimpleDateFormat("dd/MM/yyyy");
        return formatoData.format(date);
    }

    //retorna a data de hoje com a data dia,mes e ano
    public static String somarData(Date data, int mais) throws ParseException {

        data.setDate(data.getDate() + mais);
        formatoData = new SimpleDateFormat("dd/MM/yyyy");
        return formatoData.format(data);

    }

    //------------------------------valor------------------------------------------
    static DecimalFormat decimalformat = new DecimalFormat("#,###.00");

//    public static String dividirValor(String valor, int divisor) throws ParseException {
//
//        Double a = Double.parseDouble(String.valueOf(NumberFormat.getIntegerInstance().parse(valor))) / divisor;
//        return decimalformat.format(a);
//    }
    public static String valorInteiro(String valor) throws ParseException {
        if (valor != "") {
            return String.valueOf(NumberFormat.getIntegerInstance().parse(valor));
        } else {
            return "";
        }
    }

    public static BigDecimal stringToBigDecimal(String valor) throws ParseException {
        return new BigDecimal(String.valueOf(NumberFormat.getNumberInstance().parse(valor)));
    }

    public static String bigDecimalToString(BigDecimal valor) {
        try {
            return decimalformat.format(valor);
        } catch (Exception e) {
            return null;
        }
    }

    public static double stringToDouble(String valor) throws ParseException {
        if (valor != null) {
            return Double.parseDouble(String.valueOf(NumberFormat.getNumberInstance().parse(valor)));
        } else {
            return 0;
        }
    }

    public static String doubleToString(Double valor) {
        try {
            return decimalformat.format(valor);
        } catch (Exception e) {
            return null;
        }
    }
    

    //---------------------------MASCARA------------------------------------------------------
    public MaskFormatter mascara(String tipo) throws ParseException {
        MaskFormatter formato = null;
        // TODO add your handling code here:
        if (tipo.equals("fisica")) {
            formato = new MaskFormatter("###.###.###-##");
        } else if (tipo.equals("juridica")) {
            formato = new MaskFormatter("##.###.###/####-##");
        }
        return formato;
    }

    //-----------------pesquisar diretório-----------------------------------------
    public String getResourceDoClasspath(JFrame frame, String nomeArquivo) {
        File file = new File(frame.getClass().getClassLoader().getResource(nomeArquivo).getFile());
        return file.toPath().toString();
    }

//----------------------------Tabela----------------------------------------------
//    public static void colorirTabela(JTable jTable) {
//        //colore a tabela, vermelho para não quitados e azul para quitados
//        jTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable table,
//                    Object value,
//                    boolean isSelected,
//                    boolean hasFocus,
//                    int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setForeground(Color.white);
//                    setBackground(new Color(45, 118, 178));
//                } else {
//                    setBackground(new Color(31, 154, 255));
//                    setForeground(Color.white);
//                }
//                return this;
//            }
//        });jSpinner
//    }    
    public static void limparCampos(JPanel panel) {
        Component[] components = panel.getComponents();

        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JFormattedTextField) {
                ((JFormattedTextField) component).setFocusLostBehavior(JFormattedTextField.COMMIT);
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            } else if (component instanceof JXLabel) {
                ((JXLabel) component).setText("");
            } else if (component instanceof JSpinner) {
                ((JSpinner) component).setValue(0);
            } else if (component instanceof JTextArea) {
                ((JTextArea) component).setText("");
            }
        }
    }

    public static void habilitarCampos(JPanel panel, boolean opcao) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setEnabled(opcao);
            } else if (component instanceof JFormattedTextField) {
                component.setEnabled(opcao);
            } else if (component instanceof JComboBox) {
                component.setEnabled(opcao);
            } else if (component instanceof JSpinner) {
                ((JSpinner) component).setEnabled(opcao);
            } else if (component instanceof JTextArea) {
                ((JTextArea) component).setEnabled(opcao);
            } else if (component instanceof JButton) {
                ((JButton) component).setEnabled(opcao);
            }
        }
    }

    public static void habilitarBotao(JPanel panel, boolean novo, boolean salvar, boolean alterar, boolean excluir, boolean pesquisar) {
        Component[] components = panel.getComponents();

        for (Component component : components) {
            if (component instanceof JXButton) {
                switch (((JXButton) component).getToolTipText()) {
                    case "Salvar":
                        if (salvar == false) {
                            component.setEnabled(salvar);
                            component.setBackground(new Color(131, 45, 33));
                        } else {
                            component.setEnabled(salvar);
                            component.setBackground(new Color(102, 102, 255));
                        }
                        break;
                    case "Alterar":
                        if (alterar == false) {
                            component.setEnabled(alterar);
                            component.setBackground(new Color(131, 45, 33));
                        } else {
                            component.setEnabled(alterar);
                            component.setBackground(new Color(102, 102, 255));
                        }
                        break;
                    case "Excluir":
                        if (excluir == false) {
                            component.setEnabled(excluir);
                            component.setBackground(new Color(131, 45, 33));
                        } else {
                            component.setEnabled(excluir);
                            component.setBackground(new Color(102, 102, 255));
                        }
                        break;
                    case "Pesquisar":
                        if (pesquisar == false) {
                            component.setEnabled(pesquisar);
                            component.setBackground(new Color(131, 45, 33));
                        } else {
                            component.setEnabled(pesquisar);
                            component.setBackground(new Color(102, 102, 255));
                        }
                        break;
                    case "Novo":
                        if (pesquisar == false) {
                            component.setEnabled(novo);
                            component.setBackground(new Color(131, 45, 33));
                        } else {
                            component.setEnabled(pesquisar);
                            component.setBackground(new Color(102, 102, 255));
                        }
                        break;
                }
            }
        }
    }

    public static void alterarNomeColuna(JTable table, String nome, int coluna) {
        table.getColumnModel().getColumn(coluna).setHeaderValue(nome);
        table.getTableHeader().resizeAndRepaint();
    }

    public static void limparTabela(JXTable tabela) {

        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

    }

//    public static void preencherCombo(JComboBox, List<Object> lista){
//        
//    }
}
