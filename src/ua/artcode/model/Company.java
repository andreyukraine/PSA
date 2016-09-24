package ua.artcode.model;

import ua.artcode.utils.Constants;

import java.io.Serializable;
import java.util.List;

/**
 * Created by serhii on 21.08.16.
 */
public class Company implements Serializable {

    private long id;
    private String nameCompany;
    private String descriptionCompany;
    private Constants.statusCompany changeStatusCompany;
    private Location location;

    private Client moderator;
    private List<Worker> workers;
    private List<Comment> comments;
    private Service service;


    // constructors --------------------------------------------------------------------------------

    public Company() {
    }

    public Company(String nameCompany, String descriptionCompany, Client moderator, Location location, Service service) {
        this.nameCompany = nameCompany;
        this.descriptionCompany = descriptionCompany;
        this.moderator = moderator;
        this.location = location;
        this.service = service;
        changeStatusCompany = Constants.statusCompany.NEW;
    }

    // geters & seters -----------------------------------------------------------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getDescriptionCompany() {
        return descriptionCompany;
    }

    public void setDescriptionCompany(String descriptionCompany) {
        this.descriptionCompany = descriptionCompany;
    }

    public Constants.statusCompany getChangeStatusCompany() {
        return changeStatusCompany;
    }

    public void setChangeStatusCompany(Constants.statusCompany changeStatusCompany) {
        this.changeStatusCompany = changeStatusCompany;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Client getModerator() {
        return moderator;
    }

    public void setModerator(Client moderator) {
        this.moderator = moderator;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Service getServices() {
        return service;
    }

    public void setServices(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", nameCompany='" + nameCompany + '\'' +
                ", descriptionCompany='" + descriptionCompany + '\'' +
                ", changeStatusCompany='" + changeStatusCompany + '\'' +
                ", location=" + location +
                ", moderator=" + moderator +
                ", workers=" + workers +
                ", comments=" + comments +
                ", service=" + service +
                '}';
    }
}
