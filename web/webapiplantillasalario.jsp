<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.ControllerPlantilla"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Consumo Api Plantilla XML</h1>
        <form method="post">
            <label>Introduzca salario: </label>
            <input type="text" name="cajasalario"/>
            <button type="submit">Buscar plantilla</button>
        </form>
        <hr/>
        <table border="2">
            <thead>
                <tr>
                    <th>Apellido</th>
                    <th>Función</th>
                    <th>Turno</th>
                    <th>Salario</th>
                </tr>                
            </thead>
            <tbody>
                <%
                String salario = request.getParameter("cajasalario");
                if (salario != null){
                    String datos = controller.getPlantillaSalario(salario);
                    out.println(datos);
                }
                %>
            </tbody>
        </table>
               
    </body>
</html>
