import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestNodos {

	@Test
	void test() {
		
		Matriz graph = new Matriz();
		graph.add("Guatemala", "Mixco", "5");
		
		//PRUEBA METODO DE AGREGAR NODO (ADD) Y METODO CONTAINS
		
		assertEquals(true,graph.contains("Guatemala", "Mixco"));
		
	}

}
