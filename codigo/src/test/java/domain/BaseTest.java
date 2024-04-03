package domain;

import Documentos.Inscripcion;
import Materias.Materia;
import Personas.Alumno;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public abstract class BaseTest {
    protected ArrayList<Materia> listaMaterias;
    protected ArrayList<Alumno> listaAlumnos;
    protected ArrayList<Inscripcion> listaInscripciones;

    protected BaseTest(){
        this.listaAlumnos = new ArrayList<Alumno>();
        this.listaMaterias = new ArrayList<Materia>();
        this.listaInscripciones = new ArrayList<Inscripcion>();
    }

    @Before

    public void inicializar(){
        this. inicializarMaterias();
        this.inicializarAlumnos();
        this.inicializarInscripciones();
    }

    private void inicializarMaterias(){
        Materia am1 = new Materia("AM1");
        Materia aga = new Materia("AGA");
        Materia am2 = new Materia("AM2");
        Materia ayed = new Materia("AyED");
        Materia pdp = new Materia("Paradigmas");
        am2.agregarCorrelativas(am1,aga);
        pdp.agregarCorrelativas(ayed);
        Collections.addAll(listaMaterias,am1,am2,aga,ayed,pdp);
    }
    private void inicializarAlumnos(){
        Alumno a1 = new Alumno("Tomas","1234567");
        Alumno a2 = new Alumno("Maria","7654321");
        Alumno a3 = new Alumno("Miguel","1726354");
        a1.agregarMateriasCursadas(buscarMateria("AM1"),buscarMateria("AGA"));
        a3.agregarMateriasCursadas(buscarMateria("AM1"),buscarMateria("AM2"),buscarMateria("AGA"));
        Collections.addAll(listaAlumnos,a1,a2,a3);
    }

    private void inicializarInscripciones(){
        Inscripcion i1 = new Inscripcion(buscarAlumno("Tomas"));
        Inscripcion i2 = new Inscripcion(buscarAlumno("Maria"));
        Inscripcion i3 = new Inscripcion(buscarAlumno("Miguel"));
        i1.agregarMaterias(buscarMateria("AM2"));
        i2.agregarMaterias(buscarMateria("AM1"),buscarMateria("AGA"));
        i3.agregarMaterias(buscarMateria("Paradigmas"));
        Collections.addAll(listaInscripciones,i1,i2,i3);
    };

    protected Materia buscarMateria(String nombre) {
        Optional<Materia> materia = this.listaMaterias
                .stream()
                .filter(m -> m.getNombre().equals(nombre))
                .findFirst();
        return materia.orElse(null);
    };
    protected Alumno buscarAlumno(String nombre) {
        Optional<Alumno> alumno = this.listaAlumnos
                .stream()
                .filter(a -> a.getNombre().equals(nombre))
                .findFirst();
        return alumno.orElse(null);
    };
    protected Inscripcion buscarInscripcion(String nombre) {
        Optional<Inscripcion> ins = this.listaInscripciones
                .stream()
                .filter(a -> a.getAlumno().getNombre().equals(nombre))
                .findFirst();
        return ins.orElse(null);
    };
}
