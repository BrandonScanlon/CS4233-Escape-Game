package escape.builder;

// Imports
//*********************************
import escape.*;
import escape.required.Coordinate;
import escape.required.EscapeException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EscapeGameManagerTest {

  /** Config 1 Tests **/
  //******************************************************************
  @Test /** 1 **/
  void makeGameObject() {
    EscapeGameManager egm = null;
    try{
      egm = new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
  }
  //------------------------------------------------------------------
  @Test /** 2 **/
  void makeFullGameObject() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertEquals(2, egm.getxMax());
    assertEquals(2, egm.getyMax());
    assertEquals(2, egm.getPlayers().length);
    assertEquals(Coordinate.CoordinateType.SQUARE, egm.getCoordinateType());
  }
  //------------------------------------------------------------------
  @Test /** 3 **/
  void makeTwoByTwoBoard() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    assertEquals(2, egm.getxMax());
    assertEquals(2, egm.getyMax());
  }
  //------------------------------------------------------------------
  @Test /** 4 **/
  void makeTwoByTwoBoardFail() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    assertNotEquals(4, egm.getxMax());
    assertNotEquals(21, egm.getyMax());
  }
  //------------------------------------------------------------------
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
  //------------------------------------------------------------------
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
  //***********************************************************************************************
  @Test /** 7 **/
  void makeGameObject2() {
    EscapeGameManager egm = null;
    try{
      egm = new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
  }
  //------------------------------------------------------------------
  @Test /** 8 **/
  void makeFullGameObject2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    assertEquals(10000000, egm.getxMax());
    assertEquals(34532215, egm.getyMax());
    assertEquals(2, egm.getPlayers().length);
    assertEquals(Coordinate.CoordinateType.HEX, egm.getCoordinateType());
  }
  //------------------------------------------------------------------
  @Test /** 9 **/
  void makeTwoByTwoBoard2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    assertEquals(10000000, egm.getxMax());
    assertEquals(34532215, egm.getyMax());
  }
  //------------------------------------------------------------------
  @Test /** 10 **/
  void makeTwoByTwoBoardFail2() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    assertNotEquals(4, egm.getxMax());
    assertNotEquals(21, egm.getyMax());
  }
  //------------------------------------------------------------------
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
  //------------------------------------------------------------------
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
  //***********************************************************************************************
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
  //------------------------------------------------------------------
  @Test /** 14 **/
  void checkCoordinateCreationInfinite() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    Coordinate coord = null;
    try{
      coord = egm.makeCoordinate(0, 0);
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertEquals(2147483647, coord.getColumn());
    assertEquals(2147483647, coord.getRow());
  }

  /** EscapeGameManager Method Exception Tests **/
  //***********************************************************************************************
  @Test /** 15 **/
  void checkEGMMove() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/config2.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    CoordinateImpl coordA = new CoordinateImpl(1, 4);
    CoordinateImpl coordB = new CoordinateImpl(32, 11);

    EscapeGameManagerImpl finalEgm = egm;
    assertThrows(EscapeException.class, () -> {
      finalEgm.move(coordA, coordB);
    });
  }
  //------------------------------------------------------------------
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
  /** EscapeGameManager addObserver() and removeObserver() throw exceptions before they can be tested **/

  /** Game Board Tests **/
  //******************************************************************
  @Test /** 17 **/
  void constructSquare2x2Board() {
    EscapeGameManager egm = null;
    try{
      egm = new EscapeGameBuilder("configurations/config1.egc").makeGameManager();
    } catch (Exception e){
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);
    //assertEquals(); // TODO: Check if the number of tiles total exists in game instance
  }





  /** Location Tests **/
  //***********************************************************************************************
  @Test /**  **/
  void checkGameWithOneClearLocation() {
    //TODO: Implement
  }
}