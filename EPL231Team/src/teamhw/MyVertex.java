package teamhw;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class MyVertex {

    int x;
    int y;
    String name;
    int id;
   // ArrayList<Integer> edges;
    ArrayList<MyNode<String>> categories;

 
    MyVertex(int x1,int y1,String n){
        x = x1;
        y=y1;
        name = n;
        id = Integer.parseInt(n.substring(5));
      //  edges = new ArrayList<>();
        categories = new ArrayList<MyNode<String>>();
     
    }
    
    
}
