/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Centro;
import Modelo.CentroTrabajadores;
import java.util.ArrayList;

/**
 *
 * @author DisenoWeb
 */
public class CentroTrabajadoresRepository {

    private final ArrayList<CentroTrabajadores> centrosT;
    private CentroRepository centroRepository;
    private TrabajadorRepository trabajadorRepository;

    public CentroTrabajadoresRepository() {
        this.centrosT = new ArrayList<>();
        centroRepository = new CentroRepository();
        trabajadorRepository = new TrabajadorRepository();
        rellenarLista();
    }

    public void rellenarLista() {
        centrosT.clear();
        ArrayList<Centro> centros = centroRepository.getCentros();
        for (int i = 0; i < centros.size(); i++) {
            Centro centro = centros.get(i);
            trabajadorRepository.buscarTrabajadoresPorCodigoCentro(centro.getCodigo());
            centrosT.add(new CentroTrabajadores(trabajadorRepository.getTrabajadores(), centro));
        }
    }

}
