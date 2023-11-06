package com.example.mercadolibre.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringArrayUtils {

    public char[][] stringArrayTo2DCharArray(String [] dna){

        char[][] matrix = new char[dna.length][dna.length];
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length; j++) {
                matrix[i][j] = dna[i].charAt(j);
            }
        }
        return matrix;
    }

    public char[] getMatrixColumnToCharArray(char [][] matrix, int column){
        char [] row = new char [matrix[1].length];
        for (int i = 0; i < row.length; i++) {
            row[i] = matrix[i][column];
        }
        return row;
    }

    public char[] getMatrixObliqueToCharArray(char[][] matrix, int row, int column){
        char [] result = new char[matrix.length];
        int flag = 0;
        while (row < matrix[0].length && column < matrix[1].length){
            result[flag] = matrix[row][column];
            flag++;
            row++;
            column++;
        }
        return result;
    }

    public char[] getMatrixInverseObliqueToCharArray(char[][] matrix, int row, int column){
        char[] result = new char[matrix.length];
        int flag = 0;
        while(row < matrix[0].length && column >= 0){
            result[flag] = matrix[row][column];
            flag++;
            row++;
            column--;
        }
        return result;
    }

}
