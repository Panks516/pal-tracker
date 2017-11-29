package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private HashMap<Long, TimeEntry> timeEntries = new HashMap<>();

    public InMemoryTimeEntryRepository() {
        timeEntries.put(new Date().getTime(), new TimeEntry(9,10, LocalDate.now(),15));
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry){
        timeEntry.setId(timeEntries.size() + 1);
        timeEntries.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id){
        return timeEntries.get(id);
    }

    @Override
    public List<TimeEntry> list(){
        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        timeEntries.replace(id, timeEntry);
        timeEntry.setId(id);
        return timeEntry;
    }

    @Override
    public void delete(Long id){
        timeEntries.remove(id);
    }
}
