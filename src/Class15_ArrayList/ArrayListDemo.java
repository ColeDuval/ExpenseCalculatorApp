/*ArrayList example. Read in a list of items from console.
 * Prevent duplicates. Print the list when blank line is input.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
	public static void main(String[] args) {

		// create ArrayList with base class String and initial capacity 20
		ArrayList<String> toDoList = new ArrayList<String>(20);

		System.out.println("Enter list entries, when prompted.");
		boolean done = false;
		String next = null;
		Scanner keyboard = new Scanner(System.in);

		// user inputs list items, prevent duplicates in ArrayList
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

		// print out list contents
		System.out.println("The list contains:");
		for (int i = 0; i < toDoList.size(); i++)
			System.out.println(toDoList.get(i));
	}
}
