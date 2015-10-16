import java.util.Random;
import java.util.Stack;

public class Main {

    public static void main(String[] args) { new Main();}

    private MClock clock;
    private Stack<Hiker> hikerStack;

    public Main(){
        clock = new MClock();
        hikerStack = new Stack<Hiker>();

        while(clock.getHour() < 22)
            runLoop();
    }

    private void runLoop(){
        Random random = new Random();
        int r = random.nextInt(10);

        for (int i = 0; i < r; i ++) {
            if (hikerStack.size() <= 10)
                hikerStack.add(new Hiker());
            else{
                //TODO Add hikerStack to trail
                hikerStack.clear();
                hikerStack.add(new Hiker());
            }
        }
        clock.updateTime();
    }
}
