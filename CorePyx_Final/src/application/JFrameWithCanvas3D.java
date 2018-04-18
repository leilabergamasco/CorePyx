package application;

import java.awt.BorderLayout;
import javax.swing.*;


public class JFrameWithCanvas3D extends JFrame {
   public JFrameWithCanvas3D() {
      super("Swing JFrame Wraps Canvas3D");
      setLayout(new BorderLayout());

      BallPanel panel = new BallPanel();
      add(panel, BorderLayout.CENTER);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }

   public static void main(String[] args) {
      System.setProperty("sun.awt.noerasebackground", "true");
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         @SuppressWarnings("unused")
         @Override
         public void run() {
            new JFrameWithCanvas3D();
         }
      });
   }  
}

