package com.recsys.twitter.matfac;

import java.util.*;
import java.util.Scanner;
//import java.math.*;
//import java.util.Arrays;
//import java.lang.*;
//import java.util.Scanner;

public class Matfac {

	public static double[][] RandMatrix(int n, int m) {
		double[][] Matrix = new double[n][m];

		Random rand = new Random();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Double r = rand.nextDouble();
				Matrix[i][j] = r;
			}
		}
		return Matrix;
	}

	public static void main(String[] args) {
		int K = 2; 
		double eij = 0, eij2 = 0;
		double gamma = 0.0002;
		double lambda = 0.02;
		Scanner in = new Scanner(System.in);

		double[][] R = new double[4][4]; // Input Rating matrix
		System.out.println("Enter the elements for the rating Matrix");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				R[i][j] = in.nextInt();
			}
		}
		System.out.println("R="); // Display Rating Matrix
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(R[i][j] + "\t");
			}
			System.out.println();
		}

		double[][] P = new double[10][10]; // Compute 'P' Random Matrix
		P = RandMatrix(4, 2);
		double[][] Q = new double[10][10]; // Compute 'Q' Random Matrix
		Q = RandMatrix(2, 4);
		double[][] R2 = new double[10][10]; // Initialize Filled Matrix
		double[][] PdotQ = new double[20][20];

		System.out.println("P=");
		for (int i = 0; i < R.length; i++) {
			for (int k = 0; k < K; k++) {
				System.out.print(P[i][k] + "\t");
			}
			System.out.println();
		}
		System.out.println("Q=");
		for (int k = 0; k < K; k++) {
			for (int j = 0; j < R[0].length; j++) {

				System.out.print(Q[k][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("PdotQ=");
		for (int i = 0; i < R.length; i++) {
			for (int j = 0; j < R[0].length; j++) {
				PdotQ[i][j] = 0;
				for (int k = 0; k < K; k++) {
					PdotQ[i][j] = P[i][k] * Q[k][j];
				}
			}
		}
		for (int i = 0; i < R.length; i++) {
			for (int j = 0; j < R[0].length; j++) {
				System.out.print(PdotQ[i][j] + "\t");
			}
			System.out.println();
		}
		while(eij2!= 0.001){
		//for (int steps = 0; steps < 5000; steps++) {
		  for (int i = 0; i < R.length; i++) {
			for (int j = 0; j < R[0].length; j++) {
				if (R[i][j] > 0)
					
				 eij = R[i][j] - PdotQ[i][j]; // computes Error

				// eij2 = (int) (eij2 + Math.pow(R[i][j] - PdotQ[i][j], 2));

				R2[i][j] = 0;
				for (int k = 0; k < K; k++) { // update rules
					P[i][k] = (double) (P[i][k] + gamma * (2*eij * Q[k][j] - lambda * P[i][k]));
					Q[k][j] = (double) (Q[k][j] + gamma * (2*eij * P[i][k] - lambda * Q[k][j]));
					R2[i][j] = P[i][k] * Q[k][j];
				}
			}
		}
    
    	
    
		for (int i = 0; i < R.length; i++) {
			for (int j = 0; j < R[0].length; j++) {
				if (R[i][j] > 0)
					eij2 = (int) (eij2 + Math.pow(R[i][j] - R2[i][j], 2)); // Computes overall Error
																			
				for (int k = 0; k < K; k++) {
					eij2 = (int) (eij2 + lambda * (Math.pow(P[i][k], 2) + Math.pow(Q[k][j], 2)));
					
				} 
					
			}
		}
      break;		
    }   
		
		System.out.println("Resultant Matrix");
					/*
					 * for ( i = 0; i < 4; i++) { for ( j = 0; j < 4; j++) {
					 * R2[i][j] = 0; for (k = 0; k < 2; k++) { R2[i][j] =
					 * P[i][k] * Q[k][j]; } } }
					 */
					for (int i = 0; i < R.length; i++) {
						for (int j = 0; j < R[0].length; j++) {
							System.out.print(R2[i][j] + "\t");
						}
						System.out.println();
					}
				}
			
}
		
	
// }

