
package trabajarconobligatorio;
import java.util.Date;


// Contactos: una lista (el nodo contactos, ademas de tener nombre, num, 
// va a tener un puntero a una lista vacia de mensajes)
// Cada contacto tiene una lista colgada de mensajes
// Cada mensaje se compone de una lista de lineas
// Cada linea tiene una lista de palabras

public interface IObligatorio {
Retorno crearSistemaMensajes(int MAX_CANT_PALABRAS_X_LINEA);
Retorno destruirSistemaMensajes();
Retorno imprimirContactos();
Retorno agregarContacto(int numContacto, String nomContacto);
Retorno eliminarContacto(int numContacto);
Retorno agregarMensaje(int numContactoOrigen, int numContactoDestino, Date fecha);
Retorno eliminarMensaje(int numContactoOrigen, int numMensaje);
Retorno imprimirTexto(int numContactoOrigen, int numMensaje);
Retorno insertarLinea(int numContactoOrigen, int numMensaje);
Retorno insertarLineaEnPosicion(int numContactoOrigen, int numMensaje, int posicionLinea);
Retorno borrarLinea(int numContactoOrigen, int numMensaje, int posicionLinea);
Retorno borrarTodo(int numContactoOrigen, int numMensaje);
Retorno borrarOcurrenciasPalabraEnTexto(int numContactoOrigen, int numMensaje, String palabraABorrar);
Retorno insertarPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar);
Retorno insertarPalabraYDesplazar(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar);
Retorno borrarPalabra(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra);
Retorno borrarOcurrenciasPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea , String palabraABorrar);
Retorno imprimirLinea(int numContactoOrigen, int numMensaje, int posicionLinea);
Retorno ingresarPalabraDiccionario(String palabraAIngresar);
Retorno imprimirDiccionario();
Retorno ImprimirTextoIncorrecto();
Retorno cantidadDeMensajes(int numContactoOrigen);

}
