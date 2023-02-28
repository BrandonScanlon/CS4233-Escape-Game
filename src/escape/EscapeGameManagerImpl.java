package escape;

// Imports
//**************************************

import escape.builder.LocationInitializer;
import escape.builder.PieceTypeDescriptor;
import escape.required.*;
import escape.required.Coordinate.CoordinateType;
import escape.required.EscapePiece.MovementPattern;
import escape.required.EscapePiece.PieceAttributeID;

public class EscapeGameManagerImpl<C extends Coordinate> implements EscapeGameManager {

  // Fields
  //**************************************
  private int colMax;
  private int rowMax;
  private String[] players;
  private CoordinateType coordinateType;
  private LocationInitializer obstacleLocations[];
  private GameBoardImpl gameBoard;
  private PieceTypeDescriptor[] pieceTypeDescriptors;
  private int whosTurn = 0;
  private int maxDistance = 0;
  private CoordinateImpl startingCoord;

  // Constructors
  //**************************************
  public EscapeGameManagerImpl(int xMax, int yMax, String[] players, CoordinateType coordinateType, LocationInitializer obstacleLocations[], PieceTypeDescriptor[] pieceTypeDescriptors) throws EscapeException {
    this.rowMax = yMax;
    this.colMax = xMax;
    this.players = players;
    this.coordinateType = coordinateType;
    this.obstacleLocations = obstacleLocations;
    this.pieceTypeDescriptors = pieceTypeDescriptors;

    if(coordinateType == CoordinateType.SQUARE) {
      SquareGameBoard squareGameBoard = new SquareGameBoard(this.rowMax, this.colMax, obstacleLocations, pieceTypeDescriptors);
      this.gameBoard = new GameBoardImpl(squareGameBoard);
    } else if(coordinateType == CoordinateType.HEX) {
      HexGameBoard hexGameBoard = new HexGameBoard(this.rowMax, this.colMax, obstacleLocations, pieceTypeDescriptors);
      this.gameBoard = new GameBoardImpl(hexGameBoard);
    }
  }

  // Methods
  //**************************************

  /**
   * Setters
   **/
  public void setCoordinateType(CoordinateType CoordinateType) {
    this.coordinateType = CoordinateType;
  }

  public void setColMax(int colMax) {
    this.colMax = colMax;
  }

  public void setrowMax(int rowMax) {
    this.rowMax = rowMax;
  }

  public void setPlayers(String[] players) {
    this.players = players;
  }

  /**
   * Getters
   **/
  public CoordinateType getCoordinateType() {
    return coordinateType;
  }

  public int getColMax() {
    return colMax;
  }

  public int getRowMax() {
    return rowMax;
  }

  public String[] getPlayers() {
    return players;
  }

  public GameBoardImpl getGameBoard() {
    return gameBoard;
  }

  public EscapePieceImpl getPieceAt(CoordinateImpl coordinate) { return null; }


  /******************** MOVE ********************/
  public GameStatus move(Coordinate from, Coordinate to) {
    GameStatusImpl gameStatus = new GameStatusImpl();
    GameBoardImpl gameBoard = this.getGameBoard();
    startingCoord = (CoordinateImpl)from;

    /******************** Check if valid move (immediate red flags) ********************/
    // Null Coordinates (Not sure if needed)
    if(from == null || to == null) {
      gameStatus.setValidMove(false);
      return gameStatus;
    }
    // Coordinates are the same
    else if(from.equals(to)) {
      gameStatus.setValidMove(false);
      return gameStatus;
    }
    // There is no piece or player at the from Coordinate
    else if(gameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPieceName() == null ||
        gameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPlayer() == null) {
      gameStatus.setValidMove(false);
      return gameStatus;
    }
    // Coordinate not on board
    else if(gameBoard.getBoardLocation(from.getRow(), from.getColumn()) == null) {
      gameStatus.setValidMove(false);
      return gameStatus;
    }
    // Moving player does not have a piece on the 'from' coordinate
    else if(!gameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPlayer().equals(players[whosTurn])) {
      gameStatus.setValidMove(false);
      return gameStatus;
    }
    // Otherwise, it's a valid move
    else {
      gameStatus.setValidMove(true);
    }

    /******************** If valid, make move, and check for collision and other validation ********************/
    if(gameStatus.isValidMove()) {
      GameBoardImpl tempGameBoard = gameBoard;
      CoordinateImpl newFrom = (CoordinateImpl)from;
      for(PieceTypeDescriptor descriptor : gameBoard.getPieceTypeDescriptors()) {
        // Check if from has an appropriate piece, then determine its capabilities
        if(tempGameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPieceName() == descriptor.getPieceName()) {
          // Determine movement pattern
          MovementPattern movementPattern = descriptor.getMovementPattern();
          int deltaRow = to.getRow() - from.getRow();
          int deltaCol = to.getColumn() - from.getColumn();
          int distance = 0;

          maxDistance = descriptor.getAttribute(PieceAttributeID.DISTANCE).getValue();

          if(tempGameBoard.getBoardLocation(to.getRow(), to.getColumn()).getLocationType() == LocationType.EXIT){
            gameStatus.setValidMove(false);
            return gameStatus;
          } else if (tempGameBoard.getBoardLocation(to.getRow(), to.getColumn()).getLocationType() == LocationType.BLOCK) {
            gameStatus.setValidMove(false);
            return gameStatus;
          }

          if((deltaRow == deltaCol || Math.abs(deltaRow) == Math.abs(deltaCol)) && (movementPattern == MovementPattern.LINEAR || movementPattern == MovementPattern.DIAGONAL || movementPattern == MovementPattern.OMNI)) {
            distance = deltaRow;
          }
          Move move = new Move(gameStatus, movementPattern, descriptor, players, whosTurn, tempGameBoard, newFrom, deltaCol, deltaRow, maxDistance);
          if(distance == 0 && newFrom.distanceTo(to) <= maxDistance) {
            gameStatus = move.movePiece();

          } else if(distance == deltaRow && Math.abs(distance) <= maxDistance) {
            gameStatus = move.movePiece();
          } else {
            gameStatus.setValidMove(false);
            return gameStatus;
          }
        }
      }
        /******************** Send back the response ********************/
        if(!gameStatus.isValidMove()) {
          gameStatus.setMoveResult(GameStatusImpl.MoveResult.NONE);
          gameStatus.setCombatResult(GameStatusImpl.CombatResult.NONE);
          newFrom = startingCoord;
          return gameStatus;
        } else {
          return gameStatus;
        }
    }
    return gameStatus;
  }

  /**
   * Returns a coordinate of the appropriate type. If the coordinate cannot be
   * created, then null is returned and the status message is set appropriately.
   *
   * @param col the col component
   * @param row the row component
   * @return the coordinate or null if the coordinate cannot be implemented
   */
  @Override
  public CoordinateImpl makeCoordinate(int row, int col){
    try {
      Coordinate newCoordinate = new CoordinateImpl(row, col);
      return (CoordinateImpl)newCoordinate;
    } catch(Exception e) {
      System.out.println("Exception from escape builder: " + e.getMessage());
      return null;
    }
  }
}
