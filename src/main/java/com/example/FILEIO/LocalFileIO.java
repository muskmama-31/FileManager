package com.example.FILEIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import filemanager.service.FileEventNotifier;

public class LocalFileIO implements FileIOStrategy {
    @Override
    public void saveFile(String filePath, byte[] data) {
        // Use try-with-resources so the stream is closed automatically
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(data);
            FileEventNotifier.getInstance().notifyObservers("Your file has been saved");
            return;
        } catch (Exception ex) {
            System.err.println("Not able to save the file at path " + filePath + ": " + ex.getMessage());
        }
    }

    @Override
    public byte[] readFile(String filePath) {
        try {

            File file = new File(filePath);
            boolean exists = file.exists();

            if (!exists) {
                return new byte[0];
            }
            // Use try-with-resources to ensure the stream is closed
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] data = fis.readAllBytes();
                FileEventNotifier.getInstance().notifyObservers("Your file has been read");
                return data;
            }
        } catch (Exception ex) {
            System.err.println("Not able to read the file from path " + filePath);
            return new byte[0];
        }
    }

    @Override
    public void deleteFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.err.println("File not found: " + filePath);
                return;
            }

            boolean deleted = file.delete();
            if (deleted) {
                FileEventNotifier.getInstance().notifyObservers("Your file has been deleted");
            } else {
                System.err.println("Failed to delete file: " + filePath);
            }
        } catch (Exception ex) {
            System.err.println("Error deleting file at path " + filePath + ": " + ex.getMessage());
        }
    }

    @Override
    public boolean find(String filePath) {
        try {
            File file = new File(filePath);
            return file.exists();
        } catch (Exception ex) {
            System.err.println("Error checking file existence for " + filePath + ": " + ex.getMessage());
            return false;
        }
    }

}