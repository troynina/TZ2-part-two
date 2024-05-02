//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static long _min(long[] numbers) {
        long min = numbers[0];
        for (long number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public static long _max(long[] numbers) {
        long max = numbers[0];
        for (long number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static String _sum(long[] numbers) {
        BigInteger int1 = new BigInteger("0");
        BigInteger int2;
        for (long number : numbers) {
            int2 = new BigInteger(String.valueOf(number));

            int1 = int1.add(int2);
        }
        return String.valueOf(int1);
    }

    public static String _mult(long[] numbers) {
        BigInteger int1 = new BigInteger("1");
        BigInteger int2;
        for (long number : numbers) {
            int2 = new BigInteger(String.valueOf(number));

            int1 = int1.multiply(int2);
        }
        return String.valueOf(int1);
    }
    public static String _even(long[] numbers) {
        BigInteger int1 = new BigInteger("0");
        for (long number : numbers) {
            if (number % 2 == 0) {
                int1 = int1.add(BigInteger.valueOf(1));
            }
        }
        return String.valueOf(int1);
    }

    public static long[] read_File(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        String[] tokens = line.split(" ");
        long[] numbers = new long[tokens.length];
        for (int i = 0; i < tokens.length; ++i) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        reader.close();
        return numbers;
    }

    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        long[] numbers = read_File(filePath);
        System.out.println("Количество чисел: " + numbers.length);
        System.out.println("Минимальное: " + _min(numbers));
        System.out.println("Максимальное: " + _max(numbers));
        System.out.println("Сумма: " + _sum(numbers));
        System.out.println("Произведение: " + _mult(numbers));
        System.out.println("Количество чётных чисел " + _even(numbers));

    }
}