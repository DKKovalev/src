import java.util.*;

/**
 * @author Ковалев Дмитрий
 *         Задание: создать журнал системных сообщений,
 *         хранить его в LinkedHashSet,
 *         добавить в коллекцию данные,
 *         отсортировать данные,
 *         вывести содержимое коллекции,
 *         найти максимальный элемент,
 *         удалить нужный элемент,
 *         объединить две коллекции.
 */

public class Main {

    public static void main(String[] params) {

        LinkedHashSet<SystemError> systemErrors = new LinkedHashSet<SystemError>();
/**
 * Добавление объектов в LinkedHashSet.
 */
        systemErrors.add(new SystemError(1, "File not found", "The system cannot find the file"));
        systemErrors.add(new SystemError(2, "Not enough memory", "Not enough storage is available"));
        systemErrors.add(new SystemError(4, "Read error", "The system cannot read the file"));
        systemErrors.add(new SystemError(3, "Write error", "The system cannot write file"));
        systemErrors.add(new SystemError(5, "Network access denied", "Network access is denied"));
        systemErrors.add(new SystemError(6, "Buffer overflow", "The file name is too long"));

        Iterator<SystemError> errorIterator = systemErrors.iterator();
        while (errorIterator.hasNext()) {
            System.out.println(errorIterator.next());
        }
/**
 * Создаем новую коллекцию объектов для дальнейшего соединения ее с systemErrors.
 */
        LinkedHashSet<SystemError> anotherSystemErrors = new LinkedHashSet<SystemError>();
        anotherSystemErrors.add(new SystemError(7, "Max sessions reached", "The maximum number of sessions has been reached."));
        anotherSystemErrors.add(new SystemError(8, "Restart failed", "The restart operation failed."));
        anotherSystemErrors.add(new SystemError(9, "Shutdown error", "The shutdown operation failed."));
/**
 * Объединение коллекций.
 */
        systemErrors.addAll(anotherSystemErrors);

        System.out.println("After combining: " + systemErrors);

        Object[] errorsArray = systemErrors.toArray();

        Arrays.sort(errorsArray);
        System.out.println("Sorted array: " + Arrays.asList(errorsArray));

        SystemError max = Collections.max(systemErrors);
        System.out.println("Max: " + max);

        SystemError toRemove = new SystemError(1, "File not found", "The system cannot find the file");
        systemErrors.remove(toRemove);
        System.out.println("After removal:" + systemErrors);


    }
}
