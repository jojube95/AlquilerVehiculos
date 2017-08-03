package persistencia;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.ReservaDTO;
import persistencia.dto.SucursalDTO;
import excepciones.DAOExcepcion;

public class SucursalDAOImp implements ISucursalDAO {

	protected ConnectionManager connManager;

	public SucursalDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}

	public SucursalDTO buscarSucursal(int id) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from SUCURSAL where ID= '"+id+"'");
			connManager.close();
		
			if (rs.next())
				return new SucursalDTO(
							rs.getInt("ID"),
                            rs.getString("DIRECCION"));
			else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}

	
	public List<SucursalDTO> obtenerSucursales() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from SUCURSAL");
			connManager.close();
	  	  
			List<SucursalDTO> listaSucursalDTO = new ArrayList<SucursalDTO>();
				
			try{				
				while (rs.next()){

					SucursalDTO sucDTO = new SucursalDTO(
                            rs.getInt("ID"),
                            rs.getString("DIRECCION"));
					listaSucursalDTO.add(sucDTO);
				}
				return listaSucursalDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}
	
	public List<ReservaDTO> obtenerReservasSucursal(int idSuc) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from SUCURSAL, RESERVA where ID= '"+idSuc+"' AND SUCURSAL.ID=RESERVA.SUCURSALDEVOLUCION");
			connManager.close();
	  	  
			List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();
				
			try{				
				while (rs.next()){

					ReservaDTO resDTO = new ReservaDTO(
                            rs.getInt("RESERVA.ID"),
                            LocalDateTime.of(rs.getDate("FECHARECOGIDA").toLocalDate(), rs.getTime("FECHARECOGIDA").toLocalTime()),
                            LocalDateTime.of(rs.getDate("FECHADEVOLUCION").toLocalDate(), rs.getTime("FECHADEVOLUCION").toLocalTime()),
                            rs.getString("MODALIDADALQUILER"),
                            rs.getString("CATEGORIA"),
                            rs.getString("CLIENTEREALIZA"),
                            Integer.parseInt(rs.getString("SUCURSALRECOGIDA")),
                            Integer.parseInt(rs.getString("SUCURSALDEVOLUCION")));
					listaReservaDTO.add(resDTO);
				}
				return listaReservaDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}

}
