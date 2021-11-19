package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class SaveCommand implements Command {
	private VersionsManager versionsManager;
	private DocumentManager documentManager;
	private LatexEditorView latexEditorView;
	private Document document;
	private String fileName;
	
	public SaveCommand() {
		versionsManager = VersionsManager.getInstance();
		latexEditorView = LatexEditorView.getInstance() ;
	}
	@Override
	public void execute() {
		saveToFile();
	}
//-------------------------------------------------
	private void saveToFile() {
		document = latexEditorView.getCurrentDocument();
		fileName = latexEditorView.getFilename();
		document.save(fileName);
		
		System.out.println("Save Commands contents = "+document.getContents());
	}
//----------------------------------------------------------------
}
