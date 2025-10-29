package com.example.FILEIO;

import java.io.File;
import java.io.FileOutputStream;

public interface FileIOStrategy {

    public void saveFile(String filepath, byte[] data);

    public byte[] readFile(String filepath);

    public void deleteFile(String filepath);

    public boolean find(String filepath);
}
