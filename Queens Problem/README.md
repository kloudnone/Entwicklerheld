# Scenario 1: Rook under attack?
Let's first look at a simplified queen problem: the rook problem. Here, too, rooks must not threaten each other. Since a rook can only move horizontally and vertically, the diagonals are omitted in this problem. The first scenario is to find out if a rook is threatened by others on the chessboard.

Given a 4x4 chessboard with 3 given rooks that do not threaten each other: let positions = [new Position(0,0), new Position(2,1), new Position(3,2)];. Take a look at the class Position.js
The function isSafeRook() returns whether another rook on this chessboard is safe or not. No other rook may be in the same row or column.
For a new rook on the Position(0,0) your method should return false, because this position is already occupied by a rook.
For a new rook on the Position(0,3) your method should return false, because it is threatened by a rook on this row.
<br>
<img src="https://task-static-files.s3.eu-central-1.amazonaws.com/queens-problem/rook-board2.png"  width="30%" height="30%">
<br>

For a new rook on the Position(1,0) your method should return false, because it is threatened by a rook on this column.
For a new rook on the Position(0,1) your method should return false, because it is threatened by a rook on this row and column.
For a new rook on the Position(1,3) your method should return true, because it is not threatened by a rook on this row or column.
<br>
<img src="https://task-static-files.s3.eu-central-1.amazonaws.com/queens-problem/rook-board3.png"  width="30%" height="30%">
<br>

This should work with other examples as well.


# Scenario 2: Queen under attack?
Now we extend the isSafeRook() method from the first scenario in the new method isSafeQueen(). In addition, here we consider whether or not a queen is under attack by a queen on the row, column or diagonal.

Given a 4x4 chessboard with 2 given queens that do not threaten each other: let positions = [new Position(0,1), new Position(3,2)];
The function isSafeQueen() returns whether another queen on this chessboard is safe or not. No other queen may be in the same row, column or diagonal.
For a new queen on the Position(0,1) your method should return false, because this position is already occupied by a queen.
For a new queen on the Position(0,3) your method should return false, because it is threatened by a queen on this row.
<br>
<img src="https://task-static-files.s3.eu-central-1.amazonaws.com/queens-problem/queen-board1.png"  width="30%" height="30%">
<br>

For a new queen on the Position(2,2) your method should return false, because it is threatened by a queen on this column.
For a new queen on the Position(1,0) your method should return false, because it is threatened by a queen on this diagonal.
<br>
<img src="https://task-static-files.s3.eu-central-1.amazonaws.com/queens-problem/queen-board2.png"  width="30%" height="30%">
<br>

For a new queen on the Position(2,0) your method should return true, because it is not threatened by a queen on this row, column or diagonal.
<br>
<img src="https://task-static-files.s3.eu-central-1.amazonaws.com/queens-problem/queen-board3.png"  width="30%" height="30%">
<br>

This should work with other examples as well.


# Scenario 3: One valid solution
Now let's take a closer look at the n queens problem. We already know whether a queen is standing safely or not. Now we want to find a valid solution for the n queens problem for a given chessboard size. Place n queens on a nxn chessboard so that none threatens the others.

Given is a boardSize of 4. Your task is to find a solution with 4 queens on the chessboard and return a list with the right positions (order does not matter). For this boardSize there are 2 valid solutions:
let positions1 = [new Position(0,1), new Position(1,3), new Position(2,0), new Position(3,2)];
let positions2 = [new Position(0,2), new Position(1,0), new Position(2,3), new Position(3,1)];
<br>
<img src="https://task-static-files.s3.eu-central-1.amazonaws.com/queens-problem/queen-board4.png"  width="30%" height="30%">
<br>


Your method getQueensProblemSolution() should return one of them.
Note that the n queens problem only work for a boardSize greater or equal 4.
For a boardSize of less than 4 your method should return an empty list.
This should work with other examples as well.