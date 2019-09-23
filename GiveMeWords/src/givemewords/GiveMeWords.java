/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package givemewords;


import java.awt.Color;
import java.awt.Font; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 
import java.util.Random;
import java.util.stream.IntStream;
import javax.swing.table.*;
import java.util.Arrays;
/**
 *
 * @author Asus
 */
public class GiveMeWords implements ActionListener{
    Random rand;
    
    String[] users = new String[10];
    
    int user_count = 0;
    
    int[] scores = new int[10];
    
    
    int randomizer;
    JFrame application_frame, gamemode_frame, rank_frame, easy_frame, medium_frame, hard_frame;
    
    JButton Submit, HighScore, Exit ,easy, medium, hard, back, backgm, easyback, medback, hardback, easysubmit, eshuffle, med_submit, 
           med_shuffle, hard_submit, hard_shuffle, easyskip, easyquit, medskip, medquit, hardskip, hardquit,buttons;
    
    JTextField username, easy_input, med_input, med_main, hard_input, wordDisplayer,escore,mscore,hscore;
    
    JTextArea word_area;
    
    JLabel level, label, guessed_wordl, tobeGuess, inputl, guessed_word2, tobeGuess2
      , input2, guessed_word3, tobeGuess3, input3, escorel, mscorel, hscorel, easybg, 
        appbg, hslabel, hsjepg, esbg , mebg, habg , gmbg;
    
    Icon bgimg, hsimg, esimg, meimg, haimg, gmimg;
    
    public GiveMeWords() {
        
     rand = new Random();
     application();   
    }
    
   
      public void application() {
      
    application_frame = new JFrame("Give Me Words");
   
    username    = new JTextField();
    label       = new JLabel("Input Username");
    Submit      = new JButton("SUBMIT");
    HighScore   = new JButton("High Score");
    Exit        = new JButton("EXIT");
    bgimg       = new ImageIcon("C:\\Users\\Asus\\Desktop\\GiveMeWords\\main.jpg");
    appbg       = new JLabel(bgimg);
    application_frame.setContentPane(appbg);

            
application_frame.setLayout(null);
application_frame.setSize(1000,1000);
application_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
application_frame.setVisible(true);
application_frame.setLocationRelativeTo(null);



application_frame.add(username);
username.setBounds(400,290,200,70);
username.setFont(new  Font("times new roman", Font.BOLD, 40));
username.setVisible(true);
username.setOpaque(false );
username.setForeground(Color.cyan);
            

application_frame.add(label);
label.setBounds(400,330,400,100);
label.setFont(new Font("times new roman", Font.BOLD, 30));

label.setForeground(Color.cyan);

 application_frame.add(Submit);
 Submit.setBounds(400,440,200,35);
 Submit.addActionListener(this);
 Submit.setFont(new Font("Comic sans mt", Font.BOLD, 20));
 
 application_frame.add(HighScore);
 HighScore.setBounds(400,495,200,35);
 HighScore.addActionListener(this);
 
 application_frame.add(Exit);
 Exit.setBounds(400,555,200,35);
 Exit.addActionListener(this);

 }
    
    public void gameMode() {
        gamemode_frame = new JFrame("Select Game mode");
        gamemode_frame.setLayout(null);
        gamemode_frame.setSize(1000,1000);
        gamemode_frame.setVisible(true);
        gamemode_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamemode_frame.setLocationRelativeTo(null);
        
        
        level = new JLabel("Choose Level");
        
        easy    = new JButton("> Easy <");
        medium  = new JButton("> Medium <");
        hard    = new JButton("> Hard <");
        backgm  = new JButton("> Back <");
        gmimg   = new ImageIcon("C:\\Users\\Asus\\Desktop\\GiveMeWords\\main.jpg");
        gmbg    = new JLabel(gmimg);
        gamemode_frame.setContentPane(gmbg);
        
 

 
 
 gamemode_frame.add(level);
 level.setBounds(400,330,400,100);
 level.setFont(new Font("Calibri", Font.BOLD, 40));
 level.setForeground(Color.cyan);
 
 gamemode_frame.add(easy);
 easy.setBounds(400,440,200,35);
 easy.addActionListener(this);
 
 gamemode_frame.add(medium);
 medium.setBounds(400,495,200,35);
 medium.addActionListener(this);
 
 gamemode_frame.add(hard);
 hard.setBounds(400,555,200,35);
 hard.addActionListener(this);
 
 gamemode_frame.add(backgm);
 backgm.setBounds(400,600,200,35);
 backgm.addActionListener(this);
        
    }

