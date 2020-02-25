package am.davsoft.barcodegenerator;

import am.davsoft.barcodegenerator.api.BarCodeData;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.jfree.graphics2d.svg.SVGGraphics2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author David Shahbazyan
 * @since Apr 07, 2017
 */
public class BarCodeGenerator {
    private static final Map<ErrorCorrectionLevel, Integer> MAX_CHARS_COUNT = new HashMap<ErrorCorrectionLevel, Integer>() {
        {
            put(ErrorCorrectionLevel.L, 2952);
            put(ErrorCorrectionLevel.M, 2330);
            put(ErrorCorrectionLevel.Q, 1662);
            put(ErrorCorrectionLevel.H, 1272);
        }
    };

    private final BarcodeFormat barcodeFormat;

    /**
     * The error correction level of the generated QR code from the lowest to highest.
     * <pre>
     * L = ~7%  correction
     * M = ~15% correction
     * Q = ~25% correction
     * H = ~30% correction
     * </pre>
     */
    private ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.M;
    /**
     * The QR code main color. Default is Color(0, 0, 0, 255).
     *
     * @see Color
     */
    private Color mainColor = new Color(0, 0, 0, 255);
    /**
     * The QR code background color. Default is Color(255, 255, 255, 255).
     *
     * @see Color
     */
    private Color backgroundColor = new Color(255, 255, 255, 0);
    /**
     * The QR code one side size.
     */
    private int width = 200;
    /**
     * The QR code one side size.
     */
    private int height = 200;
    /**
     * The QR code margin from borders. Default is 4.
     */
    private Integer margin = 4;

    public BarCodeGenerator(BarcodeFormat barcodeFormat) {
        this.barcodeFormat = barcodeFormat;
    }

    public Integer getMaxCharsCount() {
        return MAX_CHARS_COUNT.getOrDefault(errorCorrectionLevel, 0);
    }

    /**
     * @see BarCodeGenerator#errorCorrectionLevel
     */
    public BarCodeGenerator setErrorCorrectionLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.errorCorrectionLevel = errorCorrectionLevel;
        return this;
    }

    public ErrorCorrectionLevel getErrorCorrectionLevel() {
        return errorCorrectionLevel;
    }

    /**
     * @see BarCodeGenerator#mainColor
     */
    public BarCodeGenerator setMainColor(Color mainColor) {
        this.mainColor = mainColor;
        return this;
    }

    public Color getMainColor() {
        return mainColor;
    }

    /**
     * @see BarCodeGenerator#backgroundColor
     */
    public BarCodeGenerator setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @see BarCodeGenerator#width
     */
    public BarCodeGenerator setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getWidth() {
        return width;
    }

    /**
     * @see BarCodeGenerator#height
     */
    public BarCodeGenerator setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public BarCodeGenerator setSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    /**
     * @see BarCodeGenerator#margin
     */
    public BarCodeGenerator setMargin(Integer margin) {
        this.margin = margin;
        return this;
    }

    public Integer getMargin() {
        return margin;
    }

    private BitMatrix getBitMatrix(BarCodeData data) throws WriterException {
        Hashtable<EncodeHintType, Object> hintMap = new Hashtable<>();
        switch (barcodeFormat) {
            case AZTEC:
            case PDF_417:
                hintMap.put(EncodeHintType.ERROR_CORRECTION, this.errorCorrectionLevel.getBits());
                break;
            default:
                hintMap.put(EncodeHintType.ERROR_CORRECTION, this.errorCorrectionLevel);
        }
        hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hintMap.put(EncodeHintType.MARGIN, this.margin);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        return multiFormatWriter.encode(data.getData(), this.barcodeFormat, this.width, this.height, hintMap);
    }

    public BufferedImage generateImage(BarCodeData data) throws WriterException {
        BitMatrix bitMatrix = getBitMatrix(data);

        int matrixWidth = bitMatrix.getWidth();
        int matrixHeight = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(matrixWidth, matrixHeight, BufferedImage.TYPE_INT_ARGB);
        image.createGraphics();
        Graphics2D graphics = (Graphics2D) image.getGraphics();

//        graphics.setComposite(AlphaComposite.Clear);
        graphics.setColor(this.backgroundColor);
        graphics.fillRect(0, 0, matrixWidth, matrixHeight);

        graphics.setColor(this.mainColor);

        //Write Bit Matrix as image
        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixHeight; j++) {
                if (bitMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }

        return image;
    }

    public String generateImageAsBase64(BarCodeData data) throws WriterException, IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(generateImage(data), "png", stream);
        return Base64.getEncoder().encodeToString(stream.toByteArray());
    }

    public String generateImageAsSVGString(BarCodeData data) throws WriterException {
        BitMatrix bitMatrix = getBitMatrix(data);
        int matrixWidth = bitMatrix.getWidth();
        int matrixHeight = bitMatrix.getHeight();
        SVGGraphics2D g2 = new SVGGraphics2D(matrixWidth, matrixHeight);
        g2.setColor(this.backgroundColor);
        g2.fillRect(0, 0, matrixWidth, matrixHeight);
        g2.setColor(this.mainColor);
        for (int x = 0; x < matrixWidth; x++) {
            for (int y = 0; y < matrixHeight; y++) {
                if (bitMatrix.get(x, y)) {
                    g2.fillRect(x, y, 1, 1);
                }
            }
        }
        return g2.getSVGElement();
    }
}
