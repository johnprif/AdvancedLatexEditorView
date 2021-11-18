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
		// TODO Auto-generated constructor stub
//		this.versionsManager = versionsManager;
		versionsManager = VersionsManager.getInstance();
		latexEditorView = LatexEditorView.getInstance() ;
		this.document = latexEditorView.getCurrentDocument();
		this.fileName = latexEditorView.getFilename();
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
//		versionsManager.saveToFile();
		saveToFile();
	}
//-------------------------------------------------
	public void saveToFile() {
		// TODO Auto-generated method stub
		document.save(fileName);
	}
//----------------------------------------------------------------
}
