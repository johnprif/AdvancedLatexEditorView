package controller.commands;

import model.VersionsManager;

public class EnableVersionsManagementCommand implements Command {
	private VersionsManager versionsManager;
	
	public EnableVersionsManagementCommand() {
		super();
//		this.versionsManager = versionsManager;
		versionsManager = VersionsManager.getInstance();
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.enableStrategy();
	}

}
