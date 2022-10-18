
package Clases;

import Estructuras.Listadoble;

public class Contacto implements Comparable<Contacto> {
    
   public int numero;
   public String nombre;
   public Listadoble <Mensaje> listaMensajes;
   
   
    public Contacto(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
        this.listaMensajes = new Listadoble<Mensaje>();
    }

    public Contacto() {
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Contacto o) {
         
        String a = this.nombre;
        String b = o.nombre;
        
        int compare = a.compareTo(b);  

        if (compare < 0) {  
            return -1;
        }
        else if (compare > 0) {
           return 1;
        }
        else {  
            return 0;
        }
    }
    
    
    @Override
    public boolean equals(Object o){
        Contacto c = (Contacto) o;
       return this.numero == c.numero;
    }
    
     @Override
    public String toString() {
        return this.nombre + " " + "(" + this.numero + ")";
    }
    
//    @Override
//    public String toString() {
//        return "Nombre: " + this.nombre + " Numero: " + this.numero;
//    }
    
}
