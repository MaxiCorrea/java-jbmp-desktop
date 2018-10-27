package com.maxicorrea.jbmp.swing;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import com.maxicorrea.jbmp.domain.Image;
import com.maxicorrea.jbmp.presentation.ImageView;
import com.maxicorrea.jbmp.utilswing.ColorConstants;

public class ImageViewSwing extends JPanel implements ImageView {

  private static final long serialVersionUID = 1L;
  private static final int SLEEP = 4_000;

  private JLabel imgLabel;
  private JLabel imgMessage;

  public ImageViewSwing() {
    super(new BorderLayout());
    setBackground(ColorConstants.BACKGROUND_COLOR_2);
    add(getImgPane(), BorderLayout.CENTER);
    add(createSpaceLabel(90, 30), BorderLayout.WEST);
    add(createPanelSouth(), BorderLayout.SOUTH);
    add(createSpaceLabel(50, 30), BorderLayout.EAST);
    add(createSpaceLabel(50, 5), BorderLayout.NORTH);
  }

  private JLabel createSpaceLabel(int width, int height) {
    JLabel jLabel = new JLabel("");
    jLabel.setPreferredSize(new Dimension(width, height));
    return jLabel;
  }

  private JPanel createPanelSouth() {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setPreferredSize(new Dimension(40, 40));
    panel.setBackground(ColorConstants.BACKGROUND_COLOR_2);
    panel.add(getMessageLabel(), BorderLayout.EAST);
    return panel;
  }

  public void showErrorMessage(String message) {
    new Thread(() -> {
      try {
        messageLabel(Color.RED, Color.WHITE, true, message);
        Thread.sleep(SLEEP);
        getMessageLabel().setOpaque(false);
        getMessageLabel().setText("");
      } catch (Exception ex) {
        getMessageLabel().setOpaque(false);
      }
    }).start();
  }

  public void showMessage(String message) {
    new Thread(() -> {
      try {
        messageLabel(Color.GREEN, Color.WHITE, true, message);
        Thread.sleep(SLEEP);
        getMessageLabel().setText("");
        getMessageLabel().setOpaque(false);
      } catch (Exception ex) {
        getMessageLabel().setOpaque(false);
      }
    }).start();
  }

  public void messageLabel(Color back, Color fore, boolean opaque, String message) {
    getMessageLabel().setBackground(back);
    getMessageLabel().setForeground(fore);
    getMessageLabel().setOpaque(opaque);
    getMessageLabel().setText(message);
  }

  public JScrollPane getImgPane() {
    JScrollPane pane = new JScrollPane(getImageLabel());
    pane.setBorder(null);
    pane.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
    pane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 5));
    pane.getViewport().setBackground(new Color(28, 35, 45));
    pane.setBackground(ColorConstants.BACKGROUND_COLOR_2);
    return pane;
  }

  public JLabel getMessageLabel() {
    if (imgMessage == null) {
      imgMessage = new JLabel("", JLabel.CENTER);
      imgMessage.setPreferredSize(new Dimension(200, 25));
    }
    return imgMessage;
  }

  public JLabel getImageLabel() {
    if (imgLabel == null) {
      imgLabel = new JLabel();
    }
    return imgLabel;
  }

  private Image image;
  
  @Override
  public void updateImage(Image image) {
    this.image = image;
    final BufferedImage bufferedImage =
        new BufferedImage(image.getSize().getWidth(), image.getSize().getHeight(), TYPE_INT_ARGB);
    for (int row = 0; row < image.getSize().getHeight(); ++row) {
      for (int col = 0; col < image.getSize().getWidth(); ++col) {
        int r = image.getPixel(row, col).getRed();
        int g = image.getPixel(row, col).getGreen();
        int b = image.getPixel(row, col).getBlue();
        bufferedImage.setRGB(col, row, (new Color(r, g, b)).getRGB());
      }
    }
    imgLabel.setIcon(new ImageIcon(bufferedImage));
  }

  @Override
  public Image getImage() {
    return image;
  }

}
