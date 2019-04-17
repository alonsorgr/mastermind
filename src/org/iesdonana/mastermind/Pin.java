package org.iesdonana.mastermind;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

/**
 * Genera un pin con untipo de color especificado
 *
 * @see TipoColorPin
 */
public class Pin {
    private TipoColorPin color;             // NO NULO, NO MODIFICABLE

    /**
     * Constructor de Pin
     *
     * @param color color del pin a generar. No puede ser nulo
     */
    public Pin(TipoColorPin color) {
        setColor(color);
    }

    public void setColor(TipoColorPin color) {
        assert color != null : "Error: el color de un pin no puede ser nulo";
        this.color = color;
    }

    /**
     * Accesor para el tipo de color de pin
     *
     * @return devuelve el color del pin actua
     */
    @Deprecated
    public TipoColorPin getColor() {
        return color;
    }

    /**
     * Compara objetos Pin
     *
     * @param o objeto con el que se comparará el actuual
     * @return devuelve verdadero si las fichas tienen el mismo color
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof Pin) {
            Pin otra = (Pin) o;
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
            case BLANCO:
                return ansi().eraseScreen().fg(WHITE).a("\u25CF").reset().toString();
            case NEGRO:
                return ansi().eraseScreen().fg(BLACK).a("\u25CF").reset().toString();
            default:
                return ansi().eraseScreen().fg(DEFAULT).a("\u2609").reset().toString();
        }
    }
}
