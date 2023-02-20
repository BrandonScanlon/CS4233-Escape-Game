package escape.builder;

// Imports
//*********************************
import escape.*;
import escape.required.Coordinate;
import escape.required.EscapeException;
import escape.required.EscapePiece.PieceName;
import escape.required.LocationType;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameManagerTest {
  // Tests
  //*********************************

  /** Config 1 Tests **/
  //***************************************************************************************************************************
  @Test /** 1 **/
  void makeGameObject() {
    EscapeGameManager egm = null;
    try{
      egm = new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
  }
  //***************************************************************************************************************************
  @Test /** 2 **/
  void makeFullGameObject() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertEquals(2, egm.getColMax());
    assertEquals(2, egm.getRowMax());
    assertEquals(2, egm.getPlayers().length);
    assertEquals(Coordinate.CoordinateType.SQUARE, egm.getCoordinateType());
  }
  //***************************************************************************************************************************
  @Test /** 3 **/
  void makeTwoByTwoBoard() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    assertEquals(2, egm.getColMax());
    assertEquals(2, egm.getRowMax());
  }
  //***************************************************************************************************************************
  @Test /** 4 **/
  void makeTwoByTwoBoardFail() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    assertNotEquals(4, egm.getColMax());
    assertNotEquals(21, egm.getRowMax());
  }
  //***************************************************************************************************************************
  @Test /** 5 **/
  void checkCoordinateTypeSquare() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    assertEquals(Coordinate.CoordinateType.SQUARE, egm.getCoordinateType());
  }
  //***************************************************************************************************************************
  @Test /** 6 **/
  void checkCoordinateTypeSquareFail() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    assertNotEquals(Coordinate.CoordinateType.HEX, egm.getCoordinateType());
  }

  /** Config 2 Tests **/
  //***************************************************************************************************************************
  @Test /** 7 **/
  void makeGameObject2() {
    EscapeGameManager egm = null;
    try{
      egm = new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
  }
  //***************************************************************************************************************************
  @Test /** 8 **/
  void makeFullGameObject2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertEquals(100, egm.getColMax());
    assertEquals(345, egm.getRowMax());
    assertEquals(2, egm.getPlayers().length);
    assertEquals(Coordinate.CoordinateType.HEX, egm.getCoordinateType());
  }
  //***************************************************************************************************************************
  @Test /** 9 **/
  void makeTwoByTwoBoard2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    assertEquals(100, egm.getColMax());
    assertEquals(345, egm.getRowMax());
  }
  //***************************************************************************************************************************
  @Test /** 10 **/
  void makeTwoByTwoBoardFail2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    assertNotEquals(4, egm.getColMax());
    assertNotEquals(21, egm.getRowMax());
  }
  //***************************************************************************************************************************
  @Test /** 11 **/
  void checkCoordinateTypeSquare2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    assertEquals(Coordinate.CoordinateType.HEX, egm.getCoordinateType());
  }
  //***************************************************************************************************************************
  @Test /** 12 **/
  void checkCoordinateTypeHexFail2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    assertNotEquals(Coordinate.CoordinateType.SQUARE, egm.getCoordinateType());
  }

  /** Other Coordinate Tests **/
  //***************************************************************************************************************************
  @Test /** 13 **/
  void checkCoordinateCreation() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    Coordinate coord = null;
    try{
      coord = egm.makeCoordinate(1, 1);
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(coord);
  }
  //***************************************************************************************************************************
  @Test /** 14 **/
  void checkCoordinatesNotEqual() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    Coordinate coordA = null;
    Coordinate coordB = null;
    try{
      coordA = egm.makeCoordinate(0, 0);
      coordB = egm.makeCoordinate(1, 5);
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertFalse(coordA.equals(coordB));
  }
