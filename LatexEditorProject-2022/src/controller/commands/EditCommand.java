package controller.commands;

import model.VersionsManager;

public class EditCommand implements Command {
	private VersionsManager versionsManager;
	
	
	public EditCommand() {
//		super();
//		this.versionsManager = versionsManager;
		versionsManager = VersionsManager.getInstance();
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.saveContents();
	}

}
