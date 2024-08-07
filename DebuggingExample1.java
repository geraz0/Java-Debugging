public class DebuggingExample1 {

    /**
     * Calculates the average of an array of integers.
     */
    public static double calculateAverage(int[] numbers) {
        if (numbers == null) {
            System.out.println("Error: Array is null");
            return -1; // Indicates an error condition clearly
        }

        double sum = 0;
        // Introduce an ArrayIndexOutOfBoundsException by going one index too far
        for (int i = 0; i <= numbers.length; i++) {
            sum += numbers[i];  // Error will occur when i equals numbers.length
        }

        // Introduce a logic error: Incorrectly calculating average
        double average = sum;  // Forgot to divide by numbers.length
        return average;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        try {
            double average = calculateAverage(numbers);
            System.out.println("The calculated average is: " + average);  // Incorrect output expected
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an array index out-of-bounds exception. Fixing the issue.");
            // Fix the loop to correctly iterate over the array elements
            double correctAverage = calculateAverageFixed(numbers);
            System.out.println("Corrected average is: " + correctAverage);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

        // Test with a null array to trigger null pointer handling
        double average = calculateAverage(null);
        System.out.println("Average for null array is: " + average);
    }

    // Fixed method to calculate average correctly
    public static double calculateAverageFixed(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.length;  // Correct calculation
    }
}
