package Main;

import Main.GameObjects.Entity.Player;
import Main.Utils.KeyHandler;
import Main.Utils.MapHandler.MapHandler;
import Main.Utils.MouseHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // Window Variables
    private Thread thread;
    private JFrame frame;
    public final int FPS = 60;
    public int mRows = 9, mCols = 16;
    public int tileSize = 48;
    private int sWidth = mCols * tileSize; // short for screen Width
    private int sHeight = mRows * tileSize; // short for screen Height
    private String title = "Game Window";

    // Utils
    KeyHandler kh;
    MouseHandler mh;
    public MapHandler mapH;

    public Player p;


    public GamePanel(){
        init();
    }

    private void init() {
        // Initializing some Variables
        kh = new KeyHandler(this);
        mh = new MouseHandler(this);
        mapH = new MapHandler(this);

        p = new Player(this);

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
        mapH.loadMap();
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
        p.update();
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics; // using graphics2d other than graphics

        mapH.draw(g);
        p.draw(g);

        g.dispose();
    }
}
