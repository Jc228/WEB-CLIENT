package com.distribuida.utilidades;

import com.distribuida.interfaces.AlbumService;
import com.distribuida.modelo.Album;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class AlbumServiceImpl implements AlbumService {
   RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<Album> listar ( ) {
        ResponseEntity<List<Album>> response = restTemplate.exchange(Constantes.URL_ALBUM + "/listar", HttpMethod.GET, null, new ParameterizedTypeReference<List<Album>>() {});
        List<Album> lista = response.getBody();
        System.out.println(lista);
        return lista;
    }

    @Override
    public Album buscarPorId (Integer id) {
        ResponseEntity<Album> response = restTemplate.getForEntity(Constantes.URL_ALBUM+"/buscar/"+id, Album.class,12);
        return response.getBody();
    }

    @Override
    public Album crearAlbum (Album album) {
        ResponseEntity<Album> response = restTemplate.postForEntity(Constantes.URL_ALBUM+"/crear", album, Album.class);
        return response.getBody();
    }

    @Override
    public String actualizarAlbum (Album album) {
        Long id = album.getId();
        restTemplate.put(Constantes.URL_ALBUM+"/actualizar/"+id, album, 123L);
        return "Actualizado";
    }

    @Override
    public String eliminarAlbum (Long id) {
        restTemplate.delete(Constantes.URL_ALBUM+"/eliminar/"+id,12);
        return "Eliminado";
    }
}
