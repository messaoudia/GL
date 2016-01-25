package models;

import com.avaje.ebean.Model;
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
    public static Model.Finder<Long, Notification> find = new Model.Finder<Long, Notification>(Notification.class);

    public Notification(String title, String contentNotification, Date dateEnvoi, String link, Boolean etatLecture, Boolean archiver) {
        this.title = title;
        this.contentNotification = contentNotification;
        this.dateEnvoi = dateEnvoi;
        this.link = link;
        this.etatLecture = etatLecture;
        this.archiver = archiver;
    }

    public Boolean getArchiver() {
        return archiver;
    }

    public void setArchiver(Boolean archiver) {
        this.archiver = archiver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentNotification() {
        return contentNotification;
    }

    public void setContentNotification(String contentNotification) {
        this.contentNotification = contentNotification;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getEtatLecture() {
        return etatLecture;
    }

    public void setEtatLecture(Boolean etatLecture) {
        this.etatLecture = etatLecture;
    }
}
