package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class CreateCommand implements Command {
	private DocumentManager documentManager;
	private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	private String type;
	
	public CreateCommand() {
		documentManager = DocumentManager.getInstance();
		versionsManager = VersionsManager.getInstance();
		latexEditorView = LatexEditorView.getInstance();
	}

	@Override
	public void execute() {
		type = latexEditorView.getType();
		Document document = documentManager.createDocument(type);
		latexEditorView.setCurrentDocument(document);
	}

}
