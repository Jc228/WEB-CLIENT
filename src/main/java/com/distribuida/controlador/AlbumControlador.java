package com.distribuida.controlador;

import com.distribuida.modelo.Album;
import com.distribuida.utilidades.AlbumServiceImpl;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "albController")
@SessionScope
public class AlbumControlador {
    private Album album;
    private List<Album> albums;
    private AlbumServiceImpl albumService;

    public Album getAlbum ( ) {
        return album;
    }

    public void setAlbum (Album album) {
        this.album = album;
    }

    public List<Album> getAlbums ( ) {
        return albums;
    }

    public void setAlbums (List<Album> albums) {
        this.albums = albums;
    }

    public AlbumServiceImpl getAlbumService ( ) {
        return albumService;
    }

    public void setAlbumService (AlbumServiceImpl albumService) {
        this.albumService = albumService;
    }

    @PostConstruct
    public void innit(){
        albumService = new AlbumServiceImpl();
        albums = albumService.listar();
        album = new Album();
    }
    //Metodos para realizar operaciones con Album
    public void addAlbum(Album album){
        albumService.crearAlbum(album);
    }
    public String verAlbum(Album alb){
        album = alb;
        return "/album/ver-album.xhtml";
    }
    public String verEditAlbum(Album alb){
        album = alb;
        return "/album/update-album.xhtml";
    }
    public String borrarAlbum(Album alb){
        album = alb;
        Long id = album.getId();
        albumService.eliminarAlbum(id);
        return "/album/album.xhtml";
    }
    public String editarAlbum(Album alb){
        album = alb;
        albumService.actualizarAlbum(album);
        return "/album/album.xhtml";
    }
}
