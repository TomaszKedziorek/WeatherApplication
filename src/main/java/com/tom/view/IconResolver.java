package com.tom.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IconResolver {
  
  public static ImageView getIconForGivenIconNumber(int iconNumber){
    return new ImageView(new Image(IconResolver.class.getResourceAsStream("icons/"+iconNumber+ "-s.png")));
  }
  
}
