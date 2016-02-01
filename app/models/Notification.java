package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;

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
public class Notification extends Model{
    @Id
    @GeneratedValue
    public Long id;
    public String title;
    public String contentNotification;

    @Formats.DateTime(pattern = "dd/MM/yyyy HH:mm")
    public Date dateEnvoi;
    public String link;
    public Boolean etatLecture;
    public Boolean archiver;
    public static Model.Finder<Long, Notification> find = new Model.Finder<>(Notification.class);

    public Notification(String title, String contentNotification, Date dateEnvoi, String link, Boolean etatLecture, Boolean archiver) {
        this.title = title;
        this.contentNotification = contentNotification;
        this.dateEnvoi = dateEnvoi;
        this.link = link;
        this.etatLecture = etatLecture;
        this.archiver = archiver;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Notification : ");
        sb.append(id);
        sb.append("] : ");
        sb.append(title);
        sb.append(", ");
        sb.append(dateEnvoi);
        sb.append(", ");
        sb.append(link);
        sb.append(", etatLecture ");
        sb.append(etatLecture);
        sb.append(", archiver ");
        sb.append(archiver);
        sb.append(", contentNotification \n");
        sb.append(contentNotification);
        sb.append("\n");
        return sb.toString();
    }
}
