import javax.swing.JFrame;

public class method_mondai2
{
    public static void main(String[] args)
    {
        return;
    }
    public static void hello()
    {
        System.out.println("hello");
    }
}
class SwingGUI extends JFrame{
    
    SwingGUI()
    {
         JFrame frame = new JFrame();
         frame.setSize(400,400);
         frame.setTitle("こんにちはJFrame");
         frame.setVisible(true);
    }
}