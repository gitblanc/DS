package gui;

import java.awt.event.*;

import javax.swing.*;

import model.Document;

public class Window extends JFrame {

	private Canvas canvas;

	private JPanel buttonPanel;
	private ButtonGroup buttonGroup;

	private JRadioButton leftButton, justifiedButton, rightButton, centeredButton;

	public Window(Document document) {
		setTitle(document.getTitle());
		setSize(500, 480);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		createButtons();
		add(buttonPanel, "North");

		canvas = new Canvas(document, leftButton, justifiedButton, rightButton, centeredButton);
		add(canvas, "Center");

		// Adds a listener to resize the canvas when the window resizes
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = getWidth();
				canvas.adjustWidth(width);
			}
		});
	}

	private void createButtons() {
		buttonPanel = new JPanel();
		buttonGroup = new ButtonGroup();

		leftButton = addButton("Left");
		justifiedButton = addButton("Justified");
		// Ampliación -> Alineación a la derecha y Centrado
		rightButton = addButton("Right");
		centeredButton = addButton("Centered");

		leftButton.setSelected(true);
	}

	private JRadioButton addButton(String buttonText) {
		var button = new JRadioButton(buttonText);
		buttonPanel.add(button);
		buttonGroup.add(button);
		button.addActionListener(e -> {
			// Ampliación -> se cambia en tiempo de ejecución el botón seleccionado del
			// canvas
			canvas.setSelectedButton(buttonText);
			canvas.drawDocument();
		});

		return button;
	}
}
