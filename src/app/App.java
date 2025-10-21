package app;

import Operations.*;
import domain.Games;
import enums.TipoOperacao;
import repo.Repository;

import java.io.IOException;
import java.util.*;


public class App {
    public static final String RESET = "\u001B[0m";
    public static final String BRIGHT_BLACK = "\u001B[30;1m";
    public static final String BRIGHT_RED = "\u001B[31;1m";
    public static final String BRIGHT_GREEN = "\u001B[32;1m";
    public static final String BRIGHT_YELLOW = "\u001B[33;1m";
    public static final String BRIGHT_BLUE = "\u001B[34;1m";
    public static final String BRIGHT_MAGENTA = "\u001B[35;1m";
    public static final String BRIGHT_CYAN = "\u001B[36;1m";
    public static final String BRIGHT_WHITE = "\u001B[37;1m";

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

            if (op == TipoOperacao.SPECIAL_FEATURE){
                Repository.serialize(List.of(
                        new Games("Metal Gear Solid 2", 54.31),
                        new Games("Half Life 2", 13.1),
                        new Games("Portal 1", 24.31),
                        new Games("Portal 2", 24.31),
                        new Games("Rain World", 156.31),
                        new Games("Hades 2", 66.66),
                        new Games("Cyberpunk 2077", 91.17)
                ));


                System.out.println(BRIGHT_MAGENTA + "=====ALL GAMES======" + RESET);
                System.out.println(BRIGHT_CYAN +"=====Order by Name======" + RESET);


                Stack<Object> stack = new Stack<>();


                List<?> listOrByName = Repository.deserialize().stream()
                        .map(obj -> (Games) obj)
                        .sorted(Comparator.comparing(Games::getName))
                        .toList();

                for (Object o : listOrByName) {
                    if (o instanceof Games games){
                        System.out.println(games.getId() + " - " + games.getName() + " - R$" + games.getValue());
                    }
                }



                List<Games> listOrByValue = listOrByName.stream()
                        .map(obj -> (Games) obj)
                        .sorted(Comparator.comparing(Games::getValue))
                        .toList();

                for (Games games : listOrByValue) {
                    stack.push(games);
                }


                System.out.println("--------------------------------------");


                System.out.println(BRIGHT_GREEN +"Press any key to see the price rank: " + RESET);
                String next = sc.nextLine();

                for (Object o : stack.reversed()) {
                    if (o instanceof Games games){
                        System.out.println(BRIGHT_MAGENTA + games.getId() + " - " + games.getName() + " - R$" + games.getValue() + RESET );
                    }
                }


                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }


            OperarArquivo operacao = switch (op) {
                case WRITE_TXT -> new GravarTXT();
                case WRITE_CSV -> new GravarCSV();
                case WRITE_FIX_TEXT -> new WriteFixedTXT();
                case WRITE_BIN -> new Serialize();
                case COPY_FILE -> new CopiarArquivo();
                default -> null;
            };

            if (operacao != null) {
                operacao.executar();
            }

        } while (op != TipoOperacao.EXIT);

        System.out.println(BRIGHT_CYAN + "Exiting the program have a wonderful day" + RESET);

    }


}