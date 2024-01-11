import java.awt.*;

/**
 * precdemo
 */
public class precdemo extends Frame{
    // reqirement for add container//
    Button b=new Button("click here");
    Panel p=new Panel();
precdemo(){
    setSize(600,500);
    setVisible(true);
    setLayout(null);
    setTitle("precdemo");
    b.setBounds(300,50,300,123);
    add(b);
    
}
   
public static void main(String[] args) {
        new precdemo();
    }
}