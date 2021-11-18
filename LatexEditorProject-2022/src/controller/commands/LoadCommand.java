package controller.commands;

import model.VersionsManager;
import view.LatexEditorView;

public class LoadCommand implements Command {
	private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	
	public LoadCommand() {
//		super();
//		this.versionsManager = versionsManager;
		versionsManager = VersionsManager.getInstance();
		latexEditorView = LatexEditorView.getInstance() ;
	}

	public VersionsManager getVersionsManager() {
		return versionsManager;
	}

//	public void setVersionsManager(VersionsManager versionsManager) {
//		this.versionsManager = versionsManager;
//	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
//		versionsManager.loadFromFile();
		loadFromFile();
	}
	
	public void loadFromFile() {
		// TODO Auto-generated method stub
		latexEditorView.loadFromFile();
	}

}
