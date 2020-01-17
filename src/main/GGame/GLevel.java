package main.GGame;

import java.util.Arrays;
import java.util.stream.Collectors;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import jgame.JGLayer;
import jgame.JGScene;

public class GLevel extends JGScene {
	
	JGLayer l1 = new Layer1();
	JGLayer l2 = new Layer2();
	JGLayer l3 = new Layer3();



	public void initialize() {
		System.out.println("GLevel initialize");
		l1.zIndex.set(4);
		l2.zIndex.set(2);
		l3.zIndex.set(3);
		
		layers.add(l1);
		layers.add(l2);
		layers.add(l3);
		
		
//		layers.stream().collect(Collectors.toList());
//        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.RED)};
//
//        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
//
//		Rectangle background = new Rectangle(0, 0, 1500, 1500);
//		background.managedProperty().bind(background.visibleProperty());
//		background.setFill(lg1);
//		background.relocate(-500, -500);
//		stackPane.get().getChildren().addAll(background);
//		background.relocate(-500, -500);
//		
//		Coin coin = new Coin();
//		coin.addToScene();
//		
//		Player player = new Player();
//		player.addToScene();
//		player.node.get().setTranslateX(-300);
//		player.node.get().setTranslateY(-500);
		
		

	}
	
	public void onKeyPress(KeyCode key) {
		l1.zIndex.set(l1.zIndex.get()-1);
	}
}
