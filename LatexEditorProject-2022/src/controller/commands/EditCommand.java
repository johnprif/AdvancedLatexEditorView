package controller.commands;

import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class EditCommand implements Command {
	private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	private Document currentDocument;
	private String text;
	
	public EditCommand() {
		versionsManager = VersionsManager.getInstance();
		latexEditorView = LatexEditorView.getInstance();
		
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		saveContents();
	}
	
	public void saveContents() {
		currentDocument = latexEditorView.getCurrentDocument();
		text = latexEditorView.getText();
		if(versionsManager.isEnabled()) {
			versionsManager.putVersion(currentDocument);
			currentDocument.changeVersion();
		}
		currentDocument.setContents(text);
	}
}
