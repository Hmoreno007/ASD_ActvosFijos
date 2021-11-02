package com.asd.activosfijos;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;

import java.sql.Timestamp;
import java.util.List;

import com.asd.activosfijos.dto.ResponseDTO;
import com.asd.activosfijos.models.ActivosFijosModel;
import com.asd.activosfijos.services.ActivosFijosService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ActivosfijosApplicationTests {

	ActivosFijosService activosFijosService;

	@Test
	void contextServiceObtenerActivos() {		
		try {
			ResponseDTO<List<ActivosFijosModel>> activos = activosFijosService.obtenerActivosFijos();
			assertTrue(activos.getResult().size() > 0, "No se encuentran registros");
			for (ActivosFijosModel activo : activos.getResult()) {
				System.out.println(""+activo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void contextServiceObtenerActivosFiltro() {		
		try {
			ResponseDTO<List<ActivosFijosModel>> activos = activosFijosService.obtenerActivosFijosFiltro("ArtOficina", new Timestamp(2021-10-31), "019999");
			assertTrue(activos.getResult().size() > 0, "No se encuentran registros");
			for (ActivosFijosModel activo : activos.getResult()) {
				System.out.println(""+activo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void contextServiceGuardaActivosFijos() {		
		try {
			ActivosFijosModel activoDummy = new ActivosFijosModel(); 
			activoDummy.setActivoNombre("Monitor");
			activoDummy.setDescripcion("descripcion");
			activoDummy.setTipo("tipo");
			activoDummy.setActivoSerial("0123456");
			activoDummy.setNumIntInventario("numIntInventario");
			double diemnsiones = anyDouble();
			activoDummy.setPeso(diemnsiones);
			activoDummy.setAlto(diemnsiones);
			activoDummy.setAncho(diemnsiones);
			activoDummy.setLargo(diemnsiones);
			activoDummy.setValorCompra(1200200);
			activoDummy.setEstado("A");
			activoDummy.setFechaHoraCompra(new Timestamp(2021-10-31));
			activoDummy.setFechaHoraCrea(new Timestamp(2021-10-31));
			activoDummy.setFechaHoraModifica(new Timestamp(2021-10-31));
			ResponseDTO<ActivosFijosModel> activos = activosFijosService.guardActivosFijosModel(activoDummy);
			assertTrue(activos.getResult().equals(null), "No se encuentran registros");	
		    System.out.println(""+activos);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void contextServiceActualizaActivosFijos() {		
		try {
			ActivosFijosModel activoDummy = new ActivosFijosModel(); 
			Long id = anyLong();
			activoDummy.setId(id);
			activoDummy.setActivoNombre("Monitor");
			activoDummy.setDescripcion("descripcion");
			activoDummy.setTipo("tipo");
			activoDummy.setActivoSerial("0123456");
			activoDummy.setNumIntInventario("numIntInventario");
			double diemnsiones = anyDouble();
			activoDummy.setPeso(diemnsiones);
			activoDummy.setAlto(diemnsiones);
			activoDummy.setAncho(diemnsiones);
			activoDummy.setLargo(diemnsiones);
			activoDummy.setValorCompra(1200200);
			activoDummy.setEstado("A");
			activoDummy.setFechaHoraCompra(new Timestamp(2021-10-31));
			activoDummy.setFechaHoraCrea(new Timestamp(2021-10-31));
			activoDummy.setFechaHoraModifica(new Timestamp(2021-10-31));
			ResponseDTO<ActivosFijosModel> activos = activosFijosService.guardActivosFijosModel(activoDummy);
			assertTrue(activos.getResult().equals(null), "No se encuentran registros");	
		    System.out.println(""+activos);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
