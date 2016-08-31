package ua.artcode.model;

import java.util.List;

/**
 * Created by serhii on 21.08.16.
 */
public class Company {

    private long id;
    private String nameCompany;
    private String descriptionCompany;
    private String changeStatusCompany;
    private Location location;

    private Client moderator;
    private List<Worker> workers;
    private List<Comment> comments;
    private List<Service> services;


    // constructors --------------------------------------------------------------------------------

    public Company() {
    }

    public Company(String nameCompany, String descriptionCompany, Client moderator, Location location) {
        this.nameCompany = nameCompany;
        this.descriptionCompany = descriptionCompany;
        this.moderator = moderator;
        this.location = location;
        changeStatusCompany = new Status().statusCompany(1);
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

    public String getChangeStatusCompany() {
        return changeStatusCompany;
    }

    public void setChangeStatusCompany(String changeStatusCompany) {
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
