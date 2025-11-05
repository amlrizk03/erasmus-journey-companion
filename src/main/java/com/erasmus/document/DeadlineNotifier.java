package com.erasmus.document;

import com.erasmus.notification.Observer;
import com.erasmus.notification.Subject;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DeadlineNotifier implements Subject {
    private List<Observer> observers;
    private List<Document> documents;

    public DeadlineNotifier() {
        this.observers = new ArrayList<>();
        this.documents = new ArrayList<>();
    }

    public void addDocument(Document document) {
        documents.add(document);
        checkDeadlines();
    }

    public void checkDeadlines() {
        LocalDate today = LocalDate.now();
        
        for (Document doc : documents) {
            if (doc.getDeadline() != null) {
                long daysUntilDeadline = ChronoUnit.DAYS.between(today, doc.getDeadline());
                
                if (daysUntilDeadline <= 7 && daysUntilDeadline >= 0) {
                    String message = "Reminder: Document '" + doc.getFileName() + 
                                   "' deadline is in " + daysUntilDeadline + " days!";
                    notifyObservers(message);
                }
            }
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
