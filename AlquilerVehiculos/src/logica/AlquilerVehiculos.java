package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.CategoriaDTO;
import persistencia.dto.ClienteDTO;
import persistencia.dto.CocheDTO;
import persistencia.dto.EmpleadoDTO;
import persistencia.dto.EntregaDTO;
import persistencia.dto.ReservaDTO;
import persistencia.dto.SucursalDTO;

public final class AlquilerVehiculos {
	//Atributos
    private DAL dal;
    
    //Instancia de la clase (Patron Singleton)
    private static AlquilerVehiculos INSTANCIA = new AlquilerVehiculos();
    
    //Constructor privado para impedir la creaci�n de nuevos objetos (Patr�n Singleton)
    private AlquilerVehiculos() {
        //Carga de datos pre-existentes
        this.dal = DAL.obtenerDAL();
        cargaSistema();
    }
    
    // M�todo para obtener la instancia de la clase (Patr�n Singleton)
    public static AlquilerVehiculos obtenerAlquilerVehiculos() {
        return INSTANCIA;
    }
  
    //Atributos relaciones:
    private List<Sucursal> sucursal = new ArrayList<Sucursal>();
    private List<Categoria> categoria = new ArrayList<Categoria>();
    private List<Reserva> reserva = new ArrayList<Reserva>();
    private List<Cliente> cliente = new ArrayList<Cliente>();
    
    //Constructor p�blico para obtener una referencia al objeto DAL
    
    
    //Metodos a�adir/eliminar/consultar:
    public void anyadirSucursal(Sucursal sucursal){
        this.sucursal.add(sucursal);
    }
    public void eliminarSucursal(Sucursal sucursal){
        this.sucursal.remove(sucursal);
    }
    //public Sucursal consultarSucursal(id){}
        
    public void anyadirCategoria(Categoria categoria){
        this.categoria.add(categoria);
    }
    public void eliminarCategoria(Categoria categoria){
        this.categoria.remove(categoria);
    }
    //public Categoria consultarCategoria(id){}
        
    public void anyadirReserva(Reserva reserva){
        this.reserva.add(reserva);
    }
    public void eliminarReserva(Reserva reserva){
        this.reserva.remove(reserva);
    }
    //public Reserva consultarReserva(id){}
        
    public void anyadirCliente(Cliente cliente){
        this.cliente.add(cliente);
    }
    public void eliminarCliente(Cliente cliente){
        this.cliente.remove(cliente);
    }
    //public Cliente consultarCliente(id){}
    
    private void cargaSistema(){
        cargaCategorias();
        cargaClientes();
        cargaReservas();
        cargaSucursales();
    }
    
    private void cargaCategorias() {
        List<CategoriaDTO> listacatDTO = dal.obtenerCategorias();
        // Crear y a�adir todas las categorias a la coleccion
        for (CategoriaDTO catDTO: listacatDTO) {
            anyadirCategoria(new Categoria(catDTO.getNombre(),
                                           catDTO.getPrecioModIlimitada(),
                                           catDTO.getPrecioModKms(),
                                           catDTO.getPrecioKMModKms(),
                                           catDTO.getPrecioSeguroTRiesgo(),
                                           catDTO.getPrecioSeguroTerceros()));
        }
        //Actualizar los enlaces que representan la relacion "superior"
        for (CategoriaDTO catDTO : listacatDTO){
            if (catDTO.getNombreCategoriaSuperior() != null){
                buscarCategoria(catDTO.getNombre()).setCategoriaSuperior(buscarCategoria(catDTO.getNombreCategoriaSuperior()));
            }
        }
    }
    
