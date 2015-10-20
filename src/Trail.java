import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by bill on 10/16/15.
 */
public class Trail {
    private ArrayDeque<Hiker> hikerQueue;
    private int trailName;

    public Trail(int trailName) {
        this.trailName =trailName;
        hikerQueue = new ArrayDeque<Hiker>(100);
    }

    public void addStack(Stack<Hiker> hikerStack){
        for (int i = 0; i < hikerStack.size(); i++)
            hikerQueue.add(hikerStack.pop());
    }

    public Hiker releaseHiker(){
        return hikerQueue.pop();
    }

    public boolean hasNext(){ return !hikerQueue.isEmpty();}

    public int getTrailName(){ return trailName;}

}
