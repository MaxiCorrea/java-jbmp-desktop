package com.maxicorrea.jbmp.swing;

import static com.maxicorrea.jbmp.swing.OperationViewSwing.createSubItem;
import static com.maxicorrea.jbmp.utilswing.ColorConstants.BACKGROUND_COLOR;
import static com.maxicorrea.jbmp.utilswing.IconLocations.FAVICON_ICON;
import static com.maxicorrea.jbmp.utilswing.IconLocations.FILTER_ICON;
import static com.maxicorrea.jbmp.utilswing.IconLocations.HORIZONTAL_ICON;
import static com.maxicorrea.jbmp.utilswing.IconLocations.OPEN_ICON;
import static com.maxicorrea.jbmp.utilswing.IconLocations.RESET_ICON;
import static com.maxicorrea.jbmp.utilswing.IconLocations.ROTATE_LEFT_ICON;
import static com.maxicorrea.jbmp.utilswing.IconLocations.ROTATE_RIGHT_ICON;
import static com.maxicorrea.jbmp.utilswing.IconLocations.SAVE_ICON;
import static com.maxicorrea.jbmp.utilswing.IconLocations.VERTICAL_ICON;
import static com.maxicorrea.jbmp.utilswing.TextLabels.APP_TITLE;
import static com.maxicorrea.jbmp.utilswing.TextLabels.BLUR_TEXT;
import static com.maxicorrea.jbmp.utilswing.TextLabels.EDGES_TEXT;
import static com.maxicorrea.jbmp.utilswing.TextLabels.GRAYSCALE_TEXT;
import static com.maxicorrea.jbmp.utilswing.TextLabels.HORIZONTAL_TEXT;
import static com.maxicorrea.jbmp.utilswing.TextLabels.LEFT_TEXT;
import static com.maxicorrea.jbmp.utilswing.TextLabels.NEGATIVE_TEXT;
import static com.maxicorrea.jbmp.utilswing.TextLabels.OPEN_TEXT;
import static com.maxicorrea.jbmp.utilswing.TextLabels.RESET_TEXT;
import static com.maxicorrea.jbmp.utilswing.TextLabels.RIGHT_TEXT;
import static com.maxicorrea.jbmp.utilswing.TextLabels.SAVE_TEXT;
import static com.maxicorrea.jbmp.utilswing.TextLabels.SEPIA_TEXT;
import static com.maxicorrea.jbmp.utilswing.TextLabels.TITLE_ESSENTIAL;
import static com.maxicorrea.jbmp.utilswing.TextLabels.TITLE_FILTER;
import static com.maxicorrea.jbmp.utilswing.TextLabels.TITLE_FLIP;
import static com.maxicorrea.jbmp.utilswing.TextLabels.VERTICAL_TEXT;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.WEST;
import static java.awt.Toolkit.getDefaultToolkit;
import static javax.swing.BoxLayout.PAGE_AXIS;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.maxicorrea.jbmp.presentation.AppView;
import com.maxicorrea.jbmp.presentation.AppViewContext;
import com.maxicorrea.jbmp.usecases.AppUseCasesContext;
import com.maxicorrea.jbmp.utilswing.Item;
import com.maxicorrea.jbmp.utilswing.MotionFrame;
import com.maxicorrea.jbmp.utilswing.TitleItem;

public class AppViewSwing implements AppView {

  static final int FRAME_WIDTH = 990;
  static final int FRAME_HEIGHT = 580;

  private final JFrame mainFrame;

  private Item essentials;
  private OperationViewSwing open;
  private OperationViewSwing save;
  private OperationViewSwing reset;

  private Item filters;
  private OperationViewSwing grayscale;
  private OperationViewSwing negative;
  private OperationViewSwing sepia;
  private OperationViewSwing blur;
  private OperationViewSwing edges;

  private Item flips;
  private OperationViewSwing vertical;
  private OperationViewSwing horizontal;
  private OperationViewSwing right;
  private OperationViewSwing left;

  private ImageViewSwing imageView;

  public AppViewSwing() {
    imageView = new ImageViewSwing();
    mainFrame = new JFrame(APP_TITLE);
    mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    mainFrame.setIconImage(getDefaultToolkit().getImage(getClass().getResource(FAVICON_ICON)));
    mainFrame.setUndecorated(true);
    mainFrame.setContentPane(getContentPane());
    mainFrame.setLocationRelativeTo(null);
  }

  private JPanel getContentPane() {
    JPanel contentPane = new JPanel(new BorderLayout());
    contentPane.setBackground(BACKGROUND_COLOR);
    contentPane.add(new MotionFrame(mainFrame), NORTH);
    contentPane.add(imageView, CENTER);
    contentPane.add(createWestPane(), WEST);
    return contentPane;
  }

