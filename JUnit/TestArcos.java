import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestArcos {

	@Test
	void test() {
		Matriz graph = new Matriz();
		
		graph.add("Guatemala", "Mixco", "5");
		
		//PRUEBA METODO ARCOS (VERIFICA SI EL ARCO SE ALMACENA CORRECTAMENTE)
		
		assertEquals(5,graph.distance("Guatemala", "Mixco"));
	}

}
