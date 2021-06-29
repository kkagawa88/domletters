import java.io.*;
import java.util.Scanner;

public class Main{
    private static Scanner input;    
    public static void main(String[] args) throws IOException 
    {
        int count=0;
        //https://stackoverflow.com/questions/40822533/input-a-text-file-through-command-line-in-java
        //&& https://stackoverflow.com/questions/14169661/read-complete-file-without-using-loop-in-java
        String str;

        if(args.length == 0) {
            System.out.println("File name not specified.");
            System.exit(1);
        }
        try {
            File file = new File(args[0]);
            input = new Scanner(file);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            str = new String(data, "UTF-8");

            //https://www.jackrutorial.com/2018/06/java-split-string-by-space-and-newline.html
            String[] words = str.split("\\s+");
            for(String word : words) {
                count+=domcount(word);
            }
        } 
        catch (IOException ioException) 
        {
            System.err.println("Cannot open file.");
            System.exit(1);
        }

        System.err.println(count);

    }

    //domminant count 
    public static int domcount(String word) 
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