package analyzer.visitors;

import analyzer.SemantiqueError;
import analyzer.ast.*;

import javax.lang.model.element.VariableElement;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created: 19-01-10
 * Last Changed: 22-01-29
 * Author: Esther Guerrier
 * Modified by: Hakim Mektoub
 * <p>
 * Description: Ce visiteur explorer l'AST est renvois des erreur lorqu'une erreur sémantique est détecté.
 */

public class SemantiqueVisitor implements ParserVisitor {

    private final PrintWriter writer;

    private HashMap<String, VarType> symbolTable = new HashMap<>(); // mapping variable -> type

    // variable pour les metrics
    private int VAR = 0;
    private int WHILE = 0;
    private int IF = 0;
    private int FOR = 0;
    private int OP = 0;
    private boolean error = false;

    public SemantiqueVisitor(PrintWriter writer) {
        this.writer = writer;
    }

    //Vous pouvez utilisez cette fonction pour imprimer vos erreurs.
    private void print(final String msg) {
        if (!error) {
            writer.print(msg);
            error = true;
        }
    }

    /*
    Le Visiteur doit lancer des erreurs lorsqu'un situation arrive.

    regardez l'énoncé ou les tests pour voir le message à afficher et dans quelle situation.
    Lorsque vous voulez afficher une erreur, utilisez la méthode print implémentée ci-dessous.
    Tous vos tests doivent passer!!

     */

    @Override
    public Object visit(SimpleNode node, Object data) {
        node.childrenAccept(this, data);
        return null;
    }

    @Override
    public Object visit(ASTProgram node, Object data) {
        try {
            node.childrenAccept(this, data);
            print(String.format("{VAR:%d, WHILE:%d, IF:%d, FOR:%d, OP:%d}", VAR, WHILE, IF, FOR, OP));
        }
        catch (SemantiqueError error){
            print(error.getMessage());
        }
        return null;
    }

    /*
    Ici se retrouve les noeuds servant à déclarer une variable.
    Certaines doivent enregistrer les variables avec leur type dans la table symbolique.
     */
    @Override
    public Object visit(ASTDeclaration node, Object data) {
        node.childrenAccept(this, data);
        return null;
    }

    @Override
    public Object visit(ASTNormalDeclaration node, Object data) {
        VAR++;
        String varName = ((ASTIdentifier) node.jjtGetChild(0)).getValue();
        String typeName = node.getValue();

        VarType type = VarType.num;

        if (typeName.equals("bool")){
            type = VarType.bool;
        }else if(typeName.equals("real")){
            type = VarType.real;
        }
        checkInvalidDeclaration(varName);
        symbolTable.put(varName, type);

        node.childrenAccept(this,data);
        return null;
    }


    @Override
    public Object visit(ASTListDeclaration node, Object data) {
        VAR++;
        String varName = ((ASTIdentifier) node.jjtGetChild(0)).getValue();
        String typeName = node.getValue();
        checkInvalidDeclaration(varName);

        VarType type = VarType.listnum;
        if (typeName.equals("listbool")){
            type = VarType.listbool;
        }else if(typeName.equals("listreal")){
            type = VarType.listreal;
        }

        symbolTable.put(varName, type);
        node.childrenAccept(this,data);
        return null;
    }

    @Override
    public Object visit(ASTBlock node, Object data) {
        node.childrenAccept(this, data);
        return null;
    }


    @Override
    public Object visit(ASTStmt node, Object data) {
        node.childrenAccept(this, data);
        return null;
    }

    /*
     * Il faut vérifier que le type déclaré à gauche soit compatible avec la liste utilisée à droite. N'oubliez pas
     * de vérifier que les variables existent.
     */


    @Override
    public Object visit(ASTForEachStmt node, Object data) {
        FOR++;

        String varNameList = ((ASTIdentifier) node.jjtGetChild(1)).getValue();
        checkInvalidUseIdentifier(varNameList);
        checkIfArrayType(varNameList);

        DataStruct child0Info = goGetChildInfo(node,0);
        if(child0Info.symbol != null){
            checkInvalidArrayAssignement(child0Info.symbol,varNameList);
        }

        node.jjtGetChild(1).jjtAccept(this, data);
        node.jjtGetChild(2).jjtAccept(this, data);
        return null;
    }


