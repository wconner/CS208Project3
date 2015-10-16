/**
 * Created by bill on 10/16/15.
 * Each hiker has an ID number
 */

public class Hiker {
    private static int hikerID = 0; //Static aka class variable
    private int idNum;

    public Hiker(){
        hikerID++;
        idNum = hikerID;
    }

    public int getIdNum(){ return idNum;}
}
