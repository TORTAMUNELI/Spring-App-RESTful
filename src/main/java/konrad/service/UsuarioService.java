/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.service;

import java.util.ArrayList;
import java.util.Optional;
import konrad.entity.Usuario;
import konrad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Konrad
 *
 * "Logica de negocio"
 */
@Service
public class UsuarioService implements Implementation<Usuario> {

    //Inyeccion de dependencias para el uso del CRUD
    @Autowired
    private UsuarioRepository usuarioRepo;

    /**
     * Metodo para crear usuarios
     *
     * @param usuario
     * @return
     */
    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    /**
     * Metodo para obtener un usuario por medio del codigo del usuari
     *
     * @param codUsuario
     * @return
     */
    @Override
    public Usuario getById(int codUsuario) {
        try {
            return usuarioRepo.findById(codUsuario).get();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Metodo para obtener todas los usuarios registradas en la base de dato
     *
     * @return s
     */
    @Override
    public ArrayList<Usuario> getAll() {
        return (ArrayList<Usuario>) usuarioRepo.findAll();
    }

    /**
     * Metodo para actualizar un usuario Actualizar un usuario requiere todos
     * los atributos de Usuari
     *
     * @param usuario
     * @return
     */
    @Override
    public Usuario update(Usuario usuario) {
        Optional<Usuario> usuarioS = usuarioRepo.findById(usuario.getCodUsuario());
        if (usuarioS.isPresent()) {
            return usuarioRepo.save(usuario);
        }
        return null;
    }

    /**
     * Metodo para eliminar un usuario //Busca el usuario con el cod recibido y
     * lo elimin
     *
     * @param codUsuario
     * @return
     */
    @Override
    public boolean deleteByID(int codUsuario) {
        Optional<Usuario> usuarioS = usuarioRepo.findById(codUsuario);
        if (usuarioS.isPresent()) {
            usuarioRepo.deleteById(codUsuario);
            return true;
        }
        return false;
    }
}
