package ua.artcode.controler;

import ua.artcode.model.Company;

import java.util.List;

/**
 * Created by ladapodborska on 9/5/16.
 */
public interface ICompany {

    //add company to app
    Company addCompany(Company company);

    //remove company from app
    Company removeCompany(long companyId);

    //edit information about company
    Company editCompany(long companyId, String newNameCompany, String newDescriptionCompany);

    //print list of all companies
    List<Company> getAllCompanies();

    //find company by id
    Company findCompany(long companyId);
}
