//ISucursalDAO
package persistencia;

import java.util.List;

import persistencia.dto.ReservaDTO;
import persistencia.dto.SucursalDTO;
import excepciones.*;

public interface ISucursalDAO {
 public List <SucursalDTO> obtenerSucursales() throws DAOExcepcion;
 public SucursalDTO buscarSucursal(int id) throws DAOExcepcion;
 public List<ReservaDTO> obtenerReservasSucursal(int idSuc) throws DAOExcepcion;
}
