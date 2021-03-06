package jgame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jgame.generics.*;

public class JGSpriteManager {
//	Field<List<Integer>> list = new Field<>(new ArrayList<Integer>());
//	FieldList<Integer> list = new FieldList<>();
	public FieldList<JGSprite> spriteList = new FieldList<>();
	public FieldList<JGSprite> activeSprites = new FieldList<>();
//    private static List<KeyStateEvent> collisionListener = new ArrayList<KeyStateEvent>();

	public JGSpriteManager() {
		JGSceneManager.activeScene.addEventHandler(scene -> {
			activeSprites.clear();
			spriteList.forEach(sprite -> {
				if (sprite.node.get().getScene() != null) {
					System.out.println("sprite " + sprite);
					sprite.initialize();
					activeSprites.add(sprite);
				} else {
//					sprite.destroy();
//					activeSprites.remove(sprite);
//					spriteList.remove(sprite);
				}
			});
			
			System.out.println("layers" +scene.layers);
			System.out.println("activeSprites" + activeSprites);
			System.out.println("spriteList" + spriteList);
		});
		JGame.tick.addEventHandler((event) -> {
			cleanup();
			checkCollisions();
			activeSprites.forEach((sprite) -> {
				sprite.update();
			});
		});
	}
	
    public void checkCollisions() {
    	List<JGSprite> copy = new ArrayList<>();
    	copy.addAll(activeSprites);
        for (JGSprite spriteA : copy) {
            for (JGSprite spriteB : copy) {
                if (spriteA != spriteB && spriteA.intersects(spriteB)) {
                    spriteA.onCollision(spriteA, spriteB);
                    spriteA.onCollision(spriteB);
                }
//                if (!spriteA.getActive()) {
//                	addSpritesToBeRemoved(spriteA);
//                	main.gameengine.Game.getSceneNodes().getChildren().remove(spriteA.getNode());
//                }
            }
        }
    }

    public void cleanup() {
    	List<JGSprite> copy = new ArrayList<>();
    	copy.addAll(spriteList);
    	copy.forEach(sprite -> {
    		if (JGame.sceneManager.activeScene.get().stackPane.get().getChildren().contains(sprite.node.get().getParent())) {
    			sprite.active.set(true);
    		} else {
    			sprite.active.set(false);
    			activeSprites.remove(sprite);
    		}
    	});
//    	spriteList.forEach(sprite -> {
//    		if (!activeSprites.contains(sprite)) {
//    			activeSprites.add(sprite);
//    		}
//    	});
    }
    
    public List<JGSprite> getSprites(Boolean active) {
    	if (active) {
//    		JGame.sceneManager.activeScene.get().stackPane.get().getChildren().contains(sprite.node.get().getParent())
    		return spriteList.stream().filter(p -> p.node.get().getScene() == JGame.sceneManager.activeScene.get().scene.get()).collect(Collectors.toList());
    	}
    	return spriteList.stream().filter(p -> p.node.get().getScene() != JGame.sceneManager.activeScene.get().scene.get()).collect(Collectors.toList());
    }
}
