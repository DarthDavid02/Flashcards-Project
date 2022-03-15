
import java.awt.Insets;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author donov
 */
public class FlashCards extends javax.swing.JFrame {

    /**
     * Creates new form FlashCards
     */
    //side = 0 = Question ... side = 1 = Answer
    private String [][] card = {{"4 + 4 =", "8"},{"What is The meaning of Life?", "42"},{"Who's the best?", "You are!"},
        {"What is a super random fact that absolutely no one would ever even know in their lives" + '\n' + "except that one person who would know it?", "The cake is a lie"}};
    private ArrayList <String[]> flashCards = new ArrayList<String[]>();
    private int cardCount = 0;
    boolean isFlipped = false;
    public FlashCards() {
        initComponents();
        makeCardList();
        showCard(0);
        checkVis();
    }
    
    public void makeCardList()
    {
       for(int i = 0; i < card.length; i++)
       {
           flashCards.add(card[i]);
       }
    }

    public void checkVis()
    {
      //hides next button if at end of list so user doesn't go out of bounds
      if(cardCount == flashCards.size()-1)
      {
        nextBtn.setVisible(false);
      }
      else
      {
        nextBtn.setVisible(true);
      }
      
      //hides previous button if at start of list so user doesn't go out of bounds
      if(cardCount == 0)
      {
        prevBtn.setVisible(false);
      }
      else
      {
        prevBtn.setVisible(true);
      }
        
    }
    public void showCard(int side)
    {
        flashCardBtn.setText(flashCards.get(cardCount)[side]);
        cardNumLabel.setText((cardCount+1) + "/" + flashCards.size());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prevBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        cardNumLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        flashCardBtn = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        prevBtn.setText("Previous");
        prevBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevBtnActionPerformed(evt);
            }
        });

        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        cardNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cardNumLabel.setText("0/0");

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        flashCardBtn.setEditable(false);
        flashCardBtn.setColumns(20);
        flashCardBtn.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        flashCardBtn.setLineWrap(true);
        flashCardBtn.setRows(5);
        flashCardBtn.setWrapStyleWord(true);
        flashCardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        flashCardBtn.setFocusable(false);
        flashCardBtn.setMargin(new java.awt.Insets(35, 35, 35, 35));
        flashCardBtn.setRequestFocusEnabled(false);
        flashCardBtn.setVerifyInputWhenFocusTarget(false);
        flashCardBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                flashCardBtnMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(flashCardBtn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prevBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(cardNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prevBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prevBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevBtnActionPerformed
        // TODO add your handling code here:
        --cardCount;
        //resets isFlipped variable to reflect that the question should be showing for new card
        isFlipped = false;
        showCard(0);
        checkVis();
    }//GEN-LAST:event_prevBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        ++cardCount;
        //resets isFlipped variable to reflect that the question should be showing for new card
        isFlipped = false;
        showCard(0);
        checkVis();
    }//GEN-LAST:event_nextBtnActionPerformed

    private void flashCardBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flashCardBtnMousePressed
        // TODO add your handling code here:
        if(isFlipped)
        {
            isFlipped = false;
            showCard(0);
        }
        else
        {
            isFlipped = true;
            showCard(1);
        }
    }//GEN-LAST:event_flashCardBtnMousePressed

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
            java.util.logging.Logger.getLogger(FlashCards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlashCards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlashCards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlashCards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlashCards().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cardNumLabel;
    private javax.swing.JTextArea flashCardBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton prevBtn;
    // End of variables declaration//GEN-END:variables
}
