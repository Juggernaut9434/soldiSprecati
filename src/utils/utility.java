package utils;

import java.awt.image.BufferedImage;

public class utility {
	
	/**
	 * Crops an image to the specified region
	 * @param bufferedImage the image that will be crop
	 * @param x the upper left x coordinate that this region will start
	 * @param y the upper left y coordinate that this region will start
	 * @param width the width of the region that will be crop
	 * @param height the height of the region that will be crop
	 * @return the image that was cropped.
	 */
	public static BufferedImage croppedImage(BufferedImage bufferedImage, int x, int y, int width, int height)
	{
	    return bufferedImage.getSubimage(x, y, width, height);
	}
}
