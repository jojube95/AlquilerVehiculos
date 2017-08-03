package logica;

import java.util.ArrayList;
import java.util.List;

import persistencia.dto.CategoriaDTO;
import persistencia.dto.ClienteDTO;
import persistencia.dto.CocheDTO;
import persistencia.dto.EmpleadoDTO;
import persistencia.dto.EntregaDTO;
import persistencia.dto.ReservaDTO;
import persistencia.dto.SucursalDTO;

public class DAOPersistenceTester {
	//Instancia clase AlquilerVehiculos:
	AlquilerVehiculos alq1 = AlquilerVehiculos.obtenerAlquilerVehiculos();
	static DAL dal = DAL.obtenerDAL();
	//Metodo main:
	public static void main(){
		//Cargar clases de la base de datos:
		List<CategoriaDTO> listaCatDto = dal.obtenerCategorias();
		List<ClienteDTO> listaCliDto = dal.obtenerClientes();
		List<ReservaDTO> listaResDto = dal.obtenerReservas();
		List<SucursalDTO> listaSucDto = dal.obtenerSucursales();
		List<CocheDTO> listaCochDto = dal.obtenerCoches();
		List<EntregaDTO> listaEntDto = dal.obtenerEntregas();
		List<EmpleadoDTO> listaEmpDto = dal.obtenerEmpleado();
		
		//Convertir List<CategoriaDTO> a List<Categoria>
		List<Categoria> listaCat = new ArrayList<Categoria>();
		for(int i = 0; i<listaCatDto.size(); i++){
			listaCat.add(CategoriaDTOtoCategoria(listaCatDto.get(i)));
		}
		//Convertir List<ClienteDTO> a List<Cliente>
		
		List<Cliente> listaCli = new ArrayList<Cliente>();
		if(listaCliDto!=null){
			for(int i = 0; i<listaCliDto.size(); i++){
				listaCli.add(ClienteDTOtoCliente(listaCliDto.get(i)));
			}
		}
		//Convertir List<ReservaDTO> a List<Reserva>
		List<Reserva> listaRes = new ArrayList<Reserva>();
		if(listaResDto!=null){
		for(int i = 0; i<listaResDto.size(); i++){
			listaRes.add(ReservaDTOtoReserva(listaResDto.get(i)));
		}
		}
		//Convertir List<SucursalDTO> a List<Sucursal>
		List<Sucursal> listaSuc = new ArrayList<Sucursal>();
		for(int i = 0; i<listaSucDto.size(); i++){
			listaSuc.add(SucursalDTOtoSucursal(listaSucDto.get(i)));
		}
		//Convertir List<CocheDTO> a List<Coche>
		List<Coche> listaCoch = new ArrayList<Coche>();
		for(int i = 0; i<listaCochDto.size(); i++){
			listaCoch.add(CocheDTOtoCoche(listaCochDto.get(i)));
		}
		//Convertir List<EntregaDTO> a List<Entrega>
		List<Entrega> listaEnt = new ArrayList<Entrega>();
		if(listaEntDto!=null){
		for(int i = 0; i<listaEntDto.size(); i++){
			listaEnt.add(EntregaDTOtoEntrega(listaEntDto.get(i)));
		}
		}
		
		
		
		//Mostrar la lista de categoria anteriormente cargada:
		for(int i = 0; i<listaCat.size(); i++){
			System.out.println("Categoria num "+i+" : "+listaCat.get(i).getNombre()+"|"+listaCat.get(i).getPrecioModIlimitada()+"|"+listaCat.get(i).getPrecioModKms()+"|"+listaCat.get(i).getPrecioKmModKms()+"|"+listaCat.get(i).getPrecioSeguroTRiesgo()+"|"+listaCat.get(i).getPrecioSeguroTerceros()+"|"+listaCat.get(i).getNombreCategoriaSuperior()+".\n");
		}
		//Mostrar la lista de cliente anteriormente cargada:
		for(int i = 0; i<listaCli.size(); i++){
			System.out.println("Cliente num "+i+" : "+listaCli.get(i).getDni()+"|"+listaCli.get(i).getNombreyApellidos()+"|"+listaCli.get(i).getDireccion()+"|"+listaCli.get(i).getPoblacion()+"|"+listaCli.get(i).getCodPostal()+"|"+listaCli.get(i).getFechaCarnetConducir()+"|"+listaCli.get(i).getDigitosTC()+"|"+listaCli.get(i).getMesTC()+"|"+listaCli.get(i).getAnyoTC()+"|"+listaCli.get(i).getCvcTC()+"|"+listaCli.get(i).getTipoTC()+".\n");
		}
		//Mostrar la lista de reserva anteriormente cargada:
		for(int i = 0; i<listaRes.size(); i++){
			System.out.println("Reserva num "+i+" : "+listaRes.get(i).getId()+"|"+listaRes.get(i).getFechaRecogida()+"|"+listaRes.get(i).getFechaDevolucion()+"|"+listaRes.get(i).getModalidadAlquiler()+"|"+listaRes.get(i).getNombreCategoria()+"|"+listaRes.get(i).getDniCliente()+"|"+listaRes.get(i).getIdSucursalRecogida()+"|"+listaRes.get(i).getIdSucursalDevolucion()+".\n");
		}
		//Mostrar la lista de sucursal anteriormente cargada:
		for(int i = 0; i<listaSuc.size(); i++){
			System.out.println("Sucursal num "+i+" : "+listaSuc.get(i).getId()+"|"+listaSuc.get(i).getDireccion()+".\n");
		}
		//Mostrar la lista de coches anteriormente cargada:
		for(int i = 0; i<listaCoch.size(); i++){
			System.out.println("Coche num "+i+" : "+listaCoch.get(i).getMatricula()+"|"+listaCoch.get(i).getKmsActuales()+"|"+listaCoch.get(i).getSucursalId()+"|"+listaCoch.get(i).getNombreCategoria()+"|"+listaCoch.get(i).getNombre()+".\n");
		}
		//Mostrar la lista de entregas anteriormente cargada:
		for(int i = 0; i<listaEnt.size(); i++){
			System.out.println("Entrega num "+i+" : "+listaEnt.get(i).getId()+"|"+listaEnt.get(i).getFecha()+"|"+listaEnt.get(i).getTipoSeguro()+"|"+listaEnt.get(i).getKms()+"|"+listaEnt.get(i).getCombustible()+"|"+listaEnt.get(i).getCocheAsignado()+"|"+listaEnt.get(i).getEmpleadoRealiza()+".\n");
		}
		//Mostrar la lista de empleados anteriormente cargada:
		for(int i = 0; i<listaEmpDto.size(); i++){
			System.out.println("Empleado num "+i+" : "+listaEmpDto.get(0).getDni()+"|"+listaEmpDto.get(i).getNombre()+"|"+listaEmpDto.get(i).isAdministrador()+"|"+listaEmpDto.get(i).getSucursal()+".\n");
		}
		
	}
	
