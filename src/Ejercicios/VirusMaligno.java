package Ejercicios;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;


public class VirusMaligno extends Frame {
    Panel pNorte,pCentro,pEste;
    TextField tSuperior;
    TextArea taNorte,taCentro;
    Button b;
    File f,fLectura,fEscritura;
    String ruta="cositas",rutaFicheroLectura="C:\\Windows\\PFRO.log",rutaFicheroEscritura="cositas/sorpresa.txt";
    
    VirusMaligno(){
        componerPantalla();
        crearComponentes();
        cerrar();
    }
    
    private void componerPantalla(){
        setLayout(new BorderLayout());
        
        //Panel Norte
        tSuperior = new TextField("Soy un virus malísimo. Vigila tu carpeta cositas jaja",50);
        pNorte=new Panel(new FlowLayout());
        pNorte.add(tSuperior);
        
        //Panel Centro
        taNorte=new TextArea("“Voy a limpiar toda la basura que tienes, jeje. \nSi te atreves, pulsa el boton de la derecha, jeje”",10,40);
        taNorte.setBackground(Color.BLUE);
        taNorte.setForeground(Color.YELLOW);
        taCentro=new TextArea(20,40);
        taCentro.setBackground(Color.BLACK);
        taCentro.setForeground(Color.GREEN);
        pCentro=new Panel(new BorderLayout());
        pCentro.add(taNorte,BorderLayout.NORTH);
        pCentro.add(taCentro,BorderLayout.CENTER);
        
        //Panel Este
        b=new Button("¿Tienes lo que hay que tener?");
        pEste=new Panel(new FlowLayout());
        pEste.add(b);
        
        //Añadir Paneles
        add(pNorte,BorderLayout.NORTH);
        add(pCentro,BorderLayout.CENTER);
        add(pEste,BorderLayout.EAST);
    }
    
    private void crearComponentes(){
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f=new File(ruta);
                if(f.exists()){
                    borraFicherosDirectorios(f);
                }
            }
        });
    }
    
    private void borraFicherosDirectorios(File f){
        taNorte.setText("");
        taNorte.append("Estos ficheros y Directorios se van a elimniar: \n");
        String lista[]=f.list();
        System.out.println("Lista de "+lista.length);
        for(int i=0;i<lista.length;i++){
            File faux=new File(f.getName(),lista[i]);
            if(faux.exists()){
                if(faux.isFile()){
                    if (faux.delete()){
                        System.out.println("Archivo"+faux.getName()+" borrado");
                        taNorte.append(faux.getName()+"\n");
                    }
                    
                }else if(faux.isDirectory()){
                    borraFicherosDirectorios(faux);
                }
            }else{
                System.out.println("No existe el archivo");
            }
        }
    }
    
    private void cerrar(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String args[]) {
        Frame f = new VirusMaligno();
        f.setBounds(100, 40, 650, 500);
        f.setVisible(true);
    }
}
