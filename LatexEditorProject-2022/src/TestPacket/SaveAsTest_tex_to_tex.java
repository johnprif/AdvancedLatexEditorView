package TestPacket;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Document;
import view.LatexEditorView;

class SaveAsTest_tex_to_tex {
	
	private static Document document;
	private static LatexEditorView latexEditorView;
	private static String expected;
	private static String fileNameWithPath = "C:\\Users\\Joanis Prifti\\Desktop\\test.tex";
	
	@BeforeAll
	public static void initialize() 
	{
		latexEditorView = LatexEditorView.getInstance();
		document = new Document();
		
		expected = "\\documentclass[11pt,a4paper]{report}\r\n"
				+ "\r\n"
				+ "\\begin{document}\r\n"
				+ "\\title{Report Template: How to Structure a LaTeX Document}\r\n"
				+ "\\author{Author...}\r\n"
				+ "\\date{\\today}\r\n"
				+ "\\maketitle\r\n"
				+ "\r\n"
				+ "\\begin{abstract}\r\n"
				+ "Your abstract goes here...\r\n"
				+ "...\r\n"
				+ "\\end{abstract}\r\n"
				+ "\r\n"
				+ "\\chapter{AdvancedLatexEditorView}\r\n"
				+ "\\section{PRIFTI JOANIS 3321}\r\n"
				+ "\\section{TUCALIUC AGNES MONALISA 3346}\r\n"
				+ "\\section{Section Title.....}\r\n"
				+ "\r\n"
				+ "\\chapter{....}\r\n"
				+ "\r\n"
				+ "\\chapter{WE PASS THE LESSON}\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\\chapter*{References}\r\n"
				+ "\r\n"
				+ "\\end{document}\r\n"
				+ "";
		
		document.setContents(expected);
		latexEditorView.setCurrentDocument(document);
		latexEditorView.setFilename(fileNameWithPath);
		document.save(latexEditorView.getFilename());
	}
	
	@Test
	void test() throws FileNotFoundException 
	{
		File file = new File(fileNameWithPath);
	    Scanner sc = new Scanner(file);
	    String actualContent = "";
	 
	    while (sc.hasNextLine())
	    {
	    	actualContent = actualContent + sc.nextLine() +"\r\n" ;
	    }
	    assertEquals(actualContent, expected);
	}
}
