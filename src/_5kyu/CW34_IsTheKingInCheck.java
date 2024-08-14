package _5kyu;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.of;

/*
You have to write a function that takes for input a 8x8 chessboard in the form of a bi-dimensional array of chars
(or strings of length 1, depending on the language) and returns a boolean indicating whether the king is in check.

The array will include 64 squares which can contain the following characters :
'K' for the black King;
'Q' for a white Queen;
'B' for a white Bishop;
'N' for a white kNight;
'R' for a white Rook;
'P' for a white Pawn;
' ' (a space) if there is no piece on that square.

There will always be exactly one king, which is the black king, whereas all the other pieces are white.
The board is oriented from Black's perspective.
Remember that pawns can only move and take forward.
Also be careful with the pieces' lines of sight ;-) .

The input will always be valid, no need to validate it. To help you visualize the position,
tests will print a chessboard to show you the problematic cases.
 */
public class CW34_IsTheKingInCheck {
    public static void main(String[] args) {

        char[][] chessboard1 = new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'R', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'K', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };
        System.out.println(isTheKinginCheck(chessboard1)); // true

        char[][] chessboard2 = new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'B', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'K', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };
        System.out.println(isTheKinginCheck(chessboard2)); // true

        char[][] chessboard3 = new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'K', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };
        System.out.println(isTheKinginCheck(chessboard3)); // false
    }

    public static boolean isTheKinginCheck(char[][] chessboard) {

        int kingRow = 0, kingCol = 0;
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                if (chessboard[i][j] == 'K') {
                    kingRow = i;
                    kingCol = j;
                    i = chessboard.length;
                    break;
                }
            }
        }

        return isThreatenedByPawn(chessboard, kingRow, kingCol)
                || isThreatenedByKnight(chessboard, kingRow, kingCol)
                || isThreatenedByQueenBishopOrRook(chessboard, kingRow, kingCol);


        // ParanoidUser, 401Unauthorized
//        return of(chessboard).map(String::valueOf).collect(joining("_")).matches(".*(" +
//                /* ♟   */ "P(?<!_.).{7}K|P(?!_).{9}K|" +
//                /* ♛♜ */ "[QR] *K|K *[QR]|[QR](.{8} )*.{8}K|K(.{8} )*.{8}[QR]|" +
//                /* ♛♝ */ "[QB]((?<!_.).{7} )*(?<!_).{7}K|K((?<!_.).{7} )*(?<!_).{7}[QB]|[QB]((?!_).{9} )*(?!_).{9}K|K((?!_).{9} )*(?!_).{9}[QB]|" +
//                /* ♞   */ "N(?<!_.|_..)(?![^_]{6}).{6}K|K(?<!_.|_..)(?![^_]{6}).{6}N|N(?!_|._).{10}K|K(?!_|._).{10}N|N(?<!_.).{16}K|K(?<!_.).{16}N|N(?!_).{18}K|K(?!_).{18}N).*");
    }

    private static boolean isThreatenedByPawn(char[][] chessboard, int row, int col) {
        return row > 0 && ((col > 0 && chessboard[row - 1][col - 1] == 'P') || (col < 7 && chessboard[row - 1][col + 1] == 'P'));
    }

    private static boolean isThreatenedByKnight(char[][] chessboard, int row, int col) {
        return row > 1 && col > 0 && chessboard[row - 2][col - 1] == 'N'
                || row > 1 && col < 7 && chessboard[row - 2][col + 1] == 'N'
                || row < 6 && col > 0 && chessboard[row + 2][col - 1] == 'N'
                || row < 6 && col < 7 && chessboard[row + 2][col + 1] == 'N'
                || row > 0 && col > 1 && chessboard[row - 1][col - 2] == 'N'
                || row > 0 && col < 6 && chessboard[row - 1][col + 2] == 'N'
                || row < 7 && col > 1 && chessboard[row + 1][col - 2] == 'N'
                || row < 7 && col < 6 && chessboard[row + 1][col + 2] == 'N';
    }

    private static boolean isThreatenedByQueenBishopOrRook(char[][] chessboard, int row, int col) {
        boolean pathClearUp = true, pathClearDown = true, pathClearLeft = true, pathClearRight = true,
                pathClearUpLeft = true, pathClearUpRight = true, pathClearDownLeft = true, pathClearDownRight = true;

        for (int i = 1; i < 8; i++) {
            int up = row - i, down = row + i, left = col - i, right = col + i;

            if (pathClearUp && up >= 0) {
                if (chessboard[up][col] == 'Q' || chessboard[up][col] == 'R') {
                    return true;
                }
                if (chessboard[up][col] != ' ') {
                    pathClearUp = false;
                }
            }

            if (pathClearDown && down < 8) {
                if (chessboard[down][col] == 'Q' || chessboard[down][col] == 'R') {
                    return true;
                }
                if (chessboard[down][col] != ' ') {
                    pathClearDown = false;
                }
            }

            if (pathClearLeft && left >= 0) {
                if (chessboard[row][left] == 'Q' || chessboard[row][left] == 'R') {
                    return true;
                }
                if (chessboard[row][left] != ' ') {
                    pathClearLeft = false;
                }
            }

            if (pathClearRight && right < 8) {
                if (chessboard[row][right] == 'Q' || chessboard[row][right] == 'R') {
                    return true;
                }
                if (chessboard[row][right] != ' ') {
                    pathClearRight = false;
                }
            }

            if (pathClearUpLeft && up >= 0 && left >= 0) {
                if (chessboard[up][left] == 'Q' || chessboard[up][left] == 'B') {
                    return true;
                }
                if (chessboard[up][left] != ' ') {
                    pathClearUpLeft = false;
                }
            }

            if (pathClearUpRight && up >= 0 && right < 8) {
                if (chessboard[up][right] == 'Q' || chessboard[up][right] == 'B') {
                    return true;
                }
                if (chessboard[up][right] != ' ') {
                    pathClearUpRight = false;
                }
            }

            if (pathClearDownLeft && down < 8 && left >= 0) {
                if (chessboard[down][left] == 'Q' || chessboard[down][left] == 'B') {
                    return true;
                }
                if (chessboard[down][left] != ' ') {
                    pathClearDownLeft = false;
                }
            }

            if (pathClearDownRight && down < 8 && right < 8) {
                if (chessboard[down][right] == 'Q' || chessboard[down][right] == 'B') {
                    return true;
                }
                if (chessboard[down][right] != ' ') {
                    pathClearDownRight = false;
                }
            }
        }
        return false;
    }
}
