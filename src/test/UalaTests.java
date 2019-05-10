package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.phidalgo.uala.controller.CobroController;
import com.phidalgo.uala.controller.RecomendacionController;
import com.phidalgo.uala.modelo.Plan;
import com.phidalgo.uala.modelo.Producto;
import com.phidalgo.uala.modelo.Usuario;
import com.phidalgo.uala.modelo.enums.CanalesComunicacion;
import com.phidalgo.uala.modelo.enums.EstadoAnimo;
import com.phidalgo.uala.modelo.enums.TipoProducto;
import com.phidalgo.uala.util.StringUtil;

public class UalaTests {
	private ArrayList<Producto> listaProductosAll = new ArrayList<Producto>();
	private ArrayList<CanalesComunicacion> canalesTodos = new ArrayList<CanalesComunicacion>();
	private ArrayList<CanalesComunicacion> canalUno = new ArrayList<CanalesComunicacion>();
	private ArrayList<Usuario> listaUsuariosAll = new ArrayList<Usuario>();
	private ArrayList<Producto> pelisTriAnt = new ArrayList<Producto>();
	private ArrayList<Producto> pelisTriNue = new ArrayList<Producto>();
	private ArrayList<Producto> pelisConAnt = new ArrayList<Producto>();
	private ArrayList<Producto> pelisConNue = new ArrayList<Producto>();
	private ArrayList<Producto> pelisMel = new ArrayList<Producto>();
	private Usuario usuarioAntiguo;
	private Usuario usuarioNuevo;
	private Usuario usuarioInteresante;
	private Usuario usuarioNoInteresante;
	private ArrayList<Producto> prodsInte = new ArrayList<Producto>();
	private ArrayList<Producto> prodsNoInte = new ArrayList<Producto>();
	private Plan plan;
	private Usuario usuarioCobrable;
	private Usuario usuarioNoCobrable;
	private Usuario usuarioTriste;
	private Usuario usuarioContento;
	private Usuario usuarioMelancolico;

