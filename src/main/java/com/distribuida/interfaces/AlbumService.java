package com.distribuida.interfaces;

import com.distribuida.modelo.Album;

import java.util.List;

public interface AlbumService {
    List<Album> listar ( );
    Album buscarPorId (Integer id);
    Album crearAlbum (Album album);
    String actualizarAlbum (Album album);
    String eliminarAlbum (Long id);
}
