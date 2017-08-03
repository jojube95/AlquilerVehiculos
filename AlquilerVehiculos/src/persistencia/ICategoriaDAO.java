//ICategoriaDAO
package persistencia;

import java.util.List;

import persistencia.dto.CategoriaDTO;
import excepciones.*;

public interface ICategoriaDAO {
 public CategoriaDTO buscarCategoria(String nombre)throws DAOExcepcion;

 public List<CategoriaDTO> obtenerCategorias() throws DAOExcepcion;
 
 public CategoriaDTO obtenerCategoriaSuperiorA(String nombreCategoria) throws DAOExcepcion;
 
 public CategoriaDTO buscarCategoriaDTO(String nombreCategoria) throws DAOExcepcion;
}
