/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.service;

import java.util.ArrayList;
import java.util.Optional;
import konrad.entity.Asunto;
import konrad.repository.AsuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Konrad
 *
 * "Logica de negocio"
 */
@Service
public class AsuntoService implements Implementation<Asunto> {

    //Inyeccion de dependencias para el uso del CRUD
    @Autowired
    private AsuntoRepository asuntoRepo;

    /**
     * Metodo para crear asunto
     *
     * @param asunto
     * @return
     */
    @Override
    public Asunto create(Asunto asunto) {
        return asuntoRepo.save(asunto);
    }

    /**
     * Metodo para obtener un asunto por medio del codigo del asunt
     *
     * @param codAsunto
     * @return
     */
    @Override
    public Asunto getById(int codAsunto) {
        try {
            return asuntoRepo.findById(codAsunto).get();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Metodo para obtener todas los asuntos registradas en la base de dato
     *
     * @return s
     */
    @Override
    public ArrayList<Asunto> getAll() {
        return (ArrayList<Asunto>) asuntoRepo.findAll();
    }

    /**
     * Metodo para actualizar un asunto Actualizar un asunto requiere todos los
     * atributos de Asunt
     *
     * @param asunto
     * @return
     */
    @Override
    public Asunto update(Asunto asunto) {
        Optional<Asunto> asuntoS = asuntoRepo.findById(asunto.getCodAsunto());
        if (asuntoS.isPresent()) {
            return asuntoRepo.save(asunto);
        }
        return null;
    }

    /**
     * Metodo para eliminar un asunto Busca el asunto con el cod recibido y lo
     * elimina
     *
     * @param codAsunto
     * @return
     */
    @Override
    public boolean deleteByID(int codAsunto) {
        Optional<Asunto> asuntoS = asuntoRepo.findById(codAsunto);
        if (asuntoS.isPresent()) {
            asuntoRepo.deleteById(codAsunto);
            return true;
        }
        return false;
    }
}
