package com.sso.sys.common.plugs.vcode.generator;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import static com.sso.sys.common.plugs.vcode.generator.XRandoms.num;
import com.sso.sys.common.plugs.vcode.gifencoder.AnimatedGifEncoder;

public class Gif3VCGenerator extends Generator {

	/** background graphic alpha value **/
	private static float bkAlpha = 0.7f; 
	
	/** oval stroke size**/
	private static float ovalSize = 4.0f;
	
	/** oval count. decide to draw how many ovals as background**/
	private static int ovalCount = 10;

	public Gif3VCGenerator() {
	}

	public Gif3VCGenerator(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Gif3VCGenerator(int width, int height, int len) {
		this(width, height);
		this.len = len;
	}

	public Gif3VCGenerator(int width, int height, int len, Font font) {
		this(width, height, len);
		this.font = font;
	}

	/**this constructor is different from others.
	 *  parameters with prefix 'p' are static field.
	 *  be care for the side effect to other beans
	 * @param width image width
	 * @param height image height
	 * @param len validation code length
	 * @param font font features
	 * @param pbkAlpha  alpha channel for image background. default 7f
	 * @param pOvalSize the interference oval strike size. default 4
	 * @param pOvalCount the interference oval count. default 10
	 */
	public Gif3VCGenerator(int width, int height, int len, Font font,
			float pbkAlpha, float pOvalSize, int pOvalCount) {
		this(width, height, len, font);
		bkAlpha = pbkAlpha;
		ovalSize = pOvalSize;
		ovalCount = pOvalCount;
	}
	
	@Override
	public OutputStream write2out(OutputStream out) {
		if (out == null) {
			return null;
		}
		AnimatedGifEncoder gifEncoder = new AnimatedGifEncoder();
		gifEncoder.start(out);
		gifEncoder.setQuality(180);
		gifEncoder.setDelay(100);
		gifEncoder.setRepeat(0);
		BufferedImage frame;
		char[] rands = alphas();
		Color fontcolor[] = new Color[len];
		for (int i = 0; i < len; i++) {
			fontcolor[i] = new Color(20 + num(110), 20 + num(110), 20 + num(110));
		}
		int[] ovalPosition = new int[ovalCount * 4];
		Color[] colors = new Color[ovalCount];		
		for (int i = 0; i < ovalPosition.length; i += 4) {
			ovalPosition[i] = num(width);
			ovalPosition[i+1] = num(height);
			ovalPosition[i+2] = 10 + num(10);
			ovalPosition[i+3] = 10 + num(10);
			colors[i >> 2] = color(150, 250);
		}
		for (int i = 0; i < len; i++) {
			frame = getValidCodeImage(fontcolor, rands, ovalPosition, colors, i);
			gifEncoder.addFrame(frame);
			frame.flush();
		}
		gifEncoder.finish();
		return out;
	}

	/** draw one frame for the GIF image
	 * @param fontcolor font color
	 * @param strs validation string
	 * @param flag
	 * @return
	 */
	private BufferedImage getValidCodeImage(Color[] fontcolor, char[] strs, int[] ovalPosition, Color[] colors, int flag) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) image.getGraphics();
		// set background color to white
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, width, height);
		g2d.setStroke(new BasicStroke(ovalSize));
		AlphaComposite ac3;
		ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, bkAlpha);// specify the background graphic's alpha channel
		g2d.setComposite(ac3);

		// draw random ovals
		for (int i = 0; i < ovalPosition.length; i += 4) {
			g2d.setColor(colors[i >> 2]);		
			g2d.drawOval(ovalPosition[i], ovalPosition[i+1], ovalPosition[i+2], ovalPosition[i+3]);
		}
		int h = height - ((height - font.getSize()) >> 1);
		int w = width / len;
		g2d.setFont(font);
		for (int i = 0; i < len; i++) {
			ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getAlpha(flag, i));
			g2d.setComposite(ac3);
			g2d.setColor(fontcolor[i]);						
			int degree = num(90); // random rotate degree. -90 < degree < 90
			degree = num(2) == 0 ? -degree : degree;
			g2d.rotate(Math.toRadians(degree), (width - (len - i) * w) + (w >> 1), (height >> 1) + 2);
			g2d.drawString(strs[i] + "", (width - (len - i) * w) + (w - font.getSize()) + 1, h - 4);
			g2d.rotate(-Math.toRadians(degree), (width - (len - i) * w) + (w >> 1), (height >> 1) + 2);
		}
		g2d.dispose();
		return image;
	}

	/** Calculate alpha
	 * @param i
	 * @param j
	 * @return
	 */
	private float getAlpha(int i, int j) {
		int num = i + j;
		float r = (float) 1 / len, s = (len + 1) * r;
		return num > len ? (num * r - s) : num * r;
	}

	/* return null for all invoke. 
	 * @see com.xinguang.xvcode.generator.Captcha#getValidCodeImage(char[])
	 */
	@Override
	public BufferedImage getValidCodeImage() {
		return null;
	}

}
