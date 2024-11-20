package es.masanz.ut4.ahorcado.entity;

import es.masanz.ut4.ahorcado.util.GeneradorPalabras;

import java.util.Scanner;

public class Ahorcado {

    public static final int NUM_INTENTOS_DEFECTO = 6;
    private String palabraAhorcado;
    private String progresoUsuario;
    private int intentos;

    public Ahorcado(int intentos){
        this.palabraAhorcado = GeneradorPalabras.obtenerPalabraFija();
        this.intentos = intentos;
        this.progresoUsuario = "";
        for (int i = 0; i < this.palabraAhorcado.length(); i++) {
            this.progresoUsuario = this.progresoUsuario + "_";
        }
    }

    public Ahorcado(){
        this.palabraAhorcado = GeneradorPalabras.obtenerPalabraFija();
        this.intentos = NUM_INTENTOS_DEFECTO;
        this.progresoUsuario = "";
        for (int i = 0; i < this.palabraAhorcado.length(); i++) {
            this.progresoUsuario = this.progresoUsuario + "_";
        }
    }

    public Ahorcado(String palabra, int intentos){
        this.palabraAhorcado = palabra;
        this.intentos = intentos;
        this.progresoUsuario = "";
        for (int i = 0; i < palabra.length(); i++) {
            this.progresoUsuario = this.progresoUsuario + "_";
        }
    }

    public Ahorcado(String palabra){
        this.palabraAhorcado = palabra;
        this.intentos = NUM_INTENTOS_DEFECTO;
        this.progresoUsuario = "";
        for (int i = 0; i < palabra.length(); i++) {
            this.progresoUsuario = this.progresoUsuario + "_";
        }
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= this.intentos; i++) {
            System.out.print("INTRODUCE UNA LETRA: ");
            String letra = scanner.next();
            if(letra.length()==1){
                System.out.println("Vas en el intento: "+i+" de "+this.intentos);
                validarLetra(letra);
            } else {
                i--;
            }
            if(this.progresoUsuario.equals(this.palabraAhorcado)){
                break;
            }
        }
        if(this.progresoUsuario.equals(this.palabraAhorcado)){
            System.out.println("ENHORABUENA, ERES UN CRACK!");
        } else {
            System.out.println("TIENES MUCHO QUE APRENDER, JOVEN PADAWAN.");
        }
    }

    private void validarLetra(String letra) {
        for (int i = 0; i < this.palabraAhorcado.length(); i++) {
            char letraAhorcado = this.palabraAhorcado.charAt(i);
            if(letra.equals(letraAhorcado+"")){
                String desde = this.progresoUsuario.substring(0, i);
                String hasta = this.progresoUsuario.substring(i+1);
                this.progresoUsuario = desde + letra + hasta;
            }
        }


        System.out.println(this.progresoUsuario);
    }
}
