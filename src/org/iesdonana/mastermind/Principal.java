package org.iesdonana.mastermind;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Jugador[] jugadores = new Jugador[2];

        System.out.print(ansi().eraseScreen().fg(YELLOW).a("\nMASTERMIND").reset().toString());
        System.out.println(ansi().eraseScreen().fg(BLUE).a(" v0.1\n").reset().toString());
        System.out.println(ansi().eraseScreen().fg(CYAN).a("IES Doñana - Programación 1º DAW").reset().toString());
        System.out.println(ansi().eraseScreen().fg(CYAN).a("Alonso García").reset().toString());
        // TODO: 20/02/19 DISEÑAR E IMPLEMENTAR EL JUEGO PARA 2 JUGADORES (NO MÁQUINA)
        System.out.println("\nINICIO DE PARTIDA\n");
        System.out.print("Introduzca su alias: ");
        jugadores[0] = new Jugador("Máqiuina");
        jugadores[1] = new Jugador(sc.next());

        Partida partida = new Partida(jugadores, 15);
        partida.jugar();

    }
}