    /*
    Ici faites attention!! Lisez la grammaire, c'est votre meilleur ami :)
     */
    @Override
    public Object visit(ASTForStmt node, Object data) {
        FOR++;
        checkCondition(node,data,1);
        node.childrenAccept(this, data);
        return null;
    }

    /*
    Méthode recommandée à implémenter puisque vous remarquerez que quelques fonctions ont exactement le même code! N'oubliez
    -pas que la qualité du code est évalué :)
     */
    private void callChildenCond(SimpleNode node) {

    }

    /*
    les structures conditionnelle doivent vérifier que leur expression de condition est de type booléenne
    On doit aussi compter les conditions dans les variables IF et WHILE
     */
    @Override
    public Object visit(ASTIfStmt node, Object data) {
        IF++;
        checkCondition(node,data,0);
        node.childrenAccept(this,data);
        return null;
    }

    @Override
    public Object visit(ASTWhileStmt node, Object data) {
        WHILE++;
        checkCondition(node,data,0);
        node.childrenAccept(this,data);
        return null;
    }

    /*
    On doit vérifier que le type de la variable est compatible avec celui de l'expression.
    La variable doit etre déclarée.
     */
    @Override
    public Object visit(ASTAssignStmt node, Object data) {
        String varName1 = ((ASTIdentifier) node.jjtGetChild(0)).getValue();

        checkInvalidUseIdentifier(varName1);

        DataStruct childInfo = goGetChildInfo(node,1);
        if(childInfo.symbol != null){
            if(childInfo.type==null) childInfo.type = symbolTable.get(childInfo.symbol);
        }

        checkInvalidTypeAssignment(varName1,childInfo);
        return null;
    }

    @Override
    public Object visit(ASTExpr node, Object data) {
        //Il est normal que tous les noeuds jusqu'à expr retourne un type.
        if(node.jjtGetNumChildren() == 1){
            if (data != null && data instanceof DataStruct) {
                DataStruct child0Info = goGetChildInfo(node, 0);
                ((DataStruct) data).type = child0Info.type;
                ((DataStruct) data).symbol = child0Info.symbol;
            }
        }
        return null;
    }

    @Override
    public Object visit(ASTCompExpr node, Object data) {
        /*attention, ce noeud est plus complexe que les autres.
        si il n'a qu'un seul enfant, le noeud a pour type le type de son enfant.

        si il a plus d'un enfant, alors ils s'agit d'une comparaison. il a donc pour type "bool".

        de plus, il n'est pas acceptable de faire des comparaisons de booleen avec les opérateur < > <= >=.
        les opérateurs == et != peuvent être utilisé pour les nombres, les réels et les booléens, mais il faut que le type soit le même
        des deux côté de l'égalité/l'inégalité.
        */

        int nChild = node.jjtGetNumChildren();
        if(nChild == 1){
            if (data != null && data instanceof DataStruct) {
                DataStruct child0Info = goGetChildInfo(node, 0);
                ((DataStruct) data).type = child0Info.type;
                ((DataStruct) data).symbol = child0Info.symbol;
            }
        }
        else if(nChild>1) {
            OP += nChild-1;
            String operator = node.getValue();
            VarType child0Type = goGetChildInfo(node, 0).type;
            VarType child1Type = goGetChildInfo(node, 1).type;
            if((operator.equals(">") ||operator.equals("<") ||operator.equals(">=") ||operator.equals("<="))
                && (child0Type == VarType.bool || child1Type == VarType.bool)){
                throwInvalidTypeInExpr();
            }
            if(child0Type != child1Type){
                throwInvalidTypeInExpr();
            }
            ((DataStruct) data).type = VarType.bool;
            ((DataStruct) data).symbol = null;
        }
        return null;
    }

