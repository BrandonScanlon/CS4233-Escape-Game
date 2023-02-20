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
      SquareGameBoard squareGameBoard = new SquareGameBoard(this.colMax, this.rowMax, obstacleLocations, pieceTypeDescriptors);
      this.gameBoard = new GameBoardImpl(squareGameBoard);
    } else if(coordinateType == CoordinateType.HEX) {
      HexGameBoard hexGameBoard = new HexGameBoard(this.colMax, this.rowMax, obstacleLocations, pieceTypeDescriptors);
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

  public void setPlayers(String[] players) { this.players = players; }

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

  /******************** MOVE ********************/
  public GameStatus move(Coordinate from, Coordinate to) {
    GameStatusImpl gameStatus = new GameStatusImpl();
    GameBoardImpl gameBoard = this.getGameBoard();

    //System.out.println(pieceTypeDescriptors[0]);

    /******************** Check if valid move (immediate red flags) ********************/
    // Null Coordinates (Not sure if needed)
    if(from == null || to == null) {
      gameStatus.setValidMove(false);
      return gameStatus;
    }
    // Coordinates are the same
    else if(from.equals(to)) {
      gameStatus.setValidMove(false);
    }
    // There is no piece or player at the from Coordinate
    else if(gameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPieceName() == null ||
        gameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPlayer() == null) {
      gameStatus.setValidMove(false);
    }
    // Coordinate not on board
    else if(gameBoard.getBoardLocation(from.getRow(), from.getColumn()) == null) {
      gameStatus.setValidMove(false);
    }
    // Moving player does not have a piece on the 'from' coordinate
    else if(!gameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPlayer().equals(players[whosTurn])) {
      gameStatus.setValidMove(false);
    }
    // Otherwise, it's a valid move
    else {
      gameStatus.setValidMove(true);
    }

    /******************** If valid, make move, and check for collision and other validation ********************/
    if(gameStatus.isValidMove()) {
      GameBoardImpl tempGameBoard = gameBoard;
      CoordinateImpl newFrom = (CoordinateImpl)from;
      System.out.println(pieceTypeDescriptors);

      for(PieceTypeDescriptor descriptor : gameBoard.getPieceTypeDescriptors()) {
        // Check if from has an appropriate piece, then determine its capabilities
        if(tempGameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPieceName() == descriptor.getPieceName()) {
          if((newFrom.distanceTo(to) <= descriptor.getAttribute(PieceAttributeID.DISTANCE).getValue())) {
            int deltaRow = to.getRow() - from.getRow();
            int deltaCol = to.getColumn() - from.getColumn();
            // Determine movement pattern
            MovementPattern movementPattern = descriptor.getMovementPattern();
            switch(movementPattern) {
              case LINEAR:
                // Move only in a straight line
                while(deltaRow != 0 && deltaCol != 0) {
//                  /** Move Row **/
//                  if(deltaRow == deltaCol) {
//                    if(deltaRow > 0) { // Move Up
//                      //Set initial location to null
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      //Set new location to piece
//                      tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
//                      newFrom.setRow(newFrom.getRow() + 1);
//                      deltaRow--;
//                    }
//                    if(deltaRow < 0) { // Move Down
//                      //Set initial location to null
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      //Set new location to piece
//                      tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
//                      newFrom.setRow(newFrom.getRow() - 1);
//                      deltaRow++;
//                    }
//                  }
//                  /** Move Column **/
//                  if(deltaRow < deltaCol) {
//                    if(deltaRow > 0) { // Move Right
//                      //Set initial location to null
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      //Set new location to piece
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() + 1).setPlayer(players[whosTurn]);
//                      newFrom.setColumn(newFrom.getColumn() + 1);
//                      deltaRow--;
//                    }
//                    if(deltaRow < 0) { // Move Left
//                      //Set initial location to null
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      //Set new location to piece
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn() - 1).setPlayer(players[whosTurn]);
//                      newFrom.setColumn(newFrom.getColumn() - 1);
//                      deltaRow++;
//                    }
//                  }
//                  /** Move Row **/
//                  if(deltaRow > deltaCol) {
//                    if(deltaRow > 0) { // Move Up
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow() + 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
//                      newFrom.setRow(newFrom.getRow() + 1);
//                      deltaRow--;
//                    }
//                    if(deltaRow < 0) { // Move Down
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
//                      tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPieceName(descriptor.getPieceName());
//                      tempGameBoard.getBoardLocation(newFrom.getRow() - 1, newFrom.getColumn()).setPlayer(players[whosTurn]);
//                      newFrom.setRow(newFrom.getRow() - 1);
//                      deltaRow++;
//                    }
//                  }
                }
                break;
              case DIAGONAL:
                // Move in any diagonal direction
                break;
              case ORTHOGONAL:
                // Move in any direction, but not diagonally
                break;
              case OMNI:
                // Move in any direction
                break;
            }


//          // Move the piece
//          tempGameBoard.getBoardLocation(from.getRow(), from.getColumn()).setPieceName(null);
//          tempGameBoard.getBoardLocation(to.getRow(), to.getColumn()).setPieceName(pieceType.getPieceName());
//          tempGameBoard.getBoardLocation(to.getRow(), to.getColumn()).setPlayer(players[whosTurn]);
//          // Check for collision
//          if(tempGameBoard.getBoardLocation(to.getRow(), to.getColumn()).getPieceName() != null){
//            gameStatus.setMoveResult(GameStatusImpl.MoveResult.CAPTURE);
//            gameStatus.setCombatResult(GameStatusImpl.CombatResult.CAPTURE);
//            gameStatus.setWinner(players[whosTurn]);
//            return gameStatus;
//          }
          } else {
            gameStatus.setValidMove(false);
          }
        }

      }
      }


      // Check these
      gameStatus.setMoveResult(GameStatusImpl.MoveResult.NONE);
      gameStatus.setCombatResult(GameStatusImpl.CombatResult.NONE);

      /******************** Send back the reponse ********************/
      // Respond with appropriate Game Status
      if(!gameStatus.isValidMove()) {
        gameStatus.setMoveResult(GameStatusImpl.MoveResult.NONE);
        gameStatus.setCombatResult(GameStatusImpl.CombatResult.NONE);
        return gameStatus;
      } else {
        return gameStatus;
      }
    }

  /** Coordinate **/
  /**
   * Returns a coordinate of the appropriate type. If the coordinate cannot be
   * created, then null is returned and the status message is set appropriately.
   *
   * @param col the col component
   * @param row the row component
   * @return the coordinate or null if the coordinate cannot be implemented
   */
  @Override
  public CoordinateImpl makeCoordinate(int col, int row){
    try {
      Coordinate newCoordinate = new CoordinateImpl(col, row);
      return (CoordinateImpl)newCoordinate;
    } catch(Exception e) {
      System.out.println("Exception from escape builder: " + e.getMessage());
      return null;
    }
  }
}
