/*
Trevor Applegate 2/9/2020
CSC 501 001
Linked List Class with a fake header Node
Has methods to create new Nodes, add Nodes to the end of the list, remove Nodes from the end of the list,
insert a Node at a specific index, insert a Node after a specific value, remove a Node at a specific index, 
remove a Node containing a specific value, print the list, print the list reversed, duplicate the list, 
check if the list is empty, get the length of the list.
 */

import java.lang.*;

public class LinkedList {
    private  Node head = new Node();//Node to point to hold the head of list
    private  Node tail= new Node(); //Node to point to the tail of list
    private  int length=0;     

        //default constructor
        public void LinkedList(){  
            head = null;
            tail = null;

            }
    
        //adds an int to the end of the list by creating a new node with passed
        //int data
        public void add(int intData)
        {
            Node curNode = new Node(intData);
            if(length==0){
                head.setNext(curNode);
                
            }             
            
            tail.setNext(curNode);
                        
            setTail(curNode);
            
            incrimentLength();
            
        }//end append int
        
        //append a new node to the list
        public void add(Node nodeToInsert)
        {
            if(length==0){
                head.setNext(nodeToInsert);
                
            }             
            
            tail.setNext(nodeToInsert);
                        
            setTail(nodeToInsert);
            
            incrimentLength();
            
        }//end append Node
        
        //inserts an item at a specific index in the list by inserting a passed node
        public void add(int index, Node nodeToInsert)
        {
             Node current = head;//start at the head Node
             
             //check to see if list is long enough to insert item.
             if(length < index)
             {
                 System.out.println("Unable to insert after " + index + ", list only contains " + length + " items.");//oputput statement if list is too short
                 
             }
             else
             { 

                for(int i=1;i<index+1;i++)//iterate through the list to find inxes to insert after
                {         
                    current=current.getNext();//incriment to next Node                 
                    if(i==index)//if index position found
                    {
                        nodeToInsert.setNext(current.getNext());//set pointer of new Node to current Nodes next Node
                        current.setNext(nodeToInsert);//set current Nodes pointer to new Node
                        incrimentLength();

                    }//end of if statement
                }//end of for loop 
             }
             
        }//end of add(index, node)
        
        //insert an int at an index by creating a new node
        public void add(int index, int intToInsert)
        {
             Node current = head;//start at the head Node
             
             Node nodeToInsert = new Node(intToInsert);
             
             //check to see if list is long enough to insert item.
             if(length < index)
             {
                 System.out.println("Unable to insert after " + index + ", list only contains " + length + " items.");//oputput statement if list is too short
                 
             }
             else
             { 

                for(int i=0;i<index+1;i++)//iterate through the list to find inxes to insert after
                {         
                                     
                    if(i==index)//if index position found
                    {
                        nodeToInsert.setNext(current.getNext());//set pointer of new Node to current Nodes next Node
                        current.setNext(nodeToInsert);//set current Nodes pointer to new Node
                        incrimentLength();

                    }//end of if statement
                    current=current.getNext();//incriment to next Node
                }//end of for loop 
             }
             
        }//end of insertAtIndex
        
        
        
        //removes the last Node
        public void removeEnd()
        {
            //if list is not empty            
            if(length>0){    
                Node current = new Node();
                current = head;
                while(current.getNext() != tail)//search through the list to find Node before tail
                {
                    current = current.getNext();                
                }
                tail=current;//move tail to current
                current.setNext(null);//remove former tail Node
                decrimentLength();//update length
            }
            //else list is empty, output error
            else{
                System.out.println("Can not remove from an empty list");
            }
        }// end removeEnd()
        
        //sets the tail Node
        private void setTail(Node newNode)
        {
            this.tail = newNode;
        }//end setTail
        
        //increase length
        private void incrimentLength()
        {
            length++;
        }//end incrimentLength()
        
        private void decrimentLength()
        {
            length--;
        }//end decrimentLength
        
        //returns tail
        public int getTail()
        {
            return tail.getData();        
        }//end getTail
        
        
        //checks for an empty list
        public boolean isEmpty()
        {
            if(length==0)//if the head and tail Node are the same then list is empty
            {
                return true;
            }
            
            return false;//otherwise return false, list is not empty
        }//end of isEmpty()
        
        //gets the size of the list
        public int size()
        {
            return length;//return length of list
        }//end getSize()
        
        
        
