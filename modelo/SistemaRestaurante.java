package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaRestaurante {

	private List<Cliente> clientes;
	private List<Mesa> mesas;
	private List<Reserva> reservas;

	public SistemaRestaurante() {
		this.clientes = new ArrayList<Cliente>();
		this.mesas = new ArrayList<Mesa>();
		this.reservas = new ArrayList<Reserva>();
	}

	public Cliente traerCliente(long dni) {
		Cliente cliente = null;
		boolean clienteEncontrado = false;
		int i = 0;
		while ((i < clientes.size()) && (!clienteEncontrado)) {
			Cliente clienteActual = clientes.get(i);
			if (clienteActual.getDni() == dni) {
				cliente = clienteActual;
				clienteEncontrado = true;
			}
			i++;
		}
		return cliente;
	}

	public boolean agregarCliente(String nombre, String apellido, long dni, String telefono) throws Exception {
		Cliente clienteBuscado = traerCliente(dni);
		if (clienteBuscado != null) {
			throw new Exception(String.format("El cliente con DNI `%d` ya existe", dni));
		}
		int id = calcularAutoIncrementalCliente();
		return clientes.add(new Cliente(id, nombre, apellido, dni, telefono));
	}

	public Mesa traerMesa(int numeroMesa) {
		Mesa mesa = null;
		boolean mesaEncontrada = false;
		int i = 0;
		while ((i < mesas.size()) && (!mesaEncontrada)) {
			Mesa mesaActual = mesas.get(i);
			if (mesaActual.getNumeroMesa() == numeroMesa) {
				mesa = mesaActual;
				mesaEncontrada = true;
			}
			i++;
		}
		return mesa;
	}

	public boolean agregarMesa(int numeroMesa, int capacidad) throws Exception {
		Mesa mesaBuscada = traerMesa(numeroMesa);
		if (mesaBuscada != null) {
			throw new Exception(String.format("La mesa numero `%d` ya existe", numeroMesa));
		}
		int id = calcularAutoIncrementalMesa();
		return mesas.add(new Mesa(id, numeroMesa, capacidad));
	}

	public Reserva traerReserva(int numeroMesa, LocalDate fechaReserva) {

		Reserva reserva = null;
		boolean reservaEncontrada = false;
		int i = 0;
		while ((i < reservas.size()) && (!reservaEncontrada)) {
			Reserva reservaActual = reservas.get(i);
			if ((reservaActual.getMesa().getNumeroMesa() == numeroMesa)
					&& (reservaActual.getFechaReserva().equals(fechaReserva))) {
				reserva = reservaActual;
				reservaEncontrada = true;
			}
			i++;
		}
		return reserva;
	}

	public boolean agregarReserva(Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantidadComensales)
			throws Exception {
		Reserva reservaBuscada = traerReserva(mesa.getNumeroMesa(), fechaReserva);
		if (reservaBuscada != null) {
			throw new Exception(String.format("La mesa ya esta reservada para la fecha `%s` ", fechaReserva));
		}
		int id = calcularAutoIncrementalReserva();
		return reservas.add(new Reserva(id, cliente, fechaReserva, mesa, cantidadComensales));
	}

	public List<Reserva> traerReservasPorFecha(LocalDate fechaDesde, LocalDate fechaHasta) {
		List<Reserva> reservasCoincidentes = new ArrayList<Reserva>();
		for (Reserva reserva : reservas) {
			LocalDate fechaActual = reserva.getFechaReserva();
			if (entreFechas(fechaActual, fechaDesde, fechaHasta)) {
				reservasCoincidentes.add(reserva);
			}
		}
		return reservasCoincidentes;
	}

	// Metodo para saber si una fecha esta entre dos fechas (extremos incluidos)
	private boolean entreFechas(LocalDate fecha, LocalDate desde, LocalDate hasta) {
		return (fecha.equals(desde)) || ((fecha.isAfter(desde)) && (fecha.isBefore(hasta))) || (fecha.equals(hasta));
	}

	public List<Mesa> traerMesasLibresPorFecha(LocalDate fecha) {
		List<Mesa> mesasLibres = new ArrayList<Mesa>();
		for (Mesa mesa : mesas) {
			/*
			 * Si una mesa esta en una reserva, entonces traerReserva devuelve una instancia
			 * de Reserva
			 */
			if (traerReserva(mesa.getNumeroMesa(), fecha) == null) {
				mesasLibres.add(mesa);
			}
		}
		return mesasLibres;
	}

	// Metodos para calcular autoincremental

	private int calcularAutoIncrementalCliente() {
		int id = 0;
		if (clientes.isEmpty()) {
			id = 1;
		} else {
			id = clientes.get(clientes.size() - 1).getId() + 1;
		}
		return id;
	}

	private int calcularAutoIncrementalMesa() {
		int id = 0;
		if (mesas.isEmpty()) {
			id = 1;
		} else {
			id = mesas.get(mesas.size() - 1).getId() + 1;
		}
		return id;
	}

	private int calcularAutoIncrementalReserva() {
		int id = 0;
		if (reservas.isEmpty()) {
			id = 1;
		} else {
			id = reservas.get(reservas.size() - 1).getId() + 1;
		}
		return id;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}
}
