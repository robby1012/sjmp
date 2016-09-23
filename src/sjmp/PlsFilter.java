package sjmp;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class PlsFilter extends FileFilter {

    public PlsFilter() {
	}

	public boolean accept (File p) {
    if (p.isDirectory()) {
        return true;
    }
    String file = p.getName().toUpperCase();
    if (file.endsWith(".M3U")) {
        return true;
    }
    return false;
    }  

    public String getDescription() {
    return "Playlist (.m3u)";
    }

}