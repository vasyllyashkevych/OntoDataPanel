package org.cssig.kb.util;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FNManager {

    public static String main(String arg, String ext) {
        String fName = null;
        JFileChooser fileopen = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Dialogs files", ext);
        fileopen.setAcceptAllFileFilterUsed(true);
        fileopen.addChoosableFileFilter(filter);

        int result = fileopen.showDialog(null, arg);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            fName = file.getPath();
        }
        return fName;
    }
}
