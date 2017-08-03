package presentacion.control;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import persistencia.dto.ReservaDTO;
import persistencia.dto.SucursalDTO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import logica.DAL;

public class ControladorListarReservasSucursal extends ControladorCasoDeUso{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<ReservaDTO, Integer> tcSucDev;

    @FXML
    private TableColumn<ReservaDTO, String> tcCliente;

    @FXML
    private TableColumn<ReservaDTO, String> tcModAlq;

    @FXML
    private TextField txtSuc;

    @FXML
    private Button buscar;

    @FXML
    private TableColumn<ReservaDTO, LocalDate> tcFechaDev;

    @FXML
    private TableColumn<ReservaDTO, String> tcCat;

    @FXML
    private TableColumn<ReservaDTO, Integer> tcId;

    @FXML
    private TableColumn<ReservaDTO, LocalDate> tcFechaRec;

    @FXML
    private TableView<ReservaDTO> tvReserva;

    @FXML
    void buscar(ActionEvent event) {
    	int sucABuscar = Integer.parseInt(txtSuc.getText());
    	SucursalDTO sucDTO = DAL.obtenerDAL().buscarSucursal(sucABuscar);//Busca la sucursal en la BD y la devuelve.
    	  	
    	//Sucursal suc = AlquilerVehiculos.obtenerAlquilerVehiculos().buscarSucursal(sucABuscar);
    	
    	if(sucDTO!=null){
    		//Listar reserva esta sucursal
    		List<ReservaDTO> reservaList = DAL.obtenerDAL().obtenerReservasSucursales(sucDTO);//Devuelve las reservas de la sucursal dada
    		//Mostrar en las columnas:
    		ObservableList<ReservaDTO> oreservaList = FXCollections.observableArrayList(reservaList);
    		
    		tvReserva.setItems(oreservaList);
    		
    		
    		tcId.setCellValueFactory(new Callback<CellDataFeatures<ReservaDTO, Integer>, ObservableValue<Integer>>() {
  			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Integer> call(CellDataFeatures<ReservaDTO, Integer> p) {
       	         return new ReadOnlyObjectWrapper(p.getValue().getId());
       	     }
	
    		});
    	
    		tcFechaRec.setCellValueFactory(new Callback<CellDataFeatures<ReservaDTO, LocalDate>, ObservableValue<LocalDate>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
      	     public ObservableValue<LocalDate> call(CellDataFeatures<ReservaDTO, LocalDate> p) {
      	         return new ReadOnlyObjectWrapper(p.getValue().getFechaRecogida());
      	     }
	
    		});
    
    		tcFechaDev.setCellValueFactory(new Callback<CellDataFeatures<ReservaDTO, LocalDate>, ObservableValue<LocalDate>>() {
    		@SuppressWarnings({ "unchecked", "rawtypes" })
	  	     public ObservableValue<LocalDate> call(CellDataFeatures<ReservaDTO, LocalDate> p) {
	  	         return new ReadOnlyObjectWrapper(p.getValue().getFechaDevolucion());
	  	     }
	
			});
	
    		tcSucDev.setCellValueFactory(new Callback<CellDataFeatures<ReservaDTO, Integer>, ObservableValue<Integer>>() {
    		@SuppressWarnings({ "unchecked", "rawtypes" })
		     public ObservableValue<Integer> call(CellDataFeatures<ReservaDTO, Integer> p) {
		         return new ReadOnlyObjectWrapper(p.getValue().getIdSucursalDevolucion());
		     }
	
    		});
		
    		tcModAlq.setCellValueFactory(new Callback<CellDataFeatures<ReservaDTO, String>, ObservableValue<String>>() {
    		@SuppressWarnings({ "unchecked", "rawtypes" })
	  	     public ObservableValue<String> call(CellDataFeatures<ReservaDTO, String> p) {
	  	         return new ReadOnlyObjectWrapper(p.getValue().getModalidadAlquiler());
	  	     }
	
			});
			
    		tcCliente.setCellValueFactory(new Callback<CellDataFeatures<ReservaDTO, String>, ObservableValue<String>>() {
    		@SuppressWarnings({ "unchecked", "rawtypes" })
	      	     public ObservableValue<String> call(CellDataFeatures<ReservaDTO, String> p) {
	      	         return new ReadOnlyObjectWrapper(p.getValue().getNombreCategoria());
	      	     }
		
	   		});
	   		
    		tcCat.setCellValueFactory(new Callback<CellDataFeatures<ReservaDTO, String>, ObservableValue<String>>() {
    		@SuppressWarnings({ "unchecked", "rawtypes" })
	      	     public ObservableValue<String> call(CellDataFeatures<ReservaDTO, String> p) {
	      	         return new ReadOnlyObjectWrapper(p.getValue().getDniCliente());
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

    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	stage = new Stage(StageStyle.DECORATED);
    	stage.setTitle("RESERVAS SUCURSAL");
        assert tcSucDev != null : "fx:id=\"tcSucDev\" was not injected: check your FXML file 'listar-reservas-sucursal.fxml'.";
        assert tcCliente != null : "fx:id=\"tcCliente\" was not injected: check your FXML file 'listar-reservas-sucursal.fxml'.";
        assert tcModAlq != null : "fx:id=\"tcModAlq\" was not injected: check your FXML file 'listar-reservas-sucursal.fxml'.";
        assert txtSuc != null : "fx:id=\"txtSuc\" was not injected: check your FXML file 'listar-reservas-sucursal.fxml'.";
        assert buscar != null : "fx:id=\"buscar\" was not injected: check your FXML file 'listar-reservas-sucursal.fxml'.";
        assert tcFechaDev != null : "fx:id=\"tcfechaDev\" was not injected: check your FXML file 'listar-reservas-sucursal.fxml'.";
        assert tcCat != null : "fx:id=\"tcCat\" was not injected: check your FXML file 'listar-reservas-sucursal.fxml'.";
        assert tcId != null : "fx:id=\"tcId\" was not injected: check your FXML file 'listar-reservas-sucursal.fxml'.";
        assert tcFechaRec != null : "fx:id=\"tcFechaRec\" was not injected: check your FXML file 'listar-reservas-sucursal.fxml'.";
        assert tvReserva != null : "fx:id=\"tvReserva\" was not injected: check your FXML file 'listar-reservas-sucursal.fxml'.";

    }
}
