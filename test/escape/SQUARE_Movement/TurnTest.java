package escape.SQUARE_Movement;

import escape.Builder.EscapeGameBuilder;
import escape.CoordinateImpl;
import escape.EscapeGameManagerImpl;
import escape.GameStatusImpl;
import escape.required.EscapePiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnTest {
  //***************************************************************************************************************************
  @Test
  /** **/
  void checkPieceDistanceAttribute() {
    EscapeGameManagerImpl egm = null;
    try{
      egm = (EscapeGameManagerImpl)new EscapeGameBuilder("configurations/Turn Configurations/FullGame.egc").makeGameManager();
    } catch (Exception e){
      e.printStackTrace();
      fail("Exception from escape builder: " + e.getMessage());
    }
    assertNotNull(egm);

    /** CHRIS' PIECES **/
    CoordinateImpl CF = new CoordinateImpl(8, 3);
    CoordinateImpl CH = new CoordinateImpl(6, 8);
    CoordinateImpl CB = new CoordinateImpl(10, 6);
    CoordinateImpl CS = new CoordinateImpl(17, 2);
    CoordinateImpl CD = new CoordinateImpl(4, 14);

    /** PAT'S PIECES **/
    CoordinateImpl PF = new CoordinateImpl(8, 13);
    CoordinateImpl PH = new CoordinateImpl(8, 17);
    CoordinateImpl PB = new CoordinateImpl(7, 16);
    CoordinateImpl PS = new CoordinateImpl(10, 13);
    CoordinateImpl PD = new CoordinateImpl(9, 8);

    /** Check all pieces line up **/
    EscapePiece.PieceName pieceName = egm.getGameBoard().getBoardLocation(CF.getRow(), CF.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.FROG);

    pieceName = egm.getGameBoard().getBoardLocation(CH.getRow(), CH.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.HORSE);

    pieceName = egm.getGameBoard().getBoardLocation(CB.getRow(), CB.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.BIRD);

    pieceName = egm.getGameBoard().getBoardLocation(CS.getRow(), CS.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.SNAIL);

    pieceName = egm.getGameBoard().getBoardLocation(CD.getRow(), CD.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.DOG);

    pieceName = egm.getGameBoard().getBoardLocation(PF.getRow(), PF.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.FROG);

    pieceName = egm.getGameBoard().getBoardLocation(PH.getRow(), PH.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.HORSE);

    pieceName = egm.getGameBoard().getBoardLocation(PB.getRow(), PB.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.BIRD);

    pieceName = egm.getGameBoard().getBoardLocation(PS.getRow(), PS.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.SNAIL);

    pieceName = egm.getGameBoard().getBoardLocation(PD.getRow(), PD.getColumn()).getPieceName();
    assertEquals(pieceName, EscapePiece.PieceName.DOG);

    /** Check validMove is false **/
    GameStatusImpl gameStatus = new GameStatusImpl();
    gameStatus.setValidMove(true);
    assertTrue(gameStatus.isValidMove());

    System.out.println("******** GAME INITIALIZED ********");
    // First Move
    CoordinateImpl TO = new CoordinateImpl(13, 9);
    assertEquals(gameStatus.isValidMove(), egm.move(CB, TO).isValidMove());
    System.out.println("First Move: ");
    System.out.println("(" + CB.getRow() + ", " + CB.getColumn() + ")\n");

    // Second Move
    TO = new CoordinateImpl(11, 12);
    assertEquals(gameStatus.isValidMove(), egm.move(PS, TO).isValidMove());
    System.out.println("Second Move: ");
    System.out.println("(" + PS.getRow() + ", " + PS.getColumn() + ")\n");

    // Third Move
    TO = new CoordinateImpl(13, 10);
    assertEquals(gameStatus.isValidMove(), egm.move(CB, TO).isValidMove());
    System.out.println("Third Move: ");
    System.out.println("(" + CB.getRow() + ", " + CB.getColumn() + ")\n");



    //egm.getGameBoard().printBoard();
  }
}
