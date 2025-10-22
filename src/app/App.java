package app;

import Operations.*;
import domain.Games;
import enums.TipoOperacao;
import repo.Repository;

import java.io.IOException;
import java.util.*;


public class App {
    public static final String RESET = "\u001B[0m";
    public static final String BRIGHT_RED = "\u001B[31;1m";
    public static final String BRIGHT_GREEN = "\u001B[32;1m";
    public static final String BRIGHT_MAGENTA = "\u001B[35;1m";
    public static final String BRIGHT_CYAN = "\u001B[36;1m";


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        TipoOperacao op;

        do {
            System.out.println(BRIGHT_CYAN + "=== MENU ===" + RESET);
            for (TipoOperacao t : TipoOperacao.values()) {
                System.out.println(BRIGHT_MAGENTA + t.getCod() + " - " + t.getDesc() + RESET);
            }

            System.out.print(BRIGHT_GREEN + "Chose one of those: " + RESET);
            int cod = sc.nextInt();
            sc.nextLine();
            op = TipoOperacao.MatchOperations(cod);

            if (op == null) {
                System.out.println(BRIGHT_RED + "INVALID OPTION!" + RESET);
                continue;
            }

            OperarArquivo operacao = switch (op) {
                case WRITE_TXT -> new GravarTXT();
                case WRITE_CSV -> new GravarCSV();
                case WRITE_FIX_TEXT -> new WriteFixedTXT();
                case WRITE_BIN -> new Serialize();
                case COPY_FILE -> new CopiarArquivo();
                case SPECIAL_FEATURE ->  new SpecialFeature();
                default -> null;
            };

            if (operacao != null) {
                operacao.executar();
            }

        } while (op != TipoOperacao.EXIT);

        System.out.println(BRIGHT_CYAN + "Exiting the program have a wonderful day" + RESET);
    }



}