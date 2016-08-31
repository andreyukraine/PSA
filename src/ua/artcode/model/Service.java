package ua.artcode.model;

import java.util.Arrays;

/**
 * Created by serhii on 21.08.16.
 */
public class Service {

    private long id;
    private String nameService;
    private String descriptionService;
    private Worker[] workers;
    private Comment[] commentsService;
    private Rate rateService;

    // constructors --------------------------------------------------------------------------------

    public Service(String nameService, String descriptionService) {
        this.nameService = nameService;
        this.descriptionService = descriptionService;
    }

    public Service() {
    }

    // geters & seters -----------------------------------------------------------------------------


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getDescriptionService() {
        return descriptionService;
    }

    public void setDescriptionService(String descriptionService) {
        this.descriptionService = descriptionService;
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }

    public Comment[] getCommentsService() {
        return commentsService;
    }

    public void setCommentsService(Comment[] commentsService) {
        this.commentsService = commentsService;
    }

    public Rate getRateService() {
        return rateService;
    }

    public void setRateService(Rate rateService) {
        this.rateService = rateService;
    }
    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", nameService='" + nameService + '\'' +
                ", descriptionService='" + descriptionService + '\'' +
                ", workers=" + Arrays.toString(workers) +
                ", commentsService=" + Arrays.toString(commentsService) +
                ", rateService=" + rateService +
                '}';
    }
}
