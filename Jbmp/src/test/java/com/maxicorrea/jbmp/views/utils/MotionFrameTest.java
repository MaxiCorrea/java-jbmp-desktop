package com.maxicorrea.jbmp.views.utils;

import static org.junit.Assert.*;
import javax.swing.JFrame;
import org.junit.Test;

public class MotionFrameTest {

  @Test
  public void shouldSetTheTitleInTheFrame() {
    JFrame frame = new JFrame();
    new MotionFrame(frame);
    assertEquals(TextLabels.APP_TITLE ,frame.getTitle());
  }

  @Test
  public void theIconShouldBeCorrect() {
    JFrame frame = new JFrame();
    MotionFrame motion = new MotionFrame(frame);
    assertEquals(MotionFrame.MINI_ICON , motion.getLabelMini().getIcon());
    assertEquals(MotionFrame.CLOSE_ICON , motion.getLabelClose().getIcon());
  }
  
  @Test
  public void shouldBeAbleToCloseTheFrame() {
    JFrame frame = new JFrame();
    MotionFrame motion = new MotionFrame(frame);
    motion.closeFrame();
    assertFalse(frame.isVisible());
    assertFalse(frame.isDisplayable());
  }
  
  @Test
  public void  shouldBeAbleToMinimizeTheFrame() {
    JFrame frame = new JFrame();
    MotionFrame motion = new MotionFrame(frame);
    motion.iconifiedFrame();
    assertEquals(JFrame.ICONIFIED , frame.getState());
  }
  
}
