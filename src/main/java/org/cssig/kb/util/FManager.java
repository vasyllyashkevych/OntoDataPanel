package org.cssig.kb.util;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FManager {

    static File file;

    public static File main(String arg) {
        JFileChooser fileopen = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Dialogs files", "txt");
        fileopen.setAcceptAllFileFilterUsed(true);
        fileopen.addChoosableFileFilter(filter);

        int result = fileopen.showDialog(null, arg);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileopen.getSelectedFile();
        }
        return file;
    }
}
