package escape;

import escape.required.Coordinate;
import escape.required.EscapePiece.PieceName;
import escape.required.LocationType;


public class CoordinateImpl implements Coordinate {
  // Fields
  //**************************************
  private LocationType locationType;
  private String player;
  private PieceName pieceName;
  private int row;
  private int col;


  // Constructors
  //**************************************
  public CoordinateImpl(int col, int row) {
    this.col = col;
    this.row = row;
  }

  // Enums
  //**************************************
  private static enum CoordinateType {
    // Standard hex coordinates
    // The distance from (0,0)->(-1, 2) is 2; (-1, 2)->(2, -2) is 4.
    HEX,

    // Standard squares where distance is measure as shortest combination of
    // orthogonal and diagonal moves. Examples: (1,1)->(2,2) is distance 1,
    // (1,2)->(3,5) is distance 3
    SQUARE
  };

  // Methods
  //**************************************
  public int getRow() { return row; }

  public void setRow(int row) { this.row = row; }

  public int getColumn() { return col; }

  public void setColumn(int col) { this.col = col; }

  public boolean equals(CoordinateImpl coord) {
    if(this.row == coord.row && this.col == coord.col && this.locationType == coord.locationType) {
      return true;
    } else {
      return false;
    }
  }

  public int distanceTo(Coordinate c) {
    int deltaR = Math.abs(this.row - c.getRow());
    int deltaC = Math.abs(this.col - c.getColumn());

    return deltaR + deltaC;
  }

  public void setLocationType(LocationType locationType) { this.locationType = locationType; }

  public LocationType getLocationType() { return locationType; }

  public void setPlayer(String player) { this.player = player; }

  public String getPlayer() { return player; }

  public void setPieceName(PieceName pieceName) { this.pieceName = pieceName; }

  public PieceName getPieceName() { return pieceName; }

  @Override
  public String toString() {
    return "CoordinateImpl [Row=" + row + ", Col=" + col
        + ", locationType=" + locationType + "]";
  }
}
