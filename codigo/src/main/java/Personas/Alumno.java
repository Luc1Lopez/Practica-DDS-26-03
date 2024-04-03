package Personas;

import Materias.Materia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno{
    private String nombre;
    private String leg;

    private List<Materia> materiasCursadas;

    public Alumno(String nombre,String leg){
        this.nombre = nombre;
        this.leg = leg;
        this.materiasCursadas = new ArrayList<>();
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    public String getLeg() {
        return leg;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setMateriasCursadas(ArrayList<Materia> materiasCursadas) {
        this.materiasCursadas = materiasCursadas;
    }
    public List<Materia> getMateriasCursadas() {
        return materiasCursadas;
    }

    public void agregarMateriasCursadas(Materia ... materia){
        Collections.addAll(this.materiasCursadas,materia);
    }

    public boolean puedeCursar(Materia materia){
        return materia.getCorrelativas()
                .stream()
                .allMatch(m -> this.cumpleRequisitos(m));
    };

    public boolean cumpleRequisitos(Materia materia){
        return this.materiasCursadas.contains(materia);
    }
}