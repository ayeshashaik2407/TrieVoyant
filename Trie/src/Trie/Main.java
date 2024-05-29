package Trie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.err.println("Dictionary Using Trie Data Structure");
        System.out.println("*********~~~~~~~~~---Menu---~~~~~~~~~*********");
        int choice;
        Trie T = new Trie();
        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("1. Insert a word.");
            System.out.println("2. Insert all words from a file.");
            System.out.println("3. Check if the given words exists in Dictionary.");
            System.out.println("4. Check if the given words from a file exists in Dictionary");
            System.out.println("5. Print all words.");
            System.out.println("6. Print all words from prefix.");
            System.out.println("7. Exit.");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your word: ");
                    String st = s.next();
                    if(T.insertWord(st)) System.out.println("Word Insersion Succesful");
                    else System.err.println("Word Insersion Unsuccesful");
                    break;
                case 2:
                    System.out.print("Enter your path of the text file: ");
                    //String path = s.next();
                    System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
                    File f = new File("E:\\OneDrive - K L University\\Academics\\SEMESTER-2\\JAVA\\Trie_Application\\src\\main\\java\\org\\example\\dict.txt");
                    if(T.insertWordsThroughFile(f)) System.out.println("Words Insersion Succesful");
                    else System.err.println("Words Insersion Unsuccesful");
                    break;
                case 3:
                    System.out.print("Enter your word: ");
                    String str = s.next();
                    if(T.checkword(str)) System.out.println("Word Exists in Dictionary");
                    else {
                        System.err.println("Word does not exists in Dictionary");
                        System.out.println("Do you Wanna add it in the Dictionary(y/n)");
                        char stat = 'n';
                        stat = s.next().charAt(0);
                        if(stat == 'y'){
                        System.out.print("Enter your word: ");
                        String stri = s.next();
                        if(T.insertWord(stri)) System.out.println("Word Insersion Succesful");
                        else System.err.println("Word Insersion Unsuccesful");}
                    }
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println(T.getAllWords());
                    break;
                case 6:
                    System.out.print("Enter your word: ");
                    String str1 = s.next();
                    List<String> ans = T.autoSuggest(str1);
                    System.out.println(ans);
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        }

    }
}
