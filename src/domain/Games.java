package domain;



import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Games implements Serializable{
    private static final AtomicInteger COUNTER =
            new AtomicInteger(0);
    private int id;
    private String name;;
    private Double value;


    public Games(String name, Double value) {
        this.id = COUNTER.getAndIncrement();
        this.name = name;
        this.value = value;
    }

    @Override
    public String
    toString() {
        return "Games{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Games games = (Games) o;
        return id == games.id && value == games.value && Objects.equals(name, games.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public Double getValue() {
        return value;
    }



}
