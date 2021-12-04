package Conveter;

import java.util.HashMap;

public class latexToHtml 
{
	private HashMap<String, String> latexToHtmlValues;
	private String laTexContents;
	private String htmlContents;
	private String[] latexLines;
	
	public latexToHtml(String laTexContents)
	{
		this.laTexContents = laTexContents;
		latexToHtmlValues = new HashMap<String, String>();
		htmlContents = "";
		makeDictionary();
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
	
	private void makeDictionary()
	{
		latexToHtmlValues.put("chapter", "<h1>");
		latexToHtmlValues.put("section", "<h2>");
		latexToHtmlValues.put("par", "<p>");
	}
	
	private void convertTatexToHtml()
	{
		System.out.println(latexLines[1]);
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
		}else
		{
			for(int i=0; i<latexLines.length-1; i++)
			{
				System.out.println(latexLines[i]);
				System.out.println("-------------------------------------------------------");
				String[] temp = latexLines[i].split("}");
				if(latexLines[i].contains("chapter") && !latexLines[i].contains("chapter*"))
				{
					htmlContents = htmlContents + "<h1 id=\""+temp[0].substring(8, temp[0].length())+"\">"+temp[0].substring(8, temp[0].length())+"</h1>" +"\n";
				}else if(latexLines[i].contains("section") && !latexLines[i].contains("section*"))
				{
					htmlContents = htmlContents + "<h2 id=\""+temp[0].substring(8, temp[0].length())+"\">"+temp[0].substring(8, temp[0].length())+"</h2>" +"\n";
				}else if(latexLines[i].contains("subsection"))
				{
					htmlContents = htmlContents + "<h3 id=\""+temp[0].substring(11, temp[0].length())+"\">"+temp[0].substring(11, temp[0].length())+"</h3>" +"\n";
				}else if(latexLines[i].contains("subsubsection"))
				{
					htmlContents = htmlContents + "<h4 id=\""+temp[0].substring(14, temp[0].length())+"\">"+temp[0].substring(14, temp[0].length())+"</h4>" +"\n";
				}else if(latexLines[i].contains("subparagraph"))
				{
					htmlContents = htmlContents + "<h5 id=\""+temp[0].substring(13, temp[0].length())+"\">"+temp[0].substring(13, temp[0].length())+"</h5>" +"\n";
				}else if(latexLines[i].contains("chapter*"))
				{
					htmlContents = htmlContents + "<h1 class=\"unnumbered\" id=\""+temp[0].substring(9, temp[0].length())+"\">"+temp[0].substring(9, temp[0].length())+"</h1>" +"\n";
				}else if(latexLines[i].contains("section*"))
				{
					htmlContents = htmlContents + "<h1 class=\"unnumbered\" id=\""+temp[0].substring(9, temp[0].length())+"\">"+temp[0].substring(9, temp[0].length())+"</h1>" +"\n";
				}
			}
		}
	}
	
	

}

