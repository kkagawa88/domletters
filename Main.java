import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException 
    {
        /*
         // first check to see if the program was run with the command line argument
        if(args.length < 1) {
            System.out.println("Error, usage: java ClassName inputfile");
            System.exit(1);
        }
        
        Scanner reader = new Scanner(new FileInputStream(args[0]));
        String content = reader.toString();
        reader.close();

        */

        
        String sentences = new String("The bookkeeper and the beekeeper Giggled greatly. They were in unacrimonious union.");
        domcount(sentences);

        System.out.println(sentences);
        String[] words = sentences.split("\\s+");
        for(String word : words) {
            System.out.println(word);
        }
    }
  
    public static int domcount(String sentences)
    {
        int count = 0;
        /*******************NOT MY WORK********************* */
        //can be found at: https://stackoverflow.com/questions/4674850/converting-a-sentence-string-to-a-string-array-of-words-in-java

        /*************************************************** */
        /*
        for(int i=0; i < words.length; ++i)
            {count+=domcount(words[i]);}
        */
        return count;
    }

    //domminant count 
    public static int domcount_word(String word) 
    {
        LinkedList domminant = new LinkedList();
        
        //Count all letters
        for(int i = 0; i < word.length(); i++)
            {domminant.Add(word.charAt(i));}

        //Find the letter with the most occurances
        return domminant.largest();
    }
}

class LinkedList{
    protected Node head;

    LinkedList()
        {this.head=null;}

    //Add a letter & update count
    public void Add(char letter){
        //if list is empty
        if(this.head == null)
            this.head = new Node(letter);
        else
            Add(letter, this.head);
    }
    //recursively add letter & update count
    protected void Add(char letter, Node current)
    {
        //Check if letter matches - not unique
        if(current.check_letter(letter)){
            current.add_count();
        }
        else
        {
            //Letter is unique - create new entry
            if(current.Get_Next() == null)
            {
                Node temp = new Node(letter);
                current.Set_Next(temp); 
            }
            //continue searching
            else
                Add(letter, current.Get_Next());
        }        

        return;
    }
    //find largest count
    protected int largest()
    {
        int largest = 0;
        Node current = this.head;
        while(current != null)
        {
            //is there something larger than the largest?
            if(largest <  current.get_count())
                largest = current.get_count();
            current = current.Get_Next();
        }
        return largest;
    }
}

//A unique letter and its corrsponding count
class Node{
    private static final char A = 0;
    protected char letter;
    protected int count;
    protected Node next;
    
    public Node() {
        this.count=0;
        this.letter= A;
        this.next = null;
    }   
    public Node(char c) {
        this.count=1;
        this.letter= c;
        this.next = null;
    }
    public boolean check_letter(char match){
        return match == this.letter;
    }
    public int get_count(){
        return this.count;
    }
    public void add_count(){
        this.count+=1;
    }
    public void Set_Next(Node next) {
        this.next = next;
    }     
    public Node Get_Next() {
        return this.next;
    }   
}