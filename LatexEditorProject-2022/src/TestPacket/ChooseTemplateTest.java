package TestPacket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.DocumentManager;

class ChooseTemplateTest {

	private static DocumentManager docman;
	private static String expectedArticle;
	private static String getActualArticle;
	private static String expectedBook;
	private static String getActualBook;
	private static String expectedReport;
	private static String getActualReport;
	private static String expectedLetter;
	private static String getActualLetter;
	private static String expectedEmpty;
	private static String getActualEmpty;
	
	@BeforeAll
	public static void initialize() 
	{
		docman = DocumentManager.getInstance();
		
		//Article
		getActualArticle = docman.getContents("articleTemplate");
		expectedArticle = "\\documentclass[11pt,twocolumn,a4paper]{article}\n\n"+
				"\\begin{document}\n"+
				"\\title{Article: How to Structure a LaTeX Document}\n"+
				"\\author{Author...}\n"+
				"\\date{\\today}\n\n"+
				"\\maketitle\n\n"+
				"\\section{Section Title 1}\n\n"+
				"\\section{Section Title 2}\n\n"+
				"\\section{Section Title.....}\n\n"+
				"\\section{Conclusion}\n\n"+
				"\\section*{References}\n\n"+
				"\\end{document}\n";
		
		//Book
		getActualBook = docman.getContents("bookTemplate");
		expectedBook = "\\documentclass[11pt,a4paper]{book}\n\n"+
				"\\begin{document}\n"+
				"\\title{Book: How to Structure a LaTeX Document}\n"+
				"\\author{Author...}\n"+
				"\\date{\\today}\n\n"+
				"\\maketitle\n\n"+
				"\\frontmatter\n\n"+
				"\\chapter{Preface}\n"+
				"% ...\n\n"+
				"\\mainmatter\n"+
				"\\chapter{First chapter}\n"+
				"\\section{Section Title 1}\n"+
				"\\section{Section Title 2}\n\n"+
				"\\section{Section Title.....}\n\n"+	
				"\\chapter{....}\n\n"+
				"\\chapter{Conclusion}\n\n"+
				"\\chapter*{References}\n\n\n"+
				"\\backmatter\n"+
				"\\chapter{Last note}\n\n"+
				"\\end{document}\n";
		
		//Report
		getActualReport = docman.getContents("reportTemplate");
		expectedReport = "\\documentclass[11pt,a4paper]{report}\n\n"+
				"\\begin{document}\n"+
				"\\title{Report Template: How to Structure a LaTeX Document}\n"+
				"\\author{Author...}\n"+
				"\\date{\\today}\n"+
				"\\maketitle\n\n"+
				"\\begin{abstract}\n"+
				"Your abstract goes here...\n"+
				"...\n"+
				"\\end{abstract}\n\n"+
				"\\chapter{Introduction}\n"+
				"\\section{Section Title 1}\n"+
				"\\section{Section Title 2}\n"+
				"\\section{Section Title.....}\n\n"+
				"\\chapter{....}\n\n"+
				"\\chapter{Conclusion}\n\n\n"+
				"\\chapter*{References}\n\n"+
				"\\end{document}\n";
		
		//Letter
		getActualLetter = docman.getContents("letterTemplate");
		expectedLetter = "\\documentclass{letter}\n"+
				"\\usepackage{hyperref}\n"+
				"\\signature{Sender's Name}\n"+
				"\\address{Sender's address...}\n"+
				"\\begin{document}\n\n"+
				"\\begin{letter}{Destination address....}\n"+
				"\\opening{Dear Sir or Madam:}\n\n"+
				"I am writing to you .......\n\n\n"+
				"\\closing{Yours Faithfully,}\n"+
				"\\ps\n\n"+
				"P.S. text .....\n\n"+
				"\\encl{Copyright permission form}\n\n"+
				"\\end{letter}\n"+
				"\\end{document}\n";
		
		//Empty document
		getActualEmpty = docman.getContents("emptyTemplate");
		expectedEmpty = null;
	}
	
	@Test
	void articleTemplateTest() {
		assertEquals(getActualArticle,expectedArticle);
	}
	
	@Test
	void bookTemplateTest() {
		assertEquals(getActualBook,expectedBook);
	}
	
	@Test
	void reportTemplateTest() {
		assertEquals(getActualReport,expectedReport);
	}
	
	@Test
	void letterTemplateTest() {
		assertEquals(getActualLetter,expectedLetter);
	}
	
	@Test
	void emptyTemplateTest() {
		assertEquals(getActualEmpty,expectedEmpty);
	}

}
