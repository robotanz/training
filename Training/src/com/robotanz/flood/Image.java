package com.robotanz.flood;

public class Image {
	
	private final int[] image;
	
	final int width, height;
	
	/**
	 * Constructor with image reference to be used
	 * @param image array of size width*height
	 */
	public Image(int[] image, int width, int height) {
		super();
		// TODO should check image size and throw and exception if not consistent
		this.image = image;
		this.width = width;
		this.height = height;
	}
	
	public Color getColor(Point point) {
		return new Color(image[point.x + width*point.y]);
	}
	
	public void setColor(Point point, Color color) {
		image[point.x + width * point.y] = color.value;
	}
}
