package trabajarconobligatorio;

import Clases.Contacto;
import Clases.Diccionario;
import Clases.Linea;
import Clases.Mensaje;
import Clases.Palabra;
import Estructuras.Lista;
import Estructuras.Listadoble;
import Estructuras.Nodo;
import Estructuras.NodoDoble;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Obligatorio implements IObligatorio {

    public static int MAX_CANT_PALABRAS_X_LINEA;
    public Lista<Contacto> listaContactos;
    public Diccionario diccionario;

    public Lista<Contacto> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(Lista<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }

    public Diccionario getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Diccionario diccionario) {
        this.diccionario = diccionario;
    }

    public Obligatorio() {
        this.listaContactos = null;
        this.diccionario = null;
        this.MAX_CANT_PALABRAS_X_LINEA = 0;
    }

    @Override
    public Retorno crearSistemaMensajes(int MAX_CANT_PALABRAS_X_LINEA) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        this.MAX_CANT_PALABRAS_X_LINEA = MAX_CANT_PALABRAS_X_LINEA;
        this.setListaContactos(new Lista<Contacto>());
        this.setDiccionario(new Diccionario());
       

        return ret;
    }

    @Override
    public Retorno destruirSistemaMensajes() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        this.listaContactos = null;
        this.diccionario = null;
        this.MAX_CANT_PALABRAS_X_LINEA = 0;
        return ret;
    }

    @Override
    public Retorno agregarContacto(int numContacto, String nomContacto) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoAAgregar = new Contacto(numContacto, nomContacto);

        if (!listaContactos.buscarElemento(contactoAAgregar)) {
            listaContactos.agregarInicio(contactoAAgregar);
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno eliminarContacto(int numContacto) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoAEliminar = new Contacto();
        contactoAEliminar.numero = numContacto;

        if (listaContactos.buscarElemento(contactoAEliminar)) {
            listaContactos.borrarElemento(contactoAEliminar);
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    // Pre-condicion: Los mensajes se agregan cronologicamente.
    @Override
    public Retorno agregarMensaje(int numContactoOrigen, int numContactoDestino, Date fecha) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        Contacto contactoDestino = new Contacto();
        contactoDestino.numero = numContactoDestino;

        if (listaContactos.buscarElemento(contactoOrigen) && listaContactos.buscarElemento(contactoDestino)) {

            Mensaje nuevoMensaje = new Mensaje(numContactoOrigen, numContactoDestino, fecha);

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();
            
            contactoDestino = (Contacto) listaContactos.obtenerElemento(contactoDestino).getDato();

            contactoOrigen.listaMensajes.agregarInicio(nuevoMensaje);
           
            // nuevo
//            contactoDestino.listaMensajes.agregarInicio(nuevoMensaje);
        } else {

            ret.resultado = Retorno.Resultado.ERROR;

        }

        return ret;
    }

    @Override
    public Retorno eliminarMensaje(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            Mensaje mensajeABuscar = new Mensaje();
            mensajeABuscar.numMensaje = numMensaje;

            if (contactoOrigen.listaMensajes.buscarelemento(mensajeABuscar)) {
                contactoOrigen.listaMensajes.borrarElemento(mensajeABuscar);

            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno imprimirTexto(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        ret.valorString = "";
        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            Mensaje mensajeABuscar = new Mensaje();
            mensajeABuscar.numMensaje = numMensaje;

            if (contactoOrigen.listaMensajes.buscarelemento(mensajeABuscar)) {

                mensajeABuscar = (Mensaje) contactoOrigen.listaMensajes.obtenerElemento(mensajeABuscar).getDato();

                Linea linea = new Linea();

                ret.valorString += "\n";
                
                if( mensajeABuscar.listaLineas.cantElementos() != 0){
                    for (int i = 1; i <= mensajeABuscar.listaLineas.cantElementos(); i++) {

                    linea = (Linea) mensajeABuscar.listaLineas.GetElementoPorPosicion(i).getDato();
                    
                    ret.valorString += i + ": ";
                    for (int j = 1; j <= linea.listaPalabra.cantElementos(); j++) {
                        ret.valorString += linea.listaPalabra.GetElementoPorPosicion(j).getDato();
                    }
                    
                    ret.valorString += "\n";
                }
                    
                } else {
                
                ret.valorString = "Texto Vacio";
                }
                

            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno insertarLinea(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            Mensaje mensajeABuscar = new Mensaje();
            mensajeABuscar.numMensaje = numMensaje;

            if (contactoOrigen.listaMensajes.buscarelemento(mensajeABuscar)) {

                Linea lineaNueva = new Linea();

                mensajeABuscar = (Mensaje) contactoOrigen.listaMensajes.obtenerElemento(mensajeABuscar).getDato();
                mensajeABuscar.getListaLineas().insertarRecursivo(lineaNueva);

            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno insertarLineaEnPosicion(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            Mensaje mensajeAInsertarLinea = new Mensaje();
            mensajeAInsertarLinea.numMensaje = numMensaje;

            if (contactoOrigen.listaMensajes.buscarelemento(mensajeAInsertarLinea)) {

                mensajeAInsertarLinea = (Mensaje) contactoOrigen.listaMensajes.obtenerElemento(mensajeAInsertarLinea).getDato();

                if (posicionLinea >= 1 && posicionLinea <= mensajeAInsertarLinea.listaLineas.cantElementos() + 1) {

                    Linea lineaNueva = new Linea();

                    if (mensajeAInsertarLinea.listaLineas.esVacia() || posicionLinea == 1) {
                        mensajeAInsertarLinea.listaLineas.agregarInicio(lineaNueva);
                    } else {

                        Linea primeraLinea = (Linea) mensajeAInsertarLinea.listaLineas.getPrimero().getDato();

                        // Si el index de la linea a insertar es menor a la primero, la linea a insertar va primera
                        if (mensajeAInsertarLinea.listaLineas.IndiceDe(primeraLinea) > posicionLinea) {
                            mensajeAInsertarLinea.listaLineas.agregarInicio(lineaNueva);

                        } else {

                            Linea ultimaLinea = (Linea) mensajeAInsertarLinea.listaLineas.getUltimo().getDato();

                            // Si el index de la palabra a insertar es mayor a la ultima, se agrega al final
                            if (mensajeAInsertarLinea.listaLineas.IndiceDe(ultimaLinea) < posicionLinea) {
                                mensajeAInsertarLinea.listaLineas.agregarFinal(lineaNueva);
                            } else {

                                NodoDoble aux = mensajeAInsertarLinea.listaLineas.getPrimero();
                                Linea lineaAComparar = (Linea) aux.getDato();

                                // mientras haya nodos y el indice de la palabra a insertar sea mayor que la palabra a comprar, seguir recorriendo
                                while (aux != null && mensajeAInsertarLinea.listaLineas.IndiceDe(lineaAComparar) < posicionLinea) {
                                    aux = aux.getSig();
                                    lineaAComparar = (Linea) aux.getDato();
                                }

                                NodoDoble NodoLinea = new NodoDoble(lineaNueva);

                                aux.getAnterior().setSiguiente(NodoLinea);
                                NodoLinea.setSiguiente(aux);
                                NodoLinea.setAnt(aux.getAnterior());
                                aux.setAnt(NodoLinea);
                                mensajeAInsertarLinea.listaLineas.cantnodos = mensajeAInsertarLinea.listaLineas.cantnodos + 1;
                            }
                        }

                    }

                } else {
                    ret.resultado = Retorno.Resultado.ERROR;
                }

            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno borrarLinea(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            Mensaje mensajeABuscar = new Mensaje();
            mensajeABuscar.numMensaje = numMensaje;

            if (contactoOrigen.listaMensajes.buscarelemento(mensajeABuscar)) {

                // Adentro de este mensaje estan las lineas
                mensajeABuscar = (Mensaje) contactoOrigen.listaMensajes.obtenerElemento(mensajeABuscar).getDato();

                if (posicionLinea >= 1 && posicionLinea <= mensajeABuscar.listaLineas.cantElementos()) {

                    Linea lineaAEliminar = (Linea) mensajeABuscar.listaLineas.GetElementoPorPosicion(posicionLinea).getDato();

                    if (lineaAEliminar != null) {
                        mensajeABuscar.listaLineas.borrarElemento(lineaAEliminar);
                    } else {
                        ret.resultado = Retorno.Resultado.ERROR;
                    }

                } else {

                    ret.resultado = Retorno.Resultado.ERROR;

                }

            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno borrarTodo(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            Mensaje mensajeABuscar = new Mensaje();
            mensajeABuscar.numMensaje = numMensaje;

            if (contactoOrigen.listaMensajes.buscarelemento(mensajeABuscar)) {

                // Adentro de este mensaje estan las lineas
                mensajeABuscar = (Mensaje) contactoOrigen.listaMensajes.obtenerElemento(mensajeABuscar).getDato();

                mensajeABuscar.listaLineas.borrarRecursivo(mensajeABuscar.listaLineas.getPrimero());

            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;

    }

    @Override
    public Retorno borrarOcurrenciasPalabraEnTexto(int numContactoOrigen, int numMensaje, String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            Mensaje mensajeABuscar = new Mensaje();
            mensajeABuscar.numMensaje = numMensaje;

            if (contactoOrigen.listaMensajes.buscarelemento(mensajeABuscar)) {

                // Adentro de este mensaje estan las lineas
                mensajeABuscar = (Mensaje) contactoOrigen.listaMensajes.obtenerElemento(mensajeABuscar).getDato();

                NodoDoble auxLine = mensajeABuscar.listaLineas.getPrimero();
                Palabra p = new Palabra(palabraABorrar);

                while (auxLine != null) {
                    Linea l = (Linea) auxLine.getDato();
                    l.listaPalabra.borrarOcurrenciaRecursivo(l.listaPalabra.getPrimero(), p);

                    auxLine = auxLine.getSig();
                }

            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno insertarPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            Mensaje mensajeABuscar = new Mensaje();
            mensajeABuscar.numMensaje = numMensaje;

            if (contactoOrigen.listaMensajes.buscarelemento(mensajeABuscar)) {

                // Adentro de este mensaje estan las lineas
                mensajeABuscar = (Mensaje) contactoOrigen.listaMensajes.obtenerElemento(mensajeABuscar).getDato();

                NodoDoble nodoLinea = mensajeABuscar.listaLineas.GetElementoPorPosicion(posicionLinea);

                if (nodoLinea != null) {
                    Linea lineaAInsertarPalabra = (Linea) mensajeABuscar.listaLineas.GetElementoPorPosicion(posicionLinea).getDato();
                    
                    if (lineaAInsertarPalabra.listaPalabra.cantElementos() < MAX_CANT_PALABRAS_X_LINEA) {
                        
                        if (posicionPalabra >= 1 && posicionPalabra <= lineaAInsertarPalabra.listaPalabra.cantElementos() + 1) {

                            Palabra palabraNueva = new Palabra(palabraAIngresar);

                            if (lineaAInsertarPalabra.listaPalabra.esVacia() || posicionPalabra == 1) {
                                lineaAInsertarPalabra.listaPalabra.agregarInicio(palabraNueva);
                            } else {
                                Palabra primerPalabra = (Palabra) lineaAInsertarPalabra.listaPalabra.getPrimero().getDato();
                                
                                // Si el index de la palabra a insertar es menor al primero, la palabra a insertar va primera
                                if (lineaAInsertarPalabra.listaPalabra.IndiceDe(primerPalabra) > posicionPalabra) {
                                    lineaAInsertarPalabra.listaPalabra.agregarInicio(palabraNueva);
                                } else {

                                    Palabra ultimaPalabra = (Palabra) lineaAInsertarPalabra.listaPalabra.getUltimo().getDato();

                                    int indexUltimaPalabra = lineaAInsertarPalabra.listaPalabra.IndiceDe(ultimaPalabra);
                                    
                                    // Si el index de la palabra a insertar es mayor a la ultima, se agrega al final
                                    if (lineaAInsertarPalabra.listaPalabra.IndiceDe(ultimaPalabra) < posicionPalabra) {
                                        lineaAInsertarPalabra.listaPalabra.agregarFinal(palabraNueva);
                                    } else {
                                        
                                        NodoDoble aux = lineaAInsertarPalabra.listaPalabra.getPrimero();
                                        Palabra palabraAComparar = (Palabra) aux.getDato();

                                        // mientras haya nodos y el indice de la palabra a insertar sea mayor que la palabra a comprar, seguir recorriendo
                                        while (aux != null && lineaAInsertarPalabra.listaPalabra.IndiceDe(palabraAComparar) < posicionPalabra) {
                                            aux = aux.getSig();
                                            palabraAComparar = (Palabra) aux.getDato();
                                        }
                                        
                                        NodoDoble pNodo = new NodoDoble(palabraNueva);

                                        aux.getAnterior().setSiguiente(pNodo);
                                        pNodo.setSiguiente(aux);
                                        pNodo.setAnt(aux.getAnterior());
                                        aux.setAnt(pNodo);
                                        lineaAInsertarPalabra.listaPalabra.cantnodos = lineaAInsertarPalabra.listaPalabra.cantnodos + 1;
                                    }
                                }

                            }

                        } else {
                            ret.resultado = Retorno.Resultado.ERROR;
                        }

                    } else {
                        ret.resultado = Retorno.Resultado.ERROR;
                    }

                } else {
                    ret.resultado = Retorno.Resultado.ERROR;
                }

            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    // Pre-condicion: La linea en la que insertamos deberia estar llena, sino seria una simple insercion
    @Override
    public Retorno insertarPalabraYDesplazar(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            Mensaje mensajeABuscar = new Mensaje();
            mensajeABuscar.numMensaje = numMensaje;

            if (contactoOrigen.listaMensajes.buscarelemento(mensajeABuscar)) {

                mensajeABuscar = (Mensaje) contactoOrigen.listaMensajes.obtenerElemento(mensajeABuscar).getDato();

                Linea lineaAInsertarPalabra = (Linea) mensajeABuscar.listaLineas.GetElementoPorPosicion(posicionLinea).getDato();

                if (lineaAInsertarPalabra != null) {

                    if (lineaAInsertarPalabra.listaPalabra.cantElementos() < MAX_CANT_PALABRAS_X_LINEA) {

                        if (posicionPalabra >= 1 && posicionPalabra <= lineaAInsertarPalabra.listaPalabra.cantElementos() + 1) {

                            this.insertarPalabraEnLinea(numContactoOrigen, numMensaje, posicionLinea, posicionPalabra, palabraAIngresar);

                        } else {
                            ret.resultado = Retorno.Resultado.ERROR;
                        }

                    } else {

                        if (lineaAInsertarPalabra.listaPalabra.cantElementos() == MAX_CANT_PALABRAS_X_LINEA) {

                            Palabra palabraAMover = (Palabra) lineaAInsertarPalabra.listaPalabra.getUltimo().getDato();

                            lineaAInsertarPalabra.listaPalabra.borrarFin();

                            NodoDoble nodoLineaSiguiente = mensajeABuscar.listaLineas.GetElementoPorPosicion(posicionLinea + 1);

                            this.insertarPalabraEnLinea(numContactoOrigen, numMensaje, posicionLinea, posicionPalabra, palabraAIngresar);

                            if (nodoLineaSiguiente != null) {

                                Linea lineaSiguiente = (Linea) nodoLineaSiguiente.getDato();

                                if (lineaSiguiente.listaPalabra.cantElementos() == MAX_CANT_PALABRAS_X_LINEA) {
                                    this.insertarPalabraYDesplazar(numContactoOrigen, numMensaje, posicionLinea + 1, 1, palabraAMover.valor);
                                } else {
                                    lineaSiguiente.listaPalabra.agregarInicio(palabraAMover);
                                }

                            } else {
                                Linea lineaVacia = new Linea();
                                mensajeABuscar.listaLineas.agregarFinal(lineaVacia);
                                Linea lineaSiguiente = (Linea) mensajeABuscar.listaLineas.GetElementoPorPosicion(posicionLinea + 1).getDato();
                                lineaSiguiente.listaPalabra.agregarInicio(palabraAMover);
                            }
                        }
                    }

                } else {
                    ret.resultado = Retorno.Resultado.ERROR;
                }

            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno borrarPalabra(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            Mensaje mensajeABuscar = new Mensaje();
            mensajeABuscar.numMensaje = numMensaje;

            if (contactoOrigen.listaMensajes.buscarelemento(mensajeABuscar)) {

                // Adentro de este mensaje estan las lineas
                mensajeABuscar = (Mensaje) contactoOrigen.listaMensajes.obtenerElemento(mensajeABuscar).getDato();

                if (posicionLinea >= 1 && posicionLinea <= mensajeABuscar.listaLineas.cantElementos()) {

                    Linea lineaABuscar = (Linea) mensajeABuscar.listaLineas.GetElementoPorPosicion(posicionLinea).getDato();

                    if (lineaABuscar != null) {

                        if (posicionPalabra >= 1 && posicionPalabra <= lineaABuscar.listaPalabra.cantElementos()) {

                            Palabra palabraAEliminar = (Palabra) lineaABuscar.listaPalabra.GetElementoPorPosicion(posicionPalabra).getDato();

                            if (palabraAEliminar != null) {
                                lineaABuscar.listaPalabra.borrarElemento(palabraAEliminar);
                            } else {
                                ret.resultado = Retorno.Resultado.ERROR;

                            }

                        } else {
                            ret.resultado = Retorno.Resultado.ERROR;

                        }

                    } else {
                        ret.resultado = Retorno.Resultado.ERROR;
                    }

                } else {

                    ret.resultado = Retorno.Resultado.ERROR;

                }

            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno borrarOcurrenciasPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            Mensaje mensajeABuscar = new Mensaje();
            mensajeABuscar.numMensaje = numMensaje;

            if (contactoOrigen.listaMensajes.buscarelemento(mensajeABuscar)) {

                // Adentro de este mensaje estan las lineas
                mensajeABuscar = (Mensaje) contactoOrigen.listaMensajes.obtenerElemento(mensajeABuscar).getDato();

                if (posicionLinea >= 1 && posicionLinea <= mensajeABuscar.listaLineas.cantElementos()) {

                    Linea lineaAEliminarPalabra = (Linea) mensajeABuscar.listaLineas.GetElementoPorPosicion(posicionLinea).getDato();

                    if (lineaAEliminarPalabra != null && !lineaAEliminarPalabra.listaPalabra.esVacia()) {

                        Palabra palabraAEliminar = new Palabra(palabraABorrar);

                        NodoDoble aux = (NodoDoble) lineaAEliminarPalabra.listaPalabra.getPrimero();

                        while (aux != null) {
                            if (palabraAEliminar.equals(aux.getDato())) {
                                lineaAEliminarPalabra.listaPalabra.borrarElemento((Palabra) aux.getDato());
                            }
                            aux = aux.getSig();
                        }

                    } else {
                        ret.resultado = Retorno.Resultado.ERROR;
                    }

                } else {

                    ret.resultado = Retorno.Resultado.ERROR;

                }

            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno imprimirLinea(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        ret.valorString = "";
        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            Mensaje mensajeABuscar = new Mensaje();
            mensajeABuscar.numMensaje = numMensaje;

            if (contactoOrigen.listaMensajes.buscarelemento(mensajeABuscar)) {

                mensajeABuscar = (Mensaje) contactoOrigen.listaMensajes.obtenerElemento(mensajeABuscar).getDato();

                NodoDoble nodoLinea = mensajeABuscar.listaLineas.GetElementoPorPosicion(posicionLinea);

                if (nodoLinea != null) {

                    Linea linea = (Linea) mensajeABuscar.listaLineas.GetElementoPorPosicion(posicionLinea).getDato();

                    ret.valorString += posicionLinea + ": ";

                    for (int j = 1; j <= linea.listaPalabra.cantElementos(); j++) {

                        ret.valorString += linea.listaPalabra.GetElementoPorPosicion(j).getDato();
                    }
                    ret.valorString += "\n";

                } else {
                    ret.resultado = Retorno.Resultado.ERROR;

                }

            } else {
                ret.resultado = Retorno.Resultado.ERROR;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }

        return ret;
    }

    @Override
    public Retorno ingresarPalabraDiccionario(String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Palabra palabraABuscar = new Palabra(palabraAIngresar);

        if (!this.diccionario.listaPalabras.buscarelemento(palabraABuscar)) {
            this.diccionario.listaPalabras.agregarOrd(palabraABuscar);
        } else {
            ret.resultado = Retorno.Resultado.ERROR;

        }

        return ret;
    }

    @Override
    public Retorno imprimirDiccionario() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        int cantidadPalabras = this.diccionario.listaPalabras.cantElementos();

        for (int i = 1; i <= cantidadPalabras; i++) {
            Palabra palabraDiccionario = (Palabra) this.diccionario.listaPalabras.GetElementoPorPosicion(i).getDato();
            ret.valorString += i + ": " + palabraDiccionario.valor + "\n";
        }

        return ret;
    }

    @Override
    public Retorno ImprimirTextoIncorrecto() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        
        Listadoble palabrasIncorrectas = new Listadoble();

        Nodo aux = listaContactos.getInicio();

        while (aux != null) {
            Contacto c = (Contacto) aux.getDato();
            NodoDoble auxMsg = c.listaMensajes.getPrimero();
            while (auxMsg != null) {

                Mensaje m = (Mensaje) auxMsg.getDato();

                NodoDoble auxLine = m.listaLineas.getPrimero();

                while (auxLine != null) {

                    Linea l = (Linea) auxLine.getDato();

                    NodoDoble auxPalabra = l.listaPalabra.getPrimero();

                    while (auxPalabra != null) {

                        Palabra p = (Palabra) auxPalabra.getDato();

                        if (!this.existeEnDiccionario(p.valor) && !palabrasIncorrectas.buscarelemento(p)) {
                            palabrasIncorrectas.agregarOrd(p);
                        }
                        auxPalabra = auxPalabra.getSig();
                    }
                    auxLine = auxLine.getSig();
                }
                auxMsg = auxMsg.getSig();
            }
            aux = aux.getSiguiente();
        }
        
        for (int i = 1; i <= palabrasIncorrectas.cantElementos(); i++) {
            Palabra palabraIncorrecta = (Palabra) palabrasIncorrectas.GetElementoPorPosicion(i).getDato();
            ret.valorString += palabraIncorrecta.valor + "\n";
        }

        return ret;
    }

    public boolean existeEnDiccionario(String palabra) {
        Palabra palabraAbuscar = new Palabra(palabra);
        return diccionario.listaPalabras.buscarelemento(palabraAbuscar);

    }

    @Override
    public Retorno cantidadDeMensajes(int numContactoOrigen) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        Contacto contactoOrigen = new Contacto();
        contactoOrigen.numero = numContactoOrigen;

        if (listaContactos.buscarElemento(contactoOrigen)) {

            contactoOrigen = (Contacto) listaContactos.obtenerElemento(contactoOrigen).getDato();

            int cantColumnas = this.GetFechasUnicasPorContacto(numContactoOrigen, contactoOrigen.listaMensajes).getCantnodos() + 1;

            int cantFilas = this.DestinatariosUnicosPorContacto(contactoOrigen.numero, contactoOrigen.listaMensajes).getCantnodos() + 1;

            String[][] matriz = new String[cantFilas][cantColumnas];

            int cantElementos = cantColumnas * cantFilas;

            // Obtenemos las listas de fechas y nombres unicos
            Listadoble listaFechas = this.GetFechasUnicasPorContacto(numContactoOrigen, contactoOrigen.listaMensajes);
            Listadoble listaNombres = this.DestinatariosUnicosPorContacto(numContactoOrigen, contactoOrigen.listaMensajes);
            int c, f;

            //NodoDoble auxMsj = contactoOrigen.listaMensajes.getPrimero();
            NodoDoble fechaAux = listaFechas.getPrimero();
            NodoDoble nombreAux = listaNombres.getPrimero();
             
            // Ponemos fechas en la matriz // Ponemos nombres en la matriz // Ponemos datos en la matriz
            for (int i = 0; i < cantElementos; i++) {
                f = i / cantColumnas;
                c = i % cantColumnas;

                if (f == 0 && c == 0) {
                    matriz[f][c] = "                           ";
                } 
                if (f == 0 && c != 0) {
                        String n = String.valueOf(fechaAux.getDato());
                        matriz[f][c] = n + "  ";
                        fechaAux = fechaAux.getSig();
                }
                if (f != 0 && c == 0) {
                        String n = String.valueOf(nombreAux.getDato());
                        matriz[f][c] = n + "    ";
                        nombreAux = nombreAux.getSig();
                }
                if (f != 0 && c != 0) {

                        Date fecha = new Date();
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        String fechaMatriz = matriz[0][c];

                        try {
                            fecha = formato.parse(fechaMatriz);
                            String nombreYnumero = matriz[f][0];
                            String numeroMatriz = nombreYnumero.replaceAll("[^0-9]", "");

                            int numero = Integer.parseInt(numeroMatriz);

                            // Aca insertamos la cantidad de mensajes por fecha
                            matriz[f][c] = String.valueOf(this.CantidadDeMsjsPorContacto(numero, contactoOrigen.listaMensajes, fecha)) + "           ";
                        } catch (ParseException ex) {
                            Logger.getLogger(Obligatorio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                
            }  
            
            ret.valorString = this.mostrarmatriz(matriz);
        }

        return ret;
    }

    public int CantidadDeMsjsPorContacto(int numeroDestino, Listadoble listaMensajes, Date fechaMsj) {

        int cantidad = 0;

        NodoDoble auxMsg = listaMensajes.getPrimero();

        while (auxMsg != null) {

            Mensaje m = (Mensaje) auxMsg.getDato();
            Date fechaMensaje = m.fecha;

            if (m.numContactoDestino == numeroDestino && fechaMensaje.equals(fechaMsj)) {
                cantidad++;
            }
            auxMsg = auxMsg.getSig();
        }

        return cantidad;

    }

    public Listadoble DestinatariosUnicosPorContacto(int numeroContacto, Listadoble listaMensajes) {
        NodoDoble auxMsg = listaMensajes.getPrimero();

        Listadoble listaAux = new Listadoble();

        while (auxMsg != null) {

            Mensaje m = (Mensaje) auxMsg.getDato();

            Contacto cABuscar = new Contacto();
            cABuscar.numero = m.numContactoDestino;

            if (!listaAux.buscarelemento(cABuscar)) {

                cABuscar = (Contacto) this.listaContactos.obtenerElemento(cABuscar).getDato();
                listaAux.agregarInicio(cABuscar);

            }
            auxMsg = auxMsg.getSig();
        }

        return listaAux;
    }

    public Listadoble GetFechasUnicasPorContacto(int numeroContacto, Listadoble listaMensajes) {

        NodoDoble auxMsg = listaMensajes.getPrimero();
        Listadoble listaAux = new Listadoble();

        while (auxMsg != null) {

            Mensaje m = (Mensaje) auxMsg.getDato();

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            String fechaABuscar = formatter.format(m.fecha);

            if (!listaAux.buscarelemento(fechaABuscar)) {

                listaAux.agregarInicio(fechaABuscar);
            }
            auxMsg = auxMsg.getSig();
        }

        return listaAux;

    }

    public String mostrarmatriz(String[][] m) {
        String matriz = "";

        int columnas = m[0].length;
        int filas = m.length;
        int cantidadElementos = columnas * filas;
        int fila, columna;

        for (int i = 0; i < cantidadElementos; i++) {

            fila = i / columnas;
            columna = i % columnas;

            matriz += m[fila][columna] + " ";

            if (columna == columnas - 1) {
                matriz += "\n";
            }
        }
        return matriz;
    }

    @Override
    public Retorno imprimirContactos() {
        
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ret.valorString = "";
        
        for(int i = 1; i <= this.listaContactos.cantElementos(); i++){
            
            Contacto c = (Contacto) listaContactos.GetElementoPorPosicion(i).getDato();
            ret.valorString += c.toString();
            ret.valorString += "\n";
        }
        
        
        return ret;
        
    }
    

}
