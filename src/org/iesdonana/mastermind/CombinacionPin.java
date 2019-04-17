package org.iesdonana.mastermind;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

/**
 * Genera una combinación de pines
 *
 * @see Pin
 */
public class CombinacionPin {
    private Pin[] pines;            // NO NULO, LONGITUD = 4

    /**
     * Constructor de CombinacionPin
     */
    public CombinacionPin() {
        pines = new Pin[4];
    }

    /**
     * Coloca un pin en una posición determinada
     *
     * @param pin      pin que no puede ser nulo a colocar en una determinada posicion
     * @param posicion la posición donde se colocará el pin. Tiene que ser mayor o igual a 0 y menor o igual a 4
     */
    public void agregar(Pin pin, int posicion) {
        assert pin != null : "Error: el pin a agregar no puede ser nulo";
        pines[posicion] = pin;
    }

    /**
     * Representación gráfica
     *
     * @return devuelve la representación en cadena del objeto
     */
    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < pines.length; i++) {
            String saltoLinea = i == 1 ? "\n" : " ";
            resultado += pines[i] != null ? pines[i] + saltoLinea + "" :
                    ansi().eraseScreen().fg(DEFAULT).a("\u2609").reset().toString() + saltoLinea;
        }
        return resultado;
    }
}
