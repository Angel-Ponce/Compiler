/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Compiler.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author angelponce
 */
public class LexicAnalizer {

    private ArrayList<Element> elements;
    private JTextArea input;
    private JTextArea output;
    private String outputFileName = null;
    private final ImageIcon fileIcon = new ImageIcon(getClass().getResource("/Images/file.png"));

    public LexicAnalizer(ArrayList<Element> elements, JTextArea input, JTextArea output) {
        this.elements = elements;
        this.input = input;
        this.output = output;
    }

    public LexicAnalizer() {
    }

    public void analize() {

        output.setText("");
        String code = input.getText().trim(); //delete front an back null spaces
        code = code.replace("\n", " ");
        String[] words = split(code, "(?:\"[^\"]*?\"|[^\\s])+");
        String line = "";
        for (String w : words) {
            if (!w.matches("\\s+")) {
                line += w + " ";
            }
        }
        line = line.trim();
        line = line += "  ";
        String element = "";
        int indexChar = 0;
        for (int i = 0; i < line.length(); i++) {
            String character = String.valueOf(line.charAt(i));
            indexChar = i;
            if (character.matches("(\\w|\\.)")) {
                element += character;
            } else {
                if (character.equals("\"")) {
                    for (int j = indexChar + 1; j < line.length(); j++) {
                        i++;
                        character = String.valueOf(line.charAt(j));
                        if (!character.equals("\"")) {
                            element += character;
                        } else {
                            String token = "<\",sy_codo> " + "<" + element + ",value> " + "<\",sy_codo> ";
                            output.append(token);
                            element = "";
                            break;
                        }
                    }
                } else if (character.equals("\'")) {
                    for (int j = indexChar + 1; j < line.length(); j++) {
                        i++;
                        character = String.valueOf(line.charAt(j));
                        if (!character.equals("\'")) {
                            element += character;
                        } else {
                            String token = "<\',sy_cosi> " + "<" + element + ",value> " + "<\',sy_cosi> ";
                            output.append(token);
                            element = "";
                            break;
                        }
                    }
                } else {
                    if (!character.matches("\\s|\\t")) {
                        if (!element.isEmpty()) {
                            String token = "<" + element + "," + elementDescription(element) + "> " + "<" + character + "," + elementDescription(character) + "> ";
                            output.append(token);
                        } else {
                            String token = "<" + character + "," + elementDescription(character) + "> ";
                            output.append(token);
                        }
                        if (character.equals(";") || character.equals("{") || character.equals("}")) {
                            if (!String.valueOf(line.charAt(indexChar + 1)).equals(";")) {
                                if (!String.valueOf(line.charAt(indexChar + 2)).equals(";")) {
                                    output.append("\n");
                                }
                            }
                        }
                    } else {
                        if (!element.isEmpty()) {
                            String token = "<" + element + "," + elementDescription(element) + "> ";
                            output.append(token);
                        }
                    }
                    element = "";
                }
            }
        }
        //Una doble pasada para buscar los números con exponentes
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(output.getText().split("\n")));
        output.setText("");
        tokens.forEach((token) -> {
            String[] t = token.split("\\s");
            for (int i = 0; i < t.length; i++) {
                if (t[i].matches("<\\d+(.\\d+)?E,error>") && i < (t.length - 2)) {
                    if (t[i + 1].matches("<(\\+|-),(op_less|op_add)>")) {
                        if (t[i + 2].matches("<\\d+,num>")) {
                            String t1 = t[i];
                            String t2 = t[i + 1];
                            String t3 = t[i + 2];
                            String oldChar = "" + t1 + " " + t2 + " " + t3;
                            t1 = t1.replace("<", "").replace(">", "").replace(",", "").replace("error", "");
                            t2 = t2.replace("<", "").replace(">", "").replace(",", "").replace("op_less", "");
                            t2 = t2.replace("<", "").replace(">", "").replace(",", "").replace("op_add", "");
                            t3 = t3.replace("<", "").replace(">", "").replace(",", "").replace("num", "");
                            String newChar = "<" + t1 + t2 + t3 + "," + "num" + ">";
                            token = token.replace(oldChar, newChar);
                        }
                    }

                }
            }
            output.append(token + "\n");
        });

        cleanOutput();
        int save = JOptionPane.showConfirmDialog(null, "¿Desea guardar los tokens?", "Atención", JOptionPane.YES_NO_OPTION);
        if (save == JOptionPane.YES_OPTION) {
            outputFileName = (String) JOptionPane.showInputDialog(null, "Nombre de archivo: ", "Archivo", JOptionPane.DEFAULT_OPTION, fileIcon, null, null);
            if (outputFileName != null) {
                if (outputFileName.matches("\\w+")) {
                    ArrayList<String> contentOutput = new ArrayList<>(Arrays.asList(output.getText().split("\n")));
                    Txt outputFile = new Txt(outputFileName);
                    outputFile.addContent(contentOutput);
                    outputFileName = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre incorrecto");
                }
            }

        }

    }

    public static String[] split(CharSequence input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int start = 0;
        ArrayList<String> result = new ArrayList();
        while (matcher.find()) {
            result.add(input.subSequence(start, matcher.start()).toString());
            result.add(matcher.group());
            start = matcher.end();
        }
        if (start != input.length()) {
            result.add(input.subSequence(start, input.length()).toString());
        }
        return result.toArray(new String[0]);
    }

    private String elementDescription(String line) {
        String description = "value";
        for (Element element : elements) {
            if (element.getValue().equals(line)) {
                description = element.getDescription();
                break;
            }
        }
        if (description.equals("value")) {
            if (line.matches("^(_{2,}|_\\w|[a-zA-Z])\\w*$")) {
                description = "id";
            } else if (line.matches("\\d+(\\.)?(\\d*)?(f|((E[+-]?\\d)?)d?|l)?")) {
                description = "num";
            } else if (line.matches("^(((_{2,}|_\\w|[a-zA-Z])\\w*).)+$")) {
                description = "objects";
            } else {
                description = "error";
            }
        }
        return description;
    }

    private void cleanOutput() {
        String code = output.getText();
        String[] tokens = code.split("\n");
        output.setText("");
        for (String token : tokens) {
            if (!token.matches("\\s*|\\t*")) {
                output.append(token.trim() + "\n");
            }
        }
    }
}
