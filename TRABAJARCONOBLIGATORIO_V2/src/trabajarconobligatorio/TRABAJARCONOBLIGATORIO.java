package trabajarconobligatorio;

import Clases.Contacto;
import Clases.Linea;
import Clases.Mensaje;
import Clases.Palabra;
import Estructuras.Lista;
import Estructuras.Listadoble;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TRABAJARCONOBLIGATORIO {

    public static void main(String[] args) throws ParseException {

        Obligatorio obl = new Obligatorio();
        Prueba p = new Prueba();
        juegodeprueba1(obl, p);
    }

    public static void juegodeprueba1(Obligatorio obl, Prueba p) throws ParseException {

        
        //==========================================================================================
        // ******************* JUEGO DE PRUEBA 1 *******************
        //==========================================================================================
        
        // Creamos Sistema de Mensajes
        System.out.println("-------------- Se crea sistema de mensajes --------------");
        obl.crearSistemaMensajes(4);

        //================================================================================
        // Agregando 4 Contactos
        //================================================================================
        System.out.println("-------------- Agregando Contactos --------------");

        p.ver(obl.agregarContacto(7114821, "Juan D. Perez").resultado, Retorno.Resultado.OK, "Se agrega contacto Juan D. Perez al sistema");
        p.ver(obl.agregarContacto(6224587, "Ana M. Rodriguez").resultado, Retorno.Resultado.OK, "Se agrega contacto Ana M. Rodriguez al sistema");
        p.ver(obl.agregarContacto(6238852, "Bea Huston Texas").resultado, Retorno.Resultado.OK, "Se agrega contacto Bea Huston Texas al sistema");
        p.ver(obl.agregarContacto(8524712, "Pedro Fibonaccii").resultado, Retorno.Resultado.OK, "Se agrega contacto Pedro Fibonacci al sistema");
        p.ver(obl.agregarContacto(7777771, "Mariana R.LaRoca").resultado, Retorno.Resultado.OK, "Se agrega contacto Mariana R.LaRoca al sistema");

        //================================================================================
        // Probamos agregar 2 contactos que ya existen
        //================================================================================
        System.out.println("-------------- Probamos agregar a 2 contactos que ya existen --------------");

        p.ver(obl.agregarContacto(7114821, "Juan Perez").resultado, Retorno.Resultado.ERROR, "Se intenta de agregar a Juan D. Perez al sistema nuevamente aunque ya existe");
        p.ver(obl.agregarContacto(7777771, "Mariana R.LaRoca").resultado, Retorno.Resultado.ERROR, "Se trata de agregar a Mariana R.LaRoca al sistema nuevamente aunque ya existe");

        //================================================================================
        // Imprimimos todos los contactos, observamos que no se agregaron los repetidos
        //================================================================================
        System.out.println("-------------- Imprimimos Lista de Contactos --------------");
        System.out.println(obl.listaContactos.mostrar());

        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        //===============================================================================================================
        // Agregamos mensajes, 8 son de Juan a los 4 contactos restantes, y 2 Mariana a Pedro. Un total de 10 mensajes.
        //===============================================================================================================
        System.out.println("-------------- Agregando Mensajes --------------");

        System.out.println("-------------- Agregando mensajes de Juan a los otros 4 contactos --------------");
        fecha = formato.parse("23/03/2022");
        p.ver(obl.agregarMensaje(7114821, 6224587, fecha).resultado, Retorno.Resultado.OK, "Se crea un mensaje entre Juan y Ana");

        fecha = formato.parse("26/03/2022");
        p.ver(obl.agregarMensaje(7114821, 6238852, fecha).resultado, Retorno.Resultado.OK, "Se crea un mensaje entre Juan y Bea");

        fecha = formato.parse("30/05/2022");
        p.ver(obl.agregarMensaje(7114821, 8524712, fecha).resultado, Retorno.Resultado.OK, "Se crea un mensaje entre Juan y Pedro");
        fecha = formato.parse("30/05/2022");
        p.ver(obl.agregarMensaje(7114821, 8524712, fecha).resultado, Retorno.Resultado.OK, "Se crea un mensaje entre Juan y Pedro");
        fecha = formato.parse("30/05/2022");
        p.ver(obl.agregarMensaje(7114821, 8524712, fecha).resultado, Retorno.Resultado.OK, "Se crea un mensaje entre Juan y Pedro");

        fecha = formato.parse("21/08/2022");
        p.ver(obl.agregarMensaje(7114821, 7777771, fecha).resultado, Retorno.Resultado.OK, "Se crea un mensaje entre Juan y Mariana");
        fecha = formato.parse("22/08/2022");
        p.ver(obl.agregarMensaje(7114821, 7777771, fecha).resultado, Retorno.Resultado.OK, "Se crea un mensaje entre Juan y Mariana");
        fecha = formato.parse("22/08/2022");
        p.ver(obl.agregarMensaje(7114821, 7777771, fecha).resultado, Retorno.Resultado.OK, "Se crea un mensaje entre Juan y Mariana");

        System.out.println("-------------- Agregando mensajes de Mariana a Pedro --------------");

        fecha = formato.parse("05/07/2022");
        p.ver(obl.agregarMensaje(7777771, 8524712, fecha).resultado, Retorno.Resultado.OK, "Se crea un mensaje entre Mariana y Pedro");
        fecha = formato.parse("06/008/2022");
        p.ver(obl.agregarMensaje(7777771, 8524712, fecha).resultado, Retorno.Resultado.OK, "Se crea un mensaje entre Mariana y Pedro");

        //================================================================================
        // Agregamos lineas
        //================================================================================
        System.out.println("-------------- Agregando Lineas a mensajes de Juan --------------");

        p.ver(obl.insertarLinea(7114821, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 al mensaje 1 de Juan Perez");
        p.ver(obl.insertarLinea(7114821, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 2 al mensaje 1 de Juan Perez");
        p.ver(obl.insertarLinea(7114821, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 3 al mensaje 1 de Juan Perez");
        p.ver(obl.insertarLinea(7114821, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 4 al mensaje 1 de Juan Perez");

        p.ver(obl.insertarLinea(7114821, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 1 al mensaje 2 de Juan Perez");
        p.ver(obl.insertarLinea(7114821, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 2 al mensaje 2 de Juan Perez");
        p.ver(obl.insertarLinea(7114821, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 3 al mensaje 2 de Juan Perez");
        p.ver(obl.insertarLinea(7114821, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 4 al mensaje 2 de Juan Perez");

        p.ver(obl.insertarLinea(7114821, 3).resultado, Retorno.Resultado.OK, "Se agrega linea 1 al mensaje 3 de Juan Perez");
        p.ver(obl.insertarLinea(7114821, 3).resultado, Retorno.Resultado.OK, "Se agrega linea 2 al mensaje 3 de Juan Perez");
        p.ver(obl.insertarLinea(7114821, 3).resultado, Retorno.Resultado.OK, "Se agrega linea 3 al mensaje 3 de Juan Perez");

        p.ver(obl.insertarLinea(7114821, 4).resultado, Retorno.Resultado.OK, "Se agrega linea 1 al mensaje 4 de Juan Perez");

        p.ver(obl.insertarLinea(7114821, 5).resultado, Retorno.Resultado.OK, "Se agrega linea 1 al mensaje 5 de Juan Perez");
        p.ver(obl.insertarLinea(7114821, 5).resultado, Retorno.Resultado.OK, "Se agrega linea 2 al mensaje 5 de Juan Perez");

        p.ver(obl.insertarLinea(7114821, 6).resultado, Retorno.Resultado.OK, "Se agrega linea 1 al mensaje 6 de Juan Perez");
        p.ver(obl.insertarLinea(7114821, 6).resultado, Retorno.Resultado.OK, "Se agrega linea 2 al mensaje 6 de Juan Perez");

        p.ver(obl.insertarLinea(7114821, 7).resultado, Retorno.Resultado.OK, "Se agrega linea 1 al mensaje 7 de Juan Perez");

        p.ver(obl.insertarLinea(7114821, 8).resultado, Retorno.Resultado.OK, "Se agrega linea 1 al mensaje 8 de Juan Perez");

        System.out.println("-------------- Agregando Lineas a mensajes de Mariana --------------");

        p.ver(obl.insertarLinea(7777771, 9).resultado, Retorno.Resultado.OK, "Se agrega linea 1 al mensaje 1 de Mariana");
        p.ver(obl.insertarLinea(7777771, 9).resultado, Retorno.Resultado.OK, "Se agrega linea 2 al mensaje 1 de Mariana");
        p.ver(obl.insertarLinea(7777771, 9).resultado, Retorno.Resultado.OK, "Se agrega linea 3 al mensaje 1 de Mariana");

        p.ver(obl.insertarLinea(7777771, 10).resultado, Retorno.Resultado.OK, "Se agrega linea 1 al mensaje 2 de Mariana");

        //================================================================================
        // Agregamos palabras a los mensajes
        //================================================================================
        System.out.println("-------------- Agregando Palabras --------------");

        System.out.println("-------------- Agregamos palabras al mensaje 1 de Juan. Para Ana --------------");

        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 1, 1, "Hola").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 1 del mensaje 1");
        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 1, 2, "Ana").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 1 del mensaje 1");
        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 1, 3, "Como").resultado, Retorno.Resultado.OK, "Se agrega Palabra 3 a linea 1 del mensaje 1");
        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 1, 4, "Te").resultado, Retorno.Resultado.OK, "Se agrega Palabra 4 a linea 1 del mensaje 1");

        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 2, 1, "Va?").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 2 del mensaje 1");
        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 2, 2, "Que").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 2 del mensaje 1");
        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 2, 3, "lindo").resultado, Retorno.Resultado.OK, "Se agrega Palabra 3 a linea 2 del mensaje 1");
        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 2, 4, "que").resultado, Retorno.Resultado.OK, "Se agrega Palabra a linea 2 del mensaje 1");

        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 3, 1, "Va").resultado, Retorno.Resultado.OK, "Se agrega Palabra a linea 3 del mensaje 1");
        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 3, 2, "a").resultado, Retorno.Resultado.OK, "Se agrega Palabra a linea 3 del mensaje 1");
        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 3, 3, "estar").resultado, Retorno.Resultado.OK, "Se agrega Palabra a linea 3 del mensaje 1");
        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 3, 4, "el").resultado, Retorno.Resultado.OK, "Se agrega Palabra a linea 3 del mensaje 1");

        p.ver(obl.insertarPalabraEnLinea(7114821, 1, 4, 1, "festival").resultado, Retorno.Resultado.OK, "Se agrega Palabra a linea 4 del mensaje 1");

        System.out.println("-------------- Agregamos palabras al mensaje 2 de Juan. Para Bea --------------");

        p.ver(obl.insertarPalabraEnLinea(7114821, 2, 1, 1, "Hola").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 1 del mensaje 2");
        p.ver(obl.insertarPalabraEnLinea(7114821, 2, 1, 2, "Bea").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 1 del mensaje 2");
        p.ver(obl.insertarPalabraEnLinea(7114821, 2, 1, 3, "Hola").resultado, Retorno.Resultado.OK, "Se agrega Palabra 3 a linea 1 del mensaje 2");

        p.ver(obl.insertarPalabraEnLinea(7114821, 2, 2, 1, "Todo").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 2 del mensaje 2");
        p.ver(obl.insertarPalabraEnLinea(7114821, 2, 2, 2, "Bien?").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 2 del mensaje 2");
        p.ver(obl.insertarPalabraEnLinea(7114821, 2, 2, 3, "Saludos").resultado, Retorno.Resultado.OK, "Se agrega Palabra 3 a linea 2 del mensaje 2");
        p.ver(obl.insertarPalabraEnLinea(7114821, 2, 2, 4, "A").resultado, Retorno.Resultado.OK, "Se agrega Palabra 4 a linea 2 del mensaje 2");

        p.ver(obl.insertarPalabraEnLinea(7114821, 2, 3, 1, "Jorge").resultado, Retorno.Resultado.OK, "Se agrega Palabra a linea 3 del mensaje 1");

        System.out.println("-------------- Agregamos palabras al mensaje 3 de Juan. Para pedro --------------");

        p.ver(obl.insertarPalabraEnLinea(7114821, 3, 1, 1, "Aloha").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 1 del mensaje 3");
        p.ver(obl.insertarPalabraEnLinea(7114821, 3, 1, 2, "Pedro").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 1 del mensaje 3");
        p.ver(obl.insertarPalabraEnLinea(7114821, 3, 1, 3, "como").resultado, Retorno.Resultado.OK, "Se agrega Palabra 3 a linea 1 del mensaje 3");
        p.ver(obl.insertarPalabraEnLinea(7114821, 3, 1, 4, "va").resultado, Retorno.Resultado.OK, "Se agrega Palabra 4 a linea 1 del mensaje 3");

        p.ver(obl.insertarPalabraEnLinea(7114821, 3, 2, 1, "Aca").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 2 del mensaje 3");
        p.ver(obl.insertarPalabraEnLinea(7114821, 3, 2, 2, "en").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 2 del mensaje 3");
        p.ver(obl.insertarPalabraEnLinea(7114821, 3, 2, 3, "Hawaii").resultado, Retorno.Resultado.OK, "Se agrega Palabra 3 a linea 2 del mensaje 3");
        p.ver(obl.insertarPalabraEnLinea(7114821, 3, 2, 4, "tomando").resultado, Retorno.Resultado.OK, "Se agrega Palabra 4 a linea 2 del mensaje 3");

        p.ver(obl.insertarPalabraEnLinea(7114821, 3, 3, 1, "un").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 3 del mensaje 1");
        p.ver(obl.insertarPalabraEnLinea(7114821, 3, 3, 2, "trago").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 3 del mensaje 1");

        System.out.println("-------------- Agregamos palabras al mensaje 4 de Juan. Para pedro --------------");

        p.ver(obl.insertarPalabraEnLinea(7114821, 4, 1, 1, "Saludos").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 1 del mensaje 4");

        System.out.println("-------------- Agregamos palabras al mensaje 5 de Juan. Para pedro --------------");
        p.ver(obl.insertarPalabraEnLinea(7114821, 5, 1, 1, "Feliz").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 1 del mensaje 5");
        p.ver(obl.insertarPalabraEnLinea(7114821, 5, 1, 2, "Cumple").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 1 del mensaje 5");
        p.ver(obl.insertarPalabraEnLinea(7114821, 5, 2, 1, "Saludos").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 2 del mensaje 5");

        System.out.println("-------------- Agregamos palabras al mensaje 6 de Juan. Para Mariana --------------");
        p.ver(obl.insertarPalabraEnLinea(7114821, 6, 1, 1, "Hola").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 1 del mensaje 6");
        p.ver(obl.insertarPalabraEnLinea(7114821, 6, 2, 1, "Que").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 2 del mensaje 6");
        p.ver(obl.insertarPalabraEnLinea(7114821, 6, 2, 2, "andas").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 2 del mensaje 6");

        System.out.println("-------------- Agregamos palabras al mensaje 7 de Juan. Para Mariana --------------");
        p.ver(obl.insertarPalabraEnLinea(7114821, 7, 1, 1, "Ya").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 1 del mensaje 7");
        p.ver(obl.insertarPalabraEnLinea(7114821, 7, 1, 2, "Llegando").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 1 del mensaje 7");

        System.out.println("-------------- Agregamos palabras al mensaje 8 de Juan. Para Mariana --------------");
        p.ver(obl.insertarPalabraEnLinea(7114821, 8, 1, 1, "Estoy").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 1 del mensaje 8");
        p.ver(obl.insertarPalabraEnLinea(7114821, 8, 1, 2, "Afuera").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 1 del mensaje 8");

        System.out.println("-------------- Agregamos palabras al mensaje 9 de Mariana. Para Pedro --------------");

        p.ver(obl.insertarPalabraEnLinea(7777771, 9, 1, 1, "Pedro").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 1 del mensaje 9");
        p.ver(obl.insertarPalabraEnLinea(7777771, 9, 1, 2, "Como").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 1 del mensaje 9");
        p.ver(obl.insertarPalabraEnLinea(7777771, 9, 1, 3, "Te").resultado, Retorno.Resultado.OK, "Se agrega Palabra 3 a linea 1 del mensaje 9");
        p.ver(obl.insertarPalabraEnLinea(7777771, 9, 1, 4, "Va").resultado, Retorno.Resultado.OK, "Se agrega Palabra 4 a linea 1 del mensaje 9");

        p.ver(obl.insertarPalabraEnLinea(7777771, 9, 2, 1, "Te").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 2 del mensaje 9");
        p.ver(obl.insertarPalabraEnLinea(7777771, 9, 2, 2, "extrañamos").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 2 del mensaje 9");
        p.ver(obl.insertarPalabraEnLinea(7777771, 9, 2, 3, "aca").resultado, Retorno.Resultado.OK, "Se agrega Palabra 3 a linea 2 del mensaje 9");
        p.ver(obl.insertarPalabraEnLinea(7777771, 9, 2, 4, "en").resultado, Retorno.Resultado.OK, "Se agrega Palabra 4 a linea 2 del mensaje 9");

        p.ver(obl.insertarPalabraEnLinea(7777771, 9, 3, 1, "Italia").resultado, Retorno.Resultado.OK, "Se agrega Palabra a linea 3 del mensaje 9");
        p.ver(obl.insertarPalabraEnLinea(7777771, 9, 3, 2, "Venite").resultado, Retorno.Resultado.OK, "Se agrega Palabra a linea 3 del mensaje 9");
        p.ver(obl.insertarPalabraEnLinea(7777771, 9, 3, 3, "pronto").resultado, Retorno.Resultado.OK, "Se agrega Palabra a linea 3 del mensaje 9");
        p.ver(obl.insertarPalabraEnLinea(7777771, 9, 3, 4, "saludos").resultado, Retorno.Resultado.OK, "Se agrega Palabra a linea 3 del mensaje 9");

        System.out.println("-------------- Agregamos palabras al mensaje 10 de Mariana. Para Pedro --------------");
        p.ver(obl.insertarPalabraEnLinea(7777771, 10, 1, 1, "Tenemos").resultado, Retorno.Resultado.OK, "Se agrega Palabra 1 a linea 1 del mensaje 9");
        p.ver(obl.insertarPalabraEnLinea(7777771, 10, 1, 2, "Comida").resultado, Retorno.Resultado.OK, "Se agrega Palabra 2 a linea 1 del mensaje 9");
        p.ver(obl.insertarPalabraEnLinea(7777771, 10, 1, 3, "Apurate").resultado, Retorno.Resultado.OK, "Se agrega Palabra 3 a linea 1 del mensaje 9");

        //================================================================================
        // Imprimimos todos los mensajes
        //================================================================================
        System.out.println("-------------- Imprimimos todos los mensajes --------------");

        System.out.println("-------------- Imprimimos mensaje 1 de Juan. Para Ana --------------");
        p.ver(obl.imprimirTexto(7114821, 1).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 1).valorString);

        System.out.println("-------------- Imprimimos mensaje 2 de Juan. Para Bea --------------");
        p.ver(obl.imprimirTexto(7114821, 2).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 2).valorString);

        System.out.println("-------------- Imprimimos mensaje 3 de Juan. Para Pedro --------------");
        p.ver(obl.imprimirTexto(7114821, 3).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 3).valorString);

        System.out.println("-------------- Imprimimos mensaje 4 de Juan. Para Pedro --------------");
        p.ver(obl.imprimirTexto(7114821, 4).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 4).valorString);

        System.out.println("-------------- Imprimimos mensaje 5 de Juan. Para Pedro --------------");
        p.ver(obl.imprimirTexto(7114821, 5).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 5).valorString);

        System.out.println("-------------- Imprimimos mensaje 6 de Juan. Para Mariana --------------");
        p.ver(obl.imprimirTexto(7114821, 6).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 6).valorString);

        System.out.println("-------------- Imprimimos mensaje 7 de Juan. Para Mariana --------------");
        p.ver(obl.imprimirTexto(7114821, 7).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 7).valorString);

        System.out.println("-------------- Imprimimos mensaje 8 de Juan. Para Mariana --------------");
        p.ver(obl.imprimirTexto(7114821, 8).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 8).valorString);

        System.out.println("-------------- Imprimimos mensaje 9 de Mariana. Para Pedro --------------");
        p.ver(obl.imprimirTexto(7777771, 9).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7777771, 9).valorString);

        System.out.println("-------------- Imprimimos mensaje 10 de Mariana. Para Pedro --------------");
        p.ver(obl.imprimirTexto(7777771, 10).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7777771, 10).valorString);

        //================================================================================
        // Pruebas de Inserción de palabras y desplazar 
        //================================================================================
        System.out.println("-------------- ********* Pruebas de Inserción de palabras y desplazar ******** --------------");

        System.out.println("-------------- Mensaje 9 Original:--------------");
        p.ver(obl.imprimirTexto(7777771, 9).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7777771, 9).valorString);

        System.out.println("-------------- Insertamos la palabra 'mucho' en posicion 3, linea 2, mensaje 9:--------------");
        p.ver(obl.insertarPalabraYDesplazar(7777771, 9, 2, 3, "mucho").resultado, Retorno.Resultado.OK, "Insertamos palabra 'mucho'");

        System.out.println("-------------- Mensaje 9 despues de insertar la palabra 'mucho':--------------");
        p.ver(obl.imprimirTexto(7777771, 9).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7777771, 9).valorString);

        System.out.println("-------------- Insertamos la palabra 'amigo', linea 1, posicion 2, en linea llena, y la linea de abajo tambien esta llena:--------------");
        p.ver(obl.insertarPalabraYDesplazar(7777771, 9, 1, 2, "amigo").resultado, Retorno.Resultado.OK, "Insertamos palabra 'amigo'");

        System.out.println("-------------- Mensaje 9 despues de insertar la palabra 'amigo', vemos como hay 2 desplazamientos:--------------");
        p.ver(obl.imprimirTexto(7777771, 9).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7777771, 9).valorString);

        //================================================================================
        // Pruebas de Inserción de lineas vacias en posición
        //================================================================================
        System.out.println("-------------- ********* Pruebas de Inserción de lineas vacias en posición ******** --------------");

        System.out.println("-------------- Mensaje 2 Original:--------------");
        p.ver(obl.imprimirTexto(7114821, 1).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 1).valorString);

        p.ver(obl.insertarLineaEnPosicion(7114821, 1, 4).resultado, Retorno.Resultado.OK, "insertamos linea en posicion 4");

        System.out.println("-------------- Mensaje con 2 linea insertada en pos 4:--------------");
        p.ver(obl.imprimirTexto(7114821, 1).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 1).valorString);

        p.ver(obl.insertarLineaEnPosicion(7114821, 1, 2).resultado, Retorno.Resultado.OK, "insertamos linea en posicion 2");

        System.out.println("-------------- Mensaje con 2 linea insertada en pos 2:--------------");
        p.ver(obl.imprimirTexto(7114821, 1).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 1).valorString);

        System.out.println("-------------- Insertamos linea en dos posiciones NO VALIDAS, esperamos ERROR:--------------");
        p.ver(obl.insertarLineaEnPosicion(7114821, 1, 8).resultado, Retorno.Resultado.ERROR, "insertamos linea en posicion 8, esperamos ERROR");
        p.ver(obl.insertarLineaEnPosicion(7114821, 1, -3).resultado, Retorno.Resultado.ERROR, "insertamos linea en posicion -3, esperamos ERROR");

        //================================================================================
        // Pruebas de Inserción de palabras en posición
        //================================================================================
        System.out.println("-------------- ********* Pruebas de Inserción de palabras en posición ******** --------------");

        System.out.println("-------------- Mensaje 10 Original:--------------");
        p.ver(obl.imprimirTexto(7777771, 10).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7777771, 10).valorString);

        p.ver(obl.insertarPalabraEnLinea(7777771, 10, 1, 3, "Caliente").resultado, Retorno.Resultado.OK, "Se agrega Palabra 'Caliente!' a mensaje 10, posicion 3");

        System.out.println("-------------- Mensaje 10 con palabra 'Caliente!' Ingresada en posicion 3, se puedne probar otras posiciones para variar:--------------");
        p.ver(obl.imprimirTexto(7777771, 10).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7777771, 10).valorString);

        System.out.println("-------------- Tratamos de Insertar palabra en dos posiciones NO VALIDAS, esperamos ERROR:--------------");
        p.ver(obl.insertarPalabraEnLinea(7777771, 10, 1, 5, "Prueba1").resultado, Retorno.Resultado.ERROR, "Intentamos agregar Palabra en posición no valida");
        p.ver(obl.insertarPalabraEnLinea(7777771, 10, 1, 6, "Prueba2").resultado, Retorno.Resultado.ERROR, "Intentamos agregar Palabra en posición no valida");

        //================================================================================
        // Imprimimos lineas variadas de varios mensajes
        //================================================================================
        p.ver(obl.imprimirLinea(7114821, 1, 3).resultado, Retorno.Resultado.OK, "Imprimiendo linea 3, mensaje 1: \n" + obl.imprimirLinea(7114821, 1, 4).valorString);

        p.ver(obl.imprimirLinea(7114821, 2, 2).resultado, Retorno.Resultado.OK, "Imprimiendo linea 2, mensaje 2: \n" + obl.imprimirLinea(7114821, 2, 2).valorString);

        p.ver(obl.imprimirLinea(7114821, 3, 1).resultado, Retorno.Resultado.OK, "Imprimiendo linea 1, mensaje 3: \n" + obl.imprimirLinea(7114821, 3, 1).valorString);

        p.ver(obl.imprimirLinea(7114821, 6, 2).resultado, Retorno.Resultado.OK, "Imprimiendo linea 2, mensaje 6: \n" + obl.imprimirLinea(7114821, 6, 2).valorString);

        p.ver(obl.imprimirLinea(7114821, 6, 2).resultado, Retorno.Resultado.OK, "Imprimiendo linea 2, mensaje 6: \n" + obl.imprimirLinea(7114821, 6, 2).valorString);

        p.ver(obl.imprimirLinea(7777771, 9, 3).resultado, Retorno.Resultado.OK, "Imprimiendo linea 3, mensaje 9: \n" + obl.imprimirLinea(7777771, 9, 3).valorString);

        System.out.println("-------------- Probamos imprimir lineas que no existen:--------------");

        p.ver(obl.imprimirLinea(7777771, 10, 2).resultado, Retorno.Resultado.ERROR, "Probamos imprimir linea 2 que no existe, del mensaje 10: \n" + obl.imprimirLinea(7777771, 10, 2).valorString);
        p.ver(obl.imprimirLinea(7114821, 6, 7).resultado, Retorno.Resultado.ERROR, "Probamos imprimir linea 7 que no existe, del mensaje 6: \n" + obl.imprimirLinea(7777771, 10, 2).valorString);

        //================================================================================
        // Eliminacion de Mensajes
        //================================================================================
        p.ver(obl.eliminarMensaje(7777771, 10).resultado, Retorno.Resultado.OK, "Eliminando mensaje 10");

        System.out.println("-------------- Probamos imprimir el mensaje 10, pero ya no existe, esperamos ERROR --------------");
        p.ver(obl.imprimirTexto(7777771, 10).resultado, Retorno.Resultado.ERROR, obl.imprimirTexto(7777771, 10).valorString);

        //================================================================================
        // Eliminacion de Ocurrencia de manera RECURSIVA en mensaje
        //================================================================================
        System.out.println("-------------- Imprimimos mensaje 9, para luego borrar la palabra 'Te' (la tiene 2 veces) --------------");
        p.ver(obl.imprimirTexto(7777771, 9).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7777771, 9).valorString);

        p.ver(obl.borrarOcurrenciasPalabraEnTexto(7777771, 9, "Te").resultado, Retorno.Resultado.OK, "Borramos la ocurrencia de la palabra 'Te'");

        System.out.println("-------------- Mensaje 9 sin la palabra 'Te'--------------");
        p.ver(obl.imprimirTexto(7777771, 9).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7777771, 9).valorString);

        //================================================================================
        // Eliminacion de Ocurrencia en Linea
        //================================================================================
        System.out.println("-------------- Imprimimos mensaje 2, Linea 1, que tiene la palabra Hola REPETIDA --------------");
        p.ver(obl.imprimirLinea(7114821, 2, 1).resultado, Retorno.Resultado.OK, "Imprimiendo linea 1, mensaje 2: \n" + obl.imprimirLinea(7114821, 2, 1).valorString);

        p.ver(obl.borrarOcurrenciasPalabraEnLinea(7114821, 2, 1, "Hola").resultado, Retorno.Resultado.OK, "Borrando palabra 'Hola' de mensaje 2, linea 1");

        System.out.println("-------------- Imprimimos mensaje 2, Linea 1, ahora sin la palabra 'Hola'--------------");
        p.ver(obl.imprimirLinea(7114821, 2, 1).resultado, Retorno.Resultado.OK, "Imprimiendo linea 1, mensaje 2: \n" + obl.imprimirLinea(7114821, 2, 1).valorString);

        //================================================================================
        // Eliminacion de Palabra en posición
        //================================================================================
        System.out.println("-------------- Imprimimos mensaje 6 para verlo completo--------------");
        p.ver(obl.imprimirTexto(7114821, 6).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 6).valorString);

        System.out.println("-------------- Eliminamos palabra 1 en linea 2, mensaje 6--------------");
        p.ver(obl.borrarPalabra(7114821, 6, 2, 1).resultado, Retorno.Resultado.OK, "Borramos palabra 1 en linea 2 del mensaje 6");

        System.out.println("-------------- Imprimimos mensaje 6 con la palabra eliminada--------------");
        p.ver(obl.imprimirTexto(7114821, 6).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 6).valorString);

        //================================================================================
        // Eliminacion de todas las lineas de un mensaje
        //================================================================================
        System.out.println("-------------- Imprimimos mensaje 5 para verlo completo--------------");
        p.ver(obl.imprimirTexto(7114821, 5).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 5).valorString);

        p.ver(obl.borrarTodo(7114821, 5).resultado, Retorno.Resultado.OK, "Borra todas las lineas del mensaje 5");

        System.out.println("-------------- Imprimimos mensaje 5 Vacio--------------");
        p.ver(obl.imprimirTexto(7114821, 5).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 5).valorString);

        //================================================================================
        // Eliminacion de linea
        //================================================================================
        System.out.println("-------------- Imprimimos mensaje 3 para verlo completo--------------");
        p.ver(obl.imprimirTexto(7114821, 3).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 3).valorString);

        p.ver(obl.borrarLinea(7114821, 3, 2).resultado, Retorno.Resultado.OK, "Borramos linea 2, mensaje 3");

        System.out.println("-------------- Imprimimos mensaje 3 sin la linea 2--------------");
        p.ver(obl.imprimirTexto(7114821, 3).resultado, Retorno.Resultado.OK, obl.imprimirTexto(7114821, 3).valorString);

        //================================================================================
        // Agregamos palabras al diccionario
        //================================================================================
        p.ver(obl.ingresarPalabraDiccionario("Hola").resultado, Retorno.Resultado.OK, "Se agrega palabra 'Hola' al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("Andas").resultado, Retorno.Resultado.OK, "Se agrega palabra 'Andas' al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("Italia").resultado, Retorno.Resultado.OK, "Se agrega palabra 'Italia' al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("Como").resultado, Retorno.Resultado.OK, "Se agrega palabra 'Como' al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("Hawaii").resultado, Retorno.Resultado.OK, "Se agrega palabra 'Hawaii' al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("Pronto").resultado, Retorno.Resultado.OK, "Se agrega palabra 'Pronto' al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("Extrañamos").resultado, Retorno.Resultado.OK, "Se agrega palabra 'Extrañamos' al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("En").resultado, Retorno.Resultado.OK, "Se agrega palabra 'En' al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("Comida").resultado, Retorno.Resultado.OK, "Se agrega palabra 'Comida' al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("Zafiro").resultado, Retorno.Resultado.OK, "Se agrega palabra 'Zafiro' al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("Bueno").resultado, Retorno.Resultado.OK, "Se agrega palabra 'Bueno' al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("Va").resultado, Retorno.Resultado.OK, "Se agrega palabra 'Va' al diccionario");

        System.out.println("-------------- Probamos agregar palabra que ya existen en el diccionario:--------------");
        p.ver(obl.ingresarPalabraDiccionario("Italia").resultado, Retorno.Resultado.ERROR, "Se intenta agregar 'Italia' al diccionario, ya existe");
        p.ver(obl.ingresarPalabraDiccionario("Pronto").resultado, Retorno.Resultado.ERROR, "Se intenta agregar 'Pronto' al diccionario, ya existe");
        //================================================================================
        // Imprimimos Diccionario
        //================================================================================
        p.ver(obl.imprimirDiccionario().resultado, Retorno.Resultado.OK, "Imprimiendo Diccionario en orden alfabetico: \n" + obl.imprimirDiccionario().valorString);
        //===================================================================================================
        // Imprimimos Texto Incorrecto (Todas las palabras de todos los textos que no están en el Diccionario)
        //====================================================================================================
        p.ver(obl.ImprimirTextoIncorrecto().resultado, Retorno.Resultado.OK, "Imprimiendo Texto Incorrecto: \n" + obl.ImprimirTextoIncorrecto().valorString);

        //================================================================================
        // Matriz con cantidad de mensajes por contacto
        //================================================================================
        p.ver(obl.cantidadDeMensajes(7114821).resultado, Retorno.Resultado.OK, "Imprimiendo Matriz con cantidad de mensajes de Juan: \n" + obl.cantidadDeMensajes(7114821).valorString);

        // Mariana tiene 1 solo mensaje porque el otro fue eliminado.
        p.ver(obl.cantidadDeMensajes(7777771).resultado, Retorno.Resultado.OK, "Imprimiendo Matriz con cantidad de mensajes de Mariana: \n" + obl.cantidadDeMensajes(7777771).valorString);

        //================================================================================
        // Eliminacion de contacto
        //================================================================================
        System.out.println("-------------- Eliminamos a Ana--------------");
        p.ver(obl.eliminarContacto(6224587).resultado, Retorno.Resultado.OK, "Eliminamos contacto de Ana");

        System.out.println("-------------- Eliminamos a un contacto que no existe, esperamos ERROR--------------");
        p.ver(obl.eliminarContacto(6224587).resultado, Retorno.Resultado.ERROR, "Eliminamos contacto que no existe");
        
        System.out.println("-------------- Verificamos que Ana no existe mas en la lista de contacots--------------");
        System.out.println(obl.listaContactos.mostrar());

        p.ver(obl.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, "Sistema eliminado con exito");
       
         //=====================================================================================================================================================================
         //                             ******************* JUEGO DE PRUEBA 2 SUBIDO POR PROFESOR FUNCIONANDO *******************
         //                                  ************ Comentar el juego de prueba anterior antes de ejecutar ************
         //=====================================================================================================================================================================

         
//        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK, "Se creara sistma para 3 palabras por linea");
//
//        p.ver(obl.agregarContacto(0, "Nosotros").resultado, Retorno.Resultado.OK, "Se agrega usuario 0");
//
//        p.ver(obl.agregarContacto(1, "Carlos Perez").resultado, Retorno.Resultado.OK, "se agrega contacto Carlos Perez al sistema");
//        p.ver(obl.agregarContacto(1, "Carlos Perez").resultado, Retorno.Resultado.ERROR, "se intenta agregar contacto Carlos Perez que ya existe");
//        p.ver(obl.eliminarContacto(1).resultado, Retorno.Resultado.OK, "se elimina contacto Carlos Perez del sistema");
//
//        p.ver(obl.agregarContacto(1, "Juan").resultado, Retorno.Resultado.OK, "se agrega contacto Juan Perez al sistema");
//        p.ver(obl.agregarContacto(2, "Pedro").resultado, Retorno.Resultado.OK, "se agrega contacto Juan Perez al sistema");
//        p.ver(obl.agregarContacto(3, "Ana  ").resultado, Retorno.Resultado.OK, "se agrega contacto Juan Perez al sistema");
//        p.ver(obl.agregarContacto(4, "Maria").resultado, Retorno.Resultado.OK, "se agrega contacto Maria al sistema");
//
//        // ----------------------
//        // Mostramos contactos
//        //-----------------------    
//        p.ver(obl.imprimirContactos().resultado, Retorno.Resultado.OK, "Lista de Contactos: \n" + obl.imprimirContactos().valorString);
//
//        // definimos una fecha        
//        Date fecha = new Date();
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//
//        //-------------------------------
//        fecha = formato.parse("23/03/2022");
//        //--------------------------------
//        // Agregamos 3 mensajes a contacto Pedro que Existe
//        p.ver(obl.agregarMensaje(0, 2, fecha).resultado, Retorno.Resultado.OK, "Se agrega primer mensaje para Pedro ");
//        p.ver(obl.agregarMensaje(0, 2, fecha).resultado, Retorno.Resultado.OK, "Se agrega segundo mensaje para Pedro ");
//        p.ver(obl.agregarMensaje(0, 2, fecha).resultado, Retorno.Resultado.OK, "Se agrega tercer  mensaje para Pedro ");
//
//        // Agregamos mensaje a contacto 8 que NO Existe
//        p.ver(obl.agregarMensaje(0, 8, fecha).resultado, Retorno.Resultado.ERROR, "Se agrega mensaje a contacto inexistente ");
//
//        // Agregamos lineas al mensaje 2 de pedro
//        p.ver(obl.insertarLineaEnPosicion(0, 2, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 2 de Pedro");
//        p.ver(obl.insertarLineaEnPosicion(0, 2, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 2 en blanco al mensaje 2 de Pedro");
//        p.ver(obl.insertarLineaEnPosicion(0, 2, 3).resultado, Retorno.Resultado.OK, "Se agrega linea 3 en blanco al mensaje 2 de Pedro");
//
//        // Agregamos palabras al mensaje 2 de pedro en la linea 1
//        p.ver(obl.insertarPalabraEnLinea(0, 2, 1, 1, "Hola").resultado, Retorno.Resultado.OK, "Se agrega palabra Hola linea 1 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(0, 2, 1, 2, "Pedro").resultado, Retorno.Resultado.OK, "Se agrega palabra Pedro linea 1 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(0, 2, 2, 1, "Te").resultado, Retorno.Resultado.OK, "Se agrega palabra Te linea 2 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(0, 2, 2, 2, "LLamo").resultado, Retorno.Resultado.OK, "Se agrega palabra Te linea 2 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(0, 2, 2, 3, "En").resultado, Retorno.Resultado.OK, "Se agrega palabra Llamo linea 2 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(0, 2, 3, 1, "5min").resultado, Retorno.Resultado.OK, "Se agrega palabra 5min linea 3 mensaje 2");
//
//        // Imprimimos mensaje 2 de pedro
//        p.ver(obl.imprimirTexto(0, 2).resultado, Retorno.Resultado.OK, "Se imprime mensaje 2 de Pedro \n" + obl.imprimirTexto(0, 2).valorString);
//
//        p.ver(obl.insertarPalabraYDesplazar(0, 2, 2, 2, "puedo").resultado, Retorno.Resultado.OK, "Se agrega palabra puedo en linea 2 mensaje 2 posicion 2");
//
//        // Imprimimos mensaje 2 de pedro
//        p.ver(obl.imprimirTexto(0, 2).resultado, Retorno.Resultado.OK, "Se imprime mensaje 2 de Pedro" + obl.imprimirTexto(0, 2).valorString);
////        
//        p.ver(obl.borrarPalabra(0, 2, 2, 2).resultado, Retorno.Resultado.OK, "Se elimina palabra pos 2 de mensaje 2 linea 2 de pedro");
////
////      // Imprimimos mensaje 2 de pedro
//        p.ver(obl.imprimirTexto(0, 2).resultado, Retorno.Resultado.OK, "Se imprime mensaje 2 de Pedro" + obl.imprimirTexto(0, 2).valorString);
////        
//        //-------------------------------        
//        fecha = formato.parse("24/03/2022");
//        //-------------------------------
//////       
//        p.ver(obl.agregarMensaje(0, 2, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje  4 para Pedro en  fecha 24/03/2022 ");
//        p.ver(obl.agregarMensaje(0, 2, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 5 para Pedro en  fecha 24/03/2022 ");
//////        
//////       // Agregamos lineas al mensaje 1 de pedro
//        p.ver(obl.insertarLineaEnPosicion(0, 1, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 1 de Pedro");
//        p.ver(obl.insertarLineaEnPosicion(0, 1, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 2 en blanco al mensaje 1 de Pedro");
//        p.ver(obl.insertarLineaEnPosicion(0, 1, 3).resultado, Retorno.Resultado.OK, "Se agrega linea 3 en blanco al mensaje 1 de Pedro");
//////
//////        // Agregamos palabras al mensaje 1 de pedro en la linea 1
//        p.ver(obl.insertarPalabraEnLinea(0, 1, 1, 1, "Voy").resultado, Retorno.Resultado.OK, "Se agrega palabra voy linea 1 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(0, 1, 1, 2, "llegando").resultado, Retorno.Resultado.OK, "Se agrega palabra llegando linea 1 mensaje 2");
////        
////        
//        p.ver(obl.agregarMensaje(0, 3, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje  6 para Ana en fecha 24/03/2022 ");
//        p.ver(obl.agregarMensaje(0, 3, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 7 para Ana en fecha 24/03/2022");
//////       
//        //---------------------------------        
//        fecha = formato.parse("25/03/2022");
//        //----------------------------------
////       
//        p.ver(obl.agregarMensaje(0, 2, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 8 para Pedro en fecha 25/03/2022 ");
//        p.ver(obl.agregarMensaje(0, 4, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 9 para Maria en fecha 25/03/2022 ");
//
//        p.ver(obl.insertarLineaEnPosicion(0, 3, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 3 de Pedro");
//        p.ver(obl.insertarPalabraEnLinea(0, 3, 1, 1, "Estoy").resultado, Retorno.Resultado.OK, "Se agrega palabra Estoy linea 1 mensaje 3");
//        p.ver(obl.insertarPalabraEnLinea(0, 3, 1, 2, "estacionando").resultado, Retorno.Resultado.OK, "Se agrega palabra estacionando linea 1 mensaje 3");
////
//////        
//        p.ver(obl.agregarMensaje(0, 4, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 10 para Maria en fecha 25/03/2022 ");
//        p.ver(obl.agregarMensaje(0, 4, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 11 para Maria en fecha 25/03/2022");
////
//////       // Agregamos lineas al mensaje 2 
//        p.ver(obl.insertarLineaEnPosicion(0, 2, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 2 de Pedro");
//        p.ver(obl.insertarLineaEnPosicion(0, 2, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 2 en blanco al mensaje 2 de Pedro");
//
//        p.ver(obl.insertarLineaEnPosicion(0, 11, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 2 de Maria");
//        p.ver(obl.insertarLineaEnPosicion(0, 11, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 2 en blanco al mensaje 2 de Maria");
//////        
//////        // Agregamos palabras al mensaje 2 de maria en la linea 1
//        p.ver(obl.insertarPalabraEnLinea(0, 11, 1, 1, "Hola").resultado, Retorno.Resultado.OK, "Se agrega palabra Hola linea 1 mensaje 2");
//        p.ver(obl.insertarPalabraEnLinea(0, 11, 1, 2, "Maria").resultado, Retorno.Resultado.OK, "Se agrega palabra Maria linea 1 mensaje 2");
//
//        p.ver(obl.insertarPalabraYDesplazar(0, 11, 1, 3, "llamo").resultado, Retorno.Resultado.OK, "Se agrega palabra llamo a mensaje 2 linea 1 de maria");
//        p.ver(obl.insertarPalabraYDesplazar(0, 11, 1, 3, "Te").resultado, Retorno.Resultado.OK, "Se agrega palabra Te a mensaje 2 linea 1 de maria");
//        p.ver(obl.insertarPalabraYDesplazar(0, 11, 2, 2, "y salimos").resultado, Retorno.Resultado.OK, "Se agrega palabra Te a mensaje 2 linea 1 de maria");
//
//        p.ver(obl.cantidadDeMensajes(0).resultado, Retorno.Resultado.OK, "Mensajes de Nosotros \n" + obl.cantidadDeMensajes(0).valorString);
//////                
//        p.ver(obl.ingresarPalabraDiccionario("hola").resultado, Retorno.Resultado.OK, "Se agrega palabra al diccionario");
//        p.ver(obl.ingresarPalabraDiccionario("Estacionando").resultado, Retorno.Resultado.OK, "Se agrega palabra al diccionario");
//        p.ver(obl.ingresarPalabraDiccionario("llegando").resultado, Retorno.Resultado.OK, "Se agrega palabra al diccionario");
//        p.ver(obl.ingresarPalabraDiccionario("Te").resultado, Retorno.Resultado.OK, "Se agrega palabra al diccionario");
//        p.ver(obl.ingresarPalabraDiccionario("Estoy").resultado, Retorno.Resultado.OK, "Se agrega palabra al diccionario");
//////        
//        p.ver(obl.imprimirDiccionario().resultado, Retorno.Resultado.OK, "palabras del diccionario \n" + obl.imprimirDiccionario().valorString);
//        p.ver(obl.ImprimirTextoIncorrecto().resultado, Retorno.Resultado.OK, "Palabras que no estan en el diccionario\n" + obl.ImprimirTextoIncorrecto().valorString);
//////       
//        p.ver(obl.cantidadDeMensajes(1).resultado, Retorno.Resultado.OK, "Mensajes de juan \n" + obl.cantidadDeMensajes(1).valorString);
//        p.ver(obl.cantidadDeMensajes(2).resultado, Retorno.Resultado.OK, "Mensajes de Pedro\n" + obl.cantidadDeMensajes(2).valorString);
//        p.ver(obl.cantidadDeMensajes(3).resultado, Retorno.Resultado.OK, "Mensajes de Ana\n" + obl.cantidadDeMensajes(3).valorString);
//        p.ver(obl.cantidadDeMensajes(4).resultado, Retorno.Resultado.OK, "Mensajes de Maria\n" + obl.cantidadDeMensajes(4).valorString);
////        
//       
//
////       
//        p.ver(obl.agregarMensaje(0, 1, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje para Juan en fecha 25/03/2022 ");
////        
//        // Esta vacio
//        p.ver(obl.imprimirTexto(0, 12).resultado, Retorno.Resultado.OK, "Se Imprime mensaje 1 de Juan 25/03/2022: \n" + obl.imprimirTexto(0, 12).valorString);
////        
//        p.ver(obl.insertarLineaEnPosicion(0, 12, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 1 de Juan");
//        p.ver(obl.insertarLineaEnPosicion(0, 12, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 2 en blanco al mensaje 1 de Juan");
//        p.ver(obl.insertarLineaEnPosicion(0, 12, 3).resultado, Retorno.Resultado.OK, "Se agrega linea 3 en blanco al mensaje 1 de Juan");
//        p.ver(obl.imprimirTexto(0, 12).resultado, Retorno.Resultado.OK, "Se Muestra  mensaje   para Juan en fecha 25/03/2022 " + obl.imprimirTexto(0, 12).valorString);
////        
//        p.ver(obl.insertarPalabraYDesplazar(0, 12, 1, 1, "P2").resultado, Retorno.Resultado.OK, "Se agrega P2 en linea 1 mensaje 1 posicion 1");
//        p.ver(obl.insertarPalabraYDesplazar(0, 12, 1, 2, "P3").resultado, Retorno.Resultado.OK, "Se agrega P3 en linea 1 mensaje 1 posicion 1");
//        p.ver(obl.insertarPalabraYDesplazar(0, 12, 1, 1, "P1").resultado, Retorno.Resultado.OK, "Se agrega P1 en linea 1 mensaje 1 posicion 1");
//        p.ver(obl.imprimirTexto(0, 12).resultado, Retorno.Resultado.OK, "Se Muestra  mensaje   para Juan en fecha 25/03/2022 \n" + obl.imprimirTexto(0, 12).valorString);
//        p.ver(obl.insertarPalabraYDesplazar(0, 12, 2, 1, "P4").resultado, Retorno.Resultado.OK, "Se agrega P4 en linea 2 mensaje 1 posicion 1");
////
//        p.ver(obl.insertarPalabraYDesplazar(0, 12, 2, 2, "P1").resultado, Retorno.Resultado.OK, "Se agrega P1 en linea 2 mensaje 1 posicion 2");
//        p.ver(obl.insertarPalabraYDesplazar(0, 12, 2, 3, "P5").resultado, Retorno.Resultado.OK, "Se agrega P5 en linea 3 mensaje 1 posicion 3");
//        p.ver(obl.insertarPalabraYDesplazar(0, 12, 3, 1, "P6").resultado, Retorno.Resultado.OK, "Se agrega P6 en linea 2 mensaje 1 posicion 1");
//        p.ver(obl.insertarPalabraYDesplazar(0, 12, 3, 2, "P7").resultado, Retorno.Resultado.OK, "Se agrega P7 en linea 2 mensaje 1 posicion 2");
//        p.ver(obl.insertarPalabraYDesplazar(0, 12, 3, 3, "P1").resultado, Retorno.Resultado.OK, "Se agrega P1 en linea 3 mensaje 1 posicion 3");
//        p.ver(obl.imprimirTexto(0, 12).resultado, Retorno.Resultado.OK, "Se Muestra  mensaje   para Juan en fecha 25/03/2022 \n" + obl.imprimirTexto(0, 12).valorString);
//
//        p.ver(obl.borrarOcurrenciasPalabraEnTexto(0, 12, "P1").resultado, Retorno.Resultado.OK, "Se elimina P1 del mensaje 1 de Juan ");
//
//        p.ver(obl.imprimirTexto(0, 12).resultado, Retorno.Resultado.OK, "Se Muestra  mensaje   para Juan en fecha 25/03/2022 \n" + obl.imprimirTexto(0, 12).valorString);
//
//        p.ver(obl.imprimirLinea(0, 12, 1).resultado, Retorno.Resultado.OK, "Se Muestra  la linea 1 para el mensaje 1 de Juan en fecha 25/03/2022 \n" + obl.imprimirLinea(0, 12, 1).valorString);
//
//        p.ver(obl.borrarLinea(0, 12,2).resultado, Retorno.Resultado.OK, "Se elimina la línea 2 del mensaje 1 de Juan ");
//        p.ver(obl.imprimirTexto(0, 12).resultado, Retorno.Resultado.OK, "Se Muestra  mensaje   para Juan en fecha 25/03/2022 \n" + obl.imprimirTexto(0, 12).valorString);
//        p.ver(obl.borrarLinea(0, 12,1).resultado, Retorno.Resultado.OK, "Se elimina la línea 1 del mensaje 1 de Juan ");
//        p.ver(obl.imprimirTexto(0, 12).resultado, Retorno.Resultado.OK, "Se Muestra  mensaje   para Juan en fecha 25/03/2022 \n" + obl.imprimirTexto(0, 12).valorString);
//        
//        // Ejemplo para mostrar la matriz de otro contacto, le agregamos 2 mensajes
//////    p.ver(obl.agregarMensaje(4, 1, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 9 para Maria en fecha 25/03/2022 ");
//////    p.ver(obl.agregarMensaje(4, 1, fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 9 para Maria en fecha 25/03/2022 ");
//////    p.ver(obl.cantidadDeMensajes(4).resultado, Retorno.Resultado.OK, "Mensajes de Maria\n" + obl.cantidadDeMensajes(4).valorString);
//
//        
//        p.ver(obl.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, "sistema eliminado");
        
        p.imprimirResultadosPrueba();
    }
}
