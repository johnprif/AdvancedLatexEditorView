package controller.commands;

import java.util.HashMap;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class CommandFactory {
	
	public CommandFactory() {
	}


	public Command createCommand(String type) {
		if(type.equals("addLatex")) {
			return new AddLatexCommand();
		}
		if(type.equals("changeVersionsStrategy")) {
			return new ChangeVersionsStrategyCommand();
		}
		if(type.equals("create")) {
			return new CreateCommand();
		}
		if(type.equals("disableVersionsManagement")) {
			return new DisableVersionsManagementCommand();
		}
		if(type.equals("edit")) {
			return new EditCommand();
		}
		if(type.equals("enableVersionsManagement")) {
			return new EnableVersionsManagementCommand();
		}
		if(type.equals("load")) {
			return new LoadCommand();
		}
		if(type.equals("rollbackToPreviousVersion")) {
			return new RollbackToPreviousVersionCommand();
		}
		if(type.equals("save")) {
			return new SaveCommand();
		}
		return null;
	}
}
