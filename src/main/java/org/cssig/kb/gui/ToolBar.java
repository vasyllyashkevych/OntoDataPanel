/**
 * @author Vasyl Lyashkevych
 */
package org.cssig.kb.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.cssig.kb.json.ParseTypeTree;
import org.cssig.kb.util.Tabl;
import org.cssig.kb.util.FManager;
import static org.cssig.kb.gui.DictionaryPanel.jTableThingPlenty;
import static org.cssig.kb.json.ParseTypeTree.typeArray;

public class ToolBar extends JFrame {

    public static ArrayList<Tabl> ttbbll = new ArrayList<Tabl>();
    public int ik = 0;

    public static final JCheckBox fileChoosercBox = new JCheckBox(" enable / disable");

    public static int maxColRow = 101;

    public static String pathDField = "D:\\WorkNetBeans\\KbTools\\ontology\\";
    public static String pathTField = "D:\\WorkNetBeans\\KbTools\\ontology\\Files\\";
    public static String[] rowTemplate = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    public static final JCheckBox showMessBox = new JCheckBox(" enable / disable");
    public static JTextField qtableField = new JTextField("20", JButton.RIGHT);

    public ArrayList<String> pList = new ArrayList<String>();
    public ArrayList<String> fList = new ArrayList<String>();
    public ArrayList<String> cList = new ArrayList<String>();
    public ArrayList<String> tList = new ArrayList<String>();
    public ArrayList<String> vList = new ArrayList<String>();
    public ArrayList<String> eList = new ArrayList<String>();
    public ArrayList<String> hList = new ArrayList<String>();

    public static javax.swing.JTabbedPane jToolTabPanel = new JTabbedPane();
    public static String[] hSchema;
    private int qtbThing;
    private String fileTName;

    public Tabl mt = null;
    public Tabl thr = null;
    private static final JPanel hierarchyPanel = new JPanel();
    private static final JPanel dictionaryPanel = new JPanel();

    private javax.swing.JScrollPane jScrollThingTables = new javax.swing.JScrollPane();
    private javax.swing.JScrollPane jScrollTables = new javax.swing.JScrollPane();

    public static javax.swing.JTabbedPane things = new javax.swing.JTabbedPane();
    private final javax.swing.JButton graphType = new JButton("GraphOf Types");
    private final javax.swing.JButton graph_2Graph = new JButton("GraphBy_Fields");
    private final javax.swing.JButton graph_3Graph = new JButton("Graph_3 XML");
    private final javax.swing.JButton graph_4Graph = new JButton("Property by Types");
    private final javax.swing.JButton showRelations = new JButton("toShow Relations");

    // Constructor 
    //==========================================================================
    public ToolBar() {
        super("\"OntoDataPanel\" from Vasyl Lyahkevych, CSSIG 2016");

        getContentPane().add(jToolTabPanel);
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(new ToolBar.HelpAction());
        helpMenu.addSeparator();
        helpMenu.setMnemonic('H');

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
    }

    // The implementation of the help button in the menu      
    //==========================================================================
    private class HelpAction extends AbstractAction {

        public HelpAction() {
            Icon ic = UIManager.getIcon("OptionPane.questionIcon");
            putValue(Action.SMALL_ICON, ic);
            putValue(Action.NAME, "Useful information");
            putValue(Action.SHORT_DESCRIPTION, "Help for working with ontology");
            putValue(Action.MNEMONIC_KEY, new Integer('N'));
        }

        public void actionPerformed(ActionEvent event) {
            //
        }
    }

