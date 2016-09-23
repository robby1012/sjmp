package sjmp;

import java.io.*;
import java.util.*;
import javax.media.ControllerErrorEvent;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Manager;
import javax.media.Player;
import javax.media.RealizeCompleteEvent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.jaudiotagger.audio.mp3.MP3File;

public class Action {

    private JFileChooser FileChooser = new JFileChooser();
    private Mp3Filter filter = new Mp3Filter();
    private PlsFilter PlsFilter = new PlsFilter();
    public ArrayList listSong = new ArrayList();
    public int statusPlay = 0;
    public int duration = 1;
    public int mp3length;
    public Player player;
    public File song, mp3;
    private FileOutputStream fos;
    private FileInputStream fis, in;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    public String artis, album, year, title, info, bitrate, samplerate, channels, comment;
    private ID3v1Tag id3;
    private MPEGAudioFrameHeader mp3header;
    public int playable;

    /** method adding multiple mp3 files using MultiSelection Mode
     *  and convert multiple files to arraylist
     * @param listsong
     */
    public void addFile(JFrame frame) {
        FileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileChooser.setFileFilter(filter);
        FileChooser.setMultiSelectionEnabled(true);
        int fileValid = FileChooser.showOpenDialog(frame);
        if (fileValid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;
        }
        else if(fileValid == javax.swing.JFileChooser.APPROVE_OPTION) {
            File[] file = FileChooser.getSelectedFiles();
            listSong.addAll(Arrays.asList(file));
        }
    }

    public void addFolder(JFrame frame) throws IOException {
        FileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        FileChooser.setFileFilter(null);
        FileChooser.setAcceptAllFileFilterUsed(false);
        int fileValid = FileChooser.showOpenDialog(frame);
        if (fileValid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;
        }
        else if(fileValid == javax.swing.JFileChooser.APPROVE_OPTION) {
           File file = FileChooser.getSelectedFile();
           searchFolder(file, true);
        }
    }


    /** method adding singel mp3 file
     *  the only convert one file to playlist arraylist
     * @param frame
     */

    public void openFile(JFrame frame) {
        FileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileChooser.setFileFilter(filter);
        FileChooser.setMultiSelectionEnabled(false);
        int fileValid = FileChooser.showOpenDialog(frame);
        if (fileValid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;
        }
        if(fileValid == javax.swing.JFileChooser.APPROVE_OPTION) {
            File file = FileChooser.getSelectedFile();
            listSong.add(file);
        }
    }

    /** method read arraylist by returning arraylist value
     *
     * @return
     */
    public ArrayList getListSong() {
        return listSong;
    }

    /** remove selected song in Jlist
     *  then convert it to arraylist index
     * @param index
     */
    public void deleteFile(int index) {
        listSong.remove(index);
    }

    /** remove all content in arraylist (listSong)
     * @param removeAll
     */
    public void deletePlaylist () {
        listSong.removeAll(listSong);
    }

    /** save arraylist to temporary file in same folder
     *  with SJMP JAR
     *  @param fos
     */

    public void saveList(){
        try {
            fos = new FileOutputStream("song.list");
            oos = new ObjectOutputStream(fos);
            for (int i = 0; i < listSong.size(); i++){
                File tmp = (File) listSong.get(i);
                oos.writeObject(tmp);
            }
            oos.close();
        }
        catch (Exception e)
        {
            
        }
    }

    /** Method save as Playlist to a file using in spesific location
     *  write all content in arraylist to a file
     * @param frame 
     */

