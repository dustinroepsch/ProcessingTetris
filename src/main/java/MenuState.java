import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Created by dusti on 11/4/2016.
 */
public class MenuState extends GameState {
    public MenuState(TetrisGame pApplet) {
        super(pApplet);
    }


    public void tick() {

    }

    @Override
    public void draw() {
        //pApplet.textMode(PConstants.CENTER);
        pApplet.clear();
        pApplet.background(0);
        pApplet.fill(pApplet.color(255, 0, 0));
        pApplet.textSize(40);
        pApplet.text("Welcome \n to Tetris! :) \n (press space)", 20, 50);
    }

    public void keyPressed() {
        if (pApplet.key == ' ') {
            pApplet.currentState = pApplet.playingState;
        }

    }
}
