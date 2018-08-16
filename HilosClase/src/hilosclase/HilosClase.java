/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosclase;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class HilosClase extends Application {

    private boolean run = true;
    
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane p = new Pane();
        stage.setScene(new Scene(p));
        
        ImageView iv = new ImageView(
                new Image(HilosClase.class.getResourceAsStream("/recursos/box.png"))); 
        p.getChildren().add(iv);
        ImageView iv2 = new ImageView(
                new Image(HilosClase.class.getResourceAsStream("/recursos/pay.png"))); 
        p.getChildren().add(iv2);
        iv2.setTranslateX(400);
        animar(iv, iv2);
        stage.show();
    }
    
    private void animar(ImageView i1, ImageView i2) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(run) {
                    i1.setTranslateX(i);
                    try { 
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(HilosClase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i += 10;
                }
            }
        };
        Thread t = new Thread(r);
        t.setPriority(1);
        t.start();
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(run) {
                    i2.setTranslateX(i);
                    try { 
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(HilosClase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i += 10;
                }
            }
        };
        new Thread(r2).start();
    }
    
    @Override
    public void stop() {
        run = false;
    }
}
