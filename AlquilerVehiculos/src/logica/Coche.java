package logica;

public class Coche {
	//Atributos: 
	private String matricula;
	private double kmsActuales;
	private String nombre;
	private int sucursalId;
	private String nombreCategoria;
	//Relaciones:
	private Sucursal sucursal;
	private Categoria categoria;
	
	public Coche(String matricula, double kmsActuales, Sucursal sucursal, Categoria categoria, String nombre){
		this.matricula = matricula;
		this.kmsActuales = kmsActuales;
		this.sucursal = sucursal;
		this.categoria = categoria;
		this.nombre = nombre;
	}
	
	public Coche(String matricula, double kmsActuales, int sucursalId, String nombreCategoria, String nombre){
		this.matricula = matricula;
		this.kmsActuales = kmsActuales;
		this.setSucursalId(sucursalId);
		this.setNombreCategoria(nombreCategoria);
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getKmsActuales() {
		return kmsActuales;
	}
	public void setKmsActuales(int kmsActuales) {
		this.kmsActuales = kmsActuales;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(int sucursalId) {
		this.sucursalId = sucursalId;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
}
