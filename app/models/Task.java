package models;

import play.db.DB;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.*;

@Entity
public class Task extends Model{
    @Id
    public Long id;

    @Required
    public String label;

    DataSource ds = DB.getDataSource();
    Connection connection = DB.getConnection();

    public static Finder<Long,Task> find = new Finder<Long,Task>(
            Long.class, Task.class
    );

    public static List<Task> all() {
        return find.all();
    }

    public static void create(Task task) {
        task.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }



}