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
//		super();
		documentManager = DocumentManager.getInstance();
		versionsManager = VersionsManager.getInstance();
		latexEditorView = LatexEditorView.getInstance();
		type = latexEditorView.getType();
	}

	@Override
	public void execute() {
		type = "bookTemplate";
		Document document = documentManager.createDocument(type);
		latexEditorView.setCurrentDocument(document);
	}

}
