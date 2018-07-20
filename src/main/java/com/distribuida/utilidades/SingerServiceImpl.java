package com.distribuida.utilidades;

import com.distribuida.interfaces.SingerService;
import com.distribuida.modelo.Singer;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SingerServiceImpl implements SingerService {
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Singer> listar(){
        ResponseEntity<List<Singer>> response = restTemplate.exchange(Constantes.URL_SINGER + "/listar", HttpMethod.GET, null, new ParameterizedTypeReference<List<Singer>>() {});
        List<Singer> lista = response.getBody();
        System.out.println(lista);
        return lista;
    }

    @Override
    public Singer buscarPorId (Integer id) {
       ResponseEntity<Singer> response = restTemplate.getForEntity(Constantes.URL_SINGER+"/buscar/"+id, Singer.class,12);
        return response.getBody();
    }

    @Override
    public Singer crearSinger (Singer singer) {
        ResponseEntity<Singer> response = restTemplate.postForEntity(Constantes.URL_SINGER+"/crear", singer, Singer.class);
        return response.getBody();
    }

    @Override
    public String actualizarSinger (Singer singer) {
        Long id = singer.getId();
        restTemplate.put(Constantes.URL_SINGER+"/actualizar/"+id, singer.getFirstName(),singer.getLastName(),singer.getBirthDate(),singer.getEmail());
        return "Actualizado";
    }

    @Override
    public String eliminarSinger (Long id) {
        restTemplate.delete(Constantes.URL_SINGER+"/eliminar/"+id,12);
        return "Eliminado";
    }

    }
