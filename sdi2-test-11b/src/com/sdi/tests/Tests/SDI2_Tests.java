package com.sdi.tests.Tests;
import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.sdi.tests.pageobjects.PO_AltaForm;
import com.sdi.tests.utils.SeleniumUtils;

//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class SDI2_Tests {

	WebDriver driver; 
	List<WebElement> elementos = null;


	public SDI2_Tests()
	{
	}

	@Before
	public void run()
	{
		//Creamos el driver para Firefox. Recomendable usar Firefox.
		driver = new FirefoxDriver();
		//Vamos a la página principal de mi aplicación
		driver.get("http://localhost:8280/sdi2-11b/");			
	}
	@After
	public void end()
	{
		//Cerramos el navegador
		driver.quit();
	}

	//PRUEBAS

	//	1. [RegVal] Registro de Usuario con datos válidos.
	@Test	
	public void t01_RegVal() throws InterruptedException {
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_registrarse", 25); 
		driver.findElement(By.id("form-cuerpo:p_registrarse")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:login", 25); 
		new PO_AltaForm().rellenaRegistroUsuario(driver, "usuario4", "Alfredo", "Santos", "user4@mail.com", "usuario4", "usuario4");
		driver.findElement(By.id("form-cuerpo:boton")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:username", 25);
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario4", "usuario4");
		Thread.sleep(1000);

	}
	//	2. [RegInval] Registro de Usuario con datos inválidos (contraseñas diferentes).
	@Test
	public void t02_RegInval() throws InterruptedException { 
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_registrarse", 25); 
		driver.findElement(By.id("form-cuerpo:p_registrarse")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:login", 25); 
		new PO_AltaForm().rellenaRegistroUsuario(driver, "usuario5", "Alfredo", "Santos", "user4@mail.com", "aaaaaaa", "bbbbbbb");
		driver.findElement(By.id("form-cuerpo:boton")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "msjgral", 25);
		Thread.sleep(1000);
	}
	//	3. [IdVal] Identificación de Usuario registrado con datos válidos.
	@Test
	public void t03_IdVal() throws InterruptedException { 
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:username", 25);
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario1", "usuario1");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:saludo", 25); 
		Thread.sleep(1000);
	}
	//	4. [IdInval] Identificación de usuario registrado con datos inválidos.
	@Test
	public void t04_IdInval() throws InterruptedException {
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:username", 25);
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario1", "usuario2");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:msjgral", 25);    	//Comprueba que se carga el cuadro en el que se muestra el mensaje de error
		Thread.sleep(1000);
	}
	//	5. [AccInval] Intento de acceso con URL desde un usuario no público (no identificado). Intento de
	//	acceso a vistas de acceso privado.
	@Test
	public void t05_AccInval() throws InterruptedException {
		driver.get("http://localhost:8280/sdi2-11/private/misViajes");
		Thread.sleep(1000);
	}
//	//	6. [RegViajeVal] Registro de un viaje nuevo con datos válidos.
	@Test
	public void t06_RegViajeVal() throws InterruptedException{
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario4", "usuario4");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_nuevoViaje", 25);
		driver.findElement(By.id("form-cuerpo:p_nuevoViaje")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:boton", 25);
		driver.findElement(By.cssSelector("div.ui-inputswitch-off > span")).click();
		Thread.sleep(1000);
	    driver.findElement(By.id("form-cuerpo:boton")).click();
	    Thread.sleep(1000);
    }
	//	7. [RegViajeInVal] Registro de un viaje nuevo con datos inválidos.
	@Test
	public void t07_RegViajeInval() throws InterruptedException{
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario1", "usuario1");
    	SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_nuevoViaje", 25);
    	driver.findElement(By.id("form-cuerpo:p_nuevoViaje")).click();
    	SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:boton", 25);
    	driver.findElement(By.cssSelector("div.ui-inputswitch-off > span")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.id("form-cuerpo:plazasDispoibles")).clear();
        driver.findElement(By.id("form-cuerpo:plazasDispoibles")).sendKeys("6");
        driver.findElement(By.id("form-cuerpo:plazasMaximas")).clear();
        driver.findElement(By.id("form-cuerpo:plazasMaximas")).sendKeys("2");
        driver.findElement(By.id("form-cuerpo:boton")).click();
        SeleniumUtils.EsperaCargaPagina(driver, "id", "msjgral", 25);
        Thread.sleep(1000);
	}
	//	8. [EditViajeVal] Edición de viaje existente con datos válidos.
	@Test
	public void t08_EditViajeVal() throws InterruptedException {
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario2", "usuario2");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_misViajes", 25);
		driver.findElement(By.id("form-cuerpo:p_misViajes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:viajesPorHacer:7", 25);
		driver.findElement(By.id("form-cuerpo:viajesPorHacer:7:botonModificar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:plazasDispoibles", 25);
		driver.findElement(By.id("form-cuerpo:plazasDispoibles")).clear();
		driver.findElement(By.id("form-cuerpo:plazasDispoibles")).sendKeys("3");
		Thread.sleep(1000);
		driver.findElement(By.id("form-cuerpo:boton")).click();
		Thread.sleep(1000);
	}
	//	9. [EditViajeInVal] Edición de viaje existente con datos inválidos.
	@Test
	public void t09_EditViajeInVal() throws InterruptedException {
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario2", "usuario2");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_misViajes", 25);
		driver.findElement(By.id("form-cuerpo:p_misViajes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:viajesPorHacer:7", 25);
		driver.findElement(By.id("form-cuerpo:viajesPorHacer:7:botonModificar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:plazasDispoibles", 25);
		driver.findElement(By.id("form-cuerpo:plazasDispoibles")).clear();
		driver.findElement(By.id("form-cuerpo:plazasDispoibles")).sendKeys("9");
		driver.findElement(By.id("form-cuerpo:boton")).click();
		Thread.sleep(2000);
	}
	//	10. [CancelViajeVal] Cancelación de un viaje existente por un promotor.
	@Test
	public void t10_CancelViajeVal() throws InterruptedException { //FUNCIONA
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario2", "usuario2");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:travelMenu", 25);
		driver.findElement(By.id("form-cuerpo:p_misViajes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:viajesPorHacer", 25);
		driver.findElement(By.id("form-cuerpo:viajesPorHacer:6:botonCancelar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:viajesCerrados", 25);
		Thread.sleep(2000);
	}
	//	11. [CancelMulViajeVal] Cancelación de múltiples viajes existentes por un promotor.
	@Test
	public void t11_CancelMulViajeVal() throws InterruptedException {
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario3", "usuario3");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_misViajes", 25);
		driver.findElement(By.id("form-cuerpo:p_misViajes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:viajesCerrados", 25);
		driver.findElement(By.xpath("//tbody[@id='form-cuerpo:viajesPorHacer_data']/tr/td/div/div[2]/span")).click();
		driver.findElement(By.xpath("//tbody[@id='form-cuerpo:viajesPorHacer_data']/tr[2]/td/div/div[2]/span")).click();
		driver.findElement(By.id("form-cuerpo:botonCancelarVarios")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:viajesCerrados", 25);
		Thread.sleep(3000);
		driver.findElement(By.id("form-cuerpo:p_volver")).click();
	}
	//	12. [Ins1ViajeAceptVal] Inscribir en un viaje un solo usuario y ser admitido por el promotor.
	@Test
	public void t12_Ins1ViajeAceptVal()  throws InterruptedException{
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario1", "usuario1");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_lvRegistrado", 25);
		driver.findElement(By.id("form-cuerpo:p_lvRegistrado")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablalistado:0:botonSolicitar", 25);
		driver.findElement(By.id("form-cuerpo:tablalistado:0:botonSolicitar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "msjgral", 10);
		driver.findElement(By.id("form-cuerpo:p_volver")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_cerrarSesion", 25);
		driver.findElement(By.id("form-cuerpo:p_cerrarSesion")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:boton", 25);
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario2", "usuario2");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_misViajes", 25);
		driver.findElement(By.id("form-cuerpo:p_misViajes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:viajesPorHacer:0:botonVerSolicitudes", 25);
		driver.findElement(By.id("form-cuerpo:viajesPorHacer:0:botonVerSolicitudes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablaApps:0:AppAceptar", 25);
		driver.findElement(By.id("form-cuerpo:tablaApps:0:AppAceptar")).click();
		Thread.sleep(3000);
	}
	//	13. [Ins2ViajeAceptVal] Inscribir en un viaje dos usuarios y ser admitidos los dos por el promotor.
	@Test
	public void t13_Ins2ViajeAceptVal() throws InterruptedException{
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario2", "usuario2");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_lvRegistrado", 25);
		driver.findElement(By.id("form-cuerpo:p_lvRegistrado")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablalistado:3:botonSolicitar", 25);
		driver.findElement(By.id("form-cuerpo:tablalistado:3:botonSolicitar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "msjgral", 10);
		driver.findElement(By.id("form-cuerpo:p_volver")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_cerrarSesion", 25);
		driver.findElement(By.id("form-cuerpo:p_cerrarSesion")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:boton", 25);
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario3", "usuario3");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_lvRegistrado", 25);
		driver.findElement(By.id("form-cuerpo:p_lvRegistrado")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablalistado:3:botonSolicitar", 25);
		driver.findElement(By.id("form-cuerpo:tablalistado:3:botonSolicitar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "msjgral", 10);
		driver.findElement(By.id("form-cuerpo:p_volver")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_cerrarSesion", 25);
		driver.findElement(By.id("form-cuerpo:p_cerrarSesion")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:boton", 25);
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario1", "usuario1");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_misViajes", 25);
		driver.findElement(By.id("form-cuerpo:p_misViajes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:viajesPorHacer:3:botonVerSolicitudes", 25);
		driver.findElement(By.id("form-cuerpo:viajesPorHacer:3:botonVerSolicitudes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablaApps:0:AppAceptar", 25);
		driver.findElement(By.id("form-cuerpo:tablaApps:0:AppAceptar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "msjgral", 25);
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablaApps:0:AppAceptar", 25);
		driver.findElement(By.id("form-cuerpo:tablaApps:0:AppAceptar")).click();
		Thread.sleep(3000);
	}
	//	14. [Ins3ViajeAceptInval] Inscribir en un viaje (2 plazas máximo) dos usuarios y ser admitidos los dos y
	//	que un tercero intente inscribirse en ese mismo viaje pero ya no pueda por falta de plazas.
	@Test
	public void t14_Ins3ViajeAceptInval() throws InterruptedException{
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario2", "usuario2");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_lvRegistrado", 25);
		driver.findElement(By.id("form-cuerpo:p_lvRegistrado")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablalistado:1:botonSolicitar", 25);
		driver.findElement(By.id("form-cuerpo:tablalistado:1:botonSolicitar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "msjgral", 10);
		driver.findElement(By.id("form-cuerpo:p_volver")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_cerrarSesion", 25);
		driver.findElement(By.id("form-cuerpo:p_cerrarSesion")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:boton", 25);
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario3", "usuario3");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_lvRegistrado", 25);
		driver.findElement(By.id("form-cuerpo:p_lvRegistrado")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablalistado:1:botonSolicitar", 25);
		driver.findElement(By.id("form-cuerpo:tablalistado:1:botonSolicitar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "msjgral", 10);
		driver.findElement(By.id("form-cuerpo:p_volver")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_cerrarSesion", 25);
		driver.findElement(By.id("form-cuerpo:p_cerrarSesion")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:boton", 25);
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario1", "usuario1");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_misViajes", 25);
		driver.findElement(By.id("form-cuerpo:p_misViajes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:viajesPorHacer:1:botonVerSolicitudes", 25);
		driver.findElement(By.id("form-cuerpo:viajesPorHacer:1:botonVerSolicitudes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablaApps:0:AppAceptar", 25);
		driver.findElement(By.id("form-cuerpo:tablaApps:0:AppAceptar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "msjgral", 25);
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablaApps:0:AppAceptar", 25);
		driver.findElement(By.id("form-cuerpo:tablaApps:0:AppAceptar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablaSeats:1", 25);
		//Thread.sleep(1000);
		driver.findElement(By.id("form-cuerpo:p_volver")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:viajesPorHacer", 25);
		driver.findElement(By.id("form-cuerpo:p_volver")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_cerrarSesion", 25);
	    driver.findElement(By.id("form-cuerpo:p_cerrarSesion")).click();
	    SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:boton", 25);
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario4", "usuario4");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_lvRegistrado", 25);
		driver.findElement(By.id("form-cuerpo:p_lvRegistrado")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablalistado:1:botonSolicitar", 25);
		Thread.sleep(2000);
	}
	//	15. [CancelNoPromotorVal] Un usuario no promotor Cancela plaza.
	@Test
	public void t15_CancelNoPromotorVal() throws InterruptedException {
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario1", "usuario1");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_misSolicitudes", 25);
		driver.findElement(By.id("form-cuerpo:p_misSolicitudes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablaPendientes:0:botonAnular", 25);
		driver.findElement(By.id("form-cuerpo:tablaPendientes:0:botonAnular")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("form-cuerpo:p_volver")).click();
	}
	//	16. [Rech1ViajeVal] Inscribir en un viaje un usuario que será admitido y después rechazarlo por el
	//	promotor.
	@Test
	public void t16_Rech1ViajeVal() throws InterruptedException {
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario1", "usuario1");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_lvRegistrado", 25);
		driver.findElement(By.id("form-cuerpo:p_lvRegistrado")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablalistado:0:botonSolicitar", 25);
		driver.findElement(By.id("form-cuerpo:tablalistado:0:botonSolicitar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "msjgral", 10);
		driver.findElement(By.id("form-cuerpo:p_volver")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_cerrarSesion", 25);
		driver.findElement(By.id("form-cuerpo:p_cerrarSesion")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:boton", 25);
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario2", "usuario2");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_misViajes", 25);
		driver.findElement(By.id("form-cuerpo:p_misViajes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:viajesPorHacer:1:botonVerSolicitudes", 25);
		driver.findElement(By.id("form-cuerpo:viajesPorHacer:1:botonVerSolicitudes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablaApps:0:AppAceptar", 25);
		driver.findElement(By.id("form-cuerpo:tablaApps:0:AppAceptar")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:tablaSeats:0:seatCambiar", 25);
		driver.findElement(By.id("form-cuerpo:tablaSeats:0:seatCambiar")).click();
		Thread.sleep(3000);
	}
	//	17. [i18N1] Cambio del idioma por defecto a un segundo idioma. (Probar algunas vistas)
	@Test
	public void t17_i18N1() throws InterruptedException {
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:username", 25);
		SeleniumUtils.ClickSubopcionMenuHover(driver, "form-cabecera:idiomas", "form-cabecera:ingles");
		Thread.sleep(500);
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario3", "usuario3");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:userMenu", 25);
		SeleniumUtils.ClickSubopcionMenuHover(driver, "form-cabecera:idiomas", "form-cabecera:español");
		Thread.sleep(1000);

	}
	//	18. [i18N2] Cambio del idioma por defecto a un segundo idioma y vuelta al idioma por defecto. (Probar
	//	algunas vistas)
	@Test
	public void t18_i18N2() throws InterruptedException {
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:username", 25);
		SeleniumUtils.ClickSubopcionMenuHover(driver, "form-cabecera:idiomas", "form-cabecera:ingles");
		Thread.sleep(500);
		SeleniumUtils.ClickSubopcionMenuHover(driver, "form-cabecera:idiomas", "form-cabecera:español");
		Thread.sleep(500);
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario3", "usuario3");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:userMenu", 25);
		SeleniumUtils.ClickSubopcionMenuHover(driver, "form-cabecera:idiomas", "form-cabecera:ingles");
		Thread.sleep(500);
		SeleniumUtils.ClickSubopcionMenuHover(driver, "form-cabecera:idiomas", "form-cabecera:español");
		Thread.sleep(500);
	}
	//	19. [OpFiltrado] Prueba para el filtrado opcional.
	//	20. [OpOrden] Prueba para la ordenación opcional.
	@Test
	public void t20_OpOrden() throws InterruptedException{
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario1", "usuario1");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_misViajes", 25);
		driver.findElement(By.id("form-cuerpo:p_misViajes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id","form-cuerpo:viajesPorHacer:ciudadSalida" , 25);
		driver.findElement(By.id("form-cuerpo:viajesPorHacer:ciudadSalida")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("form-cuerpo:viajesPorHacer:ciudadLlegada")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("form-cuerpo:viajesPorHacer:fechaCierre")).click();
		Thread.sleep(3000);
		
	}
	
	//	21. [OpPag] Prueba para la paginación opcional.
	@Test
	public void t21_OpPag() throws InterruptedException{
		new PO_AltaForm().rellenaFormularioLogIn(driver, "usuario1", "usuario1");
		SeleniumUtils.EsperaCargaPagina(driver, "id", "form-cuerpo:p_misViajes", 25);
		driver.findElement(By.id("form-cuerpo:p_misViajes")).click();
		SeleniumUtils.EsperaCargaPagina(driver, "id","form-cuerpo:viajesPorHacer_rppDD" , 25);
		new Select(driver.findElement(By.id("form-cuerpo:viajesPorHacer_rppDD"))).selectByVisibleText("5");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//option[@value='5'])[2]")).click();
		Thread.sleep(1000);
	}
	//	22. [OpMante] Prueba del mantenimiento programado opcional.
}