//
//  /** EscapeGameManager Method Exception Tests **/
//  //***********************************************************************************************
//  @Test /** 15 **/
//  void checkEGMMove() {
//    EscapeGameManagerImpl egm = null;
//    try{
//      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
//    } catch (Exception e){
//      fail("Exception from escape builder: " + e.getMessage());
//    }
//    assertNotNull(egm);
//    CoordinateImpl coordA = new CoordinateImpl(1, 4);
//    CoordinateImpl coordB = new CoordinateImpl(32, 11);
//
//    EscapeGameManagerImpl finalEgm = egm;
//    assertThrows(EscapeException.class, () -> {
//      finalEgm.move(coordA, coordB);
//    });
//  }
  //***************************************************************************************************************************
  @Test /** 16 **/
  void checkEGMGetPieceAt() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    CoordinateImpl coordA = new CoordinateImpl(1, 4);

    EscapeGameManagerImpl finalEgm = egm;
    assertThrows(EscapeException.class, () -> {
      finalEgm.getPieceAt(coordA);
    });
  }

  /** Game Board Tests **/
  //***************************************************************************************************************************
  @Test /** 17 **/
  void checkSQUAREBoardType() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    System.out.println(egm.getGameBoard().getGameBoardType());
    assertTrue(egm.getGameBoard().getGameBoardType() == Coordinate.CoordinateType.SQUARE);
  }
  //***************************************************************************************************************************
  @Test /** 18 **/
  void checkHEXBoardType() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    System.out.println(egm.getGameBoard().getGameBoardType());
    assertTrue(egm.getGameBoard().getGameBoardType() == Coordinate.CoordinateType.HEX);
  }
  //***************************************************************************************************************************
