/*
 * Use an ArrayList<Double> to hold Golf scores. Then compute average score
 * and compute the difference of each score from the average.
 */
import java.util.*;

public class GolfScores {
	/**
	 * Shows differences between each of a list of golf scores and their
	 * average.
	 */
	public static void main(String[] args) {
		ArrayList<Double> score = new ArrayList<Double>();

		System.out.println("This program reads golf scores and shows");
		System.out.println("how much each differs from the average.");

		System.out.println("Enter golf scores:");
		fillArrayList(score);
		showDifference(score);
	}

	/**
	 * Reads values into the ArrayList a.
	 */
	public static void fillArrayList(ArrayList<Double> a) {
		System.out.println("Enter a list of nonnegative numbers.");
		System.out.println("Mark the end of the list with a negative number.");
		Scanner keyboard = new Scanner(System.in);

		double next;
	
		next = keyboard.nextDouble();
		while (next >= 0) {
			a.add(next);
			next = keyboard.nextDouble();
		}
	}

	/**
	 * Returns the average of numbers in a.
	 */
	public static double computeAverage(ArrayList<Double> a) {
		double total = 0;
		for (Double element : a)
			total = total + element;

		int numberOfScores = a.size();
		if (numberOfScores > 0) {
			return (total / numberOfScores);
		} else {
			System.out.println("ERROR: Trying to average 0 numbers.");
			System.out.println("computeAverage returns 0.");
			return 0;
		}
	}

	/**
	 * Gives screen output showing how much each of the elements in a differ
	 * from their average.
	 */
	public static void showDifference(ArrayList<Double> a) {
		double average = computeAverage(a);
		System.out.printf("Average of the %d scores = %.2f%n", a.size(), average);
		System.out.println("The scores are:");
		for (Double element : a)
			System.out.printf("%.2f differs from average by %.2f%n", element,
					 (element - average));
	}
}
