package org.cssig.kb.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;
import static org.cssig.kb.gui.DictionaryPanel.jTableThingKeywords;
import static org.cssig.kb.gui.DictionaryPanel.newKeyw;
import static org.cssig.kb.gui.DictionaryPanel.jTableThingPlenty;
import static org.cssig.kb.gui.ToolBar.rowTemplate;
import static org.cssig.kb.gui.ToolBar.jToolTabPanel;

/**
 *
 * @author Vasyl
 */
public class TextAnalysis {

    // Imported variables
    private int maxTabl = 200;
    private boolean analys = true;

    private int intTabl;
//    private int intTabl = 10;

    // Local variables
    private final JLabel keepLabel = new JLabel("Keep", JButton.LEFT);
    private final JLabel optLabel = new JLabel("Opt", JButton.CENTER);
    private final JLabel fullTextLabel = new JLabel("Full text of the resource", JButton.CENTER);
    private JTable jTKeywords;
    private DefaultTableModel fTableKeywords;
    public int findKeywords = 0;
    private final JScrollPane textPane;
    public static String fileN = new String();

    private final javax.swing.JScrollPane mainPane = new JScrollPane();
    private javax.swing.JScrollPane jKeywPane;
    private final javax.swing.JButton loadButton = new JButton("Load information resource");
    private final javax.swing.JButton analysisButton = new JButton("Analysis of resource");
    private final javax.swing.JButton dictButton = new JButton("Save to dictionary");

    private final javax.swing.JPanel panel1 = new JPanel();
    private final javax.swing.JPanel panel2 = new JPanel();
    private final javax.swing.JPanel panel3 = new JPanel();

    private final JCheckBox checkBox1 = new JCheckBox("");
    private final JCheckBox checkBox2 = new JCheckBox("");
    private final JCheckBox checkBox3 = new JCheckBox("");
    private final JCheckBox checkBox4 = new JCheckBox("");
    private final JCheckBox checkBox5 = new JCheckBox("");
    private final JCheckBox checkBox6 = new JCheckBox("");
    private final JCheckBox checkBox7 = new JCheckBox("");
    private final JCheckBox checkBox8 = new JCheckBox("");
    private final JCheckBox checkBox9 = new JCheckBox("");
    private final JCheckBox checkBox10 = new JCheckBox("");
    private final JCheckBox checkBox11 = new JCheckBox("");
    private final JCheckBox checkBox12 = new JCheckBox("");
    private final JCheckBox checkBox13 = new JCheckBox("");
    private final JCheckBox checkBox14 = new JCheckBox("");
    private final JCheckBox checkBox15 = new JCheckBox("");
    private final JCheckBox checkBox16 = new JCheckBox("");
    private final JCheckBox checkBox17 = new JCheckBox("");
    private final JCheckBox checkBox18 = new JCheckBox("");
    private final JCheckBox checkBox19 = new JCheckBox("");
    private final JCheckBox checkBox20 = new JCheckBox("");
    private final JCheckBox checkBox21 = new JCheckBox("");
    private final JCheckBox checkBox22 = new JCheckBox("");
    private final JCheckBox checkBox23 = new JCheckBox("");
    private final JCheckBox checkBox24 = new JCheckBox("");
    private final JCheckBox checkBox25 = new JCheckBox("");
    private final JCheckBox checkBox26 = new JCheckBox("");
    private final JCheckBox checkBox27 = new JCheckBox("");
    private final JCheckBox checkBox28 = new JCheckBox("");
    private final JCheckBox checkBox29 = new JCheckBox("");
    private final JCheckBox checkBox30 = new JCheckBox("");

    private final JTextField strField1 = new JTextField("");
    private final JTextField strField2 = new JTextField("");
    private final JTextField strField3 = new JTextField("");
    private final JTextField strField4 = new JTextField("");
    private final JTextField strField5 = new JTextField("");
    private final JTextField strField6 = new JTextField("");
    private final JTextField strField7 = new JTextField("");
    private final JTextField strField8 = new JTextField("");
    private final JTextField strField9 = new JTextField("");
    private final JTextField strField10 = new JTextField("");
    private final JTextField strField11 = new JTextField("");
    private final JTextField strField12 = new JTextField("");

    private final JTextField str1Field1 = new JTextField("");
    private final JTextField str1Field2 = new JTextField("");
    private final JTextField str1Field3 = new JTextField("");
    private final JTextField str1Field4 = new JTextField("");
    private final JTextField str1Field5 = new JTextField("");
    private final JTextField str1Field6 = new JTextField("");
    private final JTextField str1Field7 = new JTextField("");
    private final JTextField str1Field8 = new JTextField("");
    private final JTextField str1Field9 = new JTextField("");
    private final JTextField str1Field10 = new JTextField("");
    private final JTextField str1Field11 = new JTextField("");
    private final JTextField str1Field12 = new JTextField("");

    private static final JTextArea readField = new JTextArea();
    private static final JTextArea allTextField = new JTextArea();

    private final String[] nameTable;

    public static JComboBox<String> comboBox1;
    public static JComboBox<String> comboBox2;
    public static JComboBox<String> comboBox3;
    public static JComboBox<String> comboBox4;
    public static JComboBox<String> comboBox5;
    public static JComboBox<String> comboBox6;
    public static JComboBox<String> comboBox7;
    public static JComboBox<String> comboBox8;
    public static JComboBox<String> comboBox9;
    public static JComboBox<String> comboBox10;
    public static JComboBox<String> comboBox11;
    public static JComboBox<String> comboBox12;

