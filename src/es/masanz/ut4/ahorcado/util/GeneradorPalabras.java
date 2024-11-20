package es.masanz.ut4.ahorcado.util;

public class GeneradorPalabras {

    public static final String PALABRAS_FIJAS = "coche avion campo perro";
    public static final String PALABRAS_VARIABLES = "coche oro furgoneta camarero";
    private static final char SEPARADOR = ' ';

    public static String obtenerPalabraFija(){
        int longitudPalabra = 0;
        for (int i = 0; i < PALABRAS_FIJAS.length(); i++) {
            char caracter = PALABRAS_FIJAS.charAt(i);
            if(caracter != SEPARADOR){
                longitudPalabra++;
            } else {
                break;
            }
        }

        int contadorPalabras = 1;
        for (int i = 0; i < PALABRAS_FIJAS.length(); i++) {
            char caracter = PALABRAS_FIJAS.charAt(i);
            if(caracter == SEPARADOR){
                contadorPalabras++;
            }
        }

        int numPalabraAleatoria = (int) (Math.random() * contadorPalabras);

        int desde = numPalabraAleatoria * (longitudPalabra + 1);
        int hasta = desde + longitudPalabra;

        String palabraSeleccionada = PALABRAS_FIJAS.substring(desde, hasta);

        return palabraSeleccionada;
    }

    public static String obtenerPalabraVariable(){


        int contadorPalabras = 1;
        for (int i = 0; i < PALABRAS_VARIABLES.length(); i++) {
            char caracter = PALABRAS_VARIABLES.charAt(i);
            if(caracter == SEPARADOR){
                contadorPalabras++;
            }
        }

        int desde = -1;
        int hasta = -1;

        int numPalabraAleatoria = (int) (Math.random() * contadorPalabras);
        int posSeparadorDesde = numPalabraAleatoria - 1;
        int posSeparadorHasta = numPalabraAleatoria;
        int separadoresHastaAhora = 0;

        for (int i = 0; i < PALABRAS_VARIABLES.length(); i++) {
            char caracter = PALABRAS_VARIABLES.charAt(i);
            if(caracter == SEPARADOR){
                separadoresHastaAhora++;
            }
            if(separadoresHastaAhora==posSeparadorDesde){
                desde = i;
            }
            if(separadoresHastaAhora==posSeparadorHasta){
                hasta = i;
            }
        }

        String palabraSeleccionada = "";

        System.out.println("Desde: "+desde);
        System.out.println("Hasta: "+hasta);

        if(posSeparadorDesde==0){
            desde = 0;
            palabraSeleccionada = PALABRAS_VARIABLES.substring(desde, hasta);
        } else if(posSeparadorHasta==contadorPalabras){
            palabraSeleccionada = PALABRAS_VARIABLES.substring(desde);
        } else {
            palabraSeleccionada = PALABRAS_VARIABLES.substring(desde, hasta);
        }

        return palabraSeleccionada;
    }
}
