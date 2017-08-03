package persistencia;

import java.util.List;
import persistencia.dto.EmpleadoDTO;
import excepciones.DAOExcepcion;

public interface IEmpleadoDAO {
	public EmpleadoDTO buscarEmpleado(String dni)throws DAOExcepcion;
	
	public List<EmpleadoDTO> obtenerEmpleado() throws DAOExcepcion;
}
