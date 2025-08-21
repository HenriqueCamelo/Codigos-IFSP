package src.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import src.model.enums.CourseStatus;

import src.model.plans.SubscriptionPlan;

public class Student extends User{

        public SubscriptionPlan subscriptionPlan;
        private List<Enrollment> enrollments = new ArrayList<>();

        public Student(String name, String email, SubscriptionPlan subscriptionPlan) {
            super(name, email);
            this.subscriptionPlan = subscriptionPlan;
        }

        public SubscriptionPlan getSubscriptionPlan() {
            return subscriptionPlan;
        }

        public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
            this.subscriptionPlan = subscriptionPlan;
        }

        public List<Enrollment> getEnrollments() { 
            return enrollments; 
        }

        public void setEnrollments(List<Enrollment> enrollments) { 
            this.enrollments = enrollments; 
        }


        @Override
	    public String toString() {
	        return getName();
	    }
    }
