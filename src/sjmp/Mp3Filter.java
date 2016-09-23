package sjmp;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class Mp3Filter extends FileFilter {

    public Mp3Filter() {
}

public boolean accept (File f) {
    if (f.isDirectory()) {
            return true;
    }
    String file = f.getName().toUpperCase();
    if (file.endsWith(".MP3") || file.endsWith(".OGG")) {
        return true;
    }
    return false;
    }  

    public String getDescription() {
    return "MP3 files (.mp3)";
    }

}