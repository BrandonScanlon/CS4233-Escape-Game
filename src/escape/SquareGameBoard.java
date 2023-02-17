package escape;

import escape.builder.LocationInitializer;
import escape.required.LocationType;

public class SquareGameBoard implements GameBoard{
  // Global Variables
  //******************************************************************
  private int rows;
  private int cols;
  private LocationInitializer locationInitializer;
  private LocationInitializer obstacleLocations[];
  private LocationInitializer[][] board;

  // Constructors
  //******************************************************************

  public SquareGameBoard(int rows, int cols, LocationInitializer obstacleLocations[]) {
    this.rows = rows;
    this.cols = cols;
    this.obstacleLocations = obstacleLocations;

    // Create game board
    board = new LocationInitializer[rows][cols];

    // Set all locations on the game board to CLEAR to start
    for(int row = 0; row < rows; row++) {
      for(int col = 0; col < cols; col++) {

        board[row][col] = locationInitializer = new LocationInitializer(row, col, LocationType.CLEAR, null, null);
        System.out.println(board[row][col]);
      }
    }
  }

  // Methods
  //******************************************************************

  public void setBoardLocation(int row, int col, LocationInitializer locationInitializer) {
    board[row][col] = locationInitializer;
  }

  public LocationInitializer getBoardLocation(int row, int col) {
    return board[row][col];
  }



}