        //insert a Node after an int in the list
        //returns true if the keyToInsertAfter is found in the list, false
        //if keyToInsertAfter is not found in the list
        public boolean insertNode(int keyToInsertAfter, int dataToInsert)
        {
            Node current = head;//start at the head Node
            
            //while loop to search through the list for the keyToInsertAfter
            while(current.getNext() != null)
            {
                if(current.getData() == keyToInsertAfter)//if current Node is the keyToInsertAfter, insert the Node
                {
                    Node NodeToInsert = new Node(dataToInsert);//create the Node to insert
                    
                    NodeToInsert.setNext(current.getNext());//set the new Nodes next pointer to current Nodes next pointer
                    
                    current.setNext(NodeToInsert);//set the current Nodes next pointer to the new Node
                                       
                    incrimentLength();// increase the length of the list
                    
                    return true;                    
                }
                current=current.getNext();  // if current Node does not contain the key, move to next Node.              
            }//end while loop to look for 
            
            //
            System.out.println("Item not found in list");
            return false;
        }//end insertNode
        
        
        //removes a specific node
        public void remove(Node nodeToRemove)
        {
            Node current = head;//start at the head Node
            
            //while loop to search through the list for the keyToInsertAfter
            while(current.getNext() != null)
            {
                if(current.getNext().getData() == nodeToRemove.getData())//if the next node is the node to remove
                {
                   if(current.getNext()==tail)//if removing the tail node
                   {
                       tail=current;
                       current.setNext(null);
                   }//end if removing the tail
                   current.setNext(current.getNext().getNext());//remove item from list
                   decrimentLength();//decriment list length
                                       
                }//end of if node is found
                current=current.getNext();  // if current Node does not contain the key, move to next Node.              
            }//end while loop to look for key to remove
                        
        }//end removeNode
        
        //removes a specific int
        public void removeInt(int intToRemove)
        {
            Node current = head;//start at the head Node
            
            for(int i=0;i<length;i++)
            {
                if(current.getNext().getData() == intToRemove)//if the next node is the node to remove
                {
                    if(current.getNext()==tail)//if removing the tail node
                    {                      
                        tail=current;
                        current.setNext(null);
                    }
                    else
                    {
                        current.setNext(current.getNext().getNext());//remove item from list                        
                    }
                    decrimentLength();//decriment list length                      
                }//end of if statement removing the int
                current=current.getNext();  //  move to next Node.
                
            }//end for loop searching for the int to remove           
           
        }//end removeInt given a specific int
        
        
        //remove an item at a specific index
        public boolean remove(int index)
        {
             Node current = head;//start at the head Node
             
             //check to see if list is long enough to remove item.
             if(length < index)
             {
                 System.out.println("Unable to remove after " + index + ", list only contains " + length + " items.");//oputput statement if list is too short
                 return false;
             }
             
             
             for(int i=0;i<index+1;i++)//iterate through the list to find index to remove after
             {        
                 
                 if(i==index)//if index position found
                 {
                     if(current.getNext()==tail)
                     {
                         tail=current;
                     }
                     
                     
                     if(current.getNext().getNext()==tail)
                     {
                         tail=current.getNext();
                     }
                     current.setNext(current.getNext().getNext());
                     
                     
                     decrimentLength();//decriment list length
                     
                     return true;
                     
                 }//end of if statement
                 current=current.getNext();//incriment to next Node 
             }//end of for loop     
             
             return false;// shouldnt get here but if something goes wrong and you do return false
        }//end of removeAtIndex
        
        //print the list as a string
        public String printList()
        {
            String printList = new String();// create a new string to hold the list
            
            printList += "List Length is " + length + " and includes items: "; // adds the length of the list to the beginning of the output statement
            
            if(head.getNext() != null) // checks for empty list
            {
                Node current = head.getNext();// set current equal to Node after head
                
                while(current != null)//keeps going through the list until a null value is hit
                {
                printList = printList + current.getData() + ", ";//adds the data of current to the output list
                current = current.getNext();//moves current to the next data Node
                }  
                return printList;//returns the finished output statement
            }  
            return "This list is empty";//returns if the list is empty
            
        }// end of print list method  
        
        //method for duplicating the linked list
        public LinkedList duplicate()
        {
            LinkedList newList= new LinkedList();//create a new list
            
            Node currentNode = new Node();//create a new node to track current node
            
            currentNode = head.getNext();//start at head hode
            
            while(currentNode!=null)
            {
                newList.add(currentNode);  
                currentNode=currentNode.getNext();
            }
            return newList;
        }//end duplicate()
        
