package com.everis.poo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.everis.poo.model.Banco;

public class BancoServiceTest {
	
	private BancoService servicio = new BancoService();

	@Test
	public void testInsertarListar() {
		Banco banco = new Banco();
		banco.setNombre("Bancomer");
		banco.setDireccion("Av Reforma");
		boolean exito = servicio.insertar(banco);
		assertTrue(exito);
		
		Banco banco2 = new Banco();
		banco2.setNombre("Bancomer");
		banco2.setDireccion("Av Insurgentes");
		exito = servicio.insertar(banco2);
		assertTrue(!exito);
		
		List<Banco> bancos = servicio.listar();
		assertTrue(bancos.size() > 0);
		for(Banco objBanco : bancos) {
			System.out.println(objBanco);
		}
	}


	@Test
	public void testBuscar() {
		
		Banco banco = new Banco();
		banco.setNombre("HSBC");
		banco.setDireccion("Av Zaragoza");
		servicio.insertar(banco);
		
		Banco encontrado = servicio.buscar(0);
		assertNotNull(encontrado);
	}

	@Test
	public void testActualizar() {
		
		Banco banco = new Banco();
		banco.setNombre("Bancomer");
		banco.setDireccion("Av Reforma");
		servicio.insertar(banco);
		
		
		Banco banco3 = new Banco();
		
		banco3.setIdBanco(1);
		banco3.setNombre("Actualizado");
		banco3.setIdBanco(0);
		boolean exito = servicio.actualizar(banco3);
		assertTrue(exito);
	}

	@Test
	public void testEliminar() {
		
		boolean exito = servicio.eliminar(1);
		assertTrue(exito);
	}

}
