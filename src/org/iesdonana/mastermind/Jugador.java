package org.iesdonana.mastermind;

/**
 * Crea un objeto jugador
 */
public class Jugador {
    private String alias;       // NO NULO, NO VACIO, NO MODIFICABLE

    /**
     * Constructor de jugador
     * @param alias el alias del jugador no puede ser nulo, vacio ni se puede modificar
     * @see String
     */
    public Jugador(String alias) {
        setAlias(alias);
    }

    private void setAlias(String alias) {
        assert alias != null : "Error: el alias de un jugador no puede ser nulo";
        assert !alias.isEmpty() : "Error: el alias de un jugador no puede estar vacio";
        this.alias = alias;
    }
    /**
     * Representación gráfica
     *
     * @return devuelve la representación en cadena del objeto
     */
    @Override
    public String toString() {
        return alias;
    }
}
