package escape;

// Imports
//**************************************
import escape.builder.LocationInitializer;
import escape.required.Coordinate;
import escape.required.Coordinate.CoordinateType;

public class EscapeGameManagerImpl<C extends Coordinate> implements EscapeGameManager<CoordinateImpl> {

  // Fields
  //**************************************
  private int xMax;
  private int yMax;
  private String[] players;
  private CoordinateType coordinateType;
  private LocationInitializer obstacleLocations[];
  private GameBoardImpl gameBoard;

  // Constructors
  //**************************************
  public EscapeGameManagerImpl(int xMax, int yMax, String[] players, CoordinateType coordinateType, LocationInitializer obstacleLocations[]) {
    this.xMax = xMax;
    this.yMax = yMax;
    this.players = players;
    this.coordinateType = coordinateType;
    this.obstacleLocations = obstacleLocations;

    if(coordinateType == CoordinateType.SQUARE) {
      SquareGameBoard squareGameBoard = new SquareGameBoard(xMax, yMax, obstacleLocations);
      this.gameBoard = new GameBoardImpl(squareGameBoard);
    } else if(coordinateType == CoordinateType.HEX){
      HexGameBoard hexGameBoard = new HexGameBoard(xMax, yMax, obstacleLocations);
      this.gameBoard = new GameBoardImpl(hexGameBoard);
    }
  }

  // Methods
  //**************************************
  /** Setters **/
  public void setCoordinateType(CoordinateType CoordinateType) { this.coordinateType = CoordinateType; }

  public void setxMax(int xMax) { this.xMax = xMax; }

  public void setyMax(int yMax) { this.yMax = yMax; }

  public void setPlayers(String[] players){
    this.players = players;
  }

  public void setLocationInitializers() {
    // TODO Auto-generated method stub
  }

  /** Getters **/
  public CoordinateType getCoordinateType() { return coordinateType; }

  public int getxMax() { return xMax; }

  public int getyMax() { return yMax; }

  public String[] getPlayers(){ return players; }

  public GameBoardImpl getGameBoard() { return gameBoard; }

  public void getLocation() {
    // TODO Auto-generated method stub
  }

  /** Coordinate **/
  /**
   * Returns a coordinate of the appropriate type. If the coordinate cannot be
   * created, then null is returned and the status message is set appropriately.
   *
   * @param x the x component
   * @param y the y component
   * @return the coordinate or null if the coordinate cannot be implemented
   */
  @Override
  public CoordinateImpl makeCoordinate(int x, int y) {
    try{
      Coordinate newCoordinate = new CoordinateImpl(x, y);
      return (CoordinateImpl)newCoordinate;
    } catch(Exception e){
      System.out.println("Exception from escape builder: " + e.getMessage());
      return null;
    }
  }
}
