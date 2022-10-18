package Clases;

public class Palabra implements Comparable<Palabra> {

    
    public String valor; 

    public String getValor() {
        return valor;
    }

    public Palabra(String valor) {
        this.valor = valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Palabra() {
    }
    
    

    @Override
    public int compareTo(Palabra o) {
        
        String a = this.valor;
        String b = o.valor;
        
        int compare = a.compareTo(b);  

        if (compare < 0) {  
            return -1;
        }
        else if (compare > 0) {
           return 1;
        }
        else {  
            return 0;
        }
    }
    
    @Override
    public boolean equals(Object o){
        Palabra p = (Palabra) o;
        
        return this.valor.equalsIgnoreCase(p.valor.toLowerCase());
    }
    
    @Override
    public String toString() {
        return valor + " ";
    }
    
    
}
