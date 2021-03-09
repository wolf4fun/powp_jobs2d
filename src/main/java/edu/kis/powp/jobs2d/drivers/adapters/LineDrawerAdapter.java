package edu.kis.powp.jobs2d.drivers.adapters;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;

public class LineDrawerAdapter extends Job2dAdapter {

  private LineType lineType = LineType.DOTTED;

  public LineDrawerAdapter() {
		super();
	}

  public enum LineType {
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
	public void operateTo(int x, int y) {
		ILine line = getLine();
		line.setStartCoordinates(super.getStartX(), super.getStartY());
		line.setEndCoordinates(x, y);
		getDrawPanelController().drawLine(line);
		setPosition(x, y);
		drawLine(line);
	}

	@Override
	public String toString() {
		return "Extended Job2dAdapter for drawing lines";
	}
}