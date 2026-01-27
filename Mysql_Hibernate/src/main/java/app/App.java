package app;

import pasarela.CrearBaseDatos;
import pasarela.InicializarBaseDatos;

/**
 * 
 * PRUEBA JPA CON HIBERNATE
 * 
 * 
 */
public class App {

    public static void main(String[] args) {
    	
        System.out.println("=========================================");
        System.out.println("    INICIANDO SISTEMA DE GESTIÓN         ");
        System.out.println("=========================================\n");

        CrearBaseDatos.CreaBaseDatos();
        InicializarBaseDatos.inicializarDatos();
       
       
        
        
        System.out.println("\n=========================================");
        System.out.println("          FIN                              ");
        System.out.println("===========================================");
        
        
    }
}