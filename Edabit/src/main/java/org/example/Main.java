package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(Hard.BookChapter.nearestChapter(new Hard.Chapter[] {
                new Hard.Chapter("New Beginnings", 1),
                new Hard.Chapter("Strange Developments", 62),
                new Hard.Chapter("The End?", 194),
                new Hard.Chapter("The True Ending", 460)
                }, 200));
    }
}
