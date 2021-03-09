package edu.kis.powp.jobs2d.features;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.SelectDriverMenuOptionListener;
import edu.kis.powp.jobs2d.drivers.adapters.LineDrawerAdapter;
import java.awt.event.ActionEvent;
public class DriverFeature {

	private static DriverManager driverManager = new DriverManager();
	private static Application app;

	public static DriverManager getDriverManager() {
		return driverManager;
	}

	/**
	 * Setup jobs2d drivers Plugin and add to application.
	 * 
	 * @param application Application context.
	 */
	public static void setupDriverPlugin(Application application) {
		app = application;
		app.addComponentMenu(DriverFeature.class, "Drivers");
	}

	/**
	 * Add driver to context, create button in driver menu.
	 * 
	 * @param name   Button name.
	 * @param driver Job2dDriver object.
	 */
	public static void addDriver(String name, Job2dDriver driver) {
		SelectDriverMenuOptionListener listener = new SelectDriverMenuOptionListener(driver, driverManager);
		app.addComponentMenuElement(DriverFeature.class, name, listener);
	}

	public static void addDriverDrawingLineTypeOptions(Application application,LineDrawerAdapter driver)
	{	
		application.addComponentMenuElement(DrawPanelController.class, "Basic", (ActionEvent e) -> driver.setLineType(LineDrawerAdapter.LineType.BASIC));
		application.addComponentMenuElement(DrawPanelController.class, "Dotted", (ActionEvent e) -> driver.setLineType(LineDrawerAdapter.LineType.DOTTED));
		application.addComponentMenuElement(DrawPanelController.class, "Special", (ActionEvent e) -> driver.setLineType(LineDrawerAdapter.LineType.SPECIAL));
	}

	/**
	 * Update driver info.
	 */
	public static void updateDriverInfo() {
		app.updateInfo(driverManager.getCurrentDriver().toString());
	}

}
