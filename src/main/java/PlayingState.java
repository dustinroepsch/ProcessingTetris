import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Created by dusti on 11/4/2016.
 */
public class PlayingState extends GameState {
    public static int MILLIS_PER_FALL = 500;

    private int[][] gameBoard;
    private long lastFallTime;
    IPiece iPiece;

    public PlayingState(TetrisGame pApplet) {
        super(pApplet);
        gameBoard = new int[TetrisGame.TETRIS_BOARD_HEIGHT][TetrisGame.TETRIS_BOARD_WIDTH];
        fillGameBoardWithZeros(gameBoard);
        iPiece = new IPiece(pApplet);
        lastFallTime = System.currentTimeMillis();
    }

    private void fillGameBoardWithZeros(int[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = 0;
            }
        }
    }

    @Override
    public void draw() {
        pApplet.clear();
        pApplet.pushMatrix();
        pApplet.scale(pApplet.width / TetrisGame.TETRIS_BOARD_WIDTH, pApplet.height / TetrisGame.TETRIS_BOARD_HEIGHT);
        renderBoard();
        iPiece.render();
        pApplet.popMatrix();
    }

    private void renderBoard() {
        pApplet.rectMode(PConstants.CENTER);
        for (int i = 0; i < TetrisGame.TETRIS_BOARD_HEIGHT; i++) {
            for (int j = 0; j < TetrisGame.TETRIS_BOARD_WIDTH; j++) {
                pApplet.stroke(gameBoard[i][j]);
                pApplet.rect(j, i, 0, 0);
            }
        }
    }

    public void tick() {
        if (System.currentTimeMillis() - lastFallTime >= MILLIS_PER_FALL) {
            if (iPiece.canFall(gameBoard)) {
                iPiece.fall();
            }
            lastFallTime = System.currentTimeMillis();
        }
    }

    public void keyPressed() {

    }
}
