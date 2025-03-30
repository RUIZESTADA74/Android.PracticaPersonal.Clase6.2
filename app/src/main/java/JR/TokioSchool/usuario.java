package JR.TokioSchool;

import java.util.ArrayList;

public class usuario {

    // DEFINIR VARIABLES DE MAINACTIVITI A UTILIZAR Y ARRAYLIST PARA DEPORTES
    private String nombre;
    private String ciudad;
    private String estadocivil;
    private ArrayList<String> deporteseleccionado;

    // CONFIGURACION DE DATOS DE USUSARIO CON VARIABLES GLOBALES.

    public usuario(String nombre, String ciudad, String casado, ArrayList<String> deporteseleccionado) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estadocivil=casado;
        this.deporteseleccionado = deporteseleccionado;
    }

    public usuario() {
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "Nombre:'" + nombre + '\'' +
                ", Ciudad:'" + ciudad + '\'' +
                ", Estado Civil:'" + estadocivil +
                ", Deportes:'" + deporteseleccionado + '\'' +
                '}';
    }
}
