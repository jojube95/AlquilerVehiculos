package persistencia;

import java.util.List;

import persistencia.dto.CocheDTO;
import excepciones.*;

public interface ICocheDAO {
	
	public CocheDTO buscarCoche(String matricula)throws DAOExcepcion;

	public List<CocheDTO> obtenerCoches() throws DAOExcepcion;
	
	public List<CocheDTO> obtenerCochesSucursalPorCategoria(int sucursal, String categoria) throws DAOExcepcion;
	
	public List<CocheDTO> obtenerCochesSucursal(int sucursal) throws DAOExcepcion;
	
}