    public static String shuffle(String text) {
        char[] characters = text.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = (int)(Math.random() * characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
    
  // -----------------------------------------------------------------------------------------------------EASY MODE---------------------------------------------------------------------------------  
    
    String[][] easyWords = { {"bare","ear","are","era","bear"},{"game","mage","gem","mag","age"},
        {"scar","cars","arc","arcs","car"},{"skin","ink","inks","sink","kin"},
        {"need","eden","nee","den","end"},{"bird","brid","rib","rid","bid"},
        {"gulp","plug","pug","pul","gul"},{"hant","than","ant","tan","hat"},
        {"brag","bag","bar","rag","grab"},{"late","tale","tea","eat","ate"} };
    String currentWord[] = new String[5];
    String guessedWord[] = new String[5];
    int counter_guessed = 0;
    int easy_level = 1;
    int out[] = new int[3];
    
 public void easymode() {
    randomizer = rand.nextInt(10);
    out[easy_level-1] = randomizer;
    for (int i = 0 ; i != 5 ; i++) {
        currentWord[i] = easyWords[randomizer][i];
    }
    easy_frame = new JFrame("Easy Mode");
    easy_frame.setLayout(null);
    easy_frame.setSize(1000,1000);
    easy_frame.setVisible(true);
    easy_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    easy_frame.setLocationRelativeTo(null);

    easyback    =  new JButton("Back");
    easysubmit  = new JButton("Submit word");
    eshuffle    = new JButton("Shuffle");
    easyquit    = new JButton("Quit");
    easyskip    = new JButton("Skip");
    easy_input  = new JTextField();
    wordDisplayer   = new JTextField();
    escore          = new JTextField();
    word_area       =  new JTextArea();
    guessed_wordl   = new JLabel("Guessed Words");
    inputl          = new JLabel("Write your words here:");
    tobeGuess       = new JLabel("Get Your Words Here:");
    escorel         = new JLabel("score:");
    esimg           = new ImageIcon("C:\\Users\\Asus\\Desktop\\GiveMeWords\\ice.jpg");
    esbg            = new JLabel(esimg);
    easy_frame.setContentPane(esbg);
            
    easy_frame.add(guessed_wordl);
    guessed_wordl.setBounds(30,160,200,50);
    guessed_wordl.setFont(new Font("exclibur", Font.BOLD, 20));
    
    easy_frame.add(tobeGuess);
    tobeGuess.setBounds(350,160,300,50);
    tobeGuess.setFont(new Font("exclibur", Font.BOLD, 20));
    
    easy_frame.add(inputl);
    inputl.setBounds(350,360,300,50);
    inputl.setFont(new Font("exclibur", Font.BOLD, 20));
 
    easy_frame.add(wordDisplayer);
    wordDisplayer.setBounds(350,200,300,100);
    wordDisplayer.setEditable(false);
    wordDisplayer.setFont(new Font("exclibur", Font.BOLD, 70));
    wordDisplayer.setOpaque(false );
    wordDisplayer.setText("***");
    
    wordDisplayer.setText(shuffle(easyWords[randomizer][0]));
    
    easy_frame.add(escore);
    escore.setBounds(880,105,100,40);
    escore.setEditable(false);
    escore.setText("0");
    escore.setFont(new Font("comic sans ms", Font.BOLD, 20));
    escore.setOpaque(false );
    
    easy_frame.add(escorel);
    escorel.setBounds(820,100,100,50);
    escorel.setFont(new Font("comic sans ms", Font.BOLD, 20));
    
    easy_frame.add(easy_input);
    easy_input.setBounds(350,400,300,100);
    easy_input.setFont(new Font("exclibur", Font.BOLD, 70));
    easy_input.setOpaque(false);
    
   
    easy_frame.add(word_area);
    word_area.setBounds(30,200,200,300);
    word_area.setEditable(false);
    word_area.setFont(new Font("exclibur", Font.BOLD, 40));
    word_area.setOpaque(false);
    
    easy_frame.add(easysubmit);
    easysubmit.setBounds(600,600,200,35);
    easysubmit.addActionListener(this); 
 
    easy_frame.add(eshuffle);
    eshuffle.setBounds(200,600,200,35);
    eshuffle.addActionListener(this);
    
    easy_frame.add(easyback);
    easyback.setBounds(215,700,170,35);
    easyback.addActionListener(this);
    
    easy_frame.add(easyskip);
    easyskip.setBounds(415,700,170,35);
    easyskip.addActionListener(this);
    
     easy_frame.add(easyquit);
    easyquit.setBounds(615,700,170,35);
    easyquit.addActionListener(this);
 
    
    
 }
 
 // -----------------------------------------------------------------------------------------------------MEDIUM MODE---------------------------------------------------------------------------------  
 
 String[][] medWords = { {"bare","ear","are","era","bear"},{"game","mage","gem","mag","age"},
        {"scar","cars","arc","arcs","car"},{"skin","ink","inks","sink","kin"},
        {"need","eden","nee","den","end"},{"bird","brid","rib","rid","bid"},
        {"gulp","plug","pug","pul","gul"},{"hant","than","ant","tan","hat"},
        {"brag","bag","bar","rag","grab"},{"late","tale","tea","eat","ate"} };
 
 int med_level = 1;
 
  public void medmode() {
     randomizer = rand.nextInt(10);
     out[med_level-1] = randomizer;
    for (int i = 0 ; i != 5 ; i++) {
        currentWord[i] = medWords[randomizer][i];
    }
    
    medium_frame = new JFrame("Medium Mode");
    medium_frame.setLayout(null);
    medium_frame.setSize(1000,1000);
    medium_frame.setVisible(true);
    medium_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    medium_frame.setLocationRelativeTo(null);
   
    medback         = new JButton("back");
    med_submit      = new JButton("Submit word");
    med_shuffle     = new JButton("Shuffle");
    medquit         = new JButton("Quit");
    medskip         = new JButton("Skip");
    guessed_word2   = new JLabel("Guessed Words");
    input2          = new JLabel("Write your words here:");
    tobeGuess2       = new JLabel("Get Your Words Here:");
    med_input       = new JTextField();
    wordDisplayer   = new JTextField();
    word_area       = new JTextArea();
    mscore          = new JTextField();
    mscorel         = new JLabel("score:");
    meimg           = new ImageIcon("C:\\Users\\Asus\\Desktop\\GiveMeWords\\medium.jpg");
    mebg            = new JLabel(meimg);
    medium_frame.setContentPane(mebg);
   
    
     wordDisplayer.setText(shuffle(medWords[randomizer][0]));
     
    medium_frame.add(guessed_word2);
    guessed_word2.setBounds(30,160,200,50);
    guessed_word2.setFont(new Font("exclibur", Font.BOLD, 20));
    
    medium_frame.add(tobeGuess2);
    tobeGuess2.setBounds(350,160,300,50);
    tobeGuess2.setFont(new Font("exclibur", Font.BOLD, 20));
    
    medium_frame.add(input2);
    input2.setBounds(350,360,300,50);
    input2.setFont(new Font("exclibur", Font.BOLD, 20));
     
    medium_frame.add(med_input);
    med_input.setBounds(350,400,300,100);
    med_input.setFont(new Font("exclibur", Font.BOLD, 70));
    med_input.setOpaque(false );
    
    medium_frame.add(mscorel);
    mscorel.setBounds(820,100,100,50);
    mscorel.setFont(new Font("comic sans ms", Font.BOLD, 20));

    medium_frame.add(mscore);
    mscore.setBounds(880,105,100,40);
    mscore.setEditable(false);
    mscore.setText("0");
    mscore.setFont(new Font("comic sans ms", Font.BOLD, 20));
    mscore.setOpaque(false );
    
    medium_frame.add(word_area);
    word_area.setBounds(30,200,200,300);
    word_area.setEditable(false);
    word_area.setFont(new Font("exclibur", Font.BOLD, 40));
    word_area.setOpaque(false );
    
    medium_frame.add(wordDisplayer);
    wordDisplayer.setBounds(350,200,300,100);
    wordDisplayer.setFont(new Font("exclibur", Font.BOLD, 70));
    wordDisplayer.setEditable(false);
    wordDisplayer.setOpaque(false );
  
    medium_frame.add(med_submit);
    med_submit.setBounds(600,600,200,35);
    med_submit.addActionListener(this); 
 
    medium_frame.add(med_shuffle);
    med_shuffle.setBounds(200,600,200,35);
    med_shuffle.addActionListener(this);
    
    medium_frame.add(medback);
    medback.setBounds(215,700,170,35);
    medback.addActionListener(this);
    
    medium_frame.add(medskip);
    medskip.setBounds(415,700,170,35);
    medskip.addActionListener(this);
    
    medium_frame.add(medquit);
    medquit.setBounds(615,700,170,35);
    medquit.addActionListener(this);
 }
  
  // -----------------------------------------------------------------------------------------------------HARD MODE---------------------------------------------------------------------------------  
  
   String[][] hardWords = { {"bare","ear","are","era","bear"},{"game","mage","gem","mag","age"},
        {"scar","cars","arc","arcs","car"},{"skin","ink","inks","sink","kin"},
        {"need","eden","nee","den","end"},{"bird","brid","rib","rid","bid"},
        {"gulp","plug","pug","pul","gul"},{"hant","than","ant","tan","hat"},
        {"brag","bag","bar","rag","grab"},{"late","tale","tea","eat","ate"} };

    int hard_level = 1;

   public void hardmode() {
        randomizer = rand.nextInt(10);
    out[hard_level-1] = randomizer;
    for (int i = 0 ; i != 5 ; i++) {
        currentWord[i] = hardWords[randomizer][i];
    }
    hard_frame = new JFrame("Hard Mode");
    hard_frame.setLayout(null);
    hard_frame.setSize(1000,1000);
    hard_frame.setVisible(true);
    hard_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    hard_frame.setLocationRelativeTo(null);
    
    
    hardback        = new JButton("back");
    hard_submit     = new JButton("Submit word");
    hard_shuffle    = new JButton("Shuffle");
    hardquit        = new JButton("Quit");
    hardskip        = new JButton("Skip");
    guessed_word3   = new JLabel("Guessed Words");
    input3          = new JLabel("Write your words here:");
    tobeGuess3      = new JLabel("Get Your Words Here:");
    hard_input      = new JTextField();
    wordDisplayer   = new JTextField();
    word_area       = new JTextArea();
    hscore          = new JTextField();
    hscorel         = new JLabel("score:");
    haimg           = new ImageIcon("C:\\Users\\Asus\\Desktop\\GiveMeWords\\med.png");
    habg            = new JLabel(haimg);
    hard_frame.setContentPane(habg);
    
    wordDisplayer.setText(shuffle(hardWords[randomizer][0]));
    
    hard_frame.add(guessed_word3);
    guessed_word3.setBounds(30,60,200,50);
    guessed_word3.setFont(new Font("exclibur", Font.BOLD, 20));
    guessed_word3.setForeground(Color.cyan);
    
    hard_frame.add(tobeGuess3);
    tobeGuess3.setBounds(350,160,300,50);
    tobeGuess3.setFont(new Font("exclibur", Font.BOLD, 20));
    tobeGuess3.setForeground(Color.cyan);
    
    hard_frame.add(input3);
    input3.setBounds(350,360,300,50);
    input3.setFont(new Font("exclibur", Font.BOLD, 20));
    input3.setForeground(Color.cyan);
    
    hard_frame.add(hard_input);
    hard_input.setBounds(350,400,300,100);
    hard_input.setFont(new Font("exclibur", Font.BOLD, 70));
    hard_input.setOpaque(false );
    
    hard_frame.add(hscorel);
    hscorel.setBounds(820,100,100,50);
    hscorel.setFont(new Font("comic sans ms", Font.BOLD, 20));
    hscorel.setForeground(Color.cyan);
    
    hard_frame.add(hscore);
    hscore.setBounds(880,105,100,40);
    hscore.setEditable(false);
    hscore.setText("0");
    hscore.setFont(new Font("comic sans ms", Font.BOLD, 20));
    hscore.setOpaque(false );
    hscore.setForeground(Color.cyan);
    
    hard_frame.add(wordDisplayer);
    wordDisplayer.setBounds(350,200,300,100);
    wordDisplayer.setEditable(false);
    wordDisplayer.setFont(new Font("exclibur", Font.BOLD, 70));
    wordDisplayer.setOpaque(false );
    wordDisplayer.setForeground(Color.cyan);
  
    hard_frame.add(word_area);
    word_area.setBounds(30,100,200,300);
    word_area.setEditable(false);
    word_area.setFont(new Font("exclibur", Font.BOLD, 40));
    word_area.setOpaque(false );
    word_area.setForeground(Color.cyan);
     
     hard_frame.add(hard_submit);
   hard_submit.setBounds(600,600,200,35);
    hard_submit.addActionListener((java.awt.event.ActionListener) this); 
 
   hard_frame.add(hard_shuffle);
    hard_shuffle.setBounds(200,600,200,35);
    hard_shuffle.addActionListener(this);
    
    hard_frame.add(hardback);
    hardback.setBounds(215,700,170,35);
    hardback.addActionListener(this);
    
    hard_frame.add(hardskip);
    hardskip.setBounds(415,700,170,35);
    hardskip.addActionListener(this);
    
    hard_frame.add(hardquit);
    hardquit.setBounds(615,700,170,35);
    hardquit.addActionListener(this);
  
    
 }
     JTable table;

     public void highScore (){
        DefaultTableModel model = new DefaultTableModel(); 
        int sorted_array[] = new int[10];
        rank_frame         = new JFrame ("High Score");
        table              = new JTable(model);
        back               = new JButton("Back");
        hslabel            = new JLabel("HIGH SCORES");
        
        rank_frame.setLayout(null);
        rank_frame.setSize(1000,1000);
        rank_frame.setVisible(true);
        rank_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rank_frame.setLocationRelativeTo(null);
        hsimg       = new ImageIcon("C:\\Users\\Asus\\Desktop\\GiveMeWords\\main.jpg");
        hsjepg       = new JLabel(hsimg);
        rank_frame.setContentPane(hsjepg);
        
        rank_frame.add(hslabel);
        hslabel.setFont(new Font("comic sans mt", Font.BOLD, 70));
        hslabel.setBounds(250, 20, 500, 100);
        hslabel.setForeground(Color.cyan);

        
        
      
        rank_frame.add(table);
        model.addColumn("Username");
        model.addColumn("Score");
        
        
        
        for (int i = 0 ; i!= user_count ; i++){
           sorted_array[i] = scores[i];
        }
         Arrays.sort(sorted_array);
        System.out.println(Arrays.toString(sorted_array));
        System.out.println(Arrays.toString(scores));
        
        System.out.println(find(scores,sorted_array[9]));
        System.out.println(user_count);
        for (int i = 9 ; i >= (10-user_count) ; i--) {
            model.addRow(new Object[]{
               users[find(scores,sorted_array[i])],sorted_array[i] 
            });
        }
        
        table.setBounds(350,180,300,500);
        table.setFont(new Font("Comic sans mt", Font.BOLD, 20));
        table.setRowHeight(20);
        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        table.setForeground(Color.cyan);
        table.setEnabled(false);

        
        rank_frame.add(back);
        back.setBounds(400,700,200,35);
        back.addActionListener(this);
    }
     
     public int find(int[] array, int value) {
    for(int i=0; i<array.length; i++) 
         if(array[i] == value)
             return i;
    return 0;
    }

     

   /* public static void main(String[] args) {
        String secret = ;
        int wrongGuesses = 0;
        GiveMeWords GMW = new GiveMeWords(secret);
        System.out.println(GMW.getHidden()); // _____________
        if (GMW.check('a')) {
            System.out.println(GMW.getHidden()); // __a_________
        }
        else {
           wrongGuesses++;
        }
        //... and so on...
    }

  */

    /**
     *
     * @param e
     */
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Submit
        if (e.getSource() == Submit) {
            users[user_count] = username.getText();
            
            JOptionPane.showMessageDialog(null,"Hello " + users[user_count]);
            user_count++;
        if (username.getText().equals("")){
                            JOptionPane.showMessageDialog(null,"Please Input an Username");
        } else {
            application_frame.setVisible(false);
            gameMode();
        }
         }
        //EXIT
        if (e.getSource() == Exit) {
        JOptionPane.showMessageDialog(null,"Thank you!");
            System.exit(0);
        }
         
       
        
        if (e.getSource() == HighScore) {
             application_frame.setVisible(false);
             highScore();
        }
        
        if (e.getSource() == back) {
             rank_frame.setVisible(false);
             application();
        }
        
        if (e.getSource() == backgm) {
             gamemode_frame.setVisible(false);
             application();
        }
        
         if (e.getSource() == easy) {
             gamemode_frame.setVisible(false);
             currentWord = new String[5];
            guessedWord= new String[5];
            counter_guessed = 0;
             easymode();
        }
        if (e.getSource() == medium) {
             gamemode_frame.setVisible(false);
             currentWord = new String[5];
            guessedWord= new String[5];
            counter_guessed = 0;
             medmode();
        }
        if (e.getSource() == hard) {
             gamemode_frame.setVisible(false);
             currentWord = new String[5];
            guessedWord= new String[5];
            counter_guessed = 0;
             hardmode();
        }
       if (e.getSource() == easyback) {
             easy_frame.setVisible(false);
             gameMode();
        }
       if (e.getSource() == easyquit) {
        int confirmed = JOptionPane.showConfirmDialog(null,
           "Are you sure you want to quit?", "User Confirmation",
           JOptionPane.YES_NO_OPTION);
           if (confirmed == JOptionPane.YES_OPTION){
               easy_level = 1;
           med_level = 1;
           hard_level = 1;
               application();  
              
            easy_frame.setVisible(false);
           scores[user_count-1] = Integer.parseInt(escore.getText());
           }
       }
        
        if (e.getSource() == medback) {
             medium_frame.setVisible(false);
             gameMode();
        }
        if (e.getSource() == medquit) {
            
        int confirmed = JOptionPane.showConfirmDialog(null,
           "Are you sure you want to quit?", "User Confirmation",
           JOptionPane.YES_NO_OPTION);
           if (confirmed == JOptionPane.YES_OPTION){
               easy_level = 1;
           med_level = 1;
           hard_level = 1;
           medium_frame.setVisible(false);
           scores[user_count-1] = Integer.parseInt(mscore.getText());
            application(); 
           
           }
        }
        
        if (e.getSource() == hardback) {
             hard_frame.setVisible(false);
             gameMode();
        }
        if (e.getSource() == hardquit) {
            
        int confirmed = JOptionPane.showConfirmDialog(null,
           "Are you sure you want to quit?", "User Confirmation",
           JOptionPane.YES_NO_OPTION);
           if (confirmed == JOptionPane.YES_OPTION){
               easy_level = 1;
           med_level = 1;
           hard_level = 1;
           hard_frame.setVisible(false);
           scores[user_count-1] = Integer.parseInt(hscore.getText());
            application(); 
           
           }
        }
        
         // --------------------------easy -------------------------------------------------------------------------------------------EASY----------------------------
        
        if (e.getSource() == eshuffle) {
            wordDisplayer.setText(shuffle(easyWords[randomizer][0]));
        }
        if (e.getSource() == easyskip){
                    if (easy_level < 3) {
                    JOptionPane.showMessageDialog(null, "skipped this set!"
                            + "proceed to next set!");
                    randomizer = rand.nextInt(10);
                    boolean contains = IntStream.of(out).anyMatch(x -> x == randomizer);
                    
                    while (contains) {
                        
                        randomizer = rand.nextInt(10);
                        contains = IntStream.of(out).anyMatch(x -> x = = randomizer);
                        
                        System.out.println(contains);
                    }
                    
                    out[easy_level-1] = randomizer;
                    word_area.setText("");
                    easy_input.setText("");
                    wordDisplayer.setText(shuffle(easyWords[randomizer][0]));
                    currentWord = new String[5];
                    for (int i = 0 ; i != 5 ; i++) {
                        currentWord[i] = easyWords[randomizer][i];
                    }
                    guessedWord= new String[5];
                    counter_guessed = 0;
                    easy_level++;
                    
                    System.out.println(easy_level);
                    } else {
                        JOptionPane.showMessageDialog(null, "Proceed to Medium level");
                        easy_frame.setVisible(false);
                        medmode();
                    }
                } 
            
        if (e.getSource() == easysubmit){
            
            word_area.setText("");
            String word = easy_input.getText();
            Boolean found = false;
            Boolean guessed = false;
            
            for (int j = 0 ; j != counter_guessed; j++ ) {
                if (word.equals(guessedWord[j])) {
                    JOptionPane.showMessageDialog(null,"Already guessed");
                    guessed = true;
                    found = true;
                    
                }
            }
            
        
            
            if (!guessed) {
                for (int i = 0 ; i != 5 ; i++) {
                    if (word.equals(currentWord[i])) {
                        guessedWord[counter_guessed] = currentWord[i];
                        word_area.append(word +  "\n");
                        JOptionPane.showMessageDialog(null,"Naa");
                        escore.setText(Integer.toString(Integer.parseInt(escore.getText())+10));
                        found = true;
                        easy_input.setText("");
                        counter_guessed++;
                    }
                }
                if (counter_guessed == 5 ) {
                    if (easy_level < 3) {
                    JOptionPane.showMessageDialog(null, "You guessed 5 already! ,"
                            + "proceed to next set!");
                    randomizer = rand.nextInt(10);
                    boolean contains = IntStream.of(out).anyMatch(x -> x == randomizer);
                    
                    while (contains) {
                        
                        randomizer = rand.nextInt(10);
                        contains = IntStream.of(out).anyMatch(x -> x == randomizer);
                        
                        System.out.println(contains);
                    }
                    
                    out[easy_level-1] = randomizer;
                    word_area.setText("");
                    easy_input.setText("");
                    wordDisplayer.setText(shuffle(easyWords[randomizer][0]));
                    currentWord = new String[5];
                    for (int i = 0 ; i != 5 ; i++) {
                        currentWord[i] = easyWords[randomizer][i];
                    }
                    guessedWord= new String[5];
                    counter_guessed = 0;
                    easy_level++;
                    
                    System.out.println(easy_level);
                    } else {
                        JOptionPane.showMessageDialog(null, "Proceed to Medium level");
                        easy_frame.setVisible(false);
                        medmode();
                    }
                } 
            }
            if (!found) {
                JOptionPane.showMessageDialog(null,"Wala jud");
            }
        
        }
             // --------------------------medium ---------------------------------------------------------------------------------------MEDIUM------------------------
            
            if (e.getSource() == med_shuffle) {
                wordDisplayer.setText(shuffle(medWords[randomizer][0]));
            }
            
            if (e.getSource()== medskip) {
       if (med_level < 3) {
                    JOptionPane.showMessageDialog(null, "skip this set ,"
                            + "proceed to next set!");
                    randomizer = rand.nextInt(10);
                    boolean contains = IntStream.of(out).anyMatch(x -> x == randomizer);
                    
                    while (contains) {
                        
                        randomizer = rand.nextInt(10);
                        contains = IntStream.of(out).anyMatch(x -> x == randomizer);
                        
                        System.out.println(contains);
                    }
                    
                    out[med_level-1] = randomizer;
                    word_area.setText("");
                    med_input.setText("");
                    wordDisplayer.setText(shuffle(medWords[randomizer][0]));
                    currentWord = new String[5];
                    for (int i = 0 ; i != 5 ; i++) {
                        currentWord[i] = medWords[randomizer][i];
                    }
                    guessedWord= new String[5];
                    counter_guessed = 0;
                    med_level++;
                    
                    System.out.println(med_level);
                    } else {
                        JOptionPane.showMessageDialog(null, "Proceed to Hard level");
                        medium_frame.setVisible(false);
                        hardmode();
       }
       }
            
          if (e.getSource() == med_submit){
            String word2= med_input.getText();
            Boolean found2 = false;
            Boolean guessed2 = false;
            
            for (int j = 0 ; j != counter_guessed; j++ ) {
                if (word2.equals(guessedWord[j])) {
                    JOptionPane.showMessageDialog(null,"Already guessed");
                    guessed2 = true;
                    found2 = true;
                }
            }
            if (!guessed2) {
                for (int i = 0 ; i != 5 ; i++) {
                    if (word2.equals(currentWord[i])) {
                        guessedWord[counter_guessed] = currentWord[i];
                        word_area.append(word2 + "\n");
                        JOptionPane.showMessageDialog(null,"Naa");
                        mscore.setText(Integer.toString(Integer.parseInt(mscore.getText())+15));
                        found2 = true;
                        med_input.setText("");
                        counter_guessed++;
                    }
                }
                if (counter_guessed == 5 ) {
                    if (med_level < 3) {
                    JOptionPane.showMessageDialog(null, "You guessed 5 already! ,"
                            + "proceed to next set!");
                    randomizer = rand.nextInt(10);
                    boolean contains = IntStream.of(out).anyMatch(x -> x == randomizer);
                    
                    while (contains) {
                        
                        randomizer = rand.nextInt(10);
                        contains = IntStream.of(out).anyMatch(x -> x == randomizer);
                        
                        System.out.println(contains);
                    }
                    
                    out[med_level-1] = randomizer;
                    word_area.setText("");
                    med_input.setText("");
                    wordDisplayer.setText(shuffle(medWords[randomizer][0]));
                    currentWord = new String[5];
                    for (int i = 0 ; i != 5 ; i++) {
                        currentWord[i] = medWords[randomizer][i];
                    }
                    guessedWord= new String[5];
                    counter_guessed = 0;
                    med_level++;
                    
                    System.out.println(med_level);
                    } else {
                        JOptionPane.showMessageDialog(null, "Proceed to Hard level");
                        medium_frame.setVisible(false);
                        hardmode();
                    }
                } 
            }
            if (!found2) {
                JOptionPane.showMessageDialog(null,"Wala jud");
            }
          }
            
           // --------------------------hard -----------------------------------------------------------------------------------------------------HARD---------
            if (e.getSource() == hard_shuffle) {
            wordDisplayer.setText(shuffle(hardWords[randomizer][0]));
        }
            
           if (e.getSource() == hardskip) {
             if (hard_level < 3) {
                    JOptionPane.showMessageDialog(null, "skip this set ,"
                            + "proceed to next set!");
                    randomizer = rand.nextInt(10);
                    boolean contains = IntStream.of(out).anyMatch(x -> x == randomizer);
                    
                    while (contains) {
                        
                        randomizer = rand.nextInt(10);
                        contains = IntStream.of(out).anyMatch(x -> x == randomizer);
                        
                        System.out.println(contains);
                    }
                    
                    out[hard_level-1] = randomizer;
                    word_area.setText("");
                    hard_input.setText("");
                    wordDisplayer.setText(shuffle(hardWords[randomizer][0]));
                    currentWord = new String[5];
                    for (int i = 0 ; i != 5 ; i++) {
                        currentWord[i] = hardWords[randomizer][i];
                    }
                    guessedWord= new String[5];
                    counter_guessed = 0;
                    hard_level++;
                    
                    System.out.println(hard_level);
                    } else {
                        JOptionPane.showMessageDialog(null, "This is the last level");
                        
           }
             
           }
          
            
          if (e.getSource() == hard_submit){
            String word3= hard_input.getText();
            Boolean found3 = false;
            Boolean guessed3 = false;
            
            for (int j = 0 ; j != counter_guessed; j++ ) {
                if (word3.equals(guessedWord[j])) {
                    JOptionPane.showMessageDialog(null,"Already guessed");
                    guessed3 = true;
                    found3 = true;
                }
            }
            if (!guessed3) {
                for (int i = 0 ; i != 5 ; i++) {
                    if (word3.equals(currentWord[i])) {
                        guessedWord[counter_guessed] = currentWord[i];
                        word_area.append(word3 + "\n");
                        JOptionPane.showMessageDialog(null,"Naa");
                        hscore.setText(Integer.toString(Integer.parseInt(hscore.getText())+20));
                        found3 = true;
                        hard_input.setText("");
                        counter_guessed++;
                    }
                }
                if (counter_guessed == 5 ) {
                    if (hard_level < 3) {
                    JOptionPane.showMessageDialog(null, "You guessed 5 already! ,"
                            + "proceed to next set!");
                    randomizer = rand.nextInt(10);
                    boolean contains = IntStream.of(out).anyMatch(x -> x == randomizer);
                    
                    while (contains) {
                        
                        randomizer = rand.nextInt(10);
                        contains = IntStream.of(out).anyMatch(x -> x == randomizer);
                        
                        System.out.println(contains);
                    }
                    
                    out[hard_level-1] = randomizer;
                    word_area.setText("");
                    hard_input.setText("");
                    wordDisplayer.setText(shuffle(hardWords[randomizer][0]));
                    currentWord = new String[5];
                    for (int i = 0 ; i != 5 ; i++) {
                        currentWord[i] = hardWords[randomizer][i];
                    }
                    guessedWord= new String[5];
                    counter_guessed = 0;
                    hard_level++;
                    
                    System.out.println(hard_level);
                    } else {
                        JOptionPane.showMessageDialog(null, "Congratulations you finish all the levels");
                        hard_frame.setVisible(false);
                        application();
                    }
                } 
            }
            if (!found3) {
                JOptionPane.showMessageDialog(null,"Wala jud");
            }
          }
            
            
    }
    
    public static void main(String[] args) {
        
        GiveMeWords GMW = new GiveMeWords();
    }
}


