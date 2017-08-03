package logica;

public class Danyo {

	//atributos
	private int id;
	private String zona;
	private String descripcion;
	
	//relaciones
	public Entrega entrega;
	public Devolucion devolucion;
	//consultores
	public int getId(){return id;}
	public String getZona(){return zona;}
	public String getDescripcion(){return descripcion;}
	
	//modificadores
	public void setId(int i){id=i;}
	public void setZona(String z){zona=z;}
	public void setDescripcion(String d){descripcion=d;}
}
