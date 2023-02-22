<?php
declare(strict_types=1);

namespace entwicklerheld;

class QueensProblem {

    /**
     * @param array $positions
     * @param mixed $rook
     * @return boolean
     */
    static function isSafeRook(array $positions, $rook) : bool {
        $res = true;
        foreach ($positions as $enemy) {
            if (
                $enemy->rowIndex === $rook->rowIndex
                || $enemy->columnIndex === $rook->columnIndex
            ) {
                $res = false;
            }
        }

        return $res;
    }

    /**
     * @param array $positions
     * @param mixed $queen
     * @return boolean
     */
    static function isSafeQueen(array $positions, $queen) : bool {
        $res = true;
        foreach ($positions as $enemy) {
            if (
                $queen->rowIndex === $enemy->rowIndex
                || $queen->columnIndex === $enemy->columnIndex
                || $queen->leftDiagonal() === $enemy->leftDiagonal()
                || $queen->rightDiagonal() === $enemy->rightDiagonal()
            ) {
                $res = false;
            }
        }

        return $res;
    }

    /**
     * @param integer $boardSize
     * @return array
     */
    static function getQueensProblemSolution(int $boardSize) : array {
        if ($boardSize < 4) {
            return [];
        }

        $positions = [];

        $p = new Position(0, 0);
        $positions[] = $p;

        $row = 0;

        while (count($positions) < $boardSize) {
            for ($column = 0; $column < $boardSize; $column++) {
                $p = new Position($row, $column);

                if (self::isSafeQueen($positions, $p)) {
                    $positions[] = $p;
                    break;
                }
            }
            $row++;
        }

        return $positions;
    }
}