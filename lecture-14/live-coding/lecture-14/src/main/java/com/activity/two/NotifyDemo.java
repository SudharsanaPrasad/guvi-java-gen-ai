package com.activity.two;


/*
Context: simple notification system manages messages of different types but
currently uses plain strings and has an override error
Tasks
- Add @Override in the subclass and fix the method signature so overriding works correctly
- Replace the fragile string type with an enum Channel having values EMAIL, SMS, and PUSH
- Add a method label() in Channel to return a friendly name such as "Email message"
- Use the enum in main() to print the readable channel label after sending the message

 */
public class NotifyDemo {
    public static void main(String[] a) {
        Notification n1 = new Notification();
        n1.send("Sending push...");

        Notification n = new EmailNotification();
        n.send("Hello user!");
        // n.getType() -> Channel = EMAIL
        // EMAIL.label()
        System.out.println(n.getType().label());
    }
}
