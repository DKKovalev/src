import java.util.*;

/**
 * @author Ковалев Дмитрий
 *         Задание:
 *         1. создать журнал системных сообщений,
 *         2. хранить его в LinkedHashSet,
 *         3. добавить в коллекцию данные,
 *         4. отсортировать данные,
 *         5. вывести содержимое коллекции,
 *         6. найти максимальный элемент,
 *         7. удалить нужный элемент,
 *         8. объединить две коллекции.
 *
 *         Ввод: Название Hash происходит от понятия хэш-функция.
 *         Хэш-функция — это функция, сужающая множество значений объекта до некоторого подмножества целых чисел.
 *         Класс Object имеет метод hashCode(), который используется классом HashSet для эффективного размещения объектов, заносимых в коллекцию.
 *         В классах объектов, заносимых в HashSet, этот метод должен быть переопределен (override).
 *
 *         Класс LinkedHashSet расширяет класс HashSet, не добавляя никаких новых методов.
 *         Класс поддерживает связный список элементов набора в том порядке, в котором они вставлялись.
 *         Это позволяет организовать упорядоченную итерацию вставки в набор.
 */

public class Main {

    private static LinkedHashSet<SystemError> systemErrors;
    private static Iterator<SystemError> errorIterator;

    public static void main(String[] params) {

        systemErrors = new LinkedHashSet<SystemError>();
/**
 * Добавление объектов в LinkedHashSet.
 */
        systemErrors.add(new SystemError(1, "File not found", "The system cannot find the file"));
        systemErrors.add(new SystemError(2, "Not enough memory", "Not enough storage is available"));
        systemErrors.add(new SystemError(4, "Read error", "The system cannot read the file"));
        systemErrors.add(new SystemError(3, "Write error", "The system cannot write file"));
        systemErrors.add(new SystemError(5, "Network access denied", "Network access is denied"));
        systemErrors.add(new SystemError(6, "Buffer overflow", "The file name is too long"));

        System.out.println('\n' + "Base collection: " + '\n');

        errorIterator = systemErrors.iterator();
        while (errorIterator.hasNext()) {
            System.out.println(errorIterator.next());
        }

        sort();

        findMax();

        removeSpecifiedElement();

        combine();
    }

    /**
     * Функция для объединения коллекций.
     * LinkedHashSet.addAll добавляет все элементы определенной коллекции в set, если они не присутствуют в этом set.
     */

    private static void combine() {

        LinkedHashSet<SystemError> anotherSystemErrors = new LinkedHashSet<SystemError>();
        anotherSystemErrors.add(new SystemError(7, "Max sessions reached", "The maximum number of sessions has been reached."));
        anotherSystemErrors.add(new SystemError(8, "Restart failed", "The restart operation failed."));
        anotherSystemErrors.add(new SystemError(9, "Shutdown error", "The shutdown operation failed."));

        systemErrors.addAll(anotherSystemErrors);

        System.out.println('\n' + "After combining: " + '\n');

        errorIterator = systemErrors.iterator();
        while (errorIterator.hasNext()) {
            System.out.println(errorIterator.next());
        }
    }

    /**
     * Функция сортировки.
     * Arrays.sort сортирует массив объектов в порядке убывания.
     * Arrays.asList возвращает лист определенного размера, содержащего элементы массива.
     */

    private static void sort() {
        Object[] errorsArray = systemErrors.toArray();

        Arrays.sort(errorsArray);
        System.out.println('\n' + "Sorted base collection: " + Arrays.asList(errorsArray));
    }

    /**
     * Функция поиска максимального элемента.
     * Collections.max возвращает максимальный элемент данной коллекции.
     */
    private static void findMax(){
        SystemError max = Collections.max(systemErrors);
        System.out.println('\n' + "Max: " + max);
    }

    /**
     * Функция удаления нужного элемента.
     * LinkedHashSet.remove удаляет определенный элемент, если он присутствует.
     * Для проверки присутствия элемента в коллекции используются методы hashCode и equals.
     * Если hashCode элемента, присутствующего в коллекции и элемента, который необходимо удалить, совпадают,
     * то этот элемент удаляется.
     */

    private static void removeSpecifiedElement(){

        SystemError toRemove = new SystemError(1, "File not found", "The system cannot find the file");
        systemErrors.remove(toRemove);
        System.out.println('\n' + "After removal:" + '\n');

        errorIterator = systemErrors.iterator();
        while (errorIterator.hasNext()) {
            System.out.println(errorIterator.next());
        }
    }
}

/**
 * Вывод: в работе были рассмотрены методы работы с коллекциями в общем и с LinkedHashSet в частности.
 */
