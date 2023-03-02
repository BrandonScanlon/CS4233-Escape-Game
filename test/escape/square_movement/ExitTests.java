package escape.square_movement;

import escape.coordinate.CoordinateImpl;
import escape.manager.EscapeGameManagerImpl;
import escape.utils.GameStatusImpl;
import escape.builder.EscapeGameBuilder;
import escape.required.EscapePiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExitTests {

//***************************************************************************************************************************
  @Test
  /** 121 **/
  void checkMoveOrthogonalExit() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Exit Configurations/ExitTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(3, 12);
    coordA.setPieceName(EscapePiece.PieceName.SNAIL);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(5, 12);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(3, 12);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }
//***************************************************************************************************************************
  @Test
  /** 122 **/
  void checkMoveLinearExit() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Exit Configurations/ExitTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(5, 16);
    coordA.setPieceName(EscapePiece.PieceName.BIRD);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(5, 12);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(true);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(coordB.getRow(), coordA.getRow());
    assertEquals(coordB.getColumn(), coordA.getColumn());
  }
//***************************************************************************************************************************
  @Test
  /** 123 **/
  void checkMoveOMNIExit() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Exit Configurations/ExitTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(7, 13);
    coordA.setPieceName(EscapePiece.PieceName.FROG);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(5, 12);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(7, 13);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }
//***************************************************************************************************************************
  @Test
  /** 124 **/
  void checkMoveDiagonalExit() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Exit Configurations/ExitTests.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(1, 8);
    coordA.setPieceName(EscapePiece.PieceName.HORSE);
    coordA.setPlayer("Chris");
    CoordinateImpl coordB = egm.makeCoordinate(5, 12);
    coordB.setPieceName(null);
    coordB.setPlayer(null);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    CoordinateImpl startingCoord = egm.makeCoordinate(1, 8);
    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(startingCoord.getRow(), coordA.getRow());
    assertEquals(startingCoord.getColumn(), coordA.getColumn());
  }
}
