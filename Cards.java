/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Donovan
 */
public class Cards {
    private String [] myCard = new String[2];
    
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
}
