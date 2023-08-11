import task5and6.Tree;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements to insert: ");
        int numElements = scanner.nextInt();
        Tree<Integer> tree = new Tree<>();
        Random random = new Random();
        System.out.println("Random numbers to insert:");
        for (int i = 0; i < numElements; i++) {
            int randomValue = random.nextInt(100);
            tree.insert(randomValue);
            System.out.print(randomValue + " ");
        }
        System.out.println("\nTree structure after insertion:");

        tree.printTree();
    }
}