    public void saveAsPlaylist(JFrame frame) {
        FileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileChooser.setFileFilter(PlsFilter);
        FileChooser.setMultiSelectionEnabled(false);
        int Valid = FileChooser.showSaveDialog(frame);
        if (Valid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;
        }
        else if (Valid == javax.swing.JFileChooser.APPROVE_OPTION) {
            File pls = FileChooser.getSelectedFile();
            try {
            fos = new FileOutputStream(pls+".m3u");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw);
            String out = writeM3u();
            writer.write(out);
            writer.close();
            }
            catch (Exception e)
            {
            
            }
        }
    }
	
	public void openPls(JFrame frame) {
        FileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileChooser.setFileFilter(PlsFilter);
        FileChooser.setMultiSelectionEnabled(false);
        int Valid = FileChooser.showOpenDialog(frame);
        if (Valid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;
        }
        if(Valid == javax.swing.JFileChooser.APPROVE_OPTION) {
            try {
            File pls = FileChooser.getSelectedFile();
            fis = new FileInputStream(pls);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            while (line != null)  {
            boolean linetype = line.endsWith(".mp3") || line.endsWith(".MP3");
            if (linetype == true) {
                song = new File(line);
                listSong.add(song);
            }
            line = reader.readLine();
            }
            }
            catch (Exception e) {
			}
        }

        
    }
	
    public String writeM3u() {
        String str = "#EXTM3U\r\n";
        listSong = getListSong();
        File file = null;
		String artist = new String();
		String songtitle = new String();
        int time;
		for( int i =0; i < listSong.size(); i++ ) {
	    file = (File) listSong.get(i);
            try {
            id3 = new ID3v1Tag(file);
            mp3header = new MPEGAudioFrameHeader(file);
            MP3File extHeader = new MP3File(file);
            time = (int) Math.floor(extHeader.getMP3AudioHeader().getPreciseTrackLength());
	    str += "#EXTINF:" + time + ",";
            }
            catch (Exception e) {

            }
	    try {
		artist = id3.getArtist();
	    }
	    catch( Exception e ) {
	    }

	    try {
		songtitle = id3.getTitle();
	    }
	    catch( Exception e ) {
	    }

	    if( (artist.trim().length() == 0) ||
		(songtitle.trim().length() == 0) ) {

		artist = id3.getArtist();
		//artist = artist.substring( 0, artist.length() - 4 );
	    }

	    str += artist + " - " + songtitle + "\r\n";
	    str += file.getAbsolutePath() + "\r\n";
	}

	return str;
    }

    public void readList() {
        try {
            fis = new FileInputStream("Song.list");
            ois = new ObjectInputStream(fis);
            File tmp;
            while ((tmp = (File) ois.readObject()) != null) {
                listSong.add(tmp);
            }
            if ((tmp = (File) ois.readObject()) == null) {
                listSong.isEmpty();
            }
            ois.close();
        } catch (Exception e) {
        }
     }

    /** Method read arraylist in file at spesific location
     *  then write it to Arraylist Component (JList)
     * @param frame
     */


    /** read mp3 filename then convert it to String
     *
     * @return
     */
    public String getTitle() {
        return song.getName();
    }

    /** Method convert selected index to mp3 location then read ID3tag
     *  and all mp3 info including Bitrate, Sample rate and Audio channels
     * @param index
     */
    public void setNewSong(int index) {
        song = (File) listSong.get(index);
        try {
            player = Manager.createPlayer(song.toURL());
            MP3File extHeader = new MP3File(song);
            duration = (int) Math.floor(extHeader.getMP3AudioHeader().getPreciseTrackLength());
            
        } catch (Exception ex) {
            
        }
    }

    /** Method play mp3 and convert mp3 length from long to int
     * 
     * @param index
     */

    public void playMusic(int index) {
        
        if (statusPlay == 0) {
            setNewSong(index);
        } else if (statusPlay == 1) {
            player.stop();
            setNewSong(index);
        }
        player.start();
        statusPlay = 1;
        try {
        player.realize();
        }
        catch (Exception e) {
        }
        player.addControllerListener(new ControllerListener() {

            @Override
            public void controllerUpdate(ControllerEvent event) {
                //System.out.println(event.toString());
                if (event instanceof RealizeCompleteEvent) {
                    duration = getPlayerDuration();
                    playable = 1;
                }
                else if (event instanceof ControllerErrorEvent) {
                    player.close();
                    playable = 0;

                }
            }
        });
    }

    /**  Method Pause Playing mp3 then set a value for playing status
     *
     */

    public void pauseMusic() {
        player.stop();
        statusPlay = 2;
        
    }

    /** Method Stop Playing mp3 then set a value for playing status
     *
     */
    public void stopMusic() {
        player.stop();
        player.close();
        statusPlay = 0;
    }

    /** return song totaltime/length value to Integer
     * 
     * @return
     */
    public int getPlayerDuration() { 
        return duration;
    }

    public void readID3(int index) {
        song = (File) listSong.get(index);
        try {
            id3 = new ID3v1Tag(song);
            MP3File extheader = new MP3File(song);
            artis = id3.getArtist();
            title = id3.getTitle();
            album = id3.getAlbum();
            year = id3.getYear();
            mp3header = new MPEGAudioFrameHeader(song);
            bitrate = String.valueOf(mp3header.getBitRate());
            samplerate = String.valueOf(mp3header.getSampleRate());
            channels = mp3header.getChannelMode();
            mp3length = (int) Math.floor(extheader.getMP3AudioHeader().getPreciseTrackLength());
            extheader.commit();
        } catch (Exception ex) {
            
        }
    }

    /** return ID3Tag And another info value to String
     *
     * @return
     */
    public String getID3() {
        info = "<html><b>Title : </b>" + title +
                "<p><b>Artist : </b>" + artis +
                "<p><b>Album : </b>" + album +
                "<p><b>Year : </b>" + year +
                "<p><b>Bitrate : </b>" + bitrate + " kbps" +
                "<p><b>Sample Rate : </b>" + samplerate + " Hz" +
                "<p><b>Channels : </b>" + channels
                + "<p><b>Length : </b>" + mp3length + " seconds"
                + "<p><b>FileSize : </b>" + (song.length() / 1024) + " KB"
                + "<p><b>Location : </b>"
                + song.getAbsolutePath();
        return info;
    }

    private void searchFolder(File dir, boolean recurse)
    throws IOException
    {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles( new ScanDir(true) );
            File[] mp3list = null;
            for (int i = 0; i < files.length; i++) {
                if( files[i].isFile() ) {
                    try {
                    mp3list = new File[i];
                    listSong.addAll(Arrays.asList(files[i]));
                    }
                    catch( Exception e ) {
			
                    }
                    }
                    else if( recurse ) {
                    searchFolder(files[i], recurse);
		}
            }
        }
        else {
            throw new IOException("error load files");
        }
    }
}