package com.example.colleenminor.theadventure.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Created by colleenminor on 10/28/15.
 */
@Table(name = "Users", id = "_id")
public class User extends Model {

    @Column(name = "Name")
    private String mName;

    @Column(name = "Actions")
    private int mActions;

    public int getActions() {
        return mActions;
    }
    public void addActions(int numActions) {
        this.mActions = (this.mActions + numActions);
    }
    public void subtractActions(int numActions) {
        this.mActions = (this.mActions - numActions);
    }

    public void setActions(int mActions) {
        this.mActions = mActions;
    }

    public User() {
        super();
    }

    public User(String name, int actions) {
        super();
        mName = name;
        mActions = actions;
    }

    public String getName() {
        return mName;
    }

    public static User find(String username) {
        return new Select()
                .from(User.class)
                .where("Name = ?", username)
                .executeSingle();
    }

}