package edu.kis.powp.jobs2d.drivers.adapters;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;

public class LineDrawerAdapter extends Job2dAdapter {

  private LineType lineType = LineType.DOTTED;

  public LineDrawerAdapter() {
		super();
	}

  enum LineType {
    BASIC, DOTTED, SPECIAL
  }

  public void setLineType(LineType type) {
    this.lineType = type;
  }

  private ILine getLine() {
    switch (this.lineType) {
      case BASIC:
        return LineFactory.getBasicLine();
      case DOTTED:
        return LineFactory.getDottedLine();
      case SPECIAL:
        return LineFactory.getSpecialLine();
      default:
        return LineFactory.getBasicLine();
    }
  }

	@Override
	public String toString() {
		return "Extended Job2dAdapter for drawing lines";
	}
}