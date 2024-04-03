package Documentos;

import Personas.Alumno;
import Materias.Materia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Inscripcion{
    private Alumno alumno;
    private ArrayList<Materia> listaDeMaterias;

    public Inscripcion(Alumno alumno){
        this.alumno = alumno;
        this.listaDeMaterias = new ArrayList<>();
    }
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Materia> getListaDeMaterias() {
        return listaDeMaterias;
    }

    public void setListaDeMaterias(ArrayList<Materia> listaDeMaterias) {
        this.listaDeMaterias = listaDeMaterias;
    }

    public void agregarMaterias(Materia ... materia){
        Collections.addAll(this.listaDeMaterias,materia);
    }

    public boolean aprobada(){
        return this.listaDeMaterias
                .stream()
                .allMatch(m -> this.alumno.puedeCursar(m));
    }
}
