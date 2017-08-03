package persistencia.dto;

public class CocheDTO {

	private String matricula;
	private double kmsActuales;
	private int sucursal;
	private String categoria;
	private String nombre;

	
	public CocheDTO(String matricula, double kmsActuales,
			int sucursal, String categoria, String nombre) {
		super();
		this.setMatricula(matricula);
		this.setKmsActuales(kmsActuales);
		this.setSucursal(sucursal);
		this.setCategoria(categoria);
		this.setNombre(nombre);
		
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


	public void setKmsActuales(double kmsActuales) {
		this.kmsActuales = kmsActuales;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getSucursal() {
		return sucursal;
	}


	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
