import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class factors {
    public static void factorize(long n) {
        long i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                System.out.println(n + "=" + i + "*" + n / i);
                return;
            }
            i++;
        }
        System.out.println(n + " is a prime number.");
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Factorize input.txt");
            System.exit(1);
        }

        String filePath = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                long num = Long.parseLong(line);
                factorize(num);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            System.exit(1);
        }
    }
}

