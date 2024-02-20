import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = "";

        System.out.print("Enter '1' to input text manually or '2' to specify a file for word count: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        if (choice == 1) {
            System.out.println("Enter the text for word counting:");
            inputText = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter the path to the file you want to count words from:");
            String filePath = scanner.nextLine();

            try {
                inputText = readFromFile(filePath);
            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found.");
                System.exit(1);
            }
        } else {
            System.err.println("Invalid choice. Please enter '1' or '2'.");
            System.exit(1);
        }

        while (true) {
            System.out.print("Select an action:\n1. Count Total Words.\n2. Show Word Frequency.\n3. Exit : ");
            int action = scanner.nextInt();

            switch (action) {
                case 1: {
                    int totalWordCount = countWords(inputText);
                    System.out.println("Total Word Count: " + totalWordCount);
                    break;
                }
                case 2: {
                    Map<String, Integer> wordFrequency = getWordFrequency(inputText);
                    System.out.println("Total Number of Unique Words: " + wordFrequency.size());
                    System.out.println("Word Frequency:");
                    for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;
                }
                case 3: {
                    System.out.println("Thank You for using the program!");
                    System.exit(0);
                }
                default: {
                    System.out.println("Wrong Input!!!\nEnter Correctly...");
                    break;
                }
            }
        }
    }

    // Method to count total words in the input text
    public static int countWords(String text) {
        String[] words = text.split("[\\s.,!?;:]+");
        return words.length;
    }

    // Method to get word frequency in the input text
    public static Map<String, Integer> getWordFrequency(String text) {
        String[] words = text.split("[\\s.,!?;:]+");
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase();
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }

    // Method to read text from a file
    public static String readFromFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        File file = new File(filePath);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                content.append(fileScanner.nextLine());
                if (fileScanner.hasNextLine()) {
                    content.append("\n");
                }
            }
        }
        return content.toString();
    }
}
