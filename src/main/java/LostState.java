/**
 * Created by dusti on 11/4/2016.
 */
public class LostState extends GameState {
    public LostState(TetrisGame pApplet) {
        super(pApplet);
    }

    @Override
    public void draw() {
        //pApplet.textMode(PConstants.CENTER);
        pApplet.clear();
        pApplet.background(0);
        pApplet.fill(pApplet.color(255, 0, 0));
        pApplet.textSize(40);
        pApplet.text("You Lost :( \n (press space)", 20, 50);
    }

    public void tick() {

    }

    public void keyPressed() {
        if (pApplet.key == ' ') {
            pApplet.playingState = new PlayingState(pApplet);
            pApplet.currentState = pApplet.playingState;
        }
    }
}
