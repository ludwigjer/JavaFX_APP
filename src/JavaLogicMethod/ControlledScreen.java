/*
*This is ControlledScreen Interface
 */
package JavaLogicMethod;

import tourismapp.ScreensController;

/**
 *
 * @author ZuoyunJin(16825)
 */
public interface ControlledScreen {
    //Allow the injection of the Parent screensPage
    public void setScreenParent(ScreensController screensPage);
}
