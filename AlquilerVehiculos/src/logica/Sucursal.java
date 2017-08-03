package logica;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    //Atributos:
    private int id;
    private String direccion;
    //Relaciones:
    private List<Empleado> lempleado = new ArrayList<Empleado>();
    private List<Coche> lcoche = new ArrayList<Coche>();
    private List<Reserva> llugarRecogida = new ArrayList<Reserva>();
    private List<Reserva> llugarEntrega = new ArrayList<Reserva>();
    //Constructor:
    public Sucursal(int id, String direccion){
        this.id = id;
        this.direccion = direccion;
    }
        
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public List<Empleado> getLempleado() {
        return lempleado;
    }
    public void setLempleado(List<Empleado> lempleado) {
        this.lempleado = lempleado;
    }
    public List<Coche> getLcoche() {
        return lcoche;
    }
    public void setLcoche(List<Coche> lcoche) {
        this.lcoche = lcoche;
    }
    public List<Reserva> getLlugarRecogida() {
        return llugarRecogida;
    }
    public void setLlugarRecogida(List<Reserva> llugarRecogida) {
        this.llugarRecogida = llugarRecogida;
    }
    public List<Reserva> getLlugarEntrega() {
        return llugarEntrega;
    }
    public void setLlugarEntrega(List<Reserva> llugarEntrega) {
        this.llugarEntrega = llugarEntrega;
    }
    
    public void anyadirEmpleado(Empleado empleado){
        this.lempleado.add(empleado);
    }
    public void eliminarEmpleado(Empleado empleado){
        this.lempleado.remove(empleado);
    }
        
    public void anyadirCoche(Coche coche){
        this.lcoche.add(coche);
    }
    public void eliminarCoche(Coche coche){
        this.lcoche.remove(coche);
    }
        
    public void anyadirLugarRecogida(Reserva lugarRecogida){
        this.llugarRecogida.add(lugarRecogida);
    }
    public void eliminarLugarRecogida(Reserva lugarRecogida){
        this.llugarRecogida.remove(lugarRecogida);
    }
        
    public void anyadirLugarEntrega(Reserva lugarEntrega){
        this.llugarEntrega.add(lugarEntrega);
    }
    public void eliminarLugarEntrega(Reserva lugarEntrega){
        this.llugarEntrega.remove(lugarEntrega);
    }
}
