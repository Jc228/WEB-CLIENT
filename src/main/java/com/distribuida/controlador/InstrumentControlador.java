package com.distribuida.controlador;

import com.distribuida.interfaces.InstrumentService;
import com.distribuida.modelo.Instrument;
import com.distribuida.utilidades.InstrumentServiceImpl;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "instruController")
@SessionScope
public class InstrumentControlador {
    private Instrument instrument;
    private List<Instrument> instrumentos;
    private InstrumentServiceImpl instrumentService;

    public Instrument getInstrument ( ) {
        return instrument;
    }

    public void setInstrument (Instrument instrument) {
        this.instrument = instrument;
    }

    public List<Instrument> getInstrumentos ( ) {
        return instrumentos;
    }

    public void setInstrumentos (List<Instrument> instrumentos) {
        this.instrumentos = instrumentos;
    }

    public InstrumentServiceImpl getInstrumentService ( ) {
        return instrumentService;
    }

    public void setInstrumentService (InstrumentServiceImpl instrumentService) {
        this.instrumentService = instrumentService;
    }

    @PostConstruct
    public void init(){
        instrumentService = new InstrumentServiceImpl();
        instrumentos = instrumentService.listar();
        instrument = new Instrument();
    }

    //Metodos para realizar operaciones con Instrument
    public void addInstrument(Instrument instrument){
        instrumentService.crearInstrument(instrument);
    }
    public String verInstrument(Instrument inst){
        instrument = inst;
        return "/instrument/ver-instrument.xhtml";
    }
    public String verEditInstrument(Instrument instr){
        instrument = instr;
        return "/instrument/update-instrument.xhtml";
    }
    public String borrarInstrument(Instrument instr){
        instrument = instr;
        String id = instrument.getInstrumentId();
        instrumentService.eliminarInstrument(id);
        return "/instrument/instrument.xhtml";
    }
    public String editarInstrument(Instrument instr){
        instrument = instr;
        instrumentService.actualizarInstrument(instrument);
        return "/instrument/instrument.xhtml";
    }
}
