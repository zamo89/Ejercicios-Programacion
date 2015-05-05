package Ejercicios;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class JuegoCapitales extends Applet {
    Panel pNorte,pOeste,pCentro,pEste,pSur;
    TextArea tSuperior,tRespuesta;
    TextField tAciertos,tErrores,tMensajes;
    int aciertos=0,errores=0,anchura,altura;
    Label l1,l2,lAciertos,lErrores;
    List l;
    Button comprobar,borrar;
    String paises[]={"Afganistán","Argentina","Bélgica","Brasil","Catar","Dinamarca","Eslovaquia"};
    String capitales[]={"Kabul","Buenos Aires","Bruselas","Brasília","Doha","Copenhague","Bratislava"};
    String paisesCapitales[][];
    
    public void init() {
        paisesCapitales = new String [2][paises.length];
        altura=this.getHeight();
        anchura=this.getWidth();
        añadirCapitales();
        componerPantalla();
        crearComponentes();
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
                +"seleccionalo y pulsa el boton COMPROBAR con el boton izdo. \nPara borrar la capital"
                +"escrita y el mensaje de acierto o error pulsa BORRAR. \nSi fallas mas de tres veces el "
                +"programa no te dejara jugar mas. \nNo intentes modificar tus aciertos o errores porque no podras. \n"
                +"Ten cuidado con los acentos y las mayúsculas");
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
        tAciertos=new TextField(intString(aciertos),5);
        tAciertos.setEditable(false);
        tErrores=new TextField(intString(errores),5);
        tErrores.setEditable(false);
        tMensajes=new TextField(30);
        tMensajes.setEditable(false);
        pSur=new Panel(new FlowLayout());
        pSur.add(lAciertos);
        pSur.add(tAciertos);
        pSur.add(lErrores);
        pSur.add(tErrores);
        pSur.add(tMensajes);
        
        //Carga de paneles
        add(pNorte,BorderLayout.NORTH);
        add(pOeste,BorderLayout.WEST);
        add(pCentro,BorderLayout.CENTER);
        add(pEste,BorderLayout.EAST);
        add(pSur,BorderLayout.SOUTH);
    }
    
    public void crearComponentes(){
        comprobar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(errores<3){
                    if(l.getSelectedIndex()!=-1 && !tRespuesta.getText().isEmpty()){
                        if(paisesCapitales[1][eleccionLista()].equals(tRespuesta.getText())){
                            aciertos++;
                            tAciertos.setText(intString(aciertos));
                            tMensajes.setText("Respuesta Correcta!!");
                        }else{
                            errores++;
                            tErrores.setText(intString(errores));
                            tMensajes.setText("Tontito, respuesta incorrecta");
                        }

                    }else{
                        tMensajes.setText("Respuesta vacia o pais no selecionado");
                    }
                }else{
                    tMensajes.setText("Has fallado mas de 3 veces INCULTO!!");
                }
            }
        });
          
        borrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tRespuesta.setText("");
                tMensajes.setText("");
            }
        });
    }
    
    public int eleccionLista(){
        return l.getSelectedIndex();
    }
    
    public String intString(int x){
        return Integer.toString(x);
    }
    
    
    //Pruebas
    void mostrarArray(){
        
        for(int i=0;i<paises.length;i++){ 
            System.out.print(paisesCapitales[0][i]);
            System.out.print(" = ");
            System.out.print(paisesCapitales[1][i]);
            System.out.println();
        }
    }
}
