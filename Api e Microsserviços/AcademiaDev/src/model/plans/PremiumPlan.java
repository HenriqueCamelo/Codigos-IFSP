package src.model.plans;

public class PremiumPlan implements SubscriptionPlan{

        @Override
        public boolean canEnroll(int currentEnrollments) {
            return true;
        }

        @Override
        public String getPlan() {
            return "Premium";
        }

    }
