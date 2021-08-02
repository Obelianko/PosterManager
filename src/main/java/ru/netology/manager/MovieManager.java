package ru.netology.manager;

import ru.netology.domain.MoviePoster;


public class MovieManager {
    private MoviePoster[] movies = new MoviePoster[0];
    public int moviesLimit = 10;

    public MovieManager(int moviesLimit) {
        this.moviesLimit = moviesLimit;
    }

    public MovieManager() {
    }

    public void add(MoviePoster movie) {
        // создаём новый массив размером на единицу больше
        int length = movies.length + 1;
        MoviePoster[] tmp = new MoviePoster[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MoviePoster[] getLast() {
        int length;
        if (movies.length > moviesLimit) {
            length = moviesLimit;
        } else {
            length = movies.length;
        }
        MoviePoster[] result = new MoviePoster[length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < length; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}
