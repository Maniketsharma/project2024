import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class AWTFrameExample extends Frame implements ActionListener {

    private TextField textField;
    private Label resultLabel;

    public AWTFrameExample() {
        // Set the layout manager for the frame
        setLayout(new FlowLayout());

        // Create components
        Label nameLabel = new Label("Enter your name:");
        textField = new TextField(20);
        Button submitButton = new Button("Submit");
        resultLabel = new Label("");

        // Add components to the frame
        add(nameLabel);
        add(textField);
        add(submitButton);
        add(resultLabel);

        // Add action listener to the button
        submitButton.addActionListener(this);

        // Set properties for the frame
        setTitle("AWT Frame Example");
        setSize(300, 150);
        setVisible(true);

        // Handle closing the frame
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    // Handle button click event
    public void actionPerformed(ActionEvent e) {
        String name = textField.getText();
        resultLabel.setText("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        new AWTFrameExample();
    }
}
/**
 * dud
 
import java.awt.*;
public class dud {
class myframe extends Frame{
myframe(){
    setLayout(null);
    setSize(500,500);
    setVisible(true);

}
}
    public static void main(String[] args) {
       new dud();    }/* 
*/