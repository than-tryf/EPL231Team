package teamhw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author root pame trelenomaiiii Thanasis Elias Stylianos
 */
public class MainProg {

	static String fname, s;
	static File f;
	static FileReader fr;
	static BufferedReader br;
	static String sbuf[]; // pairnei [USER_18, 828, 319, Annet_Artani,
							// file342.mp3]
	static MyCategory cat_list; // i lista me ta arxeia ana katigoria kaixristi
	static MyGraph g; // o grafos
	static MyVertex ver; // o komvos tou grafou
	static MyNode<String> katigoria; // komvos katigoria pou mpainei ston komvo
										// tou grafou
	static int d; // to d pou tou dinoume
	static Scanner in;
	static Dijkstra dij; // Dijkstra class for calculating shortest path

	static int menuchoice;

	public static void printMenu() {
		System.out.println("=============================");
		System.out.println("Menu:");
		System.out.println("****************************");
		System.out.println("1.Eisagogi neou xristi");
		System.out.println("2.Eisagogi neou arxeiou se kapoio xristi");
		System.out.println("3.Eksodos xristi");
		System.out
				.println("4.Ektiposi stoixeion arxeion pou anikoun se kapoia katigoria");
		System.out
				.println("5.Ektiposi stoixeion arxeion pou anikoun se kapoia katigoria kai apostasi apo xristi");
		System.out
				.println("6.Ektiposi stoixeion katigorias  pou einai kontinoteri se kapoio xristi");
		System.out
				.println("7.Enimerosi arxeiou sistimatos kai eksodos apo to sistima");
		System.out.print("\n\n Epilogi > ");
	}

	public static void Choice1() {
		String uname;
		int xc, yc;
		in = new Scanner(System.in);
		System.out.println("\nEisagogi xristi: \n");
		System.out.print("Username > ");
		uname = in.nextLine();
		System.out.print("x-coordinate > ");
		xc = in.nextInt();
		System.out.print("y-coordinate > ");
		yc = in.nextInt();
		g.addUserToGraph(uname, d, xc, yc);
		cat_list = new MyCategory();
		cat_list.createCategoryList(g);
		dij = new Dijkstra(g);
	}

	public static void Choice2() {
		in = new Scanner(System.in);
		String uname, categ, mp3name;
		System.out.println("\nEisagogi arxeiou se xristi:\n");
		System.out.print("Username > ");
		uname = in.nextLine();
		System.out.print("Category > ");
		categ = in.nextLine();
		System.out.print("File name > ");
		mp3name = in.nextLine();
		g.addNewFile(uname, categ, mp3name);
		dij = new Dijkstra(g);

	}

	public static void Choice3() {
		in = new Scanner(System.in);
		String uname;
		System.out.println("\nEksodos xristi: \n");
		System.out.print("Username > ");
		uname = in.nextLine();
		g.userLogOut(uname, d);
		cat_list = new MyCategory();
		cat_list.createCategoryList(g);
		dij = new Dijkstra(g);
	}

	public static void Choice4() {
		in = new Scanner(System.in);
		String categ;
		System.out.println("\nEktiposi arxeion katigorias: \n");
		System.out.print("Category > ");
		categ = in.nextLine();
		cat_list = new MyCategory();
		cat_list.createCategoryList(g);
		cat_list.printData(categ);
	}

	public static void Choice5() {
		in = new Scanner(System.in);
		String uname, categ;
		System.out
				.println("Ektiposi arxeion katigorias kai apostasis apo to xristi\n");
		System.out.print("Username > ");
		uname = in.nextLine();
		System.out.print("Category > ");
		categ = in.nextLine();
		dij = new Dijkstra(g);
		dij.calculateDijkstra(uname, categ);
		dij.allFilesfromUser(uname, categ);
	}

	public static void Choice6() {
		in = new Scanner(System.in);
		String uname, categ;
		System.out
				.println("\nEktiposi arxeion katigorias kontinoteris sto xristi:\n");
		System.out.print("Username > ");
		uname = in.nextLine();
		System.out.print("Category > ");
		categ = in.nextLine();
		dij = new Dijkstra(g);
		dij.calculateDijkstra(uname, categ);
		dij.showMinCat(uname, categ);
	}

	public static void Choice7() {
		in = new Scanner(System.in);
		System.out.println("Apothikeusi allagon sto sistima....");
		System.out.println("Eksodos apo to sistima...");
		g.saveGraph();
		System.exit(0);

	}

	public static void main(String[] args) {
		try {
			fname = "./HW3InputFile.txt";
			f = new File(fname);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			br.readLine();
			g = new MyGraph();
			cat_list = new MyCategory();
			in = new Scanner(System.in);
			// long start, end;

			System.out.print("Dose to d: ");
			d = in.nextInt();

			// start = System.currentTimeMillis();
			/**
			 * To while pio kato dimiourgei tous komvous tou grafou kai tous
			 * topothetei sto arraylist pou antiprosopeuei to grafo mas
			 */
			while ((s = br.readLine()) != null) {
				sbuf = s.split("[\t]+");
				ver = new MyVertex(Integer.parseInt(sbuf[1]),
						Integer.parseInt(sbuf[2]), sbuf[0]);
				katigoria = new MyNode<String>(sbuf[3], sbuf[4]);
				g.addToGraph(ver, katigoria);
			}
			br.close();
			g.createEdges(d); // dimiourgia ton akmon vasi tou d
			cat_list.createCategoryList(g); // dimiourgia tis listas me tis
											// katigories
			dij = new Dijkstra(g);
			while (true) {
				printMenu();
				in = new Scanner(System.in);
				menuchoice = in.nextInt();
				if (menuchoice == 1) {
					Choice1();

				} else if (menuchoice == 2) {
					Choice2();

				} else if (menuchoice == 3) {
					Choice3();

				} else if (menuchoice == 4) {
					Choice4();

				} else if (menuchoice == 5) {
					Choice5();

				} else if (menuchoice == 6) {
					Choice6();

				} else if (menuchoice == 7) {
					Choice7();

				} else {
					System.out
							.println("\nLathos epilogi menu dokimase ksana!\n");
				}
			}

			// end = System.currentTimeMillis();
			// System.out.println("Spend time = " + (end - start) + "Milsec");

		} catch (FileNotFoundException ex) {
			System.out.println("File not found...!");
		} catch (IOException ex) {
			System.out.println("Inout/output error!");
		}

	}
}
