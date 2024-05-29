package Trie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trie {
    static int ALPHA_SIZE = 26;
    TrieNode root = new TrieNode();

    boolean insertWord(String word) // store given word in TRIE DataStructure.
    {
        System.out.println("Inserting "+word);
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a'; // a -> 0 , b -> 1 , c -> 3
            if (temp.children[idx] == null) {
                TrieNode newNode = new TrieNode(); //create new Node.
                temp.children[idx] = newNode;
            }
            temp = temp.children[idx];
        }
        temp.isEOW = true;
        return true; //Stored a new Word.
    }

    boolean checkword(String word) // to check whether word is present in the Trie DataStructure or not.
    {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a'; // a -> 0 , b -> 1 , c -> 3
            if (temp.children[idx] == null) {
                return false; // word is not in the DataStructure.
            }
            temp = temp.children[idx];
        }
        return temp.isEOW;
    }

    List<String> getAllWords(){
        List<String> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        helper(root,path,ans);
        return ans;
    }

    void helper(TrieNode root,StringBuilder path,List<String> ans){
        if(root.isEOW){
            ans.add(path.toString()); //no return statement
        }
        for(int i = 0;i < ALPHA_SIZE;i++){
            if(root.children[i] != null){
                char ch =  (char)(i + 'a');
                path.append(ch); //choose
                helper(root.children[i],path,ans); //explore
                path.setLength(path.length()-1);
            }
        }
    }

    boolean insertWordsThroughFile(File f) throws FileNotFoundException {
        Scanner st = new Scanner(f);
        while(st.hasNextLine()){
            String word = st.nextLine();
            //System.out.println(word);
            System.out.println(insertWord(word));
        }
        st.close();
        return true;
    }

    List <String> autoSuggest(String prefix){
        List<String> ans = new ArrayList<>();
        TrieNode temp = root;
        for(char ch:prefix.toCharArray()){
            int idx = ch - 'a';
            if(temp.children[idx] == null){
                return ans;
            }
            temp = temp.children[idx];
        }
        StringBuilder path = new StringBuilder(prefix);
        helper(temp,path,ans);
        return ans;
    }
}
