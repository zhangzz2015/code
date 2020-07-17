import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.apple.concurrent.Dispatch.Priority;

public class TopKSimilarSongsWithAtMostMLevelDiff {
    static class Song {
        int id;
        int rating;
        List<Song> similarSongs;
        Song(int id, int rating, List<Song> similarSongs) {
            this.id = id;
            this.rating = rating;
            this.similarSongs = similarSongs;
        }
    }

    public List<Song> topKSimilarSongsWithAtMostMLevelDiff(Song song, int k, int mLevel) {
        PriorityQueue minHeapSongs = new PriorityQueue<>((a, b) -> Integer.compare(a.rating, b.rating));
        Queue<Song> songs = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        songs.offer(song);
        visited.add(song.id);
        while (!songs.isEmpty() && mLevel-- > 0) {
            int curSize = songs.size();
            for (int i = 0; i < curSize; i++) {
                Song curSong = songs.poll();
                List<Song> similarSongs = curSong.similarSongs;
                for (Song s : similarSongs) {
                    if (!visited.add(s.id)) {
                        continue;
                    }
                    if (minHeapSongs.size() < k) {
                        minHeapSongs.offer(s);
                    } else if (minHeapSongs.peek().ratins < s.rating) {
                        minHeapSongs.poll();
                        minHeapSongs.offer(s);
                    }
                    songs.offer(s);
                }
            }
        }
        List<Song> topK = new ArrayList<>();
        while (!minHeapSongs.isEmpty()) {
            topK.add(minHeapSongs.poll());
        }
        return topK;
    }
}