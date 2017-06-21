package com.callegasdev.database;


import com.callegasdev.profile.History;

public class SaveHistory {

    private History history;
    private DaoHistory daoHistory;


    public SaveHistory(DaoHistory daoHistory, History history) {
        this.history = history;
        this.daoHistory = daoHistory;
    }

    public void save(String message){
        history.setHistory(message);
        daoHistory.save(history);

    }
}
