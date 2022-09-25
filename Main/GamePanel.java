package Main;

import Main.Utils.KeyHandler;
import Main.Utils.MouseHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // Window Variables
    private Thread thread;
    private JFrame frame;
    public final int FPS = 60;
    private int sWidth = 1200; // short for screen Width
    private int sHeight = 800; // short for screen Height
    private String title = "Game Window";

    // Utils
    KeyHandler kh;
    MouseHandler mh;


    public GamePanel(){
        init();
    }

    private void init() {
        // Initializing some Variables
        kh = new KeyHandler(this);
        mh = new MouseHandler(this);

        // Initializing JPanel i.e. this
        setPreferredSize(new Dimension(sWidth, sHeight));
        setBackground(Color.WHITE);
        setOpaque(true);
        setDoubleBuffered(true);
        setFocusable(true);
        addMouseListener(mh);
        addMouseMotionListener(mh);
        addMouseWheelListener(mh);
        addKeyListener(kh);

        // Initializing the Jframe
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(640 - (sWidth/2), 510 - (sHeight/2) ); // i.e. in the center
        frame.setTitle(title);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);

        // Starting
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        // Fps vars
        long lTime = System.nanoTime(); // short for lastTime
        long dTime = 1000000000/FPS; // the first number is a second in nanosecond form (9 0's after 1)
        while (true) {
            if(System.nanoTime() > lTime + dTime) {
                update();
                repaint();

                lTime = System.nanoTime();
            }
        }
    }

    private void update(){

    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics; // using graphics2d other than graphics



        g.dispose();
    }
}
