package advance.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class Vertex {
	String label;

	public Vertex(String label) {
		this.label = label;
	}

	public String getVertex() {
		return label;
	}

	public void setVertex(String vertex) {
		this.label = vertex;
	}
}

class Edge {
	Vertex source;
	Vertex desination;
	int weight;

	public Edge(Vertex source, Vertex desination, int weight) {
		this.source = source;
		this.desination = desination;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return this.desination.label + "(" + this.weight + ")";
	}
}

public class Graph {

	private Map<Vertex, List<Edge>> map;

	public Graph() {
		this.map = new HashMap<>();
	}

	public Vertex addVertex(String label) {
		Vertex newVertex = new Vertex(label);
		map.put(newVertex, new ArrayList<Edge>());
		return newVertex;
	}

	public void addEdge(String source, String desination, int weight) {
		for (Vertex key : map.keySet()) {
			if (key.label == source) {
				map.get(key).add(0, new Edge(new Vertex(source), new Vertex(desination), weight));
				break;
			}
		}
	}

	public void printGraph(Graph obj) {
		map.forEach((K, V) -> System.out.println(K.label + " Outgoing paths : " + V.toString()));
	}

	public void bfs(Graph graph, String vertex) {

	}

	public void dfs(Graph graph, Vertex vertex) {
		System.out.print(vertex.label + " ");
		Optional<List<Edge>> edgesOptional = Optional.ofNullable(graph.map.get(vertex));
		if (edgesOptional.isPresent())
			for (Edge edge : edgesOptional.get())
				dfs(graph, edge.desination);
	}

	public void motherVertex() {

	}

	public void topologicalSort(Graph graph) {

	}

}
