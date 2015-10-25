import java.util.Random;
import java.util.Stack;

/**
 * Created by bill on 10/16/15.
 * This is the main class for the simulation.
 *
 * I use the stack in this class.  When a hiker is created he is added to the stack
 * when the stack is full (10 hikers), it is then passed to the Trail
 * A stack is not necessary, but it is a way to pass the hikers.
 */

public class Main {
    private static final int NUMTRAILS = 4;

    private MClock clock;
    private Stack<Hiker> hikerStack;
    private Trail[] trails;
    private MyPanel myPanel;

    public Main(MyPanel myPanel) {
        this.myPanel = myPanel;
        clock = new MClock();
        hikerStack = new Stack<Hiker>();
        trails = new Trail[NUMTRAILS];

        makeTrails();
    }

    private void makeTrails() {
        for (int i = 0; i < NUMTRAILS; i++) {
            trails[i] = new Trail(i + 1);
        }
    }

    public void runLoop() {
        Random random = new Random();
        int r = random.nextInt(10);

        if (clock.getHour() < 12) {
            /** Generates a random amount of hikers and adds them to the stack. **/
            for (int i = 0; i < r; i++) {
                if (hikerStack.size() < 10)
                    hikerStack.push(new Hiker());
                /** Adds the full stack to the queue **/
                else {
                    int c = random.nextInt(4);
                    trails[c].addStack(hikerStack);
                    hikerStack.clear();
                    hikerStack.add(new Hiker());
                }
            }

            /** 7:00 AM  Initial release of hikers. **/
            if ((clock.getHour() == 7) && (clock.getMinutes() == 0)) {
                for (int i = 0; i < NUMTRAILS; i++) {
                    for (int j = 0; j < 20; j++) {
                        if(trails[i].hasNext())
                            myPanel.addHikerName(trails[i].releaseHiker().getIdNum(), i + 1);
                    }
                }
            }
            /** Between 7:00 and 10:00 AM  Releases hikers every 15 minutes. **/
            if((clock.getHour() >= 7) && (clock.getHour() < 10)){
                if((clock.getMinutes() % 15) == 0){
                    for (int i = 0; i < NUMTRAILS; i++){
                        while(trails[i].hasNext())
                            myPanel.addHikerName(trails[i].releaseHiker().getIdNum(), i + 1);

                    }
                }
            }

            /** 10:00 AM  Final release of hikers. **/
        if((clock.getHour()) == 10 && (clock.getMinutes() == 0))
            for (int i = 0; i < NUMTRAILS; i++) {
                while (trails[i].hasNext())
                    myPanel.addHikerName(trails[i].releaseHiker().getIdNum(), i + 1);
                trails[i].makeFile();
            }

            clock.updateTime();
            myPanel.updateClock(getTime());
            System.out.println("Time: " + clock.getHour() + ":" + clock.getMinuteTens() + clock.getMinuteOnes());
        }
    }

    /**
     * Returns time formatted for the panel.
     * @return the time
     */
    public String getTime(){
        String ampm;

        if(clock.getHour() < 12)
            ampm = "AM";
        else
            ampm = "PM";

        return clock.getHour() + ":" + clock.getMinuteTens() + clock.getMinuteOnes() + ampm;
    }

    public void setRun(int runtime){
        while(clock.getHour() < runtime)
            runLoop();
    }
}
