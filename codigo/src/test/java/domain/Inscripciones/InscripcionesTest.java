package domain.Inscripciones;

import domain.BaseTest;
import Documentos.Inscripcion;
import Materias.Materia;
import Personas.Alumno;
import org.junit.Assert;
import org.junit.Test;

public class InscripcionesTest extends BaseTest {
    @Test
    public void inscripcion1Pasa(){
        Inscripcion ins1 = super.buscarInscripcion("Tomas");
        Assert.assertTrue(ins1.aprobada());
    };
    @Test
    public void inscripcion2Pasa(){
        Inscripcion ins2 = super.buscarInscripcion("Maria");
        Assert.assertTrue(ins2.aprobada());
    };
    @Test
    public void inscripcion3NoPasa(){
        Inscripcion ins3 = super.buscarInscripcion("Miguel");
        Assert.assertFalse(ins3.aprobada());
    };
}
