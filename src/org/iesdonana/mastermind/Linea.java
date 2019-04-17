package org.iesdonana.mastermind;

/**
 *  Genera una línea para el tablero
 */
public class Linea {
    private CombinacionPin combinacionPin;          // NO NULO
    private CombinacionLinea combinacionLinea;      // NO NULO

    /**
     * Constructor Linea
     *
     * Linea compuesta de pines y fichas
     */
    public Linea() {
        combinacionLinea = new CombinacionLinea();
        combinacionPin = new CombinacionPin();
    }

    /**
     * Accesor de pines
     * @return devuelve la combinación de pines de una línea
     */
    public CombinacionPin getCombinacionPin() {
        return combinacionPin;
    }

    /**
     * Accesor de fichas
     * @return devuelve la combinación de fichas de una línea
     */
    public CombinacionLinea getCombinacionLinea() {
        return combinacionLinea;
    }
    /**
     * Representación gráfica
     *
     * @return devuelve la representación en cadena del objeto
     */
    @Override
    public String toString() {
        return combinacionPin.toString() + "| " + combinacionLinea.toString() + "\n";
    }
}