    private void cargaClientes() {
        List<ClienteDTO> listacliDTO = dal.obtenerClientes();
        // Crear y a�adir todas las categorias a la coleccion
        if(listacliDTO!=null){
	        for (ClienteDTO cliDTO: listacliDTO) {//FALLA ESTE
	            anyadirCliente(new Cliente(cliDTO.getDni(),
	                                           cliDTO.getNombreyApellidos(),
	                                           cliDTO.getDireccion(),
	                                           cliDTO.getPoblacion(),
	                                           cliDTO.getCodPostal(),
	                                           cliDTO.getFechaCanetConducir(),
	                                           cliDTO.getDigitosTC(),
	                                           cliDTO.getMesTC(),
	                                           cliDTO.getAnyoTC(),
	                                           cliDTO.getCvcTC(),
	                                           cliDTO.getTipoTC()));
        }
    }
        /*Actualizar los enlaces que representan la relacion "superior"
        for (CategoriaDTO catDTO : listacliDTO){
            if (catDTO.getNombreCategoriaSuperior() != null){
                buscarCliente(catDTO.getNombre()).setCategoriaSuperior(buscarCategoria(catDTO.getNombreCategoriaSuperior()));
            }
        }*/
    }
    
    private void cargaReservas() {
        List<ReservaDTO> listaresDTO = dal.obtenerReservas();
        // Crear y a�adir todas las categorias a la coleccion
        if(listaresDTO!=null){
        for (ReservaDTO resDTO: listaresDTO) {
            anyadirReserva(new Reserva(resDTO.getId(),
                                           resDTO.getFechaRecogida(),
                                           resDTO.getFechaDevolucion(),
                                           resDTO.getModalidadAlquiler(),
                                           resDTO.getNombreCategoria(),
                                           resDTO.getDniCliente(),
                                           resDTO.getIdSucursalRecogida(),
                                           resDTO.getIdSucursalDevolucion()));
        	}
        }
    }
    
    public Sucursal[] cargaSucursales() {
    	Sucursal[] listaSucursales = new Sucursal[DAL.obtenerDAL().obtenerSucursales().size()];
        List<SucursalDTO> listasucDTO = dal.obtenerSucursales();
        // Crear y a�adir todas las categorias a la coleccion
        int i = 0;
        for (SucursalDTO sucDTO: listasucDTO) {
            anyadirSucursal(new Sucursal(sucDTO.getId(), sucDTO.getDireccion()));
            listaSucursales[i] = new Sucursal(sucDTO.getId(), sucDTO.getDireccion());
            
        }
		return listaSucursales;
        
	}
    
    
    public String ListarReservasSucursal(int id){
        String res="";
        boolean existe = false;
        //Comprobar que la sucursal existe:
        for(int i = 0; existe==false && i<sucursal.size();i++){
            if(sucursal.get(i).getId()==id){
                existe = true;
            }
        }
        if(existe==false){
            System.out.println("La sucursal no existe");
        }
        else{
            //Obtener los datos de reservas de la sucursal dada:
            for(int i = 0; i<reserva.size();i++){
                if(reserva.get(i).getSucursalDevolucion().getId() == id || reserva.get(i).getSucursalRecogida().getId()==id){
                    int id_s = reserva.get(i).getSucursalDevolucion().getId();
                    LocalDateTime fechaRecogida_s = reserva.get(i).getFechaRecogida();
                    String lugarRecogida_s = reserva.get(i).getSucursalRecogida().getDireccion();
                    LocalDateTime fechaDevolucion_s = reserva.get(i).getFechaDevolucion();
                    String lugarDevolucion_s = reserva.get(i).getSucursalDevolucion().getDireccion();
                    String modalidadAlquiler_s = reserva.get(i).getModalidadAlquiler();
                    String nombreCliente_s = reserva.get(i).getCliente().getNombreyApellidos();
                    String categoria_s = reserva.get(i).getCategoria().getNombre();
                    String matricula_s = "2222"+i;
                    double kms_s = Math.random()*1000;
                    
                    res = res +(id_s+", "+fechaRecogida_s+", "+lugarRecogida_s+", "+fechaDevolucion_s+", "+lugarDevolucion_s+", "+modalidadAlquiler_s+", "+nombreCliente_s+", "+categoria_s+", "+matricula_s+", "+Math.rint(kms_s*100)/100+"\n");
                    
                }
            }
            
        }
        return res;
    }
    
