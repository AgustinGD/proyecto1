package project;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementacion de un Grafo dirigido no pesado con matriz de adyacencia.
 * @author Agustin Emanuel Gonzalez Diaz.
 */
public class Graph
{
	// Atributos de instancia
	private boolean[] nodos;
	private boolean[][] arcos;
	private static Logger logger;
	
	// Constructor	
	/**
	 * Inicializa el grafo con espacio para n nodos y una matriz nxn.
	 * El primer nodo es el 0;
	 * @param n cantidad de nodos
	 */
	public Graph(int n)
	{
		nodos = new boolean[n];
		arcos = new boolean[n][n];
		
		if (logger == null)
		{
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();			
			hnd.setLevel(Level.FINEST);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.FINEST);
			
			// Para no mostrar los log de la raiz
			Logger logger_raiz = logger.getParent();			
			for(Handler h : logger_raiz.getHandlers())
			{
				h.setLevel(Level.OFF);
			}			
		}
	}
	
	// Metodos
	/**
	 * Agrega un nodo al grafo.
	 * @param node nodo que se quiere agregar.
	 */
	public void addNode(int node)
	{
		boolean check = check_node(node);
		
		if (check)
		{
			if(!nodos[node])
			{
				nodos[node] = true;				
				logger.fine("Se agregó correctamente el nodo "+ node);
			}
			else
			{
				logger.warning("El nodo "+ node +" ya existia en el grafo");
			}
		}
	}
	/**
	 * Agrega un arco con origen node1 y destino node2
	 * @param node1 nodo origen.
	 * @param node2 nodo destino.
	 */
	public void addEdge(int node1, int node2)
	{
		boolean check = check_node(node1) && check_node(node2) && existe(node1) && existe(node2);
		
		if(check)
		{
			if (!arcos[node1][node2])
			{
				arcos[node1][node2] = true;
				logger.fine("Se agregó correctamente un arco con origen el nodo "+ node1 +" y destino el nodo "+node2);
			}
			else
			{
				logger.warning("Ya existia un arco con origen el nodo "+ node1 +" y destino el nodo "+node2);
			}
		}
	}
	
	/**
	 * Remueve un nodo del grafo.
	 * @param node nodo que se quiere remover.
	 */
	public void removeNode(int node)
	{
		boolean check = check_node(node) && existe(node);
		
		if(check)
		{
			for(int i = 0; i < arcos.length; i++)
			{
				if (arcos[i][node])
				{
					arcos[i][node] = false;
				}
						
			}
			
			for(int j = 0; j < arcos.length; j++)
			{
				if (arcos[node][j])
				{
					arcos[node][j] = false;
				}
						
			}
			
			nodos[node] = false;
			logger.info("Se removió correctamente el nodo "+node);
		}
	}
	
	/**
	 * Remueve el arco con origen node1 y destino node2.
	 * @param node1 nodo origen.
	 * @param node2 nodo destino.
	 */
	public void removeEdge(int node1, int node2)
	{
		boolean check = check_node(node1) && check_node(node2) && existe(node1) && existe(node2);
		
		if (check)
		{
			if(arcos[node1][node2])
			{
				arcos[node1][node2] = false;
				logger.info("Se removió correctamente un arco con origen el nodo "+ node1 +" y destino el nodo "+node2);
			}
			else
			{
				logger.warning("No existia un arco con origen el nodo "+ node1 +" y destino el nodo "+node2);
			}
		}
	}
	/**
	 * determina si el nodo podria llegar a existir.
	 * @param node nodo que se quiere chequear.
	 * @return True si puede llegar a existir, False en caso contrario.
	 */
	private boolean check_node(int node)
	{
		boolean pertenece = node < nodos.length;
		
		if (!pertenece)
		{
			logger.warning("El nodo "+ node +" no es valido ya que solo existe hasta el nodo "+ (nodos.length - 1));
		}
		
		return pertenece;
	}
	
	/**
	 * determina si un nodo ya fue agregado.
	 * @param node nodo que se quiere chequear.
	 * @return True si esta ocupado, False caso contrario.
	 */
	private boolean existe(int node)
	{
		boolean existe = nodos[node];
		
		if(!existe)
		{
			logger.warning("No existe el nodo "+ node);
		}
		
		return existe;
	}
}
