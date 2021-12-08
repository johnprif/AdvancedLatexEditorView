package TestPacket;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.Document;
import view.LatexEditorView;

class OpenFileTest_fromTex_to_tex {

	private static Document document;
	private static LatexEditorController latexEditorController;
	private static LatexEditorView latexEditorView;
	private static String expected;
	private static String fileNameWithPath = "C:\\Users\\Joanis Prifti\\Desktop\\test.tex";
	
	
	@BeforeAll
	public static void initialize() 
	{
		latexEditorController = new LatexEditorController();
		
		latexEditorView = LatexEditorView.getInstance();
		document = new Document();
		
		latexEditorView.setFilename(fileNameWithPath);
		latexEditorView.setController(latexEditorController);
		latexEditorView.setCurrentDocument(document);
		latexEditorView.getController().enact("load");
		expected = latexEditorView.getCurrentDocument().getContents();	
	}
	
	@Test
	void test() throws FileNotFoundException {
		String actual = "\\documentclass[11pt,a4paper]{report}\n"
				+ "\n"
				+ "\\begin{document}\n"
				+ "\\title{Report Template: How to Structure a LaTeX Document}\n"
				+ "\\author{Author...}\n"
				+ "\\date{\\today}\n"
				+ "\\maketitle\n"
				+ "\n"
				+ "\\begin{abstract}\n"
				+ "Your abstract goes here...\n"
				+ "...\n"
				+ "\\end{abstract}\n"
				+ "\n"
				+ "\\chapter{AdvancedLatexEditorView}\n"
				+ "\\section{PRIFTI JOANIS 3321}\n"
				+ "\\section{TUCALIUC AGNES MONALISA 3346}\n"
				+ "\\section{Section Title.....}\n"
				+ "\n"
				+ "\\chapter{....}\n"
				+ "\n"
				+ "\\chapter{WE PASS THE LESSON}\n"
				+ "\n"
				+ "\n"
				+ "\\chapter*{References}\n"
				+ "\n"
				+ "\\end{document}\n"
				+ "";
		
	    assertEquals(actual, expected);
	}

}
