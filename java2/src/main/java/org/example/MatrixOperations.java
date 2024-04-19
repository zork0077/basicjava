package org.example;

import java.util.Scanner;
import java.util.Random;

public class MatrixOperations {
    private static final int MAX_SIZE = 20;
    private static final int MIN_RANDOM = 1;
    private static final int MAX_RANDOM = 100;

    private int[][] matrix;
    private int width;
    private int height;

    public static void main(String[] args) {
        MatrixOperations matrixOps = new MatrixOperations();
        matrixOps.initializeMatrix();
        matrixOps.printMatrix();
        matrixOps.findMinMax();
        matrixOps.calculateAverage();
    }

    public void initializeMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ширину матриці: ");
        width = scanner.nextInt();
        System.out.print("Введіть висоту матриці: ");
        height = scanner.nextInt();

        if (width > MAX_SIZE || height > MAX_SIZE) {
            System.out.println("Матриця повинна бути до 20 по ширіні та висоті!");
            return;
        }

        matrix = new int[height][width];

        System.out.println("Вибір режиму вводу: ");
        System.out.println("1. Ручний");
        System.out.println("2. Рандомний");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                manualInput(scanner);
                break;
            case 2:
                randomInput();
                break;
            default:
                System.out.println("Виберіть режим вводу!");
        }
    }

    private void manualInput(Scanner scanner) {
        System.out.println("Введіть елементи матриці");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("Введіть елемент [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private void randomInput() {
        Random random = new Random();
        System.out.println("Випадково генерую елементи матриці...");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM;
            }
        }
    }

    public void printMatrix() {
        System.out.println("Матриця:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void findMinMax() {
        int min = matrix[0][0];
        int max = matrix[0][0];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
    }

    public void calculateAverage() {
        int sum = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sum += matrix[i][j];
            }
        }

        double average = (double) sum / (width * height);
        System.out.println("Середнє арефметичне: " + average);
    }
}