	private static Categoria CategoriaDTOtoCategoria(CategoriaDTO cdto){
		Categoria cat = new Categoria(cdto.getNombre(), cdto.getPrecioModIlimitada(), cdto.getPrecioModKms(), cdto.getPrecioKMModKms(), cdto.getPrecioSeguroTRiesgo(), cdto.getPrecioSeguroTerceros(), cdto.getNombreCategoriaSuperior());
		return cat;
	}
	
	private static Cliente ClienteDTOtoCliente(ClienteDTO cdto){
		Cliente cli = new Cliente(cdto.getDni(), cdto.getNombreyApellidos(), cdto.getDireccion(), cdto.getPoblacion(), cdto.getCodPostal(), cdto.getFechaCanetConducir(), cdto.getDigitosTC(), cdto.getMesTC(), cdto.getAnyoTC(), cdto.getCvcTC(), cdto.getTipoTC());
		return cli;
	}
	private static Reserva ReservaDTOtoReserva(ReservaDTO cdto){
		Reserva res = new Reserva(cdto.getId(), cdto.getFechaRecogida(), cdto.getFechaDevolucion(), cdto.getModalidadAlquiler(), cdto.getNombreCategoria(), cdto.getDniCliente(), cdto.getIdSucursalRecogida(), cdto.getIdSucursalDevolucion());
		return res;
	}
	private static Sucursal SucursalDTOtoSucursal(SucursalDTO cdto){
		Sucursal suc = new Sucursal(cdto.getId(), cdto.getDireccion());
		return suc;
	}
	private static Coche CocheDTOtoCoche(CocheDTO cdto){
		Coche coch = new Coche(cdto.getMatricula(), cdto.getKmsActuales(), cdto.getSucursal(), cdto.getCategoria(), cdto.getNombre());
		return coch;
	}
	private static Entrega EntregaDTOtoEntrega(EntregaDTO cdto){
		Entrega ent = new Entrega(cdto.getId(), cdto.getFecha(), cdto.getTipoSeguro(), cdto.getKms(), cdto.getCombustible(), cdto.getCoche(), cdto.getEmpleado());
		return ent;
	}
}
