
package Estructuras;


public interface ILista<T extends Comparable<T>> {
    
    //metodos de la interfaz
    //post: Retorna un boolean indicado si la lista es vacía
    public boolean esVacia();
    
    //pre: El elemento a agregar es un objeto generico
    //post: agrega el elemento al principio de la lista
    public void agregarInicio(T n);
    
    //pre: n es un objeto generico
    //post: agrega el elemento al final de la lista
    public void agregarFinal(T n);
    
    //post: se borra el primer elemento de la lista
    public void borrarInicio();
    
    //post: se elimina el ultimo elemento de la lista
    public void borrarFin();
    
    //post: se vacia la lista
    public void vaciar();
    
    //post: se muestran todos los elementos de la lista en orden 
    public String mostrar();
    

    //pre: n es un objecto generico 
    //post: se elimina la primera ocurrencia de n en la lista
    // Retorna true en caso de que lo haya podido borrar correctamente 
    // Retorna False en caso de que la lista este vacia o el elemento no exista
    public Boolean borrarElemento(T n);
    
    //pre: n es un objecto generico
    //post: retronar el nodo que contiene el dato n
    // si no existe en la lista , entonces retorna null
    public Nodo obtenerElemento(T n);
    
     //pre: n es un objecto generico
    //post: retronar true or false 
    public boolean buscarElemento(T n);
        
    //post: Retorna la cantidad de elementos de la lista
    public int cantElementos();
    
    //pre: recibe un nodo y un string donde se alamcenara 
    // el texto a retornar
    //post: muestra la lista en orden inverso (en forma recursiva)
    public String mostrarREC(Nodo l, String texto);
    
    // pre: recibe un objeto generico
    // post: busca el elemento en la lista, 
    // si no lo encuentra entonces lo agrega al inicio y retorna true
    // si lo encuentra , no lo agrega y retorna false
    public Boolean agregarInicioSiNoExiste(T n);
    
    // pre: recibe un objeto generico
    // post: busca el elemento en la lista, 
    // si no lo encuentra entonces lo agrega al inicio y retorna true
    // si lo encuentra , no lo agrega y retorna false
    public Boolean agregarFinalSiNoExiste(T n);
    
    // pre: recibe un objeto generico
    // post: si encuentra el objeto lo elimina de la lista
    // y ademas retorna el elemento eliminado
    public T borrarElementoRetObjeto(T n);
    
    //pre : --
    //post: ordena la lista de manera descendiente utilizando el metodo de la burbuja
    // la ordena segun el criterio de comparacion del objeto generico
    public void ordenarDescBurbuja();
    
  
}
