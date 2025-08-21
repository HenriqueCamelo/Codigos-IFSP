package src.model;

import java.util.List;

public class Enrollment {
        private Courses course;
        private Student student;
        private double progress; // 0.0 to 100.0

        public Enrollment(Courses course, Student student){
            this.course = course;
            this.student = student;
        }

        public double getProgress() {
            return progress;
        }

        public void setProgress(double progress) {
            this.progress = progress;
        }

        public Courses getCourse() {
            return course;
        }

        public Student getStudent() {
            return student;
        }

        @Override
	    public String toString() {
	        return "\n Aluno: " + student +  "[Curso: " + course + "]";
	    }

        

    }
