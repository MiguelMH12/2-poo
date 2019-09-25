package com.everis;

import com.everis.poo.model.Cliente;
import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String json = convertirClienteJson();
        System.out.println(json);
    }
    
    public static String convertirClienteJson() {
    	Cliente cliente = new Cliente();
    	cliente.setIdCliente(1);
    	cliente.setNombre("Miguel");
    	cliente.setApaterno("Martinez");
    	cliente.setAmaterno("Hernandez");
    	cliente.setRfc("MAHM");
    	
    	//Convertir este objeto a formato JSON
    	Gson gson = new Gson();
    	String json = gson.toJson(cliente);  //Convierte el objeto a JSON
    	return json;
    }
}
