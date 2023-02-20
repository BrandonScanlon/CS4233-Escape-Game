package escape;

// Imports
//**************************************
import escape.builder.LocationInitializer;
import escape.builder.PieceTypeDescriptor;
import escape.required.Coordinate.CoordinateType;
import escape.required.EscapeException;

public interface GameBoard {
	// Methods
	//************************************
	default void setBoardLocation(int col, int row, LocationInitializer locationInitializer) { throw new EscapeException("Not implemented"); }

	default CoordinateImpl getBoardLocation(int col, int row) { throw new EscapeException("Not implemented"); }

	CoordinateType getGameBoardType();

	default void printBoard() { throw new EscapeException("Not implemented"); }

	default PieceTypeDescriptor[] getPieceTypeDescriptors() { throw new EscapeException("Not implemented"); }

	default int getRows() { throw new EscapeException("Not implemented"); }

	default int getCols() { throw new EscapeException("Not implemented"); }
}
