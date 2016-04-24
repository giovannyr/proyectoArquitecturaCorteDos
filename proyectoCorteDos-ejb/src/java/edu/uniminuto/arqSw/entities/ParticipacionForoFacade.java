/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniminuto.arqSw.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Itech
 */
@Stateless
public class ParticipacionForoFacade extends AbstractFacade<ParticipacionForo> {
    @PersistenceContext(unitName = "proyectoCorteDos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParticipacionForoFacade() {
        super(ParticipacionForo.class);
    }
    
}
