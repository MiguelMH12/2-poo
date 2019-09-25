package com.everis.poo.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.everis.poo.model.Cliente;

public class ClienteServiceTest {

	private ClienteService servicio = new ClienteService();	
	
	@Test
	public void testInsertarListar() {
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(1);
		cliente.setNombre("Miguel");
		cliente.setApaterno("Martinez");
		cliente.setAmaterno("Hernandez");
		cliente.setRfc("MAHM");
		
		boolean exito = servicio.insertar(cliente);
		assertTrue(exito);
		
		Cliente cliente2 = new Cliente();
		
		cliente2.setIdCliente(1);
		cliente2.setNombre("Miguel");
		cliente2.setApaterno("Martinez");
		cliente2.setAmaterno("Hernandez");
		cliente2.setRfc("MAHM");
		exito = servicio.insertar(cliente2);
		assertTrue(!exito);
		
		List<Cliente> clientes = servicio.listar();
		assertTrue(clientes.size() > 0);
		for(Cliente objCliente : clientes) {
			System.out.println(objCliente);
		}
	}

	@Test
	public void testBuscar() {
		testInsertarListar();
		Cliente encontrado = servicio.buscar(1);
		assertNotNull(encontrado);
	}

	@Test
	public void testActualizar() {
		testInsertarListar();
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(1);
		cliente.setNombre("Actualizado");
		
		
		boolean exito = servicio.actualizar(cliente);
		assertTrue(exito);
	}

	@Test
	public void testEliminar() {
		testInsertarListar();
		boolean exito = servicio.eliminar(1);
		assertTrue(exito);
	}

}
