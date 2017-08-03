package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.CocheDTO;
import excepciones.DAOExcepcion;

public class CocheDAOImp implements ICocheDAO {

	protected ConnectionManager connManager;

	public CocheDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}

	public CocheDTO buscarCoche(String matricula) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from COCHE where MATRICULA= '"+matricula+"'");
			connManager.close();
		
			if (rs.next())
				return new CocheDTO(
							rs.getString("MATRICULA"),
							rs.getDouble("KMSACTUALES"),
							rs.getInt("SUCURSAL"),
							rs.getString("CATEGORIA"),
							rs.getString("NOMBRE"));
							
			else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}

	
	public List<CocheDTO> obtenerCoches() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from COCHE");						
			connManager.close();
	  	  
			List<CocheDTO> listaCochesDTO = new ArrayList<CocheDTO>();
				
			try{				
				while (rs.next()){

					CocheDTO cocDTO = new CocheDTO(
							rs.getString("MATRICULA"),
							rs.getDouble("KMSACTUALES"),
							rs.getInt("SUCURSAL"),
							rs.getString("CATEGORIA"),
							rs.getString("NOMBRE"));
					listaCochesDTO.add(cocDTO);
				}
				return listaCochesDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}
	
	public List<CocheDTO> obtenerCochesSucursalPorCategoria(int sucursal, String categoria) throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from COCHE where SUCURSAL='"+sucursal+"' AND NOMBRE='"+categoria+"'");						
			connManager.close();
	  	  
			List<CocheDTO> listaCochesDTO = new ArrayList<CocheDTO>();
				
			try{				
				while (rs.next()){

					CocheDTO cocDTO = new CocheDTO(
							rs.getString("MATRICULA"),
							rs.getDouble("KMSACTUALES"),
							rs.getInt("SUCURSAL"),
							rs.getString("CATEGORIA"),
							rs.getString("NOMBRE"));
					listaCochesDTO.add(cocDTO);
				}
				return listaCochesDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}
		
	}
	
	public List<CocheDTO> obtenerCochesSucursal(int sucursal) throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from COCHE where SUCURSAL='"+sucursal+"' AND MATRICULA NOT IN(select COCHEASIGNADO from ENTREGA)");						
			connManager.close();
	  	  
			List<CocheDTO> listaCochesDTO = new ArrayList<CocheDTO>();
				
			try{				
				while (rs.next()){

					CocheDTO cocDTO = new CocheDTO(
							rs.getString("MATRICULA"),
							rs.getDouble("KMSACTUALES"),
							rs.getInt("SUCURSAL"),
							rs.getString("CATEGORIA"),
							rs.getString("NOMBRE"));
					listaCochesDTO.add(cocDTO);
				}
				return listaCochesDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}
	}
}
