package controller.commands;

import model.VersionsManager;

public class AddLatexCommand implements Command  {
	private VersionsManager versionsManager;
	
	
	public AddLatexCommand() {
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
