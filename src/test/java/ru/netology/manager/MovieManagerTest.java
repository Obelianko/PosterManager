package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MoviePoster;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    private MoviePoster movie1 = new MoviePoster(1, "Ходячие мертвецы", "ужасы");
    private MoviePoster movie2 = new MoviePoster(2, "Рик и Морти", "мультфильм");
    private MoviePoster movie3 = new MoviePoster(3, "Засланец из космоса", "фантастика");
    private MoviePoster movie4 = new MoviePoster(4, "Пищеблок", "триллер");
    private MoviePoster movie5 = new MoviePoster(5, "Майор Гром: Чумной Доктор", "приключения");
    private MoviePoster movie6 = new MoviePoster(6, "Блудный сын", "триллер");
    private MoviePoster movie7 = new MoviePoster(7, "Душа", "мультфильм");
    private MoviePoster movie8 = new MoviePoster(8, "Рыцари справедливости", "боевик");
    private MoviePoster movie9 = new MoviePoster(9, "Гнев человеческий", "боевик");
    private MoviePoster movie10 = new MoviePoster(10, "Я не шучу", "комедия");

    @BeforeEach
    public void setUp() {
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);
        manager.add(movie8);
        manager.add(movie9);
        manager.add(movie10);
    }

    @Test
    public void addMovie() {
        MovieManager manager = new MovieManager();
        manager.add(movie4);

        MoviePoster[] actual = manager.getLast();
        MoviePoster[] expected = new MoviePoster[]{movie4};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addIfFive() {
        MovieManager manager = new MovieManager();
        manager.add(movie5);
        manager.add(movie2);

        MoviePoster[] actual = manager.getLast();
        MoviePoster[] expected = new MoviePoster[]{movie2, movie5, movie6, movie4, movie3, movie1, movie8};

    }

    @Test
    public void addFive() {
        MovieManager manager = new MovieManager();

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie5);
        manager.add(movie8);

        MoviePoster[] actual = manager.getLast();
        MoviePoster[] expected = new MoviePoster[]{movie8, movie5, movie3, movie2, movie1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLast10() {
        MovieManager manager = new MovieManager();

        manager.add(movie1);
        manager.add(movie3);
        manager.add(movie2);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie8);
        manager.add(movie7);
        manager.add(movie9);
        manager.add(movie10);

        MoviePoster[] actual = manager.getLast();
        MoviePoster[] expected = new MoviePoster[]{movie10, movie9, movie7, movie8, movie6, movie5, movie4, movie2, movie3, movie1};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void getLast5() {
        MovieManager manager = new MovieManager(5);

        manager.add(movie1);
        manager.add(movie3);
        manager.add(movie2);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie8);
        manager.add(movie7);
        manager.add(movie9);
        manager.add(movie10);

        MoviePoster[] actual = manager.getLast();
        MoviePoster[] expected = new MoviePoster[]{movie10, movie9, movie7, movie8, movie6};

        assertArrayEquals(expected, actual);
    }

    }