//  @Test /** 19 **/
//  void checkSQUAREBoardAllCLEAR() {
//    EscapeGameManagerImpl egm = null;
//    try{
//      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
//    } catch (Exception e){
//      fail("Exception from escape builder: " + e.getMessage());
//    }
//    assertNotNull(egm);
//
//    assertTrue(egm.getGameBoard().getGameBoardType() == Coordinate.CoordinateType.SQUARE);
//
//    System.out.println(egm.getGameBoard().getGameBoardType());
//    for(int row = 0; row < egm.getColMax(); row++){
//      for(int col = 0; col < egm.getRowMax(); col++){
//        //System.out.println(egm.getGameBoard().getBoardLocation(row, col).getLocationType());
//        assertTrue(egm.getGameBoard().getBoardLocation(row, col).getLocationType().equals(LocationType.CLEAR));
//      }
//    }
//  }
//  //***************************************************************************************************************************
//  @Test /** 20 **/
//  void checkHEXBoardAllCLEAR() {
//    EscapeGameManagerImpl egm = null;
//    try{
//      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
//    } catch (Exception e){
//      fail("Exception from escape builder: " + e.getMessage());
//    }
//    assertNotNull(egm);
//
//    assertTrue(egm.getGameBoard().getGameBoardType() == Coordinate.CoordinateType.HEX);
//
//    System.out.println(egm.getGameBoard().getGameBoardType());
//    for(int row = 0; row < egm.getColMax(); row++){
//      for(int col = 0; col < egm.getRowMax(); col++){
//        //System.out.println(egm.getGameBoard().getBoardLocation(row, col).locationType);
//        assertTrue(egm.getGameBoard().getBoardLocation(row, col).getLocationType().equals(LocationType.CLEAR));
//      }
//    }
//  }
  //***************************************************************************************************************************
  @Test /** 21 **/
  void checkSQUARECoordinateEquals() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertTrue(egm.getGameBoard().getGameBoardType() == Coordinate.CoordinateType.SQUARE);

    CoordinateImpl testCoordinate = new CoordinateImpl(1, 1);
    testCoordinate.setLocationType(LocationType.CLEAR);

    //System.out.println(egm.getGameBoard().getBoardLocation(1, 1).toString());
    //System.out.println(testCoordinate);

    assertTrue(egm.getGameBoard().getBoardLocation(1, 1).equals(testCoordinate));
  }
  //***************************************************************************************************************************
  @Test /** 22 **/
  void checkHEXCoordinateEquals() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertTrue(egm.getGameBoard().getGameBoardType() == Coordinate.CoordinateType.HEX);

    CoordinateImpl testCoordinate = egm.makeCoordinate(5, 5);
    testCoordinate.setLocationType(LocationType.CLEAR);

    //System.out.println(egm.getGameBoard().getBoardLocation(5, 5).toString());
    //System.out.println(testCoordinate);

    assertTrue(egm.getGameBoard().getBoardLocation(5, 5).equals(testCoordinate));
  }
  //***************************************************************************************************************************
  @Test /** 23 **/
  void checkSQUAREBoardPopulation() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config3.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertTrue(egm.getGameBoard().getGameBoardType() == Coordinate.CoordinateType.SQUARE);

    //System.out.println(egm.getGameBoard().getGameBoardType());
    egm.getGameBoard().printBoard();

    // (1, 1) CLEAR
    assertTrue(egm.getGameBoard().getBoardLocation(1, 1).getColumn() == 1);
    assertTrue(egm.getGameBoard().getBoardLocation(1, 1).getRow() == 1);
    assertTrue(egm.getGameBoard().getBoardLocation(1, 1).getLocationType().equals(LocationType.CLEAR));
    assertTrue(egm.getGameBoard().getBoardLocation(1, 1).getPlayer() == null);
    assertTrue(egm.getGameBoard().getBoardLocation(1, 1).getPieceName() == null);

    // (4, 4) clear Chris snail
    assertTrue(egm.getGameBoard().getBoardLocation(4, 4).getColumn() == 4);
    assertTrue(egm.getGameBoard().getBoardLocation(4, 4).getRow() == 4);
    assertTrue(egm.getGameBoard().getBoardLocation(4, 4).getLocationType().equals(LocationType.CLEAR));
    assertTrue(egm.getGameBoard().getBoardLocation(4, 4).getPlayer().equals("Chris"));
    assertTrue(egm.getGameBoard().getBoardLocation(4, 4).getPieceName() == PieceName.SNAIL);

    // (5, 12) exit
    assertTrue(egm.getGameBoard().getBoardLocation(5, 12).getColumn() == 5);
    assertTrue(egm.getGameBoard().getBoardLocation(5, 12).getRow() == 12);
    assertTrue(egm.getGameBoard().getBoardLocation(5, 12).getLocationType().equals(LocationType.EXIT));
    assertTrue(egm.getGameBoard().getBoardLocation(5, 12).getPlayer() == null);
    assertTrue(egm.getGameBoard().getBoardLocation(5, 12).getPieceName() == null);
  }
  //***************************************************************************************************************************
  @Test /** 24 **/
  void checkBoardInfinite() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config4.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertEquals(10000, egm.getGameBoard().getCols());
    assertEquals(10000, egm.getGameBoard().getRows());
  }

  /********************** INVALID MOVEMENT TESTS **********************/
  //***************************************************************************************************************************
  @Test /** 25 **/
  void checkSQUAREMoveNullFromCoordinate() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config3.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = null;
    CoordinateImpl coordB = egm.makeCoordinate(5, 5);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
  }
  //***************************************************************************************************************************
  @Test /** 26 **/
  void checkSQUAREMoveToSameCoordinate() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config3.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(5, 5);
    CoordinateImpl coordB = egm.makeCoordinate(5, 5);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
  }
  //***************************************************************************************************************************
  @Test /** 27 **/
  void checkSQUAREMovePieceWithNoPlayer() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config3.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(5, 5);
    CoordinateImpl coordB = egm.makeCoordinate(15, 15);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
  }
  //***************************************************************************************************************************
  @Test /** 28 **/
  void checkSQUAREMoveCoordinateOffBoard() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config3.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    CoordinateImpl coordA = egm.makeCoordinate(5, 5);
    CoordinateImpl coordB = egm.makeCoordinate(21, 21);

    GameStatusImpl status = new GameStatusImpl();
    status.setValidMove(false);

    assertEquals(status.isValidMove(), egm.move(coordA, coordB).isValidMove());
  }



  /********************** LINEAR MOVEMENT TESTS **********************/

  /********************** ONMI MOVEMENT TESTS **********************/


  //***************************************************************************************************************************
  @Test /**  **/
  void checkSQUAREMoveLINEAR() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertTrue(egm.getGameBoard().getGameBoardType() == Coordinate.CoordinateType.SQUARE);
  }
}