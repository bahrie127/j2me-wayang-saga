/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wayang.game.main;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStoreException;

/**
 *
 * @author fendi
 */
public class RecordTime extends Canvas implements Runnable, CommandListener {
    private int defFontHeight=Font.getDefaultFont().getHeight();
    private Display display;
    private MIDlet midlet;
    private boolean showSplashScreen = true;
    private Image piala;
    private String[] scoreData;
    private ScoreManager sm;
    private Command commBack = null;
    private MenuUtama mu;

    public RecordTime(Display display, MenuUtama mu) throws RecordStoreException {
        this.mu = mu;
        this.display = display;
        this.display.setCurrent(this);
        this.sm = new ScoreManager();
        this.sm.getScore();
        this.commBack = new Command("Back", Command.BACK, 1);
        this.addCommand(commBack);
        this.setCommandListener((CommandListener) this);
    }

    protected void paint(Graphics g) {
        try {
            g.setColor(255, 255, 255);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(0, 0, 0);
            this.piala = (Image) ImgSource.img.get("piala");
            g.drawImage(piala, 10, 10, Graphics.TOP | Graphics.LEFT);
            g.setColor(0x000000);
            scoreData = sm.getScore();
            for (int i = 0; i < scoreData.length; i++) {
                int ff = i + 1;
                g.drawString(ff + ".  " + scoreData[i], this.getWidth() / 2, (this.getHeight() / 3) + (defFontHeight * (i * 1)), Graphics.TOP | Graphics.LEFT);
            }
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
            

    }

    public void run() {
        try {
            Thread.sleep(30);
            repaint();
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
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
