module com.tom {
  requires javafx.controls;
  requires javafx.fxml;
  requires com.google.gson;
  requires java.net.http;
  requires java.desktop;
  
  opens com.tom;
  opens com.tom.controller;
  opens com.tom.view;
  opens com.tom.model;
  opens com.tom.model.persistence;
  exports com.tom;
}
