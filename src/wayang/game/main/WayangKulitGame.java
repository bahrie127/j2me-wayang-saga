/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wayang.game.main;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.*;


/**
 * @author Fendi
 */
public class WayangKulitGame extends MIDlet {
    private Display display;
    private Image splash;
    private MenuUtama mu;

    public void startApp() {
       
       

            SplashScreen ss = new SplashScreen(Display.getDisplay(this), this);
       
          
    }



    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }
}
