package Operations;

import domain.Games;
import enums.TipoOperacao;
import repo.Repository;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;



public class SpecialFeature implements OperarArquivo{
    public static final String RESET = "\u001B[0m";

    public static final String BRIGHT_GREEN = "\u001B[32;1m";
    public static final String BRIGHT_MAGENTA = "\u001B[35;1m";
    public static final String BRIGHT_CYAN = "\u001B[36;1m";

    @Override
    public void executar() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

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
        System.out.println(BRIGHT_CYAN + "=====Order by Name======" + RESET);


        Stack<Object> stack = new Stack<>();


        List<?> listOrByName = Repository.deserialize().stream()
                .map(obj -> (Games) obj)
                .sorted(Comparator.comparing(Games::getName))
                .toList();

        for (Object o : listOrByName) {
            if (o instanceof Games games) {
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


        System.out.println(BRIGHT_GREEN + "Press any key to see the price rank: " + RESET);
        sc.nextLine();

        for (Object o : stack.reversed()) {
            if (o instanceof Games games) {
                System.out.println(BRIGHT_CYAN + games.getId() + " - " + games.getName() + " - R$" + games.getValue() + RESET);
            }
        }


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
