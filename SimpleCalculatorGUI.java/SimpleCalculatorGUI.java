import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculatorGUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JTextField inputField;
    private JButton[] buttons;
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    private String operator;
    private double num1, num2, result;

    public SimpleCalculatorGUI() {
        frame = new JFrame("Simple Calculator");
        panel = new JPanel();
        inputField = new JTextField();
        buttons = new JButton[10];
        operator = "";

        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(String.valueOf(i));
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        frame.setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(buttons[1]);
        panel.add(buttons[2]);
        panel.add(buttons[3]);
        panel.add(addButton);
        panel.add(buttons[4]);
        panel.add(buttons[5]);
        panel.add(buttons[6]);
        panel.add(subButton);
        panel.add(buttons[7]);
        panel.add(buttons[8]);
        panel.add(buttons[9]);
        panel.add(mulButton);
        panel.add(clrButton);
        panel.add(buttons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        frame.add(inputField, BorderLayout.NORTH);
        frame.add(panel);

        for (JButton button : buttons) {
            button.addActionListener(this);
        }
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        eqButton.addActionListener(this);
        clrButton.addActionListener(this);

        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9')) {
            inputField.setText(inputField.getText() + command);
        } else if (command.charAt(0) == 'C') {
            inputField.setText("");
            num1 = num2 = result = 0;
            operator = "";
        } else if (command.charAt(0) == '=') {
            num2 = Double.parseDouble(inputField.getText());

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }

            inputField.setText(String.valueOf(result));
            num1 = result;
            operator = "";
        } else {
            if (!operator.isEmpty()) {
                return;
            }
            operator = command;
            num1 = Double.parseDouble(inputField.getText());
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculatorGUI();
    }
}
