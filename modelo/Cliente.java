package modelo;

public class Cliente {
	private int id;
	private String nombre;
	private String apellido;
	private long dni;
	private String telefono;

	public Cliente(int id, String nombre, String apellido, long dni, String telefono) {
		this.setId(id);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
		this.setTelefono(telefono);
	}

	@Override
	public String toString() {
		return String.format("Cliente(id=%d, nombre=%s, apellido=%s, dni=%d, telefono=%s)", id, nombre, apellido, dni,
				telefono);
	}

	public boolean equals(Cliente cliente) {
		return (this.id == cliente.getId()) && (this.dni == cliente.getDni());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
