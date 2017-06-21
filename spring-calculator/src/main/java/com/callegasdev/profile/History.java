package com.callegasdev.profile;

import com.callegasdev.view.ColorFactory;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class History {

    @Id
    @GeneratedValue
    private Integer id;

    private String history;

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public String toString() {
        ColorFactory colorFactory = new ColorFactory();
        return "\n" + colorFactory.ANSI_RED +
                history +
                colorFactory.ANSI_RESET + "\n";
    }
}

