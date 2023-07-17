package project;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class lockedMeApp {
    private static final String ROOT_DIRECTORY = "C:\\Users\\jyothi\\Desktop\\simplilearn\\";

    public static void main(String[] args) {
        displayWelcomeScreen();

        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            int option = getUserChoice();

            switch (option) {
                case 1:
                    displayFileNames();
                    break;
                case 2:
                    handleUserOperations();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Closing the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayWelcomeScreen() {
        System.out.println("Welcome to LockedMe.com");
        System.out.println("Developer: Your Name");
        System.out.println();
    }

    private static void displayMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("1. Retrieve current file names in ascending order");
        System.out.println("2. User operations");
        System.out.println("3. Close the application");
    }

    private static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void displayFileNames() {
        File directory = new File(ROOT_DIRECTORY);
        String[] fileNames = directory.list();

        if (fileNames == null || fileNames.length == 0) {
            System.out.println("No files found in the directory.");
        } else {
            Arrays.sort(fileNames);
            System.out.println("File names in ascending order:");
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        }

        System.out.println();
    }

    private static void handleUserOperations() {
        boolean backToMain = false;
        while (!backToMain) {
            displayUserOperationsMenu();
            int option = getUserChoice();

            switch (option) {
                case 1:
                    addFile();
                    break;
                case 2:
                    deleteFile();
                    break;
                case 3:
                    searchFile();
                    break;
                case 4:
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayUserOperationsMenu() {
        System.out.println("USER OPERATIONS");
        System.out.println("1. Add a file to the directory list");
        System.out.println("2. Delete a file from the directory list");
        System.out.println("3. Search for a file in the directory list");
        System.out.println("4. Navigate back to the main context");
    }

    private static void addFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to add: ");
        String fileName = scanner.nextLine();

        File file = new File(ROOT_DIRECTORY +fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File added successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        System.out.println();
    }

    private static void deleteFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to delete: ");
        String fileName = scanner.nextLine();

        File file = new File(ROOT_DIRECTORY + fileName);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File not found.");
        }

        System.out.println();
    }

    private static void searchFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name to search: ");
        String fileName = scanner.nextLine();

        File file = new File(ROOT_DIRECTORY + fileName);
        if (file.exists() && file.isFile()) {
            System.out.println("File found.");
        } else {
            System.out.println("File not found.");
        }

        System.out.println();
    
}

		}


