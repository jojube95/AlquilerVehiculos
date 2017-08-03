package presentacion.control;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import persistencia.dto.CategoriaDTO;
import persistencia.dto.CocheDTO;
import persistencia.dto.ReservaDTO;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import logica.AlquilerVehiculos;
import logica.DAL;

public class ControladorListarVehiculosSucursalCategoria extends ControladorCasoDeUso{
	public static int SucursalRecogida = -1;
	public int idReserva = -1;
	public CategoriaDTO categoria;
	public String categoriaABuscar;
	public int sucABuscar = -1;
	ControladorPrincipal conPrin = ControladorPrincipal.obtenerControladorPrincipal();
	AlquilerVehiculos alq = AlquilerVehiculos.obtenerAlquilerVehiculos();
	
    @FXML
    private TableView<CocheDTO> tvCoche;

    @FXML
    private TableColumn<CocheDTO, Double> tcKmsActuales;

    @FXML
    private Button butCatSup;

    @FXML
    private TableColumn<CocheDTO, String> tcCategoria;

    @FXML
    private TableColumn<CocheDTO, String> tcMatricula;
    
    @FXML
    void categoriaSuperior(ActionEvent event) {
    	System.out.println("Categoria superior");
    	categoriaABuscar = categoria.getNombreCategoriaSuperior();
    	if(categoriaABuscar==null){
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("ERROR");
    		alert.setHeaderText("Error");
    		alert.setContentText("No existe categor�a superior.");
    		alert.showAndWait();
    	}
    	else{
    	categoria = AlquilerVehiculos.obtenerAlquilerVehiculos().buscarCategoriaDTO(categoriaABuscar);
    	System.out.println("Categoria a buscar= "+categoriaABuscar);
    	List<CocheDTO> cochDTO = DAL.obtenerDAL().obtenerCochesSucursalPorCategoria(sucABuscar, categoriaABuscar);
		//Mostrar en las columnas:
		ObservableList<CocheDTO> oreservaList = FXCollections.observableArrayList(cochDTO);
		
		tvCoche.setItems(oreservaList);
		
		
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
    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		stage = new Stage(StageStyle.DECORATED);
		stage.setTitle("LISTAR VEHICULOS");
		
		this.idReserva = ControladorEntregarVehiculoReservado.idReserva;
		System.out.println(this.idReserva);
		ReservaDTO reserva = AlquilerVehiculos.obtenerAlquilerVehiculos().buscarReserva(this.idReserva);
		categoria = AlquilerVehiculos.obtenerAlquilerVehiculos().buscarCategoriaDTO(reserva.getNombreCategoria());
		
    	
    	sucABuscar = reserva.getIdSucursalRecogida();
		categoriaABuscar = categoria.getNombre();
		System.out.println("Categoria a buscar= "+categoriaABuscar);
		System.out.println("Sucursal a buscar= "+sucABuscar);
		
		List<CocheDTO> cochDTO = DAL.obtenerDAL().obtenerCochesSucursalPorCategoria(sucABuscar, categoriaABuscar);
		//Mostrar en las columnas:
		ObservableList<CocheDTO> oreservaList = FXCollections.observableArrayList(cochDTO);
		
		tvCoche.setItems(oreservaList);
		
		
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
	 

}

