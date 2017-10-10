/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectflappy;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;


/**
 *
 * @author Home
 */
public final class TheGame extends JFrame  implements MouseListener{
JPanel jp;
//declaration of the varibles

int x_width = 500;
int y_height = 500;

int count = 5 ;

Ellipse2D Ball;


int x_ball;
int y_ball;
int cord_xup1,cord_xdown1;
int cord_xup2,cord_xdown2;
int cord_xup3,cord_xdown3;
int cord_xup4,cord_xdown4;
int cord_xup5,cord_xdown5;

Boolean flag = true;

RoundRectangle2D up1,down1,up2,down2,up3,down3,up4,down4;

Font font = new Font("Matura MT Script Capitals",Font.ROMAN_BASELINE,40);
Font font1 = new Font("Matura MT Script Capitals",Font.ROMAN_BASELINE,20);
Font font3 = new Font("Matura MT Script Capitals",Font.ROMAN_BASELINE,20);

float das[] = {10.0f};
BasicStroke color = new BasicStroke(10,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL,20.0f,das,0.0f); 


GradientPaint gp2 = new GradientPaint(20, 0, 
Color.DARK_GRAY, 0, 10, Color.GRAY, true);
   
GradientPaint gp3 = new GradientPaint(30, 0, 
Color.BLACK, 0, 20, Color.GREEN, true);

Toolkit kit = Toolkit.getDefaultToolkit();

 //Getting the "background.jpg" image we have in the folder

Image background = kit.getImage(getClass().getResource("1.png"));
 
JLabel a = new JLabel("Get Ready ! Click to Start.");
JLabel retry = new JLabel(new ImageIcon(  getClass().getResource("unnamed.png")   ));

int score = 0;


    //constructor
    public TheGame() throws IOException 
    {
        
        super("Flapping Circle");
        setSize(x_width, y_height);
        setLocationRelativeTo ( null );
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        jp = new DrawingPanel();
       
        add(jp);
        
        addMouseListener(this);
    }
    
