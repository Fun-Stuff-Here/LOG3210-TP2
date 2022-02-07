/* Parser.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. Parser.java */
package analyzer.ast;

public class Parser/*@bgen(jjtree)*/implements ParserTreeConstants, ParserConstants {/*@bgen(jjtree)*/
  protected JJTParserState jjtree = new JJTParserState();public static ASTProgram ParseTree(java.io.InputStream input) throws ParseException
        {
                Parser c = new Parser(input);
                return c.Program();
        }

//
// SYNTAX ANALYSIS
//
  final public 
ASTProgram Program() throws ParseException {/*@bgen(jjtree) Program */
  ASTProgram jjtn000 = new ASTProgram(JJTPROGRAM);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case DEC:{
        jj_consume_token(DEC);
        label_1:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case TYPE:
          case ARRAYTYPE:{
            ;
            break;
            }
          default:
            jj_la1[0] = jj_gen;
            break label_1;
          }
          Declaration();
          jj_consume_token(SEMICOLON);
        }
        jj_consume_token(ENDDEC);
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        ;
      }
      Block();
      jj_consume_token(0);
jjtree.closeNodeScope(jjtn000, true);
                        jjtc000 = false;
{if ("" != null) return jjtn000;}
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
}

  final public void Declaration() throws ParseException {/*@bgen(jjtree) Declaration */
                      ASTDeclaration jjtn000 = new ASTDeclaration(JJTDECLARATION);
                      boolean jjtc000 = true;
                      jjtree.openNodeScope(jjtn000);Token t;
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TYPE:{
        NormalDeclaration();
        break;
        }
      case ARRAYTYPE:{
        ListDeclaration();
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void NormalDeclaration() throws ParseException {/*@bgen(jjtree) NormalDeclaration */
                            ASTNormalDeclaration jjtn000 = new ASTNormalDeclaration(JJTNORMALDECLARATION);
                            boolean jjtc000 = true;
                            jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(TYPE);
jjtn000.setValue(t.image);
      Identifier();
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void ListDeclaration() throws ParseException {/*@bgen(jjtree) ListDeclaration */
                          ASTListDeclaration jjtn000 = new ASTListDeclaration(JJTLISTDECLARATION);
                          boolean jjtc000 = true;
                          jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(ARRAYTYPE);
jjtn000.setValue(t.image);
      jj_consume_token(LSBRAC);
      jj_consume_token(RSBRAC);
      Identifier();
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void Block() throws ParseException {/*@bgen(jjtree) Block */
  ASTBlock jjtn000 = new ASTBlock(JJTBLOCK);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case WHILE:
        case FOR:
        case FOREACH:
        case SEMICOLON:
        case IDENTIFIER:{
          ;
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          break label_2;
        }
        Stmt();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
             jjtree.clearNodeScope(jjtn000);
             jjtc000 = false;
           } else {
             jjtree.popNode();
           }
           if (jjte000 instanceof RuntimeException) {
             {if (true) throw (RuntimeException)jjte000;}
           }
           if (jjte000 instanceof ParseException) {
             {if (true) throw (ParseException)jjte000;}
           }
           {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
             jjtree.closeNodeScope(jjtn000, true);
           }
    }
}

  final public void Stmt() throws ParseException {/*@bgen(jjtree) Stmt */
  ASTStmt jjtn000 = new ASTStmt(JJTSTMT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IDENTIFIER:{
        AssignStmt();
        jj_consume_token(SEMICOLON);
        break;
        }
      case IF:{
        IfStmt();
        break;
        }
      case WHILE:{
        WhileStmt();
        break;
        }
      case FOR:{
        ForStmt();
        break;
        }
      case FOREACH:{
        ForEachStmt();
        break;
        }
      case SEMICOLON:{
        jj_consume_token(SEMICOLON);
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  final public void ForStmt() throws ParseException {/*@bgen(jjtree) ForStmt */
  ASTForStmt jjtn000 = new ASTForStmt(JJTFORSTMT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(FOR);
      jj_consume_token(LPAREN);
      AssignStmt();
      jj_consume_token(SEMICOLON);
      Expr();
      jj_consume_token(SEMICOLON);
      AssignStmt();
      jj_consume_token(RPAREN);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LACC:{
        jj_consume_token(LACC);
        Block();
        jj_consume_token(RACC);
        break;
        }
      case IF:
      case WHILE:
      case FOR:
      case FOREACH:
      case SEMICOLON:
      case IDENTIFIER:{
        Stmt();
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void ForEachStmt() throws ParseException {/*@bgen(jjtree) ForEachStmt */
  ASTForEachStmt jjtn000 = new ASTForEachStmt(JJTFOREACHSTMT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(FOREACH);
      jj_consume_token(LPAREN);
      NormalDeclaration();
      jj_consume_token(COLON);
      Identifier();
      jj_consume_token(RPAREN);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case WHILE:
      case FOR:
      case FOREACH:
      case SEMICOLON:
      case IDENTIFIER:{
        Stmt();
        break;
        }
      case LACC:{
        jj_consume_token(LACC);
        Block();
        jj_consume_token(RACC);
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
         jjtree.clearNodeScope(jjtn000);
         jjtc000 = false;
       } else {
         jjtree.popNode();
       }
       if (jjte000 instanceof RuntimeException) {
         {if (true) throw (RuntimeException)jjte000;}
       }
       if (jjte000 instanceof ParseException) {
         {if (true) throw (ParseException)jjte000;}
       }
       {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
         jjtree.closeNodeScope(jjtn000, true);
       }
    }
}

  final public void IfStmt() throws ParseException {/*@bgen(jjtree) IfStmt */
  ASTIfStmt jjtn000 = new ASTIfStmt(JJTIFSTMT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(IF);
      jj_consume_token(LPAREN);
      Expr();
      jj_consume_token(RPAREN);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case WHILE:
      case FOR:
      case FOREACH:
      case SEMICOLON:
      case IDENTIFIER:{
        Stmt();
        break;
        }
      case LACC:{
        jj_consume_token(LACC);
        Block();
        jj_consume_token(RACC);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case ELSE:{
          jj_consume_token(ELSE);
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case IF:
          case WHILE:
          case FOR:
          case FOREACH:
          case SEMICOLON:
          case IDENTIFIER:{
            Stmt();
            break;
            }
          case LACC:{
            jj_consume_token(LACC);
            Block();
            jj_consume_token(RACC);
            break;
            }
          default:
            jj_la1[7] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          break;
          }
        default:
          jj_la1[8] = jj_gen;
          ;
        }
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
         jjtree.clearNodeScope(jjtn000);
         jjtc000 = false;
       } else {
         jjtree.popNode();
       }
       if (jjte000 instanceof RuntimeException) {
         {if (true) throw (RuntimeException)jjte000;}
       }
       if (jjte000 instanceof ParseException) {
         {if (true) throw (ParseException)jjte000;}
       }
       {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
         jjtree.closeNodeScope(jjtn000, true);
       }
    }
}

  final public void WhileStmt() throws ParseException {/*@bgen(jjtree) WhileStmt */
  ASTWhileStmt jjtn000 = new ASTWhileStmt(JJTWHILESTMT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(WHILE);
      jj_consume_token(LPAREN);
      Expr();
      jj_consume_token(RPAREN);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:
      case WHILE:
      case FOR:
      case FOREACH:
      case SEMICOLON:
      case IDENTIFIER:{
        Stmt();
        break;
        }
      case LACC:{
        jj_consume_token(LACC);
        Block();
        jj_consume_token(RACC);
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
         jjtree.clearNodeScope(jjtn000);
         jjtc000 = false;
       } else {
         jjtree.popNode();
       }
       if (jjte000 instanceof RuntimeException) {
         {if (true) throw (RuntimeException)jjte000;}
       }
       if (jjte000 instanceof ParseException) {
         {if (true) throw (ParseException)jjte000;}
       }
       {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
         jjtree.closeNodeScope(jjtn000, true);
       }
    }
}

  final public void AssignStmt() throws ParseException {/*@bgen(jjtree) AssignStmt */
  ASTAssignStmt jjtn000 = new ASTAssignStmt(JJTASSIGNSTMT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Identifier();
      jj_consume_token(ASSIGN);
      Expr();
    } catch (Throwable jjte000) {
if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  final public void Expr() throws ParseException {/*@bgen(jjtree) Expr */
               ASTExpr jjtn000 = new ASTExpr(JJTEXPR);
               boolean jjtc000 = true;
               jjtree.openNodeScope(jjtn000);Token t;
    try {
      BoolExpr();
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void BoolExpr() throws ParseException {/*@bgen(jjtree) BoolExpr */
                   ASTBoolExpr jjtn000 = new ASTBoolExpr(JJTBOOLEXPR);
                   boolean jjtc000 = true;
                   jjtree.openNodeScope(jjtn000);Token t;
    try {
      CompExpr();
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case BOOLOP:{
          ;
          break;
          }
        default:
          jj_la1[11] = jj_gen;
          break label_3;
        }
        t = jj_consume_token(BOOLOP);
jjtn000.addOp(t.image);
        CompExpr();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void CompExpr() throws ParseException {/*@bgen(jjtree) CompExpr */
                   ASTCompExpr jjtn000 = new ASTCompExpr(JJTCOMPEXPR);
                   boolean jjtc000 = true;
                   jjtree.openNodeScope(jjtn000);Token t;
    try {
      AddExpr();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMPARE:{
        t = jj_consume_token(COMPARE);
        AddExpr();
jjtn000.setValue(t.image);
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void AddExpr() throws ParseException {/*@bgen(jjtree) AddExpr */
                   ASTAddExpr jjtn000 = new ASTAddExpr(JJTADDEXPR);
                   boolean jjtc000 = true;
                   jjtree.openNodeScope(jjtn000);Token t;
    try {
      MulExpr();
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case PLUS:
        case MINUS:{
          ;
          break;
          }
        default:
          jj_la1[13] = jj_gen;
          break label_4;
        }
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case PLUS:{
          t = jj_consume_token(PLUS);
          break;
          }
        case MINUS:{
          t = jj_consume_token(MINUS);
          break;
          }
        default:
          jj_la1[14] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
jjtn000.addOp(t.image);
        MulExpr();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void MulExpr() throws ParseException {/*@bgen(jjtree) MulExpr */
                   ASTMulExpr jjtn000 = new ASTMulExpr(JJTMULEXPR);
                   boolean jjtc000 = true;
                   jjtree.openNodeScope(jjtn000);Token t;
    try {
      UnaExpr();
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case MULOP:{
          ;
          break;
          }
        default:
          jj_la1[15] = jj_gen;
          break label_5;
        }
        t = jj_consume_token(MULOP);
jjtn000.addOp(t.image);
        UnaExpr();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void UnaExpr() throws ParseException {/*@bgen(jjtree) UnaExpr */
                   ASTUnaExpr jjtn000 = new ASTUnaExpr(JJTUNAEXPR);
                   boolean jjtc000 = true;
                   jjtree.openNodeScope(jjtn000);Token t;
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case MINUS:{
        t = jj_consume_token(MINUS);
jjtn000.addOp(t.image);
        break;
        }
      default:
        jj_la1[16] = jj_gen;
        ;
      }
      NotExpr();
    } catch (Throwable jjte000) {
if (jjtc000) {
         jjtree.clearNodeScope(jjtn000);
         jjtc000 = false;
       } else {
         jjtree.popNode();
       }
       if (jjte000 instanceof RuntimeException) {
         {if (true) throw (RuntimeException)jjte000;}
       }
       if (jjte000 instanceof ParseException) {
         {if (true) throw (ParseException)jjte000;}
       }
       {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
         jjtree.closeNodeScope(jjtn000, true);
       }
    }
}

  final public void NotExpr() throws ParseException {/*@bgen(jjtree) NotExpr */
                   ASTNotExpr jjtn000 = new ASTNotExpr(JJTNOTEXPR);
                   boolean jjtc000 = true;
                   jjtree.openNodeScope(jjtn000);Token t;
    try {
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case NOT:{
          ;
          break;
          }
        default:
          jj_la1[17] = jj_gen;
          break label_6;
        }
        t = jj_consume_token(NOT);
jjtn000.addOp(t.image);
      }
      GenValue();
    } catch (Throwable jjte000) {
if (jjtc000) {
         jjtree.clearNodeScope(jjtn000);
         jjtc000 = false;
       } else {
         jjtree.popNode();
       }
       if (jjte000 instanceof RuntimeException) {
         {if (true) throw (RuntimeException)jjte000;}
       }
       if (jjte000 instanceof ParseException) {
         {if (true) throw (ParseException)jjte000;}
       }
       {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
         jjtree.closeNodeScope(jjtn000, true);
       }
    }
}

  final public void GenValue() throws ParseException {/*@bgen(jjtree) GenValue */
  ASTGenValue jjtn000 = new ASTGenValue(JJTGENVALUE);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case BOOLEAN:{
        BoolValue();
        break;
        }
      case IDENTIFIER:{
        Identifier();
        break;
        }
      case INTEGER:{
        IntValue();
        break;
        }
      case REAL:{
        RealValue();
        break;
        }
      case LPAREN:{
        jj_consume_token(LPAREN);
        Expr();
        jj_consume_token(RPAREN);
        break;
        }
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void BoolValue() throws ParseException {/*@bgen(jjtree) BoolValue */
                     ASTBoolValue jjtn000 = new ASTBoolValue(JJTBOOLVALUE);
                     boolean jjtc000 = true;
                     jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(BOOLEAN);
jjtree.closeNodeScope(jjtn000, true);
                     jjtc000 = false;
jjtn000.setValue(t.image);
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  final public void Identifier() throws ParseException {/*@bgen(jjtree) Identifier */
                      ASTIdentifier jjtn000 = new ASTIdentifier(JJTIDENTIFIER);
                      boolean jjtc000 = true;
                      jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(IDENTIFIER);
jjtree.closeNodeScope(jjtn000, true);
                           jjtc000 = false;
jjtn000.setValue(t.image);
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  final public void IntValue() throws ParseException {/*@bgen(jjtree) IntValue */
                    ASTIntValue jjtn000 = new ASTIntValue(JJTINTVALUE);
                    boolean jjtc000 = true;
                    jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(INTEGER);
jjtree.closeNodeScope(jjtn000, true);
                        jjtc000 = false;
jjtn000.setValue(Integer.parseInt(t.image));
    } finally {
if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
}

  final public void RealValue() throws ParseException {/*@bgen(jjtree) RealValue */
                     ASTRealValue jjtn000 = new ASTRealValue(JJTREALVALUE);
                     boolean jjtc000 = true;
                     jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(REAL);
jjtree.closeNodeScope(jjtn000, true);
                 jjtc000 = false;
jjtn000.setValue(Double.parseDouble(t.image));
    } finally {
if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
}

  /** Generated Token Manager. */
  public ParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[19];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x1100000,0x40000,0x1100000,0x7200,0x7200,0x7200,0x7200,0x7200,0x800,0x7200,0x7200,0x80000000,0x20000000,0x0,0x0,0x40000000,0x0,0x0,0x8000,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x0,0x0,0x0,0xc00000,0xc00000,0xc20000,0xc20000,0xc20000,0x0,0xc20000,0xc20000,0x0,0x0,0x3,0x3,0x0,0x2,0x4000,0xc808000,};
	}

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new ParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
	 jj_input_stream = new JavaCharStream(stream, 1, 1);
	 token_source = new ParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new JavaCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new ParserTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jjtree.reset();
	 jj_gen = 0;
	 for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[61];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 19; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 61; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private int trace_indent = 0;
  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}