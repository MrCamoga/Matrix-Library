package com.camoga.matrix;

import static com.camoga.complex.Complex.ONE;
import static com.camoga.complex.Complex.ZERO;

import com.camoga.complex.Complex;

public class ComplexMatrix {

	public static final ComplexMatrix ID = new ComplexMatrix(new Complex[][]{{ONE,ZERO,ZERO},{ZERO,ONE,ZERO},{ZERO,ZERO,ONE}});
	
	public Complex matrix[][];
	
	public ComplexMatrix(Complex[][] matrix) {
		this.matrix = matrix;
	}

	public ComplexMatrix multiply(Complex[][] m) {
		Complex[][] result = new Complex[matrix.length][m[0].length];
		for(int y = 0; y < m.length; y++) {
			for(int x = 0; x < m[0].length; x++) {
				for(int j = 0; j < matrix[0].length; j++) {
					result[y][x] = Complex.add(result[y][x],Complex.mul(matrix[y][j],m[j][x]));
				}
			}
		}
		return new ComplexMatrix(result);
	}
	
	public ComplexMatrix multiply(ComplexMatrix m) {
		Complex[][] result = new Complex[matrix.length][m.matrix[0].length];
		for(int y = 0; y < m.matrix.length; y++) {
			for(int x = 0; x < m.matrix[0].length; x++) {
				for(int j = 0; j < matrix[0].length; j++) {
					result[y][x] = Complex.add(result[y][x],Complex.mul(matrix[y][j],m.matrix[j][x]));
				}
			}
		}
		return new ComplexMatrix(result);
	}
}