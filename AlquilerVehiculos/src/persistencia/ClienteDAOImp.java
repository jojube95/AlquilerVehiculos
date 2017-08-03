package persistencia;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.ClienteDTO;
import excepciones.DAOExcepcion;

public class ClienteDAOImp implements IClienteDAO {

	protected ConnectionManager connManager;

	public ClienteDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}
    
    public void crearCliente(ClienteDTO cliDTO) throws DAOExcepcion {
        
    	try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = cliDTO.getFechaCanetConducir();
            String formattedDateTime=dateTime.format(formatter);
            connManager.connect();
            String str = "insert into CLIENTE (DNI, NOMBREAPELLIDOS, DIRECCION, POBLACION, CODPOSTAL, "
                            + "FECHACARNETCONDUCIR, DIGITOSTC, MESTC, \"a�oTC\", CVCTC, TIPOTC) values ('"+cliDTO.getDni()+"','"+cliDTO.getNombreyApellidos()+"','"
                            +cliDTO.getDireccion()+"', '"+cliDTO.getPoblacion()+"','"+cliDTO.getCodPostal()+"','"
                            +formattedDateTime+"','"+cliDTO.getDigitosTC()+"',"+cliDTO.getMesTC()+","+cliDTO.getAnyoTC()+","
                            +cliDTO.getCvcTC()+",'"+cliDTO.getTipoTC()+"')";
            connManager.updateDB(str);
            connManager.close();
    }
    catch (Exception e){        throw new DAOExcepcion(e);}
}
    
    
       
	public ClienteDTO buscarCliente(String dni) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CLIENTE where DNI= '"+dni+"'");
			connManager.close();
		
			if (rs.next())
				return new ClienteDTO(
							rs.getString("DNI"),
                            rs.getString("NOMBREAPELLIDOS"),
                            rs.getString("DIRECCION"),
                            rs.getString("POBLACION"),
                            rs.getString("CODPOSTAL"),
                            LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(), rs.getTime("FECHACARNETCONDUCIR").toLocalTime()),
                            rs.getString("DIGITOSTC"),
                            rs.getInt("MESTC"),
                            rs.getInt("AÑOTC"),
                            rs.getInt("CVCTC"),
                            rs.getString("TIPOTC"));


			else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}

	
	public List<ClienteDTO> obtenerClientes() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from CLIENTE");
			connManager.close();
	  	  
			List<ClienteDTO> listaClienteDTO = new ArrayList<ClienteDTO>();
				
			try{				
				while (rs.next()){

					ClienteDTO cliDTO = new ClienteDTO(
                            rs.getString("DNI"),
                            rs.getString("NOMBREAPELLIDOS"),
                            rs.getString("DIRECCION"),
                            rs.getString("POBLACION"),
                            rs.getString("CODPOSTAL"),
                            LocalDateTime.of(rs.getDate("FECHACARNETCONDUCIR").toLocalDate(), rs.getTime("FECHACARNETCONDUCIR").toLocalTime()),
                            rs.getString("DIGITOSTC"),
                            rs.getInt("MESTC"),
                            rs.getInt("añoTC"),
                            rs.getInt("CVCTC"),
                            rs.getString("TIPOTC"));
					listaClienteDTO.add(cliDTO);
				}
				return listaClienteDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}

}
