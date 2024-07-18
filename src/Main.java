import calculator.Calculator;
import swing.CustomerTable;

public class Main {
    public static void main(String[] args) {
//        Calculator calc = new Calculator();
//        calc.buildCalculator();

        try {
            CustomerTable customerTable = new CustomerTable();
            customerTable.select();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}