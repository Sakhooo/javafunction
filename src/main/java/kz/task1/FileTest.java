package kz.task1;

import java.io.File;
import java.io.FileFilter;
import java.util.function.IntFunction;

public class FileTest {
    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);

        IntFunction<Integer> integerIntFunction = (int x) -> x + 1;

    }
}
