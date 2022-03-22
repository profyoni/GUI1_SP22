import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class _22_GuiWithProperties extends JFrame {
    public static void main(String[] args) {
        new _22_GuiWithProperties();
    }

    _22_GuiWithProperties()
    {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {

                Properties prop = new Properties();
                try {
                    prop.load(new FileInputStream("app.props"));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                int width = Integer.parseInt(prop.getProperty("width"));
                int height = Integer.parseInt(prop.getProperty("height"));
                int x = Integer.parseInt(prop.getProperty("x"));
                int y = Integer.parseInt(prop.getProperty("y"));

                setLocation(x,y);
                setSize(width,height);
                System.out.println("Opened");
            }
            @Override
                public void windowClosing(WindowEvent e) {
                Properties prop = new Properties();
                prop.setProperty("width", getWidth()+"");
                prop.setProperty("height", getHeight()+"");
                prop.setProperty("x", getLocation().x+"");
                prop.setProperty("y", getLocation().y+"");

                try {
                    prop.store(new FileOutputStream("app.props"),"no comment I am a politician");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Closed");
                System.exit(0);
                //super.windowClosing(e);
            }
        });

        setSize(50, 50);
        setLocation(10,10);
        setVisible(true);
    }
}
