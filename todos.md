# TODOs

## Logic
- [ ] Should we make NPC's? (Y/N) ie characters moving on the casino floor
- [ ] 
- [ ] 

## World Build
- [ ] Sprite Sheet of characters
- [ ] Sprite Sheet of backgrounds / grounds
- [ ] Split up the Sprite Sheet into individual images. 
	- `cropImage(BufferedImage, int, int, int, int)` -> 1D array of character chosen.
- [ ] foobar

## Game Decisions
### Concept
- Top down 2D like pokemon
- Taking sprite sheets from internet and acknowledging them in credits
- No jumping

### Design
- Have a public repo on Github with a a GPLv3 License
- Java and JavaFX

#### Sprites
- Using `cropImage(BufferedImage, int, int, int, int)` to 
capture individual sprites and create 1D array of the character
the player chose
- Have the height and width of sprite as a constant
- Assuming sprites are in a line or a square config,
Have a for loop in a for to get the x and y -> add image to `spriteArray`


## For the Professor
- [ ] UML DIAGRAM in powerpoint etc
	- [ ] with brief description why designed that way
- [ ] presentation 8-10 minutes with game and UML
	- [ ] prepare to answer questions


## Code Pieces

```java
	/**
	 * Crops an image to the specified region
	 * @param bufferedImage the image that will be crop
	 * @param x the upper left x coordinate that this region will start
	 * @param y the upper left y coordinate that this region will start
	 * @param width the width of the region that will be crop
	 * @param height the height of the region that will be crop
	 * @return the image that was cropped.
	 */
	public static BufferedImage cropImage(BufferedImage bufferedImage, int x, int y, int width, int height){
	    BufferedImage croppedImage = bufferedImage.getSubimage(x, y, width, height);
	    return croppedImage;
	}
```
```java
ArrayList<ArrayList<BufferedImage>> spriteArray = new ArrayList<ArrayList<BufferedImage>>();
// row is a direction with different images ie stand still, walking
// column is a different direction
```

### Key Bindings
| Movement        | KeyBind  |
|-----------------|----------|
| Move Up         | UP, W    |
| Move Down       | DOWN, S  |
| Move Left       | LEFT, A  |
| Move Right      | RIGHT, D |
| Interact        | E        |
| Dialog Continue | Space    |
| Pause           | Esc, P   |
| Save            | Ctrl+S   |