// placeholder file to avoid duplicate-class errors while refactoring
// The real FileManager implementation lives in FileManager.java (correct casing).
package filemanager.manager;

import filemanager.Fileio.FileIOStrategy;

public class FileManager {
    private IFileIOStrategy strategy;

    public FileManager(IFileIOStrategy fileIOStrategy) {
        this.strategy = fileIOStrategy;
    }

    public void setStrategy(IFileIOStrategy strategy) {
        this.strategy = strategy;
    }

    public void upload(String filePath, byte[] data) {
        strategy.saveFile(filePath, data);
    }

    public byte[] download(String filePath) {
        return strategy.readFile(filePath);
    }

}