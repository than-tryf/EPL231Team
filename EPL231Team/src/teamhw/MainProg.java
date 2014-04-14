package teamhw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author root
 */
public class MainProg {

	static String fname, s;
	static File f;
	static FileReader fr;
	static BufferedReader br;
	static String sbuf[];
	static MyGraph g;
	static MyVertex ver;
	static MyNode<String> katigoria;

	public static void main(String[] args) {
		try {
			fname = "./HW3InputFile.txt";
			f = new File(fname);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			br.readLine();
			g = new MyGraph();

			while ((s = br.readLine()) != null) {
				sbuf = s.split("[\t]+");
				// System.out.println(sbuf[4]);
				ver = new MyVertex(Integer.parseInt(sbuf[1]),
						Integer.parseInt(sbuf[2]), sbuf[0]);
				katigoria = new MyNode<String>(sbuf[3], sbuf[4]);
				g.addToGraph(ver,katigoria);
			}

			//g.printGraph();
			g.printCategoriesOfNode(0);

		} catch (FileNotFoundException ex) {
			System.out.println("File not found...!");
		} catch (IOException ex) {
			System.out.println("Inout/output error!");
		}

	}

}
