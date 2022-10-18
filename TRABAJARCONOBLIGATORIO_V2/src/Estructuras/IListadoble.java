package Estructuras;

public interface IListadoble<T extends Comparable<T>> {

    public boolean esVacia();

    public void agregarInicio(T dato);

    public void agregarFinal(T dato);

    public void agregarOrd(T n);

    public void borrarInicio();

    public void borrarFin();

    public void borrarElemento(T n);

    public boolean buscarelemento(T dato);

    public NodoDoble obtenerElemento(T n);

    public int IndiceDe(T n);

    public NodoDoble GetElementoPorPosicion(int posicion);

    public void vaciar();

    public void mostrar();

    public void mostrarPorLinea();

    public void mostrarREC(NodoDoble l); // implementar el mostrar recursivo    

    public int cantElementos();

    public String mostrarRecDsc(NodoDoble primero, NodoDoble ultimo);

    public String mostrarRecAsc(NodoDoble primero, NodoDoble ultimo);
}
