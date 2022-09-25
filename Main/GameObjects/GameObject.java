package Main.GameObjects;

import Main.GamePanel;

public class GameObject {
    protected GamePanel gp;
    protected float x, y;

    public GameObject(float x, float y, GamePanel gp){
        this.x = x; this.y = y; this.gp = gp;
    }

    public static float getDistanceBetweenTwoPoints(float x1, float y1, float x2, float y2){

        float deltaX = x1 - x2;
        float deltaY = y1 - y2;

        return (float) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)); // using trignometry pytagoras theorem (maybe bad spelling lmao)
    }

    public static float getDistanceBetweenTwoGameObjects(GameObject o1, GameObject o2){
        float deltaX = o1.x - o2.x;
        float deltaY = o1.y - o2.y;

        return (float) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)); // using trignometry pytagoras theorem (maybe bad spelling lmao)
    }

    public float getDistanceBetweenPoint(float x, float y){
        float deltaX = this.x - x;
        float deltaY = this.y - y;

        return (float) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)); // using trignometry pytagoras theorem (maybe bad spelling lmao)
    }

    public float getDistanceBetweenGameObject(GameObject o){
        float deltaX = this.x - o.x;
        float deltaY = this.y - o.y;

        return (float) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)); // using trignometry pytagoras theorem (maybe bad spelling lmao)
    }
}
