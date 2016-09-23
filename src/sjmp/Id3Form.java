package sjmp;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Id3Form extends javax.swing.JFrame {

    public Id3Form() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblArtist = new javax.swing.JLabel();
        lblAlbum = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        lblGenre = new javax.swing.JLabel();
        lblComment = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        txtArtist = new javax.swing.JTextField();
        txtAlbum = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();
        txtComment = new javax.swing.JTextField();
        cboGenre = new javax.swing.JComboBox(genreList());
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtTrack = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        txtSong = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ID3 Tag Editor");
        setResizable(false);

        lblTitle.setText("Title");
        lblTitle.setPreferredSize(new java.awt.Dimension(64, 32));

        lblArtist.setText("Artist");
        lblArtist.setPreferredSize(new java.awt.Dimension(64, 32));

        lblAlbum.setText("Album");
        lblAlbum.setPreferredSize(new java.awt.Dimension(64, 32));

        lblYear.setText("Year");
        lblYear.setPreferredSize(new java.awt.Dimension(64, 32));

        lblGenre.setText("Genre");
        lblGenre.setPreferredSize(new java.awt.Dimension(64, 32));

        lblComment.setText("Comment");
        lblComment.setPreferredSize(new java.awt.Dimension(64, 32));

        txtTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTitleKeyPressed(evt);
            }
        });

        txtArtist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtArtistKeyPressed(evt);
            }
        });

        txtAlbum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAlbumKeyPressed(evt);
            }
        });

        txtYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtYearKeyPressed(evt);
            }
        });

        txtComment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCommentKeyPressed(evt);
            }
        });

        cboGenre.setEditable(true);
        cboGenre.setMaximumRowCount(15);
        cboGenre.setAutoscrolls(true);
        cboGenre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboGenreKeyPressed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(80, 32));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(80, 32));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtTrack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/go-next.png"))); // NOI18N
        btnNext.setContentAreaFilled(false);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/go-previous.png"))); // NOI18N
        btnPrev.setContentAreaFilled(false);
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        txtSong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addComponent(txtSong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTrack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSong, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        saveEdit();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
       
        song = getSong() + 1;
        if (song < list.size()) {
        int current = song + 1;
        readID3(song);
        showID3();
        }
        else {
            JOptionPane.showMessageDialog(this, "End Of Track");
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        
        song = getSong() - 1;
        if (song >= 0) {
        int current = song + 1;
        readID3(song);
        showID3();
        }
        else {
            JOptionPane.showMessageDialog(this, "First of Track");
        }
        
    }//GEN-LAST:event_btnPrevActionPerformed

    private void txtTitleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitleKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            saveEdit();
            timeshow = 2;
            count();
        }
    }//GEN-LAST:event_txtTitleKeyPressed

    private void txtArtistKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtistKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            saveEdit();
        }
    }//GEN-LAST:event_txtArtistKeyPressed

    private void txtAlbumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlbumKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            saveEdit();
        }
    }//GEN-LAST:event_txtAlbumKeyPressed

    private void txtYearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtYearKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            saveEdit();
        }
    }//GEN-LAST:event_txtYearKeyPressed

    private void txtCommentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCommentKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            saveEdit();
        }
    }//GEN-LAST:event_txtCommentKeyPressed

    private void cboGenreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboGenreKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            saveEdit();
        }
    }//GEN-LAST:event_cboGenreKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Id3Form().setVisible(true);
            }
        });
    }
    
    private void readID3(int song) {
        try {
            mp3 = (File) list.get(song);
            id3 = new ID3v1Tag(mp3);
            songtitle = id3.getTitle();
            artist = id3.getArtist();
            album = id3.getAlbum();
            year = id3.getYear();
            genre = id3.getGenreString();
            comment = id3.getComment();
        }
        catch (Exception e) {
           
        }
    }

    @SuppressWarnings("unchecked")
    private void showID3() {
        try {
        txtTitle.setText(songtitle);
        txtArtist.setText(artist);
        txtAlbum.setText(album);
        txtYear.setText(year);
        txtComment.setText(comment);
        cboGenre.setSelectedItem(id3.getGenreString());
        txtSong.setText(mp3.getName());
        int current = song + 1;
        txtTrack.setText(current + " / " + list.size());
        }
        catch (Exception e) {
            
        }
    }

    private void saveEdit() {
        try {
        id3.setTitle(txtTitle.getText());
        id3.setArtist(txtArtist.getText());
        id3.setAlbum(txtAlbum.getText());
        id3.setYear(txtYear.getText());
        id3.setComment(txtComment.getText());
        try {
            id3.setGenre(cboGenre.getSelectedIndex());
        } catch (ID3FieldDataException ex) {

        }
        id3.writeTag();
        txtSong.setText("Id3 Saved");
        timeshow = 2;
        count();
        } catch (IOException eo) {
            txtSong.setText("error saving ID3");
        }
    }

    public void count() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
         public void run(){
             if (timeshow > 0) {
                 timeshow--;
             }
             else {
                 timer.cancel();
                 txtSong.setText(mp3.getName());
             }
         }
        },delay, period);
    }
    
    public int getSong() {
        return song;
    }

    public String[] genreList() {
        Arrays.sort(genres);
        return genres;
    }

    private Action action = new Action();
    private File mp3;
    private String songtitle, artist, album, year, comment, genre;
    private ID3v1Tag id3;
    private Player ply = new Player();
    private ArrayList list = ply.getList();
    private JList listsong = ply.listSong;
    private int song, timeshow;
    private Timer timer = new Timer();
    private int delay = 0;
    private int period = 1000;
    private NullsoftID3GenreTable id3genre = new NullsoftID3GenreTable();
    private String[] genres = NullsoftID3GenreTable.getGenres();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cboGenre;
    private javax.swing.JLabel lblAlbum;
    private javax.swing.JLabel lblArtist;
    private javax.swing.JLabel lblComment;
    private javax.swing.JLabel lblGenre;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblYear;
    private javax.swing.JTextField txtAlbum;
    private javax.swing.JTextField txtArtist;
    private javax.swing.JTextField txtComment;
    private javax.swing.JLabel txtSong;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JLabel txtTrack;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables

    Component addComponentListener(JList listSong) {
        song = listSong.getSelectedIndex();
        readID3(song);
        showID3();
        return listSong;
    }
}
