package com.everis.poo.dao;
import java.util.ArrayList;
import java.util.List;
import com.everis.poo.model.Cliente;

public class ClienteDAO {
	private static List<Cliente> clientes = new ArrayList<>();  //NO hay base de datos, almacenamos todo en una lista
	
	public List<Cliente> listar() {  //Es un get o set pero no estamos en Javabean
		return clientes;
	}
	
	public void insertar(Cliente cliente) {
		clientes.add(cliente);
		
	}
	
	//Si el cliente existe regresalo, si no regresa nulo
	public Cliente buscar(int idCliente) {
//		for (int i = 0; i < clientes.size(); i++) {
//			Cliente cliente = clientes.get(i);
//			if(cliente.getIdCliente() == idCliente) {
//				return cliente;
//			} 
//		}
		
		for(Cliente cliente : clientes) {
			if(cliente.getIdCliente() == idCliente) {
				return cliente;
			} 
		} 
		return null;
	}
	
	public boolean actualizar(Cliente cliente) {
		Cliente encontrado = buscar(cliente.getIdCliente());
		if(encontrado != null) {
			encontrado.setNombre(cliente.getNombre());
			encontrado.setApaterno(cliente.getApaterno());
			encontrado.setAmaterno(cliente.getAmaterno());
			encontrado.setRfc(cliente.getRfc());
			return true;
		} else {
			return false;
		}
	}
	
	public boolean eliminar(int idCliente) {
		Cliente encontrado = buscar(idCliente);
		if(encontrado != null) {
			clientes.remove(encontrado);
			return true;
		} else {
			return false;
		}
	}
}