    public TextAnalysis() {

        super();

        initListeners();

//        intTabl = Integer.parseInt(GeneralTools.qtableField.getText());
        intTabl = 1;
        allTextField.setSize(600, 900);
        readField.setLineWrap(true);
//    textPane = new JScrollPane(allTextField);
        textPane = new JScrollPane();

        DefaultCaret caret = (DefaultCaret) allTextField.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        textPane.setViewportView(allTextField);

        this.nameTable = new String[1];
        nameTable[0] = "-";

        TextAnalysis.comboBox12 = new JComboBox<>(nameTable);
        TextAnalysis.comboBox11 = new JComboBox<>(nameTable);
        TextAnalysis.comboBox10 = new JComboBox<>(nameTable);
        TextAnalysis.comboBox9 = new JComboBox<>(nameTable);
        TextAnalysis.comboBox8 = new JComboBox<>(nameTable);
        TextAnalysis.comboBox7 = new JComboBox<>(nameTable);
        TextAnalysis.comboBox6 = new JComboBox<>(nameTable);
        TextAnalysis.comboBox5 = new JComboBox<>(nameTable);
        TextAnalysis.comboBox4 = new JComboBox<>(nameTable);
        TextAnalysis.comboBox3 = new JComboBox<>(nameTable);
        TextAnalysis.comboBox2 = new JComboBox<>(nameTable);
        TextAnalysis.comboBox1 = new JComboBox<>(nameTable);

    }

    public void initListeners() {

        loadButton.addActionListener((ActionEvent e) -> {
            openFile();
        });

        analysisButton.addActionListener((ActionEvent e) -> {
            aProcess();
        });

        dictButton.addActionListener((ActionEvent e) -> {
            passtoDictionary();
        });

        checkBox6.addItemListener((ItemEvent e) -> {
            if (checkBox6.isSelected()) {
                checkBox13.setSelected(false);
            }
        });

        checkBox7.addItemListener((ItemEvent e) -> {
            if (checkBox7.isSelected()) {
                checkBox14.setSelected(false);
            }
        });

        checkBox8.addItemListener((ItemEvent e) -> {
            if (checkBox8.isSelected()) {
                checkBox15.setSelected(false);
            }
        });

        checkBox9.addItemListener((ItemEvent e) -> {
            if (checkBox9.isSelected()) {
                checkBox16.setSelected(false);
            }
        });

        checkBox10.addItemListener((ItemEvent e) -> {
            if (checkBox10.isSelected()) {
                checkBox17.setSelected(false);
            }
        });

        checkBox11.addItemListener((ItemEvent e) -> {
            if (checkBox11.isSelected()) {
                checkBox29.setSelected(false);
            }
        });

        checkBox12.addItemListener((ItemEvent e) -> {
            if (checkBox12.isSelected()) {
                checkBox30.setSelected(false);
            }
        });

        checkBox13.addItemListener((ItemEvent e) -> {
            if (checkBox13.isSelected()) {
                checkBox6.setSelected(false);
                checkBox22.setSelected(false);
                checkBox23.setSelected(false);
            }
        });

        checkBox14.addItemListener((ItemEvent e) -> {
            if (checkBox14.isSelected()) {
                checkBox7.setSelected(false);
                checkBox23.setSelected(false);
                checkBox24.setSelected(false);
            }
        });

        checkBox15.addItemListener((ItemEvent e) -> {
            if (checkBox15.isSelected()) {
                checkBox8.setSelected(false);
                checkBox24.setSelected(false);
                checkBox25.setSelected(false);
            }
        });

        checkBox16.addItemListener((ItemEvent e) -> {
            if (checkBox16.isSelected()) {
                checkBox9.setSelected(false);
                checkBox25.setSelected(false);
                checkBox26.setSelected(false);
            }
        });

        checkBox17.addItemListener((ItemEvent e) -> {
            if (checkBox17.isSelected()) {
                checkBox10.setSelected(false);
                checkBox26.setSelected(false);
                checkBox27.setSelected(false);
            }
        });

        checkBox18.addItemListener((ItemEvent e) -> {
            if (checkBox18.isSelected()) {
                checkBox1.setSelected(true);
                checkBox2.setSelected(true);
            }
        });

        checkBox19.addItemListener((ItemEvent e) -> {
            if (checkBox19.isSelected()) {
                checkBox2.setSelected(true);
                checkBox3.setSelected(true);
            }
        });

        checkBox20.addItemListener((ItemEvent e) -> {
            if (checkBox20.isSelected()) {
                checkBox3.setSelected(true);
                checkBox4.setSelected(true);
            }
        });

        checkBox21.addItemListener((ItemEvent e) -> {
            if (checkBox21.isSelected()) {
                checkBox4.setSelected(true);
                checkBox5.setSelected(true);
            }
        });

        checkBox22.addItemListener((ItemEvent e) -> {
            if (checkBox22.isSelected()) {
                checkBox5.setSelected(true);
                checkBox6.setSelected(true);
                checkBox13.setSelected(false);
            }
        });

        checkBox23.addItemListener((ItemEvent e) -> {
            if (checkBox23.isSelected()) {
                checkBox6.setSelected(true);
                checkBox7.setSelected(true);
                checkBox13.setSelected(false);
                checkBox14.setSelected(false);
            }
        });

        checkBox24.addItemListener((ItemEvent e) -> {
            if (checkBox24.isSelected()) {
                checkBox7.setSelected(true);
                checkBox8.setSelected(true);
                checkBox14.setSelected(false);
                checkBox15.setSelected(false);
            }
        });

        checkBox25.addItemListener((ItemEvent e) -> {
            if (checkBox25.isSelected()) {
                checkBox8.setSelected(true);
                checkBox9.setSelected(true);
                checkBox15.setSelected(false);
                checkBox16.setSelected(false);
            }
        });

        checkBox26.addItemListener((ItemEvent e) -> {
            if (checkBox26.isSelected()) {
                checkBox9.setSelected(true);
                checkBox10.setSelected(true);
                checkBox16.setSelected(false);
                checkBox17.setSelected(false);
            }
        });

        checkBox27.addItemListener((ItemEvent e) -> {
            if (checkBox27.isSelected()) {
                checkBox10.setSelected(true);
                checkBox11.setSelected(true);
                checkBox17.setSelected(false);
                checkBox29.setSelected(false);
            }
        });

        checkBox28.addItemListener((ItemEvent e) -> {
            if (checkBox28.isSelected()) {
                checkBox11.setSelected(true);
                checkBox12.setSelected(true);
                checkBox29.setSelected(false);
                checkBox30.setSelected(false);
            }
        });

        checkBox29.addItemListener((ItemEvent e) -> {
            if (checkBox29.isSelected()) {
                checkBox11.setSelected(false);
                checkBox27.setSelected(false);
                checkBox28.setSelected(false);
            }
        });

        checkBox30.addItemListener((ItemEvent e) -> {
            if (checkBox30.isSelected()) {
                checkBox12.setSelected(false);
                checkBox28.setSelected(false);
            }
        });

    }