    private void callChildren(SimpleNode node, Object data, VarType validType) {

    }

    /*
    opérateur binaire
    si il n'y a qu'un enfant, aucune vérification à faire.
    par exemple, un AddExpr peut retourné le type "Bool" à condition de n'avoir qu'un seul enfant.
    Sinon, il faut s'assurer que les types des valeurs sont les mêmes des deux cotés de l'opération
     */
    @Override
    public Object visit(ASTAddExpr node, Object data) {
        OP += node.getOps().size();
        DataStruct child0Info = goGetChildInfo(node, 0);
        ((DataStruct) data).type = child0Info.type;
        ((DataStruct) data).symbol = child0Info.symbol;
        for (int i = 1; i < node.jjtGetNumChildren(); i++){
            checkInvalidMathTypes(node, ((DataStruct) data).type, i);
        }
        return null;
    }

    @Override
    public Object visit(ASTMulExpr node, Object data) {
        OP += node.getOps().size();
        DataStruct child0Info = goGetChildInfo(node, 0);
        ((DataStruct) data).type = child0Info.type;
        ((DataStruct) data).symbol = child0Info.symbol;
        for (int i = 1; i < node.jjtGetNumChildren(); i++){
            checkInvalidMathTypes(node, ((DataStruct) data).type, i);
        }
        return null;
    }

    @Override
    public Object visit(ASTBoolExpr node, Object data) {
        OP += node.getOps().size();
        int nChild = node.jjtGetNumChildren();
        DataStruct child0Info = goGetChildInfo(node, 0);
        ((DataStruct) data).type = child0Info.type;
        ((DataStruct) data).symbol = child0Info.symbol;
        if(nChild > 1){
            if(child0Info.type != VarType.bool){
                throwInvalidTypeInExpr();
            }
            ((DataStruct) data).type = VarType.bool;
            for (int i = 1; i < nChild; i++){
                DataStruct ds = goGetChildInfo(node,i);
                if(ds.type != null && ds.type != VarType.bool){
                    throwInvalidTypeInExpr();
                }
            }
        }
        return null;
    }

    /*
    opérateur unaire
    les opérateur unaire ont toujours un seul enfant.

    Cependant, ASTNotExpr et ASTUnaExpr ont la fonction "getOps()" qui retourne un vecteur contenant l'image (représentation str)
    de chaque token associé au noeud.

    Il est utile de vérifier la longueur de ce vecteur pour savoir si une opérande est présente.

    si il n'y a pas d'opérande, ne rien faire.
    si il y a une (ou plus) opérande, ils faut vérifier le type.

    */
    @Override
    public Object visit(ASTNotExpr node, Object data) {
        OP += node.getOps().size();
        DataStruct child0Info = goGetChildInfo(node, 0);
        if(node.getOps().size() > 0 && child0Info.type != VarType.bool){
            throwInvalidTypeInExpr();
        }
        ((DataStruct) data).type = child0Info.type;
        ((DataStruct) data).symbol = child0Info.symbol;
        return null;
    }

    @Override
    public Object visit(ASTUnaExpr node, Object data) {
        OP += node.getOps().size();
        DataStruct child0Info = goGetChildInfo(node, 0);
        if(node.getOps().size() > 0 && child0Info.type == VarType.bool){
            throwInvalidTypeInExpr();
        }
        ((DataStruct) data).type = child0Info.type;
        ((DataStruct) data).symbol = child0Info.symbol;
        return null;
    }

    /*
    les noeud ASTIdentifier aillant comme parent "GenValue" doivent vérifier leur type et vérifier leur existence.

    Ont peut envoyé une information a un enfant avec le 2e paramètre de jjtAccept ou childrenAccept.
     */
    @Override
    public Object visit(ASTGenValue node, Object data) {
        node.childrenAccept(this, data);
        return null;
    }


