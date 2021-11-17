package controller.commands;

import model.VersionsManager;

public class RollbackToPreviousVersionCommand implements Command {
	private VersionsManager versionsManager;
	
	
	public RollbackToPreviousVersionCommand() {
//		this.versionsManager = versionsManager;
		versionsManager = VersionsManager.getInstance();
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.rollback();
	}

}
