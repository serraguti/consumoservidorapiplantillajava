package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import models.ListaPlantilla;

public class ServicePlantilla {

    //AQUI TENDREMOS TODOS LOS METODOS PARA ATACAR A NUESTRO API
    //PERO NECESITAMOS LA RUTA
    String url;

    public ServicePlantilla() {
        this.url = "https://apijavaplantillapgs.azurewebsites.net/";
    }

    //LO QUE CONSUMIMOS DE UN SERVICIO ES UN STREAM, QUE ES UN FLUJO
    //DE DATOS, AUNQUE NOSOTROS VISUALMENTE VEAMOS TEXTO, DEBEMOS
    //CONVERTIR EL FLUJO EN TEXTO
    private String leerRespuestaApi(InputStream stream) throws IOException {
        //NECESITAMOS UN LECTOR DEL FLUJO
        BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
        //TENEMOS QUE LEER EL FLUJO Y PONER UN SEPARADOR DE ENTER
        //ENTRE LAS LINEAS
        String linea = "";
        //UN STRINGBUFFER SIRVE PARA LEER CONTENIDO MUY GRANDE
        StringBuffer data = new StringBuffer();
        //EL SEPARADOR DE ENTER DE CADA LINEA
        String separador = "";
        //MIENTRAS QUE EXISTAN LINEAS EN EL XML, DENTRO BUCLE
        while ((linea = buffer.readLine()) != null) {
            //AÑADIMOS EL CONTENIDO DE DATOS A DATA
            data.append(separador + linea);
            separador = "\n";
        }
        //RECUPERAMOS LOS DATOS COMO STRING
        String response = data.toString();
        return response;
    }

    private ListaPlantilla getRequestPlantilla(String request) throws MalformedURLException, IOException, JAXBException {
        URL peticion = new URL(this.url + request);
        HttpURLConnection conexion = (HttpURLConnection) peticion.openConnection();
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Accept", "application/xml");
        if (conexion.getResponseCode() == 200) {
            InputStream stream = conexion.getInputStream();
            String data = this.leerRespuestaApi(stream);
            JAXBContext context
                    = JAXBContext.newInstance(ListaPlantilla.class);
            Unmarshaller serial = context.createUnmarshaller();
            StringReader reader = new StringReader(data);
            ListaPlantilla plantillas = (ListaPlantilla) serial.unmarshal(reader);
            return plantillas;
        } else {
            return null;
        }
    }

    //METODO PARA LEER EL SERVICIO Y DEVOLVER LA PLANTILLA
    public ListaPlantilla getPlantilla() throws MalformedURLException, IOException, JAXBException {
        //DEBEMOS INDICAR EL METODO DONDE LEEMOS
        String request = "api/plantilla";
        return this.getRequestPlantilla(request);
    }

    public ListaPlantilla getPlantillaFuncion(String funcion) throws MalformedURLException, IOException, JAXBException {
        String request = "api/plantilla/buscarfuncion/" + funcion;
        return this.getRequestPlantilla(request);
    }

    public ListaPlantilla getPlantillaSalario(String salario) throws MalformedURLException, IOException, JAXBException {
        String request = "api/plantilla/buscarsalario/" + salario;
        return this.getRequestPlantilla(request);
    }
}
