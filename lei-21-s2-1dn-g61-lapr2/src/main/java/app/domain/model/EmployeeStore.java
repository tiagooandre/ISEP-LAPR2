package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStore {
    private List<Employee> employeeList;

    public EmployeeStore() {
        this.employeeList = new ArrayList<>();
    }

    public boolean validateEmployeeAttributes(Employee e) {
        if (e == null)
            return false;
        for(Employee emp : this.employeeList) {
            if ((emp.getPhoneNumberEmployee().equalsIgnoreCase(e.getPhoneNumberEmployee())) || (emp.getEmailEmployee().getEmail().equals(e.getEmailEmployee().getEmail()))) {
                throw new IllegalArgumentException("The email and/or phone number already exist in the system.");
            }
        }
        return true;
    }

    /**
     *
     * @param e The employee to be validated
     * @return Validation if the employee doesn't already exists
     */
    public boolean validateEmployee(Employee e) {
        if (e == null)
            return false;
        return !this.employeeList.contains(e);
    }

    /**
     *
     * @param e The employee to be added to the list of employees
     * @return true if the new employee was added successfully
     */
    public boolean saveEmployee(Employee e) {
        if (!validateEmployee(e))
            return false;
        return this.employeeList.add(e);
    }

    /**
     * @return Company's list of employees
     */
    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public boolean remove(Employee emp) {
        if (emp != null)
            return this.employeeList.remove(emp);
        return false;
    }
}
