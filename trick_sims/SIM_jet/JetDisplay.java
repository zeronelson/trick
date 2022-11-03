/* How to fix issue with clang headers?  */
/* How to change UI for sliders? */
package trick;
import java.awt.*; /* library for design and graphics */
import javax.sound.sampled.Control;
import javax.swing.*; /* library for GUI window */
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.*;
import java.io.*;
import javax.swing.BorderFactory; 
import javax.swing.border.EtchedBorder;
/* 
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.net.Socket;
*/
/* CLASS RECAP: user-defined blueprint/template that allows us to create objects */

/* JFrame = GUI window to add components to... Main container for program */
public class JetDisplay extends JFrame {
    private RangeView rangeView;
    private ControlPanel controlPanel;
    private JPanel viewPanelGroup, controlPanelGroup;
    
    /* class constructor */
    public JetDisplay(){
        rangeView = null;
        setTitle("Jet Simulation");
        setSize(600,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setFocusable(true);
    }
    public void createGUI(int mapScale){
        /* create display object */
        rangeView = new RangeView(mapScale); 

         /* create control panel object */
        controlPanel = new ControlPanel(rangeView);

        /* create JPanel to hold display and control panel */
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.Y_AXIS));
        parentPanel.add(rangeView);
        parentPanel.add(controlPanel);
        rangeView.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        controlPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

        add(parentPanel);
        setVisible(true);
    
        // How to set size of the panels??
        
       
    }

    public static void main (String[] args) throws IOException{
        System.out.println("------------- Opening Java Display -------------");
        /* create display object aka GUI window */
        JetDisplay JetDisplay = new JetDisplay(); 

        int mapScale = 32;
        /* Call to create GUI */
        JetDisplay.createGUI(mapScale);
       

    }
}
/* class for create graphic objects */
class ScenePoly {  
    public Color color; 
    public int n; 
    /* arrays which hold x and y screen coordinates of objects */
    public double[] x; 
    public double[] y;
}
/* class for display */
class RangeView extends JPanel { 

    private int scale;
    private int worldOriginX;   
    private int worldOriginY;

    private double[] jetPos;
    private double[] jetVel;

    private int speed;
    private ScenePoly jet;
    /* Class constructor */
    public RangeView(int mapScale){
        setScale(mapScale);
    }
    
    public void setScale(int mapScale){
        if (mapScale < 2) {
            scale = 2;
        } else if (mapScale > 128) {
            scale = 128;
        } else {
            scale = mapScale;
        }
        repaint();
    } 
    public int getScale(){
        return scale;
    }
    private void doDrawing(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }
    public void drawRangeView(){
      //  rangeView.repaint();
    }

}
/* class for control buttons */
class ControlPanel extends JPanel implements ChangeListener{
    private RangeView rangeView;
    private SpeedCtrlPanel speedCtrlPanel;
    private ScaleCtrlPanel scaleCtrlPanel;
    private HeadingCtrlPanel headingCtrlPanel;

