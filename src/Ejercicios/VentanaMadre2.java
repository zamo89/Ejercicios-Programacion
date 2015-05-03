package Ejercicios;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaMadre2 extends Frame {
    VentanaMadre2() {
         setLayout(new FlowLayout());
         setTitle("Ventana Madre");
         setBackground(Color.CYAN);
           setBounds(0, 0, 200,200);
         
         setVisible(true);
         addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
         });
         Button b = new Button("Abrir Ventana");
         add(b);
         b.addMouseListener(new MouseAdapter() {
            int cont=0,x=60,y=60;
            
            @Override
            public void mouseClicked(MouseEvent e) {
                final Frame f = new Frame();
                f.setBackground(Color.yellow);
                f.setTitle("VentanaHija"+cont);
                f.setBounds(x,y,200,200);
                f.setVisible(true);
                cont++;
                y+=60;
                x+=60;
                f.addWindowListener(new WindowAdapter(){
                    
                    @Override
                    public void windowClosing(WindowEvent e){
                        f.dispose();
                    }
                });
            }
         });
     }
     public static void main(String args[]){
         VentanaMadre2  v = new VentanaMadre2();
     }
}
