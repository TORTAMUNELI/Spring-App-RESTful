/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.service;

import java.util.ArrayList;

/**
 *
 * @author Konrad
 *
 * Implementacion que se debe usar para todos los services
 *
 * @param <T>
 */
public interface Implementation<T> {

    public T create(T param);

    public T getById(int param);

    public ArrayList<T> getAll();

    public T update(T param);

    public boolean deleteByID(int param);
}
