/*
Trevor Applegate
3/3/2020
CSC 501 Advanced Data Structures
Assignment 2 module 6
class Node

Node Class used in MyLinkedList, MyStack, and MyQueue classes

Creates a node with int data and points to next node

Has methods for creating an empty node, a node with data, setting next node, 
setting data, getting data, and getting next
 */
 public class Node
    {
        private int data;//holds the node data
        private Node next;//points to next node
    
        //construct new node
        public Node(int data)
        {
            this.data = data; //sets node data to passed data
            this.next = null; //starts next out as null, will be set when inserted into list
        }
        
        public Node()
        {
            this.data=0;
            this.next=null;
        }
        
        //set the next node
        public void setNext(Node next)
        {
           this.next = next;
        }//end setnext
        
        public int getData()
        {
            return this.data;
        }
        
        //get next node
        public Node getNext()
        {
            return this.next;           
        }//end get next node
        
        //change data in a node
        public void setData(int data)
        {
            this.data = data;
        }//end setData


    }// end of node class