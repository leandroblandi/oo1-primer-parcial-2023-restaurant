package modelo;

import java.time.LocalDate;

public class Reserva {
	private int id;
	private Cliente cliente;
	private LocalDate fechaReserva;
	private Mesa mesa;
	private int cantidadComensales;

	public boolean validarComensales(int cantidadComensales) throws Exception {
		if (this.mesa.getCapacidad() < cantidadComensales) {
			throw new Exception(String.format("La cantidad de comensales es superior a la capacidad de la mesa",
					cantidadComensales));
		}
		return true;
	}

	public Reserva(int id, Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantidadComensales)
			throws Exception {
		this.setId(id);
		this.setCliente(cliente);
		this.setFechaReserva(fechaReserva);
		this.setMesa(mesa);
		this.setCantidadComensales(cantidadComensales);
	}

	@Override
	public String toString() {
		return String.format("Reserva(id=%d, cliente=%s, fechaReserva=%s, mesa=%s, cantidadComensales=%d)", id, cliente,
				fechaReserva, mesa, cantidadComensales);
	}

	public boolean equals(Reserva reserva) {
		return (this.id == reserva.getId()) && (this.cliente == reserva.getCliente());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public int getCantidadComensales() {
		return cantidadComensales;
	}

	public void setCantidadComensales(int cantidadComensales) throws Exception {
		if (validarComensales(cantidadComensales)) {
			this.cantidadComensales = cantidadComensales;
		}
	}
}
