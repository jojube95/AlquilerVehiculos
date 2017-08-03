package presentacion.control;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import excepciones.LogicaExcepcion;
import persistencia.dto.CocheDTO;
import persistencia.dto.SucursalDTO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import logica.AlquilerVehiculos;
import logica.DAL;

public class ControladorListarVehiculos extends ControladorCasoDeUso{
	ControladorPrincipal conPrin = ControladorPrincipal.obtenerControladorPrincipal();
	@SuppressWarnings("unused")
	private Stage primaryStage;
	@SuppressWarnings("unused")
	private static final String LISTAR_SUCURSALES = "../vista/listar-sucursales.fxml";
	AlquilerVehiculos alq = AlquilerVehiculos.obtenerAlquilerVehiculos();
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtSuc;

    @FXML
    private TableColumn<CocheDTO, Double> tcKmsActuales;

    @FXML
    private Button buscar;

    @FXML
    private TableColumn<CocheDTO, String> tcCategoria;

    @FXML
    private TableView<CocheDTO> tvCoches;

    @FXML
    private TableColumn<CocheDTO, String> tcMatricula;

    @FXML
    private Button mostrarSucursales;

	    
	    @FXML
	    void buscar(ActionEvent event) {
	    	int sucABuscar = Integer.parseInt(txtSuc.getText());
	    	SucursalDTO sucDTO = DAL.obtenerDAL().buscarSucursal(sucABuscar);
	    	
	    	if(sucDTO!=null){
	    		//Listar reserva esta sucursal
	    		List<CocheDTO> cocheList = DAL.obtenerDAL().obtenerCochesSucursal(sucDTO);//Devuelve las reservas de la sucursal dada
	    		//Mostrar en las columnas:
	    		ObservableList<CocheDTO> oreservaList = FXCollections.observableArrayList(cocheList);
	    		
	    		tvCoches.setItems(oreservaList);
	    		
	    		
	    		tcMatricula.setCellValueFactory(new Callback<CellDataFeatures<CocheDTO, String>, ObservableValue<String>>() {
	  			@SuppressWarnings({ "unchecked", "rawtypes" })
				public ObservableValue<String> call(CellDataFeatures<CocheDTO, String> p) {
	       	         return new ReadOnlyObjectWrapper(p.getValue().getMatricula());
	       	     }
		
	    		});
	    	
	    		tcKmsActuales.setCellValueFactory(new Callback<CellDataFeatures<CocheDTO, Double>, ObservableValue<Double>>() {
				@SuppressWarnings({ "unchecked", "rawtypes" })
	      	     public ObservableValue<Double> call(CellDataFeatures<CocheDTO, Double> p) {
	      	         return new ReadOnlyObjectWrapper(p.getValue().getKmsActuales());
	      	     }
		
	    		});
	    		
	    		tcCategoria.setCellValueFactory(new Callback<CellDataFeatures<CocheDTO, String>, ObservableValue<String>>() {
				@SuppressWarnings({ "unchecked", "rawtypes" })
	      	     public ObservableValue<String> call(CellDataFeatures<CocheDTO, String> p) {
	      	         return new ReadOnlyObjectWrapper(p.getValue().getCategoria());
	      	     }
		
	    		});
	    	}
	    	else{
	    		Alert alert = new Alert(AlertType.ERROR);
	    		 alert.setTitle("Error");
	    		 alert.setHeaderText("No se ha encontrado la sucursal");
	    		 alert.setContentText("");
	    		 alert.showAndWait();
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
	    
	    

	    @FXML
	    void aceptar(ActionEvent event) {

	    }

	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
	    	stage = new Stage(StageStyle.DECORATED);
			stage.setTitle("LISTAR VEHICULOS");
		 ;
		 }
		
}
