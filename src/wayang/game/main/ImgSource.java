/**
 *              ^_^ >>> ^_^           *
 */
package wayang.game.main;

import java.io.IOException;
import java.util.Hashtable;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Fendi
 */
public class ImgSource {

    public static Hashtable img = new Hashtable();
    public static ImgSource res = new ImgSource();

    public ImgSource() {
        try {
            img.put("loading", Image.createImage("/load.png"));
            img.put("menu", Image.createImage("/menuJadi.png"));
            //menu
            img.put("play", Image.createImage("/Graphic2.png"));
            img.put("rekor", Image.createImage("/highScore.png"));
            img.put("help", Image.createImage("/help.png"));
            img.put("option", Image.createImage("/Graphic1.png"));
            img.put("exit", Image.createImage("/exit_1.png"));

            //layer
            img.put("layer", Image.createImage("/gam.png"));
            img.put("sele", Image.createImage("/selll.png"));
            img.put("select", Image.createImage("/1.png"));
            //wayang
            img.put("bagong", Image.createImage("/bagong.png"));
            img.put("petruk", Image.createImage("/petruk.png"));
            img.put("gareng", Image.createImage("/gareng.png"));
            img.put("semar", Image.createImage("/semar.png"));
            img.put("yudhistira", Image.createImage("/yudhistira.png"));
            img.put("werkudara", Image.createImage("/werkudara.png"));
            img.put("arjuna", Image.createImage("/arjuna.png"));
            img.put("nakula", Image.createImage("/nakula.png"));
            img.put("sadewa", Image.createImage("/sadewa.png"));

            //profil
            img.put("arjuna_p", Image.createImage("/proarjuna.png"));
            img.put("werkudara_p", Image.createImage("/prowerkudara.png"));
            img.put("gareng_p", Image.createImage("/progareng.png"));
            img.put("nakula_p", Image.createImage("/pronakula.png"));
            img.put("yudistira_p", Image.createImage("/proyudistira.png"));
            img.put("sadewa_p", Image.createImage("/prosadewa.png"));
            img.put("semar_p", Image.createImage("/prosemar.png"));
            img.put("bagong_p", Image.createImage("/probagong.png"));
            img.put("petruk_p", Image.createImage("/propetruk.png"));
            //piala
            img.put("piala",Image.createImage("/piala.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ImgSource getInstance() {
        return res;
    }
}
