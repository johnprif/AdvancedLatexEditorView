package controller.commands;

import model.VersionsManager;

public class EnableVersionsManagementCommand implements Command {
	private VersionsManager versionsManager;
	
	public EnableVersionsManagementCommand() {
		versionsManager = VersionsManager.getInstance();
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.enableStrategy();
	}

}
