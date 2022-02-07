/* Generated By:JavaCC: Do not edit this line. ParserVisitor.java Version 7.0.2 */
package analyzer.ast;

public interface ParserVisitor
{
  public Object visit(SimpleNode node, Object data);
  public Object visit(ASTProgram node, Object data);
  public Object visit(ASTDeclaration node, Object data);
  public Object visit(ASTNormalDeclaration node, Object data);
  public Object visit(ASTListDeclaration node, Object data);
  public Object visit(ASTBlock node, Object data);
  public Object visit(ASTStmt node, Object data);
  public Object visit(ASTForStmt node, Object data);
  public Object visit(ASTForEachStmt node, Object data);
  public Object visit(ASTIfStmt node, Object data);
  public Object visit(ASTWhileStmt node, Object data);
  public Object visit(ASTAssignStmt node, Object data);
  public Object visit(ASTExpr node, Object data);
  public Object visit(ASTBoolExpr node, Object data);
  public Object visit(ASTCompExpr node, Object data);
  public Object visit(ASTAddExpr node, Object data);
  public Object visit(ASTMulExpr node, Object data);
  public Object visit(ASTUnaExpr node, Object data);
  public Object visit(ASTNotExpr node, Object data);
  public Object visit(ASTGenValue node, Object data);
  public Object visit(ASTBoolValue node, Object data);
  public Object visit(ASTIdentifier node, Object data);
  public Object visit(ASTIntValue node, Object data);
  public Object visit(ASTRealValue node, Object data);
}
/* JavaCC - OriginalChecksum=745809e9aeb60c3469f46b1645a08f0c (do not edit this line) */
