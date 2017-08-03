

import java.io.IOException;

import presentacion.control.ControladorPrincipal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logica.AlquilerVehiculos;

public class AlquilerVehiculosApp extends Application {
	 private Stage primaryStage;
	 private BorderPane rootLayout;
	 AlquilerVehiculos alq;
	 
	 public static void main(String[] args) {
		 launch(args);
	 }
	 
	 @Override
	 public void start(Stage primaryStage) {
	   	 this.primaryStage = primaryStage;
		 this.primaryStage.setTitle("ALQUILER DE VEHICULOS");
		 initRootLayout();
	 }
	 
	 public void initRootLayout() {
	 try {
	 // Load root layout from fxml file.
		 FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(AlquilerVehiculosApp.class.getResource("presentacion/vista/VentanaPrincipal.fxml"));
		 rootLayout = loader.load();
		 // Show the scene containing the root layout.
		 Scene scene = new Scene(rootLayout);
		 primaryStage.setScene(scene);
		 primaryStage.show();
		 ControladorPrincipal controlador = loader.getController();
		 controlador.setPrimaryStage(primaryStage);
	 	} catch (IOException e) {
		 e.printStackTrace();
	 	}
	 }
	 
	 public AlquilerVehiculos obtenerAlquilerVehiculos(){
		 return alq;
	 }
}