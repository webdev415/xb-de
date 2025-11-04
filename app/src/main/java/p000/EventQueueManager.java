package p000;

import android.database.Cursor;
import android.database.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventQueueManager {

    // Singleton instance
    private static EventQueueManager instance;

    // List of event handlers
    private final List<EventHandlerRegistration> eventHandlers = new ArrayList<>();

    // Map of transaction IDs to event handlers
    private final Map<Long, AbstractC2313s> transactionHandlers = new HashMap<>();

    // Singleton getInstance
    public static EventQueueManager getInstance() {
        if (instance == null) {
            instance = new EventQueueManager();
        }
        return instance;
    }

    // Load events from the database
    public void loadEvents() {
        try (Cursor cursor = MySQLiteOpenHelper.getInstance().getReadableDatabase().query(
                "event_queue", DatabaseColumns.EVENT_QUEUE, null, null, null, null, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    long transactionId = cursor.getLong(cursor.getColumnIndex("tran_id"));
                    int eventId = cursor.getInt(cursor.getColumnIndex("event_id"));
                    String eventParams = cursor.getString(cursor.getColumnIndex("event_params"));
                    removeEvent(transactionId);
                    if (eventId != 0) {
                        processEvent(transactionId, eventId, eventParams, null);
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Remove an event from the database
    public void removeEvent(long transactionId) {
        this.transactionHandlers.remove(transactionId);
        try {
            MySQLiteOpenHelper.getInstance().getWritableDatabase().execSQL("DELETE FROM event_queue WHERE tran_id=" + transactionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add event to the queue
    public void addEvent(AbstractC2313s eventHandler) throws SQLException {
        this.transactionHandlers.put(eventHandler.m9456c(), eventHandler);
        MySQLiteOpenHelper.getInstance().getWritableDatabase().execSQL(
                "INSERT INTO event_queue(tran_id,event_id,event_params,status ) VALUES (" +
                        eventHandler.f6987a + ", " + eventHandler.f6988b + ",'" + eventHandler.f6989c + "',0)");
    }

    // Process event with parameters
    public void processEvent(int eventId) {
        processEvent(eventId, null);
    }

    public void processEvent(int eventId, String eventParams) {
        processEvent(eventId, eventParams, null);
    }

    public void processEvent(int eventId, String eventParams, Object additionalData) {
        processEvent(System.currentTimeMillis(), eventId, eventParams, additionalData);
    }

    public void processEvent(long timestamp, int eventId, String eventParams, Object additionalData) {
        for (EventHandlerRegistration registration : eventHandlers) {
            if (registration.eventId == eventId) {
                try {
                    AbstractC2313s eventHandler = (AbstractC2313s) registration.eventClass.newInstance();
                    eventHandler.m9458e(timestamp);
                    if (!eventHandler.m9457d(eventId, eventParams, additionalData)) {
                        addEvent(eventHandler);
                    }
                } catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Register an event type handler
    public void registerEventHandler(int eventId, Class<? extends AbstractC2313s> eventClass) {
        this.eventHandlers.add(new EventHandlerRegistration(eventId, eventClass));
    }

    // Internal class for event handler registration
    private static class EventHandlerRegistration {
        private final int eventId;
        private final Class<? extends AbstractC2313s> eventClass;

        public EventHandlerRegistration(int eventId, Class<? extends AbstractC2313s> eventClass) {
            this.eventId = eventId;
            this.eventClass = eventClass;
        }
    }
}