    /*Devuelve el identificador de la reserva:
    public int CrearReserva(String identificador){
    	Reserva reservaAux = null;
    	LocalDateTime fechaRecogida;
    	LocalDateTime fechaDevolucion;
    	String modalidadAlquiler;
    	Cliente cliente;
    	Sucursal sucursalRecogida;
    	Sucursal sucursalDevolucion;
    	//Entrega entrega;
    	Categoria categoria;
    	boolean encontrado = false;
    	String sucursalesExistentes = "";
    	String categoriasYPrecios = "";
    	int ide = 0;
    	//2-El sistema busca al cliente:
        if(BuscarCliente(identificador)==null){
            CrearCliente();
        }
        else{
        	cliente = BuscarCliente(identificador);
    	//3-El sistema solicita las fechas de la reserva
    	//4-El cliente proporciona unas fechas de recogida y devoluci�n
        	//Buscar la reserva pre-creada del cliente dado:
        	for(int i=0; i < reserva.size() && encontrado==false;i++){
        		if(reserva.get(i).getCliente().getDni().equals(identificador)){
        			reservaAux = reserva.get(i);
        			encontrado = true;
        		}
        	}
    	fechaRecogida = reservaAux.getFechaRecogida();
    	fechaDevolucion = reservaAux.getFechaDevolucion();
    	//5-El sistema muestra las sucursales existentes y solicita las sucursales de recogida y de devoluci�n
    		for(int i = 0; i < sucursal.size(); i++){
    			sucursalesExistentes.concat(sucursal.get(i).getDireccion()+"\n");
    		}
		//6-El cliente proporciona el identificador de la sucursal de recogida y el de la sucursal de devoluci�n
		sucursalRecogida = reservaAux.getSucursalRecogida();
		sucursalDevolucion = reservaAux.getSucursalDevolucion();
		//7-El sistema muestra las categor�as de veh�culos existentes incluyendo todos los precios de cada categor�a.
			for(int i = 0; i < this.categoria.size(); i++){
				categoriasYPrecios.concat("Nombre: "+this.categoria.get(i).getNombre()+"|precioModIlimitada: "+this.categoria.get(i).getPrecioModIlimitada()+
						"|precioModKms: "+this.categoria.get(i).getPrecioModKms()+"|precioKmModKms: "+this.categoria.get(i).getPrecioKmModKms()+
						"|precioSeguroTRiesgo: "+this.categoria.get(i).getPrecioSeguroTRiesgo()+"|precioSeguroTerceros: "+this.categoria.get(i).getPrecioSeguroTerceros()+"\n");
			}
		//8-El cliente proporciona el identificador de la categor�a que desea
		categoria = reservaAux.getCategoria();
		//7-El cliente proporciona la modalidad de alquiler que desea
		modalidadAlquiler = reservaAux.getModalidadAlquiler();
		//8-El sistema genera un identificador para la reserva, crea la reserva en el sistema de forma adecuada y proporciona al cliente el identificador la misma
		//Se crea otra reserva aparte de la pre-existente:
		
				 
		ide = (int) Math.random()*(0-100)+100;
		Reserva resNueva = new Reserva(ide, fechaRecogida, fechaDevolucion, modalidadAlquiler, cliente, sucursalRecogida, sucursalDevolucion, categoria);
		anyadirReserva(resNueva);

        }
        return ide;
    }*/
    
    //Devuelve Cliente si el cliente existe, null si no existe
    @SuppressWarnings("unused")
	private Cliente BuscarCliente(String identificador){
    	Cliente cli = null;
    	boolean res = false;
    	for(int i = 0; i < cliente.size() && res==false;i++){
    		if(cliente.get(i).getDni().equals(identificador)==true){
    			cli = cliente.get(i);
    			res = true;
    		}
    	}
    	return cli;		
    }
    /*Crea un nuevo cliente que se inscribe
    private void CrearCliente(){
    	//1. El cliente introduce su nombre, direcci�n, poblaci�n, c�digo postal, fecha de caducidad del carnet de conducir y todos los datos de su tarjeta bancaria
    	//Se usa un cliente pre-existente
    	//"12/02/1970"
    	
    	//Cliente cli1 = new Cliente("11111111A","Pepito Grillo","Hispanidad, 13","Aldaia","46960",LocalDate.of(1970,2,12),"12345678",7,2017,123,"Visa");
        //Cliente cli2 = new Cliente("22222222B","David Bisbal","Valencia, 23","Massamagrell","46130",LocalDate.of(1968,7,12),"12348765",10,2024,432,"American Express");
        //2. El sistema genera un identificador para el cliente y almacena toda lai nformaci�n de dicho cliente
        //anyadirCliente(cli1);
        //anyadirCliente(cli2);

    }*/
    
