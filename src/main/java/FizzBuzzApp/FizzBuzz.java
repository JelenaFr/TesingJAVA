package FizzBuzzApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FizzBuzz {

    public static String fizzBuzz(int input) {
        boolean multipleOfThree = ((input % 3) == 0);
        boolean multipleOfFive = ((input % 5) == 0);

        if (multipleOfThree && multipleOfFive) {
            return "FizzBuzz";
        }
        else if (multipleOfThree) {
            return "Fizz";
        }
        else if (multipleOfFive) {
            return "Buzz";
        }
        return String.valueOf(input);
    }

    public static String buildOutput(int input) {
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= input; i++) {
            output.append(fizzBuzz(i));

            if (i < input) {
                output.append(", ");
            }
        }

        return output.toString();
    }

    public static final void main(String[] args) throws Exception {
        System.out.println("Fizz buzz is a game for children to teach them about division.");
        System.out.println("Please input some number");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine().trim());
        fizzBuzz(input);
        bufferedReader.close();
        System.out.println(buildOutput(input));
    }
}
