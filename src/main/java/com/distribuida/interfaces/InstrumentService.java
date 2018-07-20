package com.distribuida.interfaces;

import com.distribuida.modelo.Instrument;
import com.distribuida.modelo.Singer;

import java.util.List;

public interface InstrumentService {
    List<Instrument> listar ( );
    Instrument buscarPorId (String id);
    Instrument crearInstrument (Instrument instrument);
    String actualizarInstrument (Instrument instrument);
    String eliminarInstrument (String id);
}
