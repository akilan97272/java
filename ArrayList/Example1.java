import java.util.*;

public class Example1{
    public static void main(String []args){
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Carrot");
        list.add("Beetroot");
        for(String fruits : list){
            System.out.println(fruits);
        }
    }
}