package com.recssys.recommendation;

import java.util.Scanner;
import java.math.*;

public class Link_rec {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no.of users");
        int L = in.nextInt();
        System.out.println("Enter no.of items");
        int K = in.nextInt();
        System.out.println("Enter no.of distinct hashtags");
        int M = in.nextInt();
        int[][][] UIH = new int[K][L][M];
        int[][] IU = new int[K][L];
        int[][] IH = new int[K][M];
        System.out.println("Enter the User-Item-Hashtag Matrix");
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < L; j++) {
                for (int k = 0; k < M; k++) {
                    UIH[i][j][k] = in.nextInt();
                }
            }
        }
        System.out.println("UIH="); // Display User-Item Matrix
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < L; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.print(UIH[i][j][k] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("UI=");
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < L; j++) {
                System.out.print(UIH[i][j][0] + "\t");
            }
            System.out.println();
        }
        System.out.println("IH=");
        for (int i = 0; i < K; i++) {
            for (int k = 0; k < M; k++) {
                int sum = 0;
                for (int j = 0; j < L; j++) {
                    sum += UIH[0][j][0];
                    UIH[i][0][k] = sum;
                }
                System.out.print(UIH[i][0][k] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        double simu = 0, simh = 0;
        System.out.println("Similarity of ik& ij:");
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < L; j++) {
                

            }
        }
        System.out.println();
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < L; j++) {
                

            }
        }
    }

}
