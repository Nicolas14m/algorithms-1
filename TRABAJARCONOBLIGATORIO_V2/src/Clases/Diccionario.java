
package Clases;

import Estructuras.Lista;
import Estructuras.Listadoble;


public class Diccionario implements Comparable<Diccionario> {

    
    public Listadoble <Palabra> listaPalabras;

    public Diccionario() {
        this.listaPalabras = new Listadoble <Palabra>();
    }

    public Listadoble<Palabra> getListaPalabras() {
        return listaPalabras;
    }

    public void setListaPalabras(Listadoble<Palabra> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }
    
    
    @Override
    public int compareTo(Diccionario o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
