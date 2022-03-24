
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Donovan
 */
public class Cards {
    int cardNum;
    //0 = Question ... side = 1 = Answer
    private String [] myCard = new String[2];
    private String status;
    //assume all cards arn't
    private boolean isMarked = false;
    
    public Cards(String question, String answer)
    {
        myCard[0] = question;
        myCard[1] = answer;
        
    }
    public int getCardNum()
    {
        return cardNum;
    }
    
    public void setCardNum(int num)
    {
        cardNum = num;
    }
    public String getQuestion()
    {
        return myCard[0];
    }
    public void setQuestion(String q)
    {
        myCard[0] = q;
    }
    
    public String getAnswer()
    {
        return myCard[1];
    }
    public void setAnswer(String a)
    {
        myCard[1] = a;
    }
    
    public String getSide(int side)
    {
        return myCard[side];
    }
    
    public void setStatus(String temp)
    {
        status = temp;
    }
    
    public void setMarked(boolean mark)
    {
        isMarked = mark;
    }
    public boolean isMarked()
    {
        return isMarked;
    }
    
    @Override
    public String toString()
    {
        return ("Card " + cardNum  + " " + status);
    }
}
