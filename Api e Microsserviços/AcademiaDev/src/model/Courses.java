package src.model;
import src.model.enums.DifficultyLevel;

import java.util.ArrayList;
import java.util.List;

import src.model.enums.CourseStatus;

public class Courses {
                    
        public String title; 
        public String description;
        public String instructorName;
        public Double durationInHours;// ??
        public DifficultyLevel difficultyLevel;
        public CourseStatus status;

        List<Courses> courses = new ArrayList<>();


        public List<Courses> getCourses() {
		    return courses;
        }
        public String getTitle() {
		    return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getInstructorName() {
            return instructorName;
        }
        public void setInstructorName(String instructorName) {
            this.instructorName = instructorName;
        }
        public Double getDurationInHours() {
            return durationInHours;
        }
        public void setDurationInHours(Double durationInHours) {
            this.durationInHours = durationInHours;
        }
        public DifficultyLevel getDifficultyLevel() {
            return difficultyLevel;
        }
        public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
            this.difficultyLevel = difficultyLevel;
        }
        public CourseStatus getStatus() {
            return status;
        }
        public void setStatus(CourseStatus status) {
            this.status = status;
        }

        @Override
	    public String toString() {
	        return title;
	    }
    }
