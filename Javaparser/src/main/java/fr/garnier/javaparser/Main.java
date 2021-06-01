package fr.garnier.javaparser;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.ThisExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;



public class Main {
    public static void main(String[] args){
        generateJavaCode();
    }

    private static void generateJavaCode() {
        CompilationUnit cu = new CompilationUnit();
        cu.setPackageDeclaration("fr.garnier.javapoet");

        ClassOrInterfaceDeclaration main = cu.addClass("Main");

        main.addField("Object","plugin", Modifier.Keyword.PRIVATE, Modifier.Keyword.STATIC);
        main.addField("String","name", Modifier.Keyword.PUBLIC);

        main.addConstructor(Modifier.Keyword.PUBLIC)
                .addParameter("String","name")
                .setBody(new BlockStmt()
                        .addStatement(new ExpressionStmt(new AssignExpr(
                                new FieldAccessExpr(
                                        new ThisExpr(), "name"),
                                new NameExpr("name"),
                                AssignExpr.Operator.ASSIGN))));


        main.addMethod("getPlugin", Modifier.Keyword.PUBLIC).setBody(
                new BlockStmt().addStatement(
                        new ReturnStmt(new NameExpr("plugin"))));

        main.addMethod("getName", Modifier.Keyword.PUBLIC).setBody(
                new BlockStmt().addStatement(
                        new ReturnStmt(new NameExpr("name"))));

        EnumDeclaration statut = cu.addEnum("statut");

        statut.addEnumConstant("NOTREADY");
        statut.addEnumConstant("READY");
        statut.addEnumConstant("STOPPED");

        System.out.println(cu.toString());
    }


}





