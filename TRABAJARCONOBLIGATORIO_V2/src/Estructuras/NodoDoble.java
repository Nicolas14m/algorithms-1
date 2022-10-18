
package Estructuras;

public class NodoDoble <T extends Comparable<T>> {
    
    private T dato;
    private NodoDoble sig; 
    private NodoDoble ant;  

    public NodoDoble(T dato) {
        this.dato = dato;
        this.sig = null;
        this.ant = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }


    public NodoDoble getSig() {
        return sig;
    }

    public void setSiguiente(NodoDoble sig) {
        this.sig = sig;
    }

    public NodoDoble getAnterior() {
        return ant;
    }

    public void setAnt(NodoDoble ant) {
        this.ant = ant;
    }
    
    
    
    
    
}
