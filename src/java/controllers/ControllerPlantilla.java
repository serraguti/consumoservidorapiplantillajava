package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.xml.bind.JAXBException;
import models.ListaPlantilla;
import models.Plantilla;
import services.ServicePlantilla;

public class ControllerPlantilla {

    ServicePlantilla service;

    public ControllerPlantilla() {
        this.service = new ServicePlantilla();
    }

    public String getTablaPlantilla() throws IOException,
            MalformedURLException, JAXBException {
        ListaPlantilla lista = this.service.getPlantilla();
        List<Plantilla> plantillas = lista.getPlantillas();
        String html = "";
        for (Plantilla p : plantillas) {
            html += "<tr>";
            html += "<td>" + p.getApellido() + "</td>";
            html += "<td>" + p.getFuncion() + "</td>";
            html += "<td>" + p.getTurno() + "</td>";
            html += "<td>" + p.getSalario() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getPlantillaFuncion(String funcion) throws IOException, MalformedURLException, JAXBException {
        ListaPlantilla objeto = this.service.getPlantillaFuncion(funcion);
        List<Plantilla> plantillas = objeto.getPlantillas();
        String html = "";
        for (Plantilla p : plantillas) {
            html += "<tr>";
            html += "<td>" + p.getApellido() + "</td>";
            html += "<td>" + p.getFuncion() + "</td>";
            html += "<td>" + p.getTurno() + "</td>";
            html += "<td>" + p.getSalario() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getPlantillaSalario(String salario) throws IOException, MalformedURLException, JAXBException {
        ListaPlantilla objeto = this.service.getPlantillaSalario(salario);
        List<Plantilla> plantillas = objeto.getPlantillas();
        String html = "";
        for (Plantilla p : plantillas) {
            html += "<tr>";
            html += "<td>" + p.getApellido() + "</td>";
            html += "<td>" + p.getFuncion() + "</td>";
            html += "<td>" + p.getTurno() + "</td>";
            html += "<td>" + p.getSalario() + "</td>";
            html += "</tr>";
        }
        return html;
    }
}
