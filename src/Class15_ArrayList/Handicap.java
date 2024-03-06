/*
 * Use an ArrayList of Score objects to hold Golf scores. Then compute average score
 * and compute the difference of each score from the average.
 * Try this example as is, then make Score and inner class, then a private inner class.
 * Inner classes are used for purposes of the outer class.
 */
 
import java.util.*;

public class Handicap {
	/**
	 * Shows differences between each of a list of golf scores and their
	 * average.
	 */
	public static void main(String[] args) {
		ArrayList<Score> score = new ArrayList<Score>();

		System.out.println("This program reads golf scores and shows");
		System.out.println("how much each differs from the average.");

		System.out.println("Enter golf scores:");
		fillArrayList(score);
		showDifference(score);
	}

	/**
	 * Reads values into the ArrayList a.
	 */
	public static void fillArrayList(ArrayList<Score> a) {
				
		Scanner keyboard = new Scanner(System.in);

		int score, handicap;

		//Let's set up this loop differently from the last example
		while (true) {
			System.out.println("Enter score and handicap. Negative number ends list");
			score = keyboard.nextInt();
			if (score < 0)
				break;
			handicap = keyboard.nextInt();

			Score scoreObj = new Score(score, handicap);
			a.add(scoreObj);
		}
	}

	/**
	 * Returns the average of numbers in a.
	 */
	public static double computeAverage(ArrayList<Score> a) {
		double total = 0;
		for (Score element : a)
			total = total + element.getScore();

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
	public static void showDifference(ArrayList<Score> a) {
		double average = computeAverage(a);
		System.out.printf("Average of the %d scores = %.2f%n", a.size(), average);
		System.out.println("The scores are:");
		for (Score element : a)			
			System.out.printf("%3d differs from average by %3.2f%n", element.getScore(),
					element.getScore()-average);
	}
}
