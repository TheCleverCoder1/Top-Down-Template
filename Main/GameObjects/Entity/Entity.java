package Main.GameObjects.Entity;

import Main.GameObjects.Rectangle;
import Main.GamePanel;

import java.awt.*;
import java.util.Objects;

public abstract class Entity extends Rectangle {

    // speed (moving vars)
    protected final float mSpeed;
    protected final float acc;
    public int dir = 2;
    protected float accX = 0f, accY = 0f, velX = 0f, velY = 0f;
    protected Image[] imgs;
    protected Image img = null;
    public boolean isWalking = false;

    public Entity(float x, float y, GamePanel gp, float width, float height, float mSpeed, float acc) {
        super(x, y, gp, width, height); this.mSpeed = mSpeed; this.acc = acc;
        init();
    }

    protected abstract void init();

    public Entity(float x, float y, GamePanel gp, float width, float height, float mSpeed, float acc, Image img) {
        super(x, y, gp, width, height); this.mSpeed = mSpeed; this.acc = acc; this.img = img;
        init();
    }

    public abstract void draw(Graphics2D g);

    public abstract void update();

    protected abstract void setImage();

    protected abstract void move();

}
