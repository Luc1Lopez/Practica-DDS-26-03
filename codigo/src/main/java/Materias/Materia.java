package Materias;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Materia{

    private String nombre;
    private ArrayList<Materia> correlativas;
    public Materia(String nombre){
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getCorrelativas() {
        return this.correlativas;
    };

    public void setCorrelativas(ArrayList<Materia> correlativas) {
        this.correlativas = correlativas;
    };

    public void agregarCorrelativas(Materia ... materia){
        Collections.addAll(this.correlativas,materia);
    }
}