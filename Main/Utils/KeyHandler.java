package Main.Utils;

import Main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GamePanel gp;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> {gp.p.isWalking = true; gp.p.dir = 0;}
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {gp.p.isWalking = true; gp.p.dir = 2;}
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {gp.p.isWalking = true; gp.p.dir = 1;}
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {gp.p.isWalking = true; gp.p.dir = 3;}
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W, KeyEvent.VK_UP, KeyEvent.VK_S, KeyEvent.VK_DOWN, KeyEvent.VK_A, KeyEvent.VK_LEFT, KeyEvent.VK_D, KeyEvent.VK_RIGHT -> gp.p.isWalking = false;
        }
    }
}
