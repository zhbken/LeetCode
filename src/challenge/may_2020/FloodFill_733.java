package challenge.may_2020;

public class FloodFill_733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int imgColor = image[sr][sc];
        if (imgColor == newColor) return image;
        image[sr][sc] = newColor;
        if (sr+1 < image.length && imgColor == image[sr+1][sc]) {
            floodFill(image, sr + 1, sc, newColor);
        }

        if (sr-1 >= 0 && imgColor == image[sr-1][sc]) {
            floodFill(image, sr - 1, sc, newColor);
        }

        if (sc+1 < image[sr].length && imgColor == image[sr][sc+1]) {
            floodFill(image, sr, sc + 1, newColor);
        }

        if (sc-1 >= 0 && imgColor == image[sr][sc-1]) {
            floodFill(image, sr, sc-1, newColor);
        }

        return image;
    }
}
