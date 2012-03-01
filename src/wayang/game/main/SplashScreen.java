/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wayang.game.main;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Ticker;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStoreException;

/**
 *
 * @author fendi
 */
public class SplashScreen extends Canvas implements Runnable,CommandListener {

   private Display display;
    private MIDlet midlet;
    private int selectPoint = 0;
    private boolean showSplashScreen = true;
    private boolean bbb = true;
    private Thread thread = null;
    private Command commBack = null;
    private Image loadin, men;
    private Image play; //menu
    private Image play2, piala; //menu2
    private Form formHelp = null;
    private Form formHs = null;
    private Form option = null;
    public String on;
    private boolean bg;
    public ChoiceGroup cg = new ChoiceGroup("Language Options", Choice.EXCLUSIVE);
    private int it, h = 0;
    private int ri;
    private int cGi;
    private Command cmExit;      // A Command to exit the MIDlet
    private Command cmView;      // View the choice selected
    private boolean coba = true;
    private Sprite sprite;
    private Image bagong;
    private Game gg;
    private ScoreManager sm;
    private String[] scoreData;
    private Graphics ghj;
    private RekorWaktu rw;
    private boolean n = true;
    private MenuUtama mu;
    private boolean metu=false;
    private boolean  mmmm= true;


    public SplashScreen(Display display, MIDlet midlet) {

        this.midlet = midlet;
        this.display = display;
        this.display.setCurrent(this);
        this.setFullScreenMode(true);
//        this.n=n;
        this.commBack = new Command("Back", Command.BACK, 1);
    }


    void keluar(){
        System.out.println("fggfajhdfja");
        mmmm=false;
        metu=true;
    }

    protected void paint(Graphics g) {

       if (!showSplashScreen) {
            try {
             MenuUtama mmm = new MenuUtama(display, midlet);
             display.setCurrent(mmm);
            } catch (RecordStoreException ex) {
                ex.printStackTrace();
            }

        } else {
            this.loadin = (Image) ImgSource.img.get("loading");
            g.drawImage(loadin, 0, 0, Graphics.TOP | Graphics.LEFT);
            thread = new Thread(this);
            thread.start();

            ImgSource.getInstance();
        }
    }

    public void display() {
        display.setCurrent(this);
    }

    public void run() {

    if(!mmmm){
       
        this.midlet.notifyDestroyed();
    }

   
         try {
            Thread.sleep(3000);
            repaint();
            showSplashScreen = false;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    
       
    }

    protected void keyPressed(int keyCode) {
//        if (this.getGameAction(keyCode) == MenuUtama.DOWN) {
//            selectPoint = selectPoint + 1;
//            if (selectPoint > 5 - 1) {
//                selectPoint = 0;
//            }
//        } else if (this.getGameAction(keyCode) == MenuUtama.UP) {
//            selectPoint = selectPoint - 1;
//            if (selectPoint < 0) {
//                selectPoint = 5 - 1;
//            }
//        } else if (this.getGameAction(keyCode) == MenuUtama.FIRE) {
//            if (selectPoint == 0) {
//
//                try {
//                    gg = new Game(display, this);
//                    display.setCurrent(gg);
//                    gg.start();
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                } catch (RecordStoreException ex) {
//                    ex.printStackTrace();
//                }
//
//
//
//            } else if (selectPoint == 1) {
//                try {
//                    RecordTime rt = new RecordTime(display, this);
//                    display.setCurrent(rt);
//                } catch (RecordStoreException ex) {
//                    ex.printStackTrace();
//                }
//
//
//
//            } else if (selectPoint == 2) {
//
//                display.setCurrent(formHelp);
//            } else if (selectPoint == 3) {
//
//                MengenalWayang mw = new MengenalWayang(display, this);
//                display.setCurrent(mw);
//
//            } else if (selectPoint == 4) {
//                midlet.notifyDestroyed();
//            }
//        }
//        this.repaint();
    }

    public void commandAction(Command c, Displayable d) {

        if (c.equals(commBack)) {
            display.setCurrent(this);

        }

    }
}
