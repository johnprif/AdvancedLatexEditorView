package model;

import java.util.HashMap;

public class DocumentManager {
	private HashMap<String, Document> templates;
	Document document;
	private static DocumentManager instance = null;
	
	private DocumentManager() {
		templates = new HashMap<String, Document>();
		document = new Document();
		String [] selectTemplate = {"reportTemplate","bookTemplate","articleTemplate","letterTemplate"};
		for(int i = 0; i < selectTemplate.length; i++) {
			document = new Document();
			document.setContents(getContents(selectTemplate[i]));
			templates.put(selectTemplate[i], document);
		};
		document = new Document();
		templates.put("emptyTemplate", document);
	}
	
	public static DocumentManager getInstance()
	{
		if (instance == null)
		{
			instance = new DocumentManager();
		}
        return instance;
	}

	
	public Document createDocument(String type) {
		return templates.get(type).clone();
	}
	
	public String getContents(String type) {
		HashMap<String, String> temp1 = new HashMap<String, String>();
		addContents(temp1);
		return temp1.get(type);	
	}
	
	private void addContents(HashMap<String, String> kati)
	{
		String [] templateType = {"articleTemplate", "bookTemplate", "letterTemplate", "reportTemplate"};
		String [] input = { //ARTICLE
						"\\documentclass[11pt,twocolumn,a4paper]{article}\n\n"+
						"\\begin{document}\n"+
						"\\title{Article: How to Structure a LaTeX Document}\n"+
						"\\author{Author1 \\and Author2 \\and ...}\n"+
						"\\date{\\today}\n\n"+
						"\\maketitle\n\n"+
						"\\section{Section Title 1}\n\n"+
						"\\section{Section Title 2}\n\n"+
						"\\section{Section Title.....}\n\n"+
						"\\section{Conclusion}\n\n"+
						"\\section*{References}\n\n"+
						"\\end{document}\n", 
						// BOOK
						"\\documentclass[11pt,a4paper]{book}\n\n"+
						"\\begin{document}\n"+
						"\\title{Book: How to Structure a LaTeX Document}\n"+
						"\\author{Author1 \\and Author2 \\and ...}\n"+
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
						"\\end{document}\n", 
						// LETTER
						"\\documentclass{letter}\n"+
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
						"\\end{document}\n",
						// REPORT
						"\\documentclass[11pt,a4paper]{report}\n\n"+
						"\\begin{document}\n"+
						"\\title{Report Template: How to Structure a LaTeX Document}\n"+
						"\\author{Author1 \\and Author2 \\and ...}\n"+
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
						"\\end{document}\n" };
		
		for(int i=0; i<templateType.length; i++)
		{
			kati.put(templateType[i], input[i]);
		}
	}
}
