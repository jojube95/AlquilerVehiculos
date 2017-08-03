package persistencia;

import java.util.List;

import persistencia.dto.EntregaDTO;
import excepciones.DAOExcepcion;

public interface IEntregaDAO {
	
	public List<EntregaDTO> obtenerEntregas() throws DAOExcepcion;
	
	public void crearEntrega(EntregaDTO entDTO) throws DAOExcepcion;

}