    /* Class constructor */
    public ControlPanel (RangeView view){
        rangeView = view;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JPanel labeledSpeedCtrlPanel = new JPanel();
        labeledSpeedCtrlPanel.setLayout(new BoxLayout(labeledSpeedCtrlPanel, BoxLayout.Y_AXIS));
        JLabel speedCtrlLabel = new JLabel("Speed");
        speedCtrlLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labeledSpeedCtrlPanel.add(speedCtrlLabel);
        speedCtrlPanel = new SpeedCtrlPanel(rangeView);
        labeledSpeedCtrlPanel.add(speedCtrlPanel);
        add(labeledSpeedCtrlPanel);

        JPanel labeledScaleCtrlPanel = new JPanel();
        labeledScaleCtrlPanel.setLayout(new BoxLayout(labeledScaleCtrlPanel, BoxLayout.Y_AXIS));
        JLabel scaleCtrlLabel = new JLabel("Scale");
        scaleCtrlLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labeledScaleCtrlPanel.add(scaleCtrlLabel);
        scaleCtrlPanel = new ScaleCtrlPanel(rangeView);
        labeledScaleCtrlPanel.add(scaleCtrlPanel);
        add(labeledScaleCtrlPanel);

        JPanel labeledHeadingCtrlPanel = new JPanel();
        labeledHeadingCtrlPanel.setLayout(new BoxLayout(labeledHeadingCtrlPanel, BoxLayout.Y_AXIS));
        JLabel headingCtrlLabel = new JLabel("Heading");
        headingCtrlLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labeledHeadingCtrlPanel.add(headingCtrlLabel);
        headingCtrlPanel = new HeadingCtrlPanel(rangeView);
        labeledHeadingCtrlPanel.add(headingCtrlPanel);
        add(labeledHeadingCtrlPanel);
    

    }
    public void stateChanged(ChangeEvent e){
       // String s = e.getActionCommand();
        String s = "hey";
        switch (s){
            case "incSpeed":
            case "decSpeed":
            case "incBearing":
            case "decBearing":
            case "incScale":
            case "decScale":
            break;  
        }
    }
}

class SpeedCtrlPanel extends JPanel implements ChangeListener {
    private SkyView skyView;
    private JSlider speedSlider;
    private JLabel speedLabel;

    /* class constructor */
    public SpeedCtrlPanel(SkyView view){
        skyView = view;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder( BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

        speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 2000, 0);
        speedSlider.setMajorTickSpacing(500);
        speedSlider.setPaintTrack(true);
        speedSlider.setPaintLabels(true);
        //speedSlider.addChangeListener(this);
        add(speedSlider);
    }

    public void stateChanged(ChangeEvent e){
        String s = "Boo";
        switch (s){
            case "Zen":
            break;
        }
    }
}



  

class HeadingCtrlPanel extends JPanel implements ChangeListener {
    private RangeView rangeView;
    private JSlider headingSlider;
    private JLabel headingLabel;

    public HeadingCtrlPanel(RangeView view){
        rangeView = view;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder( BorderFactory.createEtchedBorder(EtchedBorder.RAISED));


        headingSlider = new JSlider(JSlider.HORIZONTAL, 0, 360, 0);
        headingSlider.setMajorTickSpacing(90);
        headingSlider.setPaintTrack(true);
        headingSlider.setPaintLabels(true);
        headingSlider.addChangeListener(this);
        add(headingSlider);
    }

    public void stateChanged(ChangeEvent e){
        int value = headingSlider.getValue();
       /* System.out.println("Slider value: " + value);
        System.out.println(((JSlider) e.getSource()).getValue()); */
       /*  String s = "Boo";
        switch (s){
            case "Zen":
            break;
        } */
    }

}

class ScaleCtrlPanel extends JPanel implements ActionListener {
    private RangeView rangeView;
    private JButton zoomInButton;
    private JButton zoomOutButton;
    

    public ScaleCtrlPanel(RangeView view){
        rangeView = view;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder( BorderFactory.createEtchedBorder(EtchedBorder.RAISED));


        zoomInButton = new JButton("\u25b2");
        zoomInButton.addActionListener(this);
        zoomInButton.setActionCommand("zoomin");
        zoomInButton.setToolTipText("Zoom In");

        zoomOutButton = new JButton("\u25bc");
        zoomOutButton.addActionListener(this);
        zoomOutButton.setActionCommand("zoomout");
        zoomOutButton.setToolTipText("Zoom Out");

        add(zoomInButton);
        add(zoomOutButton);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        switch (s){
            case "zoomout":
                rangeView.setScale(rangeView.getScale() / 2);
            case "zoomin":
                rangeView.setScale(rangeView.getScale() * 2);
            default:
                System.out.println("Unknown Action Command: " + s);
            break;
        }
    }

}