	@Before
	public void setUp() {
		/* INICIALIZAMOS PRODUCTOS */
		// Productos antiguos e interesantes
		Producto peliAntInt = new Producto(1L, "PELÍCULA ANTIGUA E INTERESANTE", new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime(), TipoProducto.PELICULA, 1, 110, null);
		Producto peliAntIntTri = new Producto(2L, "PELÍCULA ANTIGUA E INTERESANTE (TRISTE)", new GregorianCalendar(2013, Calendar.JANUARY, 10).getTime(), TipoProducto.PELICULA, 2, 130, null);
		Producto peliAntIntMel = new Producto(3L, "PELÍCULA ANTIGUA E INTERESANTE (MELANCÓLICA)", new GregorianCalendar(2008, Calendar.FEBRUARY, 9).getTime(), TipoProducto.PELICULA, 3, 100,
				null);
		Producto serieAntInt = new Producto(4L, "SERIE ANTIGUA E INTERESANTE", new GregorianCalendar(2015, Calendar.MARCH, 12).getTime(), TipoProducto.SERIE, null, null, 4);
		Producto docuAntIntUnof = new Producto(5L, "DOCUMENTAL UNOFFICIAL ANTIGUO E INTERESANTE", new GregorianCalendar(2016, Calendar.APRIL, 13).getTime(), TipoProducto.DOCUMENTAL, null,
				null, null);
		// Productos nuevos e interesantes
		Producto peliNueInt = new Producto(6L, "PELÍCULA NUEVA E INTERESANTE", new GregorianCalendar(2019, Calendar.MAY, 14).getTime(), TipoProducto.PELICULA, 2, 120, null);
		Producto peliNueIntTri = new Producto(7L, "PELÍCULA NUEVA E INTERESANTE (TRISTE)", new GregorianCalendar(2019, Calendar.JANUARY, 8).getTime(), TipoProducto.PELICULA, 2, 135, null);
		Producto serieNueInt = new Producto(8L, "SERIE NUEVA E INTERESANTE", new GregorianCalendar(2018, Calendar.JUNE, 15).getTime(), TipoProducto.SERIE, null, null, 5);
		Producto docuNueIntUnof = new Producto(9L, "DOCUMENTAL UNOFFICIAL NUEVO E INTERESANTE", new GregorianCalendar(2019, Calendar.JULY, 16).getTime(), TipoProducto.DOCUMENTAL, null, null,
				null);
		// Productos antiguos y aburridos
		Producto peliAntAbu = new Producto(10L, "PELÍCULA ANTIGUA Y ABURRIDA", new GregorianCalendar(2013, Calendar.SEPTEMBER, 17).getTime(), TipoProducto.PELICULA, 0, 120, null);
		Producto peliAntAbuTri = new Producto(11L, "PELÍCULA ANTIGUA Y ABURRIDA (TRISTE)", new GregorianCalendar(2012, Calendar.DECEMBER, 6).getTime(), TipoProducto.PELICULA, 0, 145, null);
		Producto peliAntAbuMel = new Producto(12L, "PELÍCULA ANTIGUA Y ABURRIDA (MELANCÓLICA)", new GregorianCalendar(2007, Calendar.OCTOBER, 5).getTime(), TipoProducto.PELICULA, 0, 115,
				null);
		Producto serieAntAbu = new Producto(13L, "SERIE ANTIGUA Y ABURRIDA", new GregorianCalendar(2012, Calendar.AUGUST, 18).getTime(), TipoProducto.SERIE, null, null, 3);
		Producto docuAntAbu = new Producto(14L, "DOCUMENTAL ANTIGUO Y ABURRIDA", new GregorianCalendar(2011, Calendar.OCTOBER, 19).getTime(), TipoProducto.DOCUMENTAL, null, null, null);
		// Productos nuevos y aburridos
		Producto peliNueAbu = new Producto(15L, "PELÍCULA NUEVA Y ABURRIDA", new GregorianCalendar(2019, Calendar.DECEMBER, 20).getTime(), TipoProducto.PELICULA, 0, 120, null);
		Producto peliNueAbuTri = new Producto(16L, "PELÍCULA NUEVA Y ABURRIDA (TRISTE)", new GregorianCalendar(2018, Calendar.JANUARY, 23).getTime(), TipoProducto.PELICULA, 0, 129, null);
		Producto serieNueAbu = new Producto(17L, "SERIE NUEVA Y ABURRIDA", new GregorianCalendar(2018, Calendar.NOVEMBER, 21).getTime(), TipoProducto.SERIE, null, null, 2);
		Producto docuNueAbu = new Producto(18L, "DOCUMENTAL NUEVO Y ABURRIDO", new GregorianCalendar(2019, Calendar.JANUARY, 22).getTime(), TipoProducto.DOCUMENTAL, null, null, null);
		listaProductosAll.add(peliAntInt);
		listaProductosAll.add(peliAntIntTri);
		listaProductosAll.add(peliAntIntMel);
		listaProductosAll.add(serieAntInt);
		listaProductosAll.add(docuAntIntUnof);
		listaProductosAll.add(peliNueInt);
		listaProductosAll.add(peliNueIntTri);
		listaProductosAll.add(serieNueInt);
		listaProductosAll.add(docuNueIntUnof);
		listaProductosAll.add(peliAntAbu);
		listaProductosAll.add(peliAntAbuTri);
		listaProductosAll.add(peliAntAbuMel);
		listaProductosAll.add(serieAntAbu);
		listaProductosAll.add(docuAntAbu);
		listaProductosAll.add(peliNueAbu);
		listaProductosAll.add(peliNueAbuTri);
		listaProductosAll.add(serieNueAbu);
		listaProductosAll.add(docuNueAbu);

		/* CANALES COMUNICACIÓN */
		canalesTodos.add(CanalesComunicacion.CELULAR);
		canalesTodos.add(CanalesComunicacion.SMS);
		canalesTodos.add(CanalesComunicacion.MAIL);
		canalUno.add(CanalesComunicacion.MAIL);

		/* LISTAS PRODUCTOS PARTICULARES */
		pelisTriAnt.add(peliAntIntTri);
		pelisTriAnt.add(peliAntAbuTri);
		pelisTriNue.add(peliNueIntTri);
		pelisTriNue.add(peliNueAbuTri);
		pelisConAnt.add(peliAntInt);
		pelisConAnt.add(peliAntIntTri);
		pelisConAnt.add(peliAntIntMel);
		pelisConAnt.add(peliAntAbu);
		pelisConAnt.add(peliAntAbuTri);
		pelisConAnt.add(peliAntAbuMel);
		pelisConNue.add(peliNueInt);
		pelisConNue.add(peliNueIntTri);
		pelisConNue.add(peliNueAbu);
		pelisConNue.add(peliNueAbuTri);
		pelisMel.add(peliAntIntMel);
		pelisMel.add(peliAntAbuMel);

		/* USUARIOS */
		Usuario usuTriAnt = new Usuario(EstadoAnimo.TRISTE, canalesTodos, pelisTriAnt, true, 60f);
		Usuario usuConAnt = new Usuario(EstadoAnimo.CONTENTO, canalUno, pelisConAnt, true, 70f);
		Usuario usuMelAnt = new Usuario(EstadoAnimo.MELANCOLICO, new ArrayList<CanalesComunicacion>(), pelisMel, true, 80f);
		Usuario usuTriNue = new Usuario(EstadoAnimo.TRISTE, canalesTodos, pelisTriNue, false, 40f);
		Usuario usuConNue = new Usuario(EstadoAnimo.CONTENTO, canalUno, pelisConNue, false, 35f);
		Usuario usuMelNue = new Usuario(EstadoAnimo.MELANCOLICO, new ArrayList<CanalesComunicacion>(), pelisMel, true, 65.5f);
		listaUsuariosAll.add(usuTriAnt);
		listaUsuariosAll.add(usuConAnt);
		listaUsuariosAll.add(usuMelAnt);
		listaUsuariosAll.add(usuTriNue);
		listaUsuariosAll.add(usuConNue);
		listaUsuariosAll.add(usuMelNue);

		// TEST ANTIGUO
		usuarioAntiguo = new Usuario(EstadoAnimo.CONTENTO, canalUno, pelisConAnt, true, 70f);
		usuarioNuevo = new Usuario(EstadoAnimo.TRISTE, canalesTodos, pelisTriNue, false, 40f);

		// TEST INTERESANTE
		prodsInte = new ArrayList<Producto>();
		prodsInte.add(peliAntInt);
		prodsInte.add(serieNueInt);
		prodsInte.add(docuNueAbu);
		prodsNoInte = new ArrayList<Producto>();
		prodsNoInte.add(peliAntAbuTri);
		prodsNoInte.add(serieAntAbu);
		prodsNoInte.add(peliNueAbu);
		usuarioInteresante = new Usuario(EstadoAnimo.MELANCOLICO, new ArrayList<CanalesComunicacion>(), prodsInte, true, 60f);
		usuarioNoInteresante = new Usuario(EstadoAnimo.CONTENTO, canalesTodos, prodsNoInte, false, 45f);

		// TEST COBRO
		plan = new Plan(55.5f);
		usuarioCobrable = new Usuario(EstadoAnimo.TRISTE, canalesTodos, pelisMel, true, 80f);
		usuarioNoCobrable = new Usuario(EstadoAnimo.MELANCOLICO, new ArrayList<CanalesComunicacion>(), pelisConNue, false, 35f);

		// TEST RECOMENDAR
		usuarioTriste = new Usuario(EstadoAnimo.TRISTE, canalesTodos, pelisTriAnt, true, 60f);
		usuarioContento = new Usuario(EstadoAnimo.CONTENTO, canalUno, pelisConAnt, true, 70f);
		Producto otraPeliAntAbuMel = new Producto(19L, "OTRA PELÍCULA ANTIGUA Y ABURRIDA (MELANCÓLICA)", new GregorianCalendar(2005, Calendar.JULY, 29).getTime(), TipoProducto.PELICULA, 0,
				115, null);
		listaProductosAll.add(otraPeliAntAbuMel);
		usuarioMelancolico = new Usuario(EstadoAnimo.MELANCOLICO, new ArrayList<CanalesComunicacion>(), pelisMel, true, 80f);
	}

