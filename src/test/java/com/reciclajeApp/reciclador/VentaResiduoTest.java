package com.reciclajeApp.reciclador;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.reciclajeApp.domain.Estadoventa;
import com.reciclajeApp.domain.Tiporesiduo;
import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.service.AplicantesofertasService;
import com.reciclajeApp.service.EstadoventaService;
import com.reciclajeApp.service.TiporesiduoService;
import com.reciclajeApp.service.UsuarioService;
import com.reciclajeApp.service.VentaService;
import com.reciclajeApp.service.VisitarecicladoresService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class VentaResiduoTest {

	private final static Logger log = LoggerFactory.getLogger(VentaResiduoTest.class);

	@Autowired
	VentaService ventaService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	TiporesiduoService tipoResiduoService;

	@Autowired
	EstadoventaService estadoventaService;
	
	@Autowired
	VisitarecicladoresService visitaRecicladorService;

	@Test
	@Order(1)
	void nuevaVenta() throws Exception {

		Double cantidad = 2.5;

		Usuario vendedor = usuarioService.findById("jcss1462@gmail.com").get();
		Tiporesiduo tipoResiduoOpt = tipoResiduoService.findById(1).get();
		// coloco la nueva venta como disponible
		Estadoventa estadoVenta = estadoventaService.findById(1).get();
		Venta nuevaVenta = new Venta();
		Date fechaActual = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());

		nuevaVenta.setUsuario(vendedor);
		nuevaVenta.setPeso(cantidad);
		nuevaVenta.setEstadoventa(estadoVenta);
		nuevaVenta.setTiporesiduo(tipoResiduoOpt);
		nuevaVenta.setTotal(cantidad + tipoResiduoOpt.getPrecio());
		nuevaVenta.setFechaventa(fechaActual);

		nuevaVenta = ventaService.save(nuevaVenta);

	}

	@Test
	@Order(2)
	@Transactional
	void updateVenta() throws Exception {

		// obtengo la venta
		Venta venta = ventaService.findById(34).get();

		// obtengo el nuevo estado
		Estadoventa estadoVenta = estadoventaService.findById(3).get();

		// cambio los valores
		Double precio=venta.getTiporesiduo().getPrecio();
		venta.setEstadoventa(estadoVenta);
		venta.setTotal(precio * 34.33);

		// actualizo la venta
		venta = ventaService.update(venta);
	}
	
	
	@Test
	@Order(3)
	@Transactional
	void listarAplicacionesByVenta() throws Exception {
		visitaRecicladorService.visitasByVentas(21);
	}
	
	
	@Test
	@Order(4)
	@Transactional
	void ventasVendidas() throws Exception {
		ventaService.findVentasVendidasByReciclador("jcss1462@gmail.com");
	}

}
