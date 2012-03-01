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
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStoreException;

/**
 *
 * @author adrdrj2me
 */
public class MengenalWayang extends Canvas implements Runnable, CommandListener {

    private Image pYudistira, pWerkudara, pArjuna, pNakula, pSadewa, pSemar, pBagong, pPetruk, pGareng;
    private Image slide[] = new Image[9];
    private int nomor = 0;
    private MIDlet mid;
    private Display display;
    boolean tampilLayar = true;
    private Command commBack = null;
    private MenuUtama mu;
     private MIDlet midlet;

    public MengenalWayang(Display dis, MenuUtama mu) {
        this.display = dis;
        this.display.setCurrent(this);
        this.setFullScreenMode(true);
        this.mu = mu;
        this.commBack = new Command("Back", Command.BACK, 1);
        this.addCommand(commBack);
        this.setCommandListener((CommandListener) this);


    }

    protected void paint(Graphics g) {
        System.out.println("-------");


        pYudistira = (Image) ImgSource.img.get("yudistira_p");
        slide[0] = pYudistira;
        pWerkudara = (Image) ImgSource.img.get("werkudara_p");
        slide[1] = pWerkudara;
        pArjuna = (Image) ImgSource.img.get("arjuna_p");
        slide[2] = pArjuna;
        pNakula = (Image) ImgSource.img.get("nakula_p");
        slide[3] = pNakula;
        pSadewa = (Image) ImgSource.img.get("sadewa_p");
        slide[4] = pSadewa;
        pSemar = (Image) ImgSource.img.get("semar_p");
        slide[5] = pSemar;
        pBagong = (Image) ImgSource.img.get("bagong_p");
        slide[6] = pBagong;
        pPetruk = (Image) ImgSource.img.get("petruk_p");
        slide[7] = pPetruk;
        pGareng = (Image) ImgSource.img.get("gareng_p");
        slide[8] = pGareng;
        // g.drawImage(pSemar, UP, UP, nomor);

        System.out.println("jalan...");
        for (int a = 0; a < 9; a++) {
            if (nomor == a) {
                g.drawImage(slide[(0 + a)], 15, 10, Graphics.TOP | Graphics.LEFT);
            }
        }


    }

    public void run() {
        try {

            Thread.sleep(500);
            repaint();

            tampilLayar = false;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    protected void keyPressed(int keyCode) {
        if (this.getGameAction(keyCode) == MengenalWayang.DOWN) {
            if (nomor < 8) {
                nomor++;
            } else {
                nomor = 0;
            }
        } else if (this.getGameAction(keyCode) == MengenalWayang.UP) {
            if (nomor > 0) {
                nomor--;
            } else {
                nomor = 8;
            }
        } else if (this.getGameAction(keyCode) == MengenalWayang.RIGHT) {
            if (nomor < 8) {
                nomor++;
            } else {
                nomor = 0;
            }
        } else if (this.getGameAction(keyCode) == MengenalWayang.LEFT) {
            if (nomor > 0) {
                nomor--;
            } else {
                nomor = 8;
            }
        }
        this.repaint();
    }

    public void commandAction(Command c, Displayable d) {
         if (c.equals(commBack)) {
            try {
                MenuUtama mm = new MenuUtama(display,midlet);
                display.setCurrent(mm);

            } catch (RecordStoreException ex) {
                ex.printStackTrace();
            }

        }
    }
}
