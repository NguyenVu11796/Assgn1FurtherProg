package Assgn1FurtherProg.Assignment1.Interfaces;
import Assgn1FurtherProg.Assignment1.Models.Students;

/** Creating a public interface to define all available functionalities **/

public interface studentEnrolmentManager {

    public void addStudent(Students student);

    public void dropStudent(Students student);

    public void updateStudent(Students student);

    public void deleteStudent(Students student);

    public void getOne(Students student);

    public void getAll(Students student);

}
