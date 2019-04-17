package org.iesdonana.mastermind;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

/**
 * Contiene la lógica de Mastermind
 */
public class Partida {
    private static final int MININTENTOS = 10;
    private static final int MAXINTENTOS = 20;
    private int intentos;                           // MININTENTOS - MAXINTENTOS
    private int intento;                            // >= intentos
    private Jugador[] jugadores;                    // NO NULO
    private int turno;                              // 0,1
    private Tablero tablero;                        // NO NULO
    private CombinacionSecreta secreta;             // NO NULO
    private CombinacionLinea combinacionLineaActual;

    /**
     * Constructor de Partida
     *
     * @param jugadores jugadores no puede ser nulo
     * @param intentos  los intentos deben ser mayor a 10 y menor de 20
     */
    public Partida(Jugador[] jugadores, int intentos) {
        setJugadores(jugadores);
        generarCombinacionSecreta();
        setIntentos(intentos);
        setTablero(intentos);
    }

    private void setJugadores(Jugador[] jugadores) {
        assert jugadores != null : "Error: el array de jugadores no puede sere nulo";

        this.jugadores = new Jugador[jugadores.length];

        for (int i = 0; i < jugadores.length; i++) {
            this.jugadores[i] = jugadores[i];
        }
    }

    private void generarCombinacionSecreta() {
        TipoColorFicha[] tipo = TipoColorFicha.values();
        TipoColorFicha[] aleatoria = coloresAleatorios();
        for (int i = 0; i <= 3; i++) {
            tipo[i] = aleatoria[i];
        }
        secreta = new CombinacionSecreta(tipo);
    }

    private TipoColorFicha[] coloresAleatorios() {

        TipoColorFicha[] tipoColorFichas = TipoColorFicha.values();
        int a, b;

        for (int i = 0; i <= tipoColorFichas.length; i++) {
            a = (int) (Math.random() * tipoColorFichas.length);
            b = (int) (Math.random() * tipoColorFichas.length);
            intercambiarColores(tipoColorFichas, a, b);
        }
        return tipoColorFichas;
    }

    private void intercambiarColores(TipoColorFicha[] tipoColorFichas, int a, int b) {
        assert tipoColorFichas != null : "Error: el array de colores no puede ser nulo";
        TipoColorFicha aux = tipoColorFichas[a];
        tipoColorFichas[a] = tipoColorFichas[b];
        tipoColorFichas[b] = aux;
    }

    private void setIntentos(int intentos) {
        assert intentos >= MININTENTOS && intentos <= MAXINTENTOS :
                String.format
                        ("Error: numero de intentos (%d) incorrecto. El numero menor de intentos es (%d) y el minimo (%d)"
                                , intentos, MININTENTOS, MAXINTENTOS);
        this.intentos = MAXINTENTOS - MININTENTOS;
    }

    private void setTablero(int intentos) {
        assert intentos >= MININTENTOS && intentos <= MAXINTENTOS :
                String.format
                        ("Error: numero de intentos (%d) incorrecto. El numero menor de intentos es (%d) y el minimo (%d)"
                                , intentos, MININTENTOS, MAXINTENTOS);
        tablero = new Tablero(secreta, intentos);
    }

    private void setTurno(int turno) {
        assert turno == 0 || turno == 1 : String.format("Error: el turno (%d) debe ser 1 o 2", turno);
        this.turno = turno;
    }

    private void cambiarTurno() {
        setTurno(turno == 0 ? 1 : 0);
    }

    private void decrementarIntentos() {
        --intentos;
    }

    private void incrementarIntento() {
        ++intento;
    }

