package ua.artcode.controler;

import ua.artcode.model.Client;
import ua.artcode.model.Company;
import ua.artcode.model.Location;
import ua.artcode.model.Service;
import ua.artcode.utils.Constants;

import java.util.List;
import java.util.Map;

/**
 * Created by ladapodborska on 9/5/16.
 */
public interface ICompany {

    //add company to app
    Company addCompany(String nameCompany, String descriptionCompany, Client client, Location location, Service service);

    //remove company from app
    Company removeCompany(long companyId);

    //посмотреть все компании
    Map<String, Company> listAllCompany();












    //edit information about company
    Company editCompany(long companyId, String newNameCompany, String newDescriptionCompany);

    //print list of all companies
    List<Company> getAllCompanies();

    //find company by id
    Company findCompany(long companyId);

    //change status company id
   Company changeStatusCompany(String companyName, Constants.StatusCompany status);


}
