public class Main{
    public static void main(String[] args)
    {
        Node ex = new Node();
        System.out.println(ex.get_count());
        Node ex2 = new Node('a');
        System.out.println(ex2.get_count());



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
        {head=null;System.out.println(1);}

    //Add a letter & update count
    public void Add(char letter){
        System.out.println(1);
        //if list is empty
        if(head == null)
            head = new Node(letter);
        else
            Add(letter, head);
    }
    //recursively add letter & update count
    protected void Add(char letter, Node current)
    {
        //Letter is unique - create new entry
        if(current.Get_Next() == null)
        {
            Node temp = new Node(letter);
            current.Set_Next(temp); 
        }
        else
        {
            //Check if letter matches - not unique
            if(current.check_letter(letter)){
                current.add_count();
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
        Node current = head;
        while(current != null)
        {
            //is there something larger than the largest?
            if(largest <  current.get_count())
                largest = current.get_count();
            current.Get_Next();
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