package controller;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private Button input1;

	@FXML
	private Button input2;

	@FXML
	private TextField field1;

	@FXML
	private TextField field2;

	@FXML
	private Button show;

	private File json1 = null;
	private File json2 = null;

	private File fileChooser(String title, String absolutePath, String nameEx, String extension) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(title);
		if (absolutePath != null) {
			File userDirectory = new File(absolutePath);
			fileChooser.setInitialDirectory(userDirectory);
		}
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(nameEx, extension));
		return fileChooser.showOpenDialog(new Stage());
	}

	@FXML
	void chooseFile1(ActionEvent event) {
		json1 = fileChooser("choose GeoJson File", null, "GeoJson file", "*.json*");
		field1.setText(json1.getAbsolutePath());
	}

	@FXML
	void chooseFile2(ActionEvent event) {
		json2 = fileChooser("choose GeoJson File", null, "GeoJson file", "*.json*");
		field2.setText(json2.getAbsolutePath());
	}

	@FXML
	void displayMap(ActionEvent event) {
		try {
			LeafletController.setJson(json1, json2);
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/leafletMap.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
