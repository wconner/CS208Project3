import javax.swing.*;
import java.awt.*;

/**
 * Created by bill on 10/21/15.
 * Simple class, needed to make gui work, probably could be an inner class of myPanel
 */
public class Viewer {

        public static void main(String[] args){new Viewer();}

        private JFrame frame;
        private MyPanel panel;

        public Viewer(){
            frame = new JFrame();
            panel = new MyPanel();
            Container contentPane = frame.getContentPane();

            contentPane.add(panel);

            frame.pack();
            frame.setVisible(true);

            panel.startMain();
        }
}