/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.controller;

import java.util.ArrayList;
import konrad.entity.Asunto;
import konrad.service.AsuntoService;
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
 * Servicio web que maneja los recursos de Asunto
 */
@RestController
@RequestMapping(path = "asunto")
public class AsuntoController {

    //Inyeccion de dependencias
    @Autowired
    private AsuntoService asuntoServ;

    /**
     *
     * Metodo para crear asuntos que recibe un asunto por medio del body en
     * formato JSON. Devuelve un asunto en formato JSON o null en caso de que no
     * se haya podido crear el asunto
     *
     * @param asunto
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Asunto create(@RequestBody Asunto asunto) {
        return asuntoServ.create(asunto);
    }

    /**
     *
     * Metodo para obtener un asuntos, recibe por el body el codigo de un
     * asunto. Retorna el asunto en formato JSON o null en caso de que no se
     * haya encontrado
     *
     * @param codAsunto
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Asunto getAreaId(@RequestBody int codAsunto) {
        return asuntoServ.getById(codAsunto);
    }

    /**
     *
     * Metodo para obtener todos los asuntos. Retorna un ARRAY en formato JSON
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Asunto> getAll() {
        return asuntoServ.getAll();
    }

    /**
     *
     * Metodo para actualizar un asunto. Devuelve el asunto actualizado en
     * formato JSON O null en caso de que no se haya logrado actualizar
     *
     * @param asunto
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, path = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Asunto update(@RequestBody Asunto asunto) {
        return asuntoServ.update(asunto);
    }

    /**
     * Metodo para eliminar un asunto. Devuelve un boolean, TRUE si se elimino
     * el usuario o FALSE si no fue eliminado
     *
     * @param codAsunto
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "del", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@RequestBody int codAsunto) {
        return asuntoServ.deleteByID(codAsunto);
    }

}
