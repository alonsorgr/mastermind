package org.iesdonana.mastermind;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

/**
 * Genera una combinación secreta
 */
public class CombinacionSecreta {
    private Ficha[] fichas;             // NO NULO
    private boolean encriptada;

    /**
     * Constructor de CombinacionSecreta
     *
     * @param colores array de TipoColorFicha que no puede ser nulo
     * @see TipoColorFicha
     */
    public CombinacionSecreta(TipoColorFicha[] colores) {
        crearFichas(colores);
    }

    /**
     * Adquirir fichas de combinacion
     *
     * @return devuelve un aray de fichas pertenecientes a la combinación secreta
     */
    public Ficha[] getFichas() {
        return fichas;
    }

    private void crearFichas(TipoColorFicha[] color) {
        assert color != null : "Error: el array de colores no puede ser nulo";

        fichas = new Ficha[4];
        for (int i = 0; i < fichas.length; i++) {
            fichas[i] = new Ficha(color[i]);
        }
    }

    /**
     * Muestra el contenido de la combinación secreta
     */
    public void mostrarCombinacion() {
        encriptada = !encriptada;
    }

    /**
     * Representación gráfica
     *
     * @return devuelve la representación en cadena del objeto
     */
    @Override
    public String toString() {
        String resultado = ansi().eraseScreen().fg(YELLOW).a("SECRETA\n").reset().toString();
        for (Ficha ficha : fichas) {
            if (encriptada)
                resultado += ficha != null ? ficha + " " :
                        ansi().eraseScreen().fg(DEFAULT).a("\u2609").reset().toString() + " ";
            else
                resultado += "\u2609 ";
        }
        return "\n" + resultado + "\n\n";
    }
}
