package controller.commands;

import Conveter.latexToHtml;
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
	private latexToHtml converter;
	
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
//		document.save(fileName);
		
		if(fileName.endsWith(".html") == true)
		{
			converter = new latexToHtml(document.getContents());
			document.setContents(converter.getHtmlContents());
			document.save(fileName);
		}else
		{
			document.save(fileName);
		}
	}
//----------------------------------------------------------------
}
