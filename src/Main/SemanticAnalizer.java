/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author angelponce
 */
public class SemanticAnalizer {

    public SemanticAnalizer() {

    }

    public void analize() {

    }

    private static int sizeOf(String type) {
        switch (type) {
            case "byte":
                return 1;
            case "short":
                return 2;
            case "int":
                return 4;
            case "long":
                return 8;
            case "float":
                return 4;
            case "double":
                return 8;
            case "boolean":
                return 1;
            case "char":
                return 2;
            case "String":
                return 8;
            default:
                return -1;
        }
    }
}
