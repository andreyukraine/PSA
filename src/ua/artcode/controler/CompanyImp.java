package ua.artcode.controler;

import ua.artcode.db.AppDBImpl;
import ua.artcode.model.Client;
import ua.artcode.model.Company;
import ua.artcode.model.Location;
import ua.artcode.model.Service;
import ua.artcode.utils.Constants;
import ua.artcode.utils.DBFileHandler;

import java.util.List;

/**
 * Created by ladapodborska on 9/5/16.
 */
public class CompanyImp implements ICompany {

    private AppDBImpl appDB;
    private DBFileHandler dbFileHandler;

    public CompanyImp() {
    }

    public CompanyImp(AppDBImpl appDB, DBFileHandler dbFileHandler) {
        this.appDB = appDB;
        this.dbFileHandler = dbFileHandler;
    }

    @Override
    public Company changeStatusCompany(long companyId, Constants.statusCompany status) {
        for (int i = 0; i < appDB.getListCompanies().size(); i++) {
            if (appDB.getListCompanies().get(i).getId() == companyId) {
                appDB.getListCompanies().get(i).setChangeStatusCompany(status);
                return appDB.getListCompanies().get(i);
            }
        }
        return null;
    }

    @Override
    public Company addCompany(String nameCompany, String descriptionCompany, Client client, Location location, List<Service> service) {
        Company company = new Company(nameCompany, descriptionCompany, client, location, service);
        return appDB.addCompany(company);
    }

    @Override
    public Company removeCompany(long companyId) {
        return  appDB.removeCompany(companyId);
    }


    @Override
    public List<Company> listAllCompany() {
        return appDB.getListCompanies();
    }









    @Override
    public Company editCompany(long companyId, String newNameCompany, String newDescriptionCompany) {
        return null;
    }

    @Override
    public List<Company> getAllCompanies() {
        return null;
    }

    @Override
    public Company findCompany(long companyId) {
        return null;
    }
}
