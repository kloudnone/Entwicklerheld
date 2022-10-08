package org.jugsaxony.treed;

import org.jugsaxony.treed.api.AbstractBaseAnimationStrategy;
import org.jugsaxony.treed.api.Bulb;

/**
 * This class serves as starting point when developing your animation
 * on the EntwicklerHeld platform.
 */
public class MyStrategy extends AbstractBaseAnimationStrategy {

  private Double minC = Double.MAX_VALUE;
  private Double maxC = Double.MIN_VALUE;

  private boolean initDone = false;

  private int START_COLOR = 0xffd700;
  private int END_COLOR = 0x0000ff;

  @Override
  protected void calcBulb(Bulb bulb, long timestamp) {
    if (bulb.getIndex() == 0 && minC < Double.MAX_VALUE && !initDone) {
      initDone = true;
    }

    if (!initDone) {
      minC = Math.min(minC, bulb.getZ());
      maxC = Math.max(maxC, bulb.getZ());
    } else {
      double coord = bulb.getZ();
      int color = (int)(START_COLOR+((END_COLOR-START_COLOR)*(coord-minC)/(maxC-minC))) & 0x0000ff;
      bulb.setRgb(color);
    }
  }

  @Override
  public String getAuthorEmail() {
    return "treed@jugsaxony.org";
  }

  @Override
  public String getAuthorName() {
    return "TeamTreeD";
  }

  @Override
  public String getDescription() {
    return "der JUG Saxony e. V. hat einen Weihnachtsbaum mit digitalen LEDs ausgerüstet und stellt Dir eine Programmierschnittstelle zur Verfügung, mit der Du den Baum mit Leben erfüllen bzw. zum Leuchten bringen kannst. Am 24. November 2022 schauen wir uns - hoffentlich gemeinsam - alle Ergebnisse an und vergeben Preise für die “besten” Beleuchtungsprogramme (“Strategien”).";
  }

  @Override
  public String getStrategyName() {
    return "org.jugsaxony.treed.examples.VerticalRainbow";
  }

  /**
   * This is a helper method that is only needed on the EntwicklerHeld
   * platform. It prevents you from submitting by clicking on the 
   * "STAGE ABGEBEN" button accidentally. You can only submit, if you return
   * <code>true</code> from this method, so we suggest that you change
   * the return value when you're really done, right before submitting.
   * 
   * @return Whether the strategy is ready to be submitted.
   */
  public boolean readyToSubmit() {
    return true;
  }
}
