package c17_Hard;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TemplateEmpty {
    public static class Node {
        private char val;
        private HashMap<Character, Node> children = new HashMap();

        public Node() {
        }

        public Node(char val) {
            this.val = val;
        }

        public boolean containsChild(Character c) {
            return children.containsKey(c);
        }

        public Node getChild(Character c) {
            return children.get(c);
        }

        public Node addChild(Character c, Node n) {
            return children.put(c, n);
        }

        public void setVal(char val) {
            this.val = val;
        }

        public char getVal() {
            return this.val;
        }
    }



    public String longestWord(ArrayList<String> words) {
        ArrayList lowerCaseWordsSorted = initialize(words);
        Node head = new Node('.');
        int max = 0 ;
        String maxString = "";
        for (String word : words) {
          if(isMadeOfSubWords(word,head,true)){
              if(word.length()>max){
                  max = word.length();
                  maxString = word;
              }
          }
        }
        return maxString;
    }

    public boolean isMadeOfSubWords(String s, Node head, boolean searching) {
        Node current = head;
        char[] wordAsCharArray = s.toCharArray();
        for (int i = 0; i < wordAsCharArray.length; i++) {
            if(current.containsChild('.')){
                if (i == wordAsCharArray.length - 1) {
                    return true;
                } else {
                    if(isMadeOfSubWords(s.substring(i ), head, true)){
                        return true;
                    }else {
                        finishAddingWholeWord(s.substring(i),current);
                        return false;
                    }
                }
            }
            if (current.containsChild(wordAsCharArray[i])) {
                current = current.getChild(wordAsCharArray[i]);
                if(searching){
                    continue;
                }
            }else if(!searching){
                finishAddingWholeWord(s.substring(i),current);
            }
        }//end for
        return false;
    }


    public void finishAddingWholeWord(String s, Node head) {
        char c = s.charAt(0);
        Node newChild = new Node(c);
        head.addChild(c, newChild);
        if (s.length() == 1) {
            Node eow = new Node('.');
            newChild.addChild('.', eow);
        } else {
            finishAddingWholeWord(s.substring(1), newChild);
        }
    }

    public ArrayList<String> initialize(ArrayList<String> words){
        ArrayList lowerCaseWordsSorted = new ArrayList();
        for(int i = 0; i<words.size();i++){
            lowerCaseWordsSorted.add(words.get(i).toLowerCase());
        }
        Collections.sort(lowerCaseWordsSorted);
        return lowerCaseWordsSorted;
    }
//no words
    //one word
    //no words made of other words
    //one word made of multiple words
    //multiple words made of other words


    @Test
    public void test() {
        String expected = "dogwalker";
        ArrayList<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("nana");
        words.add("walk");
        words.add( "walker");
        words.add("dogwalker");
        String actual = longestWord(words);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TemplateEmpty.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}