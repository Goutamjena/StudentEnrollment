package com.infy.svc;

import com.infy.BO.Student;

public abstract class  StudentAction {

Student s=new Student();

public abstract int reister(Student s);
public abstract Student viewDetails(int rollno);

}
