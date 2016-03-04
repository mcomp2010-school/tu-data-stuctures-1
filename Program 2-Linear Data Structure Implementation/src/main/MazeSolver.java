package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

//==============================================================
//Program 2 – Maze Problem Program
//==============================================================
//Emanuel Rivera
//COSC 336-101
//Oct 6,2010
//--------------------------------------------------------------
public class MazeSolver {

	static List<Point> Path = new LinkedList<Point>();
	static Point[][] STRgrid = new Point[21][21]; // Multidimensional array of
													// Objects Points

	public static void SolverS(int Y, int X) {// provide -1
		boolean Solved = Solver(STRgrid, Y - 1, X - 1);
		if (Solved == true) {
			System.out.println("I am free");
		} else {
			System.out.println("Help, I am trapped");
			Path.clear();
		}
	}

	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		Initialize("data/maze.txt");// Put data from File into Array

		ShowStartGrid();
		Scanner ConsoleIN = new Scanner(System.in);
		System.out.println("For(X,Y) Enter Y: ");
		try {
			y = ConsoleIN.nextInt();
		} catch (Exception e) {
			System.out.println("ERROR-NOT A NUMBER");
		}

		System.out.println("For(X,Y) Enter X: ");
		try {
			x = ConsoleIN.nextInt();
		} catch (Exception e) {
			System.out.println("ERROR-NOT A NUMBER");

		}

