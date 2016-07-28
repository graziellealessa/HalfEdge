
public class Vertex {
	int id, coordX, coordY, edge;

	public Vertex(int id, int coordX, int coordY, int edge) {
		super();
		this.id = id;
		this.coordX = coordX;
		this.coordY = coordY;
		this.edge = edge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public int getEdge() {
		return edge;
	}

	public void setEdge(int edge) {
		this.edge = edge;
	}
	
}
