package Clases;

import Estructuras.Listadoble;
import java.util.Date;

public class Mensaje implements Comparable<Mensaje> {

    public Listadoble<Linea> listaLineas;

    public static int ultimoNumMensaje = 1;

    public int numMensaje;

    public int numContactoOrigen;

    public int numContactoDestino;

    public Date fecha;

    public Mensaje(int numContactoOrigen, int numContactoDestino, Date fecha) {
        this.listaLineas = new Listadoble<Linea>();
        this.numMensaje = ultimoNumMensaje;
        ultimoNumMensaje++;
        this.numContactoOrigen = numContactoOrigen;
        this.numContactoDestino = numContactoDestino;
        this.fecha = fecha;
    }

    public Listadoble<Linea> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(Listadoble<Linea> listaLineas) {
        this.listaLineas = listaLineas;
    }

    public int getNumMensaje() {
        return numMensaje;
    }

    public void setNumMensaje(int numMensaje) {
        this.numMensaje = numMensaje;
    }

    public int getNumContactoOrigen() {
        return numContactoOrigen;
    }

    public void setNumContactoOrigen(int numContactoOrigen) {
        this.numContactoOrigen = numContactoOrigen;
    }

    public int getNumContactoDestino() {
        return numContactoDestino;
    }

    public void setNumContactoDestino(int numContactoDestino) {
        this.numContactoDestino = numContactoDestino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    

    @Override
    public int compareTo(Mensaje o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean equals(Object o){
        Mensaje m = (Mensaje) o;
     if (this.numMensaje == m.numMensaje){
           return true;
        }
        else {
           return false;
        }
    }

    public Mensaje() {

    }

}
