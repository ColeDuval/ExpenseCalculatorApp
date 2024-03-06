/* Another ArrayList demo */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo2 {
	public static void main(String[] args) {
		
		//create ArrayList with base class String and initial capacity 20
		ArrayList<String> toDoList = new ArrayList<String>(20);
		
		System.out.println("Enter list entries, when prompted.");
		boolean done = false;
		String next = null;
		Scanner keyboard = new Scanner(System.in);

		//user inputs list items
		while (!done) {
			System.out.println("Input an entry:");
			next = keyboard.nextLine();
			//end loop if empty string
			if((next.isEmpty())) done = true;
			else if (toDoList.contains(next))
				System.out.println("Duplicate - try again");
			else
				toDoList.add(next);
		}
		
		//print size of list
		int size = toDoList.size();
		System.out.println("The list contains " + size + " elements.");
		
		//remove last element from list
		if (size > 0) toDoList.remove(size-1);
		
		//add new element to start of list
		toDoList.add(0, "Touchdown");

		System.out.println("The list contains:");
		
		//print out list contents
		for (int i = 0; i < toDoList.size(); i++) 
			System.out.println(toDoList.get(i));
		
		//print out list contents, use for-each statement
		for (String entry : toDoList)
			System.out.println(entry);
	}
}
