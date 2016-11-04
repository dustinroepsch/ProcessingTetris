import processing.core.PApplet;

/**
 * Created by dusti on 11/4/2016.
 */
public class TetrisGame extends PApplet {
    public GameState currentState;

    @Override
    public void settings() {
        size(500, 500);
    }

    @Override
    public void setup() {
        background(0);
        currentState = new MenuState(this);
    }

    @Override
    public void draw() {
        currentState.draw();
        currentState.tick();
    }

    @Override
    public void keyPressed() {
        currentState.keyPressed();
    }

    public static void main(String[] args) {
        PApplet.main("TetrisGame");
    }
}