    public JScrollPane getAnalysisPane() {
        mainPane.setBackground(Color.GRAY);

        GroupLayout layout1 = new GroupLayout(panel1);
        panel1.setLayout(layout1);
        layout1.setHorizontalGroup(layout1.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(keepLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox13, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox14, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox15, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox16, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox17, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox29, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox30, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(loadButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(strField1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(strField2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(strField3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(strField4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(strField5, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(strField6, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(strField7, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(strField8, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(strField9, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(strField10, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(strField11, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(strField12, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox8, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox9, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox10, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox11, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox12, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(optLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox18, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox19, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox20, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox21, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox22, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox23, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox24, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox25, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox26, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox27, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(checkBox28, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                )
                .addGap(20, 20, 20)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(analysisButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(str1Field1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(str1Field2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(str1Field3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(str1Field4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(str1Field5, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(str1Field6, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(str1Field7, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(str1Field8, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(str1Field9, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(str1Field10, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(str1Field11, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(str1Field12, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(20, 20, 20)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(dictButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(comboBox6, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(comboBox7, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(comboBox8, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(comboBox9, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(comboBox10, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(comboBox11, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout1.createSequentialGroup()
                                .addComponent(comboBox12, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                )
        );

        layout1.setVerticalGroup(layout1.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(loadButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(dictButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(analysisButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(optLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(strField1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(str1Field1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(checkBox18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(strField2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(str1Field2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(checkBox19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(strField3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(str1Field3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(checkBox20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(strField4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(str1Field4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(checkBox21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(keepLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strField5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(str1Field5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(checkBox22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(checkBox13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strField6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(str1Field6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(checkBox23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(checkBox14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strField7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(str1Field7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(checkBox24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(checkBox15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strField8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(str1Field8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(checkBox25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(checkBox16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strField9, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(str1Field9, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox9, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(checkBox26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(checkBox17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strField10, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(str1Field10, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox10, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(checkBox27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(checkBox29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strField11, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(str1Field11, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox11, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(checkBox28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(0, 0, 0)
                .addGroup(layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(checkBox30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(strField12, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(str1Field12, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox12, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                )
        );

        GroupLayout layout2 = new GroupLayout(panel2);
        panel2.setLayout(layout2);
        layout2.setHorizontalGroup(layout2.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout2.createSequentialGroup()
                                .addComponent(readField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(getKeywPane(), GroupLayout.PREFERRED_SIZE, 840, GroupLayout.PREFERRED_SIZE))
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
        );

        layout2.setVerticalGroup(layout2.createSequentialGroup()
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(readField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addComponent(getKeywPane(), GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                )
        );

        GroupLayout layout3 = new GroupLayout(panel3);
        panel3.setLayout(layout3);
        layout3.setHorizontalGroup(layout3.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(fullTextLabel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout3.createSequentialGroup()
                                .addComponent(textPane, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE))
                )
        );

        layout3.setVerticalGroup(layout3.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addGroup(layout3.createSequentialGroup()
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(fullTextLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addComponent(textPane, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE))
        );

        mainPane.setViewportView(panel3);
        mainPane.setVisible(true);
        return mainPane;
    }

    private JScrollPane getKeywPane() {
        if (jKeywPane == null) {
            jKeywPane = new JScrollPane();
            jKeywPane.setRowHeaderView(getKeywords());
            jKeywPane.setViewportView(getKeywords());
        }
        return jKeywPane;
    }

    private JTable getKeywords() {
        if (jTKeywords == null) {
            String[] headKeyw = new String[maxTabl + 1];
            headKeyw[0] = "Found keywords";
            int j = 1;
            int k = 1;
            do {
                headKeyw[j] = String.valueOf("O" + k);
                headKeyw[j + 1] = String.valueOf("P" + k);
                k++;
                j += 2;
            } while (k <= (Integer) maxTabl / 2);

            fTableKeywords = new DefaultTableModel(headKeyw, 0);
            for (int i = 0; i < maxTabl; i++) {
                fTableKeywords.addRow(rowTemplate);
            }

            jTKeywords = new JTable(fTableKeywords);
            jTKeywords.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (evt.getButton() == MouseEvent.BUTTON1) {
                        int row = jTKeywords.rowAtPoint(evt.getPoint());
                        int col = jTKeywords.columnAtPoint(evt.getPoint());
                        if (col > 0) {
                            jTKeywords.isCellEditable(row, col);
                            if (jTKeywords.getModel().getValueAt(row, col).toString().equals("X")) {
                                jTKeywords.isCellEditable(row, col);
                                jTKeywords.getModel().setValueAt("", row, col);
                            } else if (jTKeywords.getModel().getValueAt(row, col).toString().equals("")) {
                                if (col % 2 == 0) {
                                    jTKeywords.isCellEditable(row, col - 1);
                                    jTKeywords.getModel().setValueAt("", row, col - 1);
                                    jTKeywords.isCellEditable(row, col);
                                    jTKeywords.getModel().setValueAt("X", row, col);
                                } else {
                                    jTKeywords.isCellEditable(row, col + 1);
                                    jTKeywords.getModel().setValueAt("", row, col + 1);
                                    jTKeywords.isCellEditable(row, col);
                                    jTKeywords.getModel().setValueAt("X", row, col);
                                }
                            }
                        }
                        jTKeywords.repaint();
                        jTKeywords.updateUI();
                    }
                }
            });

            jTKeywords.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            jTKeywords.setColumnSelectionAllowed(false);
            jTKeywords.setRowSelectionAllowed(true);

            jTKeywords.setPreferredScrollableViewportSize(
                    new Dimension(jTKeywords.getPreferredScrollableViewportSize().width + 210, 12 * jTKeywords.getRowHeight()));
            jTKeywords.setAutoscrolls(true);
            jTKeywords.getColumnModel().getColumn(0).setPreferredWidth(200);
            for (int i = 1; i <= maxTabl; i++) {
                jTKeywords.getColumnModel().getColumn(i).setPreferredWidth(30);
            }
        }
        return jTKeywords;
    }

    // Read file
    // ==============================================
    @SuppressWarnings("resource")
    public static void openFile() {
        readField.setText("");
        allTextField.setText("");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setVisible(true);
        int result = fileChooser.showOpenDialog(fileChooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileN = fileChooser.getSelectedFile().getPath();
        }
        try {
            FileReader fr = new FileReader(fileN);
            BufferedReader reader = new BufferedReader(fr);
            String str = reader.readLine();
            while (str != null) {
                readField.append(str + "\n\r");
                allTextField.append(str + "\n\r");
                str = reader.readLine();
            }
        } catch (IOException e) {
        }
    }

    public void strRecord(String args, int ccp) {
        boolean b = false;
        String s = new String("");
        StringBuilder stb = new StringBuilder(args);

        args.trim();
        for (int i = 0; i <= 3; i++) {
            if (args.contains(":")) {
                args = stb.deleteCharAt(args.indexOf(":")).toString();
            }
            if (args.contains(";")) {
                args = stb.deleteCharAt(args.indexOf(";")).toString();
            }
            if (args.contains(".")) {
                args = stb.deleteCharAt(args.indexOf(".")).toString();
            }
            if (args.contains(",")) {
                args = stb.deleteCharAt(args.indexOf(",")).toString();
            }
            if (args.contains("(")) {
                stb = new StringBuilder(args);
                args = stb.deleteCharAt(args.indexOf("(")).toString();
            }
            if (args.contains(")")) {
                stb = new StringBuilder(args);
                args = stb.deleteCharAt(args.indexOf(")")).toString();
            }
            if (args.contains("\\")) {
                stb = new StringBuilder(args);
                args = stb.deleteCharAt(args.indexOf("\\")).toString();
            }
            if (args.contains("\"")) {
                stb = new StringBuilder(args);
                args = stb.deleteCharAt(args.indexOf("\"")).toString();
            }
            if (args.contains("@")) {
                stb = new StringBuilder(args);
                args = stb.deleteCharAt(args.indexOf("@")).toString();
            }
            if (args.contains("«")) {
                stb = new StringBuilder(args);
                args = stb.deleteCharAt(args.indexOf("«")).toString();
            }
            if (args.contains("»")) {
                stb = new StringBuilder(args);
                args = stb.deleteCharAt(args.indexOf("»")).toString();
            }
            if (args.contains("•")) {
                stb = new StringBuilder(args);
                args = stb.deleteCharAt(args.indexOf("•")).toString();
            }
            if (args.contains("”")) {
                stb = new StringBuilder(args);
                args = stb.deleteCharAt(args.indexOf("”")).toString();
            }
            if (args.contains("“")) {
                stb = new StringBuilder(args);
                args = stb.deleteCharAt(args.indexOf("“")).toString();
            }
        }
        args.toLowerCase();

        for (int i = 0; i <= findKeywords; i++) {
            jTKeywords.setRowSelectionInterval(i, i);
            if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(args)) {
                b = true;
                break;
            }
        }
        if (!b) {
            fTableKeywords.addRow(rowTemplate);
            jTKeywords.isCellEditable(findKeywords, 0);
            jTKeywords.getModel().setValueAt(args, findKeywords, 0);
            findKeywords++;
        }

        switch (ccp) {
            case 0: {
                str1Field1.setText(args);
                break;
            }
            case 1: {
                str1Field2.setText(args);
                break;
            }
            case 2: {
                str1Field3.setText(args);
                break;
            }
            case 3: {
                str1Field4.setText(args);
                break;
            }
            case 4: {
                str1Field5.setText(args);
                break;
            }
            case 5: {
                str1Field6.setText(args);
                break;
            }
            case 6: {
                str1Field7.setText(args);
                break;
            }
            case 7: {
                str1Field8.setText(args);
                break;
            }
            case 8: {
                str1Field9.setText(args);
                break;
            }
            case 9: {
                str1Field10.setText(args);
                break;
            }
            case 10: {
                str1Field11.setText(args);
                break;
            }
            case 11: {
                str1Field12.setText(args);
                break;
            }

        }
    }

    public void aProcess() {
        String temp_s = "";
        String ss = "";
        int p = 0, cp = 0;

        if (!analys) {
            if (checkBox18.isSelected() && checkBox19.isSelected() && checkBox20.isSelected() && !checkBox21.isSelected()) {
                ss = strField1.getText() + " " + strField2.getText() + " " + strField3.getText() + " " + strField4.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox18.isSelected() && checkBox19.isSelected() && checkBox20.isSelected() && checkBox21.isSelected() && !checkBox22.isSelected()) {
                ss = strField2.getText() + " " + strField3.getText() + " " + strField4.getText() + " " + strField5.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox19.isSelected() && checkBox20.isSelected() && checkBox21.isSelected() && checkBox22.isSelected() && !checkBox23.isSelected()) {
                ss = strField3.getText() + " " + strField4.getText() + " " + strField5.getText() + " " + strField6.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox20.isSelected() && checkBox21.isSelected() && checkBox22.isSelected() && checkBox23.isSelected() && !checkBox24.isSelected()) {
                ss = strField4.getText() + " " + strField5.getText() + " " + strField6.getText() + " " + strField7.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox21.isSelected() && checkBox22.isSelected() && checkBox23.isSelected() && checkBox24.isSelected() && !checkBox25.isSelected()) {
                ss = strField5.getText() + " " + strField6.getText() + " " + strField7.getText() + " " + strField8.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox22.isSelected() && checkBox23.isSelected() && checkBox24.isSelected() && checkBox25.isSelected() && !checkBox26.isSelected()) {
                ss = strField6.getText() + " " + strField7.getText() + " " + strField8.getText() + " " + strField9.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox23.isSelected() && checkBox24.isSelected() && checkBox25.isSelected() && checkBox26.isSelected() && !checkBox27.isSelected()) {
                ss = strField7.getText() + " " + strField8.getText() + " " + strField9.getText() + " " + strField10.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox24.isSelected() && checkBox25.isSelected() && checkBox26.isSelected() && checkBox27.isSelected() && !checkBox28.isSelected()) {
                ss = strField8.getText() + " " + strField9.getText() + " " + strField10.getText() + " " + strField11.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox25.isSelected() && checkBox26.isSelected() && checkBox27.isSelected() && checkBox28.isSelected()) {
                ss = strField9.getText() + " " + strField10.getText() + " " + strField11.getText() + " " + strField12.getText();
                strRecord(ss, cp++);
            }
            if (checkBox18.isSelected() && !checkBox19.isSelected()) {
                ss = strField1.getText() + " " + strField2.getText();
                strRecord(ss, cp++);
            }
            if (checkBox19.isSelected() && !checkBox18.isSelected() && !checkBox20.isSelected()) {
                ss = strField2.getText() + " " + strField3.getText();
                strRecord(ss, cp++);
            }
            if (checkBox20.isSelected() && !checkBox19.isSelected() && !checkBox21.isSelected()) {
                ss = strField3.getText() + " " + strField4.getText();
                strRecord(ss, cp++);
            }
            if (checkBox21.isSelected() && !checkBox20.isSelected() && !checkBox22.isSelected()) {
                ss = strField4.getText() + " " + strField5.getText();
                strRecord(ss, cp++);
            }
            if (checkBox22.isSelected() && !checkBox21.isSelected() && !checkBox23.isSelected()) {
                ss = strField5.getText() + " " + strField6.getText();
                strRecord(ss, cp++);
            }
            if (checkBox23.isSelected() && !checkBox22.isSelected() && !checkBox24.isSelected()) {
                ss = strField6.getText() + " " + strField7.getText();
                strRecord(ss, cp++);
            }
            if (checkBox24.isSelected() && !checkBox23.isSelected() && !checkBox25.isSelected()) {
                ss = strField7.getText() + " " + strField8.getText();
                strRecord(ss, cp++);
            }
            if (checkBox25.isSelected() && !checkBox24.isSelected() && !checkBox26.isSelected()) {
                ss = strField8.getText() + " " + strField9.getText();
                strRecord(ss, cp++);
            }
            if (checkBox26.isSelected() && !checkBox25.isSelected() && !checkBox27.isSelected()) {
                ss = strField9.getText() + " " + strField10.getText();
                strRecord(ss, cp++);
            }
            if (checkBox27.isSelected() && !checkBox26.isSelected() && !checkBox28.isSelected()) {
                ss = strField10.getText() + " " + strField11.getText();
                strRecord(ss, cp++);
            }
            if (checkBox28.isSelected() && !checkBox27.isSelected()) {
                ss = strField11.getText() + " " + strField12.getText();
                strRecord(ss, cp++);
            }
            if (checkBox18.isSelected() && checkBox19.isSelected() && !checkBox20.isSelected()) {
                ss = strField1.getText() + " " + strField2.getText() + " " + strField3.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox18.isSelected() && checkBox19.isSelected() && checkBox20.isSelected() && !checkBox21.isSelected()) {
                ss = strField2.getText() + " " + strField3.getText() + " " + strField4.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox19.isSelected() && checkBox20.isSelected() && checkBox21.isSelected() && !checkBox22.isSelected()) {
                ss = strField3.getText() + " " + strField4.getText() + " " + strField5.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox20.isSelected() && checkBox21.isSelected() && checkBox22.isSelected() && !checkBox23.isSelected()) {
                ss = strField4.getText() + " " + strField5.getText() + " " + strField6.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox21.isSelected() && checkBox22.isSelected() && checkBox23.isSelected() && !checkBox24.isSelected()) {
                ss = strField5.getText() + " " + strField6.getText() + " " + strField7.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox22.isSelected() && checkBox23.isSelected() && checkBox24.isSelected() && !checkBox25.isSelected()) {
                ss = strField6.getText() + " " + strField7.getText() + " " + strField8.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox23.isSelected() && checkBox24.isSelected() && checkBox25.isSelected() && !checkBox26.isSelected()) {
                ss = strField7.getText() + " " + strField8.getText() + " " + strField9.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox24.isSelected() && checkBox25.isSelected() && checkBox26.isSelected() && !checkBox27.isSelected()) {
                ss = strField8.getText() + " " + strField9.getText() + " " + strField10.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox25.isSelected() && checkBox26.isSelected() && checkBox27.isSelected() && !checkBox28.isSelected()) {
                ss = strField9.getText() + " " + strField10.getText() + " " + strField11.getText();
                strRecord(ss, cp++);
            }
            if (!checkBox26.isSelected() && checkBox27.isSelected() && checkBox28.isSelected()) {
                ss = strField10.getText() + " " + strField11.getText() + " " + strField12.getText();
                strRecord(ss, cp++);
            }
            if (checkBox1.isSelected() && !checkBox18.isSelected()) {
                ss = strField1.getText();
                strRecord(ss, cp++);
            }
            if (checkBox2.isSelected() && !checkBox18.isSelected() && !checkBox19.isSelected()) {
                ss = strField2.getText();
                strRecord(ss, cp++);
            }
            if (checkBox3.isSelected() && !checkBox19.isSelected() && !checkBox20.isSelected()) {
                ss = strField3.getText();
                strRecord(ss, cp++);
            }
            if (checkBox4.isSelected() && !checkBox20.isSelected() && !checkBox21.isSelected()) {
                ss = strField4.getText();
                strRecord(ss, cp++);
            }
            if (checkBox5.isSelected() && !checkBox21.isSelected() && !checkBox22.isSelected()) {
                ss = strField5.getText();
                strRecord(ss, cp++);
            }
            if (checkBox6.isSelected() && !checkBox22.isSelected() && !checkBox23.isSelected()) {
                ss = strField6.getText();
                strRecord(ss, cp++);
            }
            if (checkBox7.isSelected() && !checkBox23.isSelected() && !checkBox24.isSelected()) {
                ss = strField7.getText();
                strRecord(ss, cp++);
            }
            if (checkBox8.isSelected() && !checkBox24.isSelected() && !checkBox25.isSelected()) {
                ss = strField8.getText();
                strRecord(ss, cp++);
            }
            if (checkBox9.isSelected() && !checkBox25.isSelected() && !checkBox26.isSelected()) {
                ss = strField9.getText();
                strRecord(ss, cp++);
            }
            if (checkBox10.isSelected() && !checkBox26.isSelected() && !checkBox27.isSelected()) {
                ss = strField10.getText();
                strRecord(ss, cp++);
            }
            if (checkBox11.isSelected() && !checkBox27.isSelected() && !checkBox28.isSelected()) {
                ss = strField11.getText();
                strRecord(ss, cp++);
            }
            if (checkBox12.isSelected() && !checkBox28.isSelected()) {
                ss = strField12.getText();
                strRecord(ss, cp++);
            }

            temp_s = "";

            if (checkBox30.isSelected()) {
                temp_s = strField12.getText() + " ";
            }
            if (checkBox29.isSelected()) {
                temp_s = strField11.getText() + " " + temp_s;
            }
            if (checkBox17.isSelected()) {
                temp_s = strField10.getText() + " " + temp_s;
            }
            if (checkBox16.isSelected()) {
                temp_s = strField9.getText() + " " + temp_s;
            }
            if (checkBox15.isSelected()) {
                temp_s = strField8.getText() + " " + temp_s;
            }
            if (checkBox14.isSelected()) {
                temp_s = strField7.getText() + " " + temp_s;
            }
            if (checkBox13.isSelected()) {
                temp_s = strField6.getText() + " " + temp_s;
            }

            if (!str1Field1.getText().equals("") && comboBox1.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Install the keyword's relationship to the spreadsheet");
                analys = false;
                return;
            }
            if (!str1Field1.getText().equals("") && !comboBox1.getSelectedItem().equals("-")) {
                for (int i = 0; i <= findKeywords; i++) {
                    jTKeywords.setRowSelectionInterval(i, i);
                    if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(str1Field1.getText())) {
                        p = comboBox1.getSelectedIndex() + 1;
                        JOptionPane.showMessageDialog(null, "" + p);

                        jTKeywords.isCellEditable(i, p);
                        jTKeywords.getModel().setValueAt("X", i, p);
                    }
                }
            }

            if (!str1Field2.getText().equals("") && comboBox2.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Install the keyword's relationship to the spreadsheet");
                analys = false;
                return;
            }
            if (!str1Field2.getText().equals("") && !comboBox2.getSelectedItem().equals("-")) {
                for (int i = 0; i <= findKeywords; i++) {
                    jTKeywords.setRowSelectionInterval(i, i);
                    if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(str1Field2.getText())) {
                        p = comboBox2.getSelectedIndex();
                        jTKeywords.isCellEditable(i, p);
                        jTKeywords.getModel().setValueAt("X", i, p);
                    }
                }
            }

            if (!str1Field3.getText().equals("") && comboBox3.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Install the keyword's relationship to the spreadsheet");
                analys = false;
                return;
            }
            if (!str1Field3.getText().equals("") && !comboBox3.getSelectedItem().equals("-")) {
                for (int i = 0; i <= findKeywords; i++) {
                    jTKeywords.setRowSelectionInterval(i, i);
                    if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(str1Field3.getText())) {
                        p = comboBox3.getSelectedIndex();
                        jTKeywords.isCellEditable(i, p);
                        jTKeywords.getModel().setValueAt("X", i, p);
                    }
                }
            }

            if (!str1Field4.getText().equals("") && comboBox4.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Install the keyword's relationship to the spreadsheet");
                analys = false;
                return;
            }
            if (!str1Field4.getText().equals("") && !comboBox4.getSelectedItem().equals("-")) {
                for (int i = 0; i <= findKeywords; i++) {
                    jTKeywords.setRowSelectionInterval(i, i);
                    if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(str1Field4.getText())) {
                        p = comboBox4.getSelectedIndex();
                        jTKeywords.isCellEditable(i, p);
                        jTKeywords.getModel().setValueAt("X", i, p);
                    }
                }
            }

            if (!str1Field5.getText().equals("") && comboBox5.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Install the keyword's relationship to the spreadsheet");
                analys = false;
                return;
            }
            if (!str1Field5.getText().equals("") && !comboBox5.getSelectedItem().equals("-")) {
                for (int i = 0; i <= findKeywords; i++) {
                    jTKeywords.setRowSelectionInterval(i, i);
                    if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(str1Field5.getText())) {
                        p = comboBox5.getSelectedIndex();
                        jTKeywords.isCellEditable(i, p);
                        jTKeywords.getModel().setValueAt("X", i, p);
                    }
                }
            }

            if (!str1Field6.getText().equals("") && comboBox6.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Install the keyword's relationship to the spreadsheet");
                analys = false;
                return;
            }
            if (!str1Field6.getText().equals("") && !comboBox6.getSelectedItem().equals("-")) {
                for (int i = 0; i <= findKeywords; i++) {
                    jTKeywords.setRowSelectionInterval(i, i);
                    if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(str1Field6.getText())) {
                        p = comboBox6.getSelectedIndex();
                        jTKeywords.isCellEditable(i, p);
                        jTKeywords.getModel().setValueAt("X", i, p);
                    }
                }
            }

            if (!str1Field7.getText().equals("") && comboBox7.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Install the keyword's relationship to the spreadsheet");
                analys = false;
                return;
            }
            if (!str1Field7.getText().equals("") && !comboBox7.getSelectedItem().equals("-")) {
                for (int i = 0; i <= findKeywords; i++) {
                    jTKeywords.setRowSelectionInterval(i, i);
                    if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(str1Field7.getText())) {
                        p = comboBox7.getSelectedIndex();
                        jTKeywords.isCellEditable(i, p);
                        jTKeywords.getModel().setValueAt("X", i, p);
                    }
                }
            }

            if (!str1Field8.getText().equals("") && comboBox8.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Install the keyword's relationship to the spreadsheet");
                analys = false;
                return;
            }
            if (!str1Field8.getText().equals("") && !comboBox8.getSelectedItem().equals("-")) {
                for (int i = 0; i <= findKeywords; i++) {
                    jTKeywords.setRowSelectionInterval(i, i);
                    if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(str1Field8.getText())) {
                        p = comboBox8.getSelectedIndex();
                        jTKeywords.isCellEditable(i, p);
                        jTKeywords.getModel().setValueAt("X", i, p);
                    }
                }
            }

            if (!str1Field9.getText().equals("") && comboBox9.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Install the keyword's relationship to the spreadsheet");
                analys = false;
                return;
            }
            if (!str1Field9.getText().equals("") && !comboBox9.getSelectedItem().equals("-")) {
                for (int i = 0; i <= findKeywords; i++) {
                    jTKeywords.setRowSelectionInterval(i, i);
                    if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(str1Field9.getText())) {
                        p = comboBox9.getSelectedIndex();
                        jTKeywords.isCellEditable(i, p);
                        jTKeywords.getModel().setValueAt("X", i, p);
                    }
                }
            }

            if (!str1Field10.getText().equals("") && comboBox10.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Install the keyword's relationship to the spreadsheet");
                analys = false;
                return;
            }
            if (!str1Field10.getText().equals("") && !comboBox10.getSelectedItem().equals("-")) {
                for (int i = 0; i <= findKeywords; i++) {
                    jTKeywords.setRowSelectionInterval(i, i);
                    if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(str1Field10.getText())) {
                        p = comboBox10.getSelectedIndex();
                        jTKeywords.isCellEditable(i, p);
                        jTKeywords.getModel().setValueAt("X", i, p);
                    }
                }
            }

            if (!str1Field11.getText().equals("") && comboBox11.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Install the keyword's relationship to the spreadsheet");
                analys = false;
                return;
            }
            if (!str1Field11.getText().equals("") && !comboBox11.getSelectedItem().equals("-")) {
                for (int i = 0; i <= findKeywords; i++) {
                    jTKeywords.setRowSelectionInterval(i, i);
                    if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(str1Field11.getText())) {
                        p = comboBox11.getSelectedIndex();
                        jTKeywords.isCellEditable(i, p);
                        jTKeywords.getModel().setValueAt("X", i, p);
                    }
                }
            }

            if (!str1Field12.getText().equals("") && comboBox12.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Install the keyword's relationship to the spreadsheet");
                analys = false;
                return;
            }
            if (!str1Field12.getText().equals("") && !comboBox12.getSelectedItem().equals("-")) {
                for (int i = 0; i <= findKeywords; i++) {
                    jTKeywords.setRowSelectionInterval(i, i);
                    if (jTKeywords.getModel().getValueAt(i, 0).toString().equals(str1Field12.getText())) {
                        p = comboBox12.getSelectedIndex();
                        jTKeywords.isCellEditable(i, p);
                        jTKeywords.getModel().setValueAt("X", i, p);
                    }
                }
            }

            strField1.setText("");
            strField2.setText("");
            strField3.setText("");
            strField4.setText("");
            strField5.setText("");
            strField6.setText("");
            strField7.setText("");
            strField8.setText("");
            strField9.setText("");
            strField10.setText("");
            strField11.setText("");

            str1Field1.setText("");
            str1Field2.setText("");
            str1Field3.setText("");
            str1Field4.setText("");
            str1Field5.setText("");
            str1Field6.setText("");
            str1Field7.setText("");
            str1Field8.setText("");
            str1Field9.setText("");
            str1Field10.setText("");
            str1Field11.setText("");

            checkBox1.setSelected(false);
            checkBox2.setSelected(false);
            checkBox3.setSelected(false);
            checkBox4.setSelected(false);
            checkBox5.setSelected(false);
            checkBox6.setSelected(false);
            checkBox7.setSelected(false);
            checkBox8.setSelected(false);
            checkBox9.setSelected(false);
            checkBox10.setSelected(false);
            checkBox11.setSelected(false);
            checkBox12.setSelected(false);
            checkBox13.setSelected(false);
            checkBox14.setSelected(false);
            checkBox15.setSelected(false);
            checkBox16.setSelected(false);
            checkBox17.setSelected(false);
            checkBox18.setSelected(false);
            checkBox19.setSelected(false);
            checkBox20.setSelected(false);
            checkBox21.setSelected(false);
            checkBox22.setSelected(false);
            checkBox23.setSelected(false);
            checkBox24.setSelected(false);
            checkBox25.setSelected(false);
            checkBox26.setSelected(false);
            checkBox27.setSelected(false);
            checkBox28.setSelected(false);
            checkBox29.setSelected(false);
            checkBox30.setSelected(false);

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

            analys = true;
        }
        if (analys) {
            //  Separating sentence by words
            String rstr = " " + temp_s + " " + readField.getText();

            int k = 0;
            String temp;
            int index1 = 0, index2 = 0;
            String[] listWords = new String[12];
            do {
                index1 = rstr.indexOf(" ", index1 + 1);
                temp = rstr.substring(index2 + 1, index1);
                temp.trim();
                if (temp.length() > 2) {
                    listWords[k] = temp;
                    k++;
                }
                temp = "";
                index2 = index1;
            } while (k < 12);

            strField1.setText(listWords[0]);
            strField2.setText(listWords[1]);
            strField3.setText(listWords[2]);
            strField4.setText(listWords[3]);
            strField5.setText(listWords[4]);
            strField6.setText(listWords[5]);
            strField7.setText(listWords[6]);
            strField8.setText(listWords[7]);
            strField9.setText(listWords[8]);
            strField10.setText(listWords[9]);
            strField11.setText(listWords[10]);
            strField12.setText(listWords[11]);

            rstr = readField.getText().substring(index1, readField.getText().length());
            readField.setText(rstr);

            analysisButton.setText("Continue analysis");
            analys = false;
        }

    }

    private void passtoDictionary() {
        jTableThingKeywords.setEnabled(true);
        jTableThingKeywords.isEditing();
        String kst;
        int quantityKeyw = 0;
        do {

            jTKeywords.setRowSelectionInterval(quantityKeyw, quantityKeyw);
            jTableThingKeywords.setRowSelectionInterval(quantityKeyw, quantityKeyw);
            for (int j = 0; j <= jTableThingPlenty.getRowCount() * 2 + 1; j++) {
                kst = jTKeywords.getValueAt(quantityKeyw, j).toString();
                jTableThingKeywords.getModel().setValueAt(kst, quantityKeyw, j);
            }
            //         JOptionPane.showMessageDialog(null, ""+ quantityKeyw);
            quantityKeyw++;
        } while (quantityKeyw <= findKeywords);
        newKeyw = findKeywords;//quantityKeyw
        jTableThingKeywords.repaint();
        jTableThingKeywords.updateUI();
        analysisButton.setText("Analysis the resource");
        jToolTabPanel.setSelectedIndex(2);
    }

}
