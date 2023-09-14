package test;

import java.time.LocalDate;

import modelo.Cliente;
import modelo.Mesa;
import modelo.SistemaRestaurante;

public class SistemaRestauranteTest {

	public static void main(String[] args) {

		SistemaRestaurante sr = new SistemaRestaurante();

		System.out.println("Test 1");
		try {
			sr.agregarCliente("Rodrigo", "Sanchez", 32694053, "+541179456274");
			sr.agregarCliente("Adriana", "Diaz", 31953256, "+541109462742");
			sr.agregarCliente("Marcos", "Garcia", 34096528, "+541188345186");
			System.out.println(sr.getClientes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Test 2");
		try {
			sr.agregarMesa(1, 2);
			sr.agregarMesa(2, 2);
			sr.agregarMesa(3, 4);
			sr.agregarMesa(4, 6);
			sr.agregarMesa(5, 4);
			sr.agregarMesa(6, 2);
			System.out.println(sr.getMesas());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Test 3");

		Cliente c1 = sr.traerCliente(32694053);
		Cliente c2 = sr.traerCliente(31953256);
		Cliente c3 = sr.traerCliente(34096528);

		Mesa m1 = sr.traerMesa(1);
		Mesa m4 = sr.traerMesa(4);
		Mesa m5 = sr.traerMesa(5);

		try {
			sr.agregarReserva(c1, LocalDate.of(2023, 8, 15), m1, 2);
			sr.agregarReserva(c2, LocalDate.of(2023, 8, 15), m4, 4);
			sr.agregarReserva(c3, LocalDate.of(2023, 8, 25), m5, 4);
			System.out.println(sr.getReservas());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Test 4");
		System.out.println(sr.traerReservasPorFecha(LocalDate.of(2023, 8, 15), LocalDate.of(2023, 8, 20)));

		System.out.println("Test 5");
		System.out.println(sr.traerMesasLibresPorFecha(LocalDate.of(2023, 8, 15)));

		// Deberia lanzar excepcion
		System.out.println("Test 6");
		try {
			sr.agregarCliente("Adriana", "Diaz", 31953256, "+541109462742");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Deberia lanzar excepcion
		System.out.println("Test 7");
		try {
			sr.agregarMesa(3, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Deberia lanzar excepcion
		System.out.println("Test 8");
		try {
			sr.agregarReserva(c1, LocalDate.of(2023, 8, 25), m5, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Deberia lanzar excepcion
		System.out.println("Test 9");
		try {
			Mesa m6 = sr.traerMesa(6);
			sr.agregarReserva(c2, LocalDate.of(2023, 8, 17), m6, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
