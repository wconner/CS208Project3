import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bill on 10/21/15.
 */
public class MyPanel extends JPanel {
    JLabel clockLabel;
    JButton startButton, releaseButton, checkButton;
    Main main;

    public MyPanel() {
        setLayout(new BorderLayout());

        clockLabel = new JLabel("6:00AM");
        startButton = new JButton("Start");
        releaseButton = new JButton("Open Trail Entrances");
        checkButton = new JButton("Check Trail Entrances");
        startButton.addActionListener(new StartListener());
        releaseButton.addActionListener(new ReleaseListener());
        checkButton.addActionListener(new CheckListener());

        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();

        northPanel.add(clockLabel);
        southPanel.add(startButton);
        southPanel.add(releaseButton);
        southPanel.add(checkButton);

        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void startMain(){main = new Main(this);}

    public void updateClock(String time){
        clockLabel.setText(time);
    }

    class StartListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            main.setRun(7);
        }
    }
    class ReleaseListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if (((int) main.getTime().charAt(0)) == 55) //55 is 7 in ASCII
                main.setRun(10);
        }
    }
    class CheckListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if (((int) main.getTime().charAt(0)) == 49) //49 is 1 in ASCII
                main.setRun(12);
        }
    }
}
