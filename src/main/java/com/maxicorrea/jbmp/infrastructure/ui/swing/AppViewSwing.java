package com.maxicorrea.jbmp.infrastructure.ui.swing;

import static com.maxicorrea.jbmp.infrastructure.ui.swing.OperationViewSwing.createSubItem;
import static com.maxicorrea.jbmp.infrastructure.ui.util.ColorConstants.BACKGROUND_COLOR;
import static com.maxicorrea.jbmp.infrastructure.ui.util.IconLocations.FAVICON_ICON;
import static com.maxicorrea.jbmp.infrastructure.ui.util.IconLocations.FILTER_ICON;
import static com.maxicorrea.jbmp.infrastructure.ui.util.IconLocations.HORIZONTAL_ICON;
import static com.maxicorrea.jbmp.infrastructure.ui.util.IconLocations.OPEN_ICON;
import static com.maxicorrea.jbmp.infrastructure.ui.util.IconLocations.RESET_ICON;
import static com.maxicorrea.jbmp.infrastructure.ui.util.IconLocations.ROTATE_LEFT_ICON;
import static com.maxicorrea.jbmp.infrastructure.ui.util.IconLocations.ROTATE_RIGHT_ICON;
import static com.maxicorrea.jbmp.infrastructure.ui.util.IconLocations.SAVE_ICON;
import static com.maxicorrea.jbmp.infrastructure.ui.util.IconLocations.VERTICAL_ICON;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.APP_TITLE;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.BLUE_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.BLUR_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.CONTRAST_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.EDGES_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.GRAYSCALE_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.GREEN_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.HORIZONTAL_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.LEFT_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.NEGATIVE_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.OPEN_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.ORGB_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.RED_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.RESET_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.RIGHT_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.SAVE_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.SEPIA_TEXT;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.TITLE_ESSENTIAL;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.TITLE_FILTER;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.TITLE_FLIP;
import static com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels.VERTICAL_TEXT;
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
import com.maxicorrea.jbmp.application.port.in.ApplyFilterUseCase;
import com.maxicorrea.jbmp.application.port.in.OpenImageUseCase;
import com.maxicorrea.jbmp.application.port.in.SaveImageUseCase;
import com.maxicorrea.jbmp.infrastructure.ui.util.Dialog;
import com.maxicorrea.jbmp.infrastructure.ui.util.Item;
import com.maxicorrea.jbmp.infrastructure.ui.util.MotionFrame;
import com.maxicorrea.jbmp.infrastructure.ui.util.TextLabels;
import com.maxicorrea.jbmp.infrastructure.ui.util.TitleItem;

public class AppViewSwing {

  static final int FRAME_WIDTH = 990;
  static final int FRAME_HEIGHT = 580;

  private final JFrame mainFrame;
  private final ImageViewSwing imageView;

  private final OpenImageUseCase openImageUseCase;
  private final SaveImageUseCase saveImageUseCase;
  private final ApplyFilterUseCase resetUseCase;
  private final ApplyFilterUseCase grayscaleUseCase;
  private final ApplyFilterUseCase contrastUseCase;
  private final ApplyFilterUseCase negativeUseCase;
  private final ApplyFilterUseCase sepiaUseCase;
  private final ApplyFilterUseCase blurUseCase;
  private final ApplyFilterUseCase edgesUseCase;
  private final ApplyFilterUseCase redUseCase;
  private final ApplyFilterUseCase greenUseCase;
  private final ApplyFilterUseCase blueUseCase;
  private final ApplyFilterUseCase orgbUseCase;
  private final ApplyFilterUseCase gridUseCase;
  private final ApplyFilterUseCase verticalUseCase;
  private final ApplyFilterUseCase horizontalUseCase;
  private final ApplyFilterUseCase rightUseCase;
  private final ApplyFilterUseCase leftUseCase;

  private Item essentials;
  private OperationViewSwing open;
  private OperationViewSwing save;
  private OperationViewSwing reset;

  private Item filters;
  private OperationViewSwing grayscale;
  private OperationViewSwing contrast;
  private OperationViewSwing negative;
  private OperationViewSwing sepia;
  private OperationViewSwing blur;
  private OperationViewSwing edges;
  private OperationViewSwing red;
  private OperationViewSwing green;
  private OperationViewSwing blue;
  private OperationViewSwing orgb;
  private OperationViewSwing grid;

  private Item flips;
  private OperationViewSwing vertical;
  private OperationViewSwing horizontal;
  private OperationViewSwing right;
  private OperationViewSwing left;

