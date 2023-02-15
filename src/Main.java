import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> integerListD = Arrays.asList();

 // ------Задание 2-------
        List<Integer> integerListC = integerList.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(integerListC);
        System.out.println("Всего " + integerListC.size() + " четных числа в листе");


//------Задание 1---
        System.out.println("Вариант 1");
        findMinMax1(integerList.stream(),integerList.stream(),Integer::compareTo, (min, max) -> System.out.println("MIN: " +min.get() +"\n"+"MAX: "+ max.get()));
        System.out.println("Вариант 2");
        findMinMax(integerList.stream(),Integer::compareTo, (min, max) -> System.out.println("MIN: " + min +"\n"+"MAX: "+ max));

    }
    public static void findMinMax1(
            Stream<Integer> stream,
            Stream<Integer> stream2,
            Comparator<Integer> order,
            BiConsumer<Optional<Integer>, Optional<Integer>> minMaxConsumer) {


        Optional<Integer> min =  stream.min(order);
        Optional<Integer> max = stream2.max(order);

        minMaxConsumer.accept(min,max);
    }
    public static <S> void findMinMax(
            Stream<? extends S> stream,
            Comparator<? super S> order,
            BiConsumer<? super S, ? super S> minMaxConsumer) {
        List<S> arrayList = new ArrayList<>();
        S minS = null;
        S maxS = null;
        arrayList = stream.sorted(order).collect(Collectors.toList());
        if (arrayList.size() != 0) {
            maxS = arrayList.get(arrayList.size() - 1);
            minS = arrayList.get(0);

        }
        minMaxConsumer.accept(minS, maxS);
    }

}