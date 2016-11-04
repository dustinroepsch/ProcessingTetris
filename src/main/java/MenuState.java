import processing.core.PApplet;

/**
 * Created by dusti on 11/4/2016.
 */
public class MenuState extends GameState {
    boolean shouldUpdate = true;
    public MenuState(PApplet pApplet) {
        super(pApplet);
    }


    public void tick() {
        if (shouldUpdate) {
            for (int i = 0; i < statePixels.length; i++) {
                statePixels[i] = pApplet.color((float) Math.random() * 255, (float) Math.random() * 255, (float) Math.random() * 255);
            }
        }
    }

    public void keyPressed() {
        if (pApplet.key == ' ') {
            shouldUpdate = !shouldUpdate;
        }
    }
}
