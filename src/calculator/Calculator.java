package calculator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Calculator {
    private String arithmetic;

    public void buildCalculator() {
        JFrame f = new JFrame("SWING CALCULATOR");

        JLabel n1 = new JLabel("First Number");
        JLabel n2 = new JLabel("Second Number");
        JLabel R = new JLabel("Result");

        JTextField num1 = new JTextField("");
        JTextField num2 = new JTextField("");
        JTextField result = new JTextField("");

        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("x");
        JButton divide = new JButton("/");
        JButton modular = new JButton("%");
        JButton clear = new JButton("CLEAR");

        n1.setVerticalAlignment(SwingConstants.CENTER);
        n2.setVerticalAlignment(SwingConstants.CENTER);
        R.setVerticalAlignment(SwingConstants.CENTER);

        n1.setHorizontalAlignment(SwingConstants.CENTER);
        n2.setHorizontalAlignment(SwingConstants.CENTER);
        R.setHorizontalAlignment(SwingConstants.CENTER);


        n1.setBounds(5, 5, 190, 55);
        n2.setBounds(5, 60, 190, 55);
        R.setBounds(5, 120, 190, 55);

        plus.setBounds(5, 180, 190, 55);
        multiply.setBounds(5, 240, 190, 55);
        modular.setBounds(5, 300, 190, 55);


        num1.setBounds(200, 5, 180, 55);
        num2.setBounds(200, 60, 180, 55);
        result.setBounds(200, 120, 180, 55);

        minus.setBounds(200, 180, 180, 55);
        divide.setBounds(200, 240, 180, 55);
        clear.setBounds(200, 300, 180, 55);

        f.add(n1);
        f.add(n2);
        f.add(R);
        f.add(num1);
        f.add(num2);
        f.add(result);
        f.add(plus);
        f.add(minus);
        f.add(multiply);
        f.add(divide);
        f.add(modular);
        f.add(clear);

        plus.addActionListener(e -> {
            try {
                double input1 = Double.parseDouble(num1.getText());
                double input2 = Double.parseDouble(num2.getText());

                String response = Double.toString(input1 + input2);
                result.setText(response);

            } catch (Exception error) {
                result.setText("Error!");
            }
        });

        minus.addActionListener(e -> {
            try {
                double input1 = Double.parseDouble(num1.getText());
                double input2 = Double.parseDouble(num2.getText());

                String response = Double.toString(input1 - input2);
                result.setText(response);

            } catch (Exception error) {
                result.setText("Error!");
            }
        });

        multiply.addActionListener(e -> {
            try {
                double input1 = Double.parseDouble(num1.getText());
                double input2 = Double.parseDouble(num2.getText());

                String response = Double.toString(input1 * input2);
                result.setText(response);

            } catch (Exception error) {
                result.setText("Error!");
            }
        });

        divide.addActionListener(e -> {
            try {
                double input1 = Double.parseDouble(num1.getText());
                double input2 = Double.parseDouble(num2.getText());

                String response = Double.toString(input1 / input2);
                result.setText(response);

            } catch (Exception error) {
                result.setText("Error!");
            }
        });

        modular.addActionListener(e -> {
            try {
                double input1 = Double.parseDouble(num1.getText());
                double input2 = Double.parseDouble(num2.getText());

                String response = Double.toString(input1 % input2);
                result.setText(response);

            } catch (Exception error) {
                result.setText("Error!");
            }
        });

        clear.addActionListener(e -> {
            arithmetic = "";
            num1.setText("");
            num2.setText("");
            result.setText("");
        });

        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
}