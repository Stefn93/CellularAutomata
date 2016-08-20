package framework.gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import framework.worldmodel.World2D;

@SuppressWarnings("serial")
public abstract class CellCanvas<T> extends Canvas{
	   protected Image offScrImage;
       protected Graphics image_handle;
       protected World2D<T> grid;
       protected int old_gridsize = -99; 

       
       public void forceResize() {
    	   old_gridsize = -1;
       }
       
       protected CellCanvas(World2D<T> grid) {
    	   this.grid = grid;
       }
       
       public abstract void start_up();
       public abstract void update(Graphics g);
       
       
       public Image getOffScrImage() {
    	   return offScrImage;
       }
       
       public Graphics getImageHandle() {
    	   return image_handle;
       }
}
