
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author donov
 */
public class CardMaker extends javax.swing.JFrame {
    
    boolean isEditing = false;
    private DefaultListModel <Cards> cardList = new DefaultListModel<Cards>();
    //original window reference
    private FlashCards quizWindow;
    /**
     * Creates new form CardMaker
     */
    public CardMaker() {
        initComponents();
        this.submittedArea.setModel(cardList);
        removeBtn.setVisible(isEditing);
    }
    
    public void setWindowRef(FlashCards window)
    {
        quizWindow = window;
    }
    
     private void clearDisplayFrame()
    {
       cardList.clear();
       submittedCardsLabel.setText("Cards: 0");
       isEditing = false;
       removeBtn.setVisible(isEditing);

    }
private void saveFile(File selectedFile) 
    {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile + ".txt"));
                for(int i = 0; i < cardList.size(); i++) {
                    writer.write(cardList.getElementAt(i).getQuestion() + " /");
                    writer.write(cardList.getElementAt(i).getAnswer() + "\n");
                }
                writer.close();
            } catch (Exception e) {
                //System.out.println("Error: Couldn't write to file.");
                JOptionPane.showMessageDialog(null, "Error: Couldn't write to file.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
    }

 private void readFile(File selectedFile) 
    {    
        try {
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
            String question = reader.readLine();
            String answer = "";
            int seperator = 0;
            while (question != null) {
                for(int i=0; i < question.length(); ++i)
                {
                    if(question.charAt(i) == '/')
                    {
                        seperator = i;
                        i=question.length();                        
                    }
                }
                    answer = question.substring((seperator+1));  
                    question = question.substring(0, (seperator-1));
                    cardList.addElement(new Cards(question, answer));
                    cardList.get(cardList.getSize()-1).setCardNum(cardList.size());
                    cardList.get(cardList.getSize()-1).setStatus("import succeeded");
                    question = reader.readLine();
                }
                reader.close();
            } catch (Exception e) {
                //System.out.println("Error: Couldn't read to file.");
                JOptionPane.showMessageDialog(null, "Error: Couldn't read file.", "Error", JOptionPane.ERROR_MESSAGE);
            }       
    }
 
     private void removeCard(Cards selectedCard)
    {
       //String addedCard; 
            enterCardInfoQ.setText("");
            enterCardInfoA.setText(""); 
            //updates the list to show card is removed
            cardList.removeElement(selectedCard);
      
        for(int i = 0; i < cardList.size(); i++)
        {         
         cardList.elementAt(i).setCardNum(i+1);
        }
        submittedCardsLabel.setText("Cards: " + cardList.size());
        addBtn.setText("Add");
        isEditing = false; 
    }
     
    private void addCard()
    {
        //adds new card to card list
        Cards myCard;
         if(enterCardInfoQ.getText().equals("") || enterCardInfoA.getText().equals(""))
        {
            myCard = new Cards("This is Placeholder Text", "This is Placeholder Text");
        }
        else
        {
            myCard = new Cards(enterCardInfoQ.getText(), enterCardInfoA.getText());
        }
         cardList.addElement(myCard);
         cardList.get(cardList.size()-1).setCardNum(cardList.size());
         cardList.get(cardList.size()-1).setStatus("created");      
         submittedCardsLabel.setText("Cards: " + cardList.size());
         enterCardInfoQ.setText("");
         enterCardInfoA.setText("");
    }
    
        private void editCard(Cards selectedCard)
    {
          enterCardInfoQ.setText(selectedCard.getQuestion());
          enterCardInfoA.setText(selectedCard.getAnswer());         
          isEditing = true;
          addBtn.setText("Finish Edit");
    }
    
    private void addCard(Cards selectedCard)
    {
        //changes values of cards already in cardList
         if(enterCardInfoQ.getText().equals("") || enterCardInfoA.getText().equals(""))
        {
            selectedCard.setQuestion("This is Placeholder Text");
            selectedCard.setAnswer("This is Placeholder Text");
        }
        else
        {
            selectedCard.setQuestion(enterCardInfoQ.getText());
            selectedCard.setAnswer(enterCardInfoA.getText());
        }
        cardList.get((selectedCard.getCardNum()-1)).setStatus("updated");
        addBtn.setText("Add");
        enterCardInfoQ.setText("");
        enterCardInfoA.setText("");
        isEditing = false;
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveFileFrame = new javax.swing.JFrame();
        openFileFrame = new javax.swing.JFrame();
        QuestionLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        enterCardInfoQ = new javax.swing.JTextArea();
        submittedCardsLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        enterCardInfoA = new javax.swing.JTextArea();
        AnswerLabel = new javax.swing.JLabel();
        removeBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        submittedArea = new javax.swing.JList<>();
        menuBar = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menuItemSave = new javax.swing.JMenuItem();
        importMenuItm = new javax.swing.JMenuItem();

        saveFileFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        saveFileFrame.setTitle("Flash Card Maker");
        saveFileFrame.setAlwaysOnTop(true);

        javax.swing.GroupLayout saveFileFrameLayout = new javax.swing.GroupLayout(saveFileFrame.getContentPane());
        saveFileFrame.getContentPane().setLayout(saveFileFrameLayout);
        saveFileFrameLayout.setHorizontalGroup(
            saveFileFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        saveFileFrameLayout.setVerticalGroup(
            saveFileFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        openFileFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        openFileFrame.setTitle("Flash Card Maker");
        openFileFrame.setAlwaysOnTop(true);

        javax.swing.GroupLayout openFileFrameLayout = new javax.swing.GroupLayout(openFileFrame.getContentPane());
        openFileFrame.getContentPane().setLayout(openFileFrameLayout);
        openFileFrameLayout.setHorizontalGroup(
            openFileFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        openFileFrameLayout.setVerticalGroup(
            openFileFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flash Card Maker");
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        QuestionLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        QuestionLabel.setText("Question");

        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        enterCardInfoQ.setColumns(20);
        enterCardInfoQ.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        enterCardInfoQ.setLineWrap(true);
        enterCardInfoQ.setRows(5);
        enterCardInfoQ.setWrapStyleWord(true);
        enterCardInfoQ.setMargin(new java.awt.Insets(35, 35, 35, 35));
        jScrollPane2.setViewportView(enterCardInfoQ);

        submittedCardsLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        submittedCardsLabel.setText("Cards : 0");

        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        enterCardInfoA.setColumns(20);
        enterCardInfoA.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        enterCardInfoA.setLineWrap(true);
        enterCardInfoA.setRows(5);
        enterCardInfoA.setWrapStyleWord(true);
        enterCardInfoA.setMargin(new java.awt.Insets(35, 35, 35, 35));
        jScrollPane3.setViewportView(enterCardInfoA);

        AnswerLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AnswerLabel.setText("Answer");

        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        addBtn.setText("Add ");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        submittedArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submittedArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                submittedAreaMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(submittedArea);

        jMenu2.setText("File");

        menuItemSave.setText("Export Flash Cards");
        menuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemSave);

        importMenuItm.setText("Import Flash Cards");
        importMenuItm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importMenuItmActionPerformed(evt);
            }
        });
        jMenu2.add(importMenuItm);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(QuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnswerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(submittedCardsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submittedCardsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuestionLabel))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AnswerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveActionPerformed
        // TODO add your handling code here:
        JFileChooser fileSave = new JFileChooser("E:\\Quizlet FlashCard Files");
        int selection = fileSave.showSaveDialog(saveFileFrame);
        if(selection == JFileChooser.APPROVE_OPTION);
        {
            saveFile(fileSave.getSelectedFile());
        }
        this.clearDisplayFrame();

    }//GEN-LAST:event_menuItemSaveActionPerformed

    private void importMenuItmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importMenuItmActionPerformed
        // TODO add your handling code here:
        if(!cardList.isEmpty())
        {
            int reply = JOptionPane.showConfirmDialog(null, "Would you like to export before opening a new file? \nAll current work will be lost.", "Export Cards?", JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION)
            {
                JFileChooser fileSave = new JFileChooser("E:\\Quizlet FlashCard Files");
                int selection = fileSave.showSaveDialog(saveFileFrame);
                if(selection == JFileChooser.APPROVE_OPTION)
                {
                    saveFile(fileSave.getSelectedFile());
                    this.clearDisplayFrame();
                }
            }
        }
        
        this.clearDisplayFrame();
        JFileChooser fileLoad = new JFileChooser("E:\\Quizlet FlashCard Files");
        int selection = fileLoad.showOpenDialog(openFileFrame);
        if(selection == JFileChooser.APPROVE_OPTION)
        {
            readFile(fileLoad.getSelectedFile());
        }
    }//GEN-LAST:event_importMenuItmActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
        removeCard(submittedArea.getSelectedValue());
        removeBtn.setVisible(isEditing);
        submittedArea.clearSelection();
    }//GEN-LAST:event_removeBtnActionPerformed
   
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        if(isEditing)
        {
            addCard(submittedArea.getSelectedValue());
            removeBtn.setVisible(isEditing);
        }
        else
        {
            addCard();
        }    
    }//GEN-LAST:event_addBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:       
        quizWindow.resetEnable();
    }//GEN-LAST:event_formWindowClosing

    private void submittedAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submittedAreaMousePressed
        // TODO add your handling code here:
        if(!cardList.isEmpty())
        {
            editCard(submittedArea.getSelectedValue());
            removeBtn.setVisible(isEditing);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error: No cards are in the list", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submittedAreaMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CardMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CardMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CardMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CardMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardMaker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnswerLabel;
    private javax.swing.JLabel QuestionLabel;
    private javax.swing.JButton addBtn;
    private javax.swing.JTextArea enterCardInfoA;
    private javax.swing.JTextArea enterCardInfoQ;
    private javax.swing.JMenuItem importMenuItm;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JFrame openFileFrame;
    private javax.swing.JButton removeBtn;
    private javax.swing.JFrame saveFileFrame;
    private javax.swing.JList<Cards> submittedArea;
    private javax.swing.JLabel submittedCardsLabel;
    // End of variables declaration//GEN-END:variables
}