    @Override
    public Object visit(ASTBoolValue node, Object data) {
        if(data!=null && data instanceof DataStruct) ((DataStruct) data).type= VarType.bool;
        node.childrenAccept(this, data);
        return null;
    }

    @Override
    public Object visit(ASTIdentifier node, Object data) {
        if(data!=null && data instanceof DataStruct){
            ((DataStruct) data).symbol = node.getValue();
            checkInvalidUseIdentifier( ((DataStruct) data).symbol);
            ((DataStruct) data).type = symbolTable.get(((DataStruct) data).symbol);
        }
        node.childrenAccept(this, data);
        return null;
    }

    @Override
    public Object visit(ASTIntValue node, Object data) {
        if(data!=null && data instanceof DataStruct) ((DataStruct) data).type= VarType.num;
        node.childrenAccept(this, data);
        return null;
    }

    @Override
    public Object visit(ASTRealValue node, Object data) {
        if(data!=null && data instanceof DataStruct) ((DataStruct) data).type= VarType.real;
        node.childrenAccept(this, data);
        return null;
    }

    //des outils pour vous simplifier la vie et vous enligner dans le travail
    public enum VarType {
        bool,
        num,
        real,
        listnum,
        listbool,
        listreal
    }

    private class DataStruct {
        public VarType type;
        public String symbol;

        public DataStruct() {
        }

        public DataStruct(VarType p_type) {
            type = p_type;
        }
    }

    private void checkInvalidUseIdentifier(String varName){
        if(!symbolTable.containsKey(varName))
            throw new SemantiqueError("Invalid use of undefined Identifier "+varName);
    }

    private void checkInvalidDeclaration(String varName){
        if(symbolTable.containsKey(varName))
            throw new SemantiqueError("Invalid declaration... variable "+varName+" already exists");
    }

    private void checkInvalidTypeAssignment(String varNameFromChild1, DataStruct dsFromChild2){
        if (dsFromChild2.type != symbolTable.get(varNameFromChild1))
            throw new SemantiqueError("Invalid type in assignation of Identifier "+varNameFromChild1+"... was expecting "+symbolTable.get(varNameFromChild1).toString()+" but got "+dsFromChild2.type.toString());
    }

    private void checkCondition(Node node, Object data, int index){ //todo enlever "data" si on s'en sert pas?
        DataStruct ds = goGetChildInfo(node,index);
        if((ds.type != null && ds.type != VarType.bool) || (ds.symbol != null && symbolTable.get(ds.symbol) != VarType.bool))
            throw new SemantiqueError("Invalid type in condition");
    }

    private DataStruct goGetChildInfo(Node node,int index){
        Node expr = node.jjtGetChild(index);
        DataStruct ds = new DataStruct();
        expr.jjtAccept(this,ds);
        return ds;
    }

    private void checkIfArrayType(String listVarName){
        VarType listType = symbolTable.get(listVarName);
        if(listType != VarType.listreal && listType != VarType.listnum && listType != VarType.listbool)
            throw new SemantiqueError("Array type is required here...");
    }

    private void checkInvalidArrayAssignement(String itemVarName, String listVarName){
        VarType itemType = symbolTable.get(itemVarName);
        VarType listType = symbolTable.get(listVarName);
        boolean isInvalid = false;
        switch (itemType){
            case num:
                if (listType != VarType.listnum) isInvalid =true;
                break;
            case bool:
                if (listType != VarType.listbool) isInvalid =true;
                break;
            case real:
                if (listType != VarType.listreal) isInvalid =true;
                break;
        }
        if(isInvalid)
            throw new SemantiqueError("Array type "+listType.toString()+" is incompatible with declared variable of type "+itemType.toString()+"...");
    }

    private void checkInvalidMathTypes(Node node, VarType type, int index){
        DataStruct ds = goGetChildInfo(node,index);
        if((ds.type != null) && (ds.type == VarType.bool || ds.type != type)){
            throwInvalidTypeInExpr();
        }
    }

    private void throwInvalidTypeInExpr(){
        throw new SemantiqueError("Invalid type in expression");
    }
}
