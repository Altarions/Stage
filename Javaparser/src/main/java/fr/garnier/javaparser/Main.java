package fr.garnier.javaparser;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;


import java.util.Optional;

public class Main {
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
        CompilationUnit compilationUnit
                = StaticJavaParser.parse("public class Main { }");
        Optional<ClassOrInterfaceDeclaration> classA
                = compilationUnit.getClassByName("Main");

    }

    private static void writeFile() {

    }


}
