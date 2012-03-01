/**
 *              ^_^ >>> ^_^           *
 */
package wayang.game.main;

import java.io.IOException;
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
 * @author Fendi
 */
public class MenuUtama extends Canvas implements Runnable, CommandListener {

    private Display display;
    private MIDlet midlet;
    private int selectPoint = 0;
    private boolean showSplashScreen = false;
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
    private SplashScreen ss;

    public MenuUtama(Display display, MIDlet midlet) throws RecordStoreException {


        this.midlet = midlet;
        this.display = display;
        this.display.setCurrent(this);
        this.setFullScreenMode(true);
//        this.n=n;
        this.commBack = new Command("Back", Command.BACK, 1);
        this.sm = new ScoreManager();
        this.sm.getScore();
        //menu HighScore
        this.formHs = new Form("HIGH SCORE");
        this.formHs.addCommand(commBack);
        this.formHs.setCommandListener(this);



        //menu help
        this.formHelp = new Form("HELP...");
        Ticker ticker = new Ticker("Welcome to Game DAYANG (Game Madak-ke gambar wayang...)");
        formHelp.append("Game Wayang");
        formHelp.setTicker(ticker);
        formHelp.append("Permainan ini adalah permainan"
                + "yang menuntut anda mempunyai daya ingat yang tinggi."
                + " Permainan ini adalah permainan mencocokan gambar wayang\n");
        formHelp.append("key Fire buat select gambar...");
        formHelp.append("Left,Right,Up,Down buat pilih gambar");
        formHelp.setCommandListener(this);
        formHelp.addCommand(commBack);

    }

    public void displayOp() {
        if (coba) {
            on = "On";
        }
        cg = new ChoiceGroup("Language Options", Choice.EXCLUSIVE);

        ri = cg.append(on, null);
        cg.append("Off", null);


        cg.setSelectedIndex(ri, true);

        cmView = new Command("View", Command.SCREEN, 2);

        option = new Form("");

        cGi = option.append(cg);

        option.addCommand(commBack);
        option.setCommandListener(this);
        display.setCurrent(option);

    }

//    public void displayHs() throws RecordStoreException {
//
//        this.formHs.deleteAll();
//        scoreData = sm.getScore();
//        this.piala = (Image) ImgSource.img.get("piala");
//        formHs.append(piala);
//
//        for (int i = 0; i < scoreData.length; i++) {
//            this.formHs.append(scoreData[i]);
//        }
//
//        display.setCurrent(formHs);
//    }
    void menu(Graphics g) {
        this.play = (Image) ImgSource.img.get("play");
        g.drawImage(play, 137, 75, Graphics.TOP | Graphics.LEFT);
        this.play = (Image) ImgSource.img.get("rekor");
        g.drawImage(play, 108, 105, Graphics.TOP | Graphics.LEFT);
        this.play = (Image) ImgSource.img.get("help");
        g.drawImage(play, 140, 130, Graphics.TOP | Graphics.LEFT);
        this.play = (Image) ImgSource.img.get("option");
        g.drawImage(play, 130, 157, Graphics.TOP | Graphics.LEFT);
        this.play = (Image) ImgSource.img.get("exit");
        g.drawImage(play, 140, 185, Graphics.TOP | Graphics.LEFT);
    }

    public void menuU(Graphics g) {
        this.men = (Image) ImgSource.img.get("menu");
        g.drawImage(men, 0, 0, Graphics.TOP | Graphics.LEFT);

        for (int i = 0; i < 5; i++) {
            if (selectPoint == 0)//play
            {
                this.play2 = (Image) ImgSource.img.get("sele");
                g.drawImage(play2, 102, 72, Graphics.TOP | Graphics.LEFT);
                menu(g);
            } else if (selectPoint == 1) //rekor
            {
                this.play2 = (Image) ImgSource.img.get("sele");
                g.drawImage(play2, 102, 100, Graphics.TOP | Graphics.LEFT);
                menu(g);

            } else if (selectPoint == 2) //panduan
            {
                this.play2 = (Image) ImgSource.img.get("sele");
                g.drawImage(play2, 102, 126, Graphics.TOP | Graphics.LEFT);
                menu(g);
            } else if (selectPoint == 3) //profil
            {
                this.play2 = (Image) ImgSource.img.get("sele");
                g.drawImage(play2, 102, 154, Graphics.TOP | Graphics.LEFT);
                menu(g);

            } else if (selectPoint == 4) //exit
            {
                this.play2 = (Image) ImgSource.img.get("sele");
                g.drawImage(play2, 102, 182, Graphics.TOP | Graphics.LEFT);
                menu(g);
            }
        }
    }

