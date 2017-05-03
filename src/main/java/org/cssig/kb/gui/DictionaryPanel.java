/**
 * @author Vasyl Lyashkevych
 */
package org.cssig.kb.gui;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.LayoutStyle;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import static org.cssig.kb.gui.ToolBar.things;
import static org.cssig.kb.gui.ToolBar.pathDField;
import static org.cssig.kb.gui.ToolBar.rowTemplate;
import static org.cssig.kb.gui.ToolBar.showMessBox;
import static org.cssig.kb.json.BuildJsonProperty.getJsonSchemaGenerator;
import static org.cssig.kb.gui.TextAnalysis.comboBox1;
import static org.cssig.kb.gui.TextAnalysis.comboBox10;
import static org.cssig.kb.gui.TextAnalysis.comboBox11;
import static org.cssig.kb.gui.TextAnalysis.comboBox12;
import static org.cssig.kb.gui.TextAnalysis.comboBox2;
import static org.cssig.kb.gui.TextAnalysis.comboBox3;
import static org.cssig.kb.gui.TextAnalysis.comboBox4;
import static org.cssig.kb.gui.TextAnalysis.comboBox5;
import static org.cssig.kb.gui.TextAnalysis.comboBox6;
import static org.cssig.kb.gui.TextAnalysis.comboBox7;
import static org.cssig.kb.gui.TextAnalysis.comboBox8;
import static org.cssig.kb.gui.TextAnalysis.comboBox9;
import static org.cssig.kb.gui.ToolBar.jToolTabPanel;
import org.cssig.kb.util.FNManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// The main class of dictionary panel
//==============================================================================
public class DictionaryPanel extends JPanel {

    public static int maxColRow = 101;

    public static int newKeyw = 0;
    private boolean dictionaryState;
    private boolean singlemode = false;
    private final int maxTabl = 200;

    private static String fileDictName;
    public static String keywSValue;
    public static String keywOValue;
    public static String nameValue;

    public static int intkeywords = 0;

    private final int colDictWidth = 300;
    private final int TIW = 30;
    private final int colTablWidth = 260;
    private String[] nKrow = new String[maxTabl];
    private int intTemp = 0;

    private final JLabel label1 = new JLabel("Entity/Property", JButton.LEFT);
    private final JLabel label2 = new JLabel("Entities", JButton.CENTER);
    private final JLabel filterLabel = new JLabel("Filter to", JButton.LEFT);

    private javax.swing.JTextField keywField;

    private final JPanel dictThingPanel = new JPanel();
    private final JPanel tablThingPanel = new JPanel();
    private final JPanel entThingPanel = new JPanel();
    private final JPanel paneThingPanel = new JPanel();

    private JScrollPane jScrollThingDictPane = null;
    private JScrollPane jScrollThingTablPane = null;
    private JScrollPane jScrollThingKeywPane = null;
    private JScrollPane jMainThingScrollPane = null;

    private javax.swing.JCheckBox formatCheckBox;

    private static final String[] conceptType = new String[]{"-", "isType", "isProperty"};
    public static JComboBox<String> filterComboBox;

    public static JTable jTableThingDictionary = null;
    public static JTable jTableThingPlenty = null;
    public static JTable jTableThingKeywords = null;
    private DefaultTableModel mdataTableThingKeywords = null;
    private DefaultTableModel mdataThingDictionary = null;
    private DefaultTableModel mdataThingTablePlenty = null;

    private final JButton updateButton = new JButton("Update tables");
    private final JButton addKeywButton = new JButton("add to Dictionary");
    private final JButton saveDictButton = new JButton("save Dictionary");
    private final JButton filterButton = new JButton("To filter");

    private final JButton jButton1 = new JButton("load Dictionary");
    private final JButton jButton2 = new JButton("Add selected keywords from inforamtion resource to Dictionary");
    private final JButton jButton3 = new JButton("Concepts without relations");
    private final JButton jButton4 = new JButton("Correct concept in ontology");
    private final JButton jButton5 = new JButton("Delete selected concept");
    private final JButton jButton6 = new JButton("new Resourse");
    private final JButton jButton10 = new JButton("JsonGen");
    private final JButton jButton7 = new JButton("Save changes to the dictionary");
    private final JButton jButton8 = new JButton("Clear all marks");
    private final JButton jButton9 = new JButton("To add new type of relations");

    // Constructor implementation
    //==========================================================================  
    public DictionaryPanel() {
        this.formatCheckBox = new JCheckBox("XML/JSON");
        this.formatCheckBox.setSelected(false);
        formatCheckBox.addActionListener((ActionEvent e) -> {
            if (formatCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(null, "The XML format is choosen !");
            } else {
                JOptionPane.showMessageDialog(null, "The JSON format is choosen !");
            }
        });

        this.dictionaryState = true;
        jButton1.setBackground(Color.GRAY);
        jButton4.setBackground(Color.PINK);
        jButton5.setBackground(Color.PINK);
        saveDictButton.setBackground(Color.GRAY);
        jButton2.setBackground(Color.ORANGE);
        jButton7.setBackground(Color.CYAN);
        jButton9.setBackground(Color.CYAN);

        keywField = new javax.swing.JTextField();

        this.filterComboBox = new JComboBox<>(conceptType);

        initActionDP();
    }

