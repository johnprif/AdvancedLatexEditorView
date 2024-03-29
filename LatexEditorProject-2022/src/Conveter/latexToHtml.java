package Conveter;

public class latexToHtml 
{
	private String laTexContents;
	private String htmlContents;
	private String[] latexLines;
	
	public latexToHtml(String laTexContents)
	{
		this.laTexContents = laTexContents;
		htmlContents = "";
		getLines();
		convertTatexToHtml();
	}
	
	public String getHtmlContents()
	{
		return htmlContents;
	}
	
	private void getLines()
	{
		latexLines = laTexContents.split("\\\\");
	}
	
	private void convertTatexToHtml()
	{	
		if(laTexContents.length() != 0) //check if is not blank 
		{
			if(latexLines[1].contains("letter"))
			{
				String destinationAddress = latexLines[6].substring(14, latexLines[6].length()-2);//begin
				String[] mainLine = latexLines[7].split("}");
				String dearSir = mainLine[0].substring(8, mainLine[0].length()); //opening
				String mainText = mainLine[1].substring(0, mainLine[1].length()-2); //mainText
				String closingText = latexLines[8].substring(8, latexLines[8].length()-2); //closing
				String psText = latexLines[9].substring(2, latexLines[9].length()-2); //ps text
			
				htmlContents =
								"<p><span>"+destinationAddress+"</span></p>"
								+"<p>"+dearSir+"</p>"
								+"<p>"+mainText+"</p>"
								+"<p>"+closingText+"</p>"
								+"<p>PS.</p>"
								+"<p>"+psText+"</p>";
			}else //article, book, report
			{
				for(int i=0; i<latexLines.length-1; i++)
				{
					String[] temp = latexLines[i].split("}");
					if(latexLines[i].contains("chapter") && !latexLines[i].contains("chapter*")) //chapter
					{
						htmlContents = htmlContents + "<h1 id=\""+temp[0].substring(8, temp[0].length())+"\">"+temp[0].substring(8, temp[0].length())+"</h1>" +"\n";
					}else if(latexLines[i].contains("section") && !latexLines[i].contains("section*") && !latexLines[i].contains("subsection") && !latexLines[i].contains("subsubsection")) //section
					{
						htmlContents = htmlContents + "<h2 id=\""+temp[0].substring(8, temp[0].length())+"\">"+temp[0].substring(8, temp[0].length())+"</h2>" +"\n";
					}else if(latexLines[i].contains("subsection") && !latexLines[i].contains("subsubsection")) //subsection
					{
						htmlContents = htmlContents + "<h3 id=\""+temp[0].substring(11, temp[0].length())+"\">"+temp[0].substring(11, temp[0].length())+"</h3>" +"\n";
					}else if(latexLines[i].contains("subsubsection")) //subsubsection
					{
						htmlContents = htmlContents + "<h4 id=\""+temp[0].substring(14, temp[0].length())+"\">"+temp[0].substring(14, temp[0].length())+"</h4>" +"\n";
					}else if(latexLines[i].contains("subparagraph")) //subparagraph
					{
						htmlContents = htmlContents + "<h5 id=\""+temp[0].substring(13, temp[0].length())+"\">"+temp[0].substring(13, temp[0].length())+"</h5>" +"\n";
					}else if(latexLines[i].contains("chapter*")) //other chapter
					{
						htmlContents = htmlContents + "<h1 class=\"unnumbered\" id=\""+temp[0].substring(9, temp[0].length())+"\">"+temp[0].substring(9, temp[0].length())+"</h1>" +"\n";
					}else if(latexLines[i].contains("section*")) //other section
					{
						htmlContents = htmlContents + "<h1 class=\"unnumbered\" id=\""+temp[0].substring(9, temp[0].length())+"\">"+temp[0].substring(9, temp[0].length())+"</h1>" +"\n";
					}else if(latexLines[i].contains("par")) // new paragraph
					{
						htmlContents = htmlContents + "<p id=\""+temp[0].substring(4, temp[0].length())+"\">"+temp[0].substring(4, temp[0].length())+"</p>" +"\n";
					}else if(latexLines[i].contains("begin{enumerate}")) 
					{
						htmlContents = htmlContents + "<ol>" +"\n";
					}else if(latexLines[i].contains("item") && !latexLines[i].contains("begin{itemize}") && !latexLines[i].contains("end{itemize}"))
					{
						htmlContents = htmlContents + "<li id=\""+latexLines[i].substring(5, latexLines[i].length())+"\">"+latexLines[i].substring(5, latexLines[i].length())+"</li>" +"\n";
					}else if(latexLines[i].contains("end{enumerate}"))
					{
						htmlContents = htmlContents + "</ol>" +"\n";
					}else if(latexLines[i].contains("begin{itemize}"))
					{
						htmlContents = htmlContents + "<ul>" +"\n";
					}else if(latexLines[i].contains("item") && !latexLines[i].contains("begin{itemize}") && !latexLines[i].contains("end{itemize}"))
					{
						htmlContents = htmlContents + "<dt id=\""+latexLines[i].substring(5, latexLines[i].length())+"\">"+latexLines[i].substring(5, latexLines[i].length())+"</dt>" +"\n";
					}else if(latexLines[i].contains("end{itemize}"))
					{
						htmlContents = htmlContents + "</ul>" +"\n";
					}else if(latexLines[i].contains("text") && !latexLines[i].contains("textit{") && !latexLines[i].contains("textbf{") && !latexLines[i].contains("texttt{")) //definition
					{
						htmlContents = htmlContents + "<dd id=\""+latexLines[i].substring(5, latexLines[i].length())+"\">"+latexLines[i].substring(5, latexLines[i].length())+"</dd>" +"\n";
					}else if(latexLines[i].contains("emph{")) //emphasis
					{
						htmlContents = htmlContents + "<em id=\""+temp[0].substring(5, temp[0].length())+"\">"+temp[0].substring(5, temp[0].length())+"</em>" +"\n";
					}else if(latexLines[i].contains("textit{")) //italic
					{
						htmlContents = htmlContents + "<i id=\""+temp[0].substring(7, temp[0].length())+"\">"+temp[0].substring(7, temp[0].length())+"</i>" +"\n";
					}else if(latexLines[i].contains("textbf{")) //bold
					{
						htmlContents = htmlContents + "<b id=\""+temp[0].substring(7, temp[0].length())+"\">"+temp[0].substring(7, temp[0].length())+"</b>" +"\n";
					}else if(latexLines[i].contains("texttt{")) //fixed with
					{
						htmlContents = htmlContents + "<tt id=\""+temp[0].substring(7, temp[0].length())+"\">"+temp[0].substring(7, temp[0].length())+"</tt>" +"\n";
					}
				}
			}
		}
		
	}
	
	

}

