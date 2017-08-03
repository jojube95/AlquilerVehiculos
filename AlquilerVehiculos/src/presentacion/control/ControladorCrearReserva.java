package presentacion.control;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import excepciones.LogicaExcepcion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;
import logica.Reserva;

public class ControladorCrearReserva extends ControladorCasoDeUso{
	ControladorPrincipal conPrin = ControladorPrincipal.obtenerControladorPrincipal();
	@SuppressWarnings("unused")
	private Stage primaryStage;
	@SuppressWarnings("unused")
	private static final String LISTAR_CATEGORIAS = "../vista/listar-categorias.fxml";
	@SuppressWarnings("unused")
	private static final String LISTAR_SUCURSALES = "../vista/listar-sucursales.fxml";
	String modalidad = null;
	AlquilerVehiculos alq = AlquilerVehiculos.obtenerAlquilerVehiculos();
	
	private static final Logger LOG = Logger.getLogger(ControladorCrearReserva.class.getName());
	
	  	@FXML
	    private TextField sucDevolucion;

	    @FXML
	    private DatePicker fechaDevolucion;
	    
	    @FXML
	    private RadioButton sKmIlim;
	    
	    @FXML
	    private RadioButton sKmLim;

	    @FXML
	    private Button cancelar;

	    @FXML
	    private TextField clienteRealiza;

	    @FXML
	    private TextField modalidadAlquiler;

	    @FXML
	    private TextField categoria;

	    @FXML
	    private Button aceptar;

	    @FXML
	    private DatePicker fechaRecogida;

	    @FXML
	    private TextField sucRecogida;

	    @FXML
	    private TextField dni;
	    
	    private Reserva nuevaReserva;
	    
	    @FXML
	    private Button mostrarCategorias;

	    @FXML
	    private Button mostrarSucursales;
	    
	    @FXML
	    void mostrarCategorias(ActionEvent event) {
	    	try {
				conPrin.listarCategorias();
			} catch (LogicaExcepcion e) {
				e.printStackTrace();
			}
	    		
	    }

	    @FXML
	    void mostrarSucursales(ActionEvent event) {
	    	try {
				conPrin.listarSucursales();
			} catch (LogicaExcepcion e) {
				e.printStackTrace();
			}
	    	
	    }
	    
	    @SuppressWarnings("static-access")
		@FXML
	    void aceptar(ActionEvent event) {
	    	
	    	String alerta = "";
	    	Alert alert = new Alert(Alert.AlertType.ERROR);
	    	Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
	    	
	    	if(sKmLim.isSelected()==true){
	    		modalidad = "KmLim";
	    		
	    	}
	    	else{
	    		modalidad = "KmIlim";
	    	}
	    	
	    	if(fechaDevolucion.getValue()==null || fechaRecogida.getValue()==null){
	    		alerta = alerta+"-Fecha mal introducida.\n";
	    	}
	    	if(alq.ComprobarCategoria(categoria.getText())==false){
	    		alerta = alerta+"-Categoria no existe, o categor�a superior a 20 car�cteres.\n";
	    	}
	    	if(alq.ComprobarSucursal(Integer.parseInt(sucDevolucion.getText()))==false){
		    	alerta = alerta+"-Sucursal devoluci�n no existe.\n";
	    	}
	    	if(alq.ComprobarSucursal(Integer.parseInt(sucRecogida.getText()))==false){
	    		alerta = alerta+"-Sucursal recogida no existe.\n";
	    	}
	    	if(alq.buscarClienteDTO(dni.getText())==null){
				alerta = alerta+"-Dni no existe.\n";
	    	}
	    	if(alerta.equals("")){
	    		nuevaReserva = new Reserva((int)(Math.random()*1000),
						 LocalDateTime.of(fechaDevolucion.getValue().getYear(), fechaDevolucion.getValue().getMonth(), fechaDevolucion.getValue().getDayOfMonth(),0,0),
						LocalDateTime.of(fechaRecogida.getValue().getYear(), fechaRecogida.getValue().getMonth(), fechaRecogida.getValue().getDayOfMonth(),0,0),
						modalidad,
						categoria.getText(),
						dni.getText(),
						Integer.parseInt(sucRecogida.getText()),
						Integer.parseInt(sucDevolucion.getText()));
				 
				 if (nuevaReserva != null) {
					//Invocamos el servicio encargado de Crear un nuevo cliente
	
					 AlquilerVehiculos.obtenerAlquilerVehiculos().crearReserva(nuevaReserva);
					  LOG.log(Level.INFO, "Se ha creado una nueva Reserva: " + nuevaReserva);
					  alert2.setTitle("Informaci�n");
					  alert2.setHeaderText(null);
					  alert2.setContentText("Se he creado una nueva reserva con ID "+ nuevaReserva.getId());
					  alert2.showAndWait();
				 } else {
					 LOG.log(Level.INFO, "No se ha podido crear una nueva reserva.");
							  alert.setTitle("Error");
							  alert.setHeaderText(null);
							  alert.setContentText("Ha habido un error y no se ha podido crear una nueva reserva !");
							  alert.showAndWait();
					  }
							  stage.close();
			  }
	    	else{
	    	
	    	
	    		alert.setTitle("Error");
				  alert.setHeaderText(null);
				  alert.setContentText(alerta);
				  alert.showAndWait();
	    		
	    	}
	    }
	    
	    	
	    	
									  
							  
								 
		
	    @FXML
	    void cancelar(ActionEvent event) {

	    }

	@Override
    public void initialize(URL location, ResourceBundle resources) {
    	stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("CREAR RESERVA");
		 cancelar.setOnAction(event -> stage.close());
		 ;
	 }
}

    
	
	
