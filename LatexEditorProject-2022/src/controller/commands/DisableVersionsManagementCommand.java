package controller.commands;

import model.VersionsManager;

public class DisableVersionsManagementCommand implements Command {

	private VersionsManager versionsManager;
	
	public DisableVersionsManagementCommand() {
		versionsManager = VersionsManager.getInstance();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.disable();
	}

}
