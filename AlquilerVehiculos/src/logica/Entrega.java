package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Entrega {

	//atributos//
	private int id;
	private LocalDateTime fecha;
	private String tipoSeguro;
	private double kms;
	private double combustible;
	private String cocheAsignado;
	private String empleadoRealiza;
	
	//atributos relaciones
	private Reserva reserva;
	private List<Danyo> ldanyo = new ArrayList<Danyo>();
	private Devolucion devolucion;
	private Empleado empleado;
	private Coche coche;
	
	public Entrega(int id, LocalDateTime fecha, String tipoSeguro, double kms, double combustible, Coche coche, Empleado empleado){
		this.id = id;
		this.fecha = fecha;
		this.tipoSeguro = tipoSeguro;
		this.kms = kms;
		this.combustible = combustible;
		this.coche = coche;
		this.empleado = empleado;
	}
	
	public Entrega(int id, LocalDateTime fecha, String tipoSeguro, double kms, double combustible, String cocheAsignado, String empleadoRealiza){
		this.id = id;
		this.fecha = fecha;
		this.tipoSeguro = tipoSeguro;
		this.kms = kms;
		this.combustible = combustible;
		this.setCocheAsignado(cocheAsignado);
		this.setEmpleadoRealiza(empleadoRealiza);
	}
		
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getTipoSeguro() {
		return tipoSeguro;
	}
	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
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
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
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
		
	public Devolucion getDevolucion() {
		return devolucion;
	}
	public void setDevolucion(Devolucion devolucion) {
		this.devolucion = devolucion;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Coche getCoche() {
		return coche;
	}
	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCocheAsignado() {
		return cocheAsignado;
	}

	public void setCocheAsignado(String cocheAsignado) {
		this.cocheAsignado = cocheAsignado;
	}

	public String getEmpleadoRealiza() {
		return empleadoRealiza;
	}

	public void setEmpleadoRealiza(String empleadoRealiza) {
		this.empleadoRealiza = empleadoRealiza;
	}
}
