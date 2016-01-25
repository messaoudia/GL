package models;

import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Guillaume on 25/01/2016.
 */
@Entity
@Table(name="Notification")
public class Notification {
    @Id
    @GeneratedValue
    public Long id;
    public String title;
    public String contentNotification;

    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateEnvoi;
    public String link;
    public boolean etatLecture;
    public boolean archiver;
    
}