		if ((y >= 1 && x >= 1) && (y < STRgrid.length && x < STRgrid[0].length)) {
			SolverS(y, x);// (3,6)->(2,6)->(2,5)->(2,4)->(1,4)->(1,3)->(1,2)->(1,1)
			ShowEndGrid();
			ShowList();
		} else {
			System.out.println("X or Y out of Range");
		}

	}

	public static boolean Solver(Point[][] inArray, int ROW, int COLUMN) {
		boolean camino = true;
		if (COLUMN >= (inArray[0].length - 1) || ROW >= (inArray.length - 1)
				|| COLUMN < 0 || ROW < 0) {
			camino = false;
			return camino;
		} // the limits of Table
		if (inArray[ROW][COLUMN].Data.equalsIgnoreCase("1")
				|| inArray[ROW][COLUMN].Data.equalsIgnoreCase("~")) {
			camino = false;
			return camino;
		} // 1 == blocked; ~ == visited
			// *************
		if (inArray[ROW][COLUMN].Data.equalsIgnoreCase("E")) {// IF EXIT THEN
			inArray[ROW][COLUMN].FinishPoint = true;
			Path.add(inArray[ROW][COLUMN]); // FOUND
			// inArray[ROW][COLUMN] = "E"; //WHEN "E" is found you can assign
			// new value
			camino = true;
			return camino;
		}
		inArray[ROW][COLUMN].Data = "~"; // camino was visited
		// *************
		camino = Solver(inArray, ROW + 1, COLUMN); // go down
		if (camino == false)
			camino = Solver(inArray, ROW, COLUMN + 1); // go right
		if (camino == false)
			camino = Solver(inArray, ROW - 1, COLUMN); // go up
		if (camino == false)
			camino = Solver(inArray, ROW, COLUMN - 1); // go left
		// *************
		if (camino == true) {
			inArray[ROW][COLUMN].Data = "+";
			// Path.add(inArray[ROW][COLUMN].GetLocation());
			Path.add(inArray[ROW][COLUMN]);
		}

		return camino;
	}

	public static void Initialize(String in) {
		try {
			InitializeFromTXT(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ShowStartGrid() {
		for (int x = 0; x < STRgrid[0].length - 1; x++) {
			if (x == 0)
				System.out.print("   " + (x + 1) + "  ");
			else if (x <= 8)
				System.out.print((x + 1) + "  ");
			else if (x >= 9)
				System.out.print((x + 1) + " ");
		}
		System.out.println();
		for (int y = 0; y < STRgrid.length - 1; y++) { // print grid
			if (y <= 8)
				System.out.print((y + 1) + "  ");
			else
				System.out.print((y + 1) + " ");

			for (int x = 0; x < STRgrid[0].length - 1; x++) {
				System.out.print(STRgrid[y][x] + "  ");
			}
			System.out.println();
		}
	}

	public static void ShowEndGrid() {
		for (int y = 0; y < STRgrid.length - 1; y++) { // print grid
			// System.out.print(y+" ");
			for (int x = 0; x < STRgrid[0].length - 1; x++) {
				System.out.print(STRgrid[y][x] + "");
			}
			System.out.println();
		}
	}

	public static void ShowList() {
		ReverseList();

		ListIterator listIteratorName = Path.listIterator();
		while (listIteratorName.hasNext()) {
			Point nextElement = (Point) listIteratorName.next();
			// ***********************
			if (nextElement.FinishPoint == false && listIteratorName.hasNext()) {
				System.out.print(nextElement.GetLocation() + "->");
			} else {
				System.out.print(nextElement.GetLocation() + "");
			}
			// ***********************

		}
		System.out.print("   D=" + Path.size());
		System.out.println();
	}

	public static void ReverseList() {// This is so that the Starting point will
										// be at the beginning
		boolean FirstIsEND = false;// Check if it is right
		Stack<Point> Temp = new Stack<Point>();
		ListIterator listIteratorName = Path.listIterator();
		while (listIteratorName.hasNext()) {
			Point nextElement = (Point) listIteratorName.next();
			// ***********************
			if (nextElement.FinishPoint == true)
				FirstIsEND = true; // IF First Point is End then discontinue
			if (FirstIsEND == true)
				Temp.add(nextElement);
			else
				break;
			// ***********************
		}
		if (FirstIsEND == true) {
			Path.clear();
			while (Temp.empty() == false) {
				Path.add(Temp.pop());
			}
		}

	}

	// *****************************************************************
	// *********************InitializeFromTXT***************************
	// *****************************************************************
	public static void InitializeFromTXT(String inputFilePath)
			throws IOException {
		File file = new File(inputFilePath);
		BufferedReader bufRdr = new BufferedReader(new FileReader(file));
		String line = null;
		int linenum = 0;

		// read each line of text file

		while ((line = bufRdr.readLine()) != null) {
			// StringTokenizer st = new StringTokenizer(line,"");

			String LineString = line;
			System.out.println(LineString);
			for (int i = 0; i <= LineString.length() - 1; i++) {
				String Letter = LineString.substring(i, i + 1);
				System.out.println("(" + linenum + "," + i + ")-" + Letter);
				STRgrid[linenum][i] = new Point(linenum + 1, i + 1, Letter);
			}
			// while (st.hasMoreTokens()){
			// System.out.println(st.nextToken()+" ");
			// }
			// System.out.println();
			linenum++;
		}
		// close the file
		bufRdr.close();
	}
}

// *****************************************************************
// *********************POINT CLASS*********************************
// *****************************************************************
class Point {
	int Location_X;
	int Location_Y;
	String Data;
	boolean FinishPoint = false;

	//public Point() {

	//}

	public String GetLocation() {
		return "(" + Location_Y + "," + Location_X + ")";

	}

	public Point(int location_Y, int location_X, String data) {

		super();
		Location_X = location_X;
		Location_Y = location_Y;
		Data = data;
	}

	public Point(int location_X, int location_Y, String data,
			boolean finishPoint) {
		super();
		Location_X = location_X;
		Location_Y = location_Y;
		Data = data;
		FinishPoint = finishPoint;
	}

	public String toString() {
		return Data;
	}

}

/*
 * TESTING GRID String[][] STRgrid =
 * {{"0","0","0","1","0","0","1","1","1","0","0","0","0"},
 * {"E","1","0","0","0","1","0","0","0","0","1","1","0"},
 * {"1","1","1","1","0","1","0","1","0","1","0","1","1"},
 * {"0","0","0","1","0","0","0","1","0","1","0","0","0"},
 * {"0","1","0","1","1","1","1","0","0","0","1","1","0"},
 * {"0","1","0","0","0","0","0","0","1","0","0","0","0"},
 * {"0","1","1","1","1","1","1","1","1","1","1","1","1"},
 * {"0","0","0","0","0","0","0","0","0","0","0","0","0"}};
 */
