grammar LTLFormula;
@header{ package parser;}

formula
    : '(' formula ')'                       # Parentheses
    | Atomic                                # Atomic_Proposition
    | logicConstant                         # Constant
    | lFormula = formula op = (AndOp | OrOp)    rFormula = formula  # And_Or_Formula
    | lFormula = formula '->'                   rFormula = formula  # Implication_Formula
    | lFormula = formula 'U'                    rFormula = formula  # U_Formula
    | '!' formula                           # Not_Formula
    | 'G' formula                           # G_Formula
    | 'F' formula                           # F_Formula
    | 'X' formula                           # X_Formula
    ;

AndOp: '/\\';
OrOp : '\\/';

logicConstant: True | False;

True : 'true';
False: 'false';

Atomic: [a-z];

WHITE_SPACE: [ \t\n\r]+ -> skip;