package com.activity.two;

// enumeration
public enum Channel {
    EMAIL {
        @Override
        String label() {
            return "Email message";
        }
    },
    SMS {
        @Override
        String label() {
            return "SMS message";
        }
    },
    PUSH {
        @Override
        String label() {
            return "Push notification";
        }
    };

    abstract String label();
}

// Channel.EMAIL -> EMAIL
// Channel.SMS -> SMS