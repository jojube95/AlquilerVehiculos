package persistencia.dto;

import java.time.LocalDateTime;

public class ReservaYClienteDTO {
	private int id;
	private LocalDateTime fechaRecogida;
	private LocalDateTime fechaDevolucion;
	private String nombreCategoria;
	private String modalidadAlquiler;
	private String dni;
	private String nombreyApellidos;
	private int idSucursalRecogida;
	private int idSucursalDevolucion;
	
	public ReservaYClienteDTO(int id, LocalDateTime fechaRecogida, LocalDateTime fechaDevolucion, String nombreCategoria, String modalidadAlquiler,
			String dni, String nombreyApellidos, int idSucursalRecogida, int idSucursalDevolucion){
		this.setId(id);
		this.setFechaRecogida(fechaRecogida);
		this.setFechaDevolucion(fechaDevolucion);
		this.setNombreCategoria(nombreCategoria);
		this.setModalidadAlquiler(modalidadAlquiler);
		this.setDni(dni);
		this.setNombreyApellidos(nombreyApellidos);
		this.setIdSucursalRecogida(idSucursalRecogida);
		this.setIdSucursalDevolucion(idSucursalDevolucion);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getFechaRecogida() {
		return fechaRecogida;
	}

	public void setFechaRecogida(LocalDateTime fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
	}

	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getModalidadAlquiler() {
		return modalidadAlquiler;
	}

	public void setModalidadAlquiler(String modalidadAlquiler) {
		this.modalidadAlquiler = modalidadAlquiler;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreyApellidos() {
		return nombreyApellidos;
	}

	public void setNombreyApellidos(String nombreyApellidos) {
		this.nombreyApellidos = nombreyApellidos;
	}

	public int getIdSucursalRecogida() {
		return idSucursalRecogida;
	}

	public void setIdSucursalRecogida(int idSucursalRecogida) {
		this.idSucursalRecogida = idSucursalRecogida;
	}

	public int getIdSucursalDevolucion() {
		return idSucursalDevolucion;
	}

	public void setIdSucursalDevolucion(int idSucursalDevolucion) {
		this.idSucursalDevolucion = idSucursalDevolucion;
	}
}
