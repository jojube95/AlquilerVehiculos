package presentacion.control;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import persistencia.dto.CategoriaDTO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import logica.DAL;

public class ControladorListarCategorias extends ControladorCasoDeUso{
	
	 @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<CategoriaDTO> tvCategorias;

    @FXML
    private TableColumn<CategoriaDTO, String> tcNombre;

    @FXML
    private TableColumn<CategoriaDTO, Double> tcTer;

    @FXML
    private Button aceptar;

    @FXML
    private TableColumn<CategoriaDTO, Double> tcKmModKm;

    @FXML
    private TableColumn<CategoriaDTO, Double> tcTR;

    @FXML
    private TableColumn<CategoriaDTO, Double> tcModIlim;

    @FXML
    private TableColumn<CategoriaDTO, Double> tcModKms;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert tvCategorias != null : "fx:id=\"tvCategorias\" was not injected: check your FXML file 'listar-categorias.fxml'.";
        assert tcNombre != null : "fx:id=\"tcNombre\" was not injected: check your FXML file 'listar-categorias.fxml'.";
        assert tcTer != null : "fx:id=\"tcTer\" was not injected: check your FXML file 'listar-categorias.fxml'.";
        assert aceptar != null : "fx:id=\"aceptar\" was not injected: check your FXML file 'listar-categorias.fxml'.";
        assert tcKmModKm != null : "fx:id=\"tcKmModKm\" was not injected: check your FXML file 'listar-categorias.fxml'.";
        assert tcTR != null : "fx:id=\"tcTR\" was not injected: check your FXML file 'listar-categorias.fxml'.";
        assert tcModIlim != null : "fx:id=\"tcModIlim\" was not injected: check your FXML file 'listar-categorias.fxml'.";
        assert tcModKms != null : "fx:id=\"tcModKms\" was not injected: check your FXML file 'listar-categorias.fxml'.";
        
        stage = new Stage(StageStyle.DECORATED);
		 stage.setTitle("CREAR CLIENTE");
		 
		 aceptar.setOnAction(event -> stage.close());
		 
		 List<CategoriaDTO> categoriaList = DAL.obtenerDAL().obtenerCategorias();
		//Mostrar en las columnas:
		ObservableList<CategoriaDTO> ocategoriaList = FXCollections.observableArrayList(categoriaList);
		
		tvCategorias.setItems(ocategoriaList);
		
		tcNombre.setCellValueFactory(new Callback<CellDataFeatures<CategoriaDTO, String>, ObservableValue<String>>() {
 			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<CategoriaDTO, String> p) {
      	         return new ReadOnlyObjectWrapper(p.getValue().getNombre());
      	     }
	
   		});
		
		tcTer.setCellValueFactory(new Callback<CellDataFeatures<CategoriaDTO, Double>, ObservableValue<Double>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
 			public ObservableValue<Double> call(CellDataFeatures<CategoriaDTO, Double> p) {
      	         return new ReadOnlyObjectWrapper(p.getValue().getPrecioSeguroTerceros());
      	     }
	
   		});
		
		tcKmModKm.setCellValueFactory(new Callback<CellDataFeatures<CategoriaDTO, Double>, ObservableValue<Double>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
 			public ObservableValue<Double> call(CellDataFeatures<CategoriaDTO, Double> p) {
      	         return new ReadOnlyObjectWrapper(p.getValue().getPrecioKMModKms());
      	     }
	
   		});
		
		tcTR.setCellValueFactory(new Callback<CellDataFeatures<CategoriaDTO, Double>, ObservableValue<Double>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
 			public ObservableValue<Double> call(CellDataFeatures<CategoriaDTO, Double> p) {
      	         return new ReadOnlyObjectWrapper(p.getValue().getPrecioSeguroTRiesgo());
      	     }
	
   		});
		
		tcModIlim.setCellValueFactory(new Callback<CellDataFeatures<CategoriaDTO, Double>, ObservableValue<Double>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
 			public ObservableValue<Double> call(CellDataFeatures<CategoriaDTO, Double> p) {
      	         return new ReadOnlyObjectWrapper(p.getValue().getPrecioModIlimitada());
      	     }
	
   		});
		
		tcModKms.setCellValueFactory(new Callback<CellDataFeatures<CategoriaDTO, Double>, ObservableValue<Double>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
 			public ObservableValue<Double> call(CellDataFeatures<CategoriaDTO, Double> p) {
      	         return new ReadOnlyObjectWrapper(p.getValue().getPrecioModKms());
      	     }
	
   		});
    }
}
