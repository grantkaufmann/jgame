package jgame;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import jgame.generics.*;

public class JGSprite extends CommonControls {
	public FieldEvent<Double> positionX = new FieldEvent<>(0.0);
	public FieldEvent<Double> positionY = new FieldEvent<>(0.0);
	public Field<Double> velocityX = new Field<>(0.0);
	public Field<Double> velocityY = new Field<>(0.0);
	public FieldEvent<Double> rotate = new FieldEvent<>(0.0);
	public Field<Double> width = new Field<>();
	public Field<Double> height = new Field<>();
	public FieldEvent<Boolean> active = new FieldEvent<>(false);
	public Field<Boolean> canMove = new Field<>(false);
	public Field<Node> node = new Field<>(new ImageView());

	public JGSprite() {
//		JGame.tick.addEventHandler((event) -> {
//			if (active.get()) {
//				if (velocityX.get() != 0) {
//					positionX.set(positionX.get() + velocityX.get());
//				}
//				if (velocityY.get() != 0) {
//					positionY.set(positionY.get() + velocityY.get());
//
//				}
//			}
//		});
		JGame.spriteManager.spriteList.add(this);
		JGame.spriteManager.activeSprites.add(this);
//		System.out.println(JGame.spriteManager.spriteList);
		
		positionX.addEventHandler((x) -> {
			node.get().setTranslateX(x);
		});
		
		positionY.addEventHandler((y) -> {
			node.get().setTranslateY(y);
		});
		
		rotate.addEventHandler((x) -> {
			node.get().setRotate(x);
		});
	}
	
	public void setVelocity(double x, double y) {
		velocityX.set(x);
		velocityY.set(y);
	}
	
	public void addToScene() {
		JGame.sceneManager.activeScene.get().stackPane.get().getChildren().add(node.get());
		active.set(true);
	}
	
	public void removeToScene() {
		JGame.sceneManager.activeScene.get().stackPane.get().getChildren().remove(node.get());
		active.set(false);
	}
	
	public void update() {
		if (active.get()) {
			if (velocityX.get() != 0) {
				positionX.set(positionX.get() + velocityX.get());
			}
			if (velocityY.get() != 0) {
				positionY.set(positionY.get() + velocityY.get());
	
			}
		}
	}
	
    public boolean intersects(JGSprite s)
    {
        return s.node.get().getBoundsInParent().intersects(node.get().getBoundsInParent());
    }
    
    public void onPhysics(JGPhysics p) {}
}
