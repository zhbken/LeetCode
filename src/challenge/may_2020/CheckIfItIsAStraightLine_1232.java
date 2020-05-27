package challenge.may_2020;

public class CheckIfItIsAStraightLine_1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        int x = coordinates[0][0] - coordinates[1][0];
        int y = coordinates[0][1] - coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            if (x * (coordinates[0][1] - coordinates[i][1]) != y * (coordinates[0][0] - coordinates[i][0])) {
                return false;
            }
        }
        return true;
    }
}
