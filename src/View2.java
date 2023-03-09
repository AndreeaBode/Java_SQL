import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View2 extends JFrame {
    private JTextArea textArea;
    private JButton back;

    public View2() {

        this.setBounds(100, 100, 766, 492);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        back = new JButton("Back");
        back.setBounds(317, 401, 85, 44);
        this.add(back);

        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        //textArea.setTabSize(60);
        textArea.setBounds(47, 78, 648, 304);
        this.getContentPane().add(textArea);

        JLabel rezultatLabel = new JLabel("REZULTAT");
        rezultatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rezultatLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
        rezultatLabel.setBounds(215, 10, 253, 58);
        this.getContentPane().add(rezultatLabel);
        this.setVisible(false);
    }

    public String getTextArea() {
        return textArea.getText();
    }

    public void setTextArea(String textArea) {
        this.textArea.setText(textArea);
    }
    public void addBackListener(ActionListener action) {
        back.addActionListener(action);
    }

}

