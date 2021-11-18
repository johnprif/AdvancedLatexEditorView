package controller;

import java.util.HashMap;

import controller.commands.AddLatexCommand;
import controller.commands.ChangeVersionsStrategyCommand;
import controller.commands.Command;
import controller.commands.CommandFactory;
import controller.commands.CreateCommand;
import controller.commands.DisableVersionsManagementCommand;
import controller.commands.EditCommand;
import controller.commands.EnableVersionsManagementCommand;
import controller.commands.LoadCommand;
import controller.commands.RollbackToPreviousVersionCommand;
import controller.commands.SaveCommand;
import model.VersionsManager;
import view.LatexEditorView;

public class LatexEditorController{
	private HashMap<String, Command> commands;

	public LatexEditorController() {
		CommandFactory commandFactory = new CommandFactory();
		String [] array = {"addLatex","changeVersionsStrategy","create",
				"disableVersionsManagement","edit","enableVersionsManagement",
				"load","rollbackToPreviousVersion","save"};
		
		commands = new HashMap<String, Command>(); 
		for(int i = 0; i < array.length; i++) {
			commands.put(array[i],commandFactory.createCommand(array[i]));
		}
	}
	
	public void enact(String command) {
		commands.get(command).execute();
	}
}
