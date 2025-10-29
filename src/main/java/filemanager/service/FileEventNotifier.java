package filemanager.service;

/**
 * Minimal FileEventNotifier stub to allow compilation and basic notification.
 * Replace with a full implementation if you have a richer observer system.
 */
public final class FileEventNotifier {
    private static final FileEventNotifier INSTANCE = new FileEventNotifier();

    private FileEventNotifier() {
    }

    public static FileEventNotifier getInstance() {
        return INSTANCE;
    }

    /**
     * Notify observers of an event. This minimal stub simply prints the message.
     */
    public void notifyObservers(String message) {
        System.out.println("[FileEvent] " + message);
    }
}