  private JScrollPane createWestPane() {
    JScrollPane pane = new JScrollPane();
    pane.setBackground(BACKGROUND_COLOR);
    pane.setPreferredSize(new Dimension(145, 100));
    pane.setBorder(null);
    JPanel itemsPanel = new JPanel();
    itemsPanel.setBackground(BACKGROUND_COLOR);
    JPanel extra = new JPanel();
    extra.setBackground(BACKGROUND_COLOR);
    extra.setLayout(new BoxLayout(extra, PAGE_AXIS));
    extra.add(getEssentialItems());
    extra.add(getFilterItems());
    extra.add(getFlipItems());
    itemsPanel.add(extra);
    pane.setViewportView(itemsPanel);
    pane.getVerticalScrollBar().setPreferredSize(new Dimension(5, 0));
    pane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 5));
    return pane;
  }

  public Item getEssentialItems() {
    if (essentials == null) {
      essentials = new Item(new TitleItem(TITLE_ESSENTIAL));
      essentials.addSubItem(open = createSubItem(OPEN_TEXT, OPEN_ICON));
      essentials.addSubItem(save = createSubItem(SAVE_TEXT, SAVE_ICON));
      essentials.addSubItem(reset = createSubItem(RESET_TEXT, RESET_ICON));
    }
    return essentials;
  }

  public Item getFilterItems() {
    if (filters == null) {
      filters = new Item(new TitleItem(TITLE_FILTER));
      filters.addSubItem(grayscale = createSubItem(GRAYSCALE_TEXT, FILTER_ICON));
      filters.addSubItem(negative = createSubItem(NEGATIVE_TEXT, FILTER_ICON));
      filters.addSubItem(sepia = createSubItem(SEPIA_TEXT, FILTER_ICON));
      filters.addSubItem(blur = createSubItem(BLUR_TEXT, FILTER_ICON));
      filters.addSubItem(edges = createSubItem(EDGES_TEXT, FILTER_ICON));
    }
    return filters;
  }

  public Item getFlipItems() {
    if (flips == null) {
      flips = new Item(new TitleItem(TITLE_FLIP));
      flips.addSubItem(vertical = createSubItem(VERTICAL_TEXT, VERTICAL_ICON));
      flips.addSubItem(horizontal = createSubItem(HORIZONTAL_TEXT, HORIZONTAL_ICON));
      flips.addSubItem(right = createSubItem(RIGHT_TEXT, ROTATE_RIGHT_ICON));
      flips.addSubItem(left = createSubItem(LEFT_TEXT, ROTATE_LEFT_ICON));
    }
    return flips;
  }

  public void initializeViews() {
    AppViewContext.appView = this;
    AppViewContext.imageView = imageView;
    AppViewContext.openView = open;
    AppViewContext.saveView = save;
    AppViewContext.resetView = reset;
    AppViewContext.grayScaleView = grayscale;
    AppViewContext.nagativeView = negative;
    AppViewContext.sepiaView = sepia;
    AppViewContext.blurView = blur;
    AppViewContext.edgesView = edges;
    AppViewContext.verticalView = vertical;
    AppViewContext.horizonalView = horizontal;
    AppViewContext.rightView = right;
    AppViewContext.leftView = left;
  }

  public void initializeUseCases() {
    open.setUseCase(AppUseCasesContext.openImageUseCase);
    save.setUseCase(AppUseCasesContext.saveImageUseCase);
    reset.setUseCase(AppUseCasesContext.applyResetUseCase);
    grayscale.setUseCase(AppUseCasesContext.applyGrayscaleUseCase);
    negative.setUseCase(AppUseCasesContext.applyNegativeUseCase);
    sepia.setUseCase(AppUseCasesContext.applySepiaUseCase);
    blur.setUseCase(AppUseCasesContext.applyBlurUseCase);
    edges.setUseCase(AppUseCasesContext.applyEdgesUseCase);
    vertical.setUseCase(AppUseCasesContext.applyVerticalUseCase);
    horizontal.setUseCase(AppUseCasesContext.applyHorizontalUseCase);
    right.setUseCase(AppUseCasesContext.applyRightUseCase);
    left.setUseCase(AppUseCasesContext.applyLeftUseCase);
  }

  public void show() {
    mainFrame.setVisible(true);
  }

  public void showMessage(String message) {
    imageView.showMessage(message);
  }

  public void showErrorMessage(String errMessage) {
    imageView.showErrorMessage(errMessage);
  }

  public ImageViewSwing getImageView() {
    return imageView;
  }

  @Override
  public File getOpenFile() {
    return showOpenChooser();
  }

  private File showOpenChooser() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileFilter(new FileNameExtensionFilter("imagen BMP", "bmp"));
    if (chooser.showOpenDialog(mainFrame) == 0) {
      return chooser.getSelectedFile();
    }
    return null;
  }
  
  @Override
  public File getSaveFile() {
    return showSaveChooser();
  }

  private File showSaveChooser() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileFilter(new FileNameExtensionFilter("imagen BMP", "bmp"));
    if (chooser.showSaveDialog(mainFrame) == 0) {
      return chooser.getSelectedFile();
    }
    return null;
  }

  @Override
  public void showError(String string) {
    // TODO Auto-generated method stub
    
  }
  
}
