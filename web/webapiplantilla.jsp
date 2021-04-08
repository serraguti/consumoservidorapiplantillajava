<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.ControllerPlantilla"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Api plantilla XML Java</title>
    </head>
    <body>
        <h1>Consumo XML Java Api Plantilla</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Apellido</th>
                    <th>Función</th>
                    <th>Turno</th>
                    <th>Salario</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaPlantilla()%>
            </tbody>
        </table>
    </body>
</html>
