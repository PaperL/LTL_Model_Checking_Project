import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.LTLFormulaLexer;
import parser.LTLFormulaParser;

public class TestParser {
    public static void main(String[] args) throws Exception {
        var lexer = new LTLFormulaLexer(CharStreams.fromString("G(a \\/ b)"));
        var tokens = new CommonTokenStream(lexer);
        var parser = new LTLFormulaParser(tokens);
        ParseTree tree = parser.formula();
        System.out.println(tree.toStringTree(parser));
    }
}
