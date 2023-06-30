import java.util.HashSet;

public class UncommonNumbersSum {
    public static int getSingleDigitSum(int[] input1, int[] input2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Add unique elements from input1 to set1
        for (int num : input1) {
            if (!set2.contains(num)) {
                set1.add(num);
            }
        }

        // Add unique elements from input2 to set2
        for (int num : input2) {
            if (!set1.contains(num)) {
                set2.add(num);
            }
        }

        int sum1 = 0, sum2 = 0;

        // Calculate sum1
        for (int num : set1) {
            sum1 += num;
        }

        // Calculate sum2
        for (int num : set2) {
            sum2 += num;
        }

        int finalSum = sum1 + sum2;

        // Calculate single digit sum
        while (finalSum > 9) {
            int digitSum = 0;
            while (finalSum > 0) {
                digitSum += finalSum % 10;
                finalSum /= 10;
            }
            finalSum = digitSum;
        }

        return finalSum;
    }

    public static void main(String[] args) {
        int[] input1 = {123, 45, 7890, 67, 2, 90};
        int[] input2 = {45, 7890, 123};
        System.out.println(getSingleDigitSum(input1, input2));  // Output: 6

        int[] input3 = {6, 7, 12, 70, 44};
        int[] input4 = {8, 6, 70, 44};
        System.out.println(getSingleDigitSum(input3, input4));  // Output: 9
    }
}
