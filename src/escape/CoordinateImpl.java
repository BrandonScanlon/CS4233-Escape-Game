package escape;

import escape.required.Coordinate;

public class CoordinateImpl implements Coordinate {

private CoordinateType type;
private int x;
private int y;

  public CoordinateImpl(/**CoordinateType type,**/ int x, int y) {
    //this.type = type;
   this.x = (x == 0) ? 2147483647 : x;
   this.y = (y == 0) ? 2147483647 : y;
  }

  private static enum CoordinateType {
    // Standard hex coordinates
    // The distance from (0,0)->(-1, 2) is 2; (-1, 2)->(2, -2) is 4.
    HEX,

    // Standard squares where distance is measure as shortest combination of
    // orthogonal and diagonal moves. Examples: (1,1)->(2,2) is distance 1,
    // (1,2)->(3,5) is distance 3
    SQUARE
  };

  public int getRow() {
    return x;
  }

  public int getColumn() {
    return y;
  }

  public CoordinateType getType() {
    return type;
  }

  public boolean equals(Object o) { return (this == o); }

  public int distanceTo(Coordinate c) {
    return 0;
  }
}
