package Main.GameObjects;

import Main.GamePanel;

public class Circle extends GameObject{
    private final float radius;

    public Circle(float x, float y, GamePanel gp, float radius) {
        super(x, y, gp); this.radius = radius;
    }

    public boolean isColliding(Circle c){
        return Math.sqrt(Math.pow(x - c.x, 2) + Math.pow(y - c.y, 2)) < radius + c.radius;
    }
}
