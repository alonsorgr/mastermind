package org.iesdonana.mastermind;

/**
 * Genera un tablero para el juego Mastermind
 */
public class Tablero {
    private CombinacionSecreta combinacionSecreta;      // NO NULO
    private Linea[] lineas;                             // NO NULO

    /**
     * Constructor de Tablero
     * @param combinacionSecreta la combinacion secreta no puede ser nula
     * @param numLineas el numero de lineas debe ser mayor o igual a 0
     */
    public Tablero(CombinacionSecreta combinacionSecreta, int numLineas) {
        lineas = new Linea[numLineas];
        setCombinacionSecreta(combinacionSecreta);
    }

    private void setCombinacionSecreta(CombinacionSecreta combinacionSecreta) {
        assert combinacionSecreta != null : "Error: la combinacion secreta no puede ser nula";
        this.combinacionSecreta = combinacionSecreta;
    }

    /**
     * Coloca una ficha en el tablero
     * @param ficha ficha no nula a colocar en el tablero
     * @param posicion posición donde la ficha se colocará en el tablero
     * @param linea línea en la que se colocoará la ficha
     */
    public void colocarFicha(Ficha ficha, int posicion, int linea) {
        assert ficha != null : "Error: la ficha a colocar no puede ser nula";
        lineas[linea].getCombinacionLinea().colocar(ficha, posicion);
    }

    /**
     * Coloca un pin en el tablero
     * @param pin pin no nulo a colocar en el tablero
     * @param posicion posición donde el pin se colocará en el tablero
     * @param linea línea en la que se colocoará el pin
     */
    public void colocarPin(Pin pin, int posicion, int linea) {
        assert pin != null : "Error: el pin a colocar no pude ser nulo";
        lineas[linea].getCombinacionPin().agregar(pin, posicion);
    }

    /**
     * Agregar línea a Tablero
     * @param posicion posición donde agregar la linea
     */
    public void agregarLinea(int posicion) {
        lineas[posicion] = new Linea();
    }
    /**
     * Representación gráfica
     *
     * @return devuelve la representación en cadena del objeto
     */
    @Override
    public String toString() {
        String resultado = combinacionSecreta.toString();
        for (int i = 0; i < lineas.length; i++) {
            resultado += lineas[i] != null ? lineas[i]: "";
        }
        return resultado;
    }
}
