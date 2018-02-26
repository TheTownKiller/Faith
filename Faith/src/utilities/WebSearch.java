package utilities;

import interaccion.Interaccion;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jframe.Display;

public class WebSearch extends Application {

	public static Scene scene;

	@Override
	public void start(Stage stage) {
		Image img = new Image("/resources/FaithIcon.png");
		stage.setTitle("Faith");
		stage.getIcons().add((img));
		scene = new Scene(new Browser(), (Display.width - 15), (Display.height - 60), Color.web("#666970"));
		stage.setScene(scene);
		stage.show();
		Display.firstSearch = false;
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent t) {
				Display.endSearch = true;
				t.consume();
				stage.hide();
				synchronized (scene) {
					try {
						scene.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				scene = new Scene(new Browser(), (Display.width - 15), (Display.height - 60), Color.web("#666970"));
				stage.setScene(scene);
				stage.show();
			}
		});
	}
}

class Browser extends Region {

	final WebView browser = new WebView();
	final WebEngine webEngine = browser.getEngine();

	public Browser() {
		getStyleClass().add("browser");
		webEngine.load(Interaccion.webUrl);
		getChildren().add(browser);

	}

	@Override
	protected void layoutChildren() {
		double w = getWidth();
		double h = getHeight();
		layoutInArea(browser, 0, 0, w, h, 0, HPos.CENTER, VPos.CENTER);
	}

	@Override
	protected double computePrefWidth(double height) {
		return 750;
	}

	@Override
	protected double computePrefHeight(double width) {
		return 500;
	}
}

