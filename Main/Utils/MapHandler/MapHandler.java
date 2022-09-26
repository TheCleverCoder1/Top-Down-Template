package Main.Utils.MapHandler;

import Main.GameObjects.Tile;
import Main.GamePanel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MapHandler {
    private GamePanel gp;
    private BufferedReader br;

    public Tile[][] map;

    public MapHandler(GamePanel gp){
        this.gp = gp;
    }

    public void loadMap(){
        try{
            br = new BufferedReader(new FileReader(new File("D:/java codes/Top-Down_Template/src/Main/Utils/MapHandler/Maps/Test_Map.txt")));
        }catch (IOException e){
            e.printStackTrace();
        }

        map = new Tile[gp.mRows][gp.mCols];
        try{
            for (int i = 0; i < gp.mRows; i++) {
                String line = br.readLine();
                String[] tileIdx = line.split(" ");
                for (int j = 0; j < gp.mCols; j++) {
                    map[i][j] = new Tile(j * gp.tileSize, i * gp.tileSize, gp, gp.tileSize, gp.tileSize, Integer.parseInt(tileIdx[j]));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g){
        for (Tile[] tiles: map) {
            for (Tile tile: tiles) {
                tile.draw(g);
            }
        }
    }
}
