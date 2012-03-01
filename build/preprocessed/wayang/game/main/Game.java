/**
 *              ^_^ >>> ^_^           *
 */
package wayang.game.main;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStoreException;

/**
 *
 * @author Fendi
 */
public class Game extends GameCanvas implements Runnable, CommandListener {

    private MIDlet mid;
    private boolean running;
    private long delay;
    private int currentX, currentY;
    private int screenWidth;
    private int a = 0;
    private int screenHeight;
    private Sprite sprite01, sprite02, sprite03, sprite04, sprite05, sprite06,
            sprite07, sprite08, sprite09, sprite11, sprite12, sprite13, sprite14,
            sprite15, sprite16, sprite17, sprite18, sprite19;
    private Sprite data[] = {sprite01, sprite11, sprite02, sprite12, sprite03,
        sprite13, sprite04, sprite14, sprite05, sprite15, sprite06, sprite16, sprite07,
        sprite17, sprite08, sprite18, sprite09, sprite19};
    private Sprite tampil[] = new Sprite[18];
    private Image semar, bagong, gareng, petruk, yudhistira, werkudara, arjuna, nakula, sadewa;
    private Image bb;
    private int selectPoint, selectPoint2 = 0;
    private int tanda1 = 0, tanda2 = 0, tanda3 = 0, tanda4 = 0, tanda5 = 0, tanda6 = 0,
            tanda7 = 0, tanda8 = 0, tanda9 = 0, tanda10 = 0, tanda11 = 0, tanda12 = 0,
            tanda13 = 0, tanda14 = 0, tanda15 = 0, tanda16 = 0, tanda17 = 0, tanda18 = 0;
    private int bt = 1;
    private int cekb1 = 1;
    private int cekb2 = 1;
    private int cekb3 = 1;
    private int cekb4 = 1;
    private int cekb5 = 1;
    private int cekb6 = 1;
    private int cekb7 = 1;
    private int cekb8 = 1;
    private int cekb9 = 1;
    private int cek[] = {cekb1 = 1, cekb1 = 1, cekb2 = 1, cekb2 = 1, cekb3 = 1, cekb3 = 1, cekb4 = 1, cekb4 = 1, cekb5 = 1, cekb5 = 1, cekb6 = 1, cekb6 = 1, cekb7 = 1, cekb7 = 1, cekb8 = 1, cekb8 = 1, cekb9 = 1, cekb9 = 1};
    private int s1b = 1, s2b = 1, s3b = 1, s4b = 1, s5b = 1, s6b = 1,
            s7b = 1, s8b = 1, s9b = 1, s11b = 1, s12b = 1, s13b = 1,
            s14b = 1, s15b = 1, s16b = 1, s17b = 1, s18b = 1, s19b = 1;
    private int s1t = 0, s2t = 0, s3t = 0, s4t = 0, s5t = 0, s6t = 0,
            s7t = 0, s8t = 0, s9t = 0, s11t = 0, s12t = 0, s13t = 0,
            s14t = 0, s15t = 0, s16t = 0, s17t = 0, s18t = 0, s19t = 0;
    private int sbuka[] = new int[18];
    private int stutup[] = new int[18];
    int banding = 0;
    private int aray = 0;
    int bener = 0;
    //  private int data[]={1,2,3,4,5,6,7,8,9,19,11,12,13,14,15,16,17,18};
    //timer
    private Display dis;
    private Timer tm, keluar = null;
    private TimerTask tt;
    private int count, count1, count2, count3;
    private Command cmStart;
    private Command cmExit;
    private Command cmStop;
    private Command cmResume;
    private Display display;
    private int score;
    private MenuUtama mu;
    private boolean callGameOver = false;
    public static boolean STOP = false;
    private boolean stop = false;
    private boolean ipp = true;
    private int lvl = 1;
    private boolean leve = true;
    private boolean lee = false;
    private boolean mng, bnr = true;
    private Image prof;
    private String waktu;
    private ScoreManager sm;
    //simpan
    private Command commOk = null;
    private TextBox tb = null;
    //random gambar
    //input nama
    private TextField tfName = new TextField("Player ", "", 15, TextField.ANY);
    private Form form;
    private Command cmdOk;
    private Image select;
    private int delayBuka = 0;
    private int bukaDua = 0;
    private boolean status = false;