    // The implementation of the button's listeners      
    //==========================================================================
    public void initComponents() {

        showRelations.addActionListener((ActionEvent e) -> {
            qtbThing = jTableThingPlenty.getRowCount();
            getThingRelations();
        });
        graph_2Graph.addActionListener((ActionEvent e) -> {
            getByFieldsGraphXML();
        });
        graph_3Graph.addActionListener((ActionEvent e) -> {
//            getGraphByFields();
        });
        graph_4Graph.addActionListener((ActionEvent e) -> {
            doFillProperty();
        });
        graphType.addActionListener((ActionEvent e) -> {
            getHierarchyTypeXML();
        });

        // Dictionary panel 
        DictionaryPanel dp = new DictionaryPanel();
        dp.getThingDictionaryPane(hierarchyPanel).getAccessibleContext().setAccessibleParent(jToolTabPanel);
        jToolTabPanel.getAccessibleContext().setAccessibleName("Types");
        jToolTabPanel.addTab("Types", dp.getThingDictionaryPane(hierarchyPanel));
        jToolTabPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // Keyword analysis
        TextAnalysis tan = new TextAnalysis();
        tan.getAnalysisPane().getAccessibleContext().setAccessibleParent(jToolTabPanel);
        jToolTabPanel.getAccessibleContext().setAccessibleName("TextProcessing");
        jToolTabPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToolTabPanel.addTab("TextProcessing", tan.getAnalysisPane());

        // The presentation panel
        jScrollThingTables.setViewportView(getThingInterface());
        jScrollThingTables.getAccessibleContext().setAccessibleParent(jToolTabPanel);
        jToolTabPanel.getAccessibleContext().setAccessibleName("Properties");
        jToolTabPanel.addTab("Properties", jScrollThingTables);
        jToolTabPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    // To create the tables for presentation the semantic relations
    //==========================================================================
    public void getThingRelations() {
        String rname = "";
        ttbbll = new ArrayList<Tabl>();

        if (thr == null) {
            for (int i = 0; i < qtbThing; i++) {
                thr = new Tabl(things);
                thr.getTableTemplate(null).getAccessibleContext().setAccessibleParent(things);
                rname = jTableThingPlenty.getModel().getValueAt(i, 1).toString();
                things.getAccessibleContext().setAccessibleName(rname);
                things.addTab(rname, thr.getTableTemplate(rname));
                ttbbll.add(thr);
            }
        } else {
            for (int i = qtbThing + 1; i < jTableThingPlenty.getRowCount(); i++) {
                thr = new Tabl(things);
                thr.getTableTemplate(null).getAccessibleContext().setAccessibleParent(things);
                rname = jTableThingPlenty.getModel().getValueAt(i, 1).toString();
                things.getAccessibleContext().setAccessibleName(jTableThingPlenty.getModel().getValueAt(i, 1).toString());
                things.addTab(rname, thr.getTableTemplate(rname));
                ttbbll.add(thr);
            }
            qtbThing = jTableThingPlenty.getRowCount();
        }
    }

    // To create interface part for relation presentation
    //==========================================================================
    public JPanel getThingInterface() {
        JPanel buttonThingPane = new JPanel();
        buttonThingPane.setBorder(javax.swing.BorderFactory.createTitledBorder("The presentations of the type's relations"));
        buttonThingPane.setBackground(Color.lightGray);

        GroupLayout layout = new GroupLayout(buttonThingPane);
        buttonThingPane.setLayout(layout);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(graphType, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(graph_2Graph, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(graph_3Graph, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(graph_4Graph, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(showRelations, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addComponent(things, GroupLayout.PREFERRED_SIZE, 1500, GroupLayout.PREFERRED_SIZE))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(graphType, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(graph_2Graph, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(graph_3Graph, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(graph_4Graph, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(showRelations, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(things, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE)
                )
        );
        return buttonThingPane;
    }

    // To search the type of relations
    //==========================================================================
    private int getPosition(String strPos) {
        int pos = -1;
        for (int i = 0; i < DictionaryPanel.jTableThingPlenty.getRowCount(); i++) {
            if (DictionaryPanel.jTableThingPlenty.getModel().getValueAt(i, 1).toString().equals(strPos)) {
                pos = i;
            }
        }
        if (pos == -1) {
            JOptionPane.showMessageDialog(null, "Incorrect name of relations ?");
        }
        return pos;
    }

    // To fill relations between properties and entities
    //==========================================================================
    private void doFillProperty() {
        String entname = null;
        ArrayList<String> entList = new ArrayList<String>();
        int p = getPosition("isProperty");
        things.setSelectedIndex(p);
//        String tlname = ttbbll.get(1).table.getColumnModel().getColumn(0).getHeaderValue().toString();
//        JOptionPane.showMessageDialog(null, tlname);
        int row = ttbbll.get(p).table.getRowCount();
        int col = ttbbll.get(p).table.getColumnCount();

        new ParseTypeTree();

        for (int i = 0; i < row; i++) {
            String str = ttbbll.get(p).table.getModel().getValueAt(i, 0).toString();
            ttbbll.get(p).table.setRowSelectionInterval(i, i);
            entList = new ArrayList<String>();
            entname = null;
            for (int j = 0; j < typeArray.length; j++) {
                if (typeArray[j][1] == null) {
                    continue;
                }
                if (typeArray[j][0] != null) {
                    entname = typeArray[j][0];
                }
                if (typeArray[j][1].equals(str)) {
                    entList.add(entname);
                    entname = null;
                }
            }
            for (int j = 0; j < col; j++) {
                String entity_name = ttbbll.get(p).table.getColumnModel().getColumn(j).getHeaderValue().toString();
                if (entList.contains(entity_name)) {
                    ttbbll.get(p).table.getModel().setValueAt("X", i, j);
                }
            }
        }
    }

    //To delete duplication and to sort after the list of array
    //===========================================
    public ArrayList<String> DelDupl(ArrayList<String> array) {
        ArrayList<String> result = new ArrayList<String>(new HashSet<String>(array));
        Collections.sort(result);
//        System.out.println(result);
        return result;
    }

    //************************************************************************************
    // To create JSONArray from data
    //===========================================
    public void doCreatePType() throws IOException {
//        new ParseTypeTree();
        int pos = 0;
        pos = getPosition("isDataType");

        JSONObject obj = new JSONObject();
        JSONObject objE = new JSONObject();
        JSONObject objP = new JSONObject();
        JSONArray eList = new JSONArray();
        JSONArray pList = new JSONArray();
        JSONArray dList = new JSONArray();
        String ent_name = "";
        String prp_name = "";

        int i = 0;
        boolean stPrp = false;
        boolean stEnt = false;
        while (typeArray[i][2] != null) {
            if ((typeArray[i][0] != null) & (typeArray[i][1] != null) & (typeArray[i][2] != null)) {
                if (stEnt) {
                    objE = new JSONObject();
                    objE.put(ent_name, pList);
                    eList.add(objE);
                    obj.put("Entity", eList);
                    stEnt = false;
                }
                stEnt = true;
                ent_name = typeArray[i][0];
                prp_name = typeArray[i][1];
                pList = new JSONArray();
                dList = new JSONArray();
                dList.add(typeArray[i++][2]);
                objP = new JSONObject();
                stPrp = true;
            }
            while ((typeArray[i][0] == null) & (typeArray[i][1] == null) & (typeArray[i][2] != null)) {
                while ((typeArray[i][1] == null) & (typeArray[i][2] != null)) {
                    dList.add(typeArray[i++][2]);
                }
                objP.put(prp_name, dList);
                pList.add(objP);
            }

            while ((typeArray[i][0] == null) & (typeArray[i][1] != null) & (typeArray[i][2] != null)) {
                if (stPrp) {
                    objP.put(prp_name, dList);
                    pList.add(objP);
                    stPrp = false;
                }
                prp_name = typeArray[i][1];
                dList = new JSONArray();
                dList.add(typeArray[i++][2]);
                while ((typeArray[i][1] == null) & (typeArray[i][2] != null)) {
                    dList.add(typeArray[i++][2]);
                }
                objP = new JSONObject();
                objP.put(prp_name, dList);
                pList.add(objP);
                dList = new JSONArray();
            }
        }

        try {
            FileWriter file = new FileWriter(FManager.main("To choose JSON file for writing!"));
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//	System.out.print(obj);
    }

//    // To create the answer graph
//    // =========================================================================
//    public void getTypeFields(String[] nameGroup, String nOf) {
//        int pos = 0;
//        String fn = "isFields_" + nOf + ".xml";
//        boolean flag = false;
//        String curProperty = "";
//
//        fileTName = pathTField + fn;
//        JFileChooser fileChooser = new JFileChooser();
//        FileFilter filter = new FileNameExtensionFilter("dictionary files", "xml");
//        fileChooser.addChoosableFileFilter(filter);
//        fileChooser.setDialogTitle("Choose a file to save of the Hierarchy of types");
//        fileChooser.setSelectedFile(new File(fileTName));
//        int userSelection = fileChooser.showSaveDialog(fileChooser);
//        if (userSelection == JFileChooser.APPROVE_OPTION) {
//            fileTName = fileChooser.getSelectedFile().getAbsolutePath();
//        }
//
//        try {
//            DocumentBuilderFactory docTFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder docTBuilder = docTFactory.newDocumentBuilder();
//            Document doc = docTBuilder.newDocument();
//            Element rootElement = doc.createElement("types");
//            doc.appendChild(rootElement);
//
//            String typeBySchema = null;
//            for (int i = 0; i < nameGroup.length; i++) {
//                typeBySchema = nameGroup[i];
//                Element hierarchy = doc.createElement("is-type");
//                Element type_name = doc.createElement("type");
//                type_name.appendChild(doc.createTextNode(typeBySchema));
//                hierarchy.appendChild(type_name);
//
//                tList = new ArrayList<String>();
//                vList = new ArrayList<String>();
//                pList = new ArrayList<String>();
//                eList = new ArrayList<String>();
//                typeMap(tList, typeBySchema, 0);
//
//                pList = DelDupl(pList);
//                for (int it = 0; it < pList.size(); it++) {
//                    curProperty = pList.get(it);
//                    pos = getPosition("isDataType");
//                    int pos_ot4 = 1000 * pos;
//                    int pos_ot4_end = 1000 * pos + 1000;
//                    Element is_property = doc.createElement("is-property");
//
//                    for (int i_ot4 = pos_ot4 + 1; i_ot4 < pos_ot4_end; i_ot4++) {
//                        if (curProperty.equals(dataRelations[i_ot4][pos_ot4])) {
//                            flag = true;
//                            for (int j_ot4 = pos_ot4 + 1; j_ot4 < pos_ot4_end; j_ot4++) {
//                                if (dataRelations[i_ot4][j_ot4] == null) {
//                                    continue;
//                                }
//                                if (dataRelations[i_ot4][j_ot4].equals("X")) {
//                                    if (flag) {
//                                        Element pname = doc.createElement("pname");
//                                        pname.appendChild(doc.createTextNode(curProperty));
//                                        is_property.appendChild(pname);
//                                        flag = false;
//                                    }
//
//                                    Element dtype = doc.createElement("dtype");
//                                    String dtype_value = dataRelations[pos_ot4][j_ot4];
//                                    dtype.appendChild(doc.createTextNode(dtype_value));
//                                    is_property.appendChild(dtype);
//                                    hierarchy.appendChild(is_property);
//
//                                }
//                            }
//                        }
//                    }
//                }
//                rootElement.appendChild(hierarchy);
//            }
//
//            // write the content into xml file
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(doc);
//
//            StreamResult result = new StreamResult(new File(fileTName));
//            transformer.transform(source, result);
//            JOptionPane.showMessageDialog(null, "File saved!");
//
//        } catch (ParserConfigurationException | TransformerException pce) {
//        }
//    }
//
    // To create the answer graph
    // =========================================================================
    public void getByFieldsGraphXML() {
        /*            
            for(int i=0; i<8000; i++)
                for(int j=0; j<8000; j++) {
                    if (dataRelations[i][j]==null) {continue;}
                    System.out.println("i="+i+" j= "+j+"  : "+dataRelations[i][j]);
                }
         */
        int pos = 0;

        fileTName = pathTField + "ThingByFields.xml";
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("dictionary files", "xml");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setDialogTitle("Choose a file to save of the Hierarchy of types");
        fileChooser.setSelectedFile(new File(fileTName));
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileTName = fileChooser.getSelectedFile().getAbsolutePath();
        }

        try {
            DocumentBuilderFactory docTFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docTBuilder = docTFactory.newDocumentBuilder();
            Document doc = docTBuilder.newDocument();
            Element rootElement = doc.createElement("types");
            doc.appendChild(rootElement);

            String schema = null;
//            for (int i = 0; i < hSchema.length; i++) {
//                schema = hSchema[i];
//                // ========   To find the "isTypeProperty" position for types =====================
//                pos = getTypePosition("isTypeProperty");
//                int pos_ot2 = 1000 * pos;
//                int pos_ot2_end = 1000 * pos + 1000;
//       
//                rootElement.appendChild(hierarchy);
//            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File(fileTName));
            transformer.transform(source, result);
            JOptionPane.showMessageDialog(null, "File saved!");

        } catch (ParserConfigurationException | TransformerException pce) {
        }
    }

    // To create the answer graph
    // =========================================================================
    public void getHierarchyTypeXML() {
        /*            
            for(int i=0; i<8000; i++)
                for(int j=0; j<8000; j++) {
                    if (dataRelations[i][j]==null) {continue;}
                    System.out.println("i="+i+" j= "+j+"  : "+dataRelations[i][j]);
                }
         */
        int pos = 0;

        fileTName = pathTField + "Thing.xml";
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("dictionary files", "xml");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setDialogTitle("Choose a file to save of the Hierarchy of types");
        fileChooser.setSelectedFile(new File(fileTName));
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileTName = fileChooser.getSelectedFile().getAbsolutePath();
        }

        try {
            DocumentBuilderFactory docTFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docTBuilder = docTFactory.newDocumentBuilder();
            Document doc = docTBuilder.newDocument();
            Element rootElement = doc.createElement("types");
            doc.appendChild(rootElement);

//            // ==========  To choose list of types ========================
//            pos = getTypePosition("isEntity");
//            int pos_st0 = 1000 * pos;
//            int pos_st0_end = 1000 * pos + 1000;
//
//                        is_type.appendChild(is_inherited_in);
//                        // ========   End of the "isInheritedIn" position for types  =====================
//
//                    }
//                    rootElement.appendChild(is_type);
//                }
//            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File(fileTName));
            transformer.transform(source, result);
            JOptionPane.showMessageDialog(null, "File saved!");

        } catch (ParserConfigurationException | TransformerException pce) {
        }
    }
    // The main method
    //==========================================================================

    public static void main(String args[]) {
        ToolBar tb = new ToolBar();
        tb.setDefaultCloseOperation(EXIT_ON_CLOSE);
        tb.setVisible(true);
    }

}
