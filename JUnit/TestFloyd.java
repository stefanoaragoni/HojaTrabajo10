import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestFloyd {

	@Test
	void test() {
		Matriz graph = new Matriz();
		graph.add("Guatemala", "Mixco", "5");
		graph.add("Guatemala", "Antigua", "1");
		graph.add("Antigua", "Mixco", "1");
		
		graph.Floyd();
		
		//PRUEBA DE ALGORITMO DE FLOYD, METODO DE AGREGAR NODO (ADD) Y METODO DE ARCOS (DISTANCIA)
		
		//De guatemala a mixco, hay 5km directos. Sin embargo, la ruta mas corta es guatemala->antigua->mixco con 2km. 
		//El algortimo de floyd detecta eso.
		assertEquals(2,graph.distance("Guatemala", "Mixco"));
	}

}
