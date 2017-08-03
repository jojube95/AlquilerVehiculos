package logica;

import java.util.List;

import excepciones.*;
import persistencia.*;
import persistencia.dto.CategoriaDTO;
import persistencia.dto.ClienteDTO;
import persistencia.dto.CocheDTO;
import persistencia.dto.EmpleadoDTO;
import persistencia.dto.EntregaDTO;
import persistencia.dto.ReservaDTO;
import persistencia.dto.ReservaYClienteDTO;
import persistencia.dto.SucursalDTO;

public class DAL {
	 //Atributo
    private ICategoriaDAO catDAO;
    private IClienteDAO cliDAO;
    private IReservaDAO resDAO;
    private ISucursalDAO sucDAO;
    private ICocheDAO cochDAO;
    private IEntregaDAO entDAO;
    private IEmpleadoDAO empDAO;
    //Instancia de la clase (Patron Singleton)
    private static DAL INSTANCIA = new DAL();
    
    //Constructor privado para impedir la creacion de nuevos objetos (Patron Singleton)
    private DAL(){
        //Carga de datos pre-existentes
        try {
			this.catDAO =  new CategoriaDAOImp();
			this.cliDAO = new ClienteDAOImp();
			this.resDAO = new ReservaDAOImp();
			this.sucDAO = new SucursalDAOImp();
			this.cochDAO = new CocheDAOImp();
			this.entDAO = new EntregaDAOImp();
			this.empDAO = new EmpleadoDAOImp();
			
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //cargaSistema();
    }
    
    // Metodo para obtener la instancia de la clase (Patron Singleton)
    public static DAL obtenerDAL() {
        return INSTANCIA;
    }
    
    public List<CategoriaDTO> obtenerCategorias(){
        try{
            return catDAO.obtenerCategorias();
        } catch (DAOExcepcion e) {
            return null;
        }
    }
    public List<ClienteDTO> obtenerClientes(){
        try{
            return cliDAO.obtenerClientes();
        } catch (DAOExcepcion e) {
            return null;
        }
    }
    public List<ReservaDTO> obtenerReservas(){
        try{
            return resDAO.obtenerReservas();
        } catch (DAOExcepcion e) {
            return null;
        }
    }
    public List<SucursalDTO> obtenerSucursales(){
        try{
            return sucDAO.obtenerSucursales();
        } catch (DAOExcepcion e) {
            return null;
        }
    }
    
    public List<CocheDTO> obtenerCoches(){
    	try{
    		return cochDAO.obtenerCoches();
    	}catch(DAOExcepcion e){
    		return null;
    	}
    }
    
    public List<EntregaDTO> obtenerEntregas(){
    	try{
    		return entDAO.obtenerEntregas();
    	}catch(DAOExcepcion e){
    		return null;
    	}
    }
    
    public List<EmpleadoDTO> obtenerEmpleado(){
    	try{
    		return empDAO.obtenerEmpleado();
    	}catch(DAOExcepcion e){
    		return null;
    	}
    }
    
    public void crearCliente(ClienteDTO cliente) {
    	 try {
    		 cliDAO.crearCliente(cliente);
    	 } catch (DAOExcepcion e) {
    	 }
	}
    
    public void crearReserva(ReservaDTO reserva){
    	try{
    		resDAO.crearReserva(reserva);
    	} catch(DAOExcepcion e){
    	}
	}
    
    public void crearEntrega(EntregaDTO entrega){
    	try{
    		entDAO.crearEntrega(entrega);
    	}catch(DAOExcepcion e){
    	}
    }
    
    public SucursalDTO buscarSucursal(int id){
        try{
            return sucDAO.buscarSucursal(id);
        } catch (DAOExcepcion e) {
            return null;
        }
    }
    
    public ReservaDTO buscarReserva(int idReserva){
    	try{
    		return resDAO.buscarReserva(idReserva);
    	}catch(DAOExcepcion e){
    		return null;
    	}
    }
    
    public List<ReservaDTO> obtenerReservasSucursales(SucursalDTO sucDTO){
    	try{
            return sucDAO.obtenerReservasSucursal(sucDTO.getId());
        } catch (DAOExcepcion e) {
            return null;
        }
    	
    }
    
    public List<ReservaDTO> obtenerReservasPorEntregar(){
    	try{
    		return resDAO.obtenerReservasPorEntregar();
    	}catch(DAOExcepcion e){
    		return null;
    	}
    }
    
    public List<CocheDTO> obtenerCochesSucursalPorCategoria(int id, String categoria){
    	try{
    		return cochDAO.obtenerCochesSucursalPorCategoria(id, categoria);
    	}catch(DAOExcepcion e){
    		return null;
    	}
    }
    
    public List<CocheDTO> obtenerCochesSucursal(SucursalDTO sucDTO){
    	try{
    		return cochDAO.obtenerCochesSucursal(sucDTO.getId());
		}catch(DAOExcepcion e){
    		return null;
    	}
    }
    
    public List<ReservaYClienteDTO> obtenerReservasYCliente(){
    	try{
    		return resDAO.obtenerReservasYCliente();
		}catch(DAOExcepcion e){
    		return null;
    	}
    }
    
    public CategoriaDTO obtenerCategoriaSuperiorA(String nombreCategoria){
    	try{
    		return catDAO.obtenerCategoriaSuperiorA(nombreCategoria);
    	}catch(DAOExcepcion e){
    		return null;
    	}
    }
    
    public CategoriaDTO buscarCategoriaDTO(String nombreCategoria){
    	try{
    		return catDAO.buscarCategoriaDTO(nombreCategoria);
    	}catch(DAOExcepcion e){
    		return null;
    	}
    }

	public CocheDTO buscarCoche(String matricula) {
		try{
    		return cochDAO.buscarCoche(matricula);
    	}catch(DAOExcepcion e){
    		return null;
    	}
		
	}

	public EmpleadoDTO buscarEmpleado(String dni) {
		try{
    		return empDAO.buscarEmpleado(dni);
    	}catch(DAOExcepcion e){
    		return null;
    	}
	}

	public ClienteDTO buscarClienteDTO(String dni) {
		try{
    		return cliDAO.buscarCliente(dni);
    	}catch(DAOExcepcion e){
    		return null;
    	}
	}
    
}
