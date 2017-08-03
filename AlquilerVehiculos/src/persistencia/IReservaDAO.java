//IReservaDAO
package persistencia;

import java.util.List;

import persistencia.dto.ReservaDTO;
import persistencia.dto.ReservaYClienteDTO;
import excepciones.*;

public interface IReservaDAO {
 public ReservaDTO buscarReserva(int identificador)throws DAOExcepcion;

 public List <ReservaDTO> obtenerReservasPorSucursalOrigen(int idSucursal) throws DAOExcepcion;
 
 public void crearReserva(ReservaDTO reserva) throws DAOExcepcion;
 
 public List<ReservaDTO> obtenerReservas() throws DAOExcepcion;
 
 public List<ReservaDTO> obtenerReservasPorEntregar() throws DAOExcepcion;
 
 public List<ReservaYClienteDTO> obtenerReservasYCliente() throws DAOExcepcion;
}
