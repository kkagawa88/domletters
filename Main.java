public class Main{
    public static void main(String[] args)
    {
        LinkedList ex3 = new LinkedList();
        ex3.Add('a');
        ex3.Add('a');
        ex3.Add('a');
        ex3.Add('a');
        ex3.Add('b');
        ex3.Add('b');
        ex3.Add('c');
        ex3.Add('c');
        ex3.Add('c');
        ex3.Add('c');
        ex3.Add('c');
        ex3.Add('c');
        System.out.println(ex3.largest());


        //String word="Feedme";
        //System.out.println(domcount(word));
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
    public void display(){
        Node current =this.head;
        while(current != null)
        {

        }
    }

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