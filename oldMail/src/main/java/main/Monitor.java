/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JLabel;
import static main.frmMain.N;

/**
 *
 * @author Paolo_Veliz
 */
public class Monitor {
    public int[] regionCritica = new int[4];
    public int posicion = 0;
    String buzon[] = new String[N];
    String mensajes[] = new String[20];
    int mensajes_cantidad = 0;
    public Monitor(String[] buzon, String[] mensaje){
        this.buzon = buzon;
        this.mensajes = mensaje;
    }
    public void setBuzon(String[] buzon){
        this.buzon = buzon;
    }
    public void setMensajes(String[] mensajes){
        this.mensajes = mensajes;
    }
    public synchronized void Mon(String mensaje, int bandera){
            //Hice la variable bandera para poder diferenciar entre el mensajero y emisor
            //Siendo emisor = 0 y mensajero = 1
            System.out.println("bandera " + bandera + " "+mensaje);
            if(bandera == 0){
                //Espacio para emisor
                for (int i = 0; i < 5; i++){
                    if(buzon[i].equals("")){
                        buzon[i] = mensaje;
                        mensajes_cantidad++;
                        break;
                    }
                    
                }
                System.out.println("llego al monitor desde el emisor");
            }else{
                //Espacio para mensajero
                
            if(mensajes_cantidad != 0){
                int pos = 0;
                while(pos < 5){
                String[] palabras = buzon[pos].split(" ");
                for (int x = 0; x < palabras.length;x++) {
                    
                    if (palabras[x].equals("enviado")) {
                    System.out.println("Encontrado");
                    pos++;
                    }else{
                        buzon[pos] = buzon[pos] + " enviado";
                        break;
                    }   
                }  
            }
            }
              
            
           
        }
    }
}
