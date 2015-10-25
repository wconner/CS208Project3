import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by bill on 10/16/15.
 * In this class I use the queue.  Hikers are recieved in a stack, and transferred straight to a queue
 * At this point they can be removed from the queue when they are released onto the trail.
 * Again there is no real purpose to the queue, but it is a way to store the hikers.
 */
    
public class Trail {
    private ArrayDeque<Hiker> hikerQueue;
    private int trailNum;
    private String hikerString;
    private PrintWriter writer;


    public Trail(int trailNum){
        this.trailNum = trailNum;
        hikerQueue = new ArrayDeque<Hiker>(100);
        hikerString = "";

        try {
            writer = new PrintWriter("Trail" + trailNum + ".txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes in a stack of hikers and puts them into the queue.
     * @param hikerStack the stack of hikers
     */
    public void addStack(Stack<Hiker> hikerStack){
        int j = hikerStack.size();
        for (int i = 0; i < j; i++)
            hikerQueue.add(hikerStack.pop());
    }

    /**
     * Releases the hiker from the queue, onto the trail
     * @return the hiker released onto the trail.
     */
    public Hiker releaseHiker(){
        hikerString += hikerQueue.peek().getIdNum() + "\n";
        return hikerQueue.pop();
    }

    /**
     * This is called once all hikers are released onto the trail and makes a file with all hikers that
     * were released onto said trail.
     */
    public void makeFile(){
        writer.println(hikerString);
        writer.close();
    }

    public boolean hasNext(){ return !hikerQueue.isEmpty();}
}
