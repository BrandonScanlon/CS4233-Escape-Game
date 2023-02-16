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

  public int getRow() {
    return x;
  }

  public int getColumn() {
    return y;
  }

  public CoordinateType getType() {
    return type;
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    } else {
      return false;
    }
  }

  public int distanceTo(Coordinate c) {
    return 0;
  }
}
