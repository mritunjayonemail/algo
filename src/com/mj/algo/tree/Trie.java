package com.mj.algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mj.algo.tree.modal.TrieNode;

/*
 * Implementation of Trie data structure
 */
public class Trie {
	
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode(' ');
	}
	
	public boolean search(String word){
		TrieNode current = root; 
		if(word==null){
			return false;
		}
		for(char ch: word.toCharArray()){
			 if (current.subNode(ch) == null){
	               return false;
			 }
	         else {
	               current = current.subNode(ch);
	         }
		}
		if(current.isEnd()){
			return true;
		}
		return false;
	}
	
	public void insert(String word){
		if(word==null){
			return;
		}
		if(search(word)){
			return;
		}
		TrieNode current = root; 
		for(char ch: word.toCharArray()){
			TrieNode child = current.subNode(ch);
			 if (child == null){
				 List<TrieNode> childList = new ArrayList<TrieNode>();
				 TrieNode newChild = new TrieNode(ch);
				 childList.add(newChild);
				 current.setChildList(childList);
				 current = current.subNode(ch);
			 }
			 else {
				 current = child;
			 }
			 current.setCount(current.getCount()+1);
		}
		current.setEnd(true);
	}
	
	   /* Function to remove a word */
    public void remove(String word)
    {
    	if(word==null){
			return;
		}
        if (search(word) == false)
        {
            System.out.println(word +" does not exist in trie\n");
            return;
        }             
        TrieNode current = root;
        for (char ch : word.toCharArray()) 
        { 
            TrieNode child = current.subNode(ch);
            if (child.getCount() == 1) 
            {
                current.getChildList().remove(child);
                return;
            } 
            else 
            {
                child.setCount(child.getCount()-1);
                current = child;
            }
        }
        current.setEnd(false);
    }
    
    public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in);
        /* Creating object of AATree */
        Trie t = new Trie(); 
        System.out.println("Trie Test\n");          
        char ch;
        /*  Perform tree operations  */
        do    
        {
            System.out.println("\nTrie Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete");
            System.out.println("3. search");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter string element to insert");
                t.insert( scan.next() );                     
                break;                          
            case 2 : 
                System.out.println("Enter string element to delete");
                try
                {
                    t.remove( scan.next() ); 
                }                    
                catch (Exception e)
                {
                    System.out.println(e.getMessage()+" not found ");
                }
                break;                         
            case 3 : 
                System.out.println("Enter string element to search");
                System.out.println("Search result : "+ t.search( scan.next() ));
                break;                                          
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }

}
