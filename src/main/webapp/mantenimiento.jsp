<%@page import="com.sv.udb.controlador.UbicGeogCtrl"%>
<%@page import="com.sv.udb.modelo.UbicGeog"%>
<%@page import="com.sv.udb.controlador.TipoPersCtrl"%>
<%@page import="com.sv.udb.modelo.TipoPers"%>
<%@page import="java.util.Base64"%>
<%@page import="com.sv.udb.controlador.PersCtrl"%>
<%@page import="com.sv.udb.modelo.Pers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ID CARD</title>
        <link rel='stylesheet' href='webjars/Materialize/0.96.0/dist/css/materialize.min.css'>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/Materialize/0.96.0/dist/js/materialize.min.js"></script>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    </head>
    <body>
        <div class="row z-depth-5">
            <h1 class="col s12 m6 offset-m3">${mensAler}</h1>
            <form method="POST" action="PersServ" name="Demo" class="col s12 m6 offset-m3" enctype="multipart/form-data">
                <div class="row">
                    <div class="input-field col s12">
                        <input readonly type="text" name="codi" id="codi" value="${codi}" class="validate">
                        <label for="codi">Código</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="text" name="nomb" id="nomb" value="${nomb}">
                        <label for="nomb">Nombre</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="text" name="apel" id="apel" value="${apel}"><br>
                        <label for="apel">Apellidos</label>
                    </div>
                    <div class="input-field col s6">
                        <select id="gene" name="gene" required> 
                            <option value="" disabled selected>- Género -</option>
                            <option value="M">Masculino</option>
                            <option value="F">Femenino</option>
                            <option value="X">Otro</option>
                        </select>
                    </div>
                    <div class="input-field col s6">
                        <select id="tipo" name="tipo" required> 
                            <option value="" disabled selected>- Tipo de persona -</option>
                            <%
                                for(TipoPers temp : new TipoPersCtrl().consTodo())
                                {
                            %>
                            <option value="<%=temp.getCodiTipoPers()%>"><%=temp.getNombTipoPers()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>                        
                    <div class="input-field col s6">
                        <input type="text" name="fech" id="fech" value="${fech}">
                        <label for="fech">Fecha de nacimiento. Ejemplo 1990-05-27</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="text" name="dui" id="dui" value="${dui}">
                        <label for="dui">DUI</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="text" name="nit" id="nit" value="${nit}">
                        <label for="nit">NIT</label>
                    </div>
                    <div class="input-field col s6">
                        <input type="text" name="sang" id="sang" value="${sang}">
                        <label for="sang">Tipo de sangre</label>
                    </div>
                    <div class="input-field col s6">
                        <select id="ubic" name="ubic" required> 
                            <option value="" disabled selected>- Ubicación -</option>
                            <%
                                for(UbicGeog temp : new UbicGeogCtrl().consTodo())
                                {
                            %>
                            <option value="<%=temp.getCodiUbicGeog()%>"><%=temp.getNombUbicGeog()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div class="input-field col s6">
                        <input type="email" name="mail" id="mail" value="${mail}">
                        <label for="mail">Correo electrónico</label>
                    </div>    
                    <div class="file-field input-field col s12">
                        <div class="btn">
                            <span><i class="material-icons">image</i></span>
                            <input type="file" id="imag" name="imag" value="${imag}">
                        </div>
                        <div class="file-path-wrapper">
                            <input class="file-path validate" type="text">
                        </div>
                    </div>
                </div>
                <input ${estGuar} type="submit" name="persBton" value="Guardar">
                <input ${estModi} type="submit" name="persBton" value="Modificar">
            </form>
            <h1 class="col s12 m6 offset-m3">Tabla Pers</h1>
            `<form method="POST" action="PersServ" name="Tabl" class="col s12 m6 offset-m3">
                <table class="highlight" border="1" width="500">
                    <tr>
                        <th>Cons</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Correo</th>
                        <th>Foto</th>
                    </tr>
                    <%
                        for (Pers temp : new PersCtrl().consTodo()) {
                            byte[] photo = temp.getFotoPers();
                            String bphoto = Base64.getEncoder().encodeToString(photo);
                    %>
                    <tr>
                        <td><p><input type="radio" name="codiPersRadi" class='with-gap' id="<%=temp.getCodiPers()%>" value="<%=temp.getCodiPers()%>"><label for="<%=temp.getCodiPers()%>"></label></p></td>
                        <td><%=temp.getNombPers()%></td>
                        <td><%=temp.getApelPers()%></td>
                        <td><%=temp.getMailPers()%></td>
                        <td><img src="data:image/*;base64,<%=bphoto%>" class="materialboxed" width="100" height="100"></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                <input type="submit" name="persBton" value="Consultar">
                <input ${estElim} type="submit" onclick="return confirm('¿Desea proceder con la actualización del registro?');" name="persBton" value="Eliminar">
                <input type="submit" name="persBton" value="Nuevo">
            </form>
        </div>
    </body>
    <script>
        $(document).ready(function() {
            $('select').material_select();
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15 // Creates a dropdown of 15 years to control year
            });
          });              
    </script>
</html>