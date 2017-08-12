/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.recursos;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Estudiante
 */
public class Conexion {
    Connection con = null;
    private String url, user, pass;
    public Connection getConn()
    {
        try {
            if(this.getDatosConexion())
            {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = DriverManager.getConnection(this.url, this.user, this.pass);
            }
        } 
        catch (SQLException ex) {
            System.err.println("Error" + ex.getMessage());
        }
        return con;
    }
    private boolean getDatosConexion()
    {
        try {
            Properties prop = new Properties();
            try(InputStream file = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"))
            {
                prop.load(file);
                //Obtener valores de la concexion
                this.url = prop.getProperty("url");
                this.user = prop.getProperty("user");
                this.pass = prop.getProperty("pass");       
                return true;
            }
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
