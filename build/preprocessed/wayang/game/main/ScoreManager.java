/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wayang.game.main;

import java.util.Vector;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

/**
 *
 * @author Fendi
 */
public class ScoreManager {
private RecordStore rs = null;
    private int maxRecord=5;

    public ScoreManager()
    {

    }

    private void close() throws RecordStoreException
    {
        try {
            rs.closeRecordStore();
            rs=null;
        } catch (RecordStoreNotOpenException ex) {
            ex.printStackTrace();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    private String[] sort(Vector v)
    {
        String[] arraySort=new String[v.size()];
        v.copyInto(arraySort);


        int a=0;
        int b=0;
        String abTemp=null;
        for(int i=0;i<arraySort.length-1;i++)
        {
            for(int j=1;j<arraySort.length;j++)
            {
                a=Integer.parseInt(arraySort[j].substring(1+arraySort[j].indexOf(":")));
                b=Integer.parseInt(arraySort[j-1].substring(1+arraySort[j-1].indexOf(":")));
                if(a<b)
                {
                    abTemp=arraySort[j];
                    arraySort[j]=arraySort[j-1];
                    arraySort[j-1]=abTemp;
                }
            }

        }
        return arraySort;
    }

    public void setScore(String name, String score) throws RecordStoreException
    {

        try {
            rs = RecordStore.openRecordStore("myscore", true);
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }

        String data=name+":"+score;
        try {
                    rs.addRecord(data.getBytes(), 0, data.getBytes().length);
        } catch (RecordStoreNotOpenException ex) {
            ex.printStackTrace();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
        this.close();

    }

    public String[] getScore() throws RecordStoreException
    {

        Vector vData = new Vector();
        try {

            rs = RecordStore.openRecordStore("myscore", true);


            RecordEnumeration re = rs.enumerateRecords(null, null, false);

            while (re.hasNextElement()) {
                vData.addElement(new String(re.nextRecord()));
            }

            re = rs.enumerateRecords(null, null, false);

            while (re.hasNextElement()) {
                rs.deleteRecord(re.nextRecordId());
            }


        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }

        this.close();

        String[] dataScore=sort(vData);
        for (int i = 0; i < dataScore.length; i++) {
            if(i<maxRecord)
            {
             this.setScore(dataScore[i].substring(0,dataScore[i].indexOf(":")), (dataScore[i].substring(1+dataScore[i].indexOf(":"))));
      
//                this.setScore(dataScore[i].substring(0,dataScore[i].indexOf(":")), dataScore[i].substring(1+dataScore[i].indexOf(":")));
            }
            else
            {
                dataScore[i]="";
            }
        }
        return dataScore;

    }

}
