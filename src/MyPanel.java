import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bill on 10/21/15.
 * This is where all the gui magic happens, gui's require a lot of lines of code....
 */
public class MyPanel extends JPanel {
    JLabel clockLabel;
    JButton startButton, releaseButton, checkButton;
    Main main;
    TextArea trail1Hikers, trail2Hikers, trail3Hikers, trail4Hikers;

    public MyPanel() {
        setLayout(new BorderLayout());

        clockLabel = new JLabel("6:00AM");
        startButton = new JButton("Start");
        releaseButton = new JButton("Open Trail Entrances");
        checkButton = new JButton("Check Trail Entrances");
        trail1Hikers = new TextArea("Trail 1:\n",10,10);
        trail2Hikers = new TextArea("Trail 2:\n",10,10);
        trail3Hikers = new TextArea("Trail 3:\n",10,10);
        trail4Hikers = new TextArea("Trail 4:\n",10,10);


        startButton.addActionListener(new StartListener());
        releaseButton.addActionListener(new ReleaseListener());
        checkButton.addActionListener(new CheckListener());

        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        northPanel.add(clockLabel);
        southPanel.add(startButton);
        southPanel.add(releaseButton);
        southPanel.add(checkButton);
        centerPanel.add(trail1Hikers);
        centerPanel.add(trail2Hikers);
        centerPanel.add(trail3Hikers);
        centerPanel.add(trail4Hikers);

        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    public void startMain(){main = new Main(this);}

    public void updateClock(String time){
        clockLabel.setText(time);
    }

    /**
     * This is where hiker's names (ID #) are added to the list on the gui
     * @param hikerID hiker ID to be added
     * @param trailnum which trail the hiker was added to
     */
    public void addHikerName(int hikerID, int trailnum){
        switch (trailnum){
            case 1:
                trail1Hikers.append(hikerID + "\n");
                break;
            case 2:
                trail2Hikers.append(hikerID + "\n");
                break;
            case 3:
                trail3Hikers.append(hikerID + "\n");
                break;
            case 4: trail4Hikers.append(hikerID + "\n");
                break;
            default:
                break;
        }
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
