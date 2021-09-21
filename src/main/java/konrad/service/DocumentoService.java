/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.service;

import java.util.ArrayList;
import java.util.Optional;
import konrad.entity.Documento;
import konrad.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Konrad
 *
 * "Logica de negocio"
 */
@Service
public class DocumentoService implements Implementation<Documento> {

    //Inyeccion de dependencias para el uso del CRUD
    @Autowired
    private DocumentoRepository documentoRepo;
    @Autowired
    private MailService mailService;
    @Autowired
    private UsuarioService usuarioServ;
    @Autowired
    private AsuntoService asuntoServ;

    private void enviarEmail(Documento documento) {
        int codDestinatario = documento.getCodDestinatario().getCodUsuario();
        int codAsunto = documento.getCodAsunto().getCodAsunto();
        String correoDestinatario = usuarioServ.getById(codDestinatario).getCorreo();
        String asunto = asuntoServ.getById(codAsunto).getTitulo();
        mailService.sendMail("konradMensajes@gmail.com", correoDestinatario, asunto, "Tienes nuevos documentos pendientes.");
    }

    /**
     * Metodo para crear documento
     *
     * @param documento
     * @return
     */
    @Override
    public Documento create(Documento documento) {
        Documento dc = documentoRepo.save(documento);
        enviarEmail(documento);
        return dc;
    }

    /**
     * Metodo para obtener un documento por medio del codigo del document
     *
     * @param codDocumento
     * @return
     */
    @Override
    public Documento getById(int codDocumento) {
        try {
            return documentoRepo.findById(codDocumento).get();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Metodo para obtener todas los documentos registradas en la base de dato
     *
     * @return s
     */
    @Override
    public ArrayList<Documento> getAll() {
        return (ArrayList<Documento>) documentoRepo.findAll();
    }

    /**
     * Metodo para actualizar un document
     *
     * @param documento
     * @return
     */
    @Override
    public Documento update(Documento documento) {
        Optional<Documento> documentoS = documentoRepo.findById(documento.getCodDocumento());

        if (documentoS.isPresent()) {
            return documentoRepo.save(documento);
        }
        return null;
    }

    /**
     * Metodo para eliminar un documento Busca el documento con el cod recibido
     * y lo elimin
     *
     * @param codDocumento
     * @return
     */
    @Override
    public boolean deleteByID(int codDocumento) {
        Optional<Documento> documentoS = documentoRepo.findById(codDocumento);

        if (documentoS.isPresent()) {
            documentoRepo.deleteById(codDocumento);
            return true;
        }
        return false;
    }
}
