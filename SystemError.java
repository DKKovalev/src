/**
 * Created by PsichO on 06.10.2014.
 */
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
        return "ErrorObject{" +
                "errorId = " + errorId +
                ", errorTitle =' " + errorTitle + '\'' +
                ", errorDescription =' " + errorDescription + '\'' +
                '}';
    }

    /**
     * Функция, необходимая для сортировки.
     * @param o входной объект.
     * @return method must return negative number if current object is less than other object,
     * positive number if current object is greater than other object and zero if both objects are equal to each other.
     */
    @Override
    public int compareTo(SystemError o) {
        return toString().compareTo(o.toString());
    }
}
