public class SystemError implements Comparable<SystemError> {
    int errorId;
    String errorTitle;
    String errorDescription;

    /**
     * Конструктор.
     * @param errorId -- Код ошибки.
     * @param errorTitle -- Имя ошибки.
     * @param errorDescription -- Описание ошибки.
     */

    public SystemError(int errorId, String errorTitle, String errorDescription) {
        this.errorId = errorId;
        this.errorTitle = errorTitle;
        this.errorDescription = errorDescription;
    }

    /**
     * Функция для задания одинакового хэшкода для входного объекта.
     * Она необходима для удаления нужного элемента.
     *
     * Хешкод --  это битовая строка фиксированной длины, полученная из массива произвольной длины.
     * Под массивом произвольной длины мы будем понимать объект.
     *
     * Этот метод реализован таким образом, что для одного и того-же входного объекта, хеш-код всегда будет одинаковым.
     *
     * @return возвращает хэшкод для объекта.
     */
    public int hashCode(){
        int hashcode = 0;
        hashcode = errorId * 10;
        hashcode += errorTitle.hashCode();
        hashcode += errorDescription.hashCode();
        return hashcode;
    }

    /**
     * Эквивалентность и хеш-код тесно связанны между собой,
     * поскольку хеш-код вычисляется на основании содержимого объекта (значения полей)
     * и если у двух объектов одного и того же класса содержимое одинаковое,
     * то и хеш-коды должны быть одинаковые.
     * @param obj Входной объект.
     * @return возвращает true если сравниваемые объекты одинаковы и false в противоположном случае.
     */
    public boolean equals(Object obj){
        if(obj instanceof SystemError){
            SystemError error = (SystemError) obj;
            return (error.errorTitle.equals(this.errorTitle) && error.errorDescription.equals(this.errorDescription) && error.errorId == this.errorId);
        } else {
            return false;
        }
    }

    /**
     *
     * @return возвращает информацию в заданном формате.
     */
    @Override
    public String toString() {
        return "ErrorObject: " +
                "errorId = " + errorId +
                ", errorTitle =' " + errorTitle + '\'' +
                ", errorDescription =' " + errorDescription + '\'' +
                ';';
    }

    /**
     * Функция, необходимая для сортировки.
     * @param o входной объект.
     * @return метод возвращает отрицательное число если один объект меньше другого,
     * положительное, если больше и ноль если объекты равны.
     */
    @Override
    public int compareTo(SystemError o) {
        return toString().compareTo(o.toString());
    }
}
