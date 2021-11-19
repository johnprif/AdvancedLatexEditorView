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
//		super();
//		this.versionsManager = versionsManager;
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
//		
//		if(type.equals("chapter")) {
//			contents = before + "\n\\chapter{...}"+"\n"+after;
//		}
//		else if(type.equals("section")) {
//			contents = before + "\n\\section{...}"+"\n"+after;
//		}
//		else if(type.equals("subsection")) {
//			contents = before + "\n\\subsection{...}"+"\n"+after;
//		}
//		else if(type.equals("subsubsection")) {
//			contents = before + "\n\\subsubsection{...}"+"\n"+after;
//		}
//		else if(type.equals("enumerate")) {
//			contents = before + 
//					"\\begin{enumerate}\n"+
//					"\\item ...\n"+
//					"\\item ...\n"+
//					"\\end{enumerate}\n"+after;
//		}
//		else if(type.equals("itemize")) {
//			contents = before + 
//					"\\begin{itemize}\n"+
//					"\\item ...\n"+
//					"\\item ...\n"+
//					"\\end{itemize}\n"+after;
//		}
//		else if(type.equals("table")) {
//			contents = before + 
//					"\\begin{table}\n"+
//					"\\caption{....}\\label{...}\n"+
//					"\\begin{tabular}{|c|c|c|}\n"+
//					"\\hline\n"+
//					"... &...&...\\\\\n"+
//					"... &...&...\\\\\n"+
//					"... &...&...\\\\\n"+
//					"\\hline\n"+
//					"\\end{tabular}\n"+
//					"\\end{table}\n"+after;
//		}
//		else if(type.equals("figure")) {
//			contents = before + 
//					"\\begin{figure}\n"+
//					"\\includegraphics[width=...,height=...]{...}\n"+
//					"\\caption{....}\\label{...}\n"+
//					"\\end{figure}\n"+after;
//;
//		}
//		latexEditorView.setText(contents);
//		latexEditorView.getController().enact("addLatex");
//		editorPane.setText(contents);
//	}

	
}
