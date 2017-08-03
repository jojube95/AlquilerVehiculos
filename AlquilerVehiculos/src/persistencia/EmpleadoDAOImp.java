package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.EmpleadoDTO;
import excepciones.DAOExcepcion;

public class EmpleadoDAOImp implements IEmpleadoDAO{
	
	protected ConnectionManager connManager;
	
	public EmpleadoDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}
	
	public EmpleadoDTO buscarEmpleado(String dni)throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from EMPLEADO where DNI= '"+dni+"'");
			connManager.close();
		
			if (rs.next())
				return new EmpleadoDTO(
							rs.getString("DNI"),
                            rs.getString("NOMBRE"),
                            rs.getBoolean("ADMINISTRADOR"),
                            rs.getInt("SUCURSAL"));


			else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		
	}
	
	public List<EmpleadoDTO> obtenerEmpleado() throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from EMPLEADO");
			connManager.close();
	  	  
			List<EmpleadoDTO> listaEmpleadoDTO = new ArrayList<EmpleadoDTO>();
				
			try{				
				while (rs.next()){

					EmpleadoDTO empDTO = new EmpleadoDTO(
							rs.getString("DNI"),
                            rs.getString("NOMBRE"),
                            rs.getBoolean("ADMINISTRADOR"),
                            rs.getInt("SUCURSAL"));
					listaEmpleadoDTO.add(empDTO);
				}
				return listaEmpleadoDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

		
	}

}
