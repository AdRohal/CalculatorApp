import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private static JFrame frame;

    private static JTextField field;

    String s0, s1, s2;

    Calculator() {
        s0 = s1 = s2 = "";
    }

    // main function
    public static void main(String args[]) {
        frame = new JFrame("calculator");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        Calculator c = new Calculator();

        field = new JTextField(16);
        field.setFont(new Font("Arial", Font.PLAIN, 50));

        JButton zero, one, two, three, four, five, six, seven, eight, nine, eq, div, mul, sub, add;
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");

        eq = new JButton("=");

        div = new JButton("/");
        mul = new JButton("*");
        sub = new JButton("-");
        add = new JButton("+");

        JButton ac = new JButton("AC");
        JButton C = new JButton("C");

        JButton dec = new JButton(".");

        Font buttonFont = new Font("Arial", Font.PLAIN, 30);
        Dimension buttonSize = new Dimension(170, 100);
        zero.setFont(buttonFont);
        zero.setPreferredSize(buttonSize);
        one.setFont(buttonFont);
        one.setPreferredSize(buttonSize);
        two.setFont(buttonFont);
        two.setPreferredSize(buttonSize);
        three.setFont(buttonFont);
        three.setPreferredSize(buttonSize);
        four.setFont(buttonFont);
        four.setPreferredSize(buttonSize);
        five.setFont(buttonFont);
        five.setPreferredSize(buttonSize);
        six.setFont(buttonFont);
        six.setPreferredSize(buttonSize);
        seven.setFont(buttonFont);
        seven.setPreferredSize(buttonSize);
        eight.setFont(buttonFont);
        eight.setPreferredSize(buttonSize);
        nine.setFont(buttonFont);
        nine.setPreferredSize(buttonSize);
        eq.setFont(buttonFont);
        eq.setPreferredSize(buttonSize);
        div.setFont(buttonFont);
        div.setPreferredSize(buttonSize);
        mul.setFont(buttonFont);
        mul.setPreferredSize(buttonSize);
        sub.setFont(buttonFont);
        sub.setPreferredSize(buttonSize);
        add.setFont(buttonFont);
        add.setPreferredSize(buttonSize);
        dec.setFont(buttonFont);
        dec.setPreferredSize(buttonSize);
        ac.setFont(buttonFont);
        ac.setPreferredSize(buttonSize);
        C.setFont(buttonFont);
        C.setPreferredSize(buttonSize);

        JPanel panel = new JPanel();

        mul.addActionListener(c);
        div.addActionListener(c);
        sub.addActionListener(c);
        add.addActionListener(c);
        nine.addActionListener(c);
        eight.addActionListener(c);
        seven.addActionListener(c);
        six.addActionListener(c);
        five.addActionListener(c);
        four.addActionListener(c);
        three.addActionListener(c);
        two.addActionListener(c);
        one.addActionListener(c);
        zero.addActionListener(c);
        dec.addActionListener(c);
        eq.addActionListener(c);

        ac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                c.s0 = c.s1 = c.s2 = "";
            }
        });
        C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = field.getText();
                if (text.length() > 0) {
                    text = text.substring(0, text.length() - 1);
                    field.setText(text);
                    if (c.s2.length() > 0) {
                        c.s2 = c.s2.substring(0, c.s2.length() - 1);
                    } else if (c.s1.length() > 0) {
                        c.s1 = c.s1.substring(0, c.s1.length() - 1);
                    } else if (c.s0.length() > 0) {
                        c.s0 = c.s0.substring(0, c.s0.length() - 1);
                    }
                }
            }
        });

        panel.add(field);
        panel.add(add);
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(sub);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(mul);
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(div);
        panel.add(dec);
        panel.add(zero);
        panel.add(eq);
        panel.add(ac);
        panel.add(C);

        panel.setBackground(Color.black);
        frame.add(panel);

        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            field.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == '=') {

            double te;

            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));

            field.setText(s0 + s1 + s2 + "=" + te);

            s0 = Double.toString(te);

            s1 = s2 = "";
        } else if (s.equals("AC")) {
            s0 = s1 = s2 = "";

            field.setText("");
        } else {
            if (s1.equals("") || s2.equals(""))
                s1 = s;
            else {
                double te;

                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));

                s0 = Double.toString(te);

                s1 = s;

                s2 = "";
            }

            field.setText(s0 + s1 + s2);
            field.setPreferredSize(new Dimension(frame.getWidth(), 30));
        }
    }
}