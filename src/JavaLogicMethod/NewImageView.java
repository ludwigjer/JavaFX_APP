/*
 * This is NewImageView class
 */
package JavaLogicMethod;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *@author ZuoyunJin(16825)
 */
public class NewImageView extends ImageView{
    
    private String imagePath;
    
    public NewImageView(Image image)
    {
        setImage(image);
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
