package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.LatexEditorController;
import controller.commands.AddLatexCommand;
import controller.commands.Command;
import model.Document;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JCheckBoxMenuItem;

public class MainWindow {

	private JFrame frame;
	//private JEditorPane editorPane = new JEditorPane();
	private LatexEditorView latexEditorView;
	private JEditorPane editorPane;
	private AddLatexCommand addLatexCommand;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @param latexEditorView 
	 */
//	public MainWindow(LatexEditorView latexEditorView) {
	public MainWindow() {
		latexEditorView = LatexEditorView.getInstance();
		addLatexCommand = AddLatexCommand.getInstance();
		//this.latexEditorView = latexEditorView;
		editorPane = latexEditorView.getJEditorPane();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 823, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 805, 26);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewFile = new JMenuItem("New file");
		mntmNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				ChooseTemplate chooseTemplate = new ChooseTemplate(latexEditorView, "main");
				ChooseTemplate chooseTemplate = new ChooseTemplate("main");
				frame.dispose();
			}
		});
		mnFile.add(mntmNewFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setText(editorPane.getText());
				latexEditorView.getController().enact("edit");
			}
		});
		mnFile.add(mntmSave);
		JMenuItem addChapter = new JMenuItem("Add chapter");
		JMenu mnCommands = new JMenu("Commands");
		JMenuItem mntmLoadFile = new JMenuItem("Open file");
		mntmLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechooser = new JFileChooser();
				//We add here file a type filter for latex and html
				FileNameExtensionFilter types = new FileNameExtensionFilter("LATEX, HTML", "tex", "html");
				filechooser.setFileFilter(types);
				int option = filechooser.showOpenDialog(null);
				if(option == JFileChooser.APPROVE_OPTION) {
					String filename = filechooser.getSelectedFile().toString();
					latexEditorView.setFilename(filename);
					latexEditorView.getController().enact("load");
					mnCommands.setEnabled(true);
					addChapter.setEnabled(true);
					if(latexEditorView.getType().equals("letterTemplate")) {
						mnCommands.setEnabled(false);
					}
					if(latexEditorView.getType().equals("articleTemplate")) {
						addChapter.setEnabled(false);
					}
					editorPane.setText(latexEditorView.getCurrentDocument().getContents());
					System.out.println(latexEditorView.getCurrentDocument().getContents());
				}
			}
		});
		mnFile.add(mntmLoadFile);
		
		JMenuItem mntmSaveFile = new JMenuItem("Save As");
		mntmSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser filechooser = new JFileChooser();
				int option = filechooser.showSaveDialog(null);
				if(option == JFileChooser.APPROVE_OPTION) {
					String filename = filechooser.getSelectedFile().toString();
					if(filename.endsWith(".tex") == false && filename.endsWith(".html") == false)
					{
						//Default choise
						filename = filename+".tex";
					}
					latexEditorView.setFilename(filename);
					latexEditorView.getController().enact("save");
				}
				
			}
		});
		mnFile.add(mntmSaveFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		
		menuBar.add(mnCommands);
		if(latexEditorView.getType().equals("letterTemplate")) {
			mnCommands.setEnabled(false);
		}
		
		addChapter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addLatexCommand.editContents("chapter");
			}
		});
		mnCommands.add(addChapter);
		if(latexEditorView.getType().equals("articleTemplate")) {
			addChapter.setEnabled(false);
		}
		
		JMenu addSection = new JMenu("Add Section");
		mnCommands.add(addSection);
		
		JMenuItem mntmAddSection = new JMenuItem("Add section");
		mntmAddSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexCommand.editContents("section");
			}
		});
		addSection.add(mntmAddSection);
		
		JMenuItem mntmAddSubsection = new JMenuItem("Add subsection");
		mntmAddSubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexCommand.editContents("subsection");
			}
		});
		addSection.add(mntmAddSubsection);
		
		JMenuItem mntmAddSubsubsection = new JMenuItem("Add subsubsection");
		mntmAddSubsubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexCommand.editContents("subsubsection");
			}
		});
		addSection.add(mntmAddSubsubsection);
		
		JMenu addEnumerationList = new JMenu("Add enumeration list");
		mnCommands.add(addEnumerationList);
		
		JMenuItem mntmItemize = new JMenuItem("Itemize");
		mntmItemize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexCommand.editContents("itemize");
			}
		});
		addEnumerationList.add(mntmItemize);
		
		JMenuItem mntmEnumerate = new JMenuItem("Enumerate");
		mntmEnumerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexCommand.editContents("enumerate");
			}
		});
		addEnumerationList.add(mntmEnumerate);
		
		JMenuItem addTable = new JMenuItem("Add table");
		addTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexCommand.editContents("table");
			}
		});
		mnCommands.add(addTable);
		
		JMenuItem addFigure = new JMenuItem("Add figure");
		addFigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLatexCommand.editContents("figure");
			}
		});
		mnCommands.add(addFigure);
		
		JMenu mnStrategy = new JMenu("Strategy");
		menuBar.add(mnStrategy);
		
		JMenu mnEnable = new JMenu("Enable");
		mnStrategy.add(mnEnable);
		
		JCheckBoxMenuItem menuVolatile = new JCheckBoxMenuItem("Volatile");
		JCheckBoxMenuItem menuStable = new JCheckBoxMenuItem("Stable");
		menuStable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setStrategy("stable");
				if(latexEditorView.getVersionsManager().isEnabled() == false) {
					latexEditorView.getController().enact("enableVersionsManagement");
				}
				else {
					latexEditorView.getController().enact("changeVersionsStrategy");
				}
				menuVolatile.setSelected(false);
				menuStable.setEnabled(false);
				menuVolatile.setEnabled(true);
			}
		});

		menuVolatile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				latexEditorView.setStrategy("volatile");
				if(latexEditorView.getVersionsManager().isEnabled() == false) {
					latexEditorView.getController().enact("enableVersionsManagement");
				}
				else {
					latexEditorView.getController().enact("changeVersionsStrategy");
				}
				menuStable.setSelected(false);
				menuVolatile.setEnabled(false);
				menuStable.setEnabled(true);
			}
		});
		mnEnable.add(menuVolatile);
		
		mnEnable.add(menuStable);
		
		JMenuItem mntmDisable = new JMenuItem("Disable");
		mntmDisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.getController().enact("disableVersionsManagement");
			}
		});
		mnStrategy.add(mntmDisable);
		
		JMenuItem mntmRollback = new JMenuItem("Rollback");
		mntmRollback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				latexEditorView.getController().enact("rollbackToPreviousVersion");
				Document doc = latexEditorView.getCurrentDocument();
				editorPane.setText(doc.getContents());
			}
		});
		mnStrategy.add(mntmRollback);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 783, 467);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(editorPane);
		
		editorPane.setText(latexEditorView.getCurrentDocument().getContents());
	}
}
