import Position from "./Position";

export function isSafeRook(positions, rook) {
    let res = true;
    positions.forEach(function (enemy) {
        if (
            enemy.rowIndex == rook.rowIndex
            || enemy.columnIndex == rook.columnIndex
        ) {
            res = false;
            return;
        }
    });

    return res;
}

export function isSafeQueen(positions, queen) {
    let res = true;
    positions.forEach(function (enemy) {
        if (
            enemy.rowIndex == queen.rowIndex
            || enemy.columnIndex == queen.columnIndex
            || enemy.leftDiagonal == queen.leftDiagonal
            || enemy.rightDiagonal == queen.rightDiagonal
        ) {
            res = false;
            return;
        }
    });

    return res;
}

export function getQueensProblemSolution(boardSize) {
    let positions = [];
    let row = 0;

    if (boardSize < 4) {
        return positions;
    }

    solve(positions, 0, boardSize);

    return positions;
}

export function solve(positions, col, boardSize) {
    if (col >= boardSize) {
        return true;
    }

    for (let i = 0; i < boardSize; i++) {
        let p = new Position(i, col);
        if (isSafeQueen(positions, p)) {
            positions.push(p);
            if (solve(positions, col + 1, boardSize) == true) {
                return true;
            }

            positions.splice(-1)
        }
    }
}