/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.controller;

import java.util.ArrayList;
import konrad.entity.Usuario;
import konrad.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Konrad
 *
 * Servicio web que maneja los recursos de Usuario
 */
@RestController
@RequestMapping(path = "usuario")
public class UsuarioController {

    //Inyeccion de dependencias
    @Autowired
    private UsuarioService usuarioServ;

    /**
     *
     * Metodo para crear usuarios que recibe un usuario por medio del body en
     * formato JSON. Devuelve un usuario en formato JSON o null en caso de que
     * no se haya podido crear el usuario
     *
     * @param usuario
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioServ.create(usuario);
    }

    /**
     *
     * Metodo para obtener un usario, recibe por el body el codigo de un
     * usuario. Retorna el usuario en formato JSON o null en caso de que no se
     * haya encontrado
     *
     * @param codUsuario
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario getAreaId(@RequestBody int codUsuario) {
        return usuarioServ.getById(codUsuario);
    }

    /**
     *
     * Metodo para obtener todos los usuarios. Retorna un ARRAY en formato JSON
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Usuario> getAll() {
        return usuarioServ.getAll();
    }

    /**
     *
     * Metodo para actualizar un usuario. Devuelve el usuario actualizado en
     * formato JSON O null en caso de que no se haya logrado actualizar
     *
     * @param usuario
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, path = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario update(@RequestBody Usuario usuario) {
        return usuarioServ.update(usuario);
    }

    /**
     *
     * Metodo para eliminar un usuario. Devuelve un boolean, TRUE si se elimino
     * el usuario o FALSE si no fue eliminado
     *
     * @param codUsuario
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "del", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@RequestBody int codUsuario) {
        return usuarioServ.deleteByID(codUsuario);
    }

}
