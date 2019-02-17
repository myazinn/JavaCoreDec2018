package t03;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CrazyParser {
    private static final Pattern sentencePattern
            = Pattern.compile("[А-ЯA-Z]([^.!?(]|(\\([^)]+\\)))+[.!?]");
    private static final Pattern referencePattern
            = Pattern.compile("[рР]ис((\\.)|(унк[а-я]{0,2})|(унок)) ?(?<first>\\d+)( ?[и,] ?(?<second>\\d+))?");

    private int maximalReference;

    void parsePrintLine(String line) {

        String[] sentences = parseLine(line);

        for (String sentence : sentences) {
            int[] numbers = parseSentence(sentence);
            for (int number : numbers) {
                setMaximalReference(number);
            }
            if (numbers.length > 0) {
                System.out.println(sentence);
            }
        }
    }


    String[] parseLine(String line) {
        ArrayList<String> sentences = new ArrayList<>();
        Matcher sentenceMatcher = sentencePattern.matcher(line);

        while (sentenceMatcher.find()) {
            sentences.add(sentenceMatcher.group());
        }

        return sentences.toArray(String[]::new);
    }

    public int[] parseSentence(String sentence) {
        ArrayList<Integer> references = new ArrayList<>();
        Matcher referenceMatcher = referencePattern.matcher(sentence);

        while (referenceMatcher.find()) {
            references.add(Integer.valueOf(referenceMatcher.group("first")));

            if (referenceMatcher.group("second") != null) {
                references.add(Integer.valueOf(referenceMatcher.group("second")));
            }
        }

        int[] result = new int[references.size()];

        for (int i = 0; i < references.size(); i++) {
            result[i] = references.get(i);
        }

        return result;
    }

    private void setMaximalReference(int currentReference) {
        if (maximalReference + 1 < currentReference) {
            System.out.println("WRONG ORDER! Expected: " + (maximalReference + 1) + ". Actual: " + currentReference);
        } else {
            maximalReference = Math.max(maximalReference, currentReference);
        }
    }
}
