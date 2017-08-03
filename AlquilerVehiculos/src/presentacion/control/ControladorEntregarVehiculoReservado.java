package presentacion.control;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import persistencia.dto.EntregaDTO;
import excepciones.LogicaExcepcion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;



public class ControladorEntregarVehiculoReservado extends ControladorCasoDeUso{
	static int idReserva;
	
	
	ControladorPrincipal conPrin = ControladorPrincipal.obtenerControladorPrincipal();
	@SuppressWarnings("unused")
	private Stage primaryStage;
	@SuppressWarnings("unused")
	private static final String LISTAR_VEHICULOS = "../vista/listar-vehiculos.fxml";
	@SuppressWarnings("unused")
	private static final String LISTAR_RESERVAS = "../vista/listar-reservas.fxml";
	AlquilerVehiculos alq = AlquilerVehiculos.obtenerAlquilerVehiculos();
	
	
	
	
  @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
	private TextField txtIdReserva = new TextField();

    @FXML
    private TextField txtKms;

    @FXML
    private TextField txtEmpleado;

    @FXML
    private Button listarReservas;

    @FXML
    private TextField txtTipoSeguro;

    @FXML
    private DatePicker fechaEntrega;

    @FXML
    private Button aceptar;

    @FXML
    private TextField txtCombustible;

    @FXML
    private Button listarVehiculos;

    @FXML
    private TextField txtMatricula;
    
    @FXML
    void listarReservas(ActionEvent event) {
    	try {
			conPrin.listarReservas();
		} catch (LogicaExcepcion e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void listarVehiculos(ActionEvent event) {
    	try {
    		this.idReserva = Integer.parseInt(txtIdReserva.getText());
    		if(alq.obtenerAlquilerVehiculos().buscarReserva(this.idReserva)==null){
    			Alert alert = new Alert(Alert.AlertType.ERROR);
				  alert.setTitle("Error");
				  alert.setHeaderText("Error");
				  alert.setContentText("-El ID de la reserva no existe.\n");
				  alert.showAndWait();
        	}
    		else{
    		
			conPrin.listarVehiculosSucursalCategoria();
    		}
		} catch (LogicaExcepcion e) {
			e.printStackTrace();
		}
    }

    @FXML
    void aceptar(ActionEvent event) {
    	
    	
    	String alerta = "";
    	Alert alert = new Alert(Alert.AlertType.ERROR);
    	if(alq.obtenerAlquilerVehiculos().buscarReserva(Integer.parseInt(txtIdReserva.getText()))==null){
    		alerta = alerta+"-El ID de la reserva no existe.\n";    		
    	}
		if(alq.obtenerAlquilerVehiculos().buscarCoche(txtMatricula.getText())==null){
			alerta = alerta+"-La matrícula del coche no existe.\n";
		}
		if(txtTipoSeguro.getText().length()>10){
			alerta = alerta+"-Tipo seguro de menos de 10 carácteres.\n";
		}
		if(alq.obtenerAlquilerVehiculos().buscarEmpleado(txtEmpleado.getText())==null){
			alerta = alerta+"-El empleado no existe.\n";
		}
		if(alerta.equals("")){
			try{
		    	EntregaDTO entrega = new EntregaDTO(Integer.parseInt(txtIdReserva.getText()),
		    			LocalDateTime.of(fechaEntrega.getValue().getYear(), fechaEntrega.getValue().getMonth(), fechaEntrega.getValue().getDayOfMonth(),0,0),
		    			txtTipoSeguro.getText(),
		    			Double.valueOf(txtKms.getText()),
		    			Double.valueOf(txtCombustible.getText()),
		    			txtMatricula.getText(),
		    			txtEmpleado.getText());
		    	AlquilerVehiculos.obtenerAlquilerVehiculos().crearEntrega(entrega);
		    	
		    	if(entrega!=null){
					Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
					alert2.setTitle("Confirmación");
					  alert2.setHeaderText("Se ha creado la entrega");
					  alert2.setContentText("La entrega se ha registrado correctamente.\n");
					  alert2.showAndWait();
					  stage.close();
				}
		    	
				}catch(NumberFormatException e){
  					  alert.setTitle("Error");
					  alert.setHeaderText("Error");
					  alert.setContentText("-Los campos Kms y Combustible son numéricos.\n");
					  alert.showAndWait();
				}
			
		}
		else{
	    	   	
    		  alert.setTitle("Error");
			  alert.setHeaderText("Error");
			  alert.setContentText(alerta);
			  alert.showAndWait();
	    	
	    	
		}
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	stage = new Stage(StageStyle.DECORATED);
		stage.setTitle("ENTREGAR VEHICULO RESERVADO");
	 ;
	 }
    
    
    public void setText (String elTexto)
    {
       txtIdReserva.setText(elTexto);
    }
    	    
}

