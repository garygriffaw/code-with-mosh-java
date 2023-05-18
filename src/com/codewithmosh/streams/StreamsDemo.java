package com.garygriffaw.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void show() {
        List<Movie> movies = List.of(
            new Movie("a", 10),
            new Movie("b", 15),
            new Movie("c", 20)
        );

        // Imperative programming
        int count = 0;
        for (Movie movie : movies) {
            if (movie.getLikes() > 10)
                count++;
        }
        System.out.println(count);

        // Declarative (Functional) programming
        var count2 = movies.stream()
              .filter(movie -> movie.getLikes() > 10)
              .count();
        System.out.println(count2);


        Stream.iterate(1, n -> n + 2)
                .limit(10)
                .forEach(n -> System.out.println(n));
    }
}
