package org.example;
import java.util.Objects;

public class FriendFetcher {
    public String[] getFriendNames(String facebookPageLink) {

        //See if link is valid
        if (Objects.equals(facebookPageLink, "https://www.facebook.com/examplePage")){
            return new String[]{"Friend1", "Friend2", "Friend3"};
        }else return null;

    }
}