package ru.kpfu.shop.util;


public final class PropertyPath {

    //Абсолютный путь до папки на компьютере, куда будут сохраняться фотографии
    //Задается через bean, значения беруться из application.properties
    private static String path;


    public void setPath(String path) {
        this.path = path;
    }

    public static String getPath() {
        return path;
    }
}
