/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlightslab;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author tcr5168
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Slider redSlider;
    @FXML private Slider yellowSlider;
    @FXML private Slider greenSlider;
    @FXML private Circle redLight;
    @FXML private Circle yellowLight;
    @FXML private Circle greenLight;
    
    private double redDelay;
    private double yellowDelay;
    private double greenDelay;
    private Timeline animation;
    
    
    
    @FXML
    private void handleStart(ActionEvent event) {
        System.out.println("Start was pressed");
        redDelay = redSlider.getValue();
        yellowDelay = yellowSlider.getValue();
        greenDelay = greenSlider.getValue();
        
        //convert seconds into milliseconds
        redDelay *= 1000;
        yellowDelay *= 1000;
        greenDelay *= 1000;
        System.out.println(redDelay);
        System.out.println(yellowDelay);
        System.out.println(greenDelay);
        
        //play through the stuff with the delay times
        this.animation = new Timeline(new KeyFrame(Duration.millis(yellowDelay), e->greenOn()), new KeyFrame(Duration.millis(redDelay), e->redOn()), new KeyFrame(Duration.millis(greenDelay), e->yellowOn()));
        this.animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        
    }
    @FXML
    private void handleStop(ActionEvent event) {
        System.out.println("Stop was pressed");
        animation.stop();
        yellowLight.setFill(Color.WHITE);
        greenLight.setFill(Color.WHITE);
        redLight.setFill(Color.WHITE);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void redOn(){
        redLight.setFill(Color.RED);
        yellowLight.setFill(Color.WHITE);
        greenLight.setFill(Color.WHITE);
        System.out.println("Red is on");
    }
    
    public void yellowOn(){
        yellowLight.setFill(Color.YELLOW);
        greenLight.setFill(Color.WHITE);
        redLight.setFill(Color.WHITE);
        System.out.println("Yellow is on");
    }
    
    public void greenOn(){
        greenLight.setFill(Color.GREEN);
        redLight.setFill(Color.WHITE);
        yellowLight.setFill(Color.WHITE);
        System.out.println("Green is on");
    }
    
}
