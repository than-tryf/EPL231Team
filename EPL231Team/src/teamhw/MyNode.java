package teamhw;

/**
 *
 * @author root
 * @param <AnyType>
 */
public class MyNode<AnyType> {

    AnyType data1;
    AnyType data2;
    MyNode<?> next;

    MyNode() {
        data1 = null;
        data2 = null;
        next = null;
    }

    MyNode(AnyType d1,AnyType d2){
        data1 = d1;
        data2 = d2;
        next =null;
    }
    
    
}