	@Test
	public void clienteAntiguo() {
		Assert.assertTrue(usuarioAntiguo.esAntiguo());
	}

	@Test
	public void clienteNoAntiguo() {
		Assert.assertFalse(usuarioNuevo.esAntiguo());
	}

	@Test
	public void clienteMiraInteresante() {
		// AL MENOS UN PRODUCTO ES INTERESANTE.
		Assert.assertTrue(usuarioInteresante.miraInteresante());
	}

	@Test
	public void clienteNoMiraInteresante() {
		// NINGUNO DE SUS PRODUCTOS ES INTERESANTE.
		Assert.assertFalse(usuarioNoInteresante.miraInteresante());
	}

	@Test
	public void efectuarCobro() {
		Assert.assertTrue(CobroController.cobrar(usuarioCobrable, plan));
	}

	@Test
	public void noEfectuarCobro() {
		Assert.assertFalse(CobroController.cobrar(usuarioNoCobrable, plan));
	}

	@Test
	public void recomendarTriste() {
		List<Producto> listaTriste = RecomendacionController.recomendar(usuarioTriste, listaProductosAll);
		StringUtil.mostrarPorConsola("PELÍCULAS TRISTE", listaTriste);
		Assert.assertTrue(!listaTriste.isEmpty());
	}

	@Test
	public void recomendarContento() {
		List<Producto> listaContento = RecomendacionController.recomendar(usuarioContento, listaProductosAll);
		StringUtil.mostrarPorConsola("PELÍCULAS CONTENTO", listaContento);
		Assert.assertTrue(!listaContento.isEmpty());
	}

	@Test
	public void recomendarMelancolico() {
		List<Producto> listaMelancolico = RecomendacionController.recomendar(usuarioMelancolico, listaProductosAll);
		StringUtil.mostrarPorConsola("PELÍCULAS MELANCÓLICO", listaMelancolico);
		Assert.assertTrue(!listaMelancolico.isEmpty());
	}
}