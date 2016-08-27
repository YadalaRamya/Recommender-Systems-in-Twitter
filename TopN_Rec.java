package com.recssys.recommendation;

import java.util.*;
import java.lang.Math.*;

public class TopN_Rec {

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

    public static void main(String[] args) throws NullPointerException {
        int count = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter no.of users");
        int n = in.nextInt();

        System.out.println("Enter no.of items");
        int m = in.nextInt();

        int I = m, x = n * m;
        int[] Ou = new int[x];
        int[] Ou1 = new int[x];
        int[] Ru = new int[x];
        int[][] UI = new int[n][m];
        System.out.println("Enter the User-Item Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                UI[i][j] = in.nextInt();
            }
        }
        System.out.println("UI="); // Display User-Item Matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(UI[i][j] + "\t");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Relevant Items for user-" + (i + 1) + "=" + "\t" + "{");
            for (int j = 0; j < m; j++) {
                if (UI[i][j] == 1) {
                    Ou[i] = j;
                    Ru[j] = Ou[i];
                    System.out.print((Ou[i] + 1) + ",");
                    count++;
                }
            }

            System.out.print("}");
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Irrelevant Items for user-" + (i + 1) + "=" + "\t" + "{");
            for (int j = 0; j < m; j++) {
                if (UI[i][j] != 1) {
                    Ou1[i] = j;
                    System.out.print((++Ou1[i]) + ",");
                }
            }
            System.out.print("}");
            System.out.println();
        }
        System.out.print("I=" + I + "\t");
        System.out.print("i+=" + count + "\t");
        System.out.println("i-=" + (count - I));

        Random rand = new Random();
        int K = 2;
        double[][] Tu = new double[n][K];
        Tu = RandMatrix(n, K);
        double[][] Ti = new double[K][m];
        Ti = RandMatrix(K, m);
        double[][] Tb = new double[n][m];
        Tb = RandMatrix(n, m);
        double[][] fui = new double[n][m];
        double[][] TudotTi = new double[n][m];
        int R = 0;

        System.out.println("Tu=");
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < K; k++) {
                System.out.print(Tu[i][k] + "\t");
            }
            System.out.println();
        }
        System.out.println("Ti=");
        for (int k = 0; k < K; k++) {
            for (int j = 0; j < m; j++) {

                System.out.print(Ti[k][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Tb=");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0) {
                    Tb[i][j] = 0;
                }
                System.out.print(Tb[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("TudotTi=");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                TudotTi[i][j] = 0;
                for (int k = 0; k < K; k++) {
                    TudotTi[i][j] = Tu[i][k] * Ti[k][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(TudotTi[i][j] + "\t");
            }
            System.out.println();
        }

        double[] L = new double[x];
        double rank = 0;
        for (int u = 0; u < n; u++) {
            for (int i = 0; i < m; i++) {
                fui[u][i] = TudotTi[u][i] + Tb[u][i];
            }
        }

        System.out.println("fui=");
        for (int u = 0; u < n; u++) {
            for (int i = 0; i < m; i++) {
                System.out.print(fui[u][i] + "\t");
            }
            System.out.println();
        }

        for (int u = 0; u < n; u++) {
            System.out.println("For User(" + (u + 1) + ") :");
            for (int i = 0; i < m; i++) {
                System.out.println("Rank[" + (i + 1) + "] =");
                for (int j = 0; j < m; j++) {
                    if (j != i) {
                        L[i] = fui[u][j] - fui[u][i];
                        // System.out.print("L[" + u + "," + j + "-" + u + "," + i + "] =" + L[i]  );
                        //int k=0;
                        if (L[i] > 0) {
                            R = 1;
                        } else {
                            R = 0;
                        }
                        rank += R;
                    }
                    

                }
                    System.out.println(rank);
            }
        }
        System.out.println();
        double ADG = 0;
        for (int j = 0; j < m; j++) {
            //System.out.print("Rank of relevant items [" +(Ou[i]) + "] =  "  );
            System.out.print((Ru[j] + 1) + ",");
        }
        System.out.println();
    }

}
