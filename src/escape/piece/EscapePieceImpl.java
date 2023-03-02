package escape.piece;

import escape.required.EscapeException;
import escape.required.EscapePiece;

public class EscapePieceImpl implements EscapePiece {


  /**
   * @return the name
   */
  public PieceName getName()
  {
    throw new EscapeException("Not implemented");
  }

  /**
   * @return the owning player
   */
  public String getPlayer()
  {
    throw new EscapeException("Not implemented");
  }
}

