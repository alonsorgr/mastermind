package org.iesdonana.mastermind;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

/**
 * Genera una combinación de fichas
 *
 * @see Ficha
 */
public class CombinacionLinea {
    private Ficha[] fichas;             // NO NULO, LONGITUD = 4

    /**
     * Constructor de CombinacionLinea
     */
    public CombinacionLinea() {
        fichas = new Ficha[4];
    }

    /**
     * Coloca una ficha en una posición determinada
     *
     * @param ficha    ficha a colocar que no puede ser nula
     * @param posicion la posición donde se colocará la ficha. Debe ser mayor o igual a 0 y menor o igual 4
     */
    public void colocar(Ficha ficha, int posicion) {
        assert ficha != null : "Error: la ficha a colocarFicha no puede ser nula";
        assert posicion >= 0 && posicion <= fichas.length :
                String.format("Error: posicion incorrecta (%d). Solo se pueden colocarFicha  de 0 a %d"
                        , posicion, fichas.length);
        fichas[posicion] = ficha;
    }

    /**
     * Adquirir fichas de combinacion
     *
     * @return devuelve un aray de fichas pertenecientes a la combinación de lineas
     */
    public Ficha[] getFichas() {
        return fichas;
    }

    /**
     * Representación gráfica
     *
     * @return devuelve la representación en cadena del objeto
     */
    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < fichas.length; i++) {
            resultado += fichas[i] != null ? fichas[i] + " " :
                    ansi().eraseScreen().fg(DEFAULT).a("\u2609").reset().toString() + " ";
        }
        return resultado;
    }
}
