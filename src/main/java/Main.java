import java.io.*;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("operations.txt");
        Scanner scan;
        try {
            scan = new Scanner(file);
        } catch (IOException e) {
            throw new IOException(e);
        }
        StringBuilder fileToWrite = new StringBuilder();
        while (scan.hasNextLine()) {
            int firstInput = scan.nextInt();
            String operator = scan.next();
            int secondInput = scan.nextInt();
            String expression = getExpression(firstInput, operator, secondInput);
            fileToWrite.append(expression).append("\n");
        }
        String file2 = fileToWrite.toString();
        printAndWrite(file2);
        scan.close();
    }

    public static String getExpression(int firInput, String operator, int secInput) {
        String expression = firInput + " " + operator + " " + secInput + " = ";
        if (Objects.equals(operator, "*")) {
            expression += " " + (firInput * secInput);
        } else if (Objects.equals(operator, "+")) {
            expression += " " + (firInput + secInput);
        } else if (Objects.equals(operator, "-")) {
            expression += " " + (firInput - secInput);
        } else {
            expression += " " + ((double) firInput / secInput);
        }
        return expression;
    }

    public static void printAndWrite(String file) throws IOException {
        FileWriter fileWriter;
        BufferedWriter writer;
        try {
            fileWriter = new FileWriter("results.txt");
            writer = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            throw new IOException(e);
        }
        System.out.println(file);
        writer.write(file);
        writer.close();
    }
}