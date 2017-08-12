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
public class Pers {
    private int codiPers;
    private String nombPers;
    private String apelPers;
    private byte[] fotoPers;
    private String mailPers;
    private int codiTipoPers;
    private String genePers;
    private java.sql.Date fechNaciPers;
    private String duiPers;
    private String nitPers;
    private String tipoSangPers;
    private int codiUbicGeog;
    private java.sql.Date fechAlta;
    private java.sql.Date fechBaja;
    private int esta;

    public Pers() {
    }

    public Pers(int codiPers, String nombPers, String apelPers, byte[] fotoPers, String mailPers, int codiTipoPers, String genePers, Date fechNaciPers, String duiPers, String nitPers, String tipoSangPers, int codiUbicGeog, Date fechAlta, Date fechBaja, int esta) {
        this.codiPers = codiPers;
        this.nombPers = nombPers;
        this.apelPers = apelPers;
        this.fotoPers = fotoPers;
        this.mailPers = mailPers;
        this.codiTipoPers = codiTipoPers;
        this.genePers = genePers;
        this.fechNaciPers = fechNaciPers;
        this.duiPers = duiPers;
        this.nitPers = nitPers;
        this.tipoSangPers = tipoSangPers;
        this.codiUbicGeog = codiUbicGeog;
        this.fechAlta = fechAlta;
        this.fechBaja = fechBaja;
        this.esta = esta;
    }

    public int getCodiPers() {
        return codiPers;
    }

    public void setCodiPers(int codiPers) {
        this.codiPers = codiPers;
    }

    public String getNombPers() {
        return nombPers;
    }

    public void setNombPers(String nombPers) {
        this.nombPers = nombPers;
    }

    public String getApelPers() {
        return apelPers;
    }

    public void setApelPers(String apelPers) {
        this.apelPers = apelPers;
    }

    public byte[] getFotoPers() {
        return fotoPers;
    }

    public void setFotoPers(byte[] fotoPers) {
        this.fotoPers = fotoPers;
    }
    
    public String getMailPers() {
        return mailPers;
    }

    public void setMailPers(String mailPers) {
        this.mailPers = mailPers;
    }

    public int getCodiTipoPers() {
        return codiTipoPers;
    }

    public void setCodiTipoPers(int codiTipoPers) {
        this.codiTipoPers = codiTipoPers;
    }

    public String getGenePers() {
        return genePers;
    }

    public void setGenePers(String genePers) {
        this.genePers = genePers;
    }

    public Date getFechNaciPers() {
        return fechNaciPers;
    }

    public void setFechNaciPers(Date fechNaciPers) {
        this.fechNaciPers = fechNaciPers;
    }

    public String getDuiPers() {
        return duiPers;
    }

    public void setDuiPers(String duiPers) {
        this.duiPers = duiPers;
    }

    public String getNitPers() {
        return nitPers;
    }

    public void setNitPers(String nitPers) {
        this.nitPers = nitPers;
    }

    public String getTipoSangPers() {
        return tipoSangPers;
    }

    public void setTipoSangPers(String tipoSangPers) {
        this.tipoSangPers = tipoSangPers;
    }

    public int getCodiUbicGeog() {
        return codiUbicGeog;
    }

    public void setCodiUbicGeog(int codiUbicGeog) {
        this.codiUbicGeog = codiUbicGeog;
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
        return this.nombPers;
    }
    
    
    
}
