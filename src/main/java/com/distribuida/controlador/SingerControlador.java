package com.distribuida.controlador;

import com.distribuida.modelo.Singer;
import com.distribuida.utilidades.SingerServiceImpl;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "singController")
@SessionScope
public class SingerControlador {
    private Singer singer;
    private List<Singer> singers;
    private SingerServiceImpl singerService;

    public Singer getSinger ( ) {
        return singer;
    }

    public void setSinger (Singer singer) {
        this.singer = singer;
    }

    public List<Singer> getSingers ( ) {
        return singers;
    }

    public void setSingers (List<Singer> singers) {
        this.singers = singers;
    }

    public SingerServiceImpl getSingerService ( ) {
        return singerService;
    }

    public void setSingerService (SingerServiceImpl singerService) {
        this.singerService = singerService;
    }

    @PostConstruct
    public void init(){
        singerService = new SingerServiceImpl();
        singers = singerService.listar();
        singer = new Singer();
    }

    //Metodos para realizar operaciones con Singer
    public void addSinger(Singer singer){
        singerService.crearSinger(singer);
    }
    public String verSinger(Singer sing){
        singer = sing;
        return "/singer/ver-singer.xhtml";
    }
    public String verEditSinger(Singer sing){
        singer = sing;
        return "/singer/update-singer.xhtml";
    }
    public String borrarSinger(Singer sing){
        singer = sing;
        Long id = singer.getId();
        singerService.eliminarSinger(id);
        return "/singer/singer.xhtml";
    }
    public String editarSinger(Singer sing){
        singer = sing;
        singerService.actualizarSinger(singer);
        return "/singer/singer.xhtml";
    }
}
