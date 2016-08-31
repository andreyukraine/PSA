package ua.artcode.model;

/**
 * Created by serhii on 21.08.16.
 */
public class Company {

    private long id;
    private String nameCompany;
    private Location location;
    private String descriptionCompany;
    private String changeStatusCompany;
    private Worker[] workers;
    private Comment[] comments;
    private Service[] services;
    private Moderator moderator;



    // TODO reduct добавлен индекс количества воркеров в компании
    private int indexOfWorker;



    // constructors --------------------------------------------------------------------------------
    public Company(String nameCompany, Location location, String descriptionCompany, Moderator moderator) {
        this.nameCompany = nameCompany;
        this.location = location;
        this.descriptionCompany = descriptionCompany;
        this.moderator = moderator;
        this.changeStatusCompany = "new";
    }

    public Company() {
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescriptionCompany() {
        return descriptionCompany;
    }

    public void setDescriptionCompany(String descriptionCompany) {
        this.descriptionCompany = descriptionCompany;
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public Moderator getModerator() {
        return moderator;
    }

    public void setModerator(Moderator moderators) {
        this.moderator = moderators;
    }

    public void setIndexOfWorker(int indexOfWorker) {
        this.indexOfWorker = indexOfWorker;
    }

    public int getIndexOfWorker() {
        return indexOfWorker;
    }
}