        //method to duplicate the list in reverse
        public LinkedList duplicateReversed()
        {
            LinkedList revList = new LinkedList();
            
            Node current = new Node();           

            current=head;
                    
            int appendData;
            
            for(int i=length;i>0;i--)
            {
                current=head;
                for(int x=0;x<i;x++)
                {
                    current=current.getNext();                    
                }
                revList.add(current.getData());                
            }
            
            return revList;
        }//end duplicateReversed()
    

    
    
     public static void main(String args[])
            {
              LinkedList list = new LinkedList();//create the new linked list
              String toPrint = new String();//create a string for outputting the whole list
              int data;//create an int to add to or return from the list
               
              System.out.println("Appending 12 to the list");
              
              list.add(12);//add 12 to the empty list
              
              System.out.println("Getting the end of the list");
               
              data = list.getTail();//get the tail of the list
               
              System.out.println(data);  //output the tail          
                    
              toPrint = list.printList();//get the whole list
              
              System.out.println(toPrint);//print the whole list  
              
              //repeating the above for 13
              System.out.println("Appending 13 to the list");
              
              list.add(13);//add 13 after 12 in the list
               
              data = list.getTail();//get the tail, now 13
               
              System.out.println(data);//output the tail
              
              toPrint = list.printList();//get the whole list
              
              System.out.println(toPrint);//print the whole list
              
              
              //repeating again for 14
              
              System.out.println("Appending 14 to the list");
              
              list.add(14);//add 14 after 13 in the list              
              
              data = list.getTail();//get the tail, now 14
               
              System.out.println(data);//output the tail
              
              toPrint = list.printList();//get the whole list
              
              System.out.println(toPrint);//print the whole list
              
              
              list.insertNode(13, 10);//insert 10 after 13
              System.out.println("Inserting 10 after 13 in the list");
              
              toPrint = list.printList();//get the whole list
              
              System.out.println(toPrint);//print the whole list           
            
              System.out.println("Inserting 8 after 10 in the list");
              list.insertNode(10, 8);//insert 8 after 10
              
              toPrint = list.printList();//get the whole list
              
              System.out.println(toPrint);//print the whole list  
              
              System.out.println("Attempting to insert 11 after 7, fails because 7 is not in the list");
              list.insertNode(7, 11);//attempt to insert 11 after 7 and fail, 7 not in the list
              
              toPrint = list.printList();//get the whole list
              
              System.out.println(toPrint);//print the whole list
              
              
              System.out.println("Inserting 15 at index 0 in the list");
              list.add(0,15);//insert 15 at index 0       
              
              
              toPrint = list.printList();
              
              System.out.println(toPrint);
              
              System.out.println("Removing item at inxed 1");
              
              list.remove(1); //remove index 1    
              
              toPrint = list.printList();
              
              System.out.println(toPrint);
              
              System.out.println("Removing int 14");//remove 14 from the list
              
              list.removeInt(14);    
              
              toPrint = list.printList();
              
              System.out.println(toPrint);
              
              
              
              System.out.println("Creating a node with value 10 then removeing corresponding node from the list");//remove 14 from the list
              Node removeNode = new Node(10);
              
              list.remove(removeNode);
              
              
              
              LinkedList dupeList = new LinkedList();//duplivate the list              
              
              dupeList = list.duplicate();              
              
              System.out.println("Duplicating the list");
              
              
              String dupePrint = new String();
              dupePrint = dupeList.printList();
              
              System.out.println(dupePrint);
              
              System.out.println("Adding 77 to the end of the duplicate list");
              dupeList.add(77);
              
              dupePrint = dupeList.printList();
              
              
              System.out.println(dupePrint); 
              
              
              System.out.println("Outputting the origional list");
              
              toPrint = list.printList();
              System.out.println(toPrint);
              
              
              System.out.println("Duplicating and reversing the first list");
              LinkedList revList = new LinkedList();   
              
              revList = list.duplicateReversed();
              
              String revPrint = new String();
              revPrint = revList.printList();
              
              System.out.println(revPrint);
              
              System.out.println("Adding 77 at index 1 in the reversed list");
              revList.add(1,77);
              
              revPrint = revList.printList();
              
              System.out.println(revPrint);
                
              
                           
              
              
            }
}
