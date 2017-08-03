package presentacion.control;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import logica.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.AlquilerVehiculos;

public class ControladorCrearCliente extends ControladorCasoDeUso {
	
	 private static final Logger LOG = Logger.getLogger(ControladorCrearCliente.class.getName());
	 
	 @FXML
	 private TextField dni;
	 
	 
	 
	 @FXML
	 private TextField nombreApellidos;
	 
	 @FXML
	 private TextField direccion;
	 
	 @FXML
	 private TextField añoTC;
	 
	 @FXML
	 private TextField mesTC;
	 
	 @FXML
	 private TextField codigoPostal;
	 
	 @FXML
	 private TextField poblacion;
	 
	 @FXML
	 private DatePicker fechaCarnet;
	 
	 @FXML
	 private TextField cvc;
	 
	 @FXML
	 private TextField tipoTarjeta;
	 
	 @FXML
	 private TextField digitosTC;
	 
	 @FXML
	 private Button aceptar;
	 
	 @FXML
	 private Button cancelar;
	 
 	 private Cliente nuevoCliente;
 	 
 	@SuppressWarnings("static-access")
	@FXML
	 void aceptar(ActionEvent event) {
 		String dni2 = dni.getText();
 		dni2 = dni2.format("%1$-10s", dni2);
 		String alerta ="";
 		Alert alert = new Alert(Alert.AlertType.ERROR);
 		
 		if(dni2.length()>10){
 			alerta = alerta+"-El dni debe tener menos de 10 cirfras.\n";
 		}
 		if(nombreApellidos.getText().length()>20){
 			alerta = alerta+"-El nombre no debe tener m�s de 20 car�cteres.\n";
 		}
 		if(direccion.getText().length()>20){
 			alerta = alerta+"-La direcci�n no debe tener m�s de 20 car�cteres.\n";
 		}
 		if(codigoPostal.getText().length()>5){
 			alerta = alerta+"-El c�digo postal no debe tener m�s de 5 car�cteres.\n";
 		}
 		if(poblacion.getText().length()>20){
 			alerta = alerta+"-La poblac�n no debe tener m�s de 20 car�cteres.\n";
 		}
 		if(digitosTC.getText().length()>16){
 			alerta = alerta+"-El n�mero de targeta no debe tener m�s de 16 car�cteres.\n";
 		}
 		if(Integer.parseInt(mesTC.getText())<1 || Integer.parseInt(mesTC.getText())>12){
 			alerta = alerta+"-Mes no v�lido.\n";
 		}
 		if(cvc.getText().length()>3){
 			alerta = alerta+"-El cvc no debe tener m�s de 3 car�cteres.\n";
 		}
 		if(tipoTarjeta.getText().length()>10){
 			alerta = alerta+"-El tipo de targeta no debe tener m�s de 10 car�cteres.\n";
 		}
 		
 		if(alerta.equals("")){
 		
 		
 		nuevoCliente = new Cliente(dni2, nombreApellidos.getText(),
				 direccion.getText(),
				 poblacion.getText(), codigoPostal.getText(),
				 LocalDateTime.of(fechaCarnet.getValue().getYear(), fechaCarnet.getValue().getMonth(), fechaCarnet.getValue().getDayOfMonth(),0,0), digitosTC.getText(),
				 Integer.parseInt(mesTC.getText()),
				 Integer.parseInt(añoTC.getText()),
				 Integer.parseInt(cvc.getText()), tipoTarjeta.getText());
 		
 			if (nuevoCliente != null) {
			//Invocamos el servicio encargado de Crear un nuevo cliente

				 AlquilerVehiculos.obtenerAlquilerVehiculos().crearCliente(nuevoCliente);
				  LOG.log(Level.INFO, "Se ha creado un nuevo Cliente: " +
				 nuevoCliente);
				  Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
				  alert2.setTitle("Informaci�n");
				  alert2.setHeaderText(null);
				  alert2.setContentText("Se he creado un nuevo cliente con DNI "+
				 nuevoCliente.getDni());
				  alert2.showAndWait();
				  stage.close();

 			} else {
				 LOG.log(Level.INFO, "No se ha podido crear un nuevo cliente.");
				  
				  alert.setTitle("Error");
				  alert.setHeaderText(null);
				  alert.setContentText("Ha habido un error y no se ha podido crear un nuevo cliente !");
				  alert.showAndWait();
		  	}
 		}
		else{
			alert.setTitle("Error");
			  alert.setHeaderText(null);
			  alert.setContentText(alerta);
			  alert.showAndWait();
				  
	 }
 	}
	 
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("CREAR CLIENTE");
		 cancelar.setOnAction(event -> stage.close());
		
	 
}}