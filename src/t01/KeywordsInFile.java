package t01;

import java.io.*;

public abstract class KeywordsInFile {
    protected File file;

    public KeywordsInFile(String file) {
        this(new File(file));
    }

    public KeywordsInFile(File file) {
        this.file = file;
    }

    public void process() {
        process("SimpleOutput.txt");
    }

    public void process(String outputFileName){
        process(new File(outputFileName));
    }

    public void process(File outputFile) {

        JavaKeywords javaKeywords = findKeywordUsages();

        printKeywordUsages(javaKeywords, outputFile);

    }

    abstract void printKeywordUsages(JavaKeywords javaKeywords, File outputFile);

    abstract JavaKeywords findKeywordUsages();
}
