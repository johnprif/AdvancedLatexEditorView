package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class LoadCommand implements Command {
	private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	private Document currentDocument;
	private String fileName;
	private String type;
	
	public LoadCommand() {
		versionsManager = VersionsManager.getInstance();
		latexEditorView = LatexEditorView.getInstance() ;	
	}

	public VersionsManager getVersionsManager() {
		return versionsManager;
	}

	@Override
	public void execute() {
		loadFromFile();
	}
	
	public void loadFromFile() {
		currentDocument = latexEditorView.getCurrentDocument();
		fileName = latexEditorView.getFilename();
//		type = latexEditorView.getType();
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream(fileName));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//currentDocument = new Document();
		currentDocument.setContents(fileContents);
		
		//type = "emptyTemplate";
		
		fileContents = fileContents.trim();
		if(fileContents.startsWith("\\documentclass[11pt,twocolumn,a4paper]{article}")) {
			type = "articleTemplate";
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{book}")) {
			type = "bookTemplate";
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{report}")) {
			type = "reportTemplate";
		}
		else if(fileContents.startsWith("\\documentclass{letter}")) {
			type = "letterTemplate";
		}else
		{
			type = "emptyTemplate";
		}
		latexEditorView.setType(type);
		System.out.println("Type is = "+ type);
	}
	
}
