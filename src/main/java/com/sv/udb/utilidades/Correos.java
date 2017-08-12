/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.utilidades;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;
/**
 *
 * @author leyes
 */
public class Correos {
    
      //declaración de nuestras variables
//correo electrónico que se utilizara para enviar los mail
    private String Usuario = "";
//contraseña de correo electrónico
    private String Contra = "";
//mensaje
    String Mensaje = "";
//destino de mail
    String Para = "";
//asunto a tratar
    String Asunto = "";
    
    
    public void actuMail(String men, String para, String tema)
    {
        this.Mensaje = men;
        this.Para = para;
        this.Asunto = tema;
    }

    public void mailEnvi() {
        String resourceName = "mail.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties mail = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            mail.load(resourceStream);
        }
        catch(Exception ex)
        {
            System.out.println("Problemas con tomar info del propierties");
        }
        
        this.Usuario = mail.getProperty("gmail.cuenta");
        this.Contra = mail.getProperty("gmail.contra");
    }
    
//métodos para obtener o cambiar información de nuestras variables

    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getPara() {
        return Para;
    }

    public void setPara(String Para) {
        this.Para = Para;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

// este método autentifica el usuario y contraseña y enviar el mail a el destinatario
    public boolean SendMail(Message.RecipientType tipo) {
        boolean resp;
        mailEnvi();
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Usuario, Contra);
                    }
                });
        
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Usuario));
            message.setRecipients(tipo,
                    InternetAddress.parse(Para));
            message.setSubject(Asunto);
            message.setText(Mensaje);
            Transport.send(message);
            resp = true;
        } catch (MessagingException e) {
            resp = false;
        }
        return resp;
    }

//este método enviar un mail al destinatario adjuntando un archivo (pdf), con la diferencia que nos pedirá nombre del archivo, ruta del archivo y asunto del porque envía el archivo

    public void enviarpdf(String archivo, String nombre, String asunto) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Usuario, Contra);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Usuario));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(Para));
            BodyPart adjunto = new MimeBodyPart();
            BodyPart texto = new MimeBodyPart();
            texto.setText(asunto);
            adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
            adjunto.setFileName(nombre);
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(adjunto);
            multiParte.addBodyPart(texto);
            message.setSubject(Asunto);
            message.setText(Mensaje);
            message.setContent(multiParte);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
