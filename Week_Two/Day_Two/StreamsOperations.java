package Week_Two.Day_Two;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsOperations {

    public static void main(String[] args) {
        // System.out.println(c1.getAge());

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(10);
        integerArrayList.add(20);
        integerArrayList.add(30);

        Stream<Integer> integerStream = integerArrayList.stream();
        System.out.println(integerStream);

        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(100);
        System.out.println(streamGenerated.toList().size());

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
        System.out.println(streamIterated.toList());

        IntStream intStream = IntStream.range(1, 3);
        intStream.forEach(System.out::println);

        // java.util.Stream contains classes for processing sequence of elements
        // central API for Stream<T>

        String[] arr = new String[] { "a", "b", "c" };
        Stream<String> stream = Arrays.stream(arr);
        System.out.println(stream);
        stream = Stream.of("a", "b", "c");
        System.out.println(stream);
        stream.forEach(System.out::println);

        List<String> stringList = new ArrayList<>();
        stringList.add("ooa");
        // stringList.add("Hitarth");
        // stringList.add("Hi");
        stringList.add("aa");
        boolean isExist = stringList.stream().noneMatch(e -> e.contains("a"));
        //System.out.println(isExist);

        Stream<String> filteredStream=stringList.stream(). 
                                    filter(e -> e.contains("a"));
        filteredStream.forEach(System.out::println);

        List<Integer> alist=Arrays.asList(1,2,3,4,5,6);
        Integer reduced=alist.stream().reduce(0, (a,b) -> a+b);
        System.out.println(reduced);
       
        // creating a stream using collections
        List<String> list=Arrays.asList("String","Hello","WOrld");
        Stream<String> st1=list.stream();
        st1.forEach(System.out::println);

        // from an array
        String[] arrStr={"a","b","c"};
        Stream<String> st2=Arrays.stream(arrStr);
        st2.forEach(System.out::println);


        List<Integer> intListArray=Arrays.asList(10,20,30,40,50);
        intListArray.stream()
                    .filter(n-> n>15)
                    .map(n->n*-2)
                    .distinct()
        //            .sorted()
                    .forEach(System.out::println);
        
        List<Integer> parralelList=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        parralelList.parallelStream().forEach(n -> System.out.println(n+" "+Thread.currentThread().getName()));
        
    }
}
