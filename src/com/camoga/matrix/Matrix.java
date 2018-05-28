package com.camoga.matrix;

public class Matrix {

	public static final Matrix ID = new Matrix(new double[][]{{1,0,0},{0,1,0},{0,0,1}});
	
	public double matrix[][];
	
	public Matrix(double[][] matrix) {
		this.matrix = matrix;
	}
	//TODO add addition,, substraction, inverse,...
	public Matrix multiply(double[][] m) {
		double[][] result = new double[matrix.length][m[0].length];
		for(int y = 0; y < m.length; y++) {
			for(int x = 0; x < m[0].length; x++) {
				for(int j = 0; j < matrix[0].length; j++) {
					result[y][x] += matrix[y][j]*m[j][x];
				}
			}
		}
		return new Matrix(result);
	}
	
	public Matrix multiply(Matrix m) {
		double[][] result = new double[matrix.length][m.matrix[0].length];
		for(int y = 0; y < m.matrix.length; y++) {
			for(int x = 0; x < m.matrix[0].length; x++) {
				for(int j = 0; j < matrix[0].length; j++) {
					result[y][x] += matrix[y][j]*m.matrix [j][x];
				}
			}
		}
		return new Matrix(result);
	}
	
	@Override
	public String toString() {
		String result = "[";
		for(int y = 0; y < matrix.length; y++) {
			result += "{";
			for(int x = 0; x < matrix[y].length; x++) {
				result += matrix[y][x]+", ";
			}
			result += "},\n";
		}
		result += "]\n";
		return result;
	}
}