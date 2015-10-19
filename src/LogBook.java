import java.io.PrintWriter;
import java.util.ArrayList<E>;
/**
 * Created by bill on 10/16/15.
 * Updated 10/19/15.
 */
public class LogBook {
  private ArrayList<Hiker> hlog ;
  
  /**
   * Creates an arraylist to keep track of hikers.
   */
  public void Logbook()
  {
    hlog = new ArrayList<Hiker>();
  }
  
  /**
   * Adds a hiker to the Arraylist
   * @parramiter Hiker hiker: The hiker to be added
   */
  public void addToLog(Hiker hiker)
  {
    hlog.add(hiker)
  }
  
  /**
   * Takes the arraylist and writes it to a 
   * text file named "Logbook.txt".
   * Will overrite if text file is already present.
   */
  public void toText()
  {
    PrintWriter  log = new PrintWriter("Logbook.txt","UTF-8");
    for (i == 0; i > (hlog.size - 1); i++)
    {
     log.println((hlog.get(i).getIDNum()));
    }
    log.close();
  }
    
    
}