    public Categoria buscarCategoria(String nombre){
		
		for(int i=0;i<categoria.size();i++){
			if(nombre.compareTo(categoria.get(i).getNombre())==0){
				return categoria.get(i);
			}
		}
		return null;
		
	}

	public Sucursal buscarSucursal(int id){
		
		for(int i=0;i<sucursal.size();i++){
			if(id == sucursal.get(i).getId()){
				return sucursal.get(i);
				}
		}
		return null;
		
	}
	
	
	public List<Sucursal> listarSucursales() {
		 
		return this.sucursal;
	}
	
	public void crearCliente(Cliente cliente) {
		 ClienteDTO clienteDTO = new ClienteDTO(cliente.getDni(),
		 cliente.getNombreyApellidos(),
		 cliente.getDireccion(),
		 cliente.getPoblacion(), 
		 cliente.getCodPostal(),
 		 cliente.getFechaCarnetConducir(), 
		 cliente.getDigitosTC(),
		 cliente.getMesTC(), 
		 cliente.getAnyoTC(), 
		 cliente.getCvcTC(),
		 cliente.getTipoTC());
		 // Lo a�ade al a memoria
		 anyadirCliente(cliente);
		 // Y le pide a dal que lo persista
		 dal.crearCliente(clienteDTO);
		}
	
	public ReservaDTO buscarReserva(int idReserva){
		return dal.buscarReserva(idReserva);
	}
	
	public CategoriaDTO obtenerCategoriaSuperiorA(String nombreCategoria){
		return dal.obtenerCategoriaSuperiorA(nombreCategoria);
	}
	
	public CategoriaDTO buscarCategoriaDTO(String nombreCategoria){
		return dal.buscarCategoriaDTO(nombreCategoria);
	}
	
	public ClienteDTO buscarClienteDTO(String dni){
		return dal.buscarClienteDTO(dni);
	}
	
	public void crearReserva(Reserva reserva){
		ReservaDTO reservaDTO = new ReservaDTO(reserva.getId(),
				reserva.getFechaRecogida(),
				reserva.getFechaDevolucion(),
				reserva.getModalidadAlquiler(),
				reserva.getDniCliente(),
				reserva.getNombreCategoria(),
				reserva.getIdSucursalRecogida(),
				reserva.getIdSucursalDevolucion());
		// Lo a�ade al a memoria
		anyadirReserva(reserva);
		//Y le pide a dal que lo persista
		dal.crearReserva(reservaDTO);
	}
	
	
	public boolean ComprobarCategoria(String categoria){
		boolean res = false;
		for(int i = 0; i < this.categoria.size(); i++){
			if(this.categoria.get(i).getNombre().equals(categoria)){
				res = true;
			}
		}
		return res;
	}
	
	public boolean ComprobarCliente(String dni){
		boolean res = false;
		for(int i = 0; i < this.cliente.size(); i++){
			System.out.println(i);
			System.out.println(this.cliente.get(i).getDni());
			System.out.println(dni);
			if(this.cliente.get(i).getDni().equals(dni)){
				
				res = true;
			}
		}
		return res;
	}
	
	public boolean ComprobarSucursal(int sucursal){
		boolean res = false;
		for(int i = 0; i < this.sucursal.size(); i++){
			if(this.sucursal.get(i).getId()==sucursal){
				res = true;
			}
		}
		return res;
	}

	public void crearEntrega(EntregaDTO entrega) {
		dal.crearEntrega(entrega);
		
	}

	public CocheDTO buscarCoche(String matricula) {
		return dal.buscarCoche(matricula);
	}

	public EmpleadoDTO buscarEmpleado(String dni) {
		return dal.buscarEmpleado(dni);
	}
}
