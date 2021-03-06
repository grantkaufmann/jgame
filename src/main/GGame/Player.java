package main.GGame;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jgame.JGPhysics;
//import main.ID;
//import main.gameengine.nodes.Item;
import jgame.JGSprite;

public class Player extends JGSprite {
	public double speed = 5.0;

    public Player() {
    	Rectangle rectangle = new Rectangle(0, 0, 50, 50);

    	canMove.set(true);
    	active.set(false);
    	rectangle.setFill(Color.RED);
    	node.set(rectangle);
    	positionX.set(200.0);
    	positionY.set(200.0);
    }
    
    public void initialize() {
    	System.out.println("Player initialized");
    }
    
	public void onKeyPress(KeyCode key) {
		if (key == KeyCode.W) {velocityY.set(speed * -1.0);}
		if (key == KeyCode.S) {velocityY.set(speed * 1.0);}
		if (key == KeyCode.A) {velocityX.set(speed * -1.0);}
		if (key == KeyCode.D) {velocityX.set(speed * 1.0);}
		if (key == KeyCode.SPACE) {velocityY.set(-15.0);}
	}
	public void onKeyReleased(KeyCode key) {
		if (key == KeyCode.W) {velocityY.set(0.0);}
		if (key == KeyCode.S) {velocityY.set(0.0);}
		if (key == KeyCode.A) {velocityX.set(0.0);}
		if (key == KeyCode.D) {velocityX.set(0.0);}
	}
	
	public void onCollision(JGSprite sprite) {
		if (velocityY.get() > 0) {
			velocityY.set(0.0);
		}
	}
		
	public void onPhysics(JGPhysics p) {
//		System.out.println("Player onPhysics");
//		System.out.println(this.velocityY.get());
		velocityY.set(velocityY.get() + .5);
		if(velocityY.get() > 20){
			velocityY.set(20.0);
		}
    }
 }

