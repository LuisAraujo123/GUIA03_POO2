/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.sql.Date;

/**
 *
 * @author bernardo
 */
public class TipoPers {
    private int codiTipoPers;
    private String nombTipoPers;
    private Date fechAlta;
    private Date fechBaja;
    private int esta;

    public TipoPers() {
    }

    public TipoPers(int codiTipoPers, String nombTipoPers, Date fechAlta, Date fechBaja, int esta) {
        this.codiTipoPers = codiTipoPers;
        this.nombTipoPers = nombTipoPers;
        this.fechAlta = fechAlta;
        this.fechBaja = fechBaja;
        this.esta = esta;
    }

    public int getCodiTipoPers() {
        return codiTipoPers;
    }

    public void setCodiTipoPers(int codiTipoPers) {
        this.codiTipoPers = codiTipoPers;
    }

    public String getNombTipoPers() {
        return nombTipoPers;
    }

    public void setNombTipoPers(String nombTipoPers) {
        this.nombTipoPers = nombTipoPers;
    }

    public Date getFechAlta() {
        return fechAlta;
    }

    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }

    public Date getFechBaja() {
        return fechBaja;
    }

    public void setFechBaja(Date fechBaja) {
        this.fechBaja = fechBaja;
    }

    public int getEsta() {
        return esta;
    }

    public void setEsta(int esta) {
        this.esta = esta;
    }

    @Override
    public String toString() {
        return this.nombTipoPers;
    }
    
    
    
}
