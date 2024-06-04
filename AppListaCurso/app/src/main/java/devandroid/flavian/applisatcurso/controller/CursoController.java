package devandroid.flavian.applisatcurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.flavian.applisatcurso.model.Curso;

public class CursoController {

    private List courseList;

    public List GetListCourse(){

        courseList = new ArrayList<Curso>();

        courseList.add(new Curso("Java")); // Java
        courseList.add(new Curso("HTML")); // HTML
        courseList.add(new Curso("Java Script")); // Java Script
        courseList.add(new Curso("C#")); // C#
        courseList.add(new Curso("Python")); // Python
        courseList.add(new Curso("CSS")); // CSS

        return courseList;

    }
}