    public Game(Display display, MenuUtama mu) throws IOException, RecordStoreException {
        super(true);
        screenWidth = getWidth();
        screenHeight = getHeight();
        currentX = screenWidth / 2;
        currentY = screenHeight / 2;
        delay = 20;
        this.display = display;
        this.mu = mu;
        this.sm = new ScoreManager();
        this.sm.getScore();

        cmExit = new Command("Exit", Command.EXIT, 1);
        cmStart = new Command("Start", Command.EXIT, 1);
        cmStop = new Command("Pause", Command.OK, 2);
        cmResume = new Command("Resume", Command.OK, 3);
        cmdOk = new Command("Ok", Command.SCREEN, 1);

        loadSprite();
        raNdom();

        this.isiCekDkk();

    }

    void defaultLain() {
        bener = 0;
        banding = 0;
        aray = 0;
        bt = 1;
        tanda1 = 0;
        tanda2 = 0;
        tanda3 = 0;
        tanda4 = 0;
        tanda5 = 0;
        tanda6 = 0;
        tanda7 = 0;
        tanda8 = 0;
        tanda9 = 0;
        tanda10 = 0;
        tanda11 = 0;
        tanda12 = 0;
        tanda13 = 0;
        tanda14 = 0;
        tanda15 = 0;
        tanda16 = 0;
        tanda17 = 0;
        tanda18 = 0;
    }

    void loadSprite() {
        this.bagong = (Image) ImgSource.img.get("bagong");
        this.semar = (Image) ImgSource.img.get("semar");
        this.petruk = (Image) ImgSource.img.get("petruk");
        this.gareng = (Image) ImgSource.img.get("gareng");
        this.yudhistira = (Image) ImgSource.img.get("yudhistira");
        this.werkudara = (Image) ImgSource.img.get("werkudara");
        this.arjuna = (Image) ImgSource.img.get("arjuna");
        this.nakula = (Image) ImgSource.img.get("nakula");
        this.sadewa = (Image) ImgSource.img.get("sadewa");

        data[0] = new Sprite(bagong, 38, 50);
        sprite01 = data[0];
        data[1] = new Sprite(bagong, 38, 50);
        sprite11 = data[1];
        data[2] = new Sprite(yudhistira, 38, 50);
        sprite02 = data[2];
        data[3] = new Sprite(yudhistira, 38, 50);
        sprite12 = data[3];
        data[4] = new Sprite(petruk, 38, 50);
        sprite03 = data[4];
        data[5] = new Sprite(petruk, 38, 50);
        sprite13 = data[5];
        data[6] = new Sprite(nakula, 38, 50);
        sprite04 = data[6];
        data[7] = new Sprite(nakula, 38, 50);
        sprite14 = data[7];
        data[8] = new Sprite(semar, 38, 50);
        sprite05 = data[8];
        data[9] = new Sprite(semar, 38, 50);
        sprite15 = data[9];
        data[10] = new Sprite(sadewa, 38, 50);
        sprite06 = data[10];
        data[11] = new Sprite(sadewa, 38, 50);
        sprite16 = data[11];
        data[12] = new Sprite(arjuna, 38, 50);
        sprite07 = data[12];
        data[13] = new Sprite(arjuna, 38, 50);
        sprite17 = data[13];
        data[14] = new Sprite(gareng, 38, 50);
        sprite08 = data[14];
        data[15] = new Sprite(gareng, 38, 50);
        sprite18 = data[15];
        data[16] = new Sprite(werkudara, 38, 50);
        sprite09 = data[16];
        data[17] = new Sprite(werkudara, 38, 50);
        sprite19 = data[17];
    }

    void raNdom() {
        Random r = new Random();
        int n = Math.abs(r.nextInt() % 9);
        if (n == 0) {
            n = n + 3;
        }
        System.out.println(n);
        for (int a = 0; a < 14; a++) {
            if (n % (a + 3) == 1) {
                Sprite b = data[n];
                data[n] = data[a];
                data[a] = b;
            }
            if (n % (a + 6) == 0) {
                Sprite b = data[n - 1];
                data[n - 1] = data[a + 1];
                data[a + 1] = b;
            }

            if ((a + 7) % n == 1) {
                Sprite b = data[a + 2];
                data[a + 2] = data[n];
                data[n] = b;
            }
            Sprite c = data[n];
            data[n] = data[a + 2];
            data[a + 2] = c;
            c = data[16 - n];
            data[16 - n] = data[a + 3];
            data[a + 3] = c;
            c = data[a];
            data[a] = data[n + 2];
            data[n + 2] = c;
            c = data[17 - a];
            data[17 - a] = data[n];
            data[n] = c;

        }
        for (int c = 0; c < data.length; c++) {
            System.out.print(data[c] + "  ");
        }

    }

