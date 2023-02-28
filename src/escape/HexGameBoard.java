package escape;

import escape.builder.LocationInitializer;
import escape.builder.PieceTypeDescriptor;
import escape.required.Coordinate.CoordinateType;
import escape.required.LocationType;
import org.stringtemplate.v4.misc.Coordinate;

public class HexGameBoard implements GameBoard {
  // Global Variables
  //******************************************************************
  private GameBoard gameBoard;
  private CoordinateType gameBoardType = CoordinateType.HEX;
  private int rows;
  private int cols;
  private LocationInitializer locationInitializer;
  private LocationInitializer obstacleLocations[];
  private CoordinateImpl[][] board;
  private PieceTypeDescriptor[] pieceTypeDescriptors;

  // Constructors
  //******************************************************************

  public HexGameBoard(int cols, int rows, LocationInitializer obstacleLocations[], PieceTypeDescriptor[] pieceTypeDescriptors) {
    this.rows = (rows == 0) ? 2147483647 : rows;
    this.cols = (cols == 0) ? 2147483647 : cols;
    this.obstacleLocations = obstacleLocations;
    this.pieceTypeDescriptors = pieceTypeDescriptors;

    // Create game board
    board = new CoordinateImpl[rows][cols];

    // Set all locations on the game board to CLEAR to start
    for(int row = 1; row < rows; row++) {
      for(int col = 1; col < cols; col++) {
        board[col][row] = new CoordinateImpl(row, col);
        board[col][row].setLocationType(LocationType.CLEAR);
        board[col][row].setPlayer(null);
        board[col][row].setPieceName(null);
      }
    }
    for(LocationInitializer obstacle : obstacleLocations) {
      //System.out.println("Obstacle found at: " + obstacle.x + ", " + obstacle.y);
      board[obstacle.x][obstacle.y] = new CoordinateImpl(obstacle.x, obstacle.y);
      board[obstacle.x][obstacle.y].setLocationType(obstacle.locationType);
      board[obstacle.x][obstacle.y].setPlayer(obstacle.player);
      board[obstacle.x][obstacle.y].setPieceName(obstacle.pieceName);
    }
  }

  // Methods
  //******************************************************************
  public void setBoardLocation(int row, int col, LocationInitializer locationInitializer) {
    board[col][row].setLocationType(locationInitializer.locationType);
  }

  public CoordinateImpl getBoardLocation(int row, int col) {
    return board[row][col];
  }

  public CoordinateType getGameBoardType() { return gameBoardType; }

  public PieceTypeDescriptor[] getPieceTypeDescriptors() { return pieceTypeDescriptors; }

  public int getRows() { return this.rows; }

  public int getCols() { return this.cols; }

  public void printBoard() {
    System.out.println("******** Printing Board ********");

    for(int col = 1; col < cols; col++) {
      for(int row = 1; row < rows; row++) {
        System.out.print("(");
        System.out.print(this.board[col][row].getRow() + ", ");
        System.out.print(this.board[col][row].getColumn() + ") ");
        System.out.print(this.board[col][row].getLocationType() + " ");
        System.out.print(this.board[col][row].getPlayer() + " ");
        System.out.println(this.board[col][row].getPieceName());
      }
    }
  }
}