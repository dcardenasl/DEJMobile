/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.Local;
import pojos.Minutos;

/**
 *
 * @author Centro de Trabajo
 */
@Local
public interface MinutosFacadeLocal {

    void create(Minutos minutos);

    void edit(Minutos minutos);

    void remove(Minutos minutos);

    Minutos find(Object id);

    List<Minutos> findAll();

    List<Minutos> findRange(int[] range);

    int count();
    
}
