public class Hoarse {
    static int X = 5;
    static int Y = 5;
    static int board[][] = new int[Y][X];
    static int num;

    public static void main(String[] args) {
        init();
        num = 0;

        boolean flag = false;
        int i = 0;
        int j = 0;
        do {
            board[i][j] = 1;
            flag = move(i, j);
            board[i][j] = 0;
            i++;
            if (i == X){
                i = 0;
                j++;
            }
            if (j == Y){
                System.out.println("Решений нет");
                break;
            }
            if (flag)
                System.out.println("Решение найдено");
        } while (!flag);
    }

    static void init() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                board[i][j] = 0;
            }
        }
    }

    static boolean move(int originX, int originY){
        num++;
        if (num >= (X * Y)){
            return true;
        } else {
            if (checkPosition(originX + 1, originY - 2)) {
                return true;
            } else if (checkPosition(originX - 1, originY - 2)) {
                return true;
            } else if (checkPosition(originX + 2, originY - 1)) {
                return true;
            } else if (checkPosition(originX + 2, originY + 1)) {
                return true;
            } else if (checkPosition(originX + 1, originY + 2)) {
                return true;
            } else if (checkPosition(originX - 1, originY + 2)) {
                return true;
            } else if (checkPosition(originX - 2, originY + 1)) {
                return true;
            } else if (checkPosition(originX - 2, originY - 1)) {
                return true;
            } else {
                num--;
                return false;
            }
        }
    }

    static boolean checkPosition(int x, int y){
        if (x >= 0 && x < X && y >= 0 && y < Y){
            if (board[x][y] == 1) {
                return false;
            }
            else {
                board[x][y] = 1;
                if (move(x, y)) {
                    return true;
                } else {
                    board[x][y] = 0;
                    return false;
                }
            }
        } else
            return false;
    }

    static boolean boardIsEnded(){
        int sum = 0;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                sum += board[i][j];
            }
        }
        System.out.println(sum);
        return sum == X * Y;
    }
}
