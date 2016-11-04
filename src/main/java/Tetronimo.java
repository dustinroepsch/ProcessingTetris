import processing.core.PApplet;

/**
 * Created by dusti on 11/4/2016.
 */
public abstract class Tetronimo {
    private int color;
    private int[][] shape;
    private int x, y;
    private TetrisGame pApplet;

    public Tetronimo(int color, int[][] shape, int x, int y, TetrisGame pApplet) {
        this.color = color;
        this.shape = shape;
        this.x = x;
        this.y = y;
        this.pApplet = pApplet;
    }

    public void render() {
        pApplet.stroke(color);
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] != 0) {
                    pApplet.rect(x + j, y + i, 0, 0);
                }
            }
        }
    }
}
