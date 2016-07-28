import java.io.*;
import java.util.ArrayList;


public class Parser {
	
	public ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
	public ArrayList<Face> faceList = new ArrayList<Face>();
	public ArrayList<HalfEdge> hedgeList = new ArrayList<HalfEdge>();

	
	public void parseFile(String filename){
		boolean isvertex = false;
		boolean isface = false;
		boolean isedge = false;
		File f = new File(filename);
		String line = null;
		try {	
			BufferedReader reader = new BufferedReader(new FileReader(f));
			line = reader.readLine();
			while(line!=null){
				if((line.charAt(0)=='#') && (line.equals("#VERTEX"))){
					isvertex=true;
					isface=false;
					isedge=false;
				}
				if((line.charAt(0)=='#') && (line.equals("#FACE"))){
					isvertex=false;
					isface=true;
					isedge=false;
				}
				if((line.charAt(0)=='#') && (line.equals("#EDGE"))){
					isvertex=false;
					isface=false;
					isedge=true;
				}
				if((isvertex==true)&&(line.charAt(0)!='#')){
					//System.out.println("vertex in");
					addVertex(line);
				}
				if((isface==true)&&(line.charAt(0)!='#')){
					//System.out.println("face in");
					System.out.println(line);
					addFace(line);
				}
				if((isedge==true)&&(line.charAt(0)!='#')){
					//System.out.println("h-edge in");
					addEdge(line);
				}
				
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(line);
		//System.out.println(f.getAbsolutePath());
	}
	
	private void addEdge(String line) {
		line=line.trim();
		int i, n, t, o, f;
		String [] result;
		result=line.split(":");
		i = Integer.parseInt(result[0])-1;
		n = Integer.parseInt(result[1])-1;
		t= Integer.parseInt(result[2])-1;
		o = Integer.parseInt(result[4])-1;
		f = Integer.parseInt(result[3])-1;
		
		hedgeList.add(new HalfEdge(i, n, t, o, f));
	}

	private void addFace(String line) {
		line=line.trim();
		int i, e;
		String [] result;
		result=line.split(":");
		i = Integer.parseInt(result[0])-1;
		e = Integer.parseInt(result[1])-1;
		faceList.add(new Face(i, e));
		
	}

	private void addVertex(String line){
		line=line.trim();
		int i, x, y, e;
		String [] result;
		result=line.split(":");
		i = Integer.parseInt(result[0])-1;
		x = Integer.parseInt(result[1]);
		y= Integer.parseInt(result[2]);
		e = Integer.parseInt(result[3])-1;
		vertexList.add(new Vertex(i, x, y, e));
	}
	
}

