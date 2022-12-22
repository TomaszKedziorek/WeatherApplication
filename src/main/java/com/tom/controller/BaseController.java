package com.tom.controller;

import com.tom.ForecastManager;
import com.tom.view.ViewFactory;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.util.Duration;

public abstract class BaseController {
  
  protected final ForecastManager forecastManager;
  protected final ViewFactory viewFactory;
  private final String fxmlFileName;
  
  public BaseController(ForecastManager forecastManager, ViewFactory viewFactory, String fxmlFileName) {
    this.forecastManager = forecastManager;
    this.viewFactory = viewFactory;
    this.fxmlFileName = fxmlFileName;
  }
  
  public String getFxmlFileName() {
    return fxmlFileName;
  }
  
  public abstract String getWindowTitle();
  
  public void closeStage(Control controlElement) {
    Stage stage = (Stage) controlElement.getScene().getWindow();
    viewFactory.closeStage(stage);
  }
  
  public void setTooltip(String tooltipText, Node nodeForTooltip) {
    Tooltip tooltipAttachmentNode = new Tooltip(tooltipText);
    Tooltip.install(nodeForTooltip, tooltipAttachmentNode);
    tooltipAttachmentNode.setShowDelay(new Duration(500));
  }
}
