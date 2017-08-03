package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Devolucion {
    //atributos
	public int id;
	public LocalDateTime fecha;
	public double totalACobrar;
	public boolean cobrado;
	public double kms;
	private double combustible;
	
	//relaciones
	private List<Danyo> ldanyo = new ArrayList<Danyo>();
	private Empleado empleado;
	private Entrega entrega;
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public double getTotalACobrar() {
		return totalACobrar;
	}
	public void setTotalACobrar(double totalACobrar) {
		this.totalACobrar = totalACobrar;
	}
	public boolean isCobrado() {
		return cobrado;
	}
	public void setCobrado(boolean cobrado) {
		this.cobrado = cobrado;
	}
	public double getKms() {
		return kms;
	}
	public void setKms(double kms) {
		this.kms = kms;
	}
	public double getCombustible() {
		return combustible;
	}
	public void setCombustible(double combustible) {
		this.combustible = combustible;
	}
	public List<Danyo> getLdanyo() {
		return ldanyo;
	}
	public void setLdanyo(List<Danyo> ldanyo) {
		this.ldanyo = ldanyo;
	}
	public void anaydirDanyo(Danyo danyo){
		this.ldanyo.add(danyo);
	}
	public void eliminarDanyo(Danyo danyo){
		this.ldanyo.remove(danyo);
	}
		
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
   
}