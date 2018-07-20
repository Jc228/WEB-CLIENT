package com.distribuida.interfaces;

import com.distribuida.modelo.Singer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface SingerService {
    List<Singer> listar();
    Singer buscarPorId(Integer id);
    Singer crearSinger(Singer singer);
    String actualizarSinger(Singer singer);
    String eliminarSinger(Long id);
}
