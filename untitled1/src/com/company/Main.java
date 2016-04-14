package com.company;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {

    public static void main(String[] args)
    {
        //Set<Human> humanSet = new LinkedHashSet<>();
        Map<Integer, List<Integer>> primer = new TreeMap<>();
        for(int i = 0; i < 3; i++) {
            List<Integer> listValues1 = new LinkedList();
            for(int j = 0; j < 3; j++){
                listValues1.add(j);
            }
            primer.put(i ,listValues1);
        }


        for(Map.Entry<Integer, List<Integer>> value : primer.entrySet() ){
            System.out.println();
            List<Integer>  newList = value.getValue();
            for (Integer new1 : newList){
                System.out.print(" " + new1);
            }
        }


    }

    public class weather {



    }

}

