package persistencia;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.ReservaDTO;
import persistencia.dto.ReservaYClienteDTO;
import excepciones.DAOExcepcion;

public class ReservaDAOImp implements IReservaDAO {

	protected ConnectionManager connManager;

	public ReservaDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}

	public ReservaDTO buscarReserva(int id) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA where ID= '"+id+"'");
			connManager.close();
			
			if (rs.next())
				return new ReservaDTO(
							rs.getInt("ID"),
							LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(), rs.getTime("FECHARECOGIDA").toLocalTime()),
                            LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),rs.getTime("FECHADEVOLUCION").toLocalTime()),
                            rs.getString("MODALIDADALQUILER"),
                            rs.getString("CLIENTEREALIZA"),
                            rs.getString("CATEGORIA"),
                            rs.getInt("SUCURSALRECOGIDA"),
                            rs.getInt("SUCURSALDEVOLUCION"));
			else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}

	
	public List<ReservaDTO> obtenerReservasPorSucursalOrigen(int idSucursal) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA where SUCURSALRECOGIDA='"+idSucursal+"'");
			connManager.close();
	  	  
			List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();
				
			try{				
				while (rs.next()){

					ReservaDTO resDTO = new ReservaDTO(
                            rs.getInt("ID"),
                            LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(), rs.getTime("FECHARECOGIDA").toLocalTime()),
                            LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(),rs.getTime("FECHADEVOLUCION").toLocalTime()),
                            rs.getString("MODALIDADALQUILER"),
                            rs.getString("CATEGORIA"),
                            rs.getString("CLIENTEREALIZA"),
                            rs.getInt("SUCURSALRECOGIDA"),
                            rs.getInt("SUCURSALRDEVOLUCION"));
					listaReservaDTO.add(resDTO);
				}
				return listaReservaDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}
                                                       
    public void crearReserva(ReservaDTO resDTO) throws DAOExcepcion{
            	
    	 try{
    		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
             LocalDateTime dateTime1 = resDTO.getFechaRecogida();
             LocalDateTime dateTime2 = resDTO.getFechaDevolucion();
             String fechaRecogida=dateTime1.format(formatter);
             String fechaDevolucion=dateTime2.format(formatter);
             
             connManager.connect();
             connManager.updateDB("insert into RESERVA (ID, FECHARECOGIDA, FECHADEVOLUCION, MODALIDADALQUILER, CATEGORIA, "
                             + "CLIENTEREALIZA, SUCURSALRECOGIDA, SUCURSALDEVOLUCION) values ("+resDTO.getId()+",'"+fechaRecogida+"','"
                             +fechaDevolucion+"', '"+resDTO.getModalidadAlquiler()+"','"+resDTO.getNombreCategoria()+"','"
                             +resDTO.getDniCliente()+"',"+resDTO.getIdSucursalRecogida()+","+resDTO.getIdSucursalDevolucion()+")");
             connManager.close();
     }
     catch (Exception e){        throw new DAOExcepcion(e);}
}
    
    public List<ReservaDTO> obtenerReservas() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA");
			connManager.close();
	  	  
			List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();
				
			try{				
				while (rs.next()){

					ReservaDTO resDTO = new ReservaDTO(
                            rs.getInt("ID"),
                            LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(), rs.getTime("FECHARECOGIDA").toLocalTime()),
                            LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(), rs.getTime("FECHADEVOLUCION").toLocalTime()),
                            rs.getString("MODALIDADALQUILER"),
                            rs.getString("CATEGORIA"),
                            rs.getString("CLIENTEREALIZA"),
                            rs.getInt("SUCURSALRECOGIDA"),
                            rs.getInt("SUCURSALDEVOLUCION"));
					listaReservaDTO.add(resDTO);
				}
				return listaReservaDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}
    
    public List<ReservaDTO> obtenerReservasPorEntregar() throws DAOExcepcion{
    	try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from RESERVA where id IN(select id from ENTREGA)");
			connManager.close();
	  	  
			List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();
				
			try{				
				while (rs.next()){

					ReservaDTO resDTO = new ReservaDTO(
                            rs.getInt("ID"),
                            LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(), rs.getTime("FECHARECOGIDA").toLocalTime()),
                            LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(), rs.getTime("FECHADEVOLUCION").toLocalTime()),
                            rs.getString("MODALIDADALQUILER"),
                            rs.getString("CATEGORIA"),
                            rs.getString("CLIENTEREALIZA"),
                            rs.getInt("SUCURSALRECOGIDA"),
                            rs.getInt("SUCURSALDEVOLUCION"));
					listaReservaDTO.add(resDTO);
				}
				return listaReservaDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

    	
    }
    
    public List<ReservaYClienteDTO> obtenerReservasYCliente() throws DAOExcepcion{
    	try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select R.ID, R.FECHARECOGIDA, R.FECHADEVOLUCION, R.CATEGORIA, R.MODALIDADALQUILER, R.SUCURSALRECOGIDA, R.SUCURSALDEVOLUCION, C.DNI, C.NOMBREAPELLIDOS from RESERVA R, CLIENTE C where R.CLIENTEREALIZA=C.DNI AND R.ID NOT IN(select ID from ENTREGA)");
			connManager.close();
	  	  
			List<ReservaYClienteDTO> listaReservaYClienteDTO = new ArrayList<ReservaYClienteDTO>();
				
			try{				
				while (rs.next()){

					ReservaYClienteDTO resDTO = new ReservaYClienteDTO(
                            rs.getInt("ID"),
                            LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(), rs.getTime("FECHARECOGIDA").toLocalTime()),
                            LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(), rs.getTime("FECHADEVOLUCION").toLocalTime()),
                            rs.getString("CATEGORIA"),
                            rs.getString("MODALIDADALQUILER"),
                            rs.getString("DNI"),
                            rs.getString("NOMBREAPELLIDOS"),
                            rs.getInt("SUCURSALRECOGIDA"),
                            rs.getInt("SUCURSALDEVOLUCION"));
                        listaReservaYClienteDTO.add(resDTO);
				}
				return listaReservaYClienteDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

    	
    }
}
