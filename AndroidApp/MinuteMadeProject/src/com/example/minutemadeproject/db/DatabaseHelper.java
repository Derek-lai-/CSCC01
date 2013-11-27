package com.example.minutemadeproject.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.minutemadeproject.models.Assignment;
import com.example.minutemadeproject.models.Course;
import com.example.minutemadeproject.models.Event;
import com.example.minutemadeproject.models.Grade;
import com.example.minutemadeproject.models.Instructor;
import com.example.minutemadeproject.models.Lesson;
import com.example.minutemadeproject.models.Schedule;
import com.example.minutemadeproject.models.Student;
import com.example.minutemadeproject.models.Tutorial;
import com.example.minutemadeproject.models.User;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper{

    private static final String DATABASE_NAME = "minuteMade.db";
    private static final int DATABASE_VERSION = 3;

    private Dao<Assignment, Integer> assignmentDao = null;
    private Dao<Course, Integer> courseDao = null;
    private Dao<Event, Integer> eventDao = null;
    private Dao<Grade, Integer> gradeDao = null;
    private Dao<Instructor, Integer> instructorDao = null;
    private Dao<Lesson, Integer> lessonDao = null;
    private Dao<Schedule, Integer> scheduleDao = null;
    private Dao<Student, Integer> studentDao = null;
    private Dao<Tutorial, Integer> tutorialDao = null;
    private Dao<User, Integer> userDao = null;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Assignment.class);
            TableUtils.createTable(connectionSource, Course.class);
            TableUtils.createTable(connectionSource, Event.class);
            TableUtils.createTable(connectionSource, Grade.class);
            TableUtils.createTable(connectionSource, Instructor.class);
            TableUtils.createTable(connectionSource, Lesson.class);
            TableUtils.createTable(connectionSource, Schedule.class);
            TableUtils.createTable(connectionSource, Student.class);
            TableUtils.createTable(connectionSource, Tutorial.class);
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database.", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Assignment.class, true);
            TableUtils.dropTable(connectionSource, Course.class, true);
            TableUtils.dropTable(connectionSource, Event.class, true);
            TableUtils.dropTable(connectionSource, Grade.class, true);
            TableUtils.dropTable(connectionSource, Instructor.class, true);
            TableUtils.dropTable(connectionSource, Lesson.class, true);
            TableUtils.dropTable(connectionSource, Schedule.class, true);
            TableUtils.dropTable(connectionSource, Student.class, true);
            TableUtils.dropTable(connectionSource, Tutorial.class, true);
            TableUtils.dropTable(connectionSource, User.class, true);

            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop database.", e);
            throw new RuntimeException(e);
        }
    }

    public Dao<Assignment, Integer> getAssignmentDao() throws SQLException {
        if (assignmentDao == null) {
            assignmentDao = getDao(Assignment.class);
        }
        return assignmentDao;
    }

    public Dao<Course, Integer> getCourseDao() throws SQLException {
        if (courseDao == null) {
            courseDao = getDao(Course.class);
        }
        return courseDao;
    }

    public Dao<Event, Integer> getEventDao() throws SQLException {
        if (eventDao == null) {
            eventDao = getDao(Event.class);
        }
        return eventDao;
    }

    public Dao<Grade, Integer> getGradeDao() throws SQLException {
        if (gradeDao == null) {
            gradeDao = getDao(Grade.class);
        }
        return gradeDao;
    }

    public Dao<Instructor, Integer> getInstructorDao() throws SQLException {
        if (instructorDao == null) {
            instructorDao = getDao(Instructor.class);
        }
        return instructorDao;
    }

    public Dao<Lesson, Integer> getLessonDao() throws SQLException {
        if (lessonDao == null) {
            lessonDao = getDao(Lesson.class);
        }
        return lessonDao;
    }

    public Dao<Schedule, Integer> getScheduleDao() throws SQLException {
        if (scheduleDao == null) {
            scheduleDao = getDao(Schedule.class);
        }
        return scheduleDao;
    }

    public Dao<Student, Integer> getStudentDao() throws SQLException {
        if (studentDao == null) {
            studentDao = getDao(Student.class);
        }
        return studentDao;
    }

    public Dao<Tutorial, Integer> getTutorialDao() throws SQLException {
        if (tutorialDao == null) {
            tutorialDao = getDao(Tutorial.class);
        }
        return tutorialDao;
    }

    public Dao<User, Integer> getUserDao() throws SQLException {
        if (userDao == null) {
            userDao = getDao(User.class);
        }
        return userDao;
    }

    @Override
    public void close() {
        super.close();
        assignmentDao = null;
        courseDao = null;
        eventDao = null;
        gradeDao = null;
        instructorDao = null;
        lessonDao = null;
        scheduleDao = null;
        studentDao = null;
        tutorialDao = null;
        userDao = null;
    }
}