package Main.GameObjects;

import Main.GamePanel;

import java.awt.*;

public class Tile extends Rectangle {
    private final int tileIdx;
    public boolean solid = true;

    public Tile(float x, float y, GamePanel gp, float width, float height, int tileIdx) {
        super(x, y, gp, width, height); this.tileIdx = tileIdx;
        if (tileIdx == 10){
            solid = false;
        }
    }


    public void draw(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        if (tileIdx == 10) {
            g.setColor(Color.LIGHT_GRAY);
        }
        g.fillRect((int) x, (int) y, (int) width, (int) height);
    }
}
