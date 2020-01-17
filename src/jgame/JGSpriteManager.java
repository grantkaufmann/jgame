package jgame;

import java.util.ArrayList;
import java.util.List;

import jgame.generics.*;

public class JGSpriteManager {
//	Field<List<Integer>> list = new Field<>(new ArrayList<Integer>());
	FieldList<Integer> list = new FieldList<>();
	public FieldList<JGSprite> spriteList = new FieldList<>();
	public JGSpriteManager() {
		
		JGame.tick.addEventHandler((event) -> {
			spriteList.forEach((sprite) -> {
				sprite.update();
			});
		});
//		System.out.println(list);
		
//		list.addEventHandler((list, changed) -> {
//			System.out.println("HERE " + list);
//		});
//		list.add(1);
//		list.add(2);

	}
}