    protected void paint(Graphics g) {
//        g.setColor(255, 255, 255);
//        g.fillRect(0, 0, this.getWidth(), this.getHeight());
//        g.setColor(0, 0, 0);
//        if(!bbb){
//            try {
//                backgroundScore(g);
//            } catch (RecordStoreException ex) {
//                ex.printStackTrace();
//            }
//        }
      if (!showSplashScreen) {
        this.men = (Image) ImgSource.img.get("menu");
        g.drawImage(men, 0, 0, Graphics.TOP | Graphics.LEFT);

        for (int i = 0; i < 5; i++) {
            if (selectPoint == 0)//play
            {
                this.play2 = (Image) ImgSource.img.get("sele");
                g.drawImage(play2, 102, 72, Graphics.TOP | Graphics.LEFT);
                menu(g);
            } else if (selectPoint == 1) //rekor
            {
                this.play2 = (Image) ImgSource.img.get("sele");
                g.drawImage(play2, 102, 100, Graphics.TOP | Graphics.LEFT);
                menu(g);

            } else if (selectPoint == 2) //panduan
            {
                this.play2 = (Image) ImgSource.img.get("sele");
                g.drawImage(play2, 102, 126, Graphics.TOP | Graphics.LEFT);
                menu(g);
            } else if (selectPoint == 3) //profil
            {
                this.play2 = (Image) ImgSource.img.get("sele");
                g.drawImage(play2, 102, 154, Graphics.TOP | Graphics.LEFT);
                menu(g);

            } else if (selectPoint == 4) //exit
            {
                this.play2 = (Image) ImgSource.img.get("sele");
                g.drawImage(play2, 102, 182, Graphics.TOP | Graphics.LEFT);
                menu(g);
            }
        }
        } //else {
//            this.loadin = (Image) ImgSource.img.get("loading");
//            g.drawImage(loadin, 0, 0, Graphics.TOP | Graphics.LEFT);
//            thread = new Thread(this);
//            thread.start();
////            menuU(g);
////            // loading awal
          ImgSource.getInstance();
          repaint();
//        }
    }

    public void display() {
        display.setCurrent(this);
    }

    public void run() {
//        try {
////            Thread.sleep(500);
            repaint();
            showSplashScreen = false;
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
    }

    protected void keyPressed(int keyCode) {
        if (this.getGameAction(keyCode) == MenuUtama.DOWN) {
            selectPoint = selectPoint + 1;
            if (selectPoint > 5 - 1) {
                selectPoint = 0;
            }
        } else if (this.getGameAction(keyCode) == MenuUtama.UP) {
            selectPoint = selectPoint - 1;
            if (selectPoint < 0) {
                selectPoint = 5 - 1;
            }
        } else if (this.getGameAction(keyCode) == MenuUtama.FIRE) {
            if (selectPoint == 0) {

                try {
                    gg = new Game(display, this);
                    display.setCurrent(gg);
                    gg.start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (RecordStoreException ex) {
                    ex.printStackTrace();
                }



            } else if (selectPoint == 1) {
                try {
                    showSplashScreen=true;
                    RecordTime rt = new RecordTime(display, this);
                    display.setCurrent(rt);
                } catch (RecordStoreException ex) {
                    ex.printStackTrace();
                }



            } else if (selectPoint == 2) {

                display.setCurrent(formHelp);
            } else if (selectPoint == 3) {

                MengenalWayang mw = new MengenalWayang(display, this);
                display.setCurrent(mw);

            } else if (selectPoint == 4) {
               
                 ss = new SplashScreen(display, midlet);
                 ss.repaint();
                 ss.keluar();
                       }
        }
        this.repaint();
    }

    public void commandAction(Command c, Displayable d) {

        if (c.equals(commBack)) {
            display.setCurrent(this);

        }

    }
}
