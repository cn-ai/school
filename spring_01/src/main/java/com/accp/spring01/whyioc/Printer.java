
package com.accp.spring01.whyioc;

import com.accp.spring01.pojo.Employee;

public class Printer {
public Employee emp;

public Employee getEmp() {
	return emp;
}

public void setEmp(Employee emp) {
	this.emp = emp;
}

public void printer() {
	emp.display();
}
}
