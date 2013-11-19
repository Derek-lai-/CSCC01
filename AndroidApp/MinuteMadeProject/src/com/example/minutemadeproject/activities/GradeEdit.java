package com.example.minutemadeproject.activities;

import android.widget.ArrayAdapter;

import com.example.minutemadeproject.R;
import com.example.minutemadeproject.helpers.AssignmentHelper;
import com.example.minutemadeproject.helpers.CourseHelper;
import com.example.minutemadeproject.helpers.GradeHelper;
import com.example.minutemadeproject.helpers.StudentHelper;

import java.util.List;

public class GradeEdit extends Activity{
    GradeHelper gradeHelper;
    AssignmentHelper asssignmentHelper;
    StudentHelper studentHelper;
    CourseHelperHelper courseHelper;
    List<Grade> gradeList;
    Assignment assignment;
    int[] id;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignmentlist);

        final Bundle b = getIntent().getExtra();
        id = b.getInt("id");

        assignmentHelper = new AssignmentHelper(this);
        assignment = assignmentHelper.getAssignment(id);

        gradeHelper = new GradeHelper(this);
        gradeList = gradeHelper.findMatch("assignment", assignment.name);

        ArrayAdapter<Grade> adapter = new ArrayAdapter<Grade>(this, R.layout.asssignmentgrade, gradeList);

        TableView tv = (TableView)findViewById(R.id.assignmentgrade);
        lv.setAdapter(adapter;)


    }

}
