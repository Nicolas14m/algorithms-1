package Estructuras;

public class Listadoble<T extends Comparable<T>> implements IListadoble<T> {

    NodoDoble primero;
    NodoDoble ultimo;
    public int cantnodos;

    public Listadoble() {
        this.primero = null;
        this.ultimo = null;
        this.cantnodos = 0;
    }

    public int getCantnodos() {
        return cantnodos;
    }

    public NodoDoble getPrimero() {
        return primero;
    }

    public void setPrimero(NodoDoble primero) {
        this.primero = primero;
    }

    public NodoDoble getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoDoble ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public boolean esVacia() {
        return this.cantnodos == 0;
    }

    @Override
    public void agregarInicio(T dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (this.esVacia()) {
            this.setPrimero(nuevo);
            this.setUltimo(nuevo);
        } else {
            nuevo.setSiguiente(this.getPrimero());
            this.primero.setAnt(nuevo);
            this.setPrimero(nuevo);
        }
        int cantActual = this.cantnodos;
        
        this.cantnodos = this.cantnodos + 1;
    }

    @Override
    public void agregarFinal(T dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        if (this.esVacia()) {
            this.setPrimero(nuevo);
            this.setUltimo(nuevo);
        } else {
            nuevo.setAnt(this.getUltimo());
            this.ultimo.setSiguiente(nuevo);
            this.setUltimo(nuevo);
        }
        this.cantnodos = this.cantnodos + 1;
    }

    public void insertarRecursivo(T element) {
        insertar(element, this.primero);
    }

    public void insertar(T e, NodoDoble n) {
        if (n == null) {
            this.agregarFinal(e);
        } else {
            insertar(e, n.getSig());
        }
    }

    public void borrarRecursivo(NodoDoble n) {
        if (n == null) {
            return;
        }
        borrarRecursivo(n.getSig());
        this.borrarElemento((T) n.getDato());
    }

    public void borrarOcurrenciaRecursivo(NodoDoble n, T elementoAEliminar) {
        if (n == null) {
            return;
        } else {
            if (n.getDato().equals(elementoAEliminar)) {
                this.borrarElemento((T) n.getDato());
            }
            borrarOcurrenciaRecursivo(n.getSig(), elementoAEliminar);
        }

    }

    @Override
    public void agregarOrd(T n) {

        NodoDoble nuevo = new NodoDoble(n);

        if (this.esVacia()) {
            this.agregarInicio(n);
        } else {
            T primerElemento = (T) this.getPrimero().getDato();

            if (n.compareTo(primerElemento) == -1) {
                this.agregarInicio(n);
            } else {

                T ultimoElemento = (T) this.getUltimo().getDato();

                if (n.compareTo(ultimoElemento) == 1) {
                    this.agregarFinal(n);
                } else {

                    NodoDoble aux = this.getPrimero();
                    T elementoAComparar = (T) aux.getDato();

                    while (aux != null && n.compareTo(elementoAComparar) == 1) {
                        aux = aux.getSig();
                        elementoAComparar = (T) aux.getDato();
                    }
                    aux.getAnterior().setSiguiente(nuevo);
                    nuevo.setSiguiente(aux);
                    nuevo.setAnt(aux.getAnterior());
                    aux.setAnt(nuevo);
                    this.cantnodos = this.cantnodos + 1;
                }

            }

        }
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            if (this.cantnodos == 1) {
                this.setPrimero(null);
                this.setUltimo(null);
            } else {
                this.setPrimero(this.primero.getSig());
                this.primero.setAnt(null);
            }
            this.cantnodos = this.cantnodos - 1;
        }
    }

    @Override
    public void borrarFin() {
        if (!this.esVacia()) {
            if (this.cantnodos == 1) {
                this.setPrimero(null);
                this.setUltimo(null);
            } else {
                this.getUltimo().getAnterior().setSiguiente(null);
                this.setUltimo(this.getUltimo().getAnterior());
            }
            this.cantnodos = this.cantnodos - 1;
        }
    }

    @Override
    public void borrarElemento(T n) {

        NodoDoble buscado = this.obtenerElemento(n);

        if (buscado != null) {
            if (n.equals(this.getPrimero().getDato())) {
                this.borrarInicio();
            } else {
                if (n.equals(this.getUltimo().getDato())) {
                    this.borrarFin();
                } else {
                    buscado.getAnterior().setSiguiente(buscado.getSig());
                    buscado.getSig().setAnt(buscado.getAnterior());
//                    buscado.setSig(null);
//                    buscado.setAnt(null);
                    this.cantnodos = this.cantnodos - 1;
                }

            }

        }

    }

    @Override
    public boolean buscarelemento(T n) {
        boolean encontrado = false;
        if (!this.esVacia()) {
            NodoDoble aux = this.getPrimero();
            while (aux != null && !encontrado) {
                if (n.equals(aux.getDato())) {
                    encontrado = true;
                }
                aux = aux.getSig();
            }
        }
        return encontrado;
    }

    @Override
    public NodoDoble obtenerElemento(T n) {
        NodoDoble encontrado = null;
        if (!this.esVacia()) {
            NodoDoble aux = this.getPrimero();
            while (aux != null && encontrado == null) {
                if (n.equals(aux.getDato())) {
                    encontrado = aux;
                }
                aux = aux.getSig();
            }
        }
        return encontrado;
    }

    @Override
    public void vaciar() {
        this.setPrimero(null);
        this.setUltimo(null);
        this.cantnodos = 0;
    }

    @Override
    public void mostrar() {
        NodoDoble aux = this.getPrimero();
        while (aux != null) {
            System.out.print(aux.getDato());
            aux = aux.getSig();
        }
        System.out.println();
    }

    @Override
    public void mostrarPorLinea() {
        NodoDoble aux = this.getPrimero();
        
        while (aux != null) {
            System.out.print(aux.getDato() + "\n");
            aux = aux.getSig();
        }
        System.out.println();
    }

    public void mostrar2() {
        NodoDoble aux = this.getUltimo();
        while (aux != null) {
            System.out.print(aux.getDato() + "  ");
            aux = aux.getAnterior();
        }
        System.out.println();
    }

    @Override
    public void mostrarREC(NodoDoble l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantElementos() {
        return this.cantnodos;
    }

    @Override
    public String mostrarRecDsc(NodoDoble primero, NodoDoble ultimo) {
        if (this.primero == null) {
            return "";
        } else {
            if (primero == ultimo) {
                return primero.getDato() + " ";
            } else {
                return mostrarRecDsc(primero.getSig(), ultimo) + primero.getDato() + " - ";
            }
        }
    }

    @Override
    public String mostrarRecAsc(NodoDoble primero, NodoDoble ultimo) {
        if (primero == null) {
            return " ";
        } else {
            if (primero == ultimo) {
                return primero.getDato() + " ";
            } else {
                return primero.getDato() + " - " + mostrarRecAsc(primero.getSig(), ultimo);
            }
        }
    }

    @Override
    public int IndiceDe(T n) {
        int index = 1;
        NodoDoble<T> aux = this.getPrimero();

        while (aux != null) {
            if (aux.getDato().equals(n)) {
                return index;
            }
            index++;
            aux = aux.getSig();
        }
        return -1;
    }

    @Override
    public NodoDoble GetElementoPorPosicion(int posicion) {

        int index = 1;
        NodoDoble<T> aux = this.getPrimero();

        while (aux != null) {
            if (index == posicion) {
                return aux;
            }
            index++;
            aux = aux.getSig();
        }
        return null;
    }

}
