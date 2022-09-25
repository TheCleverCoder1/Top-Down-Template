package Main.GameObjects;

import Main.GamePanel;

public class Rectangle extends GameObject{
    protected float width, height;

    public Rectangle(float x, float y, GamePanel gp, float width, float height) {
        super(x, y, gp); this.width = width; this.height = height;
    }

    public boolean isColliding(Rectangle r){
        return ((x + width > r.x && x + width < r.x + r.width) && (y + height > r.y && y + height < r.y + r.height)) || ((x > r.x && x < r.x + r.width) && (y > r.y && y < r.y + r.height)) || ((x + width > r.x && x + width < r.x + r.width) && (y > r.y && y < r.y + r.height)) || ((x > r.x && x < r.x + r.width) && (y + height > r.y && y + height < r.y + r.height));
    }
}
