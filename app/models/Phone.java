package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.Finder;
import io.ebean.Model;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Phone extends Model {
    @Id
    public String id;
    @Constraints.Required
    public String imageurl;
    @Constraints.Required
    public String name;
    @Constraints.Required
    public String snippet;
    @Constraints.Required
    public long age;
    @Constraints.Required
    public String carrier;
    @Constraints.Required
    @Column(columnDefinition = "TEXT")
    public String details;

    public static final Finder<String, Phone> find = new Finder<>(Phone.class);
}
