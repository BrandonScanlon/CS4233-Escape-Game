package escape.top_level_tests;

// Imports
//*********************************
import escape.builder.EscapeGameBuilder;
import escape.coordinate.CoordinateImpl;
import escape.manager.EscapeGameManagerImpl;
import escape.required.EscapePiece.PieceName;
import escape.utils.GameStatusImpl;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CLevelTests {
                          /** Boards can be infinite or finite on either or both axes **/
//***************************************************************************************************************************
  @Test
  /** 138 **/
  void checkSQUAREXYFinite() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/C Level Configurations/SQUAREXYFinite.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertEquals(25, egm.getGameBoard().getRows());
    assertEquals(15, egm.getGameBoard().getCols());
  }
//***************************************************************************************************************************
  @Test
  /** 139 **/
  void checkSQUAREXFiniteYInfinite() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/C Level Configurations/SQUAREXFiniteYInfinite.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertEquals(10000, egm.getGameBoard().getCols());
    assertEquals(25, egm.getGameBoard().getRows());
  }
//***************************************************************************************************************************
  @Test
  /** 140 **/
  void checkSQUAREXInfiniteYFinite() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/C Level Configurations/SQUAREXInfiniteYFinite.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertEquals(51, egm.getGameBoard().getCols());
    assertEquals(10000, egm.getGameBoard().getRows());
  }
//***************************************************************************************************************************
  @Test
  /** 141 **/
  void checkSQUAREXInfiniteYInfinite() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/C Level Configurations/SQUAREXYInfinite.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertEquals(10000, egm.getGameBoard().getCols());
    assertEquals(10000, egm.getGameBoard().getRows());
  }
                              /** Distance Attribute Implemented **/
  //***************************************************************************************************************************
  @Test
  /** 142 **/
  void checkPieceDistanceAttribute() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/C Level Configurations/SQUAREXYFinite.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = new CoordinateImpl(4, 4);
    CoordinateImpl coordB = new CoordinateImpl(4, 5);
    CoordinateImpl coordC = new CoordinateImpl(4, 6);

    GameStatusImpl gameStatus = new GameStatusImpl();
    gameStatus.setValidMove(true);

    PieceName pieceName = egm.getGameBoard().getBoardLocation(coordA.getRow(), coordA.getColumn()).getPieceName();
    assertEquals(pieceName, PieceName.SNAIL);

    assertTrue(gameStatus.isValidMove());

    assertEquals(gameStatus.isValidMove(), egm.move(coordA, coordB).isValidMove());
    assertEquals(!gameStatus.isValidMove(), egm.move(coordA, coordC).isValidMove());
  }

  /** A move can't go over a piece or exit **/
  //***************************************************************************************************************************
  @Test
  /** 143 **/
  void checkForPieceObstruction() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/C Level Configurations/SQUAREXYFinite.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = new CoordinateImpl(5, 5);
    CoordinateImpl coordB = new CoordinateImpl(3, 3);
    CoordinateImpl coordC = new CoordinateImpl(5, 3);

    GameStatusImpl gameStatus = new GameStatusImpl();
    gameStatus.setValidMove(true);

    PieceName pieceName = egm.getGameBoard().getBoardLocation(coordA.getRow(), coordA.getColumn()).getPieceName();
    assertEquals(pieceName, PieceName.DOG);

    assertTrue(gameStatus.isValidMove());

    assertEquals(egm.move(coordA, coordC).isValidMove(), gameStatus.isValidMove());
    assertEquals(egm.move(coordA, coordB).isValidMove(), !gameStatus.isValidMove());
  }

}
