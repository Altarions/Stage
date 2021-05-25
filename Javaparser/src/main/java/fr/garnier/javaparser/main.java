package fr.garnier.javaparser;

import com.github.javaparser.*;

public class main {
    public static void main(String[] args){
        generateJavaCode();
    }

    private static void generateJavaCode() {

        generationMain();
        generationStatus();

        generationCommand();
    }

    private static void generationCommand() {
    }

    private static void generationStatus() {

    }

    private static void generationMain() {
        CompliationUnit compliationUnit
                = StaticJavaParser.parse("class Main { }");
        Optional<ClassOrInterfaceDeclaration> classA
                = compliationUnit.getClassByName("Main");

    }

    private static void writeFile() {

    }


}
