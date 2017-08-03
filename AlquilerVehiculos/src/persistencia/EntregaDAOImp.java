package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.EntregaDTO;
import excepciones.DAOExcepcion;



public class EntregaDAOImp implements IEntregaDAO{
	
	protected ConnectionManager connManager;
	
	public EntregaDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}
	
	public List<EntregaDTO> obtenerEntregas() throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet ent=connManager.queryDB("select * from ENTREGA");
			connManager.close();
	  	  
			List<EntregaDTO> listaEntregaDTO = new ArrayList<EntregaDTO>();
				
			try{				
				while (ent.next()){

					EntregaDTO entDTO = new EntregaDTO(
                            ent.getInt("ID"),
                            LocalDateTime.of(ent.getDate("FECHA").toLocalDate(), ent.getTime("FECHA").toLocalTime()),
                            ent.getString("TIPOSEGURO"),
                            ent.getDouble("KMS"),
                            ent.getDouble("COMBUSTIBLE"),
                            ent.getString("COCHEASIGNADO"),
                            ent.getString("EMPLEADOREALIZA"));
					listaEntregaDTO.add(entDTO);
				}
				return listaEntregaDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}
		
	}
	
	public void crearEntrega(EntregaDTO entDTO) throws DAOExcepcion{
	       
    	try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = entDTO.getFecha();
            String fecha =dateTime.format(formatter);
            connManager.connect();
            String str = "insert into ENTREGA (ID, FECHA, TIPOSEGURO, KMS, COMBUSTIBLE, "
                    + "COCHEASIGNADO, EMPLEADOREALIZA) values ('"+entDTO.getId()+"','"+fecha+"','"
                    +entDTO.getTipoSeguro()+"', '"+entDTO.getKms()+"','"+entDTO.getCombustible()+"','"
                    +entDTO.getCoche()+"','"+entDTO.getEmpleado()+"')";
            connManager.updateDB(str);
            connManager.close();
	    }
	    catch (Exception e){        throw new DAOExcepcion(e);}
	}
		
	

}
