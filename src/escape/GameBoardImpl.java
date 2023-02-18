package escape;

// Imports
//**************************************
import escape.builder.LocationInitializer;
import escape.required.Coordinate.CoordinateType;
import escape.required.EscapeException;

public class GameBoardImpl {
  private GameBoard gameBoard;

  public GameBoardImpl(GameBoard gameBoard) {
    this.gameBoard = gameBoard;
  }

  public void setBoardLocation(int row, int col, LocationInitializer locationInitializer) { gameBoard.setBoardLocation(row, col, locationInitializer); }

  public LocationInitializer getBoardLocation(int row, int col) { return gameBoard.getBoardLocation(row, col); }

  public CoordinateType getGameBoardType() { return gameBoard.getGameBoardType(); }
}
