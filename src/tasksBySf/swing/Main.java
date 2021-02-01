package tasksBySf.swing;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Main {
    public static void main(String[] args) {
        //Создаем окно
        JFrame jf  = new JFrame();
        //Устанавливаем ему размеры
        jf.setSize(400,300);
        // и показываем его
        jf.setVisible(true);
      //  jf.addMouseListener(new SimpleClickListener());
        jf.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println(e.getX() + " " + e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }
}
