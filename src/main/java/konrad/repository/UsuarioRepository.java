/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.repository;

import konrad.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Konrad
 *
 * Interface de la que se extraen los metodos para el DAO
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