    // Interface implementation
    //==========================================================================  
    public JPanel getThingDictionaryPane(JPanel mainPanel) {
        jMainThingScrollPane = new JScrollPane();
        jMainThingScrollPane.setBackground(Color.LIGHT_GRAY);

        GroupLayout layout1 = new GroupLayout(dictThingPanel);
        dictThingPanel.setLayout(layout1);
        layout1.setHorizontalGroup(layout1.createSequentialGroup()
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(keywField, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addKeywButton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(filterLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addComponent(filterComboBox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(filterButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(getDictThingScrollPane(), GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE))
                )
        );
        layout1.setVerticalGroup(layout1.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(keywField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addKeywButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(20, 20, 20)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(filterLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(20, 20, 20)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(getDictThingScrollPane(), GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(20, 20, 20)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
        );

        GroupLayout layout2 = new GroupLayout(tablThingPanel);
        tablThingPanel.setLayout(layout2);
        layout2.setHorizontalGroup(layout2.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                        .addComponent(getTablScrollPane(), GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE))
        );
        layout2.setVerticalGroup(layout2.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10, 10, 10)
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(getTablScrollPane(), GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10, 10, 10)
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                )
        );

        GroupLayout layout3 = new GroupLayout(entThingPanel);
        entThingPanel.setLayout(layout3);
        layout3.setHorizontalGroup(layout3.createSequentialGroup()
                .addGroup(layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 1380, GroupLayout.PREFERRED_SIZE)
                        .addComponent(getThingKeywScrollPane(), GroupLayout.PREFERRED_SIZE, 1380, GroupLayout.PREFERRED_SIZE))
        );
        layout3.setVerticalGroup(layout3.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(20, 20, 20)
                .addGroup(layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(getThingKeywScrollPane(), GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                )
        );

        GroupLayout layout0 = new GroupLayout(paneThingPanel);
        paneThingPanel.setLayout(layout0);
        layout0.setHorizontalGroup(layout0.createSequentialGroup()
                .addGroup(layout0.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout0.createSequentialGroup()
                                .addComponent(dictThingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tablThingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout0.createSequentialGroup()
                                .addComponent(entThingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
        );
        layout0.setVerticalGroup(layout0.createSequentialGroup()
                .addGroup(layout0.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(dictThingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(tablThingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(20, 20, 20)
                .addGroup(layout0.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(entThingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
        );

        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(formatCheckBox, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveDictButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(paneThingPanel, GroupLayout.PREFERRED_SIZE, 1450, GroupLayout.PREFERRED_SIZE))
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(formatCheckBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveDictButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(paneThingPanel, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
                )
        );

        jMainThingScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Interconnectedness between dictionary and concept's presentations"));
        jMainThingScrollPane.setViewportView(mainPanel);
        jMainThingScrollPane.setVisible(true);

        return mainPanel;
    }

    //==========================================================================
    //  Table's functions for procession
    //==========================================================================
    private JScrollPane getDictThingScrollPane() {
        if (jScrollThingDictPane == null) {
            jScrollThingDictPane = new JScrollPane();
            jScrollThingDictPane.setRowHeaderView(getTableThingDictionary());
            jScrollThingDictPane.setViewportView(getTableThingDictionary());
        }
        return jScrollThingDictPane;
    }

    private JTable getTableThingDictionary() {
        if (jTableThingDictionary == null) {
            String[] headDict = new String[maxTabl + 1];
            headDict[0] = "A list of concepts";
            int j = 1;
            int k = 0;
            do {
                headDict[j] = String.valueOf("S" + k);
                headDict[j + 1] = String.valueOf("O" + k);
                k++;
                j += 2;
            } while (k <= (Integer) maxTabl / 2 - 1);

            mdataThingDictionary = new DefaultTableModel(headDict, 0);

            for (int i = 0; i < intkeywords; i++) {
                mdataThingDictionary.addRow(rowTemplate);
            }

            jTableThingDictionary = new JTable(mdataThingDictionary);
            jTableThingDictionary.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            jTableThingDictionary.setSelectionForeground(Color.BLUE);
            jTableThingDictionary.setSelectionBackground(Color.yellow);

            jTableThingDictionary.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (evt.getButton() == MouseEvent.BUTTON1) {
                        int row = jTableThingDictionary.rowAtPoint(evt.getPoint());
                        //    int col = jTableDictionary.columnAtPoint(evt.getPoint());

                        for (int j = 0; j < jTableThingPlenty.getRowCount(); j++) {
                            jTableThingPlenty.isCellEditable(j, 2);
                            jTableThingPlenty.getModel().setValueAt("", j, 2);
                            jTableThingPlenty.isCellEditable(j, 3);
                            jTableThingPlenty.getModel().setValueAt("", j, 3);
                        }
                        jTableThingDictionary.getSelectedRow();
                        int j = 1;
                        do {
                            int ir = (Integer) j / 2;
                            if (jTableThingDictionary.getValueAt(row, j).equals("X")) {
                                jTableThingPlenty.isCellEditable(ir, 2);
                                jTableThingPlenty.setValueAt("X", ir, 2);
                            }
                            if (jTableThingDictionary.getValueAt(row, j + 1).equals("X")) {
                                jTableThingPlenty.isCellEditable(ir, 3);
                                jTableThingPlenty.setValueAt("X", ir, 3);
                            }
                            j += 2;
                            //    JOptionPane.showMessageDialog(null, ""+j);
                        } while (j < (jTableThingPlenty.getRowCount() * 2 + 1));
                        //                      }
                        jTableThingDictionary.repaint();
                        jTableThingDictionary.updateUI();
                        jTableThingPlenty.repaint();
                        jTableThingPlenty.updateUI();
                    }
                }
            });

            jTableThingDictionary.setColumnSelectionAllowed(false);
            jTableThingDictionary.setRowSelectionAllowed(true);
            jTableThingDictionary.setAutoscrolls(true);
            jTableThingDictionary.getColumnModel().getColumn(0).setPreferredWidth(colDictWidth);
            for (int i = 1; i <= maxTabl; i++) {
                jTableThingDictionary.getColumnModel().getColumn(i).setPreferredWidth(TIW);
            }
        }
        return jTableThingDictionary;
    }

    private JScrollPane getTablScrollPane() {
        if (jScrollThingTablPane == null) {
            jScrollThingTablPane = new JScrollPane();
            jScrollThingTablPane.setRowHeaderView(getTables());
            jScrollThingTablPane.setViewportView(getTables());
        }
        return jScrollThingTablPane;
    }

    private JTable getTables() {
        if (jTableThingPlenty == null) {
            mdataThingTablePlenty = new DefaultTableModel(new String[]{"Triple's name", "Type of relations", "S", "O"}, 0);
            for (int i = 0; i < 1; i++) {
                mdataThingTablePlenty.addRow(new String[]{"", "", "", ""});
            }

            jTableThingPlenty = new JTable(mdataThingTablePlenty);
            jTableThingPlenty.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            jTableThingPlenty.setColumnSelectionAllowed(false);
            jTableThingPlenty.setRowSelectionAllowed(true);

            jTableThingPlenty.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (evt.getButton() == MouseEvent.BUTTON1) {
                        int row = jTableThingPlenty.rowAtPoint(evt.getPoint());
                        int col = jTableThingPlenty.columnAtPoint(evt.getPoint());
                        if (col > 1) {
                            jTableThingPlenty.isCellEditable(row, col);
                            if (jTableThingPlenty.getModel().getValueAt(row, col).toString().equals("X")) {
                                jTableThingPlenty.isCellEditable(row, col);
                                jTableThingPlenty.getModel().setValueAt("", row, col);
                            } else {
                                jTableThingPlenty.isCellEditable(row, col);
                                jTableThingPlenty.getModel().setValueAt("X", row, col);
                            }

                        }
                        jTableThingPlenty.repaint();
                        jTableThingPlenty.updateUI();
                    }
                }
            });

            jTableThingPlenty.setAutoscrolls(true);
            jTableThingPlenty.getColumnModel().getColumn(0).setPreferredWidth(colTablWidth);
            jTableThingPlenty.getColumnModel().getColumn(1).setPreferredWidth(colTablWidth);
            jTableThingPlenty.getColumnModel().getColumn(2).setPreferredWidth(TIW);
            jTableThingPlenty.getColumnModel().getColumn(3).setPreferredWidth(TIW);
        }
        return jTableThingPlenty;
    }

    private JScrollPane getThingKeywScrollPane() {
        if (jScrollThingKeywPane == null) {
            jScrollThingKeywPane = new JScrollPane();
            jScrollThingKeywPane.setRowHeaderView(getThingKeywords());
            jScrollThingKeywPane.setViewportView(getThingKeywords());
        }
        return jScrollThingKeywPane;
    }

    private JTable getThingKeywords() {
        if (jTableThingKeywords == null) {
            String[] headKeyw = new String[maxTabl + 1];
            headKeyw[0] = "Found keywords";
            int j = 1;
            int k = 1;
            do {
                headKeyw[j] = String.valueOf("S" + k);
                headKeyw[j + 1] = String.valueOf("O" + k);
                k++;
                j += 2;
            } while (k <= (Integer) maxTabl / 2);

            mdataTableThingKeywords = new DefaultTableModel(headKeyw, 0);
            for (int i = 0; i < maxTabl; i++) {
                mdataTableThingKeywords.addRow(rowTemplate);
            }

            jTableThingKeywords = new JTable(mdataTableThingKeywords);
            jTableThingKeywords.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            jTableThingKeywords.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (evt.getButton() == MouseEvent.BUTTON1) {
                        int row = jTableThingKeywords.rowAtPoint(evt.getPoint());
                        int col = jTableThingKeywords.columnAtPoint(evt.getPoint());
                        if (col > 0 && col <= jTableThingPlenty.getRowCount() && row < newKeyw) {
                            jTableThingKeywords.isCellEditable(row, col);
                            if (jTableThingKeywords.getModel().getValueAt(row, col).toString().equals("X")) {
                                jTableThingKeywords.isCellEditable(row, col);
                                jTableThingKeywords.getModel().setValueAt("", row, col);
                            } else if (jTableThingKeywords.getModel().getValueAt(row, col).toString().equals("")) {
                                if (col % 2 == 0) {
                                    jTableThingKeywords.isCellEditable(row, col - 1);
                                    jTableThingKeywords.getModel().setValueAt("", row, col - 1);
                                    jTableThingKeywords.isCellEditable(row, col);
                                    jTableThingKeywords.getModel().setValueAt("X", row, col);
                                } else {
                                    jTableThingKeywords.isCellEditable(row, col + 1);
                                    jTableThingKeywords.getModel().setValueAt("", row, col + 1);
                                    jTableThingKeywords.isCellEditable(row, col);
                                    jTableThingKeywords.getModel().setValueAt("X", row, col);
                                }
                            }
                        }
                        jTableThingKeywords.repaint();
                        jTableThingKeywords.updateUI();
                    }
                }
            });

            jTableThingKeywords.setColumnSelectionAllowed(false);
            jTableThingKeywords.setRowSelectionAllowed(true);
            jTableThingKeywords.setAutoscrolls(true);
            jTableThingKeywords.getColumnModel().getColumn(0).setPreferredWidth(colDictWidth);
            for (int i = 1; i <= maxTabl; i++) {
                jTableThingKeywords.getColumnModel().getColumn(i).setPreferredWidth(TIW);
            }
        }
        return jTableThingKeywords;
    }

    public void doSearchEmptyKeyw() {
        int check;
        jTableThingDictionary.isEditing();
        for (int i = 0; i < jTableThingDictionary.getRowCount(); i++) {
            check = 0;
            jTableThingDictionary.setRowSelectionInterval(i, i);
            for (int j = 1; j < maxColRow; j++) {
                if (!jTableThingDictionary.getValueAt(i, j).equals("")) {
                    check++;
                }
            }
            if (check == 0) {
                if (showMessBox.isSelected()) {
                    jTableThingDictionary.scrollRectToVisible(jTableThingDictionary.getCellRect(i, 0, true));
                    JOptionPane.showMessageDialog(null, "The undetermined keyword is SELECTED !");
                }
                return;
            }
        }
        if (showMessBox.isSelected()) {
            JOptionPane.showMessageDialog(null, "The undetermined keyword don't find!");
        }
    }

    // To make visible the input types or properties
    //==========================================================================
    public static void scrollToVisible(JTable table, int rowIndex, int vColIndex) {
        if (!(table.getParent() instanceof JViewport)) {
            return;
        }
        JViewport viewport = (JViewport) table.getParent();

        // This rectangle is relative to the table where the
        // northwest corner of cell (0,0) is always (0,0).
        Rectangle rect = table.getCellRect(rowIndex, vColIndex, true);

        // The location of the viewport relative to the table
        Point pt = viewport.getViewPosition();

        // Translate the cell location so that it is relative
        // to the view, assuming the northwest corner of the
        // view is (0,0)
        rect.setLocation(rect.x - pt.x, rect.y - pt.y);

        table.scrollRectToVisible(rect);

        // Scroll the area into view
        //viewport.scrollRectToVisible(rect);
    }

    // To check input data
    //==========================================================================
    public void addKeywAction() {
        String keyw = keywField.getText();
        boolean keywexists = false;
        if (!keyw.equals("")) {
            for (int i = 0; i < jTableThingDictionary.getRowCount(); i++) {
                if (jTableThingDictionary.getModel().getValueAt(i, 0).toString().equals(keyw)) {
                    keywexists = true;
                    jTableThingDictionary.setRowSelectionInterval(i, i);
//                        scrollToVisible(jTableThingDictionary, i, 0);
                    jTableThingDictionary.scrollRectToVisible(jTableThingDictionary.getCellRect(i, 0, true));
                    if (showMessBox.isSelected()) {
                        JOptionPane.showMessageDialog(null, "The keywords \"" + keyw + "\" already exists into the dictionary");
                    }
                }
            }
            if (!keywexists) {
                mdataThingDictionary.addRow(rowTemplate);
                intkeywords = mdataThingDictionary.getRowCount();
                jTableThingDictionary.isCellEditable(intkeywords - 1, 0);
                mdataThingDictionary.setValueAt(keyw, intkeywords - 1, 0);
                jTableThingDictionary.setRowSelectionInterval(intkeywords - 1, intkeywords - 1);
                jTableThingDictionary.scrollRectToVisible(jTableThingDictionary.getCellRect(intkeywords - 1, 0, true));
                if (showMessBox.isSelected()) {
                    JOptionPane.showMessageDialog(null, "The keywords \"" + keyw + "\" just added to the dictionary");
                }
            }
        }
    }

    public void initActionDP() {

        filterButton.addActionListener((ActionEvent e) -> {
            /*          @Override
            public boolean include(Entry entry) {
                 // All rows are included if no filter is set
                 if (filterText.isEmpty())
                 return true;

                // If any of the column values contains the filter text,
                // the row can be shown
                for (int i = 0; i < entry.getValueCount(); i++) {
                    String value = entry.getStringValue(i);
                if (value.toLowerCase().indexOf(filterText) != -1)
                    return true;
                }

                return false;
            }
             */

        });

        updateButton.addActionListener((ActionEvent e) -> {
            jToolTabPanel.setSelectedIndex(2);
            things.setSelectedIndex(1);
        });

        jButton7.addActionListener((ActionEvent e) -> {
            int gsr = jTableThingDictionary.getSelectedRow();
            jTableThingDictionary.isEditing();
            for (int j = 1; j < jTableThingPlenty.getRowCount() * 2 + 1; j++) {
                jTableThingDictionary.setValueAt("", gsr, j);
            }
            for (int i = 0; i < jTableThingPlenty.getRowCount(); i++) {
                int ir = (Integer) i * 2 + 1;
                jTableThingPlenty.isCellEditable(i, 2);
                if (jTableThingPlenty.getModel().getValueAt(i, 2).toString().equals("X")) {
                    jTableThingDictionary.isCellEditable(gsr, ir);
                    jTableThingDictionary.setValueAt("X", gsr, ir);
                }
                jTableThingPlenty.isCellEditable(i, 3);
                if (jTableThingPlenty.getModel().getValueAt(i, 3).toString().equals("X")) {
                    jTableThingDictionary.isCellEditable(gsr, ir + 1);
                    jTableThingDictionary.setValueAt("X", gsr, ir + 1);
                }
            }
            jTableThingDictionary.repaint();
            jTableThingDictionary.updateUI();
        });

        jButton8.addActionListener((ActionEvent e) -> {
            for (int i = 0; i < jTableThingPlenty.getRowCount(); i++) {
                jTableThingPlenty.getModel().setValueAt("", i, 2);
                jTableThingPlenty.getModel().setValueAt("", i, 3);
            }
            jTableThingDictionary.repaint();
            jTableThingDictionary.updateUI();
        });

        jButton4.addActionListener((ActionEvent e) -> {
            String name = JOptionPane.showInputDialog(this, "Enter a new correct name:");
            int srow = jTableThingDictionary.getSelectedRow();
            jTableThingDictionary.getModel().setValueAt(name, srow, 0);
        });

        addKeywButton.addActionListener((ActionEvent e) -> {
            //  if (searchKeyw.isSelected()) {addKeywButtonActionPerformed(e);}
            //else{ 
            addKeywAction();
            //}
        });

        saveDictButton.addActionListener((ActionEvent e) -> {
            if (formatCheckBox.isSelected()) {
                doSaveXML();
            } else {
                try {
                    doSaveJSON();
                } catch (IOException ex) {
                    Logger.getLogger(DictionaryPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jButton3.addActionListener((ActionEvent e) -> {
            doSearchEmptyKeyw();
        });

        jButton5.addActionListener((ActionEvent e) -> {
            mdataThingDictionary.removeRow(jTableThingDictionary.getSelectedRow());
            intkeywords--;
        });

        jButton6.addActionListener((ActionEvent e) -> {
            doAnalysis();
        });

        jButton9.addActionListener((ActionEvent e) -> {
            mdataThingTablePlenty.addRow(new String[]{"", "", "", ""});
        });

        jButton1.addActionListener((ActionEvent e) -> {
            if (formatCheckBox.isSelected()) {
                doLoadXML();
            } else {
                doLoadJSON();
            }
        });

        jButton2.addActionListener((ActionEvent e) -> {
            // getJsonSchemaGenerator
        });

        jButton10.addActionListener((ActionEvent e) -> {
            getJsonSchemaGenerator();
        });

    }

    public void doAnalysis() {
        String[] nOfTables = new String[jTableThingPlenty.getRowCount() * 2];

        int k = 0;
        for (int i = 0; i < jTableThingPlenty.getRowCount(); i++) {
            jTableThingPlenty.setRowSelectionInterval(i, i);
            nOfTables[k++] = "O" + (i + 1) + " - >" + jTableThingPlenty.getModel().getValueAt(i, 0).toString() + " - " + jTableThingPlenty.getModel().getValueAt(i, 1).toString();
            nOfTables[k++] = "   p" + (i + 1) + " - >" + jTableThingPlenty.getModel().getValueAt(i, 0).toString() + " - " + jTableThingPlenty.getModel().getValueAt(i, 1).toString();
        }

        comboBox1.setModel(new DefaultComboBoxModel(nOfTables));
        comboBox2.setModel(new DefaultComboBoxModel(nOfTables));
        comboBox3.setModel(new DefaultComboBoxModel(nOfTables));
        comboBox4.setModel(new DefaultComboBoxModel(nOfTables));
        comboBox5.setModel(new DefaultComboBoxModel(nOfTables));
        comboBox6.setModel(new DefaultComboBoxModel(nOfTables));
        comboBox7.setModel(new DefaultComboBoxModel(nOfTables));
        comboBox8.setModel(new DefaultComboBoxModel(nOfTables));
        comboBox9.setModel(new DefaultComboBoxModel(nOfTables));
        comboBox10.setModel(new DefaultComboBoxModel(nOfTables));
        comboBox11.setModel(new DefaultComboBoxModel(nOfTables));
        comboBox12.setModel(new DefaultComboBoxModel(nOfTables));

        comboBox1.getModel().setSelectedItem("-");
        comboBox2.getModel().setSelectedItem("-");
        comboBox3.getModel().setSelectedItem("-");
        comboBox4.getModel().setSelectedItem("-");
        comboBox5.getModel().setSelectedItem("-");
        comboBox6.getModel().setSelectedItem("-");
        comboBox7.getModel().setSelectedItem("-");
        comboBox8.getModel().setSelectedItem("-");
        comboBox9.getModel().setSelectedItem("-");
        comboBox10.getModel().setSelectedItem("-");
        comboBox11.getModel().setSelectedItem("-");
        comboBox12.getModel().setSelectedItem("-");

        jToolTabPanel.setSelectedIndex(1);
    }

    private int ffindkeyw(String args) {
        int f = 0;
        do {
            jTableThingDictionary.setRowSelectionInterval(f, f);
            if (jTableThingDictionary.getModel().getValueAt(f, 0).toString().equals(args)) {
                return f;
            }
            f++;
        } while (f < jTableThingDictionary.getRowCount());
        f = -1;
        return f;
    }

    private void doSaveXML() {
        fileDictName = pathDField + "Dictionary.xml";
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Dictionary files", ".xml");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogTitle("Save the dictionary file");
        fileChooser.setSelectedFile(new File(fileDictName));
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileDictName = fileChooser.getSelectedFile().getAbsolutePath();
        }

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("dictionary");
            doc.appendChild(rootElement);

            Element tof = doc.createElement("typeof");
            rootElement.appendChild(tof);

            for (int i = 0; i < jTableThingPlenty.getRowCount(); i++) {
                jTableThingPlenty.setRowSelectionInterval(i, i);
                if (!jTableThingPlenty.getValueAt(i, 0).toString().equals("")) {

                    nameValue = jTableThingPlenty.getValueAt(i, 0).toString();
//                    Element obj = doc.createElement("object"); obj.appendChild(doc.createTextNode(nameValue)); tabl.appendChild(obj);
                    nameValue = nameValue + "|" + jTableThingPlenty.getValueAt(i, 1).toString();
                    Element tname = doc.createElement("tname");
                    tname.appendChild(doc.createTextNode(nameValue));
                    tof.appendChild(tname);
                    tname.setAttribute("id", String.valueOf(i));
                }
            }

            for (int i = 0; i < intkeywords; i++) {
                Element keyw = doc.createElement("concept");
                rootElement.appendChild(keyw);
                keyw.setAttribute("id", String.valueOf(i));

                jTableThingDictionary.setRowSelectionInterval(i, i);
                nameValue = jTableThingDictionary.getValueAt(i, 0).toString();
                Element namew = doc.createElement("con_name");
                namew.appendChild(doc.createTextNode(nameValue));
                keyw.appendChild(namew);

                int j = 0;
                do {
                    keywSValue = jTableThingDictionary.getValueAt(i, 2 * j + 1).toString();
                    keywOValue = jTableThingDictionary.getValueAt(i, 2 * j + 2).toString();
                    if (!keywSValue.equals("")) {
                        Element o = doc.createElement("subjectOf");
                        o.appendChild(doc.createTextNode(jTableThingPlenty.getValueAt(j, 1).toString()));
                        keyw.appendChild(o);
                    }
                    if (!keywOValue.equals("")) {
                        Element p = doc.createElement("objectOf");
                        p.appendChild(doc.createTextNode(jTableThingPlenty.getValueAt(j, 1).toString()));
                        keyw.appendChild(p);
                    }
                    //j+=2;    
                    j++;
                    if (j > jTableThingPlenty.getRowCount()) {
                        break;
                    }
                } while (j < (Integer) maxTabl / 2);
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File(fileDictName));
            transformer.transform(source, result);
            if (showMessBox.isSelected()) {
                dictionaryState = true;
                JOptionPane.showMessageDialog(null, "File saved!");
            }
        } catch (ParserConfigurationException | TransformerException pce) {
        }
    }

// To save in format XML
    //==================================================
    private void doLoadXML() {

        if (dictionaryState) {
            dictionaryState = false;
            for (int i = mdataThingDictionary.getRowCount(); i > 0; i--) {
                mdataThingDictionary.removeRow(0);
            }
            intkeywords = 0;
            fileDictName = pathDField + "Dictionary.xml";

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Open the dictionary file");
            FileFilter filter = new FileNameExtensionFilter("Dictionary files", ".xml");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(filter);
            fileChooser.setSelectedFile(new File(fileDictName));
            fileChooser.setVisible(true);
            int result = fileChooser.showOpenDialog(fileChooser);
            if (result == JFileChooser.APPROVE_OPTION) {
                fileDictName = fileChooser.getSelectedFile().getAbsolutePath();
            } else {
                return;
            }

            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();

                DefaultHandler handler = new DefaultHandler() {

                    boolean bdictionary = false;
                    boolean btypeof = false;
                    boolean btname = false;
                    boolean bconcept = false;
                    boolean bcon_name = false;
                    boolean bsubjectof = false;
                    boolean bobjectof = false;
                    int qtabl = 0;
                    String subjStr, objStr, sV = "";
                    StringBuilder sVs;
                    int position = 0;

                    @Override
                    public void startElement(String uri, String localName, String qName,
                            Attributes attributes) throws SAXException {

                        //	System.out.println("Start Element :" + qName);
                        sV = qName;

                        if (qName.equalsIgnoreCase("dictionary")) {
                            bdictionary = true;
                        }

                        if (qName.equalsIgnoreCase("typeof")) {
                            btypeof = true;
                        }

                        if (qName.equalsIgnoreCase("tname")) {
                            btname = true;
                        }

                        if (qName.equalsIgnoreCase("concept")) {
                            bconcept = true;
                        }

                        if (qName.equalsIgnoreCase("con_name")) {
                            bcon_name = true;
                        }

                        if (qName.startsWith("subjectOf")) {
                            bsubjectof = true;
                        }
                        if (qName.startsWith("objectOf")) {
                            bobjectof = true;
                        }

                    }

                    @Override
                    public void endElement(String uri, String localName,
                            String qName) throws SAXException {
                        //System.out.println("End Element :" + qName);
                    }

                    public void saveTuple(String strT) {
                        if (qtabl >= mdataThingTablePlenty.getRowCount()) {
                            mdataThingTablePlenty.addRow(new String[]{"", "", "", ""});
                        }
                        //  mdataTablePlenty.addRow(new String[]{"", "", "", ""});            
                        jTableThingPlenty.setRowSelectionInterval(qtabl, qtabl);
                        jTableThingPlenty.getModel().isCellEditable(qtabl, 0);
                        jTableThingPlenty.setValueAt(strT.substring(0, strT.indexOf("|")), qtabl, 0);
                        jTableThingPlenty.getModel().isCellEditable(qtabl, 1);
                        jTableThingPlenty.setValueAt(strT.substring(strT.indexOf("|") + 1, strT.length()), qtabl, 1);
                        qtabl++;
                    }

                    public void saveKeyw(String strT) {
//            if(intkeywords>mdataDictionary.getRowCount()) {mdataDictionary.addRow(rowTemplate);}
                        mdataThingDictionary.addRow(rowTemplate);
                        jTableThingDictionary.setRowSelectionInterval(intkeywords, intkeywords);
                        jTableThingDictionary.getModel().isCellEditable(intkeywords, 1);

                        jTableThingDictionary.setValueAt(strT, intkeywords, 0);
                        intkeywords++;
                    }

                    public void saveSRelation(int rO) {
                        jTableThingDictionary.getModel().isCellEditable(intkeywords - 1, rO);
                        jTableThingDictionary.setValueAt("X", intkeywords - 1, rO);
                    }

                    public void saveORelation(int rP) {
                        jTableThingDictionary.getModel().isCellEditable(intkeywords - 1, rP);
                        jTableThingDictionary.setValueAt("X", intkeywords - 1, rP);
                    }

                    @Override
                    public void characters(char ch[], int start, int length) throws SAXException {

                        if (bdictionary) {
                            //	System.out.println("dictionary : " + new String(ch, start, length));
                            bdictionary = false;
                        }

                        if (btypeof) {
                            //	System.out.println("id : " + new String(ch, start, length));
                            btypeof = false;
                        }

                        if (btname) {
                            //	System.out.println("tabl name  : " + new String(ch, start, length));
                            saveTuple(new String(ch, start, length));
                            btname = false;
                        }

                        if (bconcept) {
                            //	System.out.println("id : " + new String(ch, start, length));
                            bconcept = false;
                        }

                        if (bcon_name) {
                            //	System.out.println("keyw : " + new String(ch, start, length));
                            saveKeyw(new String(ch, start, length));
                            bcon_name = false;
                        }

                        if (bsubjectof) {
                            subjStr = new String(ch, start, length);
                            for (int i = 0; i < jTableThingPlenty.getRowCount(); i++) {
                                if (jTableThingPlenty.getValueAt(i, 1).toString().equals(subjStr)) {
//                                System.out.println(subjStr+"  - "+i);
                                    position = i;
                                }
                            }
                            position = position * 2 + 1;
                            saveSRelation(position);
                            bsubjectof = false;
                        }
                        if (bobjectof) {
                            objStr = new String(ch, start, length);
                            for (int i = 0; i < jTableThingPlenty.getRowCount(); i++) {
                                if (jTableThingPlenty.getValueAt(i, 1).toString().equals(objStr)) {
//                                System.out.println(objStr+"  - "+i);
                                    position = i;
                                }
                            }
                            position = position * 2 + 2;
                            saveORelation(position);
                            bobjectof = false;
                        }

                    }

                };
                saxParser.parse(fileDictName, handler);
            } catch (ParserConfigurationException | SAXException | IOException e) {
            }

        } else {
            JOptionPane.showMessageDialog(null, "The changers into dictionary doesn't save !");
        }
    }

    // To create JSONArray from data
    //===========================================
    public void doSaveJSON() throws IOException {

        int k = (int) jTableThingPlenty.getRowCount() * 2;
        JSONArray lexicon = new JSONArray();
        JSONArray relations;
        JSONObject concept;
        for (int i = 0; i < jTableThingPlenty.getRowCount(); i++) {
            concept = new JSONObject();
            relations = new JSONArray();
            relations.add(jTableThingPlenty.getValueAt(i, 0).toString());
            relations.add(jTableThingPlenty.getValueAt(i, 1).toString());
            concept.put("T", relations);
            lexicon.add(concept);
        }
        for (int i = 0; i < jTableThingDictionary.getRowCount(); i++) {
            concept = new JSONObject();
            relations = new JSONArray();
            relations.add(jTableThingDictionary.getValueAt(i, 0).toString());
            for (int j = 1; j < k + 1; j++) {
                String a = jTableThingDictionary.getValueAt(i, j).toString();
                if (a.equals("X")) {
                    relations.add(Integer.toString(j));
                }
            }
            concept.put("C", relations);
            lexicon.add(concept);
        }

        try {
            FileWriter file = new FileWriter(FNManager.main("To choose JSON file for writing!", ".json"));
            file.write(lexicon.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // To parse JSON file of the dictionary
    //==========================================================================
    public void doLoadJSON() {
        for (int i = mdataThingDictionary.getRowCount(); i > 0; i--) {
            mdataThingDictionary.removeRow(0);
        }
        for (int i = mdataThingTablePlenty.getRowCount(); i > 0; i--) {
            mdataThingTablePlenty.removeRow(0);
        }
        intkeywords = 0;
        int inttabl = 0;

        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader(FNManager.main("To choose the JSON file of DICTIONARY!", ".json")));
            JSONArray cons = (JSONArray) obj;
            Iterator<JSONObject> itCons = cons.iterator();
            while (itCons.hasNext()) {
                JSONObject cp = (JSONObject) itCons.next();
                if (cp.containsKey("T")) {
                    JSONArray tbl1 = (JSONArray) cp.get("T");
                    boolean first = true;
                    Iterator<String> ittbl = tbl1.iterator();
                    while (ittbl.hasNext()) {
                        String str = ittbl.next();
                        if (first) {
                            mdataThingTablePlenty.addRow(new String[]{"", ""});
                            jTableThingPlenty.getModel().setValueAt(str, inttabl, 0);
                            inttabl++;
                            first = false;
                        } else {
                            jTableThingPlenty.getModel().setValueAt(str, inttabl - 1, 1);
                        }
                    }
                }

                if (cp.containsKey("C")) {
                    JSONArray cons1 = (JSONArray) cp.get("C");
                    boolean first = true;
                    Iterator<String> itCons1 = cons1.iterator();
                    while (itCons1.hasNext()) {
                        String str = itCons1.next();
                        if (first) {
                            mdataThingDictionary.addRow(rowTemplate);
                            jTableThingDictionary.getModel().setValueAt(str, intkeywords, 0);
                            intkeywords++;
                            first = false;
                        } else {
                            jTableThingDictionary.getModel().setValueAt("X", intkeywords - 1, Integer.parseInt(str));
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
