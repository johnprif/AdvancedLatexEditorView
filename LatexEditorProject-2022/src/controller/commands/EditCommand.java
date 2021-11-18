package controller.commands;

import model.VersionsManager;
import view.LatexEditorView;

public class EditCommand implements Command {
	private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	
	public EditCommand() {
//		super();
//		this.versionsManager = versionsManager;
		versionsManager = VersionsManager.getInstance();
		latexEditorView = LatexEditorView.getInstance();
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
//		versionsManager.saveContents();
		saveContents();
	}

	public void saveContents() {
		// TODO Auto-generated method stub
		latexEditorView.saveContents();
	}
}
