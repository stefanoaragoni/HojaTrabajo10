import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCentro {

	@Test
	void test() {
		Matriz graph = new Matriz();
		graph.add("Mixco", "Antigua", "30");
		graph.add("Antigua", "Escuintla", "25");
		graph.add("Escuintla", "Santa-Lucia", "15");
		graph.add("Santa-Lucia", "Guatemala", "90");
		graph.add("Guatemala", "Mixco", "15");
		graph.add("Guatemala", "Antigua", "40");
		graph.add("Escuintla", "Guatemala", "70");
		
		graph.Floyd();
		
		//PRUEBA DE METODO DE CALCULAR EL CENTRO
		
		//tambien pone a prueba el metodo agregar y el algortimo de floyd
		
		graph.middle();
		
		assertEquals("Guatemala",graph.centro);
	}

}
