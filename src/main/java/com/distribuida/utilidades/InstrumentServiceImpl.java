package com.distribuida.utilidades;

import com.distribuida.interfaces.InstrumentService;
import com.distribuida.modelo.Instrument;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class InstrumentServiceImpl implements InstrumentService {
    RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<Instrument> listar ( ) {
        ResponseEntity<List<Instrument>> response = restTemplate.exchange(Constantes.URL_INSTRUMENT + "/listar", HttpMethod.GET, null, new ParameterizedTypeReference<List<Instrument>>() {});
        List<Instrument> lista = response.getBody();
        System.out.println(lista);
        return lista;
    }

    @Override
    public Instrument buscarPorId (String id) {
        ResponseEntity<Instrument> response = restTemplate.getForEntity(Constantes.URL_INSTRUMENT+"/buscar/"+id, Instrument.class,12);
        return response.getBody();
    }

    @Override
    public Instrument crearInstrument (Instrument instrument) {
        ResponseEntity<Instrument> response = restTemplate.postForEntity(Constantes.URL_INSTRUMENT+"/crear", instrument, Instrument.class);
        return response.getBody();
    }

    @Override
    public String actualizarInstrument (Instrument instrument) {
        String id = instrument.getInstrumentId();
        restTemplate.put(Constantes.URL_INSTRUMENT+"/actualizar/"+id, instrument, 123L);
        return "Actualizado";
    }

    @Override
    public String eliminarInstrument (String id) {
        restTemplate.delete(Constantes.URL_INSTRUMENT+"/eliminar/"+id,12);
        return "Eliminado";
    }
}
