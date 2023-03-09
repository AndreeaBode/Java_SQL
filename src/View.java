import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JButton ex3aButton;
    private JButton ex3bButton;
    private JButton ex4aButton;
    private JButton ex4bButton;
    private JButton ex5aButton;
    private JButton ex5bButton;
    private JButton ex6aButton;
    private JButton ex6bButton;

    private JTextField txtColocviu;

    public View() {

        this.setBounds(100, 100, 766, 492);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        ex3aButton = new JButton("Ex3a");
        ex3aButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ex3aButton.setBounds(155, 73, 115, 42);
        this.getContentPane().add(ex3aButton);

        ex3bButton = new JButton("Ex3b");
        ex3bButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ex3bButton.setBounds(155, 148, 115, 42);
        this.getContentPane().add(ex3bButton);

        ex4aButton = new JButton("Ex4a");
        ex4aButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ex4aButton.setBounds(155, 235, 115, 42);
        this.getContentPane().add(ex4aButton);

        ex4bButton = new JButton("Ex4b");
        ex4bButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ex4bButton.setBounds(155, 323, 115, 42);
        this.getContentPane().add(ex4bButton);

        ex5aButton = new JButton("Ex5a");
        ex5aButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ex5aButton.setBounds(479, 73, 115, 42);
        this.getContentPane().add(ex5aButton);

        ex5bButton = new JButton("Ex5b");
        ex5bButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ex5bButton.setBounds(479, 148, 115, 42);
        this.getContentPane().add(ex5bButton);

        ex6aButton = new JButton("Ex6a");
        ex6aButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ex6aButton.setBounds(479, 235, 115, 42);
        this.getContentPane().add(ex6aButton);

        ex6bButton = new JButton("Ex6b");
        ex6bButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ex6bButton.setBounds(479, 323, 115, 42);
        this.getContentPane().add(ex6bButton);

        JLabel lblNewLabel = new JLabel("COLOCVIU");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(299, 10, 151, 45);
        this.getContentPane().add(lblNewLabel);

        this.setVisible(true);
    }

    public void addEx3aListener(ActionListener action) {
        ex3aButton.addActionListener(action);
    }

    public void addEx3bListener(ActionListener action) {
        ex3bButton.addActionListener(action);
    }

    public void addEx4aListener(ActionListener action) {
        ex4aButton.addActionListener(action);
    }

    public void addEx4bListener(ActionListener action) {
        ex4bButton.addActionListener(action);
    }

    public void addEx5aListener(ActionListener action) {
        ex5aButton.addActionListener(action);
    }

    public void addEx5bListener(ActionListener action) {
        ex5bButton.addActionListener(action);
    }

    public void addEx6aListener(ActionListener action) {
        ex6aButton.addActionListener(action);
    }

    public void addEx6bListener(ActionListener action) {
        ex6bButton.addActionListener(action);
    }


}
