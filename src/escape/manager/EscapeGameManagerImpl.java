package escape.manager;

// Imports
//**************************************
import escape.coordinate.CoordinateImpl;
import escape.utils.GameStatusImpl;
import escape.board.GameBoardImpl;
import escape.board.HexGameBoard;
import escape.board.Move;
import escape.board.SquareGameBoard;
import escape.builder.LocationInitializer;
import escape.builder.PieceTypeDescriptor;
import escape.builder.RuleDescriptor;
import escape.piece.EscapePieceImpl;
import escape.required.*;
import escape.required.Coordinate.CoordinateType;
import escape.required.EscapePiece.MovementPattern;
import escape.required.EscapePiece.PieceAttributeID;
import escape.required.EscapePiece.PieceName;

public class EscapeGameManagerImpl<C extends Coordinate> implements EscapeGameManager {

  // Fields
  //**************************************
  private int colMax;
  private int rowMax;
  private String[] players;
  private CoordinateType coordinateType;
  private GameBoardImpl gameBoard;
  private PieceTypeDescriptor[] pieceTypeDescriptors;
  private RuleDescriptor[] ruleDescriptors;
  private int whosTurn = 1;
  private int maxDistance = 0;
  private CoordinateImpl startingCoord;
  private int p1Turns = 0;
  private int p2Turns = 0;
  private int p1Score = 0;
  private int p2Score = 0;
  private boolean stopGame = false;

  // Constructors
  //**************************************
  public EscapeGameManagerImpl(int xMax, int yMax, String[] players, CoordinateType coordinateType, LocationInitializer obstacleLocations[], PieceTypeDescriptor[] pieceTypeDescriptors, RuleDescriptor[] ruleDescriptors) throws EscapeException {
    this.rowMax = yMax;
    this.colMax = xMax;
    this.players = players;
    this.coordinateType = coordinateType;
    this.pieceTypeDescriptors = pieceTypeDescriptors;
    this.ruleDescriptors = ruleDescriptors;

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
  public GameStatus move(CoordinateImpl from, CoordinateImpl to) {
    GameStatusImpl gameStatus = new GameStatusImpl();
    GameBoardImpl gameBoard = this.getGameBoard();
    startingCoord = from;
    final CoordinateImpl initialFrom = new CoordinateImpl(from.getRow(), from.getColumn());
    CoordinateImpl newFrom = from;

    if(stopGame){
      System.exit(0);
    }

    if(whosTurn == 1) {
      whosTurn = 0;
    } else {
      whosTurn = 1;
    }
    gameStatus.setValidMove(true);
    /******************** Check if valid move (immediate red flags) ********************/
    // Null Coordinates (Not sure if needed)
    if(from == null || to == null) {
      gameStatus.setValidMove(false);
    }
    // Coordinates are the same
    else if(from.getRow() == to.getRow() && from.getColumn() == to.getColumn()) {
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
    boolean EXIT = false;
    boolean BLOCK = false;
    System.out.println(gameBoard.getBoardLocation(to.getRow(), to.getColumn()).getLocationType());
    System.out.println(gameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPieceName());
    if((gameBoard.getBoardLocation(to.getRow(), to.getColumn()).getLocationType() == LocationType.EXIT) && (gameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPieceName() == PieceName.BIRD)){
      EXIT = true;
    } else if (gameBoard.getBoardLocation(to.getRow(), to.getColumn()).getLocationType() == LocationType.EXIT && (gameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPieceName() != PieceName.BIRD)) {
      gameStatus.setValidMove(false);
    } else if (gameBoard.getBoardLocation(to.getRow(), to.getColumn()).getLocationType() == LocationType.BLOCK) {
      BLOCK = true;
      gameStatus.setValidMove(false);
    }
    // Otherwise, it's a valid move
    else if(gameStatus.isValidMove()){
      gameStatus.setValidMove(true);
    }
    /******************** If valid, make move, and check for collision and other validation ********************/
    if(gameStatus.isValidMove()) {
      GameBoardImpl tempGameBoard = gameBoard;
      MovementPattern movementPattern = null;
      int deltaRow = to.getRow() - from.getRow();
      int deltaCol = to.getColumn() - from.getColumn();
      int distance = 0;
      PieceTypeDescriptor descriptor = null;

      for(PieceTypeDescriptor desc : pieceTypeDescriptors) {
        // Check if from has an appropriate piece, then determine its capabilities
        if(tempGameBoard.getBoardLocation(from.getRow(), from.getColumn()).getPieceName() == desc.getPieceName()) {
          // Determine movement pattern
          movementPattern = desc.getMovementPattern();
          maxDistance = desc.getAttribute(PieceAttributeID.DISTANCE).getValue();
          descriptor = desc;
        }
      }
      int TURNLIMIT = 10000;
      int SCORE = 1;
      for(RuleDescriptor rules : ruleDescriptors) {
        if(rules.ruleId == Rule.RuleID.SCORE){
          SCORE = rules.ruleValue;
        }
        if(rules.ruleId == Rule.RuleID.TURN_LIMIT){
          TURNLIMIT = rules.ruleValue;
        }
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
      }
      /******************** Send back the response ********************/
      if(!gameStatus.isValidMove()) {
        gameStatus.setMoveResult(GameStatusImpl.MoveResult.NONE);
        gameStatus.setCombatResult(GameStatusImpl.CombatResult.NONE);
        gameStatus.setMoveResult(GameStatusImpl.MoveResult.LOSE);
        stopGame = true;
        return gameStatus;
      } else {
        if(whosTurn == 0){
          p1Turns++;
        } else {
          p2Turns++;
        }
        if(EXIT){
          if(whosTurn == 0){
            p1Score++;
          } else {
            p2Score++;
          }
          gameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPieceName(null);
          gameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setPlayer(null);
          gameBoard.getBoardLocation(newFrom.getRow(), newFrom.getColumn()).setLocationType(LocationType.EXIT);
        }
        gameBoard.getBoardLocation(initialFrom.getRow(), initialFrom.getColumn()).setPieceName(null);
        gameBoard.getBoardLocation(initialFrom.getRow(), initialFrom.getColumn()).setPlayer(null);
        gameBoard.getBoardLocation(initialFrom.getRow(), initialFrom.getColumn()).setLocationType(LocationType.CLEAR);
        System.out.println("Turns: " + p1Turns + ", " + p2Turns);
        System.out.println("Scores: " + p1Score + ", " + p2Score);

        // No Moves Left
        if(p1Turns >= TURNLIMIT && p2Turns >= TURNLIMIT) {
          if(p1Score > p2Score) {
            if(whosTurn == 0) {
              gameStatus.setMoveResult(GameStatusImpl.MoveResult.WIN);
            } else {
              gameStatus.setMoveResult(GameStatusImpl.MoveResult.LOSE);
            }
          } else if(p2Score > p1Score) {
            if(whosTurn == 0) {
              gameStatus.setMoveResult(GameStatusImpl.MoveResult.LOSE);
            } else {
              gameStatus.setMoveResult(GameStatusImpl.MoveResult.WIN);
            }
          } else {
            gameStatus.setMoveResult(GameStatusImpl.MoveResult.DRAW);
          }
        }
        return gameStatus;
      }
    } else {
      if(!gameStatus.isValidMove()) {
        gameStatus.setMoveResult(GameStatusImpl.MoveResult.NONE);
        gameStatus.setCombatResult(GameStatusImpl.CombatResult.NONE);
        gameStatus.setMoveResult(GameStatusImpl.MoveResult.LOSE);
        stopGame = true;
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
