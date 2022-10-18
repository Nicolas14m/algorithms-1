package trabajarconobligatorio;

import Estructuras.NodoDoble;

public class Retorno {
	enum Resultado {
		OK, ERROR, NO_IMPLEMENTADA
	};

	int valorEntero;
	String valorString;
         boolean valorbooleano;
	Resultado resultado;
        NodoDoble nodoDoble;

    public Retorno(Resultado resultado) {

        this.resultado = resultado;
    }
        
        
        
}
