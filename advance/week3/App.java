package advance.week3;

public class App {

	public static void main(String[] args) {
		Graph graph = new Graph();
		Vertex root = graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addEdge("A", "D", 8);
		graph.addEdge("B", "C", 11);
		graph.addEdge("D", "B", 9);
		graph.addEdge("E", "D", 6);
		graph.addEdge("E", "F", 4);
		graph.printGraph(graph);
		graph.dfs(graph, root);
		
	}

}
