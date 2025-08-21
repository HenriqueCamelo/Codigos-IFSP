package src.model.plans;

public interface SubscriptionPlan {
        boolean canEnroll(int currentEnrollments);
        String getPlan();
    }
