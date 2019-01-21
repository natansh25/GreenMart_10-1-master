package infinity1087.android.com.examplehr.Client;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Client {

    @SerializedName("employees")
    @Expose
    private List<ResClient> employees = null;

    public List<ResClient> getEmployees() {
        return employees;
    }

    public void setEmployees(List<ResClient> employees) {
        this.employees = employees;
    }

}
