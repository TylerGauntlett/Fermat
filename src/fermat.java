
// Name: Tyler Gauntlett
// Date: 2/18/2017
// Course: Problem Solving and Team Dynamics
// Professor: Arup Guha

import java.util.Arrays;
import java.util.Scanner;

public class fermat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int leftBound = sc.nextInt();
		int rightBound = sc.nextInt();

		while (leftBound != -1 && rightBound != -1) {

			// Read input into solve function where values where
			// the upper and lower bound are used to calculate
			// prime and sum of square occurrence.
			int[] result = solve(leftBound, rightBound);

			System.out.println(leftBound + " " + rightBound + " " + result[0] + " " + result[1]);

			// Read next line of input.
			leftBound = sc.nextInt();
			rightBound = sc.nextInt();
		}

		sc.close();
	}

	public static int[] solve(int leftBound, int rightBound) {
		// Run sieve of eratosthenes over array of size rightBound
		boolean[] primeArray = primeSieve(rightBound);

		// Stores the output array of the form
		// [prime count][sum of squares count]
		int[] output = new int[2];

		// Store the total prime numbers
		output[0] = 0;
		// Store the prime numbers that can be expressed as a sum of squares
		output[1] = 0;

		for (int i = leftBound; i < primeArray.length; i++) {
			if (primeArray[i]) {
				// Increment prime number counter.
				output[0]++;

				// Only use odd numbers, except for 2 which is treated
				// as a special case. Apply Fermat's theorem and evaluate.
				if ((i % 2 != 0 || i == 2) && isSumOfSquares(i))
					// increment the sum of squares counter.
					output[1]++;
			}
		}

		return output;
	}

	public static boolean[] primeSieve(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i * i <= n; i++)
			for (int j = 2 * i; j <= n; j += i)
				isPrime[j] = false;
		return isPrime;
	}

	public static boolean isSumOfSquares(int input) {
		// Fermat's theorem
		if ((input - 1) % 4 == 0 || (input - 1) % 4 == 1)
			return true;

		return false;
	}
}
