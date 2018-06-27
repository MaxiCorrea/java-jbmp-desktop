package com.maxicorrea.jbmp.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.maxicorrea.jbmp.controllers.EssentialsController;
import com.maxicorrea.jbmp.controllers.OperationController;
import com.maxicorrea.jbmp.views.utils.ColorConstants;
import com.maxicorrea.jbmp.views.utils.IconLocations;
import com.maxicorrea.jbmp.views.utils.MotionFrame;
import com.maxicorrea.jbmp.views.utils.TextLabels;

public class EditorView {

  static final int FRAME_WIDTH = 990;
  static final int FRAME_HEIGHT = 580;

  private final JFrame mainFrame;
  private Item essentials;
  private Item filters;
  private Item flips;
  private ImageView imageView;

  public EditorView(ImageView imageView) {
    this.imageView = imageView;
    mainFrame = new JFrame(TextLabels.APP_TITLE);
    mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setIconImage(
        Toolkit.getDefaultToolkit().getImage(getClass().getResource(IconLocations.FAVICON)));
    mainFrame.setUndecorated(true);
    mainFrame.setContentPane(getContentPane(imageView));
    mainFrame.setLocationRelativeTo(null);
  }

  private JPanel getContentPane(ImageView imageView) {
    JPanel contentPane = new JPanel(new BorderLayout());
    contentPane.setBackground(ColorConstants.BACKGROUND_COLOR);
    contentPane.add(new MotionFrame(mainFrame), BorderLayout.NORTH);
    contentPane.add(imageView, BorderLayout.CENTER);
    contentPane.add(createWestPane(), BorderLayout.WEST);
    return contentPane;
  }

  private JScrollPane createWestPane() {
    JScrollPane pane = new JScrollPane();
    pane.setBackground(ColorConstants.BACKGROUND_COLOR);
    pane.setPreferredSize(new Dimension(145, 100));
    pane.setBorder(null);
    JPanel itemsPanel = new JPanel();
    itemsPanel.setBackground(ColorConstants.BACKGROUND_COLOR);
    JPanel extra = new JPanel();
    extra.setBackground(ColorConstants.BACKGROUND_COLOR);
    extra.setLayout(new BoxLayout(extra, BoxLayout.PAGE_AXIS));
    extra.add(getEssentialItems());
    extra.add(getFilterItems());
    extra.add(getFlipItems());
    itemsPanel.add(extra);
    pane.setViewportView(itemsPanel);
    pane.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
    pane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 5));
    return pane;
  }

  Item getEssentialItems() {
    if (essentials == null) {
      essentials = new Item(new TitleItem(TextLabels.TITLE_ESSENTIAL));
      essentials.addSubItem(new SubItem(TextLabels.OPEN, IconLocations.OPEN, "Open"));
      essentials.addSubItem(new SubItem(TextLabels.SAVE, IconLocations.SAVE, "Save"));
      essentials.addSubItem(new SubItem(TextLabels.RESET, IconLocations.RESET, "Reset"));
    }
    return essentials;
  }

  Item getFilterItems() {
    if (filters == null) {
      filters = new Item(new TitleItem(TextLabels.TITLE_FILTER));
      filters.addSubItem(new SubItem(TextLabels.GRAYSCALE, IconLocations.FILTER, "Grayscale"));
      filters.addSubItem(new SubItem(TextLabels.NEGATIVE, IconLocations.FILTER, "Negative"));
      filters.addSubItem(new SubItem(TextLabels.SEPIA, IconLocations.FILTER, "Sepia"));
      filters.addSubItem(new SubItem(TextLabels.BLUR, IconLocations.FILTER, "Blur"));
      filters.addSubItem(new SubItem(TextLabels.EDGES, IconLocations.FILTER, "Edges"));
    }
    return filters;
  }

  Item getFlipItems() {
    if (flips == null) {
      flips = new Item(new TitleItem(TextLabels.TITLE_FLIP));
      flips.addSubItem(new SubItem(TextLabels.VERTICAL, IconLocations.VERTICAL, "Vertical"));
      flips.addSubItem(new SubItem(TextLabels.HORIZONTAL, IconLocations.HORIZONTAL, "Horizontal"));
      flips.addSubItem(new SubItem(TextLabels.RIGHT, IconLocations.ROTATE_RIGHT, "Right"));
      flips.addSubItem(new SubItem(TextLabels.LEFT, IconLocations.ROTATE_LEFT, "Left"));
    }
    return flips;
  }

  public void show() {
    mainFrame.setVisible(true);
  }

  public void setOperationController(OperationController controller) {
    for (SubItem subItem : filters.getSubItems())
      subItem.getButton()
          .addActionListener((ActionEvent e) -> controller.control(e.getActionCommand()));
    for (SubItem subItem : flips.getSubItems())
      subItem.getButton()
          .addActionListener((ActionEvent e) -> controller.control(e.getActionCommand()));
  }

  public void setEssentialsController(EssentialsController controller) {
    for (SubItem subItem : essentials.getSubItems()) {
      subItem.getButton()
          .addActionListener((ActionEvent e) -> controller.control(e.getActionCommand()));
    }
  }

  public File showOpenChooser() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileFilter(new FileNameExtensionFilter("imagen BMP", "bmp"));
    if (chooser.showOpenDialog(mainFrame) == 0) {
      return chooser.getSelectedFile();
    }
    return null;
  }

  public File showSaveChooser() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileFilter(new FileNameExtensionFilter("imagen BMP", "bmp"));
    if (chooser.showSaveDialog(mainFrame) == 0) {
      return chooser.getSelectedFile();
    }
    return null;
  }

  public void showMessage(String message) {
    imageView.showMessage(message);
  }

  public void showErrorMessage(String errMessage) {
    imageView.showErrorMessage(errMessage);
  }

  public ImageView getImageView() {
    return imageView;
  }

}
