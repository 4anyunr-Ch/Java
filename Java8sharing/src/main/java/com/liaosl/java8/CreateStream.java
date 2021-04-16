package com.liaosl.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *@description
 *@author  forest
 *@date  23:09 2018/9/3 0003
 **/

public class CreateStream {

    public static void main(String[] args) {
//        createStreamFromCollection().forEach(System.out::println);
//        createStreamFromValues().forEach(System.out::println);
//        createStreamFromArrays().forEach(System.out::println);
//        Stream<String> streamFromFile = createStreamFromFile();
//        System.out.println(streamFromFile);
//        createStreamFromIterator().forEach(System.out::println);
//        Stream<Double> streamFromGenerate = createStreamFromGenerate();
//        streamFromGenerate.forEach(System.out::println);
        Stream<Obj> objStreamFromGenenrate = createObjStreamFromGenenrate();
        objStreamFromGenenrate.forEach(System.out::println);
    }

    private static Stream<String> createStreamFromCollection(){
        List<String> list = Arrays.asList("hello", "alex", "forest", "world");
        return list.stream();
    }

    private static Stream<String> createStreamFromValues(){
        return Stream.of("hello", "alex", "forest", "world");
    }

    private static Stream<String> createStreamFromArrays(){
        return Arrays.stream(new String[]{"hello", "alex", "forest", "world"});
    }

    private static Stream<String> createStreamFromFile(){
        Path path = Paths.get("E:\\idea-workspace\\Java8\\Java8sharing\\src\\main\\java\\com\\liaosl\\java8\\Apple.java");
        try(Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stream<Integer> createStreamFromIterator(){
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2).limit(10);
        return iterate;
    }

    private static Stream<Double> createStreamFromGenerate(){
        return Stream.generate(Math::random).limit(10);
    }

    private static Stream<Obj> createObjStreamFromGenenrate(){
        return Stream.generate(new ObjSuppplier()).limit(10);
    }

    static class ObjSuppplier implements Supplier<Obj>{
        private int index = 0;
        private Random random = new Random(System.currentTimeMillis());

        @Override
        public Obj get() {
            index = random.nextInt(100);
            return new Obj(index,"Name->" + index);
        }
    }


    static class Obj{
        private int id;
        private String name;

        public Obj(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
