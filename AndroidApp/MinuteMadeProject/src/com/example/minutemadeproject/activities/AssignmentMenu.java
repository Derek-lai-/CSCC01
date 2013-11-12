package com.example.minutemadeproject.activities;

import com.example.minutemadeproject.R;

public class AssignmentMenu {

    private List<Course> courses;
    private List<Assignments> assignments;


    public void onCreate(Bundle savedInstanceState){}
    super.onCreate(savedInstanceState);
    setContentView(R.layout.assignmentlist);

    courseSpinner = (Spinner) findViewById(R.id.courseSpinner);
    assignmentSpinner = (Spinner) findViewById(R.id.assignmentSpinner);
    tutorialSpinner = (Spinner) findViewById(R.id.tutorialSpinner);

    getCourses();
    getAssignment();

    }

    public void getCourses(){
        courseHelper = new CourseHelper(this);
        courses = courseHelper.getAll();
    }

    public void getAssignments(){
        assignmetnHelper = new AssignmentHelper(this);
        assignemts = assignmentHelper.getAll();
    }
}