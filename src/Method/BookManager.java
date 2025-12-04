package Method;

import Data.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    private final ArrayList<Book> books = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    private final String FILE_NAME = "books.txt";

    public BookManager() {
        loadFromFile();
    }

    public void start() {
        while(true) {
            System.out.println("\n 1.  Add Book 2. List Books, 3. Search the book, 4. delete book 5. count book 6. saveToFile");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 : addBook(); break;
                case 2 : listBooks(); break;
                case 3 : searchBooks(); break;
                case 4 : deleteBook(); break;
                case 5 : countBooks(); break;
                case 6 : saveToFile(); break;
                case 0 : saveToFile(); return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    public void addBook() {
        System.out.println("Title :");
        String title = sc.nextLine();
        System.out.println("Author : ");
        String author = sc.nextLine();
        System.out.println("Price : ");
        double price = sc.nextDouble();
        sc.nextLine();

        books.add(new Book(title, author, price));
        System.out.println("Book aadded");
    }

    public void listBooks() {
        if (books.isEmpty()) System.out.println("No book");
        else books.forEach(System.out::println);
    }

    public  void searchBooks() {
        System.out.print("Keyword :");
        String keyword = sc.nextLine().toLowerCase();

        books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(keyword)
                    || b.getAuthor().toLowerCase().contains(keyword))
                .forEach(System.out::println);
    }

    public void deleteBook() {
        System.out.print("Title to delete : ");
        String title = sc.nextLine();
        books.removeIf(b -> b.getTitle().equalsIgnoreCase(title));
        System.out.println("Deleted!");
    }

    public void countBooks() {
        System.out.println("Total : " + books.size());
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book b : books) {
                bw.write(b.getTitle() + "|" + b.getAuthor() + "|" + b.getPrice());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file : " + e.getMessage());
        }
    }

    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    books.add(new Book(parts[0], parts[1], Double.parseDouble(parts[2])));
                }
            }
            System.out.println("Loaded" + books.size() + "books from file");
        } catch (Exception e) {
            System.out.println("Error loading file : " + e.getMessage());
        }
    }
}
