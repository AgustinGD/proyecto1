package project;

/**
 * Se testea la generacion de logs de la clase Graph.
 * @author Agustin Emanuel Gonzalez Diaz.
 */
public class Tester 
{

	public static void main(String[] args)
	{
		test1();
	}
	
	public static void test1()
	{
		Graph grafo = new Graph(50);
		
		// Mostrando logs a nivel FINE
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addNode(4);
		grafo.addNode(5);
		
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 4);
		grafo.addEdge(4, 5);
		
		// Mostrando logs a nivel INFO
		grafo.removeEdge(4, 5);
		grafo.removeEdge(3, 4);
		
		grafo.removeNode(3);
		grafo.removeNode(4);
		grafo.removeNode(5);
		
		// Mostrando logs a nivel WARNING
		grafo.removeEdge(4, 5);
		grafo.removeEdge(3, 4);
		grafo.removeEdge(2, 1);
		grafo.removeEdge(6, 7);
		
		grafo.removeNode(3);
		grafo.removeNode(4);
		grafo.removeNode(5);
		grafo.removeNode(69);
		grafo.removeNode(420);
		grafo.removeNode(911);
	}
}
