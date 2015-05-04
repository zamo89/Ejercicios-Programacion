
package Ejercicios;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;


public class EjercicioHistorialPulsaciones extends Applet {
    TextField t;
    Panel pNorte,pCentro,pSur;
    Button b1,b2;
    TextArea ta;
    Image im;
    AudioClip audio;
    int anchuraApplet,alturaApplet,contadorPrimero,contadorSegundo;
    
    public void init() {
        capturarParametros();
        componerPantalla();
        componentes();
    }
    
    public void capturarParametros(){
        im=getImage(getCodeBase(), getParameter("imagenes/imagen05.gif")); 
        audio=getAudioClip(getCodeBase(), getParameter("sonidos/sonido04.au"));
    }
    
    public void componerPantalla(){
        setLayout(new BorderLayout());
        
        t=new TextField(40);
        pNorte=new Panel(new FlowLayout());
        pNorte.add(t);
        
        b1=new Button("Primero");
        b2=new Button("Segundo");
        pCentro = new Panel(new FlowLayout());
        pCentro.add(b1,BorderLayout.CENTER);
        pCentro.add(b2,BorderLayout.CENTER);
        
        ta=new TextArea(5,40);
        ta.setRows(3);
        pSur=new Panel(new FlowLayout());
        pSur.add(ta);
        
        add(pNorte,BorderLayout.NORTH);
        add(pCentro,BorderLayout.CENTER);
        add(pSur,BorderLayout.SOUTH);
        
        anchuraApplet=this.getHeight();
        alturaApplet=this.getWidth();
    }
    
    public void componentes(){
        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                contadorPrimero++;
                ta.append("Pulsado "+contadorPrimero+" veces el boton primero \n");
                t.setText("Pulsado "+contadorPrimero+" veces el boton primero");
                if(contadorPrimero==10){
                    final Frame f = new Frame();
                    f.setResizable(false);
                    f.setTitle("Boton Primero");
                    f.setBounds(0,335,200,125);
                    f.setVisible(true);
                    f.getToolkit().beep();
                    //Aqui faltaria que se mostrara la imagen
                    f.addWindowListener(new WindowAdapter(){
                        @Override
                        public void windowClosing(WindowEvent e){
                            f.dispose();
                        }
                    });
                }
            }
         });
        
        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                contadorSegundo++;
                ta.append("Pulsado "+contadorSegundo+" veces el boton segundo \n");
                t.setText("Pulsado "+contadorSegundo+" veces el boton segundo");
                if(contadorSegundo==5){
                    final Frame f = new Frame();
                    f.setResizable(false);
                    f.setTitle("Boton Segundo");
                    f.setBackground(Color.yellow);
                    f.setBounds(200,335,200,125);
                    f.setVisible(true);
                    f.getToolkit().beep();
                    f.addWindowListener(new WindowAdapter(){
                        @Override
                        public void windowClosing(WindowEvent e){
                            f.dispose();
                        }
                    });
                }
            }
         });
    }
}
