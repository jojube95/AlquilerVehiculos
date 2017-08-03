package presentacion.control;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import persistencia.dto.SucursalDTO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import logica.DAL;

public class ControladorListarSucursales extends ControladorCasoDeUso {
			
	 @FXML
	 private TableView<SucursalDTO> sucursales;
	 
	 @FXML
	 private TableColumn<SucursalDTO, Integer> id;
	 
	 @FXML
	 private TableColumn<SucursalDTO, String> direccion;
	 
	 @FXML
	 private Button aceptar;
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		
		 stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("CREAR CLIENTE");
		 aceptar.setOnAction(event -> stage.close());
		 
		 List<SucursalDTO> sucursalList = DAL.obtenerDAL().obtenerSucursales();
 		//Mostrar en las columnas:
 		ObservableList<SucursalDTO> osucursalList = FXCollections.observableArrayList(sucursalList);
 		
 		sucursales.setItems(osucursalList);
 		
 		id.setCellValueFactory(new Callback<CellDataFeatures<SucursalDTO, Integer>, ObservableValue<Integer>>() {
  			@SuppressWarnings({ "rawtypes", "unchecked" })
			public ObservableValue<Integer> call(CellDataFeatures<SucursalDTO, Integer> p) {
       	         return new ReadOnlyObjectWrapper(p.getValue().getId());
       	     }
	
    		});
    	
    		direccion.setCellValueFactory(new Callback<CellDataFeatures<SucursalDTO, String>, ObservableValue<String>>() {
      	     @SuppressWarnings({ "rawtypes", "unchecked" })
			public ObservableValue<String> call(CellDataFeatures<SucursalDTO, String> p) {
      	         return new ReadOnlyObjectWrapper(p.getValue().getDireccion());
      	     }
	
    		});
	 }
}