    void isiCekDkk() {
        String s1 = String.valueOf(sprite01);
        String hs1 = s1.substring(s1.length() - 2, s1.length());
        System.out.println(hs1);

        String s2 = String.valueOf(sprite02);
        String hs2 = s2.substring(s2.length() - 2, s2.length());
        String s3 = String.valueOf(sprite03);
        String hs3 = s3.substring(s3.length() - 2, s3.length());
        String s4 = String.valueOf(sprite04);
        String hs4 = s4.substring(s4.length() - 2, s4.length());
        String s5 = String.valueOf(sprite05);
        String hs5 = s5.substring(s5.length() - 2, s5.length());
        String s6 = String.valueOf(sprite06);
        String hs6 = s6.substring(s6.length() - 2, s6.length());
        String s7 = String.valueOf(sprite07);
        String hs7 = s7.substring(s7.length() - 2, s7.length());
        String s8 = String.valueOf(sprite08);
        String hs8 = s8.substring(s8.length() - 2, s8.length());
        String s9 = String.valueOf(sprite09);
        String hs9 = s9.substring(s9.length() - 2, s9.length());
        String s11 = String.valueOf(sprite11);
        String hs11 = s11.substring(s11.length() - 2, s11.length());
        String s12 = String.valueOf(sprite12);
        String hs12 = s12.substring(s12.length() - 2, s12.length());
        String s13 = String.valueOf(sprite13);
        String hs13 = s13.substring(s13.length() - 2, s13.length());
        String s14 = String.valueOf(sprite14);
        String hs14 = s14.substring(s14.length() - 2, s14.length());
        String s15 = String.valueOf(sprite15);
        String hs15 = s15.substring(s15.length() - 2, s15.length());
        String s16 = String.valueOf(sprite16);
        String hs16 = s16.substring(s16.length() - 2, s16.length());
        String s17 = String.valueOf(sprite17);
        String hs17 = s17.substring(s17.length() - 2, s17.length());
        String s18 = String.valueOf(sprite18);
        String hs18 = s18.substring(s18.length() - 2, s18.length());
        String s19 = String.valueOf(sprite19);
        String hs19 = s19.substring(s19.length() - 2, s19.length());



        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs1.equals(h)) {
                cek[u] = 2;
                sbuka[u] = s1b;
                stutup[u] = s1t;
                tampil[0] = data[u];
                System.out.println("1 di urut" + (u + 1));
                break;
            }
        }

        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs2.equals(h)) {
                cek[u] = 4;
                sbuka[u] = s2b;
                stutup[u] = s2t;
                tampil[1] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs3.equals(h)) {
                cek[u] = 6;
                sbuka[u] = s3b;
                stutup[u] = s3t;
                tampil[2] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs4.equals(h)) {
                cek[u] = 8;
                sbuka[u] = s4b;
                stutup[u] = s4t;
                tampil[3] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs5.equals(h)) {
                cek[u] = 10;
                sbuka[u] = s5b;
                stutup[u] = s5t;
                tampil[4] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs6.equals(h)) {
                cek[u] = 12;
                sbuka[u] = s6b;
                stutup[u] = s6t;
                tampil[5] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs7.equals(h)) {
                cek[u] = 14;
                sbuka[u] = s7b;
                stutup[u] = s7t;
                tampil[6] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs8.equals(h)) {
                cek[u] = 16;
                sbuka[u] = s8b;
                stutup[u] = s8t;
                tampil[7] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs9.equals(h)) {
                cek[u] = 18;
                sbuka[u] = s9b;
                stutup[u] = s9t;
                tampil[8] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs11.equals(h)) {
                cek[u] = 2;
                sbuka[u] = s11b;
                stutup[u] = s11t;
                tampil[9] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs12.equals(h)) {
                cek[u] = 4;
                sbuka[u] = s12b;
                stutup[u] = s12t;
                tampil[10] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs13.equals(h)) {
                cek[u] = 6;
                sbuka[u] = s13b;
                stutup[u] = s13t;
                tampil[11] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs14.equals(h)) {
                cek[u] = 8;
                sbuka[u] = s14b;
                stutup[u] = s14t;
                tampil[12] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs15.equals(h)) {
                cek[u] = 10;
                sbuka[u] = s15b;
                stutup[u] = s15t;
                tampil[13] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs16.equals(h)) {
                cek[u] = 12;
                sbuka[u] = s16b;
                stutup[u] = s16t;
                tampil[14] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs17.equals(h)) {
                cek[u] = 14;
                sbuka[u] = s17b;
                stutup[u] = s17t;
                tampil[15] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs18.equals(h)) {
                cek[u] = 16;
                sbuka[u] = s18b;
                stutup[u] = s18t;
                tampil[16] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs19.equals(h)) {
                cek[u] = 18;
                sbuka[u] = s19b;
                stutup[u] = s19t;
                tampil[17] = data[u];
                tampil[16] = data[u];
                break;
            }
        }
    }

    void tidakIsiStatusSprite() {
        String s1 = String.valueOf(sprite01);
        String hs1 = s1.substring(s1.length() - 2, s1.length());
        String s2 = String.valueOf(sprite02);
        String hs2 = s2.substring(s2.length() - 2, s2.length());
        String s3 = String.valueOf(sprite03);
        String hs3 = s3.substring(s3.length() - 2, s3.length());
        String s4 = String.valueOf(sprite04);
        String hs4 = s4.substring(s4.length() - 2, s4.length());
        String s5 = String.valueOf(sprite05);
        String hs5 = s5.substring(s5.length() - 2, s5.length());
        String s6 = String.valueOf(sprite06);
        String hs6 = s6.substring(s6.length() - 2, s6.length());
        String s7 = String.valueOf(sprite07);
        String hs7 = s7.substring(s7.length() - 2, s7.length());
        String s8 = String.valueOf(sprite08);
        String hs8 = s8.substring(s8.length() - 2, s8.length());
        String s9 = String.valueOf(sprite09);
        String hs9 = s9.substring(s9.length() - 2, s9.length());
        String s11 = String.valueOf(sprite11);
        String hs11 = s11.substring(s11.length() - 2, s11.length());
        String s12 = String.valueOf(sprite12);
        String hs12 = s12.substring(s12.length() - 2, s12.length());
        String s13 = String.valueOf(sprite13);
        String hs13 = s13.substring(s13.length() - 2, s13.length());
        String s14 = String.valueOf(sprite14);
        String hs14 = s14.substring(s14.length() - 2, s14.length());
        String s15 = String.valueOf(sprite15);
        String hs15 = s15.substring(s15.length() - 2, s15.length());
        String s16 = String.valueOf(sprite16);
        String hs16 = s16.substring(s16.length() - 2, s16.length());
        String s17 = String.valueOf(sprite17);
        String hs17 = s17.substring(s17.length() - 2, s17.length());
        String s18 = String.valueOf(sprite18);
        String hs18 = s18.substring(s18.length() - 2, s18.length());
        String s19 = String.valueOf(sprite19);
        String hs19 = s19.substring(s19.length() - 2, s19.length());

        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs1.equals(h)) {
                cek[u] = 2;
                System.out.println("1 di urut" + (u + 1));
                break;
            }
        }

        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs2.equals(h)) {
                cek[u] = 4;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs3.equals(h)) {
                cek[u] = 6;
                tampil[2] = data[u];
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs4.equals(h)) {
                cek[u] = 8;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs5.equals(h)) {
                cek[u] = 10;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs6.equals(h)) {
                cek[u] = 12;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs7.equals(h)) {
                cek[u] = 14;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs8.equals(h)) {
                cek[u] = 16;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs9.equals(h)) {
                cek[u] = 18;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs11.equals(h)) {
                cek[u] = 2;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs12.equals(h)) {
                cek[u] = 4;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs13.equals(h)) {
                cek[u] = 6;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs14.equals(h)) {
                cek[u] = 8;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs15.equals(h)) {
                cek[u] = 10;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs16.equals(h)) {
                cek[u] = 12;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs17.equals(h)) {
                cek[u] = 14;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs18.equals(h)) {
                cek[u] = 16;
                break;
            }
        }
        for (int u = 0; u < 18; u++) {
            String s = String.valueOf(data[u]);
            String h = s.substring(s.length() - 2, s.length());
            if (hs19.equals(h)) {
                cek[u] = 18;
                break;
            }
        }
    }

    public void start() {
        Game.STOP = false;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        STOP = true;
        running = true;
        sprite01 = null;
        sprite02 = null;
        sprite03 = null;
        sprite04 = null;
        sprite05 = null;
        sprite06 = null;
        sprite07 = null;
        sprite08 = null;
        sprite09 = null;
        sprite11 = null;
        sprite12 = null;
        sprite13 = null;
        sprite14 = null;
        sprite15 = null;
        sprite16 = null;
        sprite17 = null;
        sprite18 = null;
        sprite19 = null;


    }

    private void getInput() {
        int keyStates = getKeyStates();

        if ((keyStates & DOWN_PRESSED) != 0) {
            selectPoint = selectPoint + 1;
            if (selectPoint > 3 - 1) {
                selectPoint = 0;
            }
        } else if ((keyStates & UP_PRESSED) != 0) {
            selectPoint = selectPoint - 1;
            if (selectPoint < 0) {
                selectPoint = 3 - 1;
            }
        } else if ((keyStates & RIGHT_PRESSED) != 0) {
            selectPoint2 = selectPoint2 + 1;
            if (selectPoint2 == 6) {
                selectPoint2 = 0;
            }
        } else if ((keyStates & LEFT_PRESSED) != 0) {
            selectPoint2 = selectPoint2 - 1;
            if (selectPoint2 < 0) {
                selectPoint2 = 6 - 1;
            }
        } else if ((keyStates & FIRE_PRESSED) != 0) {//tombol tengah
            if ((selectPoint == 0) && (selectPoint2 == 0)) {//posisi 0,0
                if (tanda1 % 2 != 0) {
                    cek[0]--;//cek benar
                    System.out.println("cek " + cekb1);
                    data[0].setFrame(stutup[0]);
                    bt--;//buka tanda (tanda buka) tanda kalo kartu lagi dibuka
                    //kalo di -- bearti ditutup kalao ++ bearti dibuka
                    System.out.println(bt);
                    tanda1++;//tanda untuk satu gambar buka tutup.
                    //ganjil genap tiap satu gambar satu tanda
                } else if (tanda1 % 2 == 0) {
                    cek[0]++;
                    bt++;
                    data[0].setFrame(sbuka[0]);
                    System.out.println("cek " + cekb1);
                    System.out.println(bt);

                    tanda1++;
                }
            } else if ((selectPoint == 0) && (selectPoint2 == 1)) {
                if (tanda2 % 2 != 0) {
                    bt--;
                    cek[1]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[1].setFrame(stutup[1]);
                    tanda2++;
                } else if (tanda2 % 2 == 0) {
                    bt++;
                    cek[1]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[1].setFrame(sbuka[1]);
                    tanda2++;
                }
            } else if ((selectPoint == 0) && (selectPoint2 == 2)) {
                if (tanda3 % 2 != 0) {
                    bt--;
                    cek[2]--;
                    System.out.println("cek " + cekb1);
                    System.out.println(bt);
                    data[2].setFrame(stutup[2]);
                    tanda3++;
                } else if (tanda3 % 2 == 0) {
                    bt++;
                    cek[2]++;
                    System.out.println("cek " + cekb1);
                    System.out.println(bt);
                    data[2].setFrame(sbuka[2]);
                    tanda3++;
                }
            } else if ((selectPoint == 0) && (selectPoint2 == 3)) {
                if (tanda4 % 2 != 0) {
                    bt--;
                    cek[3]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[3].setFrame(stutup[3]);
                    tanda4++;
                } else if (tanda4 % 2 == 0) {
                    bt++;
                    cek[3]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[3].setFrame(sbuka[3]);
                    tanda4++;
                }
            } else if ((selectPoint == 0) && (selectPoint2 == 4)) {
                if (tanda5 % 2 != 0) {
                    bt--;
                    cek[4]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[4].setFrame(stutup[4]);
                    tanda5++;
                } else if (tanda5 % 2 == 0) {
                    bt++;
                    cek[4]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[4].setFrame(sbuka[4]);
                    tanda5++;
                }
            } else if ((selectPoint == 0) && (selectPoint2 == 5)) {
                if (tanda6 % 2 != 0) {
                    bt--;
                    cek[5]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[5].setFrame(stutup[5]);
                    tanda6++;
                } else if (tanda6 % 2 == 0) {
                    bt++;
                    cek[5]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[5].setFrame(sbuka[5]);
                    tanda6++;
                }
            } else if ((selectPoint == 1) && (selectPoint2 == 0)) {
                if (tanda7 % 2 != 0) {
                    bt--;
                    cek[6]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[6].setFrame(stutup[6]);
                    tanda7++;
                } else if (tanda7 % 2 == 0) {
                    bt++;
                    cek[6]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[6].setFrame(sbuka[6]);
                    tanda7++;
                }
            } else if ((selectPoint == 1) && (selectPoint2 == 1)) {
                if (tanda8 % 2 != 0) {
                    bt--;
                    cek[7]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[7].setFrame(stutup[7]);
                    tanda8++;
                } else if (tanda8 % 2 == 0) {
                    bt++;
                    cek[7]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[7].setFrame(sbuka[7]);
                    tanda8++;
                }
            } else if ((selectPoint == 1) && (selectPoint2 == 2)) {
                if (tanda9 % 2 != 0) {
                    bt--;
                    cek[8]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[8].setFrame(stutup[8]);
                    tanda9++;
                } else if (tanda9 % 2 == 0) {
                    bt++;
                    cek[8]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[8].setFrame(sbuka[8]);
                    tanda9++;
                }
            } else if ((selectPoint == 1) && (selectPoint2 == 3)) {
                if (tanda10 % 2 != 0) {
                    bt--;
                    cek[9]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[9].setFrame(stutup[9]);
                    tanda10++;
                } else if (tanda10 % 2 == 0) {
                    bt++;
                    cek[9]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[9].setFrame(sbuka[9]);
                    tanda10++;
                }
            } else if ((selectPoint == 1) && (selectPoint2 == 4)) {
                if (tanda11 % 2 != 0) {
                    bt--;
                    cek[10]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[10].setFrame(stutup[10]);
                    tanda11++;
                } else if (tanda11 % 2 == 0) {
                    bt++;
                    cek[10]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[10].setFrame(sbuka[10]);
                    tanda11++;
                }
            } else if ((selectPoint == 1) && (selectPoint2 == 5)) {
                if (tanda12 % 2 != 0) {
                    bt--;
                    cek[11]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[11].setFrame(stutup[11]);
                    tanda12++;
                } else if (tanda12 % 2 == 0) {
                    bt++;
                    cek[11]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[11].setFrame(sbuka[11]);
                    tanda12++;
                }
            } else if ((selectPoint == 2) && (selectPoint2 == 0)) {
                if (tanda13 % 2 != 0) {
                    bt--;
                    cek[12]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[12].setFrame(stutup[12]);
                    tanda13++;
                } else if (tanda13 % 2 == 0) {
                    bt++;
                    cek[12]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[12].setFrame(sbuka[12]);
                    tanda13++;
                }
            } else if ((selectPoint == 2) && (selectPoint2 == 1)) {
                if (tanda14 % 2 != 0) {
                    bt--;
                    cek[13]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[13].setFrame(stutup[13]);
                    tanda14++;
                } else if (tanda14 % 2 == 0) {
                    bt++;
                    cek[13]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[13].setFrame(sbuka[13]);
                    tanda14++;
                }
            } else if ((selectPoint == 2) && (selectPoint2 == 2)) {
                if (tanda15 % 2 != 0) {
                    bt--;
                    cek[14]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[14].setFrame(stutup[14]);
                    tanda15++;
                } else if (tanda15 % 2 == 0) {
                    bt++;
                    cek[14]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[14].setFrame(sbuka[14]);
                    tanda15++;
                }
            } else if ((selectPoint == 2) && (selectPoint2 == 3)) {
                if (tanda16 % 2 != 0) {
                    bt--;
                    cek[15]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[15].setFrame(stutup[15]);
                    tanda16++;
                } else if (tanda16 % 2 == 0) {
                    bt++;
                    cek[15]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[15].setFrame(sbuka[15]);
                    tanda16++;
                }
            } else if ((selectPoint == 2) && (selectPoint2 == 4)) {
                if (tanda17 % 2 != 0) {
                    bt--;
                    cek[16]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[16].setFrame(stutup[16]);
                    tanda17++;
                } else if (tanda17 % 2 == 0) {
                    bt++;
                    cek[16]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(bt);
                    data[16].setFrame(sbuka[16]);
                    tanda17++;

                }
            } else if ((selectPoint == 2) && (selectPoint2 == 5)) {
                if (tanda18 % 2 != 0) {
                    bt--;
                    cek[17]--;
                    System.out.println("cek " + cekb2);
                    System.out.println(tanda18);
                    data[17].setFrame(stutup[17]);
                    tanda18++;
                } else if (tanda18 % 2 == 0) {
                    bt++;
                    cek[17]++;
                    System.out.println("cek " + cekb2);
                    System.out.println(tanda18);
                    data[17].setFrame(sbuka[17]);
                    tanda18++;
                }
            }

            Graphics g = getGraphics();
            cekPertama();

            status = false;
            if (bt == 3) {
                delayBuka = 2;
                cek[aray] = banding - 1;
                for (int u = 0; u < 18; u++) {
                    if (cek[u] == banding) {
                        data[u].setFrame(1);
                        data[aray].setFrame(1);
                        stutup[u] = 1;
                        stutup[aray] = 1;
                        cek[u] = cek[u] - 1;
                        System.out.println("jalan " + u + "  " + stutup[aray] + " " + stutup[u]);
                        status = true;
                        bener++;
                        break;
                    }
                }

                if (bener == 9) {

                    bnr = false;

                }

                for (int t = 0; t < 18; t++) {
                    data[t].setFrame(stutup[t]);
                    //cek[t] = 1;
                }

                this.tidakIsiStatusSprite();

                tanda1 = 0;//kalo bt = 3 maka tanda jadi nol kan semua
                tanda2 = 0;//supaya proses buka tutup kartunya mulai dari awal
                tanda3 = 0;
                tanda5 = 0;
                tanda6 = 0;
                tanda7 = 0;
                tanda8 = 0;
                tanda9 = 0;
                tanda10 = 0;
                tanda11 = 0;
                tanda12 = 0;
                tanda13 = 0;
                tanda14 = 0;
                tanda15 = 0;
                tanda16 = 0;
                tanda17 = 0;
                tanda18 = 0;
                tanda4 = 0;
                bt = 1;//tanda buka kartu juga mulai dari satu
            }


        }
    }

    void cekPertama() {
        if (bt == 2) {

            for (int u = 0; u < 18; u++) {
                System.out.println(cek[u]);
                if (cek[u] % 2 == 1) {
                    banding = cek[u];
                    aray = u;
                    System.out.println("cekpertama " + u + "  " + banding);
                    break;
                }
            }
        }
    }

    public void level(int n) throws InterruptedException {
        int keyStates = getKeyStates();
        if (n == 1) {
//            Graphics g = getGraphics();
//            g.setColor(0x000000);
//            g.setColor(0xffffff);
//            g.fillRect(20, 20, 280, 200);
//            g.setColor(0x000000);
//            g.setColor(0xffffff);
//            g.fillRect(20, 20, 250, 200);
//            g.setColor(0x000000);
//            g.drawString("SELAMAT BERMAIN.....", 50, 50, Graphics.TOP|Graphics.LEFT);
//            g.drawString("SAMAKAN GAMBAR SELURUHNYA,", 20, 70, Graphics.TOP | Graphics.LEFT);
//            g.drawString("SECEPAT MUNGKIN", 50, 90, Graphics.TOP | Graphics.LEFT);
//
//            g.drawString("Please wait...", 200, 120, Graphics.TOP | Graphics.LEFT);
//
//            flushGraphics();



            lee = true;
            leve = false;
//            if ((keyStates & FIRE_PRESSED) != 0) {
//                lee = true;
//                leve = false;
//            }
        }
    }

    public void run() {
        while (!running) {
            Graphics g = getGraphics();
            if (!lee) {//tampilan awal layer game
                //tampilan awal layer game
                try {
                    level(lvl);
                } catch (InterruptedException ex) {
                }
            }

            if (!leve) { //disable draw screen
                if (!ipp) {//disable input
                    getInput();
                }
                try {
                    drawScreen(g);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    //timer
    private void nolkan() {
        count = 0;
        count1 = 0;
        count2 = 0;
        count3 = 0;
    }

    private class TimerRun extends TimerTask {

        Graphics g = getGraphics();

        public final void run() {
            if (++count > 9) {
                count = 0;
                ++count1;
            }
            if (count1 > 59) {
                count1 = 0;
                ++count2;
            }
            if (count2 > 59) {
                count2 = 0;
                ++count3;
            }
            if (count3 > 23) {
                nolkan();
            }
            flushGraphics();
        }
    }

    private void mulai(boolean cc) {
        if (cc) {


            tm = new Timer();
            tt = new TimerRun();
            tm.schedule(tt, 0, 100);

        } else if (!cc) {
            //nolkan();
        }
    }

    public void timer() {
        mulai(true);
    }

    private void addComm(int code) {
        if (code == 1) {
            this.addCommand(cmStart);
        } else if (code == 2) {
            this.addCommand(cmStop);
        } else if (code == 3) {
            this.addCommand(cmResume);
        }

        this.setCommandListener((CommandListener) this);
    }

    private void drawScreen(Graphics g) throws InterruptedException {
        this.bb = (Image) ImgSource.img.get("layer");
        this.select = (Image) ImgSource.img.get("select");
        g.drawImage(bb, 0, 0, Graphics.TOP | Graphics.LEFT);
        data[0].setPosition(15, 24);
        data[0].paint(g);
        data[1].setPosition(65, 24);
        data[1].paint(g);
        data[2].setPosition(115, 24);
        data[2].paint(g);
        data[3].setPosition(165, 24);
        data[3].paint(g);
        data[4].setPosition(215, 24);
        data[4].paint(g);
        data[5].setPosition(265, 24);
        data[5].paint(g);
        data[6].setPosition(15, 79);
        data[6].paint(g);
        data[7].setPosition(65, 79);
        data[7].paint(g);
        data[8].setPosition(115, 79);
        data[8].paint(g);
        data[9].setPosition(165, 79);
        data[9].paint(g);
        data[10].setPosition(215, 79);
        data[10].paint(g);
        data[11].setPosition(265, 79);
        data[11].paint(g);
        data[12].setPosition(15, 134);
        data[12].paint(g);
        data[13].setPosition(65, 134);
        data[13].paint(g);
        data[14].setPosition(115, 134);
        data[14].paint(g);
        data[15].setPosition(165, 134);
        data[15].paint(g);
        data[16].setPosition(215, 134);
        data[16].paint(g);
        data[17].setPosition(265, 134);
        data[17].paint(g);

        for (int i = 0; i < 3; i++) {
            if (selectPoint == i) {
                g.drawImage(select, ((selectPoint2 * 50) + 12), (i * 55) + 21, Graphics.TOP | Graphics.LEFT);
            } else {
                g.drawImage(select, this.getWidth() / 3, (this.getHeight()), Graphics.TOP | Graphics.LEFT);
            }
        }

        if (!bnr) {//cek level
            g.setColor(0xffffff);
            g.fillRect(25, 20, 250, 200);
            g.setColor(0x000000);
            g.drawString("Selamat Anda Berhasil.....", 80, 100, Graphics.TOP | Graphics.LEFT);
            g.drawString("Waktu Anda : " + count2 + " : " + count1, 80, 130, Graphics.TOP | Graphics.LEFT);

            Thread.sleep(5000);
            tm.cancel();
            mulai(false);
            commOk = new Command("Ok", Command.OK, 1);
            tb = new TextBox("nama", "", 20, TextField.ANY);
            tb.addCommand(commOk);
            display.setCurrent(tb);
            tb.setCommandListener(this);
            running = true;
        }

        g.drawString(" " + count3 + " : " + count2 + " : " + count1 + " : " + count, 0, 0, Graphics.TOP | Graphics.LEFT);

        Thread.sleep(50);
        Thread.sleep(100);

        this.addCommand(cmStart);
        this.setCommandListener((CommandListener) this);
        this.addCommand(cmExit);
        this.setCommandListener((CommandListener) this);

        repaint();
        flushGraphics();
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmStart) {
            this.removeCommand(cmStart);
            this.addComm(2);
            nolkan();
            mulai(true);
            defaultLain();
            loadSprite();
            raNdom();
            ipp = false;
        } else if (c == cmStop) {
            this.removeCommand(c);
            addComm(3);
            ipp = true;
            tm.cancel();
            mulai(false);
        } else if (c == cmResume) {
            this.removeCommand(c);
            addComm(2);
            mulai(true);
            ipp = false;
        }

        if (c == cmExit) {
            try {
                MenuUtama muu = new MenuUtama(display, mid);
                display.setCurrent(muu);
            } catch (RecordStoreException ex) {
                ex.printStackTrace();
            }

        }

        if (c.equals(commOk)) {//simpan waktu terbaik
            sm = new ScoreManager();
            try {
                count1 = count1 - 5;
                String j = String.valueOf(count1);
                String k = String.valueOf(count2);
                String l = k + j;
                int i = Integer.parseInt(l);
                System.out.println(i);
                sm.setScore(tb.getString(), k + " : " + j);
            } catch (RecordStoreException ex) {
                ex.printStackTrace();
            }
            sm = null;
            try {
                RecordTime rt = new RecordTime(display, mu);
                display.setCurrent(rt);
//              this.displayHs();
            } catch (RecordStoreException ex) {
                ex.printStackTrace();
            }
        }

        if (c.equals(cmdOk)) {
            lee = true;
            leve = false;

        }
    }
}

