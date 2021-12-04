package TestPacket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import view.LatexEditorView;

class CommandTest {

	private static LatexEditorView latexEditorView;
	@BeforeAll
	public static void initialize() {
		latexEditorView = LatexEditorView.getInstance();
	}
	
	@Test
	public final void testExample() {
		String text1 = "kati";
		String text2 = "kati allo";
		
		// String expected = latexEditorView.getText()
		// saveCommand.execute()
		// String actual = load from disk
		
		// Expected, actual
		assertEquals(text1, text2);
	}

}
