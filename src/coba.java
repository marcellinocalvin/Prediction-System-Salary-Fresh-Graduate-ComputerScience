public class coba {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int rowIndex = 1;
        int columnIndex = 2;

        int value = getValueFromSelectedRow(matrix, rowIndex, columnIndex);
        System.out.println("Value: " + value);
    }

    public static int getValueFromSelectedRow(int[][] matrix, int rowIndex, int columnIndex) {
        if (matrix == null || matrix.length == 0 || rowIndex < 0 || rowIndex >= matrix.length ||
                columnIndex < 0 || columnIndex >= matrix[rowIndex].length) {
            // Return a default value or throw an exception, depending on your requirements
            return -1;
        }

        return matrix[rowIndex][columnIndex];
    }
}
