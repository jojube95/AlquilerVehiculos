package logica;
import java.time.LocalDateTime;

public class Reserva {

	//atributos//
    private int id;
	private LocalDateTime fechaRecogida;
	private LocalDateTime fechaDevolucion;
	private String modalidadAlquiler;
	private String nombreCategoria;
	private String dniCliente;
	
	//relaciones//
	private Cliente cliente;
	private Sucursal sucursalRecogida;
	private Sucursal sucursalDevolucion;
	private Entrega entrega;
	private Categoria categoria;
	int idSucursalRecogida;
	int idSucursalDevolucion;
	
	//Contructor1(Con los atributos del caso de uso)
	public Reserva(int id, LocalDateTime fechaRecogida, LocalDateTime fechaDevolucion,
			String modalidadAlquiler, Categoria categoria, Cliente cliente,
			Sucursal sucursalRecogida, Sucursal sucursalDevolucion) {
		super();
		this.id = id;
		this.fechaRecogida = fechaRecogida;
		this.fechaDevolucion = fechaDevolucion;
		this.modalidadAlquiler = modalidadAlquiler;
		this.cliente = cliente;
		this.sucursalRecogida = sucursalRecogida;
		this.sucursalDevolucion = sucursalDevolucion;
		this.categoria = categoria;
	}
	//Contructor2(Con los atributos de la base de datos)
		public Reserva(int id, LocalDateTime fechaRecogida, LocalDateTime fechaDevolucion, String modalidadAlquiler, 
				String nombreCategoria, String dniCliente, int idSucursalRecogida, int idSucursalDevolucion) {
			super();
			this.id = id;
			this.fechaRecogida = fechaRecogida;
			this.fechaDevolucion = fechaDevolucion;
			this.modalidadAlquiler = modalidadAlquiler;
			this.nombreCategoria = nombreCategoria;
			this.dniCliente = dniCliente;
			this.idSucursalRecogida = idSucursalRecogida;
			this.idSucursalDevolucion = idSucursalDevolucion;
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
	public String getModalidadAlquiler() {
		return modalidadAlquiler;
	}
	public void setModalidadAlquiler(String modalidadAlquiler) {
		this.modalidadAlquiler = modalidadAlquiler;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Sucursal getSucursalRecogida() {
		return sucursalRecogida;
	}
	public void setSucursalRecogida(Sucursal sucursalRecogida) {
		this.sucursalRecogida = sucursalRecogida;
	}
	public Sucursal getSucursalDevolucion() {
		return sucursalDevolucion;
	}
	public void setSucursalDevolucion(Sucursal sucursalDevolucion) {
		this.sucursalDevolucion = sucursalDevolucion;
	}
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
}
