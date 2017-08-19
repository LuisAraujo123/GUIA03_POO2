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
public class UbicGeog {
    private int codiUbicGeog;
    private String nombUbicGeog;
    private int codiUbicGeogSupe;
    private Date fechAlta;
    private Date fechBaja;
    private int esta;

    public UbicGeog() {
    }

    public UbicGeog(int codiUbicGeog, String nombUbicGeog, int codiUbicGeogSupe, Date fechAlta, Date fechBaja, int esta) {
        this.codiUbicGeog = codiUbicGeog;
        this.nombUbicGeog = nombUbicGeog;
        this.codiUbicGeogSupe = codiUbicGeogSupe;
        this.fechAlta = fechAlta;
        this.fechBaja = fechBaja;
        this.esta = esta;
    }

    public int getCodiUbicGeog() {
        return codiUbicGeog;
    }

    public void setCodiUbicGeog(int codiUbicGeog) {
        this.codiUbicGeog = codiUbicGeog;
    }

    public String getNombUbicGeog() {
        return nombUbicGeog;
    }

    public void setNombUbicGeog(String nombUbicGeog) {
        this.nombUbicGeog = nombUbicGeog;
    }

    public int getCodiUbicGeogSupe() {
        return codiUbicGeogSupe;
    }

    public void setCodiUbicGeogSupe(int codiUbicGeogSupe) {
        this.codiUbicGeogSupe = codiUbicGeogSupe;
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
        return this.nombUbicGeog;
    }
    
    
}
