package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Shuang Li", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("aaasami", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-11", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Jonah So"),"Team should contain Jonah So");
        assertTrue(t.getMembers().contains("Luis Mendoza"),"Team should contain Luis Mendoza");
        assertTrue(t.getMembers().contains("Sayk Diaz"),"Team should contain Sayk Diaz");
        assertTrue(t.getMembers().contains("Shuang Li"),"Team should contain Shuang Li");
        assertTrue(t.getMembers().contains("Tristan Rocha"),"Team should contain Tristan Rocha");
        assertTrue(t.getMembers().contains("Wendy Song"),"Team should contain Wendy Song");
    }

}


