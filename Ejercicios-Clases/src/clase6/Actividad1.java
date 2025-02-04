package clase6;

import java.util.*;

public class Actividad1 {
    private Map<String, Set<String>> users;

    public Actividad1() {
        users = new HashMap<>();
    }

    public void addUser(String user) {
        users.putIfAbsent(user, new HashSet<>());
    }

    public void follow(String follower, String followed) {
        if (users.containsKey(follower) && users.containsKey(followed)) {
            users.get(followed).add(follower);
        } else {
            System.out.println("Uno o ambos usuarios no existen.");
        }
    }

    public List<String> getFollowers(String user) {
        return users.containsKey(user) ? new ArrayList<>(users.get(user)) : new ArrayList<>();
    }

    public List<String> getFollowing(String user) {
        List<String> following = new ArrayList<>();
        if (users.containsKey(user)) {
            for (Map.Entry<String, Set<String>> entry : users.entrySet()) {
                if (entry.getValue().contains(user)) {
                    following.add(entry.getKey());
                }
            }
        }
        return following;
    }

    public void displayNetwork() {
        for (Map.Entry<String, Set<String>> entry : users.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Actividad1 socialNetwork = new Actividad1();
        socialNetwork.addUser("Alice");
        socialNetwork.addUser("Bob");
        socialNetwork.addUser("Charlie");

        socialNetwork.follow("Bob", "Alice");
        socialNetwork.follow("Charlie", "Alice");
        socialNetwork.follow("Alice", "Charlie");

        System.out.println("Seguidores de Alice: " + socialNetwork.getFollowers("Alice"));
        System.out.println("Usuarios seguidos por Alice: " + socialNetwork.getFollowing("Alice"));

        socialNetwork.displayNetwork();
    }
}

