using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualBasic;

namespace QueensProblemImplementation
{
    public class QueensProblem
    {
        public static Boolean IsSafeRook(List<Position> positions, Position rook) 
        {
            bool res = true;
            foreach (Position enemy in positions) {
                if (
                    enemy.RowIndex == rook.RowIndex
                    || enemy.ColumnIndex == rook.ColumnIndex
                ) {
                    res = false;
                }
            }

            return res;
        }

        public static Boolean IsSafeQueen(List<Position> positions, Position queen) 
        {
            bool res = true;
            foreach (Position enemy in positions) {
                if (
                    enemy.RowIndex == queen.RowIndex
                    || enemy.ColumnIndex == queen.ColumnIndex
                    || enemy.LeftDiagonal() == queen.LeftDiagonal()
                    || enemy.RightDiagonal() == queen.RightDiagonal()
                ) {
                    res = false;
                }
            }

            return res;
        }

        public static List<Position> GetQueensProblemSolution(int boardSize) 
        {
            List<Position> positions = new List<Position>();
            int row = 0;

            if (boardSize < 4) {
                return positions;
            }

            solve(positions, 0, boardSize);
        
            return positions;
        }

        public static bool solve(List<Position> positions, int col, int boardSize) {
            if (col >= boardSize) {
                return true;
            }

            for (int i = 0; i < boardSize; i++) {
                Position p = new Position(i, col);
                if (IsSafeQueen(positions, p)) {
                    positions.Add(p);
                    if (solve(positions, col + 1, boardSize) == true) {
                        return true;
                    }

                    positions.Remove(p);
                }
            }

            return false;
        }
    }
}