package io.github.studio22.la;

public class CheckSize {
    public static boolean checkSize(String nameOfFunction, String selectedRowSize, String selectedColumnSize) {
        switch (nameOfFunction) {
            case "Критерий Сильвестра":
                return selectedRowSize.equals(selectedColumnSize);
            default:
                return true;
        }
    }
}
