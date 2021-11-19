package controller.commands;

import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class AddLatexCommand implements Command  {
	private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	private Document currentDocument;
	private String text;
	
	public AddLatexCommand() {
		versionsManager = VersionsManager.getInstance();
		latexEditorView = LatexEditorView.getInstance();
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		saveContents();
	}
	
	public void saveContents() {
		currentDocument = latexEditorView.getCurrentDocument();
		text = latexEditorView.getText();
		if(versionsManager.isEnabled()) {
			versionsManager.putVersion(currentDocument);
			currentDocument.changeVersion();
		}
		currentDocument.setContents(text);
	}
	
//	public void editContents(String type) {
//		String contents = editorPane.getText();
//		String before = contents.substring(0, editorPane.getCaretPosition());
//		String after = contents.substring(editorPane.getCaretPosition());
//		String [] selectType = { "chapter", "section", "subsection", "subsubsection", "enumerate", "itemize", "table", "figure"};
//		String [] input = {"\n\\chapter{...}", "\n\\section{...}", "\n\\subsection{...}",  "\n\\subsubsection{...}",
//				"\\begin{enumerate}\n"+
//				"\\item ...\n"+
//				"\\item ...\n"+
//				"\\end{enumerate}\n",
//				//itemize
//				"\\begin{itemize}\n"+
//				"\\item ...\n"+
//				"\\item ...\n"+
//				"\\end{itemize}\n",
//				//table
//				"\\begin{table}\n"+
//				"\\caption{....}\\label{...}\n"+
//				"\\begin{tabular}{|c|c|c|}\n"+
//				"\\hline\n"+
//				"... &...&...\\\\\n"+
//				"... &...&...\\\\\n"+
//				"... &...&...\\\\\n"+
//				"\\hline\n"+
//				"\\end{tabular}\n"+
//				"\\end{table}\n",
//				//figure
//				"\\begin{figure}\n"+
//				"\\includegraphics[width=...,height=...]{...}\n"+
//				"\\caption{....}\\label{...}\n"+
//				"\\end{figure}\n"};
//		
//		for(int i = 0; i < selectType.length; i++) {
//			if(type.equals(selectType[i])){
//				contents = before + input[i] + "\n"+after;
//			}
//		}
//		latexEditorView.setText(contents);
//		latexEditorView.getController().enact("addLatex");
//		editorPane.setText(contents);
//	}
}
