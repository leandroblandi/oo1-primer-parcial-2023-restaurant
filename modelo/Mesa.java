package modelo;

public class Mesa {
	private int id;
	private int numeroMesa;
	private int capacidad;

	public Mesa(int id, int numeroMesa, int capacidad) {
		this.setId(capacidad);
		this.setNumeroMesa(numeroMesa);
		this.setCapacidad(capacidad);
	}

	@Override
	public String toString() {
		return String.format("Mesa(id=%d, numeroMesa=%d, capacidad=%d)", id, numeroMesa, capacidad);
	}

	public boolean equals(Mesa mesa) {
		return (this.id == mesa.getId());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
}
