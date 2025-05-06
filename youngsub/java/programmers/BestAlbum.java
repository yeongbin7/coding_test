import java.util.*;

public class BestAlbum {
    static class Song {
        int id;
        String genre;
        int playCount;

        public Song(int id, String genre, int playCount) {
            this.id = id;
            this.genre = genre;
            this.playCount = playCount;
        }
    }

    static class Genre {
        String genre;
        int playCount;

        public Genre(String genre, int playCount) {
            this.genre = genre;
            this.playCount = playCount;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playCountByGenre = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            playCountByGenre.put(genres[i], playCountByGenre.getOrDefault(genres[i], 0) + plays[i]);
            if (songsByGenre.get(genres[i]) == null) {
                songsByGenre.put(genres[i], new ArrayList<>());
            }
            songsByGenre.get(genres[i]).add(new Song(i, genres[i], plays[i]));
        }

        for (String key : songsByGenre.keySet()) {
            songsByGenre.get(key).sort((s1, s2) -> {
                return Integer.compare(s2.playCount, s1.playCount);
            });
        }

        List<Genre> genreList = new ArrayList<>();
        for (String key : playCountByGenre.keySet()) {
            genreList.add(new Genre(key, playCountByGenre.get(key)));
        }
        genreList.sort((o1, o2) -> {
            return Integer.compare(o2.playCount, o1.playCount);
        });

        List<Integer> result = new ArrayList<>();

        for (Genre genre: genreList) {
            String name = genre.genre;
            if (songsByGenre.get(name).size() == 1) {
                result.add(songsByGenre.get(name).get(0).id);
            } else {
                result.add(songsByGenre.get(name).get(0).id);
                result.add(songsByGenre.get(name).get(1).id);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}