import processing.core.PApplet;

/**
 * Created by dusti on 11/4/2016.
 */
public abstract class GameState {
    protected PApplet pApplet;
    protected int[] statePixels;

    public GameState(PApplet pApplet) {
        this.pApplet = pApplet;
        pApplet.loadPixels();
        statePixels = new int[pApplet.pixels.length];
        pApplet.updatePixels();
    }

    public void draw() {
        pApplet.loadPixels();
        for (int i = 0; i < statePixels.length; i++) {
            pApplet.pixels[i] = statePixels[i];
        }
        pApplet.updatePixels();
    }

    public abstract void tick();

    public abstract void keyPressed();
}
