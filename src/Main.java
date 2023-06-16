import ba.GNBA;
import ltl.FormulaBuilder;
import ltl.node.FormulaNode;
import org.antlr.v4.runtime.misc.Pair;
import ts.TS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String transitionSystemInputFile = "TS.txt";
        String benchmarkInputFile = "benchmark.txt";
        PrintStream output = System.out;
        // * Input Transition System and Formulas
        var ts = new TS(transitionSystemInputFile);
        var initFormulas = new ArrayList<FormulaNode>();
        var stateFormulas = new ArrayList<Pair<Integer, FormulaNode>>();
        parseFormulas(benchmarkInputFile, initFormulas, stateFormulas);

        // * Implement Model Checking
        for (var formula : initFormulas)
            output.println(check(ts, formula) ? 1 : 0);
        for (var pair : stateFormulas) {
            for (var i = 0; i < ts.states.size(); i++)  // Initialize
                ts.states.get(i).initial = (i == pair.a);
            output.println(check(ts, pair.b) ? 1 : 0);
        }
    }

    private static void parseFormulas(
            String inputFilePath,
            ArrayList<FormulaNode> initFormulas,
            ArrayList<Pair<Integer, FormulaNode>> stateFormulas) {
        Scanner scn = null;
        try {
            scn = new Scanner(new FileInputStream(inputFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert scn != null;

        int NA = scn.nextInt(), NB = scn.nextInt();
        scn.nextLine();
        for (var i = 0; i < NA; i++) {
            var line = scn.nextLine();
            var builder = new FormulaBuilder();
            initFormulas.add(builder.buildFormula(line));
        }
        for (var i = 0; i < NB; i++) {
            var s = scn.nextInt();
            var line = scn.nextLine();
            var builder = new FormulaBuilder();
            stateFormulas.add(new Pair<>(
                    s, builder.buildFormula(line)
            ));
        }
    }

    private static boolean check(TS ts, FormulaNode node) {
        var neg = node.negation();
        System.out.println(neg);
        var gnba = new GNBA(neg);
//        var nba = new NBA(gnba);
//        TS product = new TS(ts, nba);
//        return product.persistenceCheck();
        return true;
    }
}
