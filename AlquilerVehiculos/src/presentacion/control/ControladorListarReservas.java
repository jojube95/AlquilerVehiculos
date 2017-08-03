package presentacion.control;

import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javax.print.DocFlavor.URL;
import persistencia.dto.ReservaYClienteDTO;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import logica.DAL;

public class ControladorListarReservas extends ControladorCasoDeUso{
		int SucursalRecogida = -1;
		String nombreCategoria = null;
		int idReserva = -1;
		
		ControladorPrincipal conPrin = ControladorPrincipal.obtenerControladorPrincipal();
		

		@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TableColumn<ReservaYClienteDTO, String> modalidad;

	    @FXML
	    private TableView<ReservaYClienteDTO> tvReservas;

	    @FXML
	    private TableColumn<ReservaYClienteDTO, String> categoria;

	    @FXML
	    private Button aceptar;

	    @FXML
	    private TableColumn<ReservaYClienteDTO, LocalDate> fechaRecogida;

	    @FXML
	    private TableColumn<ReservaYClienteDTO, Integer> id;

	    @FXML
	    private TableColumn<ReservaYClienteDTO, LocalDate> fechaDevolucio;

	    @FXML
	    private TableColumn<ReservaYClienteDTO, String> nombre;

	    @FXML
	    private TableColumn<ReservaYClienteDTO, String> dni;

	    
		@Override
		public void initialize(java.net.URL arg0, ResourceBundle arg1) {
			stage = new Stage(StageStyle.DECORATED);
			stage.setTitle("LISTAR RESERVAS");
			
			//Listar reserva esta sucursal
    		List<ReservaYClienteDTO> reservaYClienteList = DAL.obtenerDAL().obtenerReservasYCliente();//Devuelve las reservas de la sucursal dada
    		//Mostrar en las columnas:
    		ObservableList<ReservaYClienteDTO> oreservaList = FXCollections.observableArrayList(reservaYClienteList);
    		
    		tvReservas.setItems(oreservaList);
    		
    		modalidad.setCellValueFactory(new Callback<CellDataFeatures<ReservaYClienteDTO, String>, ObservableValue<String>>() {
  			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<String> call(CellDataFeatures<ReservaYClienteDTO, String> p) {
       	         return new ReadOnlyObjectWrapper(p.getValue().getModalidadAlquiler());
       	     }
	
    		});
    		    		
    		id.setCellValueFactory(new Callback<CellDataFeatures<ReservaYClienteDTO, Integer>, ObservableValue<Integer>>() {
  			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ObservableValue<Integer> call(CellDataFeatures<ReservaYClienteDTO, Integer> p) {
       	         return new ReadOnlyObjectWrapper(p.getValue().getId());
       	     }
	
    		});
    	
    		categoria.setCellValueFactory(new Callback<CellDataFeatures<ReservaYClienteDTO, String>, ObservableValue<String>>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
      	     public ObservableValue<String> call(CellDataFeatures<ReservaYClienteDTO, String> p) {
      	         return new ReadOnlyObjectWrapper(p.getValue().getNombreCategoria());
      	     }
	
    		});
    		
    		fechaRecogida.setCellValueFactory(new Callback<CellDataFeatures<ReservaYClienteDTO, LocalDate>, ObservableValue<LocalDate>>() {
        		@SuppressWarnings({ "unchecked", "rawtypes" })
    	  	     public ObservableValue<LocalDate> call(CellDataFeatures<ReservaYClienteDTO, LocalDate> p) {
    	  	         return new ReadOnlyObjectWrapper(p.getValue().getFechaRecogida());
    	  	     }
    	
    			});
    
    		fechaDevolucio.setCellValueFactory(new Callback<CellDataFeatures<ReservaYClienteDTO, LocalDate>, ObservableValue<LocalDate>>() {
    		@SuppressWarnings({ "unchecked", "rawtypes" })
	  	     public ObservableValue<LocalDate> call(CellDataFeatures<ReservaYClienteDTO, LocalDate> p) {
	  	         return new ReadOnlyObjectWrapper(p.getValue().getFechaDevolucion());
	  	     }
	
			});
	
    		nombre.setCellValueFactory(new Callback<CellDataFeatures<ReservaYClienteDTO, String>, ObservableValue<String>>() {
    		@SuppressWarnings({ "unchecked", "rawtypes" })
		     public ObservableValue<String> call(CellDataFeatures<ReservaYClienteDTO, String> p) {
		         return new ReadOnlyObjectWrapper(p.getValue().getNombreyApellidos());
		     }
	
    		});
		
    		dni.setCellValueFactory(new Callback<CellDataFeatures<ReservaYClienteDTO, String>, ObservableValue<String>>() {
    		@SuppressWarnings({ "unchecked", "rawtypes" })
	  	     public ObservableValue<String> call(CellDataFeatures<ReservaYClienteDTO, String> p) {
	  	         return new ReadOnlyObjectWrapper(p.getValue().getDni());
	  	     }
	
			});
    		
    		
    		tvReservas.setRowFactory( tv -> {
    		    TableRow<ReservaYClienteDTO> row = new TableRow<>();
    		    return row ;
    		});
    		
    					
    		   			   		
    	}
   				
}
