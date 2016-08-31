package ua.artcode.utils;

import ua.artcode.model.Company;
import ua.artcode.model.ModeratorPSA;
import ua.artcode.model.Service;

import java.util.ArrayList;

/**
 * Created by IT on 29.08.2016.
 */
public class Array<A> {



    private ArrayList<A> listCompanies = new ArrayList<A>();
    private ArrayList<A> listWorker = new ArrayList<A>();
    private ArrayList<A> listService = new ArrayList<A>();
    private ArrayList<A> listComments = new ArrayList<A>();
    private ArrayList<A> listModeratorPSA = new ArrayList<A>();


    public boolean add(A type){
        if (type instanceof Company){
            for (int i = 0; i < listCompanies.size(); i++) {
                if (listCompanies.get(i) == null) {
                    listCompanies.add(i,(A) type);
                    return true;
                }
            }
        }
        if (type instanceof ModeratorPSA){
            for (int i = 0; i < listModeratorPSA.size() ; i++) {
                if (listModeratorPSA.get(i) == null){
                    listModeratorPSA.add(i, (A) type);
                }
            }

        }
        //так далле взависимости от входящих параметров
        return false;
    }

    public boolean edit(A type){
        if (type instanceof Service){
            for (int i = 0; i < listService.size(); i++) {
                if (listService.get(i) == type){
                    listService.add(type);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<A> getListModeratorPSA() {
        return listModeratorPSA;
    }

    public void setListModeratorPSA(ArrayList<A> listModeratorPSA) {
        this.listModeratorPSA = listModeratorPSA;
    }

    public ArrayList<A> getListCompanies() {
        return listCompanies;
    }

    public void setListCompanies(ArrayList<A> listCompanies) {
        this.listCompanies = listCompanies;
    }

    public ArrayList<A> getListWorker() {
        return listWorker;
    }

    public void setListWorker(ArrayList<A> listWorker) {
        this.listWorker = listWorker;
    }

    public ArrayList<A> getListService() {
        return listService;
    }

    public void setListService(ArrayList<A> listService) {
        this.listService = listService;
    }

    public ArrayList<A> getListComments() {
        return listComments;
    }

    public void setListComments(ArrayList<A> listComments) {
        this.listComments = listComments;
    }

}
