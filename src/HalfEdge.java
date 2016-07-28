
public class HalfEdge {
	private int id;
	private int next;
	private int twin;
	private int origin;
	private int face;
	public HalfEdge(int id, int next, int twin, int origin, int face) {
		super();
		this.id = id;
		this.next = next;
		this.twin = twin;
		this.origin = origin;
		this.face = face;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getTwin() {
		return twin;
	}
	public void setTwin(int twin) {
		this.twin = twin;
	}
	public int getOrigin() {
		return origin;
	}
	public void setOrigin(int origin) {
		this.origin = origin;
	}
	public int getFace() {
		return face;
	}
	public void setFace(int face) {
		this.face = face;
	}
	
}
