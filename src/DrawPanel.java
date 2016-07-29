import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;


public class DrawPanel {
	private ArrayList<Vertex> vertexList;
	private ArrayList<Face> faceList;
	private ArrayList<HalfEdge> halfedgeList;
	public DrawPanel(ArrayList<Vertex> vertexList, ArrayList<Face> faceList,
			ArrayList<HalfEdge> halfedgeList) {
		super();
		this.vertexList = vertexList;
		this.faceList = faceList;
		this.halfedgeList = halfedgeList;
	}
	public void draw(){
		StdDraw.setCanvasSize(1024, 800);
		StdDraw.setScale(-2, 13);
		StdDraw.show();
		StdDraw.clear();
		drawVertex();
		drawEdges();
		drawFaceNumbers();
	}
	private void drawVertex() {
		int x, y;
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int i = 0; i < vertexList.size(); i++) {
			x=vertexList.get(i).getCoordX();
			y=vertexList.get(i).getCoordY();
			StdDraw.filledCircle(x, y, 0.15);
		}
		
	}
	private void drawFaceNumbers() {
		//fun��o calcula o incentro dos triangulos e desenha o numero da face em verde
		StdDraw.setPenColor(StdDraw.GREEN);
		int firstedge, numberofvertex, nextedge;
		double centerx=0, centery=0;
		for (int i = 0; i < faceList.size()-1; i++) {
			numberofvertex=1;
			firstedge=faceList.get(i).getEdge();
			nextedge=halfedgeList.get(firstedge).getNext();
			while(nextedge!=firstedge){
				numberofvertex++;
				centerx=centerx+vertexList.get(halfedgeList.get(nextedge).getOrigin()).coordX;
				centery=centery+vertexList.get(halfedgeList.get(nextedge).getOrigin()).coordY;
				nextedge=halfedgeList.get(nextedge).getNext();
			}
			centerx=centerx/numberofvertex;
			centery=centery/numberofvertex;
			StdDraw.text(centerx, centery, String.valueOf(i));
		}
		
	}
	private void drawEdges() {
		boolean [] edgedrawn = new boolean[halfedgeList.size()];
		for (int i = 0; i < edgedrawn.length; i++) {
			edgedrawn[i]=false;
		}
		double x0, y0, x1, y1, dispx0, dispy0, dispx1, dispy1, disp=0.1;
		Vertex v0, v1;
		for (int i = 0; i < halfedgeList.size(); i++) {
			if (!edgedrawn[i]) {	
			//desenha uma aresta, uma half-edge e depois sua twin
			v0=vertexList.get(halfedgeList.get(i).getOrigin());
			x0=v0.getCoordX();
			y0=v0.getCoordY();
			v1=vertexList.get(halfedgeList.get(halfedgeList.get(i).getTwin()).getOrigin());
			x1=v1.getCoordX();
			y1=v1.getCoordY();
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(x0, y0, x1, y1); //aresta
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.line(x0, y0-disp, x1, y1-disp); //half-edge
			StdDraw.text(x0, y0-0.5, String.valueOf(i));
			StdDraw.setPenColor(StdDraw.BLUE); 
			StdDraw.line(x1, y1+disp, x0, y0+disp); //twin
			StdDraw.text(x0, y0+0.5, String.valueOf(halfedgeList.get(i).getTwin()));
			edgedrawn[halfedgeList.get(i).getId()]=true;
			edgedrawn[halfedgeList.get(i).getTwin()]=true;
			}
		}
	}
	
//	private void drawHalfArrow(double x0, double y0, double x1, double y1){
//		double tipX, tipY;
//		//tipX=;
//		
//		StdDraw.line(x0, y0, x1, y1);
//		//StdDraw.line(x1, y1, tipX, tipY);
//	}
}
