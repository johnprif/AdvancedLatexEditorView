package controller.commands;

import model.VersionsManager;

public class ChangeVersionsStrategyCommand implements Command {
	private VersionsManager versionsManager;
	
	public ChangeVersionsStrategyCommand() {
		versionsManager = VersionsManager.getInstance();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.changeStrategy();
	}

}