  public AppViewSwing(ImageViewSwing imageView,
      OpenImageUseCase openImageUseCase,
      SaveImageUseCase saveImageUseCase,
      ApplyFilterUseCase resetUseCase,
      ApplyFilterUseCase grayscaleUseCase,
      ApplyFilterUseCase contrastUseCase,
      ApplyFilterUseCase negativeUseCase,
      ApplyFilterUseCase sepiaUseCase,
      ApplyFilterUseCase blurUseCase,
      ApplyFilterUseCase edgesUseCase,
      ApplyFilterUseCase redUseCase,
      ApplyFilterUseCase greenUseCase,
      ApplyFilterUseCase blueUseCase,
      ApplyFilterUseCase orgbUseCase,
      ApplyFilterUseCase gridUseCase,
      ApplyFilterUseCase verticalUseCase,
      ApplyFilterUseCase horizontalUseCase,
      ApplyFilterUseCase rightUseCase,
      ApplyFilterUseCase leftUseCase) {
    this.imageView = imageView;
    this.openImageUseCase = openImageUseCase;
    this.saveImageUseCase = saveImageUseCase;
    this.resetUseCase = resetUseCase;
    this.grayscaleUseCase = grayscaleUseCase;
    this.contrastUseCase = contrastUseCase;
    this.negativeUseCase = negativeUseCase;
    this.sepiaUseCase = sepiaUseCase;
    this.blurUseCase = blurUseCase;
    this.edgesUseCase = edgesUseCase;
    this.redUseCase = redUseCase;
    this.greenUseCase = greenUseCase;
    this.blueUseCase = blueUseCase;
    this.orgbUseCase = orgbUseCase;
    this.gridUseCase = gridUseCase;
    this.verticalUseCase = verticalUseCase;
    this.horizontalUseCase = horizontalUseCase;
    this.rightUseCase = rightUseCase;
    this.leftUseCase = leftUseCase;

    mainFrame = new JFrame(APP_TITLE);
    mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    mainFrame.setIconImage(getDefaultToolkit().getImage(getClass().getResource(FAVICON_ICON)));
    mainFrame.setUndecorated(true);
    mainFrame.setContentPane(getContentPane());
    wireUseCases();
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

  Item getEssentialItems() {
    if (essentials == null) {
      essentials = new Item(new TitleItem(TITLE_ESSENTIAL));
      essentials.addSubItem(open = createSubItem(OPEN_TEXT, OPEN_ICON));
      essentials.addSubItem(save = createSubItem(SAVE_TEXT, SAVE_ICON));
      essentials.addSubItem(reset = createSubItem(RESET_TEXT, RESET_ICON));
    }
    return essentials;
  }

  Item getFilterItems() {
    if (filters == null) {
      filters = new Item(new TitleItem(TITLE_FILTER));
      filters.addSubItem(grayscale = createSubItem(GRAYSCALE_TEXT, FILTER_ICON));
      filters.addSubItem(contrast = createSubItem(CONTRAST_TEXT, FILTER_ICON));
      filters.addSubItem(negative = createSubItem(NEGATIVE_TEXT, FILTER_ICON));
      filters.addSubItem(sepia = createSubItem(SEPIA_TEXT, FILTER_ICON));
      filters.addSubItem(blur = createSubItem(BLUR_TEXT, FILTER_ICON));
      filters.addSubItem(edges = createSubItem(EDGES_TEXT, FILTER_ICON));
      filters.addSubItem(red = createSubItem(RED_TEXT, FILTER_ICON));
      filters.addSubItem(green = createSubItem(GREEN_TEXT, FILTER_ICON));
      filters.addSubItem(blue = createSubItem(BLUE_TEXT, FILTER_ICON));
      filters.addSubItem(orgb = createSubItem(ORGB_TEXT, FILTER_ICON));
      filters.addSubItem(grid = createSubItem(TextLabels.GRID_TEXT, FILTER_ICON));
    }
    return filters;
  }

  Item getFlipItems() {
    if (flips == null) {
      flips = new Item(new TitleItem(TITLE_FLIP));
      flips.addSubItem(vertical = createSubItem(VERTICAL_TEXT, VERTICAL_ICON));
      flips.addSubItem(horizontal = createSubItem(HORIZONTAL_TEXT, HORIZONTAL_ICON));
      flips.addSubItem(right = createSubItem(RIGHT_TEXT, ROTATE_RIGHT_ICON));
      flips.addSubItem(left = createSubItem(LEFT_TEXT, ROTATE_LEFT_ICON));
    }
    return flips;
  }

  private void wireUseCases() {
    open.setAction(() -> openImageUseCase.execute());
    save.setAction(() -> saveImageUseCase.execute());
    reset.setAction(() -> resetUseCase.execute());
    grayscale.setAction(() -> grayscaleUseCase.execute());
    contrast.setAction(() -> contrastUseCase.execute());
    negative.setAction(() -> negativeUseCase.execute());
    sepia.setAction(() -> sepiaUseCase.execute());
    blur.setAction(() -> blurUseCase.execute());
    edges.setAction(() -> edgesUseCase.execute());
    red.setAction(() -> redUseCase.execute());
    green.setAction(() -> greenUseCase.execute());
    blue.setAction(() -> blueUseCase.execute());
    orgb.setAction(() -> orgbUseCase.execute());
    grid.setAction(() -> gridUseCase.execute());
    vertical.setAction(() -> verticalUseCase.execute());
    horizontal.setAction(() -> horizontalUseCase.execute());
    right.setAction(() -> rightUseCase.execute());
    left.setAction(() -> leftUseCase.execute());
  }

  public File getOpenFile() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileFilter(new FileNameExtensionFilter("imagen BMP", "bmp"));
    if (chooser.showOpenDialog(mainFrame) == 0) {
      return chooser.getSelectedFile();
    }
    return null;
  }

  public File getSaveFile() {
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

  public void showError(String errMessage) {
    imageView.showErrorMessage(errMessage);
  }

  public void open() {
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setVisible(true);
  }

  public void showAlert(String message) {
    Dialog.showAlertDialog(mainFrame, message);
  }

}
