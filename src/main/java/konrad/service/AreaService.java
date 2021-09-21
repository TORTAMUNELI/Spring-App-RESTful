/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.service;

import java.util.ArrayList;
import java.util.Optional;
import konrad.entity.Area;
import konrad.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Konrad
 *
 * "Logica de negocio"
 */
@Service
public class AreaService implements Implementation<Area> {

    //Inyeccion de dependencias para el uso del CRUD
    @Autowired
    private AreaRepository areaRepo;

    /**
     * Metodo para crear areas
     *
     * @param area
     * @return
     */
    @Override
    public Area create(Area area) {
        return areaRepo.save(area);
    }

    /**
     * Metodo para obtener un area por medio del codigo del area
     *
     * @param codArea
     * @return
     */
    @Override
    public Area getById(int codArea) {
        try {
            return areaRepo.findById(codArea).get();
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Metodo para obtener todas las areas registradas en la base de datos
     *
     * @return
     */
    @Override
    public ArrayList<Area> getAll() {
        return (ArrayList<Area>) areaRepo.findAll();
    }

    /**
     * Metodo para actualizar un area Actualizar un area requiere todos los
     * atributos de Area
     *
     * @param area
     * @return
     */
    @Override
    public Area update(Area area) {
        Optional<Area> areaS = areaRepo.findById(area.getCodArea());

        if (areaS.isPresent()) {
            return areaRepo.save(area);
        }
        return null;
    }

    /**
     * Metodo para eliminar un area Busca el area con el cod recibido y la
     * elimina
     *
     * @param codArea
     * @return
     */
    @Override
    public boolean deleteByID(int codArea) {
        Optional<Area> areaS = areaRepo.findById(codArea);

        if (areaS.isPresent()) {
            areaRepo.deleteById(codArea);
            return true;
        }
        return false;
    }

}
