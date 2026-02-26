package com.maxicorrea.jbmp.configuration;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import com.maxicorrea.jbmp.application.port.in.ApplyFilterUseCase;
import com.maxicorrea.jbmp.application.port.in.OpenImageUseCase;
import com.maxicorrea.jbmp.application.port.in.SaveImageUseCase;
import com.maxicorrea.jbmp.application.usecase.ApplyFilterUseCaseImpl;
import com.maxicorrea.jbmp.application.usecase.OpenImageUseCaseImpl;
import com.maxicorrea.jbmp.application.usecase.ResetImageUseCaseImpl;
import com.maxicorrea.jbmp.application.usecase.SaveImageUseCaseImpl;
import com.maxicorrea.jbmp.domain.service.BlueFilter;
import com.maxicorrea.jbmp.domain.service.BlurFilter;
import com.maxicorrea.jbmp.domain.service.ContrastFilter;
import com.maxicorrea.jbmp.domain.service.EdgesFilter;
import com.maxicorrea.jbmp.domain.service.GrayscaleFilter;
import com.maxicorrea.jbmp.domain.service.GreenFilter;
import com.maxicorrea.jbmp.domain.service.GridFilter;
import com.maxicorrea.jbmp.domain.service.HorizontalFlip;
import com.maxicorrea.jbmp.domain.service.NegativeFilter;
import com.maxicorrea.jbmp.domain.service.ORGBFilter;
import com.maxicorrea.jbmp.domain.service.RedFilter;
import com.maxicorrea.jbmp.domain.service.RotateLeft;
import com.maxicorrea.jbmp.domain.service.RotateRight;
import com.maxicorrea.jbmp.domain.service.SepiaFilter;
import com.maxicorrea.jbmp.domain.service.VerticalFlip;
import com.maxicorrea.jbmp.infrastructure.persistence.BmpImageRepository;
import com.maxicorrea.jbmp.infrastructure.ui.swing.AppViewSwing;
import com.maxicorrea.jbmp.infrastructure.ui.swing.ImageViewSwing;
import com.maxicorrea.jbmp.infrastructure.ui.swing.SwingFileSelector;
import com.maxicorrea.jbmp.infrastructure.ui.swing.SwingImagePresenter;
import com.maxicorrea.jbmp.infrastructure.ui.swing.SwingUserNotifier;

public class Application {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      try {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
      } catch (UnsupportedLookAndFeelException e) {
        Logger log = Logger.getGlobal();
        log.log(Level.INFO, "No NimbusLookAndFeel");
      }

      // Infrastructure adapters
      ImageViewSwing imageView = new ImageViewSwing();
      SwingImagePresenter imagePresenter = new SwingImagePresenter();
      imagePresenter.setImageView(imageView);

      SwingUserNotifier notifier = new SwingUserNotifier();
      SwingFileSelector fileSelector = new SwingFileSelector();
      BmpImageRepository imageRepo = new BmpImageRepository();

      // Reset use case (needs reference from open)
      ResetImageUseCaseImpl resetUseCase = new ResetImageUseCaseImpl(imagePresenter, notifier);

      // Open and Save use cases
      OpenImageUseCase openUseCase = new OpenImageUseCaseImpl(
          fileSelector, imageRepo, imagePresenter, notifier, resetUseCase);
      SaveImageUseCase saveUseCase = new SaveImageUseCaseImpl(
          fileSelector, imageRepo, imagePresenter, notifier);

      // Filter use cases
      ApplyFilterUseCase grayscaleUseCase = new ApplyFilterUseCaseImpl(
          new GrayscaleFilter(), imagePresenter, notifier);
      ApplyFilterUseCase contrastUseCase = new ApplyFilterUseCaseImpl(
          new ContrastFilter(), imagePresenter, notifier);
      ApplyFilterUseCase negativeUseCase = new ApplyFilterUseCaseImpl(
          new NegativeFilter(), imagePresenter, notifier);
      ApplyFilterUseCase sepiaUseCase = new ApplyFilterUseCaseImpl(
          new SepiaFilter(), imagePresenter, notifier);
      ApplyFilterUseCase blurUseCase = new ApplyFilterUseCaseImpl(
          new BlurFilter(), imagePresenter, notifier);
      ApplyFilterUseCase edgesUseCase = new ApplyFilterUseCaseImpl(
          new EdgesFilter(), imagePresenter, notifier);
      ApplyFilterUseCase redUseCase = new ApplyFilterUseCaseImpl(
          new RedFilter(), imagePresenter, notifier);
      ApplyFilterUseCase greenUseCase = new ApplyFilterUseCaseImpl(
          new GreenFilter(), imagePresenter, notifier);
      ApplyFilterUseCase blueUseCase = new ApplyFilterUseCaseImpl(
          new BlueFilter(), imagePresenter, notifier);
      ApplyFilterUseCase orgbUseCase = new ApplyFilterUseCaseImpl(
          new ORGBFilter(), imagePresenter, notifier);
      ApplyFilterUseCase gridUseCase = new ApplyFilterUseCaseImpl(
          new GridFilter(), imagePresenter, notifier);

      // Flip/Rotate use cases
      ApplyFilterUseCase verticalUseCase = new ApplyFilterUseCaseImpl(
          new VerticalFlip(), imagePresenter, notifier);
      ApplyFilterUseCase horizontalUseCase = new ApplyFilterUseCaseImpl(
          new HorizontalFlip(), imagePresenter, notifier);
      ApplyFilterUseCase rightUseCase = new ApplyFilterUseCaseImpl(
          new RotateRight(), imagePresenter, notifier);
      ApplyFilterUseCase leftUseCase = new ApplyFilterUseCaseImpl(
          new RotateLeft(), imagePresenter, notifier);

      // Assemble UI
      AppViewSwing view = new AppViewSwing(imageView,
          openUseCase, saveUseCase, resetUseCase,
          grayscaleUseCase, contrastUseCase, negativeUseCase, sepiaUseCase,
          blurUseCase, edgesUseCase, redUseCase, greenUseCase, blueUseCase,
          orgbUseCase, gridUseCase,
          verticalUseCase, horizontalUseCase, rightUseCase, leftUseCase);

      // Wire adapters that need the view reference
      notifier.setAppView(view);
      fileSelector.setAppView(view);

      view.open();
    });
  }

}
