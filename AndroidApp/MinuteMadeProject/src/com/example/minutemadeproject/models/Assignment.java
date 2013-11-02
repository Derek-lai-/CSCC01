package com.example.minutemadeproject.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;


@DatabaseTable(tableName = "assignments")
public class Assignment {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(foreign = true)
    public Course course;

    @DatabaseField
    public String name;

    @DatabaseField
    public Date postDate;

    @DatabaseField
    public Date dueDate;

    @DatabaseField
    public double totalMark;

    @ForeignCollectionField
    public ForeignCollection<Grade> grades;

    Assignment() {
        // Needed by OrmLite
    }

    public Assignment(String name, Course course, Date postDate, Date dueDate, double totalMark) {
        this.name = name;
        this.course = course;
        this.postDate = postDate;
        this.dueDate = dueDate;
        this.totalMark = totalMark;
    }

    @Override
    public String toString() {
        return name + "for " + course.name + "due " + dueDate;
    }

    List<Map<String, String>> assignmentList = new ArrayList<Map<String,String>>();

	public void initList(){
        //populate assignmentList temporarily
        assignmentList.add(createAssignment("assignment", "asgn_1"));
        assignmentList.add(createAssignment("assignment", "asgn_2"));
        assignmentList.add(createAssignment("assignment", "asgn_3"));
        assignmentList.add(createAssignment("assignment", "asgn_4"));
        assignmentList.add(createAssignment("assignment", "asgn_5"));
        assignmentList.add(createAssignment("ass", "asgn_9"));

	}

    private HashMap<String, String> createAssignment(String key, String name) {
        HashMap<String, String> assignment = new HashMap<String, String>();
        assignment.put(key, name);

        return assignment;
    }
}
