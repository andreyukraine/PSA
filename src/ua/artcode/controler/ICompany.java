package ua.artcode.controler;

import ua.artcode.model.Company;

import java.util.List;

/**
 * Created by ladapodborska on 9/5/16.
 */
public interface ICompany {

    Company addCompany(Company company);

    Company removeCompany(long companyId);

    Company editCompany(long companyId, String newNameCompany, String newDescriptionCompany);

    List<Company> getAllCompanies();
}
