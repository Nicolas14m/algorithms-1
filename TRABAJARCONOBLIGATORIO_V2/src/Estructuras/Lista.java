package Estructuras;

public class Lista<T extends Comparable<T>> implements ILista<T> {

    private Nodo inicio;
    private int cantidadNodos;
    private Nodo ultimo;

    //Constructor   
    public Lista() {
        inicio = null;
        ultimo = null;
        cantidadNodos = 0;
    }

    @Override
    public boolean esVacia() {
        return getInicio() == null;
        
    }

    @Override
    public void agregarInicio(T n) {
        
        Nodo nuevo = new Nodo(n);
        if (this.esVacia()) {
            this.setInicio(nuevo);
            this.setUltimo(nuevo);
        } else {
            nuevo.setSiguiente(inicio);
            this.setInicio(nuevo);
        }
        this.cantidadNodos = this.cantidadNodos + 1;
    }
    
    @Override
    public void agregarFinal(T n) {
        Nodo nuevo = new Nodo(n);

        if (this.esVacia()) {
            inicio = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
        }
        ultimo = nuevo;
        
      this.cantidadNodos = this.cantidadNodos + 1;

    }

    @Override
    public String mostrar() {
        String ret = "";
        Nodo mostrar = getInicio();

        while (mostrar != null) {

            ret += mostrar.getDato() + "\n";
            mostrar = mostrar.getSiguiente();
        }
        return ret;
    }
    

    public Nodo getInicio() {
        return inicio;
    }

    /**
     * @return the ultimo
     */
    public Nodo getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }
    
    public void setInicio (Nodo inicio) {
        this.inicio = inicio;
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            if (this.inicio == this.ultimo) {
                this.inicio = null;
                this.ultimo = null;
            } else {
                this.inicio = this.inicio.getSiguiente();

            }
            this.cantidadNodos = this.cantidadNodos - 1;
        }
        
    }

    @Override
    public void borrarFin() {
        if (!this.esVacia()) {
            if (this.inicio == this.ultimo) {
                this.inicio = null;
                this.ultimo = null;
            } else {
                Nodo aux = this.inicio;
                while (aux.getSiguiente() != this.ultimo) {
                    aux = aux.getSiguiente();
                }
                aux.siguiente = null;
                this.setUltimo(aux);
            }
         this.cantidadNodos = this.cantidadNodos - 1;
        }
    }

    @Override
    public void vaciar() {
        this.inicio = null;
        this.ultimo = null;
        this.cantidadNodos = 0;
       
    }

    @Override
    public Boolean borrarElemento(T n) {
        
       boolean borrado = false;
        Nodo aux = this.inicio;
        if (!this.esVacia()) {
            if (n.equals(this.inicio.getDato())) {
                this.borrarInicio();
            } else {
                if (n.equals(this.ultimo.getDato())) {
                    this.borrarFin();
                } else {
                    while (aux.getSiguiente() != null && !borrado) {
                        if (n.equals(aux.getSiguiente().getDato())) {
                            aux.siguiente = aux.siguiente.siguiente;
                            borrado = true;
                        }
                        aux = aux.getSiguiente();
                    }
                }
            }
        }
        return borrado;
    }

    @Override
    public Nodo obtenerElemento(T n) {
        
        Nodo aux = this.getInicio();
        Nodo punteroBuscado = null;
        while (aux != null && punteroBuscado == null) {
            if (n.equals(aux.getDato())) {
                punteroBuscado = aux;
            }
            aux = aux.siguiente;
        }
        return punteroBuscado;
    }
    
    

     @Override
     public boolean buscarElemento(T n ){
         
     boolean encontrado = false;
        Nodo aux = this.getInicio();
        while (aux != null && !encontrado) {
            if (n.equals(aux.getDato())) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }
        return encontrado;
         
         
     }
    
    @Override
    public int cantElementos() {
        return this.cantidadNodos;
    }

    @Override
    public String mostrarREC(Nodo l, String texto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean agregarInicioSiNoExiste(T n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean agregarFinalSiNoExiste(T n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T borrarElementoRetObjeto(T n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ordenarDescBurbuja() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    public Nodo GetElementoPorPosicion(int posicion) {

        int index = 1;
        Nodo<T> aux = this.getInicio();

        while (aux != null) {
            if (index == posicion) {
                return aux;
            }
            index++;
            aux = aux.getSiguiente();
        }
        return null;
    }

}
