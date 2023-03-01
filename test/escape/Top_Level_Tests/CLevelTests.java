package escape.Top_Level_Tests;

// Imports
//*********************************
import escape.*;
import escape.Builder.EscapeGameBuilder;
import escape.required.EscapePiece.PieceName;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CLevelTests {
                          /** Boards can be infinite or finite on either or both axes **/
//***************************************************************************************************************************
  @Test
  /** **/
  void checkSQUAREXYFinite() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/C Level Configurations/SQUAREXYFinite.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertEquals(egm.getGameBoard().getCols(), 14);
    assertEquals(egm.getGameBoard().getRows(), 24);
  }
//***************************************************************************************************************************
  @Test
  /** **/
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
    assertEquals(24, egm.getGameBoard().getRows());
  }
//***************************************************************************************************************************
  @Test
  /** **/
  void checkSQUAREXInfiniteYFinite() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/C Level Configurations/SQUAREXInfiniteYFinite.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertEquals(50, egm.getGameBoard().getCols());
    assertEquals(10000, egm.getGameBoard().getRows());
  }
//***************************************************************************************************************************
  @Test
  /** **/
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

                                  /** All pieces have a default value of 1 **/
//***************************************************************************************************************************
  @Test
  /** **/
  void checkPieceDefault1() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/C Level Configurations/SQUAREXYFinite.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coord = new CoordinateImpl(4, 4);

    egm.getGameBoard().getPieceTypeDescriptors();
    assertNull(egm.getPieceAt(coord));

  }
                              /** Distance Attribute Implemented **/
  //***************************************************************************************************************************
  @Test
  /** **/
  void checkPieceDistanceAttribute() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/C Level Configurations/SQUAREXYFinite.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = new CoordinateImpl(4, 4);
    CoordinateImpl coordB = new CoordinateImpl(3, 4);
    CoordinateImpl coordC = new CoordinateImpl(2, 2);

    GameStatusImpl gameStatus = new GameStatusImpl();


    PieceName pieceName = egm.getGameBoard().getBoardLocation(coordA.getRow(), coordA.getColumn()).getPieceName();
    assertEquals(pieceName, PieceName.SNAIL);

    assertFalse(gameStatus.isValidMove());

    assertEquals(egm.move(coordA, coordB).isValidMove(), gameStatus.isValidMove());
    assertEquals(egm.move(coordA, coordC).isValidMove(), gameStatus.isValidMove());

    CoordinateImpl coordD = new CoordinateImpl(5, 5);
    CoordinateImpl coordE = new CoordinateImpl(5, 11);
    CoordinateImpl coordF = new CoordinateImpl(6, 20);

    PieceName pieceName2 = egm.getGameBoard().getBoardLocation(coordD.getRow(), coordD.getColumn()).getPieceName();
    assertEquals(pieceName2, PieceName.DOG);

    assertFalse(gameStatus.isValidMove());

    assertEquals(egm.move(coordD, coordE).isValidMove(), gameStatus.isValidMove());
    assertEquals(egm.move(coordD, coordF).isValidMove(), gameStatus.isValidMove());
  }

  /** A move can't go over a piece or exit **/
  //***************************************************************************************************************************
  @Test
  /** **/
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

    PieceName pieceName = egm.getGameBoard().getBoardLocation(coordA.getRow(), coordA.getColumn()).getPieceName();
    assertEquals(pieceName, PieceName.DOG);

    assertFalse(gameStatus.isValidMove());

    assertEquals(egm.move(coordA, coordB).isValidMove(), gameStatus.isValidMove());
    assertEquals(egm.move(coordA, coordC).isValidMove(), !gameStatus.isValidMove());
  }

}
