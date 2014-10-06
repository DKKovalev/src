/**
 * Created by PsichO on 06.10.2014.
 */
public class SystemError implements Comparable<SystemError> {
    int errorId;
    String errorTitle;
    String errorDescription;

    public SystemError(int errorId, String errorTitle, String errorDescription) {
        this.errorId = errorId;
        this.errorTitle = errorTitle;
        this.errorDescription = errorDescription;
    }

    public int hashCode(){
        int hashcode = 0;
        hashcode = errorId * 10;
        hashcode += errorTitle.hashCode();
        hashcode += errorDescription.hashCode();
        return hashcode;
    }

    public boolean equals(Object obj){
        if(obj instanceof SystemError){
            SystemError error = (SystemError) obj;
            return (error.errorTitle.equals(this.errorTitle) && error.errorDescription.equals(this.errorDescription) && error.errorId == this.errorId);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ErrorObject{" +
                "errorId = " + errorId +
                ", errorTitle =' " + errorTitle + '\'' +
                ", errorDescription =' " + errorDescription + '\'' +
                '}';
    }

    @Override
    public int compareTo(SystemError o) {
        return toString().compareTo(o.toString());
    }

    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public String getErrorTitle() {
        return errorTitle;
    }

    public void setErrorTitle(String errorTitle) {
        this.errorTitle = errorTitle;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
