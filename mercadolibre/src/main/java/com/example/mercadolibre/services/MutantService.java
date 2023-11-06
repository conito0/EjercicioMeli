package com.example.mercadolibre.services;

import com.example.mercadolibre.utils.StringArrayUtils;

public class MutantService {

    private final int DNA_LENGTH = 4;
    private final int DNA_MUTANT_COUNT = 2;

    private int search(char[] row){
        char flag = ' ';
        int letterCount = 0;
        int sequenceCount = 0;
        boolean restart = false;
        for (char c : row) {
            if (restart) {
                flag = c;
                restart = false;
            }
            if (flag == c) {
                letterCount++;
                if (letterCount == DNA_LENGTH) {
                    sequenceCount++;
                    letterCount = 1;
                    restart = true;
                }
            } else {
                letterCount = 1;
                flag = c;
            }
        }
        return sequenceCount;
    }

    private boolean cut(int counter){
        return counter >= DNA_MUTANT_COUNT;
    }

    public boolean isMutant(String[] dna){

        char[][] matrix = StringArrayUtils.stringArrayTo2DCharArray(dna);

        int counter = 0;
        int length = matrix.length;
        int row = length-1;
        int column = 0;
        while(column < length && row >= 0){

            //In this line start the execution of the algorithm

			/*

				Example of execution of the algorithm:
				P G G F F R
				T O O O O U
				T O O O O U
				H O O O O X
				H O O O O X
				H O O O O X

				T: Horizontal and oblique search
				U: Inverse oblique search
				R: Vertical and inverse oblique search
				P: Horizontal, vertical and oblique search
				G: Vertical and oblique search
				F: Vertical and inverse oblique search

				Bounds of obliques execution:
				The oblique are executed when the next conditions:
				row < (LENGTH - DNA LENGTH) AND col < (LENGTH - DNA LENGTH)

				The inverse oblique are exectuted when the next conditions:
				row < (LENGTH - DNA LENGTH) AND col > (LENGTH - DNA LENGTH)

			 */

            if(column == 0){
                counter += search(matrix[row]);
                if (cut(counter)) break;

                if(row <= length - DNA_LENGTH){
                    counter += search(StringArrayUtils.getMatrixObliqueToCharArray(matrix, row, column));
                    if (cut(counter)) break;
                }
            }

            if(row == 0 && column != 0 && column != length-1){
                counter += search(StringArrayUtils.getMatrixColumnToCharArray(matrix, column));
                if (cut(counter)) break;

                if(column <= length - DNA_LENGTH){
                    counter += search(StringArrayUtils.getMatrixObliqueToCharArray(matrix, row, column));
                    if (cut(counter)) break;
                }
                if(column > length - DNA_LENGTH){
                    counter += search(StringArrayUtils.getMatrixInverseObliqueToCharArray(matrix, row, column));
                    if (cut(counter)) break;
                }
            }

            if(column == length-1 && row <= length - DNA_LENGTH){
                counter += search(StringArrayUtils.getMatrixInverseObliqueToCharArray(matrix, row, column));
                if (cut(counter)) break;
            }

            //End execution

            //Start to traverse the matrix

			/*
				Example of execution:

				X X X X X X
				X V V V V X
				X V V V V X
				X V V V V X
				X V V V V X
				X V V V V X

				The X char are the path of execution of the algorithm

			 */


            //if the column is the max index
            //we iterate for the right side of the matrix
            if(column == length-1){
                if(row < length-1){
                    //Increment the value of the row to down for the right side
                    row++;
                }
                else{
                    //End the travel
                    break;
                }
            }
            //if the row is 0 and the column is not the max
            //we iterate for the top of the matrix
            if(row == 0 && column != length-1){
                column++;
            }
            //if the columns is 0 the row that decrement one per time
            //we iterate for the left side of the matrix
            if(column == 0){
                //Decrement the row value to up for the left side
                row--;
            }

            //End

        }

        return counter >= DNA_MUTANT_COUNT;
    }

}
