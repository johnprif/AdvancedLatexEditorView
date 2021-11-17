package controller.commands;

import model.VersionsManager;

public class LoadCommand implements Command {
	private VersionsManager versionsManager;
	
	public LoadCommand() {
//		super();
//		this.versionsManager = versionsManager;
		versionsManager = VersionsManager.getInstance();
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
		versionsManager.loadFromFile();
	}

}
