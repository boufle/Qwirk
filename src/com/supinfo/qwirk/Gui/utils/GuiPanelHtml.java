package com.supinfo.qwirk.Gui.utils;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 * Created by Boufle on 13/12/2016.
 */
public class GuiPanelHtml extends JEditorPane {

    public GuiPanelHtml(){


        // make it read-only
        this.setEditable(false);

// add a HTMLEditorKit to the editor pane
        HTMLEditorKit kit = new HTMLEditorKit();
        this.setEditorKit(kit);

// now add it to a scroll pane
        JScrollPane scrollPane = new JScrollPane(this);

        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule(".grid {\n" +
                "  overflow: hidden;\n" +
                "  padding: 0.5em 0 0 0.5em;\n" +
                "  max-width: 76em;\n" +
                "  margin: 0 auto;\n" +
                "}\n" +
                ".grid li {\n" +
                "  padding: 0 0.5em 0.5em 0;\n" +
                "}\n" +
                "div {\n" +
                "  background: #808080;\n" +
                "  padding: 7em 2em;\n" +
                "  text-align: center;\n" +
                "}\n" +
                ".grid li.wide {\n" +
                "  width: 100%;\n" +
                "}\n" +
                ".grid li a {\n" +
                "  color: #fff;\n" +
                "}\n" +

                "");

// create a document, set it on the jeditorpane, then add the html
        Document doc = kit.createDefaultDocument();
        this.setDocument(doc);
        this.setText("<!--Pattern HTML-->\n" +
                "  <section id=\"pattern\" class=\"pattern\">\n" +
                "  \t<ul class=\"grid\">\n" +
                "\t\t\t<li>\n" +
                "\t\t\t\t<div>\n" +
                "\t\t\t\t\t<a href=\"#\">1</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li>\n" +
                "\t\t\t\t<div>\n" +
                "\t\t\t\t\t<a href=\"#\">2</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li>\n" +
                "\t\t\t\t<div>\n" +
                "\t\t\t\t\t<a href=\"#\">3</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li>\n" +
                "\t\t\t\t<div>\n" +
                "\t\t\t\t\t<a href=\"#\">4</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li class=\"wide\">\n" +
                "\t\t\t\t<div>\n" +
                "\t\t\t\t\t<a href=\"#\">5</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li class=\"wide\">\n" +
                "\t\t\t\t<div>\n" +
                "\t\t\t\t\t<a href=\"#\">6</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li>\n" +
                "\t\t\t\t<div>\n" +
                "\t\t\t\t\t<a href=\"#\">7</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li>\n" +
                "\t\t\t\t<div>\n" +
                "\t\t\t\t\t<a href=\"#\">8</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li>\n" +
                "\t\t\t\t<div>\n" +
                "\t\t\t\t\t<a href=\"#\">9</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li>\n" +
                "\t\t\t\t<div>\n" +
                "\t\t\t\t\t<a href=\"#\">10</a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t</ul>\n" +
                "\t</section>\n" +
                "\t\n" +
                "\t<div class=\"container\">\t\n" +
                "\t\t<section class=\"pattern-description\">\n" +
                "\t\t\t<h1>Double Wide Grid Block</h1>\n" +
                "\t\t\t<p>A list of objects with several items that are twice as big.</p>\n" +
                "\t\t</section>\n" +
                "\t\t<footer role=\"contentinfo\">   \n" +
                "\t\t\t<div>\n" +
                "\t\t\t\t<nav id=\"menu\">\n" +
                "\t\t\t\t\t<a href=\"http://bradfrost.github.com/this-is-responsive/patterns.html\">&larr;More Responsive Patterns</a>\n" +
                "\t\t\t\t</nav>\n" +
                "\t\t\t</div>\n" +
                "\t\t</footer>\n" +
                "\t</div>\n");
    }
}
