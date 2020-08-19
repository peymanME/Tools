import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public static BufferedImage border(BufferedImage input, double border)
        {
        int w = input.getWidth();
        int h = input.getHeight();
        BufferedImage output = new BufferedImage(
        w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = output.createGraphics();
        g.drawImage(input, 0, 0, null);

        g.setComposite(AlphaComposite.DstOut);
        Color c0 = new Color(0,0,0,255);
        Color c1 = new Color(0,0,0,0);

        double cy = border;
        double cx = border;

        // Left
        g.setPaint(new GradientPaint(
        new Point2D.Double(0, cy), c0,
        new Point2D.Double(cx,cy), c1));
        g.fill(new Rectangle2D.Double(
        0, cy, cx, h-cy-cy));

        // Right
        g.setPaint(new GradientPaint(
        new Point2D.Double(w-cx, cy), c1,
        new Point2D.Double(w,cy), c0));
        g.fill(new Rectangle2D.Double(
        w-cx, cy, cx, h-cy-cy));

        // Top
        g.setPaint(new GradientPaint(
        new Point2D.Double(cx, 0), c0,
        new Point2D.Double(cx, cy), c1));
        g.fill(new Rectangle2D.Double(
        cx, 0, w-cx-cx, cy));

        // Bottom
        g.setPaint(new GradientPaint(
        new Point2D.Double(cx, h-cy), c1,
        new Point2D.Double(cx, h), c0));
        g.fill(new Rectangle2D.Double(
        cx, h-cy, w-cx-cx, cy));


        // Top Left
        g.setPaint(new RadialGradientPaint(
        new Rectangle2D.Double(0, 0, cx+cx, cy+cy),
        new float[]{0,1}, new Color[]{c1, c0}, MultipleGradientPaint.CycleMethod.NO_CYCLE));
        g.fill(new Rectangle2D.Double(0, 0, cx, cy));

        // Top Right
        g.setPaint(new RadialGradientPaint(
        new Rectangle2D.Double(w-cx-cx, 0, cx+cx, cy+cy),
        new float[]{0,1}, new Color[]{c1, c0}, MultipleGradientPaint.CycleMethod.NO_CYCLE));
        g.fill(new Rectangle2D.Double(w-cx, 0, cx, cy));

        // Bottom Left
        g.setPaint(new RadialGradientPaint(
        new Rectangle2D.Double(0, h-cy-cy, cx+cx, cy+cy),
        new float[]{0,1}, new Color[]{c1, c0}, MultipleGradientPaint.CycleMethod.NO_CYCLE));
        g.fill(new Rectangle2D.Double(0, h-cy, cx, cy));

        // Bottom Right
        g.setPaint(new RadialGradientPaint(
        new Rectangle2D.Double(w-cx-cx, h-cy-cy, cx+cx, cy+cy),
        new float[]{0,1}, new Color[]{c1, c0}, MultipleGradientPaint.CycleMethod.NO_CYCLE));
        g.fill(new Rectangle2D.Double(w-cx, h-cy, cx, cy));

        g.dispose();

        return output;
        }