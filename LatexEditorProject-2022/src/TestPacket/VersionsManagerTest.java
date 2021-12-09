package TestPacket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.LatexEditorView;

class VersionsManagerTest {

	private static VersionsManager versionsManager;
	private static LatexEditorView latexEditorView;
	
	@BeforeAll
	public static void initialize() 
	{
		versionsManager = VersionsManager.getInstance();
		latexEditorView = LatexEditorView.getInstance();
		latexEditorView.setVersionsManager(versionsManager);
		versionsManager.setLatexEditorView(latexEditorView);
		
	}
	
	@Test
	void changeStrategyFromStableToVolatileTest() {
		versionsManager.setStrategy(new StableVersionsStrategy()); //before
		latexEditorView.setStrategy("volatile"); //after
		versionsManager.changeStrategy();
		assertEquals(versionsManager.isEnabled(), true);
	}
	
	@Test
	void changeStrategyFromVolatileToStableTest() {
		versionsManager.setStrategy(new VolatileVersionsStrategy()); //before
		latexEditorView.setStrategy("stable"); //after
		versionsManager.changeStrategy();
		assertEquals(versionsManager.isEnabled(), true);
	}
	
	@Test
	void enableStrategyFromVolatileToStableTest() {
		versionsManager.setStrategy(new VolatileVersionsStrategy()); //before
		latexEditorView.setStrategy("stable"); //after
		versionsManager.enableStrategy();
		assertEquals(versionsManager.isEnabled(), true);
	}
	
	@Test
	void enableStrategyFromStableToVolatileTest() {
		versionsManager.setStrategy(new StableVersionsStrategy()); //before
		latexEditorView.setStrategy("volatile"); //after
		versionsManager.enableStrategy();
		assertEquals(versionsManager.isEnabled(), true);
	}
	
	@Test
	void enableStrategyFromStableToStableTest() {
		versionsManager.setStrategy(new StableVersionsStrategy()); //before
		latexEditorView.setStrategy("stable"); //after
		versionsManager.enableStrategy();
		assertEquals(versionsManager.isEnabled(), true);
	}
	
	@Test
	void enableStrategyFromVolatileToVolatileTest() {
		versionsManager.setStrategy(new VolatileVersionsStrategy()); //before
		latexEditorView.setStrategy("volatile"); //after
		versionsManager.enableStrategy();
		assertEquals(versionsManager.isEnabled(), true);
	}

}
