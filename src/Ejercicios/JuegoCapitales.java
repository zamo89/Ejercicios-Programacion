package Ejercicios;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class JuegoCapitales extends Applet {
    Panel pNorte,pOeste,pCentro,pEste,pSur;
    TextArea tSuperior,tRespuesta;
    TextField tAciertos,tErrores;
    int aciertos,errores,anchura,altura;
    Label l1,l2,lAciertos,lErrores;
    List l;
    Button comprobar,borrar;
    String paises[]={"Afganistan","Argentina","Belgica","Brasil","Catar","Dinamarca","Eslovaquia"};
    String capitales[]={"Kabul","Buenos Aires","Bruselas","Brasilia","Doha","Copenhague","Bratislava"};
    String paisesCapitales[][];
    
    public void init() {
        paisesCapitales = new String [2][15];
        altura=this.getHeight();
        anchura=this.getWidth();
        System.out.println(altura);
        System.out.println(anchura);
        añadirCapitales();
        componerPantalla();
        crearComponentes();
        mostrarArray();
    }
    
    public void añadirCapitales(){
        for(int i=0;i<paises.length;i++){
            paisesCapitales[0][i]=paises[i];
            paisesCapitales[1][i]=capitales[i];
        }
            
    }
    
    public void componerPantalla(){
        setLayout(new BorderLayout());
        
        //Panel Norte
        tSuperior=new TextArea("Escribe en el cuadro de texto la capital de un pais de la lista central,\n"
                +" seleccionalo y pulsa el boton COMPROBAR con el boton izdo. \n Para borrar la capital"
                +" escrita y el mensaje de acierto o error pulsa BORRAR. \n Si fallas mas de tres veces el "
                + "programa no te dejara jugar mas. \n No intentes modificar tus aciertos o errores porque no podras ");
        tSuperior.setEditable(false);
        pNorte=new Panel(new BorderLayout());
        pNorte.add(tSuperior);
        
        //Panel Oeste
        l1=new Label("Escribe aqui la capital");
        tRespuesta=new TextArea(3,1);
        pOeste=new Panel(new BorderLayout());
        pOeste.add(l1,BorderLayout.NORTH);
        pOeste.add(tRespuesta,BorderLayout.SOUTH);
        
        
        //Panel Central
        l2=new Label("Selecciona el pais");
        l = new List(4,false);
        for(int i=0;i<paises.length;i++){
            l.add(paisesCapitales[0][i]);
        }
        pCentro=new Panel(new BorderLayout());
        pCentro.add(l2,BorderLayout.NORTH);
        pCentro.add(l,BorderLayout.SOUTH);
        
        //Panel Este
        comprobar=new Button("Comprobar");
        borrar=new Button("Borrar");
        pEste=new Panel(new FlowLayout());
        pEste.add(comprobar);
        pEste.add(borrar);
        
        //Panel Sur
        lAciertos=new Label("Aciertos");
        lErrores=new Label("Errores");
        tAciertos=new TextField(5);
        tAciertos.setEditable(false);
        tErrores=new TextField(5);
        tErrores.setEditable(false);
        pSur=new Panel(new FlowLayout());
        pSur.add(lAciertos);
        pSur.add(tAciertos);
        pSur.add(lErrores);
        pSur.add(tErrores);
        
        //Carga de paneles
        add(pNorte,BorderLayout.NORTH);
        add(pOeste,BorderLayout.WEST);
        add(pCentro,BorderLayout.CENTER);
        add(pEste,BorderLayout.EAST);
        add(pSur,BorderLayout.SOUTH);
    }
    
    public void crearComponentes(){
          comprobar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(l.getSelectedIndex()!=-1){
                    System.out.println("Se ha elejido la opcion"+eleccionLista());
                }
            }
        });
          
         borrar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            
            }
        });
    }
    
    public int eleccionLista(){
        return l.getSelectedIndex();
    }
    
    void mostrarArray(){
        for(int i=0;i<paises.length;i++){ 
            System.out.print(paisesCapitales[0][i]);
            System.out.print(" = ");
            System.out.print(paisesCapitales[1][i]);
            System.out.println();
        }
    }
}
