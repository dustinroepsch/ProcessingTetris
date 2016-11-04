import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Created by dusti on 11/4/2016.
 */
public class PlayingState extends GameState {
    public static int MILLIS_PER_FALL = 150;

    private int[][] gameBoard;
    private long lastFallTime;
    Tetronimo currentPiece;

    public PlayingState(TetrisGame pApplet) {
        super(pApplet);
        gameBoard = new int[TetrisGame.TETRIS_BOARD_HEIGHT][TetrisGame.TETRIS_BOARD_WIDTH];
        fillGameBoardWithZeros(gameBoard);
        currentPiece = getRandomTetronimo();
        lastFallTime = System.currentTimeMillis();
    }

    private Tetronimo getRandomTetronimo() {
        int selection = (int) (Math.random() * 3);
        switch (selection) {
            case 0:
                return new IPiece(pApplet);

            case 1:
                return new OPiece(pApplet);

            case 2:
                return new TPiece(pApplet);

        }
        return null;
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
        currentPiece.render();
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
            if (currentPiece.canFall(gameBoard)) {
                currentPiece.fall();
            } else {
                writePieceToBoard(currentPiece, gameBoard);
                currentPiece = getRandomTetronimo();
            }
            lastFallTime = System.currentTimeMillis();
        }
    }

    private void writePieceToBoard(Tetronimo currentPiece, int[][] gameBoard) {
        for (int row = 0; row < currentPiece.shape.length; row++) {
            for (int col = 0; col < currentPiece.shape[row].length; col++) {
                if (currentPiece.shape[row][col] != 0) {
                    gameBoard[currentPiece.y + row][currentPiece.x + col] = currentPiece.color;
                }
            }
        }
    }

    public void keyPressed() {
        int keyCode = pApplet.keyCode;
        int key = pApplet.key;
        if (keyCode == PConstants.LEFT) {
            if (currentPiece.canMoveLeft(gameBoard)) {
                currentPiece.moveLeft();
            }
        }
        if (keyCode == PConstants.RIGHT) {
            if (currentPiece.canMoveRight(gameBoard)) {
                currentPiece.moveRight();
            }
        }
        if (key == 'j') {
            if (currentPiece.canRotateLeft(gameBoard)) {
                currentPiece.rotateLeft();
            }
        }
    }
}
