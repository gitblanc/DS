package adapters;

import google.maps.*;
import model.*;

public class AdaptadorMarcadorMonumento implements Marcador {

    private Monumento monumento;
    private Navegador navegador = new Navegador();

    public AdaptadorMarcadorMonumento(Monumento monument) {
        this.monumento = monument;
    }

    @Override
    public Coordenadas getCoordenadas() {
        return navegador.getCoordenadas(monumento.getDirección());
    }

    @Override
    public String pulsaciónCorta() {
        return monumento.getNombre() + ". Construido por " + monumento.getAutor();
    }

    @Override
    public void pulsaciónLarga() {
        navegador.navegarHasta(monumento.getDirección());
    }

}
