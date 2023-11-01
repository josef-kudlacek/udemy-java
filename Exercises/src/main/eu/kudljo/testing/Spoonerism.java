package eu.kudljo.testing;

import org.junit.platform.commons.util.StringUtils;

public class Spoonerism {

    private final String[] clusterArray = {"cr", "bl", "fl", "pl", "tr", "sn"};

    public String create(String wordsToSpoonerism) {
        if (StringUtils.isBlank(wordsToSpoonerism)) {
            throw new RuntimeException("Input for spoonerism cannot be empty or null!");
        }
        String[] words = wordsToSpoonerism.toLowerCase().split(" ");
        if (words.length != 2) {
            throw new RuntimeException("Wrong count of words for spoonerism. Count of words was: " + words.length);
        }

        String firstCluster = Character.toString(words[0].charAt(0));
        String secondCluster = Character.toString(words[1].charAt(0));
        for (int wordsIndex = 0; wordsIndex < words.length; wordsIndex++) {
            for (String cluster : clusterArray) {
                if (words[wordsIndex].startsWith(cluster)) {
                    if (wordsIndex == 0) {
                        firstCluster = cluster;
                    } else {
                        secondCluster = cluster;
                    }

                    break;
                }
            }
        }

        String firstWord = words[0].replaceFirst(firstCluster, secondCluster);
        String secondWord = words[1].replaceFirst(secondCluster, firstCluster);

        return new StringBuilder()
                .append(firstWord.substring(0, 1).toUpperCase())
                .append(firstWord.substring(1))
                .append(" ")
                .append(secondWord)
                .toString();
    }
}
