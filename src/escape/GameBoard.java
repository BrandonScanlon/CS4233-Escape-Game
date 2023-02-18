package escape;

// Imports
//**************************************
import escape.builder.LocationInitializer;
import escape.required.Coordinate.CoordinateType;
import escape.required.EscapeException;

public interface GameBoard {
	// Methods
	//************************************
	default void setBoardLocation(int row, int col, LocationInitializer locationInitializer) { throw new EscapeException("Not implemented"); }

	default LocationInitializer getBoardLocation(int row, int col) { throw new EscapeException("Not implemented"); }

	CoordinateType getGameBoardType();
}
