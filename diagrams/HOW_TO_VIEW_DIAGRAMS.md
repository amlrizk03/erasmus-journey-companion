# How to View UML Diagrams

This folder contains UML diagrams in PlantUML format (`.puml` files). Here's how to view them:

## Quick Start - Online Viewer (Easiest)

1. Go to: **https://www.plantuml.com/plantuml/uml/**
2. Copy the entire content from any `.puml` file
3. Paste it into the text editor on the website
4. The diagram will automatically render

## Recommended Tools

### 1. PlantUML Online Editor
- **URL**: https://www.plantuml.com/plantuml/uml/
- **Pros**: No installation needed, instant preview
- **Cons**: Requires internet connection

### 2. PlantText
- **URL**: https://www.planttext.com/
- **Pros**: Clean interface, easy export
- **Cons**: Requires internet connection

### 3. VS Code Extension (Best for Development)
1. Install extension: "PlantUML" by jebbs
2. Open any `.puml` file
3. Press `Alt+D` (or `Cmd+D` on Mac) to preview
4. Diagrams update in real-time as you edit

**Note:** VS Code extension requires Java to be installed

### 4. IntelliJ IDEA Plugin
1. Install "PlantUML integration" plugin
2. Right-click on `.puml` file
3. Select "Show PlantUML Diagram"

## Command Line (Advanced)

If you have PlantUML jar and GraphViz installed:

```bash
# Generate PNG images
java -jar plantuml.jar class-diagram.puml
java -jar plantuml.jar sequence-diagram-1.puml
java -jar plantuml.jar sequence-diagram-2.puml

# Generate SVG (scalable)
java -jar plantuml.jar -tsvg *.puml
```

## Files in This Folder

1. **class-diagram.puml** - Complete system class diagram with all 4 design patterns
2. **sequence-diagram-1.puml** - User registration and activity subscription flow
3. **sequence-diagram-2.puml** - Recommendations and deadline notifications flow

## Tips

- For best quality, export as SVG when possible
- Use zoom features to see details in complex diagrams
- The class diagram is comprehensive - take time to explore each package
- Sequence diagrams show chronological flow - read from top to bottom

## Troubleshooting

**Problem:** "Syntax error" when viewing online  
**Solution:** Make sure you copied the entire file content including `@startuml` and `@enduml`

**Problem:** Diagram doesn't render in VS Code  
**Solution:** Ensure Java is installed and accessible in your PATH

**Problem:** Text is too small  
**Solution:** Use the zoom feature or increase your browser/editor font size

## Need Help?

PlantUML Official Documentation: https://plantuml.com/
