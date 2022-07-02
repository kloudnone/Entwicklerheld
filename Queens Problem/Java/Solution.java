package de.entwicklerheld.queensProblemJava;

import java.util.ArrayList;
import java.util.List;

public class QueensProblem {
  public static boolean isSafeRook(List<Position> positions, Position rook) {
    for(Position position : positions) {
      if(position.rowIndex == rook.rowIndex || position.columnIndex == rook.columnIndex) {
        return false;
      }
    }
    return true;
  }

  public static boolean isSafeQueen(List<Position> positions, Position queen) {
    for(Position position : positions) {
      if(
              position.rowIndex == queen.rowIndex
                      || position.columnIndex == queen.columnIndex
                      || position.leftDiagonal() == queen.leftDiagonal()
                      || position.rightDiagonal() == queen.rightDiagonal()
      ) {
        return false;
      }
    }
    return true;
  }

  public static List<Position> getQueensProblemSolution(int boardSize) {
    List<Position> positions = new ArrayList<>();

    if(boardSize < 4) {
      return positions;
    }

    isValid(positions, 0, boardSize);

    return positions;
  }

  public static boolean isValid(List<Position> positions, int columIndex, int boardSize) {
    if(columIndex >= boardSize) {
      return true;
    }

    for(int rowIndex = 0; rowIndex < boardSize; rowIndex++) {
      Position position = new Position(rowIndex, columIndex);

      if(isSafeQueen(positions, position)) {
        positions.add(position);

        if(isValid(positions, columIndex + 1, boardSize) == true) {
          return true;
        }

        positions.remove(position);
      }
    }

    return false;
  }
}
