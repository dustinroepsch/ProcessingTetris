import processing.core.PApplet;

/**
 * Created by dusti on 11/4/2016.
 */
public class TetrisGame extends PApplet {
    public static final int TETRIS_BOARD_WIDTH = 10;
    public static final int TETRIS_BOARD_HEIGHT = 22;
    public static final int RENDER_SCALE = 30;

    public GameState menuState;
    public GameState playingState;

    public GameState currentState;

    @Override
    public void settings() {
        size(TETRIS_BOARD_WIDTH * RENDER_SCALE, TETRIS_BOARD_HEIGHT * RENDER_SCALE);
    }

    @Override
    public void setup() {
        initializeStates();
        currentState = menuState;
    }

    private void initializeStates() {
        menuState = new MenuState(this);
        playingState = new PlayingState(this);
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
