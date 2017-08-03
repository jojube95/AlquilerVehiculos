package logica;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	//Atributos:
    private String nombre;
	private double precioModIlimitada;
	private double precioModKms;
	private double precioKmModKms;
	private double precioSeguroTRiesgo;
	private double precioSeguroTerceros;
	private String nombreCategoriaSuperior;
	//Relaciones:
	private Categoria categoriaSuperior;
	private List<Coche> lcoche = new ArrayList<Coche>();
    //Contructor:
    //Constructor:
	public Categoria(String nombre, double precioModIlimitada, double precioModKms, double precioKmModKms, double precioSeguroTRiesgo, double precioSeguroTerceros){
		this.nombre = nombre;
		this.precioModIlimitada = precioModIlimitada;
		this.precioModKms = precioModKms;
		this.precioKmModKms = precioKmModKms;
		this.precioSeguroTRiesgo = precioSeguroTRiesgo;
		this.precioSeguroTerceros = precioSeguroTerceros;
	}
	
	public Categoria(String nombre, double precioModIlimitada, double precioModKms, double precioKmModKms, double precioSeguroTRiesgo, double precioSeguroTerceros, String nombreCategoriaSuperior){
		this.nombre = nombre;
		this.precioModIlimitada = precioModIlimitada;
		this.precioModKms = precioModKms;
		this.precioKmModKms = precioKmModKms;
		this.precioSeguroTRiesgo = precioSeguroTRiesgo;
		this.precioSeguroTerceros = precioSeguroTerceros;
		this.nombreCategoriaSuperior = nombreCategoriaSuperior;
	}
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	public double getPrecioModIlimitada() {
		return precioModIlimitada;
	}
	public void setPrecioModIlimitada(double precioModIlimitada) {
		this.precioModIlimitada = precioModIlimitada;
	}
	public double getPrecioModKms() {
		return precioModKms;
	}
	public void setPrecioModKms(double precioModKms) {
		this.precioModKms = precioModKms;
	}
	public double getPrecioKmModKms() {
		return precioKmModKms;
	}
	public void setPrecioKmModKms(double precioKmModKms) {
		this.precioKmModKms = precioKmModKms;
	}
	public double getPrecioSeguroTRiesgo() {
		return precioSeguroTRiesgo;
	}
	public void setPrecioSeguroTRiesgo(double precioSeguroTRiesgo) {
		this.precioSeguroTRiesgo = precioSeguroTRiesgo;
	}
	public double getPrecioSeguroTerceros() {
		return precioSeguroTerceros;
	}
	public void setPrecioSeguroTerceros(double precioSeguroTerceros) {
		this.precioSeguroTerceros = precioSeguroTerceros;
	}
	public Categoria getCategoriaSuperior() {
		return categoriaSuperior;
	}
	public void setCategoriaSuperior(Categoria categoriaSuperior) {
		this.categoriaSuperior = categoriaSuperior;
	}
	public List<Coche> getLcoche() {
		return lcoche;
	}
	public void setLcoche(List<Coche> lcoche) {
		this.lcoche = lcoche;
	}
	
	public void anaydirCoche(Coche coche){
		this.lcoche.add(coche);
	}
	public void eliminarCoche(Coche coche){
		this.lcoche.remove(coche);
	}

	public String getNombreCategoriaSuperior() {
		return nombreCategoriaSuperior;
	}

	public void setNombreCategoriaSuperior(String nombreCategoriaSuperior) {
		this.nombreCategoriaSuperior = nombreCategoriaSuperior;
	}
}
