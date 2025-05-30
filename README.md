# AdvancedLatexEditorView

> A Java Swing desktop application to compose and edit LaTeX documents using ready‑made templates, version‑history (“stratagem”) saves, and automatic LaTeX↔HTML conversion, packaged as a Windows .exe for easy distribution.

[▶ Demo Video (YouTube)](https://www.youtube.com/watch?v=eOK_Icqcwe8) • [Download Demo ](https://github.com/johnprif/AdvancedLatexEditorView/releases/tag/Stable)

## 📋 Table of Contents

1. [Overview](#overview)  
2. [Features](#features)  
3. [Screenshots](#screenshots)  
4. [Technologies](#technologies)  
5. [Installation](#installation)  
6. [Usage](#usage)  
7. [Architecture](#architecture)  
8. [Contributing](#contributing)  
9. [License](#license)  
10. [Contact](#contact)  

## Overview

AdvancedLatexEditorView is a standalone **Java 13.0.2** application with a **Swing** GUI that helps users compose LaTeX documents via selectable templates, edit code with utility commands (e.g. “add chapter”), and maintain multiple saved versions (“stratagems”) for easy rollback. It also supports loading existing `.tex` or `.html` files (auto‑converting HTML→LaTeX) and exporting edits back to LaTeX or HTML formats.

## Features

- **Template library**: Choose from multiple ready‑made LaTeX templates to jump‑start document creation.  
- **Code utilities**: Add chapters, sections, and other LaTeX constructs via menu commands without hand‑typing boilerplate.
- **Version stratagems**: Save snapshots at any stage and restore previous versions, enabling non‑linear editing workflows.  
- **Import/export**: Load `.tex` or `.html` files from disk; automatically convert HTML to LaTeX (and vice versa) for editing (HTML support under construction).
- **Design patterns**: Core logic structured with **Singleton** for global state and **Factory** for parser instantiation, improving maintainability and extensibility.  
- **Windows packaging**: Delivered as a native .exe wrapper (via Launch4j) so end users need not manually run JARs.  

## Screenshots

<p align="center">  
  <img src="https://user-images.githubusercontent.com/56134761/210099244-85fe31fc-c35b-425e-ac27-4ff160e19af4.png" alt="Template selection" width="280"/>  
  <img src="https://user-images.githubusercontent.com/56134761/210099251-98adf9fd-6f02-4013-a0c1-097ada30aac6.png" alt="Editing view" width="280"/>  
  <img src="https://user-images.githubusercontent.com/56134761/210099256-d0f8e653-ddca-46d6-8be6-9ff24f93dfde.png" alt="Version history" width="280"/>  
</p>

## Technologies

| Category            | Technologies                                                                 |
|---------------------|-------------------------------------------------------------------------------|
| **Language & GUI**  | Java 13.0.2, Java Swing (Oracle Swing Tutorial)               |
| **Design Patterns** | Singleton, Factory Method (Refactoring.Guru) |
| **IDE & Build**     | Eclipse 2022‑06, Launch4j for exe packaging                |
| **File I/O**        | Standard Java NIO & IO APIs   

## Installation

1. **Download the latest release**  
   ⮕ [Releases › v0.7 (Dec 30, 2022)](https://github.com/johnprif/AdvancedLatexEditorView/releases/tag/Stable)
2. **Run the exe**  
   - Double‑click `AdvancedLatexEditorView.exe` on Windows (bundled JRE via Launch4j).  
3. **Launch** from Start Menu or desktop shortcut—no additional setup required.  

## Usage

1. **Select a template**: Create New Document → choose template → Create.  
2. **Edit document**: Use menu commands (e.g. Add Chapter) or raw code editor.  
3. **Save stratagem**: Version → Save Snapshot; restore via Version → Load Snapshot.  
4. **Import/Export**:  
   - Import LaTeX or HTML: File → Open.  
   - Export LaTeX/HTML: File → Save As → choose `.tex` or `.html`.  
5. **Exit**: File → Exit or close window.  

## Architecture

```plaintext
+--------------------+       +-------------------+       +------------------+
| Swing GUI (View)   | <-->  | Controller (Logic)| <-->  | Parser Factory   |
+--------------------+       +-------------------+       +------------------+
                                                        |
                                                        v
                                                +-------------------+
                                                | Version Manager   |
                                                | (Singleton)       |
                                                +-------------------+
```
- Follows **MVC**: Swing GUI separates presentation from control logic. 
- **Factory Method** produces parser instances for LaTeX or HTML.
- **Singleton** manages version snapshots globally.

## Contributing
Contributions welcome! Please:
1. Fork the repo
2. Create a branch: `git checkout -b feature/MyFeature`
3. Commit changes: `git commit -m "Add MyFeature"`
4. Push branch: `git push origin feature/MyFeature`
5. Open a Pull Request

## License
This project is licensed under the **MIT License**. See [LICENSE](https://github.com/johnprif/AdvancedLatexEditorView/blob/main/LICENSE) for full text.

## Contact
- GitHub: [joanisprifti](https://github.com/joanisprifti)
- Email: [joanisprifti@gmail.com](mailto:joanisprifti@gmail.com)
- Phone: [+306940020178](tel:+306940020178)

---
*Enjoy seamless LaTeX editing by the beach!*
