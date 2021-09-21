/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.controller;

import java.util.ArrayList;
import konrad.entity.Area;
import konrad.service.AreaService;
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
 * Servicio web que maneja los recursos de Area
 */
@RestController
@RequestMapping(path = "area")
public class AreaController {

    //Inyeccion de dependencias
    @Autowired
    private AreaService areaServ;

    /**
     * Metodo para crear areas que recibe un area por medio del body en formato
     * JSON. Devuelve un area en formato JSON o null en caso de que no se haya
     * podido crear el usuario
     *
     * @param area
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Area create(@RequestBody Area area) {
        return areaServ.create(area);
    }

    /**
     *
     * Metodo para obtener un area, recibe por el body el codigo de un area.
     * Retorna el area en formato JSON o null en caso de que no se haya
     * encontrado
     *
     * @param codArea
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Area getAreaId(@RequestBody int codArea) {
        return areaServ.getById(codArea);
    }

    /**
     *
     * Metodo para obtener todas las area. Retorna un ARRAY en formato JSON
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Area> getAll() {
        return areaServ.getAll();
    }

    /**
     * Metodo para actualizar un area. Devuelve el area actualizada en formato
     * JSON O null en caso de que no se haya logrado actualizar
     *
     * @param area
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, path = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Area update(@RequestBody Area area) {
        return areaServ.update(area);
    }

    /**
     * Metodo para eliminar un area. Devuelve un boolean, TRUE si se elimino el
     * usuario o FALSE si no fue eliminado
     *
     * @param codArea
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "del", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@RequestBody int codArea) {
        return areaServ.deleteByID(codArea);
    }

}
