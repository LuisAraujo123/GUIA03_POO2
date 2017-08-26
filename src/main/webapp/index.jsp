<%@page import="com.sv.udb.controlador.PersCtrl"%>
<%@page import="com.sv.udb.modelo.Pers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/Materialize/0.96.0/dist/css/materialize.min.css'>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/Materialize/0.96.0/dist/js/materialize.min.js"></script>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
        <title>Enviar correo</title>
    </head>
    <body>
        <main class="container">
            <div class="row">
                 <div class="row">
                     <div class="col s12">
                         <div class="card blue-grey darken-1">
                             <div class="card-content white-text">
                                 <span class="card-title"><center>Enviar correo</center></span>
                                 <h4>${mensAler}</h4>
                                 <form method="POST" action="EnviarCorreoServ" name="Demo">
                                     <div class="row">
                                         <div class="input-field col s12 center-align">
                                             <select id="mailPers01" name="mailPers01" required> 
                                                 <option value="" disabled selected>- Para -</option>
                                                 <%
                                                     for (Pers temp : new PersCtrl().consTodo()) {

                                                 %> 
                                                 <option value="<%=temp.getMailPers()%>"><%=temp.getMailPers()%></option>
                                                 <%
                                                     }
                                                 %>
                                             </select>
                                        </div>
                                        <div class="input-field col s12 center-align">
                                             <select  id="mailPers02" name="mailPers02"> 
                                                 <option value="" disabled selected>- CC -</option>
                                                 <%
                                                     for (Pers temp : new PersCtrl().consTodo()) {

                                                 %> 
                                                 <option value="<%=temp.getMailPers()%>"><%=temp.getMailPers()%></option>
                                                 <%
                                                     }
                                                 %>
                                             </select>
                                        </div>
                                        <div class="input-field col s12 center-align">
                                            <select id="mailPers03" name="mailPers03"> 
                                                <option value="" disabled selected>- CCO -</option>
                                                <%
                                                    for (Pers temp : new PersCtrl().consTodo()) {

                                                %> 
                                                <option value="<%=temp.getMailPers()%>"><%=temp.getMailPers()%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <div>
                                            <div class="input-field col s12">
                                                <input id="asunto" name="asunto" type="text" class="validate">
                                                <label for="asunto">Asunto</label>
                                            </div>
                                        </div>
                                        <div class="input-field col s12 center-align">
                                            <i class="material-icons prefix"></i>
                                            <textarea id="mensaje" name="mensaje" required class="materialize-textarea">${Mens}</textarea>
                                            <label for="mensaje">Mensaje</label>
                                        </div>
                                        <div class="file-field input-field col s12">
                                            <div class="btn">
                                                <span><i class="material-icons">image</i></span>
                                                <input type="file" id="dato" name="dato" value="${dato}">
                                            </div>
                                            <div class="file-path-wrapper">
                                                <input class="file-path validate" type="text" name="arch" id="arch">
                                            </div>
                                        </div>    
                                        <div class="input-field col s12">
                                            <input id="ruta" name="ruta" type="text" class="validate">
                                            <label for="ruta">Ruta del archivo</label>
                                            <span>Para enviar un archivo se necesita el archivo y la ruta del mismo por ejemplo: C:\Users\bernardo\Pictures\1.png</span>
                                        </div>
                                     </div>
                                    <div class="center-align">
                                        <button class="btn blue waves-effect waves-light" type="submit" value="Enviar" name="btonMail">Enviar<i class="material-icons right"></i></button>
                                        <button class="btn red waves-effect waves-light" type="submit" value="Cancelar" name="btonMail">Cancelar<i class="material-icons right"></i></button>
                                    </div>
                                 </form>
                             </div>
                             <div class="card-action">
                                 
                             </div>
                         </div>
                     </div>
                 </div>
            </div>
        </main>
        <footer>
                                                 
        </footer>
        <script>
        $(document).ready(function(){
            $('.button-collapse').sideNav();
            $('.materialboxed').materialbox();
            $('select').material_select();
        });
        </script>
    </body>
</html>
