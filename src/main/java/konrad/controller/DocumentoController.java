/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.controller;

import java.util.ArrayList;
import konrad.entity.Documento;
import konrad.service.DocumentoService;
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
 * Servicio web que maneja los recursos de Documento
 */
@RestController
@RequestMapping(path = "documento")
public class DocumentoController {

    //Inyeccion de dependencias
    @Autowired
    private DocumentoService documentoServ;

    /**
     * Metodo para crear documentos que recibe un documento en formato JSON.
     * Devuelve el documento en formato JSON o null en caso de que no pueda ser
     * creado
     *
     * @param documento
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Documento create(@RequestBody Documento documento) {
        return documentoServ.create(documento);
    }

    /**
     *
     * Metodo para obtener un documento, recibe por el body el codigo de un
     * documento. Retorna el documento en formato JSON o null en caso de que no
     * se haya encontrado
     *
     * @param codDocumento
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Documento getAreaId(@RequestBody int codDocumento) {
        return documentoServ.getById(codDocumento);
    }

    /**
     *
     * Metodo para obtener todos los documentos. Retorna un ARRAY en formato
     * JSON
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Documento> getAll() {
        return documentoServ.getAll();
    }

    /**
     *
     * Metodo para actualizar un documento. Devuelve el documento actualizado en
     * formato JSON O null en caso de que no se haya logrado actualizar
     *
     * @param documento
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, path = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Documento update(@RequestBody Documento documento) {
        return documentoServ.update(documento);
    }

    /**
     *
     * Metodo para eliminar un documento. Devuelve un boolean, TRUE si se
     * elimino el documento o FALSE si no fue eliminado
     *
     * @param codDocumento
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "del", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@RequestBody int codDocumento) {
        return documentoServ.deleteByID(codDocumento);
    }

}
