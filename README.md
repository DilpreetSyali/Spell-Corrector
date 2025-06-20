
SpellCorrectorGUI is a JavaFX-based spell correction application that enables users to input a word and receive corrected suggestions from a predefined dictionary. It combines the power of Trie data structures, Levenshtein distance, and Peter Norvig’s spell correction algorithm to deliver intelligent results in an easy-to-use GUI.

🚀 Features
🔤 Spell Correction: Suggests the most likely correct spelling for any input word.

🖥️ Graphical User Interface: Intuitive JavaFX interface for entering and correcting words.

⚡ Efficient Lookup: Uses a Trie for fast and memory-efficient dictionary storage and retrieval.

🧠 Advanced Algorithms: Combines Levenshtein distance and Peter Norvig’s approach for robust correction.

📁 Project Structure

project/
│
├── javafx-sdk-22.0.2/         # JavaFX SDK
│   └── lib/                   # JavaFX libraries
│
├── src/                       # Source files
│   ├── SpellCorrector.java        # Core logic for spell correction
│   ├── SpellCorrectorGUI.java     # JavaFX GUI
│   ├── Trie.java                  # Trie data structure
│   └── TrieNode.java              # Trie node representation
│
├── bin/                       # Compiled .class files (after compilation)
└── README.md

⚙️ Prerequisites
Java 21
JavaFX SDK 22.0.2

✅ HERE IS THE WORKING VIDEO:



https://github.com/user-attachments/assets/d6a4f6dc-7552-4e85-a164-16e15027858d


🛠️ Setup and Installation
Clone or Download the Repository
Place the project in your local development directory.

Place JavaFX SDK
Copy the javafx-sdk-22.0.2 folder into the project root.

Compile the Project
Run this in PowerShell (from the project directory):

powershell

javac --module-path "javafx-sdk-22.0.2\lib" --add-modules javafx.controls -d bin src\*.java
Run the Application
Launch the GUI using:
powershell
java --module-path "javafx-sdk-22.0.2\lib" --add-modules javafx.controls -cp bin SpellCorrectorGUI
Using VS Code

Make sure the JavaFX plugin is installed.

Configure launch.json to include the JavaFX VM arguments if running inside the editor.