    private void leerCombinacion() {

        Scanner sc = new Scanner(System.in);
        TipoColorFicha[] tipo = TipoColorFicha.values();
        combinacionLineaActual = new CombinacionLinea();

        int opcion;
        int posicion;

        for (int i = 1; i < 5; i++) {
            Ficha[] fichas = combinacionLineaActual.getFichas();
            do {
                do {
                    // TODO: 20/02/19 CONTROLAR EL INDICE CORRECTO DE LA POSICION
                    System.out.printf("\nSeleccione la posicion para la %dª ficha: ", i);
                    posicion = sc.nextInt();
                    if (fichas[posicion - 1] != null)
                        System.out.printf(
                                "\nLa posicion %dª está ocupada, introduzca una nueva posicion", posicion);
                } while (fichas[posicion - 1] != null);

                // TODO: 20/02/19 CONTROLAR INDICE CORRECTO DEL TIPOCOLORFICHA
                System.out.println("\nColores disponibles para las fichas\n");
                System.out.println(ansi().eraseScreen().fg(YELLOW).a("1) Amarillo").reset().toString());
                System.out.println(ansi().eraseScreen().fg(BLUE).a("2) Azul").reset().toString());
                System.out.println(ansi().eraseScreen().fg(RED).a("3) Rojo").reset().toString());
                System.out.println(ansi().eraseScreen().fg(GREEN).a("4) Verde").reset().toString());
                System.out.println(ansi().eraseScreen().fg(CYAN).a("5) Turquesa").reset().toString());
                System.out.println(ansi().eraseScreen().fg(MAGENTA).a("6) Lila").reset().toString());
                System.out.printf("\nSeleccione el color para la ficha %d: ", posicion);
                opcion = sc.nextInt();
                System.out.println();

            } while (opcion >= tipo.length + 1);

            combinacionLineaActual.colocar(new Ficha(tipo[opcion - 1]), posicion - 1);
            tablero.colocarFicha(new Ficha(tipo[opcion - 1]), posicion - 1, intentos);
            System.out.println(tablero);
        }
    }

    private void generarPinesLinea() {
        Ficha[] secreta = this.secreta.getFichas();
        Ficha[] lineaActual = this.combinacionLineaActual.getFichas();

        for (int i = 0; i < secreta.length; i++) {
            if (secreta[i].equals(lineaActual[i])) {
                tablero.colocarPin(new Pin(TipoColorPin.NEGRO), i, intentos);
            } else {
                for (int j = secreta.length - 1; j >= 0; j--) {
                    if (secreta[i].equals(lineaActual[j])) {
                        tablero.colocarPin(new Pin(TipoColorPin.BLANCO), j, intentos);
                        break;
                    }
                }
            }
        }
    }

    private boolean esLinea() {
        int longitud = combinacionLineaActual.getFichas().length;
        for (int i = 0; i < longitud; i++) {
            if (!combinacionLineaActual.getFichas()[i].equals(secreta.getFichas()[i]))
                return false;
        }
        return true;
    }

    private boolean estaCompleto() {
        return intentos == 0;
    }

    /**
     * Comienzo del juego Mastermind
     */
    public void jugar() {

        do {
            if (intento == 0) {
                System.out.printf("\nTurno para  %s (%d)\n", jugadores[turno], turno);
                System.out.println(tablero);
            }
            cambiarTurno();
            tablero.agregarLinea(intentos);
            System.out.println(tablero);
            System.out.printf("Turno para  %s (%d) | Intento (%d) | Restantes (%d)\n",
                    jugadores[turno], turno, intento, intentos);
            leerCombinacion();
            generarPinesLinea();
            cambiarTurno();
            decrementarIntentos();
            incrementarIntento();

        } while (!esLinea() || estaCompleto());

        if (esLinea()) {
            secreta.mostrarCombinacion();
            tablero.agregarLinea(intentos);
            System.out.println(tablero);
            System.out.println(ansi().eraseScreen().fg(GREEN).a("HAS GANADO\nERE UN MASTODONTE").reset().toString());
        } else if (estaCompleto()) {
            secreta.mostrarCombinacion();
            System.out.println(ansi().eraseScreen().fg(RED).a("HAS PERDIDO\nLO IMPORTATENTE E JUGÁ").reset().toString());
        }

    }
}
