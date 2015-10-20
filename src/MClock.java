/**
 * Created by bill on 10/16/15.
 * The simulations clock, increments by 5 minutes.
 */
public class MClock {
    private int time;

    public MClock(){
        time = 600;
    }

    public void updateTime(){
        time += 5;
        if ((time % 100) == 60)
            time += 40;
    }

    public int getHour(){ return time / 100;} /** Returns the value for the hour **/
    public int getMinuteTens(){ return ((time % 100) / 10);} /** Returns the value for the minutes tens place **/
    public int getMinuteOnes(){return ((time % 100) % 10);} /** Returns the value for the minutes ones place **/
    public int getMinutes(){return ((10 * getMinuteTens()) + getMinuteOnes());} /** Returns the value of the minutes **/
}
