package org.iesdonana.mastermind;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

/**
 * Genera una ficha con un color
 * @see TipoColorFicha
 */
public class Ficha {
    private TipoColorFicha color;           // NO NULO, NO MODIFICABLE

    /**
     * Constructor de Ficha
     * @param color color de la ficha a generar. No puede ser nulo
     */
    public Ficha(TipoColorFicha color) {
        setColor(color);
    }

    private void setColor(TipoColorFicha color) {
        assert color != null : "Error: el color de una ficha no puede ser nulo";
        this.color = color;
    }

    /**
     * Adquiere el color de la ficha
     * @return evuelve el color de una ficha
     */
    public TipoColorFicha getColor() {
        return color;
    }

    /**
     * Compara objetos Ficha
     * @param o objeto con el que se comparará el actuual
     * @return devuelve verdadero si las fichas tienen el mismo color
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof Ficha) {
            Ficha otra = (Ficha) o;
            return color.equals(otra.color);
        }
        return false;
    }
    /**
     * Representación gráfica
     *
     * @return devuelve la representación en cadena del objeto
     */
    @Override
    public String toString() {
        switch (color) {
            case AMARILLO:
                return ansi().eraseScreen().fg(YELLOW).a("\u25CF").reset().toString();
            case AZUL:
                return ansi().eraseScreen().fg(BLUE).a("\u25CF").reset().toString();
            case ROJO:
                return ansi().eraseScreen().fg(RED).a("\u25CF").reset().toString();
            case VERDE:
                return ansi().eraseScreen().fg(GREEN).a("\u25CF").reset().toString();
            case TURQUESA:
                return ansi().eraseScreen().fg(CYAN).a("\u25CF").reset().toString();
            case LILA:
                return ansi().eraseScreen().fg(MAGENTA).a("\u25CF").reset().toString();
            default:
                return ansi().eraseScreen().fg(DEFAULT).a("\u25CF").reset().toString();
        }
    }
}
