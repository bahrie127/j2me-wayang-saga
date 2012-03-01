/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wayang.game.main;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStoreException;

/**
 *
 * @author fendi
 */
public class RekorWaktu extends GameCanvas implements Runnable, CommandListener {

    private Display display;
    private MIDlet midlet;
    private boolean showSplashScreen = true;
    private Image piala;
    private String[] scoreData;
    private ScoreManager sm;
    private Command commBack = null;
    private MenuUtama mu;
    private boolean ccc;
    public static boolean STOP = false;

    public RekorWaktu(Display display, MenuUtama mu) throws RecordStoreException {
        super(true);
        this.display = display;

        this.sm = new ScoreManager();
      
        this.mu = mu;
        this.sm.getScore();
        this.commBack = new Command("Back", Command.BACK, 1);
       
    }

    protected void rekoR(Graphics g) {
        try {
            g.setColor(0x000000);
            scoreData = sm.getScore();
            for (int i = 0; i < scoreData.length; i++) {
                g.drawString(scoreData[i], 180 + (i*2), 100, Graphics.TOP | Graphics.LEFT);

            }
            g.setColor(255, 255, 255);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(0, 0, 0);
            this.piala = (Image) ImgSource.img.get("piala");
            g.drawImage(piala, 10, 0, Graphics.TOP | Graphics.LEFT);
            this.addCommand(commBack);
            this.setCommandListener((CommandListener) this);
          
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
       
    }

    public void start() {

        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        STOP = true;
        }

    public void run() {
        while (!ccc) {
            repaint();
            Graphics g = getGraphics();
            rekoR(g);
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c.equals(commBack)) {
            try {
                MenuUtama mm = new MenuUtama(display, midlet);
               display.setCurrent(mm);
            } catch (RecordStoreException ex) {
                ex.printStackTrace();
            }

        }
    }
}
