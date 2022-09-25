/*

    Welcome to the BasicWindowTemplate in github btw it's my first post and this is a useful thing because you
    can use this project for making a window to start with which is actually a good thing Right!!

    It contains:---
      1. Main Class (from where the thing would start because it has public static void main(String[] args) func
      2. Main Package:--
        1. GamePanel (this is like the main class from where every Game object is drawed on the screen and updated.
        2. GameObjects Package:--
          1. GameObject Class (every class inherits it)
          2. Circle Class (circle)
          3. Rectangle Class (rectangle)
        3. Utils Package:--
          1. KeyHandler Class (handle key)
          2. MouseHandler Class (handle mouse)

 */
import Main.GamePanel;

/*
 The Main class here everything starts.
 */
public class Main {
    public static void main(String[] args) {
        new GamePanel();
    }
}