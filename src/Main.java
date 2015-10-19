import java.util.Random;
import java.util.Stack;

public class Main {

    public static void main(String[] args) { new Main();}

    private static final int NUMTRAILS = 4;

    private MClock clock;
    private Stack<Hiker> hikerStack;
    private Trail[] trails;
    private Hiker hiker;

    public Main(){
        clock = new MClock();
        hikerStack = new Stack<Hiker>();
        trails = new Trail[NUMTRAILS];

        makeTrails();

        while(clock.getHour() < 22)
            runLoop();
    }

    private void makeTrails(){
        for (int i = 0; i < NUMTRAILS; i++){
            trails[i] = new Trail(i + 1);
        }
    }

    private void runLoop(){
        Random random = new Random();
        int r = random.nextInt(10);

        while(clock.getHour() <= 10) {
            for (int i = 0; i < r; i++) {
                if (hikerStack.size() < 10)
                    hikerStack.add(new Hiker());
                else {
                    int c = random.nextInt(4);
                    trails[c].addStack(hikerStack);
                    hikerStack.clear();
                    hikerStack.add(new Hiker());
                }
            }
        }
        if ((clock.getHour() == 7) && (clock.getMinuteTens() == 0) && (clock.getMinuteOnes() == 0)) { //10:00 AM
            System.out.println("Hiker ID Numbers:");
            for (int i = 0; i < NUMTRAILS; i++){
                for (int j =0; j < 20; j++){
                    //TODO pass hiker to logbook
                    System.out.println(trails[i].releaseHiker().getIdNum());
                }
            }
        }
        clock.updateTime();
        System.out.println("Time: " + clock.getHour() + ":" + clock.getMinuteTens() + clock.getMinuteOnes());
    }
}
