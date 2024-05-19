/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectx;

import javax.swing.JFrame;

/**
 *
 * @author unknown
 */
public class ProjectX {


    public static void main(String[] args) {
    //Inputs IN =new Inputs();    
    MyFrame frame = new MyFrame("Window");
    frame.setSize(1920, 1080);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
    AnalizingInput pros=new AnalizingInput();
    pros.con();
    }
    
}
