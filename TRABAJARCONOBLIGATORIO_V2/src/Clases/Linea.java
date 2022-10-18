
package Clases;

import Estructuras.Listadoble;
import trabajarconobligatorio.Obligatorio;

public class Linea implements Comparable<Linea> {

    
    public Listadoble <Palabra> listaPalabra;

    public Linea() {
        this.listaPalabra = new Listadoble <Palabra>();
    }
    
    @Override
    public int compareTo(Linea o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
