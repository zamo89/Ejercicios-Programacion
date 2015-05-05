package Ejercicios;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class EjercicioEventos1 extends Applet {
    
    Image imagen[]=new Image[15];
    AudioClip sonido;
    String nombres[]={"Ana","Paco","David","Lucia","Ana","Paco","David","Lucia","Ana","Paco","David","Lucia","Ana","Paco","David","Lucia"};
    String descripcion[];
    int anchuraImagen,alturaImagen,pSeleccionado=0;
    Panel pNorte,pEste,pCentro,pOeste,pSur;
    Label label;
    Checkbox opcion1,opcion2;
    CheckboxGroup grupo;
    List lista;
    MiCanvas mc;
    Button b;
    TextField t;
    
    Image imagenDB;
    Graphics gDB;
    
    public void init() {
        this.setBackground(Color.cyan);
        capturarParametros();
        componerPantalla();
        crearComponentes();
    }
    
    public void capturarParametros(){
        
        for(int i=0;i<15;i++){
            imagen[i]=getToolkit().getImage("imagenes/imagen"+i);
        }
        sonido=getAudioClip(getCodeBase(), getParameter("sonido"));
    }
    
    public Graphics grafico(){
        return this.getGraphics();
    }
    
    public void componerPantalla(){
        setLayout(new BorderLayout());
        //Panel Norte
        label = new Label("¿Quieres escucharlos?");
        grupo = new CheckboxGroup();
        opcion1 = new Checkbox("Con sonido",grupo,true);
        opcion2 = new Checkbox("Sin sonido",grupo,false);
        pNorte=new Panel(new BorderLayout());
        pNorte.add(label,BorderLayout.WEST);
        pNorte.add(opcion1,BorderLayout.CENTER);
        pNorte.add(opcion2,BorderLayout.EAST);
        
        //Panel Oeste
        lista=new List(12,false);
        for(int i=0;i<nombres.length;i++){
            lista.add(nombres[i]);
        }
        pOeste=new Panel(new BorderLayout());
        pOeste.add(lista);
        
        //Panel Central
        mc = new MiCanvas(imagen[pSeleccionado]);
        mc.setSize(50, 50);
        pCentro=new Panel(new BorderLayout());
        pCentro.add(mc);
        
        //Panel Este
        pEste=new Panel(new BorderLayout());
        t=new TextField();
        t.setColumns(20);
        pEste.add(t);
        
        //Panel Sur
        b=new Button("Obtener Informacion");
        pSur=new Panel(new BorderLayout());
        pSur.add(b,BorderLayout.CENTER);

        
        
        
        //Añadir todos los paneles
        add(pNorte,BorderLayout.NORTH);
        add(pOeste,BorderLayout.WEST);
        add(pCentro,BorderLayout.CENTER);
        add(pEste,BorderLayout.EAST);
        add(pSur,BorderLayout.SOUTH);
        
       
    }
    
    public void crearComponentes(){
        b.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               if(comprobarCheckBox()){
                   System.out.println("Con Sonido");
                   System.out.println("Has elejido la opcion "+eleccionLista());
                   repaint();
               
               }else{
                   System.out.println("Sin Sonido");
                   System.out.println("Has elejido la opcion "+eleccionLista());
                   repaint();
               }
            }
        });
    }
    
    public boolean comprobarCheckBox(){
        return opcion1.getState();
    }
    
    public int eleccionLista(){
        return lista.getSelectedIndex();
    }
    
    public void paint(Graphics g) {
        

    }
    
    public void update(Graphics g) {
        if (imagenDB == null) {
        imagenDB = createImage(getWidth(), getHeight());
        gDB = imagenDB.getGraphics();
        }
        gDB.setColor(getBackground());
        gDB.fillRect(0, 0, getWidth(), getHeight());
        gDB.setColor(getForeground());
        paint(gDB);
        g.drawImage(imagenDB, 0, 0, this);
    }
}
