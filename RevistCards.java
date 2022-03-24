
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author donov
 */
public class RevistCards
{
    private ArrayList <Cards> original = new ArrayList<Cards>();
     
    public ArrayList <Cards> getFilter()
    {
        return original;
    }
    
    public void setFilter(ArrayList <Cards> cardsIn)
    {
        original.addAll(cardsIn);
    }
    
    public void resetFilter()
    {
        original.clear();
    }
    
    public Cards getCardRef(ArrayList <Cards> ref, int index)
    {
        return original.get(ref.indexOf(ref.get(index)));
    }
    public void filterUnmarkedCards(ArrayList <Cards> filter)
    {
        
        for(int i = 0; i < original.size(); ++i)
            {
                if(original.get(i).isMarked())
                    {
                        filter.add(original.get(i));
                        filter.get(filter.size()-1).setCardNum(filter.size());
                    }                          
            }
        
    }
    
//    public ArrayList <Cards>  updateFilter()
//    {
//        ArrayList <Cards> filter = new ArrayList <Cards> ();
//       for(int i = 0; i < original.size(); ++i)
//        {
//            if(original.get(i).isMarked())
//            {
//               filter.add(original.get(i));
//               filter.get(filter.size()-1).setCardNum(filter.size());
//            }                          
//        }
//       System.out.println(filter);
//       return filter;
//    }
     
    public boolean anyMarked()
    {
        boolean anyMarked = false;
        
        for(int i=0; i<original.size(); ++i)
        {
            if(original.get(i).isMarked())
            {
                anyMarked = true;
                break;
            }
        }
        return anyMarked;
    }
    public void resetCardNumbering(ArrayList <Cards> cardList)
    {
        for(int i = 0; i < cardList.size(); ++i)
        {
            cardList.get(i).setCardNum(i+1);
        }
              
    }
}
