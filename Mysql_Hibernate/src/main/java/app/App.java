package app;

import casos_uso.Caso_uso_CRUD;
import entidades.Interfaz_de_Pasarela_Clientes;
import entidades.Interfaz_de_Pasarela_Reservas;
import jakarta.persistence.EntityManager;
import pasarela.CrearBaseDatos;
import pasarela.InicializarBaseDatos;
import pasarela.PacienteDaoImpl;
import pasarela_datos.Pasarela_sqlite_Clientes;
import pasarela_datos.Pasarela_sqlite_Reservas;

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
       
        
        EntityManager em = HibernateUtil.getSessionFactory().openSession();
        
        PacienteDaoImpl pasarelaPaciente = new PacienteDaoImpl(em);
        
        Caso_uso_CRUD caso1 = new Caso_uso_CRUD(pasarelaPaciente);
        
		
       
        
        
        System.out.println("\n=========================================");
        System.out.println("          FIN                              ");
        System.out.println("===========================================");
        
        
    }
}