
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author donov
 */
public class randomizeArrayList {
    
    public void randomize(ArrayList <Cards> list){
        Random rgen = new Random();
        for (int i=0; i<list.size(); i++) {
        int randomPosition = rgen.nextInt(list.size());
        Cards temp = list.get(i);
        list.set(i, list.get(randomPosition)) ;
        list.set(randomPosition, temp);
        }
    }
}
