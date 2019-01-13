package javase01.t05;

public class Array {

    private int[][] array;

    Array(int size) {
        array = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || (i + j) == size-1) { // check if the element on main diagonal or antidiagonal
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
            }
        }
    }

    public void print() {
        //print every element of the array
        for (int[] row:array) {
            for (int element:row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
