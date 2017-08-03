package presentacion.control;

import excepciones.LogicaExcepcion;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logica.DAOPersistenceTester;

public class ControladorPrincipal {
	private static ControladorPrincipal INSTANCIA = new ControladorPrincipal();
	public static ControladorPrincipal obtenerControladorPrincipal() {
        return INSTANCIA;
    }
	 private static final String CREAR_CLIENTE = "../vista/crear-cliente.fxml";
	 private static final String LISTAR_RESERVAS_SUCURSAL = "../vista/listar-reservas-sucursal.fxml";
	 private static final String LISTAR_SUCURSALES = "../vista/listar-sucursales.fxml";
	 private static final String CREAR_RESERVA = "../vista/crear-reserva.fxml";
	 private static final String LISTAR_CATEGORIAS = "../vista/listar-categorias.fxml";
	 private static final String LISTAR_VEHICULOS = "../vista/listar-vehiculos.fxml";
	 private static final String LISTAR_RESERVAS = "../vista/listar-reservas.fxml";
	 private static final String ENTREGAR_VEHICULO_RESERVADO = "../vista/entregar-vehiculo-reservado.fxml";
	 private static final String LISTAR_VEHICULOS_SUCURSAL_CATEGORIA = "../vista/listar-vehiculos-sucursal-categorial.fxml";
	
	 private Stage primaryStage;
	 
	@FXML
    private MenuItem botEntregarVehiculoReservado;
	 
	@FXML
    private MenuItem botListarVehiculos;

	@FXML
    private Button mostrarBD;
	 
	@FXML
    private MenuItem botListarSucursales;

    @FXML
    private MenuItem botCrearreserva;

    @FXML
    private MenuItem botSalir;

    @FXML
    private MenuItem botCrearClienteCliente;

    @FXML
    private MenuItem botCrearClienteEmpleado;

    @FXML
    private MenuItem botListarReservasSucursal;
	 
	 @FXML
	 void listarSucursales() throws LogicaExcepcion {
		
		Stage stage = initCasoDeUso(LISTAR_SUCURSALES,  ControladorListarSucursales.class).getStage();
		  stage.initModality(Modality.WINDOW_MODAL);
		  stage.show();
	 
	 }
	 
	 @FXML
	 void crearCliente(ActionEvent event) throws LogicaExcepcion {
		 Stage stage = initCasoDeUso(CREAR_CLIENTE,  ControladorCrearCliente.class).getStage();
		  stage.initModality(Modality.WINDOW_MODAL);
		  stage.show();
	
	 }
	
	 void crearCliente() throws LogicaExcepcion {
		 Stage stage = initCasoDeUso(CREAR_CLIENTE,  ControladorCrearCliente.class).getStage();
		  stage.initModality(Modality.WINDOW_MODAL);
		  stage.show();
	
	 }
	 
	 @FXML
	 void crearReserva(ActionEvent event) {
		 Stage stage = initCasoDeUso(CREAR_RESERVA,  ControladorCrearReserva.class).getStage();
		  stage.initModality(Modality.WINDOW_MODAL);
		  stage.show();
	 }
	 
	 @FXML
	 void listarReservasSucursal(ActionEvent event) throws LogicaExcepcion {
		 Stage stage = initCasoDeUso(LISTAR_RESERVAS_SUCURSAL,  ControladorListarReservasSucursal.class).getStage();
		  stage.initModality(Modality.WINDOW_MODAL);
		  stage.show();
	 }
	 
	 @FXML
	 void listarCategorias() throws LogicaExcepcion {
		 Stage stage = initCasoDeUso(LISTAR_CATEGORIAS,  ControladorListarCategorias.class).getStage();
		  stage.initModality(Modality.WINDOW_MODAL);
		  stage.show();
	 }
	 
	 @FXML
	 void listarReservas() throws LogicaExcepcion {
		 Stage stage = initCasoDeUso(LISTAR_RESERVAS,  ControladorListarReservas.class).getStage();
		  stage.initModality(Modality.WINDOW_MODAL);
		  stage.show();
	 }
	 
	 
	 @FXML
	 void listarVehiculos(ActionEvent event) throws LogicaExcepcion{
		 Stage stage = initCasoDeUso(LISTAR_VEHICULOS, ControladorListarVehiculos.class).getStage();
		 stage.initModality(Modality.WINDOW_MODAL);
		  stage.show();
	 }
	 
	 
	 @FXML
	 void listarVehiculosSucursalCategoria() throws LogicaExcepcion{
		 Stage stage = initCasoDeUso(LISTAR_VEHICULOS_SUCURSAL_CATEGORIA, ControladorListarVehiculosSucursalCategoria.class).getStage();
		 stage.initModality(Modality.WINDOW_MODAL);
		  stage.show();
	 }
	 
	 
	 
	 @FXML
	 void entregarVehiculoReservado(ActionEvent event) throws LogicaExcepcion{
		 Stage stage = initCasoDeUso(ENTREGAR_VEHICULO_RESERVADO, ControladorEntregarVehiculoReservado.class).getStage();
		 stage.initModality(Modality.WINDOW_MODAL);
		  stage.show();
	 }
	 
	 	 
	 @FXML
	 void salir(ActionEvent event) {
		 Platform.exit();
	 }
	 
	 @FXML
	 void mostrarBD(ActionEvent event) {
		 DAOPersistenceTester.main();
	 }
	 
	 public void setPrimaryStage(Stage primaryStage) {
		 this.primaryStage = primaryStage;
	 }
	 
	 private <T extends ControladorCasoDeUso> T initCasoDeUso(String urlVista, Class<T> controlClass) {
			  return ControladorCasoDeUso.initCasoDeUso(urlVista, controlClass, primaryStage, ControladorPrincipal.this);
	  }
}