      ActionListener action = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                update();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           repaint();
        }
    
     };
    Timer t = new Timer(50,action);   
        
    
    public void init()
    {
        x_ball = 30;
        y_ball = 200;
        
        cord_xup1 = 175; cord_xdown1 = 175;
        cord_xup2 = 320; cord_xdown2 = 320;
        cord_xup3 = 460; cord_xdown3 = 460;
        cord_xup4 = 585; cord_xdown4 = 585;
        cord_xup5 = 700; cord_xdown5 = 700;
        
       retry.setVisible(false);
            retry.setBounds(175,260,46,46);
            a.setForeground(Color.YELLOW);
            a.setFont(font1);
            a.setVisible(true);
            a.setBounds(105,200,300,100);
            
  }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        a.setVisible(false);
        if( flag == false)
        {
            t.stop();
            
        }
        else
        {
            t.start();
            
        }
       y_ball = y_ball - 40;
        count--; 
        
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // for drawing on the panel
    class DrawingPanel extends JPanel{
        private static final long serialVersionUID = 1L;
        
        public DrawingPanel() {
            setPreferredSize(new Dimension(300, 300));
            setLayout(null);
            init();
            
            add(a);
            add(retry);
            
           // addMouseListener(this);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D d = (Graphics2D)g;
            
            d.drawImage(background, -270,-30, this);
            Ball = new Ellipse2D.Double(x_ball,y_ball,30,30);
            
            d.setColor(Color.green);
            d.setFont(font3);
            
            
            up1 = new RoundRectangle2D.Double(cord_xup1,-5,30,175,20,20);
            down1 = new RoundRectangle2D.Double(cord_xdown1,310,30,155,20,20);
            
            up2 = new RoundRectangle2D.Double(cord_xup2,-5,30,200,20,20);
            down2 = new RoundRectangle2D.Double(cord_xdown2,310,30,175,20,20);
            
            up3 = new RoundRectangle2D.Double(cord_xup3,-5,30,230,20,20);
            down3 = new RoundRectangle2D.Double(cord_xdown3,350,30,135,20,20);
            
            up4 = new RoundRectangle2D.Double(cord_xup4,-5,30,115,20,20);
            down4 = new RoundRectangle2D.Double(cord_xdown4,240,30,115,20,20);
            
            d.setPaint(gp2);
            d.setStroke(color);
            d.fill(up1);
            d.fill(down1);
            
            d.fill(up2);
            d.fill(down2);
            
            d.fill(up3);
            d.fill(down3);
            
            d.fill(up4);
            d.fill(down4);
            
            
            d.setPaint(gp3);
            d.setStroke(color);
            d.fill(Ball);
            d.setColor(Color.BLACK);
            d.setFont(font1);
            d.drawString(""+score ,200,50);
           
            
            retry.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent event) {
            
            init();
            score = 0 ;
            flag = true;
            repaint();
        }

        //...

                @Override
                public void mousePressed(MouseEvent e) {
                 //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                 //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseExited(MouseEvent e) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
    });
                if( Ball.intersects(up1.getBounds()) || Ball.intersects(down1.getBounds()) || Ball.intersects(up2.getBounds()) || Ball.intersects(down2.getBounds()) || Ball.intersects(up3.getBounds()) || Ball.intersects(down3.getBounds()) || Ball.intersects(up4.getBounds()) || Ball.intersects(down4.getBounds()))
        {
            t.stop();
            flag = false;
            
            d.setColor(Color.red);
            d.setFont(font);
            d.drawString("Game Over : "+score ,100,250);
            retry.setVisible(true);
                try {
                    gameover();
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
            
            
            
        }
       
    }   
    public void update() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        
        cord_xdown1 -= 5;
        cord_xup1 -= 5;
        
        cord_xdown2 -= 5;
        cord_xup2 -= 5;
        
        cord_xdown3 -= 5;
        cord_xup3 -= 5;
        
        cord_xdown4 -= 5;
        cord_xup4 -= 5;
        
        cord_xdown5 -= 5;
        cord_xup5 -= 5;
        
        if( cord_xup1 <=-20)
        {
            cord_xup1 = 500;
            cord_xdown1 = 500;
        }
        if( cord_xup2 <=-20)
        {
            cord_xup2 = 500;
            cord_xdown2 = 500;
        }
        if( cord_xup3 <=-20)
        {
            cord_xup3 = 500;
            cord_xdown3 = 500;
        }
        if( cord_xup4 <=-20)
        {
            cord_xup4 = 500;
            cord_xdown4 = 500;
        }
        if( cord_xup5 <=-20)
        {
            cord_xup5 = 500;
            cord_xdown5 = 500;
        }
        
        if(count >= 0)
        {
            y_ball = y_ball - 7;
            count--;
           
            if( y_ball == y_height)
            {
                t.stop();
            }
        }
        else
        {
            y_ball = y_ball + 7;
            if( y_ball == y_height-70)
            {
                t.stop();
            }
        }
        
        if(cord_xdown1 == x_ball || cord_xdown2 == x_ball || cord_xdown3 == x_ball || cord_xdown4  == x_ball)
            {   
                score = score+1;
                SCOREUP();
            }
    }
    
      public void SCOREUP() throws UnsupportedAudioFileException, IOException, LineUnavailableException
        {
             try{ 
                 URL defaultSound = this.getClass().getResource("smb_pause.wav");
                 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(defaultSound);
                 Clip clip = AudioSystem.getClip();
                 clip.open(audioInputStream);
                 clip.start(); 
             }
             catch(Exception e)
             {
                 JOptionPane.showMessageDialog(null, e);
             }
       }
      public void gameover() throws UnsupportedAudioFileException, IOException, LineUnavailableException
        {
              try{ 
                 URL defaultSound = this.getClass().getResource("blip.wav");
                 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(defaultSound);
                 Clip clip = AudioSystem.getClip();
                 clip.open(audioInputStream);
                 clip.start();
             }
             catch(Exception e)
             {
                 JOptionPane.showMessageDialog(null, e);
             }
       }
    
     public static void main(String[] args) throws IOException {
        new TheGame();
        
    }
    
}
