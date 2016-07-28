
import java.util.ArrayList;


public class MainFunction {
	
	public static ArrayList<Vertex> vertexList;
	public static ArrayList<Face> faceList;
	public static ArrayList<HalfEdge> halfedgeList;
	public static void main(String[] args) {
		Parser p = new Parser();
		p.parseFile("Files/input.txt");
		vertexList=p.vertexList;
		faceList=p.faceList;
		halfedgeList=p.hedgeList;
		DrawPanel drawer= new DrawPanel(vertexList, faceList, halfedgeList);
		drawer.draw();
		
//		for (int i = 0; i < halfedgeList.size(); i++) {
//			System.out.println("edge " + halfedgeList.get(i).getOrigin());
//		}
//		for (int i = 0; i < vertexList.size(); i++) {
//			System.out.println("vertex " + vertexList.get(i).id);
//		}
//		for (int i = 0; i < faceList.size(); i++) {
//			System.out.println("face " + faceList.get(i).id);
//		}
	}
}
