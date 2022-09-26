package Main.GameObjects.Entity;

import Main.GameObjects.Tile;
import Main.GamePanel;

import java.awt.*;

public class Player extends Entity {

    public Player(GamePanel gp){
        super(50f, 50f, gp, gp.tileSize - 4f, (gp.tileSize * 2) - 4f, 10f, 0.3f);
        init();
    }
    @Override
    protected void init() {
        // Adding images or much more
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    protected void setImage() {

    }

    @Override
    protected void move() {
        if (isWalking) {
            switch (dir) {
                case 0 -> {
                    accX = 0f;
                    accY = -acc;
                    velX = 0f;
                    if(velY > 0){
                        velY = 0f;
                    }
                    velY += accY;

                    if(velY < -mSpeed) velY = -mSpeed;
                }

                case 2 -> {
                    accX = 0f;
                    accY = acc;
                    velX = 0f;
                    if(velY < 0){
                        velY = 0f;
                    }
                    velY += accY;

                    if(velY > mSpeed) velY = mSpeed;
                }

                case 1 -> {
                    accX = -acc;
                    accY = 0f;
                    velY = 0f;
                    if(velX > 0){
                        velX = 0f;
                    }
                    velX += accX;

                    if(velX < -mSpeed) velX = -mSpeed;
                }

                case 3 -> {
                    accX = acc;
                    accY = 0f;
                    velY = 0f;
                    if(velX < 0){
                        velX = 0f;
                    }
                    velX += accX;

                    if(velX > mSpeed) velX = mSpeed;
                }
            }

            x += velX;

            for (Tile[] tiles: gp.mapH.map) {
                for (Tile tile: tiles){
                    if (tile.solid){
                        if (isColliding(tile)){
                            if(velX > 0) {
                                x = tile.x - width;
                            }else{
                                x = tile.x + tile.width;
                            }
                        }
                    }
                }
            }

            y += velY;

            for (Tile[] tiles: gp.mapH.map) {
                for (Tile tile: tiles){
                    if (tile.solid){
                        if (isColliding(tile)){
                            if(velY > 0) {
                                y = tile.y - height;
                            }else{
                                y = tile.y + tile.height;
                            }
                        }
                    }
                }
            }


        }
    }

    @Override
    public void update(){
        setImage();
        move();
